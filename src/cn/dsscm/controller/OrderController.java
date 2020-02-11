package cn.dsscm.controller;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.dsscm.pojo.Order;
import cn.dsscm.service.OrderService;

@Controller
@RequestMapping("/sys/order")
public class OrderController {
	@Resource
	private OrderService orderService;
	@RequestMapping("/list.html")
	public String list(Model model,
					   @RequestParam(value="queryname",required=false)String userName,
					   @RequestParam(value="status",required=false)Integer status,
					   @RequestParam(value="oid",required=false)Integer oid){
		if(userName==null){
			userName="";
		}
		if(status==null){
			status=0;
		}
		String[] statuslist={"请选择","待审核","审核通过","配货","卖家已发货","已收货"};
		try {
			List<Order> olist=orderService.getOrders(userName, status,oid);
			System.out.println(olist);
			model.addAttribute("olist", olist);
			model.addAttribute("queryname", userName);
			model.addAttribute("status", status);
			model.addAttribute("statuslist", statuslist);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "orderlist";
	}
}
