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
							action="${pageContext.request.contextPath }/sys/news/list.html">
							<div class="row">
								<div class="col-md-3">
									<div class="form-group">
										<label>标题 </label> <input type="text" name="title"
											class="form-control border-input" value="${title}"
											placeholder="请输入搜索新闻标题关键字......">
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
											href="${pageContext.request.contextPath}/sys/news/add.html">添加新闻</a>
									</div>
								</div>
							</div>
							<div class="clearfix"></div>
						</form>
					</div>
					<div class="content table-responsive table-full-width">
						<table class="table table-striped" style="word-break: break-all;word-wrap: break-word;">
							<thead>
								<tr>
									<th width="12%">新闻编码</th>
									<th width="23%">新闻标题</th>
									<th width="40%">新闻内容</th>
									<th width="25%">操作</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="news" items="${newsList.list}" varStatus="status">
									<tr>
										<td><span>${news.id }</span>
										</td>
										<td><span>${news.title}</span>
										</td>
										<td width="40%"><span> ${news.content}</span>
										</td>
										<td><span><a class="viewnews btn btn-info btn-xs"
												href="javascript:;" newsid=${news.id}  >查看</a></span>&nbsp;&nbsp; 
											<span><a class="modifynews btn btn-warning btn-xs"
												href="javascript:;" newsid=${news.id}  href="newsmodify.html">编辑</a></span>&nbsp;&nbsp;
											<span><a class="deletenews btn btn-success btn-xs"
												href="javascript:;" newsid=${news.id}>删除</a></span></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<nav class=" pull-right" aria-label="Page navigation">
							<ul class="pagination">
								<li>
									<a href="list.html?pageIndex=1&title=${title}" aria-label="Previous"> 
									<span aria-hidden="true">首页</span> </a>
								</li>
								<li><a href="list.html?pageIndex=${newsList.prePage==0?1:newsList.prePage}&title=${title}" aria-label="Previous"> <span aria-hidden="true">&laquo;</span> </a>
								</li>
								<c:if test="${newsList.pages-5>0}">
									<c:forEach begin="${newsList.pages-newsList.pageNum>=5?newsList.pageNum:newsList.pages-5}" end="${newsList.pageNum<newsList.pages-5?newsList.pageNum+5:newsList.pages}" var="i">
										<li <c:if test="${newsList.pageNum==i}">class="active"</c:if>>
										<a href="list.html?pageIndex=${i}&title=${title}">${i}</a>
										</li>
									</c:forEach>
								</c:if>
								<c:if test="${newsList.pages-5<0}">
									<c:forEach begin="1" end="${newsList.pages}" var="i">
										<li <c:if test="${newsList.pageNum==i}">class="active"</c:if>>
										<a href="list.html?pageIndex=${i}&title=${title}">${i}</a>
										</li>
									</c:forEach>
								</c:if>
								<li><a href="list.html?pageIndex=${newsList.pageNum==newsList.lastPage?newsList.lastPage:newsList.nextPage}&title=${title}" aria-label="Next"> <span
										aria-hidden="true">&raquo;</span> </a>
								</li>
								<li>
									<a href="list.html?pageIndex=${newsList.pages}&title=${title}" aria-label="Previous"> 
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
	src="${pageContext.request.contextPath }/statics/js/newslist.js"></script>