<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en">

    <head>

        <meta charset="utf-8">
        <title>员工注册页面</title>
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
            if(name==''||name==null||name.length>15||username==''||username==null||username.length>15||
                password==''||password==null||password.length>15||surePassword==''||surePassword==null||surePassword.length>15)
            {
               alert("输入空值字符或者字符溢出");
               return false;
            }else{
               if(surePassword!=password){
                   alert("输入密码不一致");
                   return false;
               }
            }
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
                      <form action="RegisterAction!register_wor" method="post" onsubmit="return check();">
                        <h2>注册员工账号</h2>
                        <label for="name">员工姓名</label>
                        <input type="text" id="name" name="worker.name" placeholder="请输入你的真实姓名">
                        <label for="username">用户名</label>
                        <input type="text" id="username" name="worker.username" placeholder="请输入你的登录用户名">
                        <label for="password">密码</label>
                        <input type="password" id="password" name="worker.password" placeholder="请输入登录密码">
                        <label for="surePassword">确认密码</label>
                        <input type="password" id="surePassword" name="surePassword" placeholder="请确认密码">
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

