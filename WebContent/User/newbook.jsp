<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path=request.getContextPath();
String basePath=request.getScheme()+"://"+request.getServerName()+":"+
request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>我要发布商品~</title>
<link rel="stylesheet" href="bootstrap.min.css" />
<link rel="stylesheet" href="style.css" />
<style type="text/css">
body {
	width: 100%;
	height: 100%;
	font-family: 'Open Sans', sans-serif;
	margin: 0;
	background-size: 100% 666pt;
	background-image: url(trade.jpg);
	background-repeat: no-repeat;
}
</style>
</head>
<body>
	<div class="container">
		<div>
			<h2 class="text-center">请完善商品信息</h2>
			<div class="row">
				<div class="col-sm-6 col-sm-offset-3">
				       <div class="form-group">
						</div>
						<form action="newGood"  method="post"  enctype="mutipart/form-data">
						<div class="form-group">					
							<input  name="good.gTitle" type="text" class="form-control"
								placeholder="商品名称" />
						</div>
						<div class="form-group">
							<input name="good.gPrice" type="text" class="form-control"
								placeholder="商品价格" />
						</div>
						<div class="form-group">
							<textarea name="good.gDesc" class="form-control"
								placeholder="请君好好描述哦~" rows="5"></textarea>
						</div>
						<div class="form-group">
							<s:file name="upload" label="选择图片"></s:file>
							<button type="submit">上传</button>
						</div>
						<button type="submit" class="btn btn-warning">发布</button>
						<button type="button" class="btn btn-warning" 
                        onclick="window.location.href='/Market/User/welcome.jsp'">
							返回首页
						</button>                                          
				  </form>
				  	
						
				</div>
			</div>
		</div>
	</div>
</body>
</html>
