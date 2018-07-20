<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
<title>报修单设置项</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/bootstrap-responsive.min.css" />
<link rel="stylesheet" href="css/uniform.css" />
<link rel="stylesheet" href="css/select2.css" />
<link rel="stylesheet" href="css/unicorn.main.css" />
<link rel="stylesheet" href="css/unicorn.grey.css" class="skin-color" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script language="javascript">
	
</script>
</head>
<body>


	<div id="header">
		<h1></h1>
	</div>


	<div id="user-nav" class="navbar navbar-inverse">
		<ul class="nav btn-group">
			<li class="btn btn-inverse"><a title="" href="login.html"><i
					class="icon icon-share-alt"></i> <span class="text">退出</span> </a>
			</li>
		</ul>
	</div>

	<div id="sidebar">
		<a href="#" class="visible-phone"><i class="icon icon-th-list"></i>
			Tables</a>
		<ul>
			<li><a href="WorkerAction!backIndex"><i
					class="icon icon-home"></i> <span>员工基本信息</span> </a></li>

			<li class="active"><a href="tables.html"><i
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

							<h5>你所负责已处理的报修单状况</h5>
						</div>
						<div class="widget-content nopadding">
							<ul class="activity-list">
								<li>
									<table class="table table-bordered table-striped">
										<thead>
											<tr>
												<th>报修单号</th>
												<th>报修学生学号</th>
												<th>报修学生姓名</th>
												<th>报修宿舍</th>
												<th>负责员工号</th>
												<th>是否处理</th>
												<th>详细查看</th>
												<th>点击修改</th>
											</tr>
										</thead>
										<tbody>
											<s:iterator value="arrayList" var="order">
												<tr class="success">
													<td><s:property value="#order.orderId" />
													</td>
													<td><s:property value="#order.studentId" />
													</td>
													<td><s:property value="#order.stuName" />
													</td>
													<td><s:property value="#order.address" />
													</td>
													<td><s:property value="#order.workerId" />
													</td>
													<td><s:if test="%{#order.deal!=0}">
															<p>是</p>
														</s:if> <s:else>
															<p>否</p>
														</s:else>
													</td>
													<td>
														<p>
															<a href="#">详细查看</a>
														</p>
													</td>
													<td>
														<p>
															<a href="#">点击修改</a>
														</p>
													</td>
												</tr>
											</s:iterator>
										</tbody>
									</table>
								</li>
								<li>
									<div class="pagination">
										<ul>
											<s:iterator value="allPage" var="p">
												<li><a href="OrderAction!WorkerCheckOrder?page=${p}"><s:property
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
				<div class="widget-box">
					<div class="widget-title">
						<span class="icon"> <i class="icon-th"></i> </span>
						<h5>你所负责未处理的报修单状况</h5>
						<span class="label label-info">已处理的报修单请打钩</span>
					</div>
					<div class="widget-content">
					<form action="OrderAction!dealedOrd" method="post">
						<ul class="activity-list">
							<li>
								<table class="table table-bordered table-striped with-check">
									<thead>
										<tr>
											<th><input type="checkbox" id="title-table-checkbox"
												name="title-table-checkbox" />全选</th>
												<th>报修单号</th>
												<th>报修学生学号</th>
												<th>报修学生姓名</th>
												<th>报修宿舍</th>
												<th>负责员工号</th>
												<th>是否处理</th>
												<th>详细查看</th>
												<th>点击修改</th>
										</tr>
									</thead>
									<tbody>
									<s:iterator value="arrayListNot" var="order">
												<tr>
													<td><input type="checkbox" name="dealedOrder" value=<s:property value="#order.orderId"/> /></td>
													<td><s:property value="#order.orderId"/>
													</td>
													<td><s:property value="#order.studentId" />
													</td>
													<td><s:property value="#order.stuName" />
													</td>
													<td><s:property value="#order.address" />
													</td>
													<td><s:property value="#order.workerId" />
													</td>
													<td><s:if test="%{#order.deal!=0}">
															<p>是</p>
														</s:if> <s:else>
															<p>否</p>
														</s:else>
													</td>
													<td>
														<p>
															<a href="#">详细查看</a>
														</p>
													</td>
													<td>
														<p>
															<a href="#">点击修改</a>
														</p>
													</td>
												</tr>
											</s:iterator>
									</tbody>
								</table></li>
							<li>
								<div class="pagination">
									<ul>
										<s:iterator value="allPageNot" var="p">
											<li><a href="OrderAction!WorkerCheckOrder?pageNot=${p}"><s:property
														value="#p" /> </a></li>
										</s:iterator>
									</ul>

								</div></li>
								<li>	<input type="submit" value="提交新已处理报修单" class="btn btn-primary" /></li>
						</ul>
		          </form>
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
								<h5>下面你批量修改预约日期</h5>
							</div>
							<div class="widget-content nopadding">
								<form action="OrderAction!uploadNewOrder" method="post" class="form-horizontal" onsubmit="return check();">
                                    <div class="control-group">
                                        <label class="control-label">Date picker</label>
                                        <div class="controls">
                                            <input type="text" data-date="12-02-2012" data-date-format="dd-mm-yyyy" value="12-02-2012" class="datepicker" />
                                        </div>
                                    </div>
									<div class="form-actions">
										<button type="submit" class="btn btn-primary">确认提交</button>
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
