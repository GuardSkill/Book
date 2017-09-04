<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
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
						<li class="active"><a href="showBook?page=1">图书信息</a></li>
						<li><a href="User/newbook.jsp">添加图书</a></li>
					</ul>
					<form class="navbar-form navbar-left" role="search"
						action="findBook">
						<div class="form-group">
							<input type="text" class="form-control" placeholder="书名/ISBN号" 
							required="required" name="param" />
						</div>
						<button type="submit" class="btn btn-default">查书</button>
					</form>
					<ul class="nav navbar-nav navbar-right">
						<li class="dropdown navbar-right"><a href="#"
							class="dropdown-toggle" data-toggle="dropdown">欢迎您，圖書管理员<strong
								class="caret"></strong></a>
							<ul class="dropdown-menu">
							    <li><a href="mailto:497291093@qq.com">联系人事管理員</a></li>	
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
					<th>作者</th>
					<th>热度</th>
					<th>出版社</th>
					<th>现存数</th>
					<th>总数</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="books" var="bo" status="st">
					<tr
						class="<s:if test="#st.even">success</s:if>
						<s:else>error</s:else>">
						<td><s:property value="bId" /></td>
						<td><s:property value="bName" /></td>
						<td><s:property value="bWriter" /></td>
						<td><s:property value="bHot" /></td>
						<td><s:property value="bPress" /></td>
						<td><s:property value="bNownum" /></td>
						<td><s:property value="bMaxnum" /></td>
						<td><a href="remvBook?book.bId=<s:property value="bId"/>">
								<button type="button" class="btn btn-default btn-primary">出库</button>
						</a></td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
		<span id="strutsmessage"><s:actionmessage /> </span>
		<ul class="pagination">
			<li><a href="showBook?pageop=-1
			&param=<s:property value="param"/>">Prev</a></li>
			<s:iterator begin="1" end="5" status="stat">
				<li><a href="showBook?page=<s:property value="#stat.count"/>
				&param=<s:property value="param"/>">
						<s:property value="#stat.count" />
				</a></li>
			</s:iterator>
			<li><a href="showBook?pageop=1
			&param=<s:property value="param"/>">Next</a></li>
		</ul>
	</div>
</body>
</html>