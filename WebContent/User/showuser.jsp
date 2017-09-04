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
					<a class="navbar-brand" href="showUser?page=1">首页</a>
				</div>

				<div>
					<ul class="nav navbar-nav">
						<li class="active"><a href="showUser?page=1">人员信息</a></li>

					</ul>

					<form class="navbar-form navbar-left" role="search"
						action="findUser">
						<div class="form-group">
							<input type="text" class="form-control" name="param"
								placeholder="人员ID/人员姓名" />
						</div>
						<button type="submit" class="btn btn-default">查人</button>
					</form>
					<ul class="nav navbar-nav navbar-right">
						<li class="dropdown navbar-right"><a href="#"
							class="dropdown-toggle" data-toggle="dropdown">欢迎您，人事管理员<strong
								class="caret"></strong></a>
							<ul class="dropdown-menu">
								<li><a href="mailto:497291093@qq.com">联系項目負責人</a></li>
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
					<th>编号</th>
					<th>人员</th>
					<th>邮箱</th>
					<th>种类</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
		<s:iterator value="users" var="us" status="st">
						<tr class="<s:if test="#st.even">success</s:if>
						<s:else>error</s:else>">
					     	<td><s:property value="uId"/></td>
							<td><s:property value="uName"/></td>
							<td><s:property value="uEmail"/></td>
							<td><s:if test="uType==3">人事管理员</s:if>
							<s:elseif test="uType==2">图书管理员</s:elseif>
							<s:elseif test="uType==1">学生</s:elseif>
							<s:else >访客</s:else>
							</td>
							<td><a href="remvUser?user.uId=<s:property value="uId"/>"> 
							<button type="button" class="btn btn-default btn-primary" >删除</button></a>
							<a href="updateUser?user.uId=<s:property value="uId"/>&op=+1"> 
							<button type="button" class="btn btn-default btn-primary" >提权</button></a>
							<a href="updateUser?user.uId=<s:property value="uId"/>&op=-1"> 
							<button type="button" class="btn btn-default btn-primary" >降权</button></a>
							</td>
						</tr>
					</s:iterator>
			</tbody>
		</table>
		<span id="strutsmessage"><s:actionmessage /> </span>
		<ul class="pagination">
			<li><a href="showUser?pageop=-1
			&param=<s:property value="param"/>">Prev</a></li>
			<s:iterator begin="1" end="5" status="stat">
				<li><a href="showUser?page=<s:property value="#stat.count" />
				&param=<s:property value="param"/>">
						<s:property value="#stat.count" />
				</a></li>
			</s:iterator>
			<li><a href="showUser?pageop=1
			&param=<s:property value="param"/>">Next</a></li>
		</ul>
	</div>
</body>
</html>