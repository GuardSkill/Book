<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/jquery-1.10.2.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<title>welcome</title>
</head>
<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<nav class="navbar navbar-default navbar-inverse navbar-fixed-top"
					role="navigation">
				<div class="navbar-header">
					<a class="navbar-brand" href="showData">个人首页</a>
				</div>

				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<li ><a href="showData">图书信息</a></li>
						<li class="active"><a href="User/newbook.jsp">添加图书</a></li>

					</ul>

					<form class="navbar-form navbar-left" role="search">
						<div class="form-group">
							<input type="text" class="form-control" />
						</div>
						<button type="submit" placeholder="书名或者书ID" class="btn btn-default">查书</button>
					</form>
					<ul class="nav navbar-nav navbar-right">
						<li><a href="userOut">退出登录</a></li>
					</ul>
				</div>
				</nav>

			</div>
		</div>
		<div class="page-header">
			<h1>Azure</h1>
		</div>
		<form action="newGood" method="post" enctype="mutipart/form-data">
			<div class="form-group">
				<input name="book.bName" type="text" class="form-control"
					placeholder="书籍名称" />
			</div>
			<div class="form-group">
				<input name="book.bWriter" type="text" class="form-control"
					placeholder="作者" />
			</div>
			<div class="form-group">
				<input name="book.bPress" type="text" class="form-control"
					placeholder="出版社" />
			</div>
			<div class="form-group">
				<input name="book.bMaxnum" type="text" class="form-control"
					placeholder="数量" />
			</div>
			<div class="form-group">
				<textarea name="book.bDesc" class="form-control"
					placeholder="请君好好描述哦~" rows="5"></textarea>
			</div>
			<div class="form-group">
				<button type="submit" class="btn btn-default btn-primary">确定入库</button>
				<button type="button" class="btn btn-default btn-primary">返回</button>
			</div>
		</form>
	</div>
</body>
</html>