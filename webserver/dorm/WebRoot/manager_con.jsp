<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en">
<head>
<title>����Աҳ��</title>
<meta charset="gb2312" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/bootstrap-responsive.min.css" />
<link rel="stylesheet" href="css/fullcalendar.css" />
<link rel="stylesheet" href="css/unicorn.main.css" />
<link rel="stylesheet" href="css/unicorn.grey.css" class="skin-color" />
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<script type="text/javascript" charset="utf-8">
           function checkStudent(){
                  var reg = new RegExp("^[0-9]*$");
                  var studentId=$("#studentId").val();
                  if(!reg.test(studentId)||studentId==''||studentId==null){
                     alert("�����ʽ����ȷ");
                     return false;
                  }
                  if(300000<studentId||studentId<0){
                     alert("��ֵ�����涨��Χ");
                     return false;
                  }
                  return true;
           }
                function checkWorker(){
                        var strP=/^\d+(\.\d+)?$/;
                  var reg = new RegExp("^[0-9]*$");
                  var workerId=$("#workerId").val();
                  if(!reg.test(workerId)||workerId==''||workerId==null||!strP.test(workerId)){
                     alert("�����ʽ����ȷ");
                     return false;
                  }
                           if(300000<workerId||workerId<0){
                     alert("��ֵ�����涨��Χ");
                     return false;
                  }
                  return true;
           }
                    function checkOrder(){
                  var strP=/^\d+(\.\d+)?$/;
                  var reg = new RegExp("^[0-9]*$");
                  var orderId=$("#orderId").val();
                  if(!reg.test(orderId)||orderId==''||orderId==null||!strP.test(orderId)){
                     alert("�����ʽ����ȷ");
                     return false;
                  }
                            if(300000<orderId||orderId<0){
                     alert("��ֵ�����涨��Χ");
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


	<div id="user-nav" class="navbar navbar-inverse"><ul class="nav btn-group"><li class="btn btn-inverse"><a title="" href="cleanSession.jsp"><i
					class="icon icon-share-alt"></i> <span class="text">�˳�</span>
			</a>
			</li>
		</ul>
	</div>
	<div id="sidebar">
		<a href="#" class="visible-phone"><i class="icon icon-home"></i>Dashoard</a>
		<ul>
			<li class="active"><a href="ManagerAction!backIndex"><i
					class="icon icon-home"></i> <span>����Ա������Ϣ</span>
			</a>
			</li>
			<li><a href="ManagerAction!giveJob"><i
					class="icon icon-inbox"></i> <span>Ա����������</span> </a></li>
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
			<h1>����Ա������Ϣ</h1>
			<div class="btn-group"></div>
		</div>
		<div id="breadcrumb">
			<a href="#" class="current">����Ա������Ϣ</a>
		</div>
		<div class="container-fluid">
			<div class="row-fluid">
				<div class="span12 center" style="text-align: center;">
					<ul class="site-stats">
						<li>����Ա����:<strong><s:property value="manager.name" />
						</strong><br></li>
						<li>����Ա����:<strong><s:property
									value="manager.managerId" />
						</strong><br></li>
						<li>�û���:<strong><s:property value="manager.username" />
						</strong><br></li>

					</ul>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span12">
					<div class="widget-box">
						<div class="widget-title">
							<span class="icon"> <i class="icon-align-justify"></i> </span>
							<h5>����ѧ��ѧ�ſ��Բ�����Ӧѧ����Ϣ</h5>
						</div>
						<div class="widget-content nopadding">
							<form class="form-horizontal" method="post" action="StudentAction!findStudent" name="password_validate" id="password_validate" novalidate="novalidate" onsubmit="return checkStudent();" />
							<div class="control-group">
								<label class="control-label">����ѧ��ѧ��</label>
								<div class="controls">
									<input type="text" name="student.studentId" id="studentId" />
								</div>
								<div class="form-actions">
									<input type="submit" value="��ʼ����" class="btn btn-primary" />
								</div>
							</div>
							</form>
						</div>
					</div>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span12">
					<div class="widget-box">
						<div class="widget-title">
							<span class="icon"> <i class="icon-align-justify"></i> </span>
							<h5>����Ա�����ſ��Բ�����ӦԱ����Ϣ</h5>
						</div>
						<div class="widget-content nopadding">
							<form class="form-horizontal" method="post"
								action="WorkerAction!findWorker" name="password_validate"
								id="password_validate" novalidate="novalidate"
								onsubmit="return checkWorker();">
								<div class="control-group">
									<label class="control-label">����Ա������</label>
									<div class="controls">
										<input type="text" name="worker.workerId" id="workerId" />
									</div>
									<div class="form-actions">
										<input type="submit" value="��ʼ����" class="btn btn-primary" />
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span12">
					<div class="widget-box">
						<div class="widget-title">
							<span class="icon"> <i class="icon-align-justify"></i> </span>
							<h5>���뱨�޵�������Բ�����Ӧ���޵���Ϣ</h5>
						</div>
						<div class="widget-content nopadding">
							<form class="form-horizontal" method="post"
								action="OrderAction!findOrder" name="password_validate"
								id="password_validate" novalidate="novalidate"
								onsubmit="return checkOrder();">
								<div class="control-group">
									<label class="control-label">���뱨�޵���</label>
									<div class="controls">
										<input type="text" name="order.orderId" id="orderId" />
									</div>
									<div class="form-actions">
										<input type="submit" value="��ʼ����" class="btn btn-primary" />
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
