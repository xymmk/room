<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en">
<head>
<title>员工设置项</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/bootstrap-responsive.min.css" />
<link rel="stylesheet" href="css/uniform.css" />
<link rel="stylesheet" href="css/select2.css" />
<link rel="stylesheet" href="css/unicorn.main.css" />
<link rel="stylesheet" href="css/unicorn.grey.css" class="skin-color" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	 
</head>
<body>


	<div id="header">
		<h1></h1>
	</div>


	<div id="user-nav" class="navbar navbar-inverse">
		<ul class="nav btn-group">
			<li class="btn btn-inverse"><a title="" href="cleanSession.jsp"><i
					class="icon icon-share-alt"></i> <span class="text">退出</span> </a>
			</li>
		</ul>
	</div>

	<div id="sidebar">
		<a href="#" class="visible-phone"><i class="icon icon-th-list"></i></a>
			<ul>
				<li><a href="ManagerAction!backIndex"><i class="icon icon-home"></i> <span>管理员基本信息</span></a></li>
				<li class="active">
					<a href="#"><i class="icon icon-signal"></i> <span>员工设置项</span> </a>
				</li>
			</ul>

	</div>

	<div id="style-switcher">
		<i class="icon-arrow-left icon-white"></i> <span>Style:</span> <a
			href="#grey" style="background-color: #555555;border-color: #aaaaaa;"></a>
		<a href="#blue" style="background-color: #2D2F57;"></a> <a href="#red"
			style="background-color: #673232;"></a>
	</div>

	<div id="content">
		<div id="content-header">
			<h1>员工设置项</h1>
			<div class="btn-group"></div>
		</div>
		<div id="breadcrumb">
			<a href="#" title="Go to Home" class="tip-bottom"><i
				class="icon-home"></i>管理员基本信息</a> <a href="#" class="current">员工设置项</a>
		</div>
		<div class="container-fluid">
					<div class="row-fluid">
					<div class="span12 center" style="text-align: center;">				
						<ul class="site-stats">
							<li>
							员工姓名:<strong><s:property value="worker.name"/></strong><br>
							</li>
							<li>
							工号:<strong><s:property value="worker.workerId"/></strong><br>
							</li>
							<li>
							用户名:<strong><s:property value="worker.username"/></strong><br>
							</li>
                            <li>
							负责宿舍量:<strong><s:property value="worker.rooms"/></strong><br>
							</li>
							<li>
							  <form  method="post" action="WorkerAction!deleteWorker" onsubmit="return check();" >
								<input type="hidden" name="worker.workerId" value="${worker.workerId}"/>
								 <div class="form-actions">
									<input type="submit" value="确认删除该员工" class="btn btn-primary" />
								</div>
							 </form>
							</li>
						</ul>
					</div>	
				</div>
			<div class="row-fluid">
				<div id="footer" class="span12"></div>
			</div>
		</div>
	</div>



	<script src="js/jquery.min.js"></script>
	<script src="js/jquery.ui.custom.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.uniform.js"></script>
	<script src="js/select2.min.js"></script>
	<script src="js/jquery.dataTables.min.js"></script>
	<script src="js/unicorn.js"></script>
	<script src="js/unicorn.tables.js"></script>
</body>
</html>
