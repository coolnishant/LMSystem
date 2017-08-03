package common;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class MyJBUser 
{
 String name,password,email,gender,city,country;
 String dob;
 int balance,uid;
 long contact;
 //profilepic
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}

public long getContact() {
	return contact;
}
public void setContact(long contact) {
	this.contact = contact;
}
 public int saveUser()
 {
  int i = 0;
  try
  {
	Connection con = ConnectionProvider.getConnection();
	uid = 0;
        String string = "January 2, 2010";
        DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
        Date dob = (Date) format.parse(string);
//        System.out.println(date);
	PreparedStatement pstmt2 = con.prepareStatement("insert into user values(?,?,?,?,?,?,?,?)");
	pstmt2.setString(2,name);
	pstmt2.setString(3,email);
	pstmt2.setString(4,password);
	pstmt2.setString(5,gender);
	pstmt2.setDate(6,dob);
	pstmt2.setString(7,country);
	pstmt2.setString(8,city);
	pstmt2.setLong(9,contact);
//	pstmt2.setLong(10,profilpic);
	pstmt2.setInt(11,balance);
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
 public boolean findUser(String email, String password)
 {
	boolean flag = false;
	try
	{
	Connection con = ConnectionProvider.getConnection();
	PreparedStatement pstmt = con.prepareStatement("select * from user where email=? and password=?");
	pstmt.setString(1,email);
	pstmt.setString(2,password);
	ResultSet rset = pstmt.executeQuery();
	if(rset.next())
	{
	    setName(rset.getString(2));
            setEmail(rset.getString(3));
            setGender(rset.getString(5));
            setDob(rset.getString(6));
            setCountry(rset.getString(7));
            setCity(rset.getString(8));
            setContact(rset.getLong(9));
            setBalance(rset.getInt(10));
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
 public boolean findFromEmail(String email)
 {
	boolean flag = false;
	try
	{
	Connection con = ConnectionProvider.getConnection();
	PreparedStatement pstmt = con.prepareStatement("select * from user where email=?");
	pstmt.setString(1,email);
	ResultSet rset = pstmt.executeQuery();
	if(rset.next())
	{
            setName(rset.getString(2));
            setEmail(rset.getString(3));
//            setEmail(rset.getString(4)); //password
            setEmail(rset.getString(5)); //gender
            setDob(rset.getString(6)); //dob
            setCountry(rset.getString(7)); //country
            setCity(rset.getString(8)); //city
            setContact(rset.getLong(9)); //contact
            setBalance(rset.getInt(10)); //balance 
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

public int saveUserBalance(String email, int nbal)
{
  int i = 0;
  try
  {
        balance = nbal;
	Connection con = ConnectionProvider.getConnection();
	this.uid = uid;
//        System.out.println(date);
	PreparedStatement pstmt2 = con.prepareStatement("update user set balance = ? where email = ?");
	pstmt2.setInt(1,nbal);
        pstmt2.setString(2,email);
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
}
