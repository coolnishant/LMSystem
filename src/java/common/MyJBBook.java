package common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Nishant
 */
public class MyJBBook {
    int bkid, cid;
    String locpdf, free, bname;
    int bprice;

    public String getLocpdf() {
        return locpdf;
    }

    public void setLocpdf(String locpdf) {
        this.locpdf = locpdf;
    }

    public String getFree() {
        return free;
    }

    public void setFree(String free) {
        this.free = free;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public int getBprice() {
        return bprice;
    }

    public void setBprice(int bprice) {
        this.bprice = bprice;
    }
    public int saveBook()
 {
  int i = 0;
  try
  {
	Connection con = ConnectionProvider.getConnection();
	PreparedStatement pstmt2 = con.prepareStatement("insert into book values(?,?,?,?)");
	pstmt2.setInt(2,cid);
//	pstmt2.setString(3,locpdf);
        pstmt2.setString(4,free);
	pstmt2.setString(5,bname);
	pstmt2.setInt(6,bprice);
	
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
  
 public boolean findFromBId(int bkid)
 {
	boolean flag = false;
	try
	{
	Connection con = ConnectionProvider.getConnection();
	PreparedStatement pstmt = con.prepareStatement("select * from book where bkid=?");
        pstmt.setInt(1, bkid);
	ResultSet rset = pstmt.executeQuery();
	if(rset.next())
	{
            setFree(rset.getString(4));
            setBname(rset.getString(5));
            setBprice(rset.getInt(6));
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
