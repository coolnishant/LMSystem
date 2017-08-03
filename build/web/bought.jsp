<%-- 
    Document   : bought
    Created on : 14 Jul, 2017, 12:54:56 AM
    Author     : Nishant
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <body>
        <jsp:useBean id="mybeanuser" class="common.MyJBUser"/>
        <jsp:setProperty property="*" name="mybeanuser"/>
        <jsp:useBean id="mybeanbuys" class="common.MyJBBuys"/>
        <jsp:setProperty property="*" name="mybeanbuys"/>
        <%
            String email = request.getParameter("email");
            int newbal = Integer.parseInt(request.getParameter("newbal"));
            int bkid = Integer.parseInt(request.getParameter("bid"));
            mybeanuser.saveUserBalance(email, newbal);  
            out.print(email +"\n"+ newbal);
            mybeanbuys.saveBuysFromBkid(bkid, email);
        %>
        <h1>Bought!</h1>
    </body>
</html>
