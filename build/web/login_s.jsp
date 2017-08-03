<%-- 
    Document   : login_s
    Created on : 14 Jul, 2017, 9:42:47 PM
    Author     : Nishant
--%>

<%@page import="common.MyJBUser"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:useBean id="myjbuser" class="common.MyJBUser"/>
        <jsp:setProperty name="myjbuser" property="*"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%
            if(!myjbuser.findUser(myjbuser.getEmail(),myjbuser.getPassword())){
        %>
        <title>Logined in <%= myjbuser.getName() %> In Page</title>
        
    <h1>Error Login</h1>
    <jsp:include page="signlogin.jsp"/>
        <%
            session.invalidate();
        }
else{
        
        %>
    </head>
    <body>
        <table>
            <tr>
                <td><%= myjbuser.getName() %></td>
            </tr>
            <tr>
                <td><%= myjbuser.getEmail()%></td>
            </tr>
            <tr>
                <td><%= myjbuser.getGender()%></td>
            </tr>
            <tr>
                <td><%= myjbuser.getCity()%></td>
            </tr>
        </table>
        <%
            session.setAttribute("email", myjbuser.getEmail());
            session.setAttribute("userdata", myjbuser);
            myjbuser = (MyJBUser) session.getAttribute("userdata");
        }
        %>
    </body>
</html>
