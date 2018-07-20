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
function check(){
            var message=$("#status").val();
            if(message==''||message==null||message.length>140){
               alert("输入空字符或字符溢出");
               return false;
            }else{
               return true;
            }
}

function countChar(textareaName,spanName)
{ 
 document.getElementById(spanName).innerHTML = 140 - document.getElementById(textareaName).value.length;
} 

             function setImagePreview() {
                   var docObj=document.getElementById("doc");
                   var imgObjPreview=document.getElementById("preview");
                   if(docObj.files && docObj.files[0]){
                               //火狐下，直接设img属性
                         imgObjPreview.style.display = 'block';
                         imgObjPreview.style.width = '490px';
                         imgObjPreview.style.height = '250px';
                         //imgObjPreview.src = docObj.files[0].getAsDataURL();
                         //火狐7以上版本不能用上面的getAsDataURL()方式获取，需要一下方式
                         imgObjPreview.src = window.URL.createObjectURL(docObj.files[0]);
                  }else{
                         //IE下，使用滤镜
                         docObj.select();
                         var imgSrc = document.selection.createRange().text;
                         var localImagId = document.getElementById("localImag");
                         //必须设置初始大小
                         localImagId.style.width = "250px";
                         localImagId.style.height = "200px";
                         //图片异常的捕捉，防止用户修改后缀来伪造图片
                 try{
                         localImagId.style.filter="progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";
                         localImagId.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = imgSrc;
                     }catch(e){
                         alert("您上传的图片格式不正确，请重新选择!");
                         return false;
                    }
                         imgObjPreview.style.display = 'none';
                         document.selection.empty();
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
                <li class="btn btn-inverse"><a title="" href="cleanSession.jsp"><i class="icon icon-share-alt"></i> <span class="text">退出</span></a></li>
            </ul>
        </div>

	<div id="sidebar">
		<a href="#" class="visible-phone"><i class="icon icon-th-list"></i>
			Tables</a>
		<ul>
			<li><a href="StudentAction!backIndex"><i class="icon icon-home"></i> <span>学生基本信息</span>
			</a></li>

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
				class="icon-home"></i>学生基本信息</a> <a href="#" class="current">报修单设置项</a>
		</div>
		<div class="container-fluid">
			<div class="row-fluid">
				<div class="span12">
					<div class="widget-box">
						<div class="widget-title">

							<h5>你所在宿舍报修单状况</h5>
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
											</tr>
										</thead>
										<tbody>
                  <s:iterator value="arrayList" var="order">
					<tr class="success">
						<td>
							<s:property value="#order.orderId"/>
						</td>
						<td>
							<s:property value="#order.studentId"/>
						</td>
						<td>
							<s:property value="#order.stuName"/>
						</td>
						<td>
							<s:property value="#order.address"/>
						</td>
						<td>
							<s:property value="#order.workerId"/>
						</td>
						<td>
							<s:if test="%{#order.deal!=0}">
							<p>是</p>
							</s:if>
							<s:else> <p>否</p></s:else>
						</td>
                         <td>
							<p><a href="OrderAction!stuDetailOrder?order.orderId=${order.orderId}">详细查看</a></p>
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
												<li><a
													href="OrderAction!StudentCheckOrder?page=${p}"><s:property value="#p" />
												</a></li>
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
								<h5>下面你可以提交新的报修单</h5>
							</div>
							<div class="widget-content nopadding">
								<form action="OrderAction!uploadNewOrder" method="post" class="form-horizontal" enctype="multipart/form-data" onsubmit="return check();">
									<div class="control-group">
								 <label class="control-label" for="inputPassword">图片上传</label>
                                    <div class="controls">
				                        <input type="file" name="image" id="doc" onchange="javascript:setImagePreview();">
									</div>
									 <p><div id="localImag"><img class="img-polaroid" id="preview" width=-1 height=-1 style="diplay:none" src="img/2.jpg"/></div></p>
									<div class="control-group">
										<label class="control-label">报修详情</label>
										<div class="controls">
											<textarea class="nav-stacked" id="status"  name="order.message"  rows="6" cols="40" onkeydown='countChar("status","counter");' onkeyup='countChar("status","counter");'></textarea>
										</div>
									</div>
													<div class="control-group">
				         <label class="control-label" for="inputPassword">还可以输入的字数:</label>
				    <div class="controls">
				     <span class="label badge-important" contenteditable="true" id="counter">140</span>
				     
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

