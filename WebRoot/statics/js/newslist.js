var newsObj;

//用户管理页面上点击删除按钮弹出删除框(newslist.jsp)
function deletenews(obj){
	$.ajax({
		type:"GET",
		url:path+"/sys/news/delnews.json",
		data:{id:obj.attr("newsid")},
		dataType:"json",
		success:function(data){
			if(data.delResult == "true"){//删除成功：移除删除行
				cancleBtn();
				obj.parents("tr").remove();
			}else if(data.delResult == "false"){//删除失败
				alert("对不起，删除用户【"+obj.attr("newsname")+"】失败");
			}else if(data.delResult == "notexist"){
				alert("对不起，新闻【"+obj.attr("newsname")+"】不存在");
			}
		},
		error:function(data){
			//alert("对不起，删除失败");
			changeDLGContent("对不起，删除失败");
		}
	});
}

function openYesOrNoDLG(){
	$('.zhezhao').css('display', 'block');
	$('#removeUse').fadeIn();
}

function cancleBtn(){
	$('.zhezhao').css('display', 'none');
	$('#removeUse').fadeOut();
}
function changeDLGContent(contentStr){
	var p = $(".removeMain").find("p");
	p.html(contentStr);
}

$(function(){
	//通过jquery的class选择器（数组）
	//对每个class为viewnews的元素进行动作绑定（click）
	$(".viewnews").on("click",function(){
		//将被绑定的元素（a）转换成jquery对象，可以使用jquery方法
		var obj = $(this);
		window.location.href=path+"/sys/news/view/"+ obj.attr("newsid");
	});
	
	$(".modifynews").on("click",function(){
		var obj = $(this);
		window.location.href=path+"/sys/news/modify/"+ obj.attr("newsid");
	});

	$('#no').click(function () {
		cancleBtn();
	});
	
	$('#yes').click(function () {
		deletenews(newsObj);
	});

	$(".deletenews").on("click",function(){
		newsObj = $(this);
		var del = confirm("你确定要删除新闻【"+newsObj.attr("newsname")+"】吗？");
		if (del)  {
			deletenews(newsObj);
	    } else {
	       alert("你取消删除！");
	    }
	});
	
});