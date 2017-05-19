<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path=request.getContextPath();
String basePath=request.getScheme()+"://"+request.getServerName()+":"+
request.getServerPort()+path+"/";
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
						<li class="active"><a href="showInfo">我的借阅信息</a></li>
					</ul>

					<form class="navbar-form navbar-left" role="search"
						action="findBook">
						<div class="form-group">
							<input type="text" class="form-control" />
						</div>
						<button type="submit" class="btn btn-default">查书</button>
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
		<table class="table table-striped">
			<thead>
				<tr>
					<th>SDN号</th>
					<th>书名</th>
					<th>借出时间</th>
					<th>截至时间</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="infos" var="in" status="st">

					<tr
						class="<s:if test="#st.even">success</s:if>
						<s:else>error</s:else>">
						<td><s:property value="iBook.bId" /></td>
						<td><s:property value="iBook.bName" /></td>
						<td><s:property value="iFirstTime" /></td>
						<td><s:property value="iReturnTime" /></td>
						<td><a href="remvInfo?info.iId=<s:property value="iId"/>">
								<button type="button" class="btn btn-default btn-primary">
									还书</button>
						</a></td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
		<s:actionmessage />
		<ul class="pagination">
			<li><a href="showInfo?pageop=-1">Prev</a></li>
			<li><a href="showInfo?page=1">1</a></li>
			<li><a href="showInfo?page=2">2</a></li>
			<li><a href="showInfo?page=3">3</a></li>
			<li><a href="showInfo?page=4">4</a></li>
			<li><a href="showInfo?page=5">5</a></li>
			<li><a href="showInfo?pageop=1">Next</a></li>
		</ul>
	</div>
</body>
</html>