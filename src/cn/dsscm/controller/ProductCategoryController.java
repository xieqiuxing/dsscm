package cn.dsscm.controller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.dsscm.pojo.ProductCategory;
import cn.dsscm.service.ProductCategoryService;
import cn.dsscm.tools.Constants;

import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageInfo;
import com.mysql.jdbc.StringUtils;

@Controller
@RequestMapping("/sys/productcategory")
public class ProductCategoryController {
	@Resource
	private ProductCategoryService psc;
	
	@RequestMapping("/productcategory.html")
	public String list(
			Model model,
			@RequestParam(value = "queryname", required = false) String queryname,
			@RequestParam(value = "categoryLevel1Id", required = false) Integer categoryLevel1Id,
			@RequestParam(value = "type", required = false) Integer type,
			@RequestParam(value = "pageIndex", required = false) Integer pageNum) {
		if (queryname == null) {
			queryname = "";
		}
		if (pageNum == null) {
			pageNum = 1;
		}
		int pageSize = Constants.pageSize;
		List<ProductCategory> list = null;
		PageInfo<ProductCategory> plist = null;
		try {
			list = psc.getRootCategories();
			plist = psc.findAll(pageNum, pageSize, queryname, categoryLevel1Id,
					type);
			model.addAttribute("plist", plist);
			model.addAttribute("queryname", queryname);
			model.addAttribute("categoryLevel1Id", categoryLevel1Id);
			model.addAttribute("type", type);
			model.addAttribute("parent", list);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "productcategory";
	}
	
	@RequestMapping("/productcategorylist.html")
	public String getAll(Model model){
		try {
			List<ProductCategory> plist=psc.findProductCategorys();
			System.out.println(plist);
			model.addAttribute("ppclist", plist);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "productcategorylist";
	}
	
	@RequestMapping(value = "/delproduct.json", method = RequestMethod.GET)
	@ResponseBody
	public Object delProduct(@RequestParam(value = "id") String pid) {
		HashMap<String, String> resultMap = new HashMap<String, String>();
		if (StringUtils.isNullOrEmpty(pid)) {
			resultMap.put("delResult", "notexist");
		}
		int result = -1;

		try {
			result = psc.delete((long) Integer.parseInt(pid));
			System.out.println(result);
			if (result > 0) {
				resultMap.put("delResult", "true");
			} else {
				resultMap.put("delResult", "false");
			}

		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return JSONArray.toJSONString(resultMap);
	}

	@RequestMapping("/add.html")
	public String addView() {
		return "categoryadd";
	}

	@RequestMapping(value = "/pclist.json", method = RequestMethod.GET)
	@ResponseBody
	public Object getCate(@Param("cid") Integer cid) {
		List<ProductCategory> plist = null;
		try {
			plist = psc.getProductCategories((long) cid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return JSONArray.toJSONString(plist);
	}

	@RequestMapping(value = "/ucexist.json", method = RequestMethod.GET)
	@ResponseBody
	public Object ifExist(@Param("name") String name) {
		HashMap<String, String> resultMap = new HashMap<String, String>();
		int result=-1;
		try {
			result = psc.findcount(name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (StringUtils.isNullOrEmpty(name)) {
			resultMap.put("result", "notexist");
		} else {
			if (result >= 1) {
				resultMap.put("result", "true");
			} else {
				resultMap.put("result", "false");
			}
		}
		return JSONArray.toJSONString(resultMap);
	}

	@RequestMapping("/addc1.html")
	public String add1(@RequestParam("p1name") String name) {
		ProductCategory pc=new ProductCategory();
		int parentId=0;
		int result=-1;
		try {
			result = psc.findCountById(parentId);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		long id=1;
		if(result>0){
			try {
				id=psc.findMaxId(parentId)+1;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		pc.setId(id);
		pc.setName(name);
		pc.setParentId((long)parentId);
		pc.setType(1);
		int i=-1;
		try {
			i=psc.save(pc);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(i==1){
			return "redirect:/sys/productcategory/productcategorylist.html";
		}else{
			return "categoryadd";
		}
		
	}

	@RequestMapping("/addc2.html")
	public String add2(@RequestParam("p2name") String name,@RequestParam("categoryLevel1Id") Integer c1Id) {
		ProductCategory pc=new ProductCategory();
		int result=-1;
		try {
			result = psc.findCountById(c1Id);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String cid=c1Id+"01";
		long id=(long)Integer.parseInt(cid);
		pc.setName(name);
		pc.setParentId((long)c1Id);
		pc.setType(2);
		if(result>0){
			try {
				id=psc.findMaxId(c1Id)+1;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		pc.setId(id);
		int i=-1;
		try {
			i=psc.save(pc);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(i==1){
			return "redirect:/sys/productcategory/productcategorylist.html";
		}else{
			return "categoryadd";
		}
	}

	@RequestMapping("/addc3.html")
	public String add3(@RequestParam("p3name") String name,@RequestParam("categoryLevel2Id") Integer c2Id) {
		ProductCategory pc=new ProductCategory();
		int result=-1;
		try {
			result = psc.findCountById(c2Id);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String cid=c2Id+"01";
		long id=(long)Integer.parseInt(cid);
		pc.setName(name);
		pc.setParentId((long)c2Id);
		pc.setType(3);
		if(result>0){
			try {
				id=psc.findMaxId(c2Id)+1;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		pc.setId(id);
		int i=-1;
		try {
			i=psc.save(pc);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(i==1){
			return "redirect:/sys/productcategory/productcategorylist.html";
		}else{
			return "categoryadd";
		}
	}
}
