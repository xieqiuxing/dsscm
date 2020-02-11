package cn.dsscm.controller;

import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;

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

import cn.dsscm.pojo.News;
import cn.dsscm.pojo.User;
import cn.dsscm.service.NewsService;
import cn.dsscm.tools.Constants;

import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageInfo;
import com.mysql.jdbc.StringUtils;

@Controller
@RequestMapping("/sys/news")
public class NewsController {
	@Resource
	private NewsService newsService;

	@RequestMapping("/list.html")
	public String getAll(Model model,
			@RequestParam(value = "title", required = false) String title,
			@RequestParam(value = "pageIndex", required = false) Integer pageNum) {
		if (title == null) {
			title = "";
		}
		int pageSize = Constants.pageSize;
		if (pageNum == null) {
			pageNum = 1;
		}
		try {
			PageInfo<News> list = newsService.getAllNews(pageNum, pageSize,
					title);
			model.addAttribute("newsList", list);
			model.addAttribute("title", title);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "newslist";
	}

	@RequestMapping("/add.html")
	public String addview() {
		return "newsadd";
	}

	@RequestMapping("/addsave.html")
	public String addsave(News news, HttpSession session,
			HttpServletRequest request) {
		news.setCreatedBy((long) ((User) session
				.getAttribute(Constants.USER_SESSION)).getId());
		news.setcreationDate(new Date());
		boolean flag = false;
			try {
				int result = newsService.save(news);
				if (result == 1) {
					flag = true;
					
				}else{
					flag=false;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(flag){
				return "redirect:/sys/news/list.html";
			}else{
				return "newsadd";
			}
	}
	@RequestMapping("/view/{id}")
	public String view(Model model,@PathVariable Integer id){
		try {
			News news=newsService.findById(id);
			model.addAttribute("news", news);
			System.out.println(news);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "newsview";
	}
	@RequestMapping(value = "/modify/{id}", method = RequestMethod.GET)
	public String modifyview(Model model,@PathVariable Integer id){
		try {
			News news=newsService.findById(id);
			model.addAttribute("news", news);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "newsmodify";
	}
	@RequestMapping(value="/domodify.html",method=RequestMethod.POST)
	public String doModify(News news,HttpSession session,HttpServletRequest request){
		news.setModifyBy((long)((User)session.getAttribute(Constants.USER_SESSION)).getId());
		news.setModifyDate(new Date());
		int result=-1;
		try {
			result=newsService.update(news);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(result==1){
			return "redirect:/sys/news/list.html";
		}else{
			return "newsmodify";
		}
		
	}
	
	@RequestMapping(value = "/delnews.json", method = RequestMethod.GET)
	@ResponseBody
	public Object deluser(@RequestParam String id) {
		HashMap<String, String> resultMap = new HashMap<String, String>();
		if (StringUtils.isNullOrEmpty(id)) {
			resultMap.put("delResult", "notexist");
		} else {
			try {
				if (newsService.delete((long)Integer.parseInt(id))==1)
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
