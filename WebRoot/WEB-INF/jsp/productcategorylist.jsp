<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="common/head.jsp"%>
<div class="content">
	<div class="container-fluid">
		<nav class="pull-left">
		<strong>你现在所在的位置是:</strong>&nbsp;&nbsp;&nbsp;
		<span>商品分类管理页面</span>
		<br>
		<br>
		</nav>
		<div class="col-md-2">
				<div class="text-right ">
					<a class="btn btn-danger btn-fill btn-wd"
						href="${pageContext.request.contextPath}/sys/productcategory/productcategory.html">管理商品分类</a>
				</div>
				<br>
			</div>
			<div class="col-md-2">
				<div class="text-center">
					<a class="btn btn-danger btn-fill btn-wd" href="${pageContext.request.contextPath}/sys/productcategory/add.html">添加商品分类</a>
				</div>
			</div>
			<div class="col-md-2">
				<div class="text-center ">
					<a class="btn btn-success btn-fill btn-wd"
						href="javascript:history.go(-1)">返回</a>
				</div>
				<br>
			</div>
		
	</div>
	<div class="container-fluid">
		
		<div class="row">
			<!-- Nav tabs -->
			<ul class="nav nav-tabs" role="tablist">
				<c:forEach items="${ppclist}" var="pc1">
					<li role="presentation" <c:if test="${pc1.id==1}"> class="active"</c:if>  >
						<a href="#ppc${pc1.id}" aria-controls="ppc${pc1.id}" role="tab"
							data-toggle="tab">${pc1.name}</a>
					</li>
				</c:forEach>
			</ul>

			<!-- Tab panes -->
			<div class="tab-content" id="ppclist">
				<c:forEach items="${ppclist}" var="p1">
					<div role="tabpanel" class="tab-pane content" id="ppc${p1.id}">
						<div class="row">
							<c:forEach items="${p1.productCategories}" var="p2">
								<div class="col-xs-6 col-md-3">
									<div class="list-group">
										<a href="#${p2.id}" class="list-group-item active">
											${p2.id} | ${p2.name}</a>
										<c:forEach items="${p2.productCategories}" var="p3">
											<a class="list-group-item" href="#${p3.id}"> ${p3.id} |
												${p3.name}</a>
										</c:forEach>
									</div>
								</div>
							</c:forEach>
						</div>
					</div>
				</c:forEach>

			</div>


		</div>
	</div>
</div>

<%@ include file="common/foot.jsp"%>
<script type="text/javascript">
	$(".sidebar-wrapper .nav li:eq(1)").addClass("active");
	$("#ppclist div:eq(0)").addClass("active");
</script>
