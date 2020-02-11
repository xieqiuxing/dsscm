package cn.dsscm.controller;

import java.io.File;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.dsscm.pojo.Product;
import cn.dsscm.pojo.ProductCategory;
import cn.dsscm.pojo.User;
import cn.dsscm.service.ProductCategoryService;
import cn.dsscm.service.ProductService;
import cn.dsscm.tools.Constants;

import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageInfo;
import com.mysql.jdbc.StringUtils;

@Controller
@RequestMapping("/sys/product")
public class ProductController {
	@Resource
	private ProductService productService;
	@Resource
	private ProductCategoryService pcs;
	private Logger logger = Logger.getLogger(LoginController.class);
	@RequestMapping("/list.html")
	public String list(
			Model model,
			@RequestParam(value = "queryname", required = false) String name,
			@RequestParam(value = "categoryLevel1Id", required = false) Integer categoryLevel1Id,
			@RequestParam(value = "pageIndex", required = false) Integer pageNum) {
		Integer pageSize = Constants.pageSize;
		if (pageNum == null) {
			pageNum = 1;
		}
		if (name == null) {
			name = "";
		}
		if (categoryLevel1Id == null) {
			categoryLevel1Id = 0;
		}
		try {
			PageInfo<Product> product = productService.getAll(pageNum,
					pageSize, (long) categoryLevel1Id, name);
			List<ProductCategory> clist = pcs.getRootCategories();
			model.addAttribute("parent", clist);
			model.addAttribute("productlist", product);
			model.addAttribute("categoryLevel1Id", categoryLevel1Id);
			model.addAttribute("name", name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "productlist";
	}

	@RequestMapping("/view/{id}")
	public String view(Model model, @PathVariable Integer id) {
		try {
			Product product = productService.findById((long) id);
			model.addAttribute("product", product);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "productview";
	}

	@RequestMapping(value = "/delproduct.json", method = RequestMethod.GET)
	@ResponseBody
	public Object del(@Param("id") String id) {
		HashMap<String, String> resultMap = new HashMap<String, String>();
		if (StringUtils.isNullOrEmpty(id)) {
			resultMap.put("delResult", "notexist");
		} else {
			long pid = (long) Integer.parseInt(id);
			try {
				if (productService.delete(pid) == 1) {
					resultMap.put("delResult", "true");
				} else {
					resultMap.put("delResult", "false");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return JSONArray.toJSONString(resultMap);
	}

	@RequestMapping("/add.html")
	public String addview(Model model) {
		return "productadd";
	}

	@RequestMapping(value = "/pclist.json", method = RequestMethod.GET)
	@ResponseBody
	public Object getCate(@Param("cid") Integer cid) {
		List<ProductCategory> plist = null;
		try {
			plist = pcs.getProductCategories((long) cid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return JSONArray.toJSONString(plist);
	}

	@RequestMapping("/addsave.html")
	public String addSave(Product product, HttpServletRequest request,
			HttpSession session,
			@RequestParam(value ="attachs", required = false) MultipartFile[] attachs) {
		product.setCreatedBy(((User) session
				.getAttribute(Constants.USER_SESSION)).getId());
		product.setCreationDate(new Date());
		boolean flag = false;
		flag=fileSave(product, request, session, attachs);
		try {
			if (productService.save(product) == 1) {
				flag = true;

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (flag) {
			return "redirect:/sys/product/list.html";
		} else {
			return "add.html";
		}
	}
	@RequestMapping("/modify/{id}")
	public String modifyView(Model model,@PathVariable Integer id){
		try {
			Product product=productService.findById((long)id);
			model.addAttribute("product", product);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "productmodify";
	}
	@RequestMapping("/modifysave.html")
	public String doModify(Product product,HttpServletRequest request,HttpSession session,
							@RequestParam(value="attachs",required=false) MultipartFile[] attachs){
		product.setModifyBy(((User)session.getAttribute(Constants.USER_SESSION)).getId());
		product.setModifyDate(new Date());
		boolean flag=false;
		flag=fileSave(product, request, session, attachs);
		try {
			if(productService.update(product)==1){
				flag=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(flag){
			return "redirect:/sys/product/list.html";
		}
		return "/modify/{id}";
	}
	//文件上传
		public boolean fileSave(Product product,HttpServletRequest request,HttpSession session,MultipartFile[] attachs){
			String idPicPath = null;
			String workPicPath = null;
			String errorInfo = null;
			boolean flag = true;
			String path = request.getSession().getServletContext().getRealPath("statics"+File.separator+"uploadfiles"); 
			logger.info("uploadFile path ============== > "+path);
			for(int i = 0;i < attachs.length ;i++){
				MultipartFile attach = attachs[i];
				if(!attach.isEmpty()){
					if(i == 0){
						errorInfo = "uploadFileError";
					}else if(i == 1){
						errorInfo = "uploadWpError";
		        	}
					String oldFileName = attach.getOriginalFilename();//原文件名
					logger.info("uploadFile oldFileName ============== > "+oldFileName);
					String prefix=FilenameUtils.getExtension(oldFileName);//原文件后缀     
			        logger.debug("uploadFile prefix============> " + prefix);
					int filesize = 500000;
					logger.debug("uploadFile size============> " + attach.getSize());
			        if(attach.getSize() >  filesize){//上传大小不得超过 500k
		            	request.setAttribute(errorInfo, " * 上传大小不得超过 500k");
		            	flag = false;
		            }else if(prefix.equalsIgnoreCase("jpg") || prefix.equalsIgnoreCase("png") 
		            		|| prefix.equalsIgnoreCase("jpeg") || prefix.equalsIgnoreCase("pneg")){//上传图片格式不正确
		            	String fileName = System.currentTimeMillis()+RandomUtils.nextInt(1000000)+"_Personal.jpg";  
		                logger.debug("new fileName======== " + attach.getName());
		                File targetFile = new File(path, fileName);  
		                if(!targetFile.exists()){  
		                    targetFile.mkdirs();  
		                }  
		                //保存  
		                try {  
		                	attach.transferTo(targetFile);  
		                } catch (Exception e) {  
		                    e.printStackTrace();  
		                    request.setAttribute(errorInfo, " * 上传失败！");
		                    flag = false;
		                }  
		                if(i == 0){
		                	 idPicPath = path+File.separator+fileName;
		                	 product.setFileName(idPicPath);
		                }else if(i == 1){
		                	 workPicPath = path+File.separator+fileName;
		                }
		                logger.debug("idPicPath: " + idPicPath);
		                logger.debug("workPicPath: " + workPicPath);
		                
		            }else{
		            	request.setAttribute(errorInfo, " * 上传图片格式不正确");
		            	flag = false;
		            }
				}
			}
			return flag;
		}
}
