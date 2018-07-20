<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="/struts-tags" prefix="s"%>
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
	<script type="text/javascript" charset="utf-8">
           function check(){
                  var reg = new RegExp("^[0-9]*$");
                  var minRoom=$("#minRoom").val();
                  var maxRoom=$("#maxRoom").val();
                  var giveWorkerId=$("#giveWorkerId").val();
                  if(!reg.test(minRoom)||minRoom==''||minRoom==null||
                     !reg.test(maxRoom)||maxRoom==''||maxRoom==null||
                     !reg.test(giveWorkerId)||giveWorkerId==''||giveWorkerId==null){
                     alert("输入格式不正确");
                     return false;
                  }
                  if(300000<minRoom||minRoom<0||300000<maxRoom||maxRoom<0||300000<giveWorkerId||giveWorkerId<0||minRoom>maxRoom){
                     alert("数值超出规定范围");
                     return false;
                  }
                  return true;
           }

        </script>
	
	</head>
	<body>
		

	<div id="header">
		<h1> 
		 
			 <span class="text">退出</span></h1>
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
					class="icon icon-home"></i> <span>管理员基本信息</span> </a></li>

			<li class="active"><a href="#"><i
					class="icon icon-th"></i> <span>报修单设置项</span> </a></li>
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
				class="icon-home"></i>员工基本信息</a> <a href="#" class="current">报修单设置项</a>
		</div>
			<div class="container-fluid">
					<div class="row-fluid">
				<div class="span12">
					<div class="widget-box">
						<div class="widget-title">

							<h5>宿舍分配情况</h5>
						</div>
						<div class="widget-content nopadding">
							<ul class="activity-list">
								<li>
									<table class="table table-bordered table-striped">
										<thead>
											<tr>
												<th>宿舍号码</th>
												<th>负责人</th>
												<th>负责人用户名</th>
												<th>负责人姓名</th>
											</tr>
										</thead>
										<tbody>
											<s:iterator value="arrayListRoom" var="room">
												<tr class="success">
													<td><s:property value="#room.roomId" />
													</td>
													<td><s:if test="%{#room.workerId!=0}">
															<s:property value="#room.workerId"/>
														</s:if> <s:else>
															<p>无</p>
														</s:else>
													</td>
												<td><s:property value="#room.workerUsername" />
													</td>
												<td><s:property value="#room.workerName" />
													</td>
												</tr>
											</s:iterator>
										</tbody>
									</table>
								</li>
								<li>
									<div class="pagination">
										<ul>
											<s:iterator value="allPageRoom" var="p">
												<li><a href="ManagerAction!giveJob"><s:property
															value="#p" /> </a></li>
											</s:iterator>
										</ul>

									</div></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
						<div class="row-fluid">
				<div class="span12">
					<div class="widget-box">
						<div class="widget-title">

							<h5>员工工作分配情况</h5>
						</div>
						<div class="widget-content nopadding">
							<ul class="activity-list">
								<li>
									<table class="table table-bordered table-striped">
										<thead>
											<tr>
												<th>员工工号</th>
												<th>员工姓名</th>
												<th>员工用户名</th>
												<th>负责宿舍量</th>
											</tr>
										</thead>
										<tbody>
											<s:iterator value="arrayListWorker" var="worker">
												<tr class="success">
													<td><s:property value="#worker.workerId" />
													</td>
												<td><s:property value="#worker.name" />
													</td>
												<td><s:property value="#worker.username" />
													</td>
														<td><s:property value="#worker.rooms" />
													</td>
												</tr>
											</s:iterator>
										</tbody>
									</table>
								</li>
								<li>
									<div class="pagination">
										<ul>
											<s:iterator value="allPageWorker" var="p">
												<li><a href="ManagerAction!giveJob"><s:property
															value="#p" /> </a></li>
											</s:iterator>
										</ul>

									</div></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
				<div class="row-fluid">
					<div class="span12">
						<div class="widget-box">
							<div class="widget-title">
								<span class="icon">
									<i class="icon-align-justify"></i>									
								</span>
								<h5>下面你安排员工工作范围</h5>
							</div>
							<div class="widget-content nopadding">
								<form action="ManagerAction!giveWorkerJob" method="post" class="form-horizontal" onsubmit="return check();" />
                                    <div class="control-group">
                                        <label class="control-label">从宿舍编号:</label>
                                        <div class="controls">
                                           <input id="minRoom" name="minRoom"/>
                                        </div>
                                    </div>
                                               <div class="control-group">
                                        <label class="control-label">至宿舍编号</label>
                                        <div class="controls">
                                           <input id="maxRoom" name="maxRoom"/>
                                        </div>
                                    </div>
                                                    <div class="control-group">
                                        <label class="control-label">由员工编号为</label>
                                        <div class="controls">
                                           <input id="giveWorkerId" name="giveWorkerId"/> 负责
                                        </div>
                                    </div>
						
					
									<div class="control-group">
									      <div class="controls">
											<input type="submit" value="确认分配" class="btn btn-primary"/>
											</div>
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
