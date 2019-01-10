<%--
  Created by IntelliJ IDEA.
  User: zhangweiming
  Date: 2019-01-10
  Time: 19:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
    <base href="<%=basePath%>">
    <meta charset="UTF-8">
    <title>Basic ValidateBox - jQuery EasyUI Demo</title>
    <link rel="stylesheet" type="text/css" href="themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="themes/icon.css">
    <link rel="stylesheet" type="text/css" href="css/demo.css">
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/jquery.easyui.min.js"></script>
</head>
<body>
<div style="margin:20px 0;"></div>
<div class="easyui-panel" title="用户注册" style="width:400px;padding:10px 60px 20px 60px">
    <table cellpadding="5">
        <tr>
            <td>用户名:</td>
            <td><input class="easyui-validatebox textbox" data-options="required:true,validType:'length[3,10]'"></td>
        </tr>
        <tr>
            <td>密码:</td>
            <td><input class="easyui-validatebox textbox" data-options="required:true,validType:'email'"></td>
        </tr>
        <tr>
            <td>性别:</td>
            <td>
                男：<input type="radio" name="sex" value="1">
                女：<input type="radio" name="sex" value="0">
            </td>
        </tr>
        <tr>
            <td>年龄:</td>
            <td><input class="easyui-validatebox textbox" data-options="required:true"></td>
        </tr>
        <tr>
            <td>出生年月:</td>
            <td><input class="easyui-datebox textbox"></td>
        </tr>
    </table>
</div>
<style scoped="scoped">
    .textbox{
        height:20px;
        margin:0;
        padding:0 2px;
        box-sizing:content-box;
    }
</style>

</body>
</html>