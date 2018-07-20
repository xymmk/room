<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@page import="com.cyy.dorm.util.GetFileName"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en">
<head>
<title>报修单设置项</title>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/bootstrap-responsive.min.css" />
<link rel="stylesheet" href="css/colorpicker.css" />
<link rel="stylesheet" href="css/datepicker.css" />
<link rel="stylesheet" href="css/uniform.css" />
<link rel="stylesheet" href="css/select2.css" />
<link rel="stylesheet" href="css/unicorn.main.css" />
<link rel="stylesheet" href="css/unicorn.grey.css" class="skin-color" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body>


	<div id="header">
		<h1>

			<span class="text">退出</span>
		</h1>
	</div>

	<div id="user-nav" class="navbar navbar-inverse"><ul class="nav btn-group"><li class="btn btn-inverse"><a title="" href="cleanSession.jsp"><i
					class="icon icon-share-alt"></i> <span class="text">退出</span>
			</a>
			</li>
		</ul>
	</div>
	<div id="sidebar">
		<a href="#" class="visible-phone"><i class="icon icon-th-list"></i>
			Tables</a>
		<ul>
			<li><a href="ManagerAction!backIndex"><i
					class="icon icon-home"></i> <span>管理员基本信息</span> </a>
			</li>

			<li class="active"><a href="#"><i
					class="icon icon-th"></i> <span>报修单设置项</span> </a>
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
			<h1>报修单设置项</h1>
			<div class="btn-group"></div>
		</div>
		<div id="breadcrumb">
			<a href="#" title="Go to Home" class="tip-bottom"><i
				class="icon-home"></i>管理员基本信息</a> <a href="#" class="current">报修单设置项</a>
		</div>
		<div class="container-fluid">
			<div class="row-fluid">
				<div class="span12 center" style="text-align: center;">

	
					<ul class="site-stats">
						<li>报修单号:<strong><s:property value="order.orderId" />
						</strong><br></li>
						<li>报修人学号:<strong><s:property
									value="order.studentId" />
						</strong><br></li>
						<li>负责员工号:<strong><s:property value="order.workerId" />
						</strong><br></li>
						<li>报修内容:<strong><s:property value="order.message" />
						</strong><br></li>
						<li>是否处理:<s:if test="%{order.deal==0}">
								<strong>否 </strong>
							</s:if>
							<s:else>
								<strong>是</strong>
							</s:else><br></li>
						<li>完工日期:<strong><s:property
									value="order.finishDate" />
						</strong><br></li>
						<li>上传日期:<strong><s:property
									value="order.uplodaDate" />
						</strong><br></li>
						<li>预约日期:<strong><s:property
									value="order.willFixDate" />
						</strong><br></li>
						<li>上传图片: <img src="<s:property value="'image/'+order.image"/>"/></li>
						
						<li>
							<form method="post" action="OrderAction!deleteOrder">
								<input type="hidden" name="order.orderId" value="${order.orderId}" />
								<div class="form-actions">
									<input type="submit" value="确认删除该报修单" class="btn btn-primary" />
								</div>
							</form></li>
					</ul>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span12">
					<div class="widget-box">
						<div class="widget-title">
							<span class="icon"> <i class="icon-align-justify"></i> </span>
							<h5>下面你可以修改该报修单相关内容</h5>
						</div>
						<div class="widget-content nopadding">
							<form action="OrderAction!managerUpdate" method="post" class="form-horizontal" />
							<div class="control-group">
								<label class="control-label">预约日期修改</label>
								<div class="controls">
									<input type="text" data-date="12/02/2012" data-date-format="dd/mm/yyyy" value="12/02/2012" class="datepicker" name="bookDate" />
								    <input type="hidden" name="order.orderId" value="${order.orderId}"/>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">完工日期修改</label>
								<div class="controls">
									<input type="text" data-date="12/02/2012" data-date-format="dd/mm/yyyy" value="12/02/2012" class="datepicker" name="finishDate" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">是否已处理</label>
								<div class="controls">
									        <select id="selected" name="selected" class="select">
                     <option value="0" selected="selected" >否</option>
                <option value="1" selected="selected">是</option>
                                 </select>
								</div>
							</div>

							<div class="control-group">
								<div class="controls">
									<input type="submit" value="确认修改" class="btn btn-primary" />
								</div>
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
	<script src="js/bootstrap-colorpicker.js"></script>
	<script src="js/bootstrap-datepicker.js"></script>
	<script src="js/jquery.uniform.js"></script>
	<script src="js/select2.min.js"></script>
	<script src="js/unicorn.js"></script>
	<script src="js/unicorn.form_common.js"></script>
</body>
</html>
