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
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target="#bs-example-navbar-collapse-1">
						<span class="sr-only">Toggle navigation</span><span
							class="icon-bar"></span><span class="icon-bar"></span><span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#">首页</a>
				</div>

				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<li class="active"><a href="#">我的借阅信息</a></li>

					</ul>

					<form class="navbar-form navbar-left" role="search">
						<div class="form-group">
							<input type="text" class="form-control" />
						</div>
						<button type="submit" class="btn btn-default">查书</button>
					</form>
					<ul class="nav navbar-nav navbar-right">
						<li><a href="#">退出登录</a></li>
					</ul>
				</div>
				</nav>

			</div>
		</div>
		<div class="page-header">
			<h1>Azure</h1>
		</div>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>书名</th>
					<th>作者</th>
					<th>出版社</th>
					<th>现存数</th>
					<th>总数</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>1</td>
					<td>高等数学</td>
					<td>高极端出版社</td>
					<td>1</td>
					<td>2</td>
				</tr>
				<tr class="success">
					<td>2</td>
					<td>高等数学</td>
					<td>高极端出版社</td>
					<td>1</td>
					<td>2</td>
				</tr>
				<tr class="error">
					<td>3</td>
					<td>高等数学</td>
					<td>高极端出版社</td>
					<td>1</td>
					<td>2</td>
				</tr>
				<tr class="warning">
					<td>4</td>
					<td>高等数学</td>
					<td>高极端出版社</td>
					<td>1</td>
					<td>2</td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>