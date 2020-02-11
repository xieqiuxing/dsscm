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
							action="${pageContext.request.contextPath }/sys/user/list.html">
							<div class="row">
								<div class="col-md-3">
									<div class="form-group">
										<label>用户名 </label> <input type="text" name="queryname"
											class="form-control border-input" value="${queryUserName }"
											placeholder="请输入搜索用户名......">
									</div>
								</div>
								<div class="col-md-3">
									<div class="form-group">
										<label for="queryUserRole">用 户 权 限 &nbsp;&nbsp;</label> <select
											class="form-control border-input" name="queryUserRole">
											<option value="0">- - - 请选择 - - -</option>
											<c:forEach var="role" items="${roleList}">
												<option
													<c:if test="${role.id == queryUserRole }">selected="selected"</c:if>
													name ="queryUserRole" value="${role.id}">${role.roleName}</option>
											</c:forEach>
										</select>
									</div>
								</div>
								<input type="hidden" name="pageIndex" value="1" />
								<div class="col-md-3">
									<div class="text-center">
										<button type="submit" class="btn btn-primary btn-fill btn-wd">搜&nbsp;&nbsp;&nbsp;&nbsp;索</button>
									</div>
								</div>
								<div class="col-md-3">
									<div class="text-center">
										<a class="btn btn-danger btn-fill btn-wd"
											href="${pageContext.request.contextPath}/sys/user/add.html">添加用户</a>
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
									<th width="12%">用户编码</th>
									<th width="13%">用户名称</th>
									<th width="10%">性别</th>
									<th width="10%">年龄</th>
									<th width="15%">电话</th>
									<th width="15%">用户角色</th>
									<th width="25%">操作</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="user" items="${upi.list }" varStatus="status">
									<tr>
										<td><span>${user.userCode }</span>
										</td>
										<td><span>${user.userName }</span>
										</td>
										<td><span> <c:if test="${user.gender==2}">男</c:if>
												<c:if test="${user.gender==1}">女</c:if> </span>
										</td>
										<td><span>${user.age}</span>
										</td>
										<td><span>${user.phone}</span>
										</td>
										<td><span>${user.userRoleName}</span>
										</td>
										<td><span><a class="viewUser btn btn-info btn-xs"
												href="javascript:;" userid=${user.id} username=${user.userName} >查看</a></span>&nbsp;&nbsp; 
											<span><a class="modifyUser btn btn-warning btn-xs"
												href="javascript:;" userid=${user.id} username=${user.userName} href="usermodify.html">编辑</a></span>&nbsp;&nbsp;
											<span><a class="deleteUser btn btn-success btn-xs"
												href="javascript:;" userid=${user.id} username=${user.userName}>删除</a></span></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<nav class=" pull-right" aria-label="Page navigation">
							<ul class="pagination">
								<li>
									<a href="list.html?pageIndex=1&queryname=${queryUserName}&queryUserRole=${queryUserRole}" aria-label="Previous"> 
									<span aria-hidden="true">首页</span> </a>
								</li>
								<li><a href="list.html?pageIndex=${upi.prePage==0?1:upi.prePage}&queryname=${queryUserName}&queryUserRole=${queryUserRole}" aria-label="Previous"> <span
										aria-hidden="true">&laquo;</span> </a>
								</li>
								<c:if test="${upi.pages-5>0}">
									<c:forEach begin="${upi.pages-upi.pageNum>=5?upi.pageNum:upi.pages-5}" end="${upi.pageNum<upi.pages-5?upi.pageNum+5:upi.pages}" var="i">
										<li <c:if test="${upi.pageNum==i}"> class="active"</c:if>>
										<a href="list.html?pageIndex=${i}&queryname=${queryUserName}&queryUserRole=${queryUserRole}">${i}</a>
										</li>
									</c:forEach>
								</c:if>
								<c:if test="${upi.pages-5<0}">
									<c:forEach begin="1" end="${upi.pages}" var="i">
										<li <c:if test="${upi.pageNum==i}"> class="active"</c:if>>
										<a href="list.html?pageIndex=${i}&queryname=${queryUserName}&queryUserRole=${queryUserRole}">${i}</a>
										</li>
									</c:forEach>
								</c:if>
								<li><a href="list.html?pageIndex=${upi.pageNum==upi.lastPage?upi.lastPage:upi.nextPage}&queryname=${queryUserName}&queryUserRole=${queryUserRole}" aria-label="Next"> <span
										aria-hidden="true">&raquo;</span> </a>
								</li>
								<li>
									<a href="list.html?pageIndex=${upi.pages}&queryname=${queryUserName}&queryUserRole=${queryUserRole}" aria-label="Previous"> 
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
	src="${pageContext.request.contextPath }/statics/js/userlist.js"></script>