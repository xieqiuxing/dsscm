package cn.dsscm.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.dsscm.pojo.Bill;
import cn.dsscm.pojo.Provider;
import cn.dsscm.pojo.User;
import cn.dsscm.service.BillService;
import cn.dsscm.service.ProviderService;
import cn.dsscm.tools.Constants;

import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageInfo;
import com.mysql.jdbc.StringUtils;

@Controller
@RequestMapping("sys/bill")
public class BillController {
	@Resource
	private BillService billService;
	@Resource
	private ProviderService providerService;
	@RequestMapping("/list.html")
	public String getList(Model model,@RequestParam(value="queryProductName",required=false) String productName,
						 @RequestParam(value="queryProviderId",required=false) Integer providerId,
						 @RequestParam(value="queryIsPayment",required=false)Integer isPayment,
						 @RequestParam(value="pageIndex",required=false)Integer pageNum){
		int pageSize=Constants.pageSize;
		if(productName==null){
			productName="";
		}
		if(pageNum==null){
			pageNum=1;
		}
		try {
			PageInfo<Bill> list= billService.getBillList(pageNum, pageSize, productName, providerId, isPayment);
			List<Provider> plist=providerService.getProList();
			model.addAttribute("providerList", plist);
			model.addAttribute("billlist", list);
			model.addAttribute("productName", productName);
			model.addAttribute("providerId", providerId);
			model.addAttribute("isPayment", isPayment);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "billlist";
	}
	@RequestMapping("/view/{id}")
	public String view(Model model,@PathVariable Integer id){
		try {
			Bill bill=billService.getBillById(id);
			model.addAttribute("bill", bill);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "billview";
	}
	@RequestMapping("/add.html")
	public String addview(Model model){
		try {
			List<Provider> plist=providerService.getProList();
			model.addAttribute("provider", plist);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "billadd";
	}
	@RequestMapping("/addsave.html")
	public String addSave(Bill bill,HttpServletRequest request,HttpSession session){
		bill.setCreatedBy(((User)session.getAttribute(Constants.USER_SESSION)).getId());
		bill.setCreationDate(new Date());
		int result=-1;
		try {
			result=billService.add(bill);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(result==1){
			return "redirect:/sys/bill/list.html";
		}else{
			return "add.html";
		}
	}
	@RequestMapping("/modify/{id}")
	public String modiView(Model model,@PathVariable Integer id){
		try {
			List<Provider> list=providerService.getProList();
			Bill bill=billService.getBillById(id);
			model.addAttribute("bill", bill);
			model.addAttribute("provider", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "billmodify";
	}
	@RequestMapping("/modifysave.html")
	public String modiSave(Model model,Bill bill,HttpSession session,HttpServletRequest request){
		bill.setModifyBy(((User)session.getAttribute(Constants.USER_SESSION)).getId());
		bill.setModifyDate(new Date());
		int result=-1;
		try {
			result=billService.modify(bill);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(result==1){
			return "redirect:/sys/bill/list.html";
		}else{
			return "billmodify";
		}
	}

	@RequestMapping(value = "/delbill.json", method = RequestMethod.GET)
	@ResponseBody
	public Object deluser(@RequestParam String id) {
		HashMap<String, String> resultMap=new HashMap<String, String>();
		if (StringUtils.isNullOrEmpty(id)) {
			resultMap.put("delResult", "notexist");
		} else {
			try {
				if (billService.deleteBillById(Integer.parseInt(id))==1)
					resultMap.put("delResult", "true");
				else
					resultMap.put("delResult", "false");
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return JSONArray.toJSONString(resultMap);
	}
}
