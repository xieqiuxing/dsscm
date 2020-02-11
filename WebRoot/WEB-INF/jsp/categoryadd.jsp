<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/head.jsp"%>
<div class="content">
	<div class="container-fluid">
		<nav class="pull-left">
			<strong>你现在所在的位置是:</strong>&nbsp;&nbsp;&nbsp; <span>分类管理页面 >> 类别添加页面</span><br> <br>
		</nav>
	</div>
	<div class="container-fluid">
		<div class="content">
			<div class="container-fluid">
				<div class="row">
					<div class="header">
						<h4 class="title">添加一级类</h4>
					</div>
					<div class="content">
						 <form name="p1form" id="p1form" action="${pageContext.request.contextPath }/sys/productcategory/addc1.html" method="post">
						 	<div class="col-md-4">
								<div class="form-group">
									<label>一级类</label>
									<input type="text" class="form-control border-input" placeholder="请输入一级类" name="p1name" id="p1name"/>
									<font color="red"></font>
								</div>
							</div>
							<div class="col-md-4">
	   							<div class="text-center" style="margin-top:22px;">
									<button type="button" id="add" class="btn btn-info btn-fill btn-wd">新 增 分 类</button>
									<button type="button" id="back" class="btn btn-info btn-fill btn-wd">返回</button>
								</div>
							</div>
  				 		</form>
					</div>
				</div>
				<div class="row">
					<div class="header">
						<h4 class="title">添加二级类</h4>
					</div>
					<div class="content">
						<form name="p2form" id="p2form" action="${pageContext.request.contextPath }/sys/productcategory/addc2.html" method="post">
							<div class="col-md-2">
								<div class="form-group">
									<label>一级类 </label> 
									<select name="categoryLevel1Id" id="categoryLevel1Id"
											class="form-control border-input">
									</select> 
									<font color="red"></font>
								</div>
							</div>
						 	<div class="col-md-4">
								<div class="form-group">
									<label>二级类 </label>
									<input type="text" class="form-control border-input" placeholder="请输入二级类" name="p2name" id="p2name"/>
									<font color="red"></font>
								</div>
							</div>
							<div class="col-md-4">
	   							<div class="text-center" style="margin-top:22px;">
									<button type="button" id="add2" class="btn btn-info btn-fill btn-wd">新 增 分 类</button>
									<button type="button" id="back2" class="btn btn-info btn-fill btn-wd">返回</button>
								</div>
							</div>
  				 		</form>
					</div>
				</div>
				<div class="row">
					<div class="header">
						<h4 class="title">添加三级类</h4>
					</div>
					<div class="content">
						<form name="p3form" id="p3form" action="${pageContext.request.contextPath }/sys/productcategory/addc3.html" method="post">
							<div class="col-md-2">
								<div class="form-group">
									<label>一级类 </label> 
									<select name="cl1Id" id="cl1Id"
											class="form-control border-input">
									</select> 
									<font color="red"></font>
								</div>
							</div>
							<div class="col-md-2">
								<div class="form-group">
									<label>二级类 </label> 
									<select name="categoryLevel2Id" id="categoryLevel2Id"
											class="form-control border-input">
									</select> 
									<font color="red"></font>
								</div>
							</div>
						 	<div class="col-md-4">
								<div class="form-group">
									<label>三级类 </label>
									<input type="text" class="form-control border-input" placeholder="请输入三级类" name="p3name" id="p3name"/>
									<font color="red"></font>
								</div>
							</div>
							<div class="col-md-4">
	   							<div class="text-center" style="margin-top:22px;">
									<button type="button" id="add3" class="btn btn-info btn-fill btn-wd">新 增 分 类</button>
									<button type="button" id="back3" class="btn btn-info btn-fill btn-wd">返回</button>
								</div>
							</div>
  				 		</form>
					</div>
				</div>
			</div>
		</div>
	</div>			
 </div>
 <%@include file="/WEB-INF/jsp/common/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/categoryadd.js"></script>
