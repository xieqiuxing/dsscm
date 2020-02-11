var title = null;
var content = null;
var modifyBtn=null;
var backBtn=null;
$(function(){
	title = $("#title");
	content = $("#content");
	modifyBtn=$("#modify");
	backBtn=$("#back");
	//初始化的时候，要把所有的提示信息变为：* 以提示必填项，更灵活，不要写在页面上
	title.next().html("*");
	content.next().html("*");
	
	/*
	 * 验证
	 * 失焦\获焦
	 * jquery的方法传递
	 */

	title.bind("focus",function(){
		validateTip(title.next(),{"color":"#666666"},"* 标题不能为空且长度不小于3",false);
	}).bind("blur",function(){
		if(title.val() != null && title.val().length >2){
			validateTip(title.next(),{"color":"green"},imgYes,true);
		}else{
			validateTip(title.next(),{"color":"red"},imgNo+" 标题输入的不符合规范，请重新输入",false);
		}
	});
	content.bind("focus",function(){
		validateTip(content.next(),{"color":"#666666"},"* 内容不能为空且长度不小于3",false);
	}).bind("blur",function(){
		if(content.val() != null && content.val().length>2){
			validateTip(content.next(),{"color":"green"},imgYes,true);
		}else{
			validateTip(content.next(),{"color":"red"},imgNo+" 内容输入的不符合规范，请重新输入",false);
		}
	});
	
	modifyBtn.bind("click",function(){
		if(title.attr("validateStatus") != "true"){
			title.blur();
		}else if(content.attr("validateStatus") != "true"){
			content.blur();
		}else{
			if(confirm("是否确认提交数据")){
				$("#newsForm").submit();
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
});