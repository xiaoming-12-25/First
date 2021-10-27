<%--
  Created by IntelliJ IDEA.
  User: 29081
  Date: 2021/10/19
  Time: 16:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv="Cache-Control" content="no-cache">
    <meta http-equiv="Expires" content="0">
    <title>后台管理</title>
    <link href="login.css" rel="stylesheet" type="text/css" />
    <script src="../static/jquery/jquery.min.js"></script>
    <script src="../static/easyui/jquery.easyui.min.js"></script>
</head>
<body>
<div class="login_box">
    <div class="login_l_img"><img src="images/login-img.png" /></div>
    <div class="login">
        <div class="login_logo"><a href="#"><img src="images/login_logo.png" /></a></div>
        <div class="login_name">
            <p>后台管理系统</p>
        </div>
        <form method="post" id="myform">
            <input name="username" id="name" type="text"  placeholder="用户名" required />
            <span id="nameerr"></span>
            <input name="password" id="password" type="password" id="password"  placeholder="密码" />
            <input type="text" name="code" placeholder="验证码" autocomplete="off">
            <span id="errcode"></span>
            <img src="/ver.do" id="img"><br/>
            <input type="checkbox" id="chee" name="che" value="记住"><span id="jizhu"> 记住密码?</span>
            <input value="登录" style="width:100%;margin-top: 10px" type="submit">
        </form>
    </div>
</div>
<div style="text-align:center;">
</div>
<script>
    $(document).ready(function (){
        //失去焦点将用户名的内容提交到后台进行判断是否正确
        $("#name").blur(function (e){
            // e.preventDefault(); 阻止默认提交方式get
            e.preventDefault();
            // 提交方式     $(this).serialize() 将其序列化
            $.post("/login.do",$(this).serialize(),
            //回调函数获取后台传回来的数据
            function (data){
                if (!data.err){
                    $("#nameerr").html(data.msg)
                    $("#nameerr").css("color","red")
                }else {
                    $("#nameerr").html(data.msg)
                    $("#nameerr").css("color","green")
                }
                // json 以json格式接受
            },"json")
        })
        //点击验证码图片刷新
        //?time="+new Date().getTime()) ：避免因浏览器缓存而不刷新的问题
        $("#img").click(function (){
            $(this).attr("src","/ver.do?time="+new Date().getTime())
        })
        //提交表单数据到后台
        $(function login() {
            $("#myform").submit(function (e){
                e.preventDefault();
                $.post("/register.do",$(this).serialize(),
                    //回调函数获取后台传回来的数据
                    function (data){
                        if (data.state){
                            $("#errcode").html(data.errmessage)
                            $("#errcode").css("color","green")
                            //登录成功后要跳转的路径
                            document.location.href="../manage/jsp/index.jsp"
                        }else {
                            $("#errcode").html(data.errmessage)
                            $("#errcode").css("color","red")
                        }
                    },"json")
            })
            //回车登录
            $("#myform").keydown(function() {
                if (event.keyCode == "13") {//keyCode=13是回车键
                    login();
                }
            });
        })
        })

</script>
</body>
</html>
