<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/head.jsp"%>
<div class="content">
	<div class="container-fluid">
		<nav class="pull-left">
			<strong>你现在所在的位置是:</strong>&nbsp;&nbsp;&nbsp; <span> 新闻管理页面 >>
				新闻查看页面</span><br> <br>
		</nav>
	</div>

	<div class="row">
		<div class="col-lg-8 col-md-7">
			<div class="card">
				<div class="header">
					<h4 class="title">
						用户信息 <small> User Information</small>
					</h4>
				</div>
				<div class="content">
					<p>
						<strong>新闻编号：</strong><span>${news.id }</span>
					</p>
					<p>
						<strong>新闻标题：</strong><span>${news.title}</span>
					</p>
					<p>
						<strong>新闻内容：</strong> <span> ${news.content} </span>
					</p>
					<p>
						<strong>创建人：</strong><span>${news.createdCode}</span>
					</p>
					<p>
						<strong>创建时间：</strong><span><fmt:formatDate value="${news.creationDate}" pattern="yyyy-MM-dd" /></span>
					</p>
					<c:if test="${news.modifyBy!=null}">
						<p>
							<strong>修改人：</strong><span>${news.modifyCode}</span>
						</p>
						<p>
							<strong>修改时间：</strong><span><fmt:formatDate
								value="${news.modifyDate}" pattern="yyyy-MM-dd" /></span>
						</p>
					</c:if>
					<div class="providerAddBtn">
						<input type="button" id="back" name="back" value="返回"
							class="btn btn-success btn-fill btn-wd">
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<%@include file="/WEB-INF/jsp/common/foot.jsp"%>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/statics/js/userview.js"></script>