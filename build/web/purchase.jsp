<%-- 
    Document   : purchase
    Created on : 13 Jul, 2017, 10:50:15 AM
    Author     : Nishant
--%>

<%@page import="java.sql.*"%>
<%@page import="common.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="javax.servlet.http.*,javax.servlet.http.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <jsp:useBean id="mybeanuser" class="common.MyJBUser"/>
    <jsp:setProperty property="*" name="mybeanuser"/>
    <jsp:useBean id="mybeanbook" class="common.MyJBBook"/>
    <jsp:setProperty property="*" name="mybeanbook"/>
    <%
        String bookname = request.getParameter("bname");
        String name;
        
//        session = request.getSession(false);
//        String email = (String) session.getAttribute("uemail");
        
        String email = "pawan@gmail.com";
        int balance = 0;
        int bprice = 0;
//        int bid = request.getParameter("bid");
        int bid = 1;
        String bname ="";
        mybeanbook.findFromBId(bid);
        bname = mybeanbook.getBname();
        bprice = mybeanbook.getBprice();
        out.print(balance+" "+bprice);
        if(mybeanuser.findFromEmail(email))
        {
          name = mybeanuser.getName();
          balance = mybeanuser.getBalance();
        }
        else{%>
            
            <jsp:include page="index.jsp" />
        <%
        }
        if(balance<bprice){
   %>
            <h3>Chuitye Ho kya</h3>
        <%}
        else if(bprice == 0)
        {
        %>
                <h1>File is For Free download it</h1>
        <%
        }
        else{    
                Connection con = ConnectionProvider.getConnection();
		if(!email.contains("@")){
                    //TODO on no session
                    out.print("<a href = index.jsp>Please Login<//a>");
                }
                else{
                    %>
                    <table>
                        <tr>
                            <td><label>User Balance: </label></td>
                            <td><% out.print(balance);%></td>
                        </tr>
                        <tr>
                            <td><label>Book Cost: </label></td>
                            <td><% out.print(bprice);%></td>
                        </tr>
                        <tr>
                            <td><label>new Balance: </label></td>
                            <td><% out.print(balance-bprice);%></td>
                        </tr>
                        <form action ="bought.jsp" method="post">
                            <tr>
                                <td>
                                <input type="checkbox" name="buy" value="Buy" id="checkbx" required="required">Buy<BR>
                                <input type="hidden" value="<%out.print(balance-bprice);%>" name="newbal"/>
                                <input type="hidden" value="<%out.print(email);%>" name="email"/>
                                <input type="hidden" value="<%out.print(bid);%>" name="bid"/>
                                </td>
<!--                            </td>
                            <td>-->
                                <td>
                                    <input type="submit" value="okay"/>
                                </td>
                            </tr>
                        </form>
                        </table>
                        

                    <%
                }
            }
	%>
        </body>
</html>
