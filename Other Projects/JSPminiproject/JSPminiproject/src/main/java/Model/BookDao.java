package Model;

import java.awt.print.Book;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDao implements Dbservice
{
String url="jdbc:mysql://localhost:3306/db", user="root", pass="root";
PreparedStatement ps;
Connection con=null;

public Connection getConnection() throws ClassNotFoundException, SQLException
{
	Class.forName("com.mysql.cj.jdbc.Driver");
	con=DriverManager.getConnection(url,user,pass);
	return con;
	
}
public BookDao() throws ClassNotFoundException, SQLException
{
	con=getConnection();
}
public boolean insertBook(BookPojo bobj) throws SQLException
{
	ps=con.prepareStatement("insert into book values(?,?,?,?)");
	ps.setInt(1, bobj.getBid());
	ps.setString(2, bobj.getBname());
	ps.setString(3, bobj.getAuthor());
	ps.setInt(4, bobj.getPrice());
	int rows=ps.executeUpdate();
	if(rows>0)
		return true;
	else
		return false;
	
	
}
public boolean updateBook(BookPojo bobj) throws SQLException
{
	ps=con.prepareStatement("update book set bname=?,author=?,price=? where bid=?");
	
	ps.setString(1, bobj.getBname());
	ps.setString(2, bobj.getAuthor());
	ps.setDouble(3, bobj.getPrice());
	ps.setInt(4, bobj.getBid());
	
	int rows=ps.executeUpdate();
	if(rows>0)
		return true;
	else 
		return false;
		
}
public boolean deleteBook(int bid) throws SQLException
{
	ps=con.prepareStatement("delete from book where bid=?");
	ps.setInt(1, bid);
	
	int rows=ps.executeUpdate();
	if(rows>0)
		return true;
	else 
		return false;
}
  public List <BookPojo> showAll() throws SQLException
{
	ps=con.prepareStatement("select * from book");
	ResultSet rs=ps.executeQuery();
	//create a booklist
	List<BookPojo> blist=new ArrayList<BookPojo>();
	while(rs.next())
	{
		BookPojo b=new BookPojo();
		b.setBid(rs.getInt(1));
		b.setBname(rs.getString(2));
		b.setAuthor(rs.getString(3));
		b.setPrice(rs.getInt(4));
		
		//insert b into blist
		blist.add(b);
	}
	return blist;
}
public BookPojo Search(int bid) throws SQLException
{
	ps=con.prepareStatement("select * from book where bid=?");
	ps.setInt(1, bid);
	ResultSet rs=ps.executeQuery();
	BookPojo b=null;
	if(rs.next())
	{
		b=new BookPojo();
		b.setBid(rs.getInt(1));
		b.setBname(rs.getString(2));
		b.setAuthor(rs.getString(3));
		b.setPrice(rs.getInt(4));
	}
	return b;
}

}
