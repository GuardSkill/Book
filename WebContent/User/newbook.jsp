<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/jquery-1.10.2.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<title>welcome</title>
<style type="text/css">
#strutsmessage {
	font-size: 12px;
	color: #F00;
}
</style>
</head>
<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<nav class="navbar navbar-default navbar-inverse navbar-fixed-top col-md-12"
					role="navigation">
				<div class="navbar-header">
					<a class="navbar-brand" href="showBook?page=1">个人首页</a>
				</div>
				<div>
					<ul class="nav navbar-nav">
						<li ><a href="showBook?page=1">图书信息</a></li>
						<li class="active"><a href="User/newbook.jsp">添加图书</a></li>

					</ul>

					<form class="navbar-form navbar-left" role="search"  action="findBook">
						<div class="form-group">
							<input type="text" class="form-control" placeholder="书名或者书ID" 
							required="required" name="param" />
						</div>
						<button type="submit" class="btn btn-default">查书</button>
					</form>
					<ul class="nav navbar-nav navbar-right">
						<li><a href="outUser">退出登录</a></li>
					</ul>
				</div>
				</nav>

			</div>
		</div>
		<div class="page-header"  style="padding: 5px">
			<h1>Azure</h1>
		</div>
		<span id="strutsmessage"><s:actionmessage/> </span>
		<form action="newBook" method="post" >
			<div class="form-group">
				<input name="book.bName" type="text" class="form-control"
					placeholder="书籍名称" required="required"/>
			</div>
			<div class="form-group">
				<input name="book.bWriter" type="text" class="form-control"
					placeholder="作者" required="required"/>
			</div>
			<div class="form-group">
				<input name="book.bPress" type="text" class="form-control"
					placeholder="出版社" required="required"/>
			</div>
			<div class="form-group">
				<input name="book.bMaxnum" type="text" class="form-control"
					placeholder="数量" required="required"/>
			</div>
			<div class="form-group">
				<textarea name="book.bDesc" class="form-control"
					placeholder="请君好好描述哦~" required="required" rows="5"></textarea>
			</div>
			<div class="form-group">
				<button type="submit" class="btn btn-default btn-primary">确定入库</button>
				<button type="button" class="btn btn-default btn-primary">返回</button>
			</div>
		</form>
	</div>
</body>
</html>