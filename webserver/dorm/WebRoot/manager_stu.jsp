<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en">
<head>
<title>学生设置项</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/bootstrap-responsive.min.css" />
<link rel="stylesheet" href="css/uniform.css" />
<link rel="stylesheet" href="css/select2.css" />
<link rel="stylesheet" href="css/unicorn.main.css" />
<link rel="stylesheet" href="css/unicorn.grey.css" class="skin-color" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	        <script type="text/javascript" charset="utf-8">
	                function check(){
                  var reg = new RegExp("^[0-9]*$");
                  var roomId=$("#roomId").val();
                  if(!reg.test(roomId)||roomId==''||roomId==null){
                     alert("输入格式不正确");
                     return false;
                  }
                  if(300000<roomId||roomId<0){
                     alert("数值超出规定范围");
                     return false;
                  }
                  return true;
           }
        </script>
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
					<a href="#"><i class="icon icon-signal"></i> <span>学生设置项</span> </a>
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
			<h1>学生设置项</h1>
			<div class="btn-group"></div>
		</div>
		<div id="breadcrumb">
			<a href="#" title="Go to Home" class="tip-bottom"><i
				class="icon-home"></i>管理员基本信息</a> <a href="#" class="current">学生设置项</a>
		</div>
		<div class="container-fluid">
					<div class="row-fluid">
					<div class="span12 center" style="text-align: center;">				
						<ul class="site-stats">
							<li>
							学生姓名:<strong><s:property value="student.name"/></strong><br>
							</li>
							<li>
							学号:<strong><s:property value="student.studentId"/></strong><br>
							</li>
							<li>
							用户名:<strong><s:property value="student.username"/></strong><br>
							</li>
                            <li>
							宿舍地址:<strong><s:property value="student.roomId"/></strong><br>
							</li>
							<li>
							  <form  method="post" action="StudentAction!deleteStudent">
								<input type="hidden" name="student.studentId" value="${student.studentId}" />
								 <div class="form-actions">
									<input type="submit" value="确认删除该学生" class="btn btn-primary" />
								</div>
							 </form>
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
									<h5>你可以在下面修改该学生的信息</h5>
								</div>
								<div class="widget-content nopadding">
									<form class="form-horizontal" method="post" action="StudentAction!updateStudent" name="password_validate" id="password_validate" novalidate="novalidate" onsubmit="return check();" >
										<div class="control-group">
											<label class="control-label">修改该学生的宿舍</label>
											<div class="controls">
												<input type="text" name="student.roomId" id="roomId" />
												<input type="hidden" name="student.studentId" value="${student.studentId}"/>
												<input type="hidden" name="student.name" value="${student.name}"/>
												<input type="hidden" name="student.password" value="${student.password}"/>
												<input type="hidden" name="student.username" value="${student.username}"/>
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
