package cn.dsscm.controller;

import java.io.File;
import java.util.Date;
import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.dsscm.pojo.Provider;
import cn.dsscm.pojo.User;
import cn.dsscm.service.ProviderService;
import cn.dsscm.tools.Constants;

import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageInfo;
import com.mysql.jdbc.StringUtils;

@Controller
@RequestMapping("/sys/provider")
public class ProviderController {
	private Logger logger = Logger.getLogger(LoginController.class);
	@Resource
	private ProviderService providerService;
	@RequestMapping("/list.html")
	public String getList(Model model,
						  @RequestParam(value="queryProCode",required=false)String queryProCode,
						  @RequestParam(value="queryProName",required=false)String queryProName,
						  @RequestParam(value = "pageIndex", required = false) Integer pageIndex){
		if(queryProCode==null){
			queryProCode="";
		}
		if(queryProName==null){
			queryProName="";
		}
		int pageSize=Constants.pageSize;
		if(pageIndex==null){
			pageIndex=1;
		}
		try {
			PageInfo<Provider> list= providerService.getProviderList(pageIndex, pageSize, queryProName, queryProCode);
			model.addAttribute("providerList", list);
			model.addAttribute("queryProCode", queryProCode);
			model.addAttribute("queryProName", queryProName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "providerlist";
	}
	@RequestMapping(value="/add.html",method=RequestMethod.GET)
	public String addPro(){
		return "provideradd";
	}
	@RequestMapping("/addsave.html")
	public String doadd(Provider provider,HttpSession session,HttpServletRequest request,
			 @RequestParam(value ="attachs", required = false) MultipartFile[] attachs){
		boolean flag=true;
		flag= fileSave(provider, request, session, attachs);
		if(flag){
			provider.setCreatedBy(((User) session.getAttribute(Constants.USER_SESSION)).getId());;
			provider.setCreationDate(new Date());
			try {
				if(providerService.add(provider)==1){
					return "redirect:/sys/provider/list.html";
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "add.html";
	}
	
	@RequestMapping(value="/view/{id}",method=RequestMethod.GET)
	public String view(@PathVariable Integer id,Model model,HttpServletRequest request){
		logger.debug("view id===================== "+id);
		Provider provider=new Provider();
		try {
			provider=providerService.getProviderById(id);
			if(provider.getCompanyLicPicPath() != null && !"".equals(provider.getCompanyLicPicPath())){
				String[] paths = provider.getCompanyLicPicPath().split("\\"+File.separator);
				logger.debug("view picPath paths[paths.length-1]============ " + paths[paths.length-1]);
				provider.setCompanyLicPicPath(request.getContextPath()+"/statics/uploadfiles/"+paths[paths.length-1]);
			}
			if(provider.getOrgCodePicPath()!=null && !"".equals(provider.getOrgCodePicPath())){
				String[] paths = provider.getOrgCodePicPath().split("\\"+File.separator);
				logger.debug("view picPath paths[paths.length-1]============ " + paths[paths.length-1]);
				provider.setOrgCodePicPath(request.getContextPath()+"/statics/uploadfiles/"+paths[paths.length-1]);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("provider", provider);
		return "providerview";
	}
	
	@RequestMapping("/modify/{id}")
	public String modify(Model model,@PathVariable Integer id){
		try {
			Provider provider=providerService.getProviderById(id);
			model.addAttribute("provider", provider);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "providermodify";
	}
	
	@RequestMapping("/modifysave.html")
	public String doModify(Provider provider,Model model,HttpServletRequest request,HttpSession session, 
			@RequestParam(value ="attachs", required = false) MultipartFile[] attachs){
			boolean flag=true;
			flag=fileSave(provider, request, session, attachs);
			if(flag){
				provider.setModifyBy(((User)session.getAttribute(Constants.USER_SESSION)).getId());
				provider.setModifyDate(new Date());
				try {
					if(providerService.modify(provider)==1){
						return "redirect:/sys/provider/list.html";
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		return "providermodify";
	}
	
	@RequestMapping(value="/del.json",method=RequestMethod.GET)
	@ResponseBody
	public Object del(@RequestParam String id){
		HashMap<String, String> resultMap=new HashMap<String, String>();
		if(StringUtils.isNullOrEmpty(id)){
			resultMap.put("delResult", "notexist");
		}else{
			try {
				if(providerService.deleteProviderById(Integer.parseInt(id))==1){
					resultMap.put("delResult", "true");
				}else{
					resultMap.put("delResult", "false");
				}
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return JSONArray.toJSONString(resultMap);
	}
	//文件上传
	public boolean fileSave(Provider provider,HttpServletRequest request,HttpSession session,MultipartFile[] attachs){
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
	                	 provider.setCompanyLicPicPath(idPicPath);
	                }else if(i == 1){
	                	 workPicPath = path+File.separator+fileName;
	                	 provider.setOrgCodePicPath(workPicPath);
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
