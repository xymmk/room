<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en">
	<head>
		<title>员工基本页面</title>
		<meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<link rel="stylesheet" href="css/bootstrap.min.css" />
		<link rel="stylesheet" href="css/bootstrap-responsive.min.css" />
		<link rel="stylesheet" href="css/fullcalendar.css" />	
		<link rel="stylesheet" href="css/unicorn.main.css" />
		<link rel="stylesheet" href="css/unicorn.grey.css" class="skin-color" />
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
	        <script type="text/javascript" charset="utf-8">
	           function check(){
	             var getCheck;
	             var oldPassword=$("#oldPassword").val();
	             var nowPassword=$("#nowPassword").val();
	             var password=$("#password").val();
	             var surePassword=$("#surePassword").val();
            if(oldPassword==''||oldPassword==null||oldPassword.length>15||
               password==''||password==null||password.length>15||
               surePassword==''||surePassword==null||surePassword.length>15){
                   alert("输入空值或字符溢出");
                   getCheck=false;
               }
	                else{
	                        if(oldPassword!=nowPassword){
	                        alert("原密码输入不正确");
	                        getCheck=false;
	                        }else{
	                                if(surePassword!=password){
	                                alert("确认密码输入不一致");
	                                getCheck=false;
	                                }else{
	                                getCheck=true;
	                                }
	                             }
	               }
                return getCheck;
	           }
        </script>
	</head>
	<body>
		
		
		<div id="header">
			<h1></h1>		
		</div>
		
	
	<div id="user-nav" class="navbar navbar-inverse"><ul class="nav btn-group"><li class="btn btn-inverse"><a title="" href="cleanSession.jsp"><i
					class="icon icon-share-alt"></i> <span class="text">退出</span>
			</a>
			</li>
		</ul>
	</div>
            
		<div id="sidebar">
			<a href="#" class="visible-phone"><i class="icon icon-home"></i>Dashoard</a>
			<ul>
				<li class="active"><a href="WorkerAction!backIndex"><i class="icon icon-home"></i> <span>员工基本信息</span></a></li>
				<li>
					<a href="OrderAction!WorkerCheckOrder"><i class="icon icon-th"></i> <span>报修单设置项</span> </a>
				</li>
			</ul>
		
		</div>
		
		<div id="style-switcher">
			<i class="icon-arrow-left icon-white"></i>
			<span>Style:</span>
			<a href="#grey" style="background-color: #555555;border-color: #aaaaaa;"></a>
			<a href="#blue" style="background-color: #2D2F57;"></a>
			<a href="#red" style="background-color: #673232;"></a>
		</div>
		
		<div id="content">
			<div id="content-header">
				<h1>员工基本信息</h1>
				<div class="btn-group">
				</div>
			</div>
			<div id="breadcrumb">
				<a href="worker_con.jsp" class="current">员工基本信息</a>
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
						</ul>
					</div>	
				</div>
				<div class="row-fluid">
						<div class="span12">
							<div class="widget-box">
								<div class="widget-title">
									<span class="icon">
										<i class="icon-align-justify"></i>									
									</span>
									<h5>你可以在下面修改你的信息</h5>
								</div>
								<div class="widget-content nopadding">
									<form class="form-horizontal" method="post" action="WorkerAction!updateWorker" name="password_validate" id="password_validate" novalidate="novalidate" onsubmit="return check();" />
										<div class="control-group">
											<label class="control-label">输入你的原密码</label>
											<div class="controls">
												<input type="password" name="oldPassword" id="oldPassword" />
											    <input type="hidden" value="${worker.password}" id="nowPassword"/>
												<input type="hidden" name="worker.workerId" value="${worker.workerId}"/>
												<input type="hidden" name="worker.name" value="${worker.name}"/>
												<input type="hidden" name="worker.username" value="${worker.username}">
											</div>
										</div>
										<div class="control-group">
											<label class="control-label">修改你的密码</label>
											<div class="controls">
												<input type="password" name="worker.password" id="password" />
											</div>
										</div>
									   <div class="control-group">
											<label class="control-label">再确认一次密码</label>
											<div class="controls">
												<input type="password" name="surePassword" id="surePassword" />
											</div>
										</div>
										<div class="form-actions">
											<input type="submit" value="确认修改信息" class="btn btn-primary" />
										</div>
									</form>
								</div>
							</div>
						</div>			
					</div>
				<div class="row-fluid">
					<div id="footer" class="span12">
					</div>
				</div>
			</div>
		</div>
		

            <script src="js/excanvas.min.js"></script>
            <script src="js/jquery.min.js"></script>
            <script src="js/jquery.ui.custom.js"></script>
            <script src="js/bootstrap.min.js"></script>
            <script src="js/jquery.flot.min.js"></script>
            <script src="js/jquery.flot.resize.min.js"></script>
            <script src="js/jquery.peity.min.js"></script>
            <script src="js/fullcalendar.min.js"></script>
            <script src="js/unicorn.js"></script>
            <script src="js/unicorn.dashboard.js"></script>
	</body>
</html>
