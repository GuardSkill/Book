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
</head>
<body>
	<div class="container">
		<div class="page-header" style="padding: 5px">
			<h1>
				<a href="showMute">Azure</a>
			</h1>
		</div>
		<div class="page-header" style="padding: 5px">
			<a href="exeMute?msg.mode=2">
				<button type="button" class="btn btn-default btn-primary">
					刷新</button>
			</a>
		</div>
		
		<table class="table table-striped">
			<thead>
				<tr>
					<th>IP</th>
					<th>最后更新时间</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="hostinfos" var="bo" status="st">
					<tr
						class="<s:if test="#st.even">success</s:if>
						<s:else>error</s:else>">
						<td><s:property value="ip" /></td>
						<td><s:property value="time" /></td>
						<td><a
							href="exeMute?channel=<s:property value="ip"/>&msg.mode=0">
								<button type="button" class="btn btn-default btn-primary">
									循环禁用</button>
						</a></td>
						<td><a
							href="exeMute?channel=<s:property value="ip"/>&msg.mode=6">
								<button type="button" class="btn btn-default btn-primary">
									取消循环</button>
						</a></td>
						<td><a
							href="exeMute?channel=<s:property value="ip"/>&msg.mode=1">
								<button type="button" class="btn btn-default btn-primary">
									一次禁用</button>
						</a></td>
						<td><a
							href="exeMute?channel=<s:property value="ip"/>&msg.mode=5">
								<button type="button" class="btn btn-default btn-primary">
									开机自启</button>
						</a></td>
						<td><a
							href="exeMute?channel=<s:property value="ip"/>&msg.mode=4">
								<button type="button" class="btn btn-default btn-primary">
									关闭自启</button>
						</a></td>
						<td><a
							href="exeMute?channel=<s:property value="ip"/>&msg.mode=3">
								<button type="button" class="btn btn-default btn-primary">
									关闭程序</button>
						</a></td>
					</tr>
				</s:iterator>
			</tbody>
		</table>

		<span id="strutsmessage"><s:actionmessage /> </span>
	</div>
</body>
</html>