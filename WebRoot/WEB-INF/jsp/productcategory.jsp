<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="common/head.jsp"%>
<div class="content">
	<div class="container-fluid">
		<nav class="pull-left">
			<strong>你现在所在的位置是:</strong>&nbsp;&nbsp;&nbsp; <span>商品分类管理页面</span><br>
			<br>
		</nav>
	</div>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<div class="card">
					<div class="content">
						<form class="form-inline" method="post"
							action="${pageContext.request.contextPath}/sys/productcategory/productcategory.html">
							<div class="row">
								<div class="col-md-3">
									<div class="form-group">
										<label>商品分类名 </label> <input type="text" name="queryname"
											class="form-control border-input" value="${queryname}"
											placeholder="请输入搜索商品分类名......">
									</div>
								</div>
								<div class="col-md-3">
									<div class="form-group">
										<label for="categoryLevel1Id">商品一级类别 &nbsp;&nbsp;</label> <select
											class="form-control border-input" name="categoryLevel1Id"
											id="categoryLevel1Id">
											<option value="">- - - 请选择 - - -</option>
											<c:forEach items="${parent}" var="parent">
												<option value="${parent.id}" <c:if test="${parent.id==categoryLevel1Id}">selected</c:if>>${parent.name}</option>
											</c:forEach>
										</select>
									</div>
								</div>
								<div class="col-md-3">
									<div class="form-group">
										<label for="categoryLevel1Id">商品级别 &nbsp;&nbsp;</label> <select
											class="form-control border-input" name="type" id="type">
											<option value="">- - - 请选择 - - -</option>
											<c:forEach begin="1" end="3" var="i">
												<option value="${i}" <c:if test="${i==type}">selected</c:if>>${i}级</option>
											</c:forEach>
										</select>
									</div>
								</div>
								<input type="hidden" name="pageIndex" value="1" />
								<div class="col-md-2">
									<div class="text-center">
										<button type="submit" class="btn btn-primary btn-fill btn-wd">搜&nbsp;&nbsp;&nbsp;&nbsp;索</button>
									</div>
								</div>
								<div class="col-md-2">
									<div class="text-center">
										<a class="btn btn-danger btn-fill btn-wd" href="${pageContext.request.contextPath}/sys/productcategory/add.html">添加商品分类</a>
									</div>
								</div>
							</div>
							<div class="clearfix"></div>
						</form>
					</div>
					<div class="content table-responsive table-full-width">
						<table class="table table-striped">
							<thead>
								<th width="10%">编码</th>
								<th width="15%">图标</th>
								<th width="10%">名称</th>
								<th width="10%">级别</th>
								<th width="30%">完整分类名称</th>
								<th width="25%">操作</th>
							</thead>
							<tbody>
							<c:forEach items="${plist.list}" var="plist">
								<tr>
									<td><span name="id" value="${plist.id}">${plist.id}</span></td>
									<td><span>${plist.iconClass}</span></td>
									<td><span>${plist.name}</span></td>
									<td><span>${plist.type}</span></td>
									<td><span>${plist.pc1Name} -${plist.pc2Name} - ${plist.pc3Name}</span></td>
									<td></span>&nbsp;&nbsp; <span><a
											class="delete btn btn-success btn-xs" href="javascript:;"
											pid=${plist.id} pname=${plist.name}>删除</a> </span></td>
								</tr>
							</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
				<nav class=" pull-right" aria-label="Page navigation">
					<ul class="pagination">
						<li><a
							href="productcategory.html?pageIndex=1&queryname=${queryname}&categoryLevel1Id=${categoryLevel1Id}&type=${type}"
							aria-label="Previous"> <span aria-hidden="true">首页</span> </a>
						</li>
						<li><a
							href="productcategory.html?pageIndex=${plist.prePage==0?1:plist.prePage}&queryname=${queryname}&categoryLevel1Id=${categoryLevel1Id}&type=${type}"
							aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
						</a>
						</li>
						<c:if test="${plist.pages-5>0}">
							<c:forEach
								begin="${plist.pages-plist.pageNum>=5?plist.pageNum:plist.pages-5}"
								end="${plist.pageNum<plist.pages-5?plist.pageNum+5:plist.pages}"
								var="i">
								<li <c:if test="${plist.pageNum==i}">class="active"</c:if>>
									<a
									href="productcategory.html?pageIndex=${i}&queryname=${queryname}&categoryLevel1Id=${categoryLevel1Id}&type=${type}">${i}</a>
								</li>
							</c:forEach>
						</c:if>
						<c:if test="${plist.pages-5<=0}">
							<c:forEach begin="1" end="${plist.pages}" var="i">
								<li <c:if test="${plist.pageNum==i}">class="active"</c:if>>
									<a
									href="productcategory.html?pageIndex=${i}&queryname=${queryname}&categoryLevel1Id=${categoryLevel1Id}&type=${type}">${i}</a>
								</li>
							</c:forEach>
						</c:if>
						<li><a
							href="productcategory.html?pageIndex=${plist.pageNum==plist.lastPage?plist.lastPage:plist.nextPage}&queryname=${queryname}&categoryLevel1Id=${categoryLevel1Id}&type=${type}"
							aria-label="Next"> <span aria-hidden="true">&raquo;</span> </a>
						</li>
						<li><a
							href="productcategory.html?pageIndex=${plist.pages}&queryname=${queryname}&categoryLevel1Id=${categoryLevel1Id}&type=${type}"
							aria-label="Previous"> <span aria-hidden="true">末页</span> </a>
						</li>
					</ul>
				</nav>
			</div>
		</div>
	</div>
</div>

<%@ include file="common/foot.jsp"%>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/statics/js/productcategory.js"></script>