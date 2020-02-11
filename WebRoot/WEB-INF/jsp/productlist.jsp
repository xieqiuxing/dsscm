<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="common/head.jsp"%>
<div class="content">
	<div class="container-fluid">
		<nav class="pull-left">
			<strong>你现在所在的位置是:</strong>&nbsp;&nbsp;&nbsp; <span>用户管理页面</span><br>
			<br>
		</nav>
	</div>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<div class="card">
					<div class="content">
					<form class="form-inline" method="post"
							action="${pageContext.request.contextPath}/sys/product/list.html">
							<div class="row">
								<div class="col-md-3">
									<div class="form-group">
										<label>商品名 </label> <input type="text" name="queryname"
											class="form-control border-input" value="${name}"
											placeholder="请输入搜索商品名......">
									</div>
								</div>
								<div class="col-md-3">
									<div class="form-group">
										<label for="categoryLevel1Id">商品类别 &nbsp;&nbsp;</label> 
										<select class="form-control border-input" name="categoryLevel1Id"
											id="categoryLevel1Id">
											<option value="0">- - - 请选择 - - -</option>
											<c:forEach items="${parent}" var="parents">
												<option value="${parents.id}" ${parents.id==categoryLevel1Id?selected:0}>${parents.name} </option>
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
										<a class="btn btn-danger btn-fill btn-wd"
											href="${pageContext.request.contextPath}/sys/product/add.html">添加商品</a>
									</div>
								</div>
								<div class="col-md-2">
									<div class="text-center">
										<a class="btn btn-danger btn-fill btn-wd"
											href="${pageContext.request.contextPath}/sys/productcategory/productcategorylist.html">管理商品分类</a>
									</div>
								</div>
							</div>
							<div class="clearfix"></div>
						</form>

					</div>
					<div class="content table-responsive table-full-width">
						<table class="table table-striped" style="word-break: break-all;word-wrap: break-word;">
							<thead>
								<th width="10%">商品编码</th>
								<th width="15%">商品名称</th>
								<th width="8%">单价</th>
								<th width="8%">摆放位置</th>
								<th width="8%">数量</th>
								<th width="12%">一级分类名称</th>
								<th width="12%">二级分类名称</th>
								<th width="12%">三级分类名称</th>
								<th width="25%">操作</th>
							</thead>
							<tbody>
								<c:forEach var="product" items="${productlist.list}" varStatus="status">
									<tr>
										<td ><span name="id" value="${product.id }">${product.id }</span>
										</td>
										<td><span>${product.name}</span>
										</td>
										<td><span>${product.price }</span>
										</td>
										<td><span>${product.placement}</span>
										</td>
										<td><span>${product.stock }</span>
										</td>
										<td><span>${product.p1Name}</span>
										</td>
										<td><span>${product.p2Name }</span>
										</td>
										<td><span>${product.p3Name}</span>
										<td><span>
												<a class="viewproduct btn btn-info btn-xs"href="javascript:;" productid=${product.id}  >查看</a>
											</span>&nbsp;&nbsp; 
											<span><a class="modifyproduct btn btn-warning btn-xs"
												href="javascript:;" productid=${product.id} pname=${product.name} href="newsmodify.html">编辑</a></span>&nbsp;&nbsp;
											<span><a class="deleteproduct btn btn-success btn-xs"
												href="javascript:;" pname=${product.name} productid=${product.id}>删除</a></span></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<nav class=" pull-right" aria-label="Page navigation">
							<ul class="pagination">
								<li>
									<a href="list.html?pageIndex=1&queryname=${name}&categoryLevel1Id=${categoryLevel1Id}" aria-label="Previous"> 
									<span aria-hidden="true">首页</span> </a>
								</li>
								<li><a href="list.html?pageIndex=${productlist.prePage==0?1:productlist.prePage}&queryname=${name}&categoryLevel1Id=${categoryLevel1Id}" aria-label="Previous"> <span aria-hidden="true">&laquo;</span> </a>
								</li>
								<c:if test="${productlist.pages-5>0}">
									<c:forEach begin="${productlist.pages-productlist.pageNum>=5?productlist.pageNum:productlist.pages-5}" end="${productlist.pageNum<productlist.pages-5?productlist.pageNum+5:productlist.pages}" var="i">
										<li <c:if test="${productlist.pageNum==i}">class="active"</c:if>>
										<a href="list.html?pageIndex=${i}&queryname=${name}&categoryLevel1Id=${categoryLevel1Id}">${i}</a>
										</li>
									</c:forEach>
								</c:if>
								<c:if test="${productlist.pages-5<=0}">
									<c:forEach begin="1" end="${productlist.pages}" var="i">
										<li <c:if test="${productlist.pageNum==i}">class="active"</c:if>>
										<a href="list.html?pageIndex=${i}&queryname=${name}&categoryLevel1Id=${categoryLevel1Id}">${i}</a>
										</li>
									</c:forEach>
								</c:if>
								<li><a href="list.html?pageIndex=${productlist.pageNum==productlist.lastPage?productlist.lastPage:productlist.nextPage}&queryname=${name}&categoryLevel1Id=${categoryLevel1Id}" aria-label="Next"> <span
										aria-hidden="true">&raquo;</span> </a>
								</li>
								<li>
									<a href="list.html?pageIndex=${productlist.pages}&queryname=${name}&categoryLevel1Id=${categoryLevel1Id}" aria-label="Previous"> 
									<span aria-hidden="true">末页</span> </a>
								</li>
							</ul>
						</nav>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<%@ include file="common/foot.jsp"%>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/statics/js/productlist.js"></script>