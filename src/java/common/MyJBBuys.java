package common;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

public class MyJBBuys
{
    int bkid, uid;

    public int getBkid() {
        return bkid;
    }

    public void setBkid(int bkid) {
        this.bkid = bkid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }
    
//profilepic
 public int saveBuysFromBkid(int bkidn, String email)
 {
  int i = 0;
  try
  {
        bkid = bkidn;
	Connection con = ConnectionProvider.getConnection();
        PreparedStatement pstmt1 = con.prepareStatement("select uid from user where email = ?");
	pstmt1.setString(1,email);
        ResultSet rset = pstmt1.executeQuery();
        if(rset.next())
            uid = rset.getInt(1);
	PreparedStatement pstmt2 = con.prepareStatement("insert into buys values(?,?)");
	pstmt2.setInt(1,bkid);
	pstmt2.setInt(2,uid);
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

 public boolean isBuysFromBkidUid(int bkid, int uid)
 {
	boolean flag = false;
	try
	{
	Connection con = ConnectionProvider.getConnection();
	PreparedStatement pstmt = con.prepareStatement("select * from buys where bkid=? and uid=?");
	pstmt.setInt(1,bkid);
        pstmt.setInt(2,uid);
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
// public boolean findBuysFromBkid(int bkid)
// {
//	boolean flag = false;
//	try
//	{
//	Connection con = ConnectionProvider.getConnection();
//	PreparedStatement pstmt = con.prepareStatement("select * from buys where bkid=?");
//	pstmt.setInt(1,bkid);
//	ResultSet rset = pstmt.executeQuery();
//	if(rset.next())
//	{
//	    setBkid(rset.getInt(2));
//	    flag=true;
//	}
//	pstmt.close();
//	rset.close();
//	con.close();
//	}catch(Exception e)
//	{
//		e.printStackTrace();
//	}
//	 
//	 return flag;
// }
// public ArrayList findBuysFromUid(int uid)
// {
//	boolean flag = false;
//	try
//	{
//	Connection con = ConnectionProvider.getConnection();
//	PreparedStatement pstmt = con.prepareStatement("select * from buys where uid=?");
//	pstmt.setInt(1,uid);
//	ResultSet rset = pstmt.executeQuery();
//	if(rset.next())
//	{
//	    setUid(rset.getInt(1));
//	    flag=true;
//	}
//	pstmt.close();
//	rset.close();
//	con.close();
//	}catch(Exception e)
//	{
//		e.printStackTrace();
//	}
//	 
//	 return flag;
// } 
}
