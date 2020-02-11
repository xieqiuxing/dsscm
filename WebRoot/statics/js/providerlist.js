var providerObj;

//供应商管理页面上点击删除按钮弹出删除框(providerlist.jsp)
function deleteProvider(obj){
	$.ajax({
		type:"GET",
		url:path+"/sys/provider/del.json",
		data:{id:obj.attr("proid")},
		dataType:"json",
		success:function(data){
			if(data.delResult == "true"){//删除成功：移除删除行
				obj.parents("tr").remove();
			}else if(data.delResult == "false"){//删除失败
				alert("对不起，删除供应商【"+obj.attr("proname")+"】失败");
			}else if(data.delResult == "notexist"){
				alert("对不起，供应商【"+obj.attr("proname")+"】不存在");
			}
		},
		error:function(data){
			alert("对不起，删除失败");
		}
	});
}

$(function(){
	$(".viewProvider").on("click",function(){
		//将被绑定的元素（a）转换成jquery对象，可以使用jquery方法
		var obj = $(this);
		window.location.href=path+"/sys/provider/view/"+ obj.attr("proid");
	});
	
	$(".modifyProvider").on("click",function(){
		var obj = $(this);
		window.location.href=path+"/sys/provider/modify/"+ obj.attr("proid");
	});


	$(".deleteProvider").on("click",function(){
		providerObj = $(this);
		var del = confirm("你确定要删除供应商【"+providerObj.attr("proname")+"】吗？");
		if (del)  {
			deleteProvider(providerObj);
	    } else {
	       alert("你取消删除！");
	    }
	});
	
});