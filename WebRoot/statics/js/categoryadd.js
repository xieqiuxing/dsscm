var cl1 = null;
var cl2 = null;
var cl3 = null;
var addBtn = null;
var backBtn = null;
var addBtn2 = null;
var backBtn2 = null;
var addBtn3 = null;
var backBtn3 = null;
var p1name=null;
var p2name=null;
var p3name=null;
$(function(){
	cl1 = $("#categoryLevel1Id");
	cl2 = $("#categoryLevel2Id");
	cl3 = $("#cl1Id");
	addBtn = $("#add");
	backBtn = $("#back");
	addBtn2 = $("#add2");
	backBtn2 = $("#back2");
	addBtn3 = $("#add3");
	backBtn3 = $("#back3");
	p1name= $("#p1name");
	p2name=$("#p2name");
	p3name=$("#p3name");
	cl1.next().html("*");
	cl2.next().html("*");
	cl3.next().html("*");
	p1name.next().html("*");
	p2name.next().html("*");
	p3name.next().html("*");
	$.ajax({
		type:"get",//请求类型
		url:path+"/sys/productcategory/pclist.json",//请求的url
		data:{cid:"0"},//请求参数
		dataType:"json",//ajax接口（请求url）返回的数据类型
		success:function(data){//data：返回数据（json对象）
			if(data != null){
				cl1.html("");
				var options = "<option value=\"\">请选择</option>";
				for(var i = 0; i < data.length; i++){
					options += "<option value=\""+data[i].id+"\">"+data[i].name+"</option>";
				}
				cl1.html(options);
			}
		},
	});
	$.ajax({
		type:"get",//请求类型
		url:path+"/sys/productcategory/pclist.json",//请求的url
		data:{cid:"0"},//请求参数
		dataType:"json",//ajax接口（请求url）返回的数据类型
		success:function(data){//data：返回数据（json对象）
			if(data != null){
				cl3.html("");
				var options = "<option value=\"\">请选择</option>";
				for(var i = 0; i < data.length; i++){
					options += "<option value=\""+data[i].id+"\">"+data[i].name+"</option>";
				}
				cl3.html(options);
			}
		},
	});
	cl3.change(function(){
		$.ajax({
			type:"get",//请求类型
			url:path+"/sys/productcategory/pclist.json",//请求的url
			data:{cid:cl3.val()},//请求参数
			dataType:"json",//ajax接口（请求url）返回的数据类型
			success:function(data){//data：返回数据（json对象）
				if(data != null){
					cl2.html("");
					var options = "<option value=\"\">请选择</option>";
					for(var i = 0; i < data.length; i++){
						options += "<option value=\""+data[i].id+"\">"+data[i].name+"</option>";
					}
					cl2.html(options);
				}
			},
		});
	});
	/*
	 * 验证
	 * 失焦\获焦
	 * jquery的方法传递
	 */
	p1name.bind("blur",function(){
		//ajax后台验证--userCode是否已存在
		$.ajax({
			type:"GET",//请求类型
			url:path+"/sys/productcategory/ucexist.json",//请求的url
			data:{name:p1name.val()},//请求参数
			dataType:"json",//ajax接口（请求url）返回的数据类型
			success:function(data){//data：返回数据（json对象）
				if(data.result == "false"){//账号已存在，错误提示
					validateTip(p1name.next(),{"color":"green"},imgYes+" 该类别可以使用",true);
				}else{
					validateTip(p1name.next(),{"color":"red"},imgNo+ " 该类别已存在",false);	
				}
			},
			error:function(data){//当访问时候，404，500 等非200的错误状态码
				validateTip(p1name.next(),{"color":"red"},imgNo+" 您访问的页面不存在",false);
			}
		});
	}).on("focus",function(){
		//显示友情提示
		validateTip(p1name.next(),{"color":"#666666"},"*  请输入一级类别名",false);
	}).focus();
	
	p2name.bind("blur",function(){
		//ajax后台验证--userCode是否已存在
		$.ajax({
			type:"GET",//请求类型
			url:path+"/sys/productcategory/ucexist.json",//请求的url
			data:{name:p2name.val()},//请求参数
			dataType:"json",//ajax接口（请求url）返回的数据类型
			success:function(data){//data：返回数据（json对象）
				if(data.result == "false"){//账号已存在，错误提示
					validateTip(p2name.next(),{"color":"green"},imgYes+" 该类别可以使用",true);
				}else {//账号可用，正确提示
					validateTip(p2name.next(),{"color":"red"},imgNo+ " 该类别已存在",false);
				}
			},
			error:function(data){//当访问时候，404，500 等非200的错误状态码
				validateTip(p2name.next(),{"color":"red"},imgNo+" 您访问的页面不存在",false);
			}
		});
	}).on("focus",function(){
		//显示友情提示
		validateTip(p2name.next(),{"color":"#666666"},"* 请输入二级类别名",false);
	}).focus();
	
	p3name.bind("blur",function(){
		//ajax后台验证--userCode是否已存在
		$.ajax({
			type:"GET",//请求类型
			url:path+"/sys/productcategory/ucexist.json",//请求的url
			data:{name:p3name.val()},//请求参数
			dataType:"json",//ajax接口（请求url）返回的数据类型
			success:function(data){//data：返回数据（json对象）
				if(data.result == "false"){//账号已存在，错误提示
					validateTip(p3name.next(),{"color":"green"},imgYes+" 该类别可以使用",true);	
				}else{//账号可用，正确提示
					validateTip(p3name.next(),{"color":"red"},imgNo+ " 该类别已存在",false);
				}
			},
			error:function(data){//当访问时候，404，500 等非200的错误状态码
				validateTip(p3name.next(),{"color":"red"},imgNo+" 您访问的页面不存在",false);
			}
		});
	}).on("focus",function(){
		//显示友情提示
		validateTip(p3name.next(),{"color":"#666666"},"* 请输入三级类别名",false);
	}).focus();
	
	addBtn.bind("click",function(){
		if(p1name.attr("validateStatus") != "true"){
			p1name.blur();
		}else{
			if(confirm("是否确认提交数据")){
				$("#p1form").submit();
			}
		}
		if(p2name.attr("validateStatus") != "true"){
			p2name.blur();
		}else if(cl1.val()==null || cl1.val()==""){
			cl1.next().html("* 一级类不能为空");
		}else{
			if(confirm("是否确认提交数据")){
				$("#p2form").submit();
			}
		}
		if(p3name.attr("validateStatus") != "true"){
			p3name.blur();
		}else if(cl3.val()==null || cl3.val()==""){
			cl3.next().html("* 一级类不能为空");
		}else if(cl2.val()==null || cl2.val()==""){
			cl2.next().html("* 二级类不能为空");
		}
		else{
			if(confirm("是否确认提交数据")){
				$("#p3form").submit();
			}
		}
	});
	
	backBtn.on("click",function(){
		if(referer != undefined 
			&& null != referer 
			&& "" != referer
			&& "null" != referer
			&& referer.length > 4){
		 window.location.href = referer;
		}else{
			history.back(-1);
		}
	});
	
	addBtn2.bind("click",function(){
		if(p2name.attr("validateStatus") != "true"){
			p2name.blur();
		}else if(cl1.val()==null || cl1.val()==""){
			cl1.next().html("* 一级类不能为空");
		}else{
			if(confirm("是否确认提交数据")){
				$("#p2form").submit();
			}
		}
	});
	
	backBtn2.on("click",function(){
		if(referer != undefined 
			&& null != referer 
			&& "" != referer
			&& "null" != referer
			&& referer.length > 4){
		 window.location.href = referer;
		}else{
			history.back(-1);
		}
	});
	
	addBtn3.bind("click",function(){
		if(p3name.attr("validateStatus") != "true"){
			p3name.blur();
		}else if(cl3.val()==null || cl3.val()==""){
			cl3.next().html("* 一级类不能为空");
		}else if(cl2.val()==null || cl2.val()==""){
			cl2.next().html("* 二级类不能为空");
		}
		else{
			if(confirm("是否确认提交数据")){
				$("#p3form").submit();
			}
		}
	});
	
	backBtn3.on("click",function(){
		if(referer != undefined 
			&& null != referer 
			&& "" != referer
			&& "null" != referer
			&& referer.length > 4){
		 window.location.href = referer;
		}else{
			history.back(-1);
		}
	});
});