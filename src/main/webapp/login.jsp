<%--
  Created by IntelliJ IDEA.
  User: zengjiayi
  Date: 2021/4/11
  Time: 16:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="textml;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1>Login</h1>
<%
    if (!(request.getAttribute("message")==null)){
        out.println(request.getAttribute("message"));
    }
%>
<form method="post" action="login">
    <table>
        <tr> <td>username:</td> <td><input type="text" name="username" required><br/></td></tr>
        <tr> <td>password:</td> <td><input type="password" name="password" required minlength="8"><br/></td></tr>
        <tr> <td></td><td><input type="submit" value="Login"/></td>  </tr>
    </table>
</form>
<%@include file="footer.jsp"%>
