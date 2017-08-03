package common;

import java.sql.*;

public class MyJBAdmin 
{
 String username,password;
 int idadmin;
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getIdadmin() {
        return idadmin;
    }

    public void setIdadmin(int idadmin) {
        this.idadmin = idadmin;
    }

 /*public int saveAdmin()
 {
  int i = 0;
  try
  {
	Connection con = ConnectionProvider.getConnection();
	PreparedStatement pstmt2 = con.prepareStatement("insert into empinfo values(?,?)");
	pstmt2.setString(2,username);
	pstmt2.setString(3,password);
	i = pstmt2.executeUpdate();
	if(i!=0)
	{
	 return i;	
	}
	pstmt2.close();
	con.close();
  }catch(Exception e)
  {
	  e.printStackTrace();
  }
  return i;	 
 }
 */
 public boolean findAdmin()
 {
	 boolean flag = false;
	try
	{
	Connection con = ConnectionProvider.getConnection();
	PreparedStatement pstmt = con.prepareStatement("select * from admin where name=? and password=?");
	pstmt.setString(1,username);
	pstmt.setString(2,password);
	ResultSet rset = pstmt.executeQuery();
	if(rset.next())
        {
	  flag=true;
	}
	pstmt.close();
	rset.close();
	con.close();
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	 
	 return flag;
 }
}
