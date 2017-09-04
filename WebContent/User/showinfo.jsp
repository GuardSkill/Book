<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path=request.getContextPath();
String basePath=request.getScheme()+"://"+request.getServerName()+":"+
request.getServerPort()+path+"/";
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
						<li class="active"><a href="showInfo?page=1">我的借阅信息</a></li>
					</ul>
					<form class="navbar-form navbar-left" role="search"
						action="findBook">
						<div class="form-group">
							<input type="text" class="form-control"  required="required" 
						 name="param"/>
						</div>
						<button type="submit" class="btn btn-default">查书</button>
					</form>
					<ul class="nav navbar-nav navbar-right">
						<li class="dropdown navbar-right"><a href="#"
							class="dropdown-toggle" data-toggle="dropdown">欢迎您，成大學子<strong
								class="caret"></strong></a>
							<ul class="dropdown-menu">
								<li><a href="mailto:497291093@qq.com">联系圖書管理員</a></li>
								<li><a href="mailto:497291093@qq.com">联系學校圖書舘</a></li>
								<li class="divider"></li>
								<li><a href="outUser">退出登录</a></li>
							</ul>
							</li>
					</ul>
				</div>
				</nav>

			</div>
		</div>
		<div class="page-header"  style="padding: 5px">
			<h1>Azure</h1>
		</div>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>ISBN号</th>
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
		<span id="strutsmessage"><s:actionmessage/> </span>
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