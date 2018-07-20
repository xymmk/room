<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <title>学生注册页面</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">

        <!-- CSS -->
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/style.css">

        <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
            <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->
        <script type="text/javascript" charset="utf-8">
           function check(){
            var name=$("#name").val();
            var username=$("#username").val();
            var password=$("#password").val();
            var surePassword=$("#surePassword").val();
            var roomId=$("#roomId").val();
            if(name==''||name==null||name.length>10||
               username==''||username==null||username.length>15||
               password==''||password==null||password.length>15||
               surePassword==''||surePassword==null||surePassword.length>15||
               roomId==''||roomId==null||roomId.length>6){
                   alert("输入空值或字符溢出");
                   return false;
               }
               else{
                  if(surePassword!=password){
                     alert("确认密码不相符");
                     return false;
                  }
               }
               //alert(username);
               return true;
           }
        </script>

    </head>

    <body>

        <div class="header">
            <div class="container">
                <div class="row">
                    <div class="logo span4">
                          <h1><a href="register.html"><span><-BACK</span></a></h1>
                    </div>
                </div>
            </div>
        </div>

        <div class="register-container container">
            <div class="row">
                <div class="iphone span5">
                    <img src="img/iphone.png" alt="">
                </div>
                <div class="register span6">
                    <form action="RegisterAction!register_stu" method="post" onsubmit="return check();">
                        <h2>注册学生账号</h2>
                        <label for="name">学生姓名</label>
                        <input type="text" id="name" name="student.name" placeholder="请输入你的真实姓名">
                        <label for="username">用户名</label>
                        <input type="text" id="username" name="student.username" placeholder="请输入你的登录用户名">
                        <label for="password">密码</label>
                        <input type="password" id="password" name="student.password" placeholder="请输入登录密码">
                        <label for="surePassword">确认密码</label>
                        <input type="password" id="surePassword"placeholder="请确认一次密码">
                        <label for="address">宿舍地址</label>
                        <input type="text" id="roomId" name="student.roomId" placeholder="请输入你的宿舍编号">
                        <button type="submit">注册</button>
                    </form>
                </div>
            </div>
        </div>

        <!-- Javascript -->
        <script src="js/jquery-1.8.2.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery.backstretch.min.js"></script>
        <script src="js/scripts.js"></script>

    </body>

</html>
