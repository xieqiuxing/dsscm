<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/head.jsp"%>
<div class="content">
	<div class="container-fluid">
		<nav class="pull-left">
			<strong>你现在所在的位置是:</strong>&nbsp;&nbsp;&nbsp; <span>供应商管理页面</span><br>
			<br>
		</nav>
	</div>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<div class="card">
					<div class="content">
						<form class="form-inline" method="post"
							action="${pageContext.request.contextPath }/sys/provider/list.html">
							<div class="row">
								<div class="col-md-4">
									<div class="form-group">
										<label>供应商编码：</label> <input type="text" name="queryProCode"
											type="text" value="${queryProCode }"
											class="form-control border-input" >
									</div>
								</div>
								<div class="col-md-4">
									<div class="form-group">
										<label for="queryProName">供应商名称：</label> <input
											name="queryProName" type="text" value="${queryProName}" class="form-control border-input" >
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
											href="${pageContext.request.contextPath }/sys/provider/add.html">添加供应商</a>
									</div>
								</div>
							</div>
							<div class="clearfix"></div>
						</form>
					</div>
					<div class="content table-responsive table-full-width">
						<table class="table table-striped">
							<thead>
								<tr>
									<th width="10%">供应商编码</th>
									<th width="20%">供应商名称</th>
									<th width="10%">联系人</th>
									<th width="12%">联系电话</th>
									<th width="15%">传真</th>
									<th width="10%">创建时间</th>
									<th width="23%">操作</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="provider" items="${providerList.list}"
									varStatus="status">
									<tr>
										<td><span>${provider.proCode }</span>
										</td>
										<td><span>${provider.proName }</span>
										</td>
										<td><span>${provider.proContact}</span>
										</td>
										<td><span>${provider.proPhone}</span>
										</td>
										<td><span>${provider.proFax}</span>
										</td>
										<td><span> <fmt:formatDate
													value="${provider.creationDate}" pattern="yyyy-MM-dd" /> </span>
										</td>
										<td><span><a class="viewProvider btn btn-info btn-xs"
												href="javascript:;" proid=${provider.id}
												proname=${provider.proName}>查看</a> </span> 
												<span><a
												class="modifyProvider  btn btn-warning btn-xs" href="javascript:;"
												proid=${provider.id} proname=${provider.proName }>修改</a> </span> 
												<span><a
												class="deleteProvider btn btn-success btn-xs" href="javascript:;"
												proid=${provider.id} proname=${provider.proName }>删除</a> </span>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<nav class=" pull-right" aria-label="Page navigation">
							<ul class="pagination">
								<li>
									<a href="list.html?pageIndex=1&queryProName=${queryProName}&queryProCode=${queryProCode}" aria-label="Previous"> 
									<span aria-hidden="true">首页</span> </a>
								</li>
								<li><a href="list.html?pageIndex=${providerList.prePage==0?1:providerList.prePage}&queryProName=${queryProName}&queryProCode=${queryProCode}" aria-label="Previous"> <span
										aria-hidden="true">&laquo;</span> </a>
								</li>
								<c:if test="${providerList.pages-5>0}">
									<c:forEach begin="${providerList.pages-providerList.pageNum>=5?providerList.pageNum:providerList.pages-5}" end="${providerList.pageNum<providerList.pages-5?providerList.pageNum+5:providerList.pages}" var="i">
										<li <c:if test="${providerList.pageNum==i}"> class="active"</c:if>>
										<a href="list.html?pageIndex=${i}&queryProName=${queryProName}&queryProCode=${queryProCode}">${i}</a>
										</li>
									</c:forEach>
								</c:if>
								<c:if test="${providerList.pages-5<=0}">
									<c:forEach begin="1" end="${providerList.pages}" var="i">
										<li <c:if test="${providerList.pageNum==i}"> class="active"</c:if>>
										<a href="list.html?pageIndex=${i}&queryProName=${queryProName}&queryProCode=${queryProCode}">${i}</a>
										</li>
									</c:forEach>
								</c:if>
								<li><a href="list.html?pageIndex=${providerList.pageNum==providerList.lastPage?providerList.lastPage:providerList.nextPage}&queryProName=${queryProName}&queryProCode=${queryProCode}" aria-label="Next"> <span
										aria-hidden="true">&raquo;</span> </a>
								</li>
								<li>
									<a href="list.html?pageIndex=${providerList.pages}&queryProName=${queryProName}&queryProCode=${queryProCode}" aria-label="Previous"> 
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

<%@include file="/WEB-INF/jsp/common/foot.jsp"%>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/statics/js/providerlist.js"></script>
