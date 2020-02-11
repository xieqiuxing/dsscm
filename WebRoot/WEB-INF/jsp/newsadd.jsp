<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/head.jsp"%>

<div class="content">
	<div class="container-fluid">
		<nav class="pull-left">
			<strong>你现在所在的位置是:</strong>&nbsp;&nbsp;&nbsp; <span>新闻管理页面 >>
				新闻添加页面</span><br> <br>
		</nav>
	</div>
	<div class="container-fluid">
		<div class="content">
			<div class="container-fluid">
				<div class="row">
					<div>
						<div class="card">
							<div class="header">
								<h4 class="title">
									添加新闻信息 <small> Add News Infomation</small>
								</h4>
							</div>
							<div class="content">
								<form id="newsForm" name="userForm" method="post"
									action="${pageContext.request.contextPath }/sys/news/addsave.html"
									enctype="multipart/form-data">
									<div class="row">
										<div class="col-md-4">
											<div class="form-group">
												<label>标 题 <small> NewsTitle</small> </label> <input
													type="text" class="form-control border-input"
													placeholder="请输入新闻标题" name="title" id="title"><font
													color="red"></font>
											</div>
										</div>
									</div>

									<div class="row">
										<div class="col-md-12">
											<div class="form-group">
													<label>内 容 <small> NewsContent</small> </label> <input
														type="text" class="form-control border-input"
														placeholder="请输入新闻内容" name="content" id="content"><font
														color="red"></font>
											</div>
										</div>
									</div>
									<div class="text-center">
										<button type="submit" id="add" class="btn btn-info btn-fill btn-wd">新 增 新 闻</button>
										<button type="button" id="back" class="btn btn-info btn-fill btn-wd">返回</button>
									</div>
									<div class="clearfix"></div>
								</form>
							</div>
						</div>
					</div>

				</div>
			</div>
		</div>
	</div>
</div>
<%@include file="/WEB-INF/jsp/common/foot.jsp"%>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/statics/js/newsadd.js"></script>
