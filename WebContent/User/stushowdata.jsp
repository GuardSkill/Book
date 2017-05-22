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
						<li class="active"><a href="showData">图书信息</a></li>
						<li><a href="showInfo">我的借阅信息</a></li>
					</ul>

					<form class="navbar-form navbar-left" role="search"
						action="findBook">
						<div class="form-group">
							<input type="text" class="form-control" />
						</div>
						<button type="submit" class="btn btn-default" placeholder="书名/作者">查书</button>
					</form>
					<ul class="nav navbar-nav navbar-right">
						<li><a href="outUser">退出登录</a></li>
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
					<th>热度</th>
					<th>出版社</th>
					<th>现存数</th>
					<th>总数</th>
					<th>描述</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="books" var="bo" status="st">

					<tr
						class="<s:if test="#st.even">success</s:if>
						<s:else>error</s:else>">
						<td><s:property value="bName" /></td>
						<td><s:property value="bWriter" /></td>
						<td><s:property value="bHot" /></td>
						<td><s:property value="bPress" /></td>
						<td><s:property value="bNownum" /></td>
						<td><s:property value="bMaxnum" /></td>
						<td><s:property value="bDesc" /></td>
						<td><a href="newInfo?book.bId=<s:property value="bId"/>">
								<button type="button" class="btn btn-default btn-primary">
									借出</button>
						</a></td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
		<span id="strutsmessage"><s:actionmessage /> </span>
		<ul class="pagination">
			<li><a href="showBook?pageop=-1">Prev</a></li>
			<s:iterator begin="1" end="5" status="stat">
				<li><a href="showBook?page=<s:property value="#stat.count" />">
						<s:property value="#stat.count" />
				</a></li>
			</s:iterator>
			<li><a href="showBook?pageop=1">Next</a></li>
		</ul>
	</div>
</body>
</html>