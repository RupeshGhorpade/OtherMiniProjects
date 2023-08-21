package com.spring.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class BookDao 
{
JdbcTemplate jt;



public void setJt(JdbcTemplate jt) {
	this.jt = jt;
}
public int SaveBook(Book b)
{
	String q="insert into book values(?,?,?,?)";
			return jt.update(q,b.getBid(),b.getBname(),b.getAuthor(),b.getPrice());
}
public int UpdateBook(Book b)
{
	String q="Update  book set bname=?,author=?,price=? where bid=?";
	return jt.update(q,b.getBname(),b.getAuthor(),b.getPrice(),b.getBid());
	
}
public int deleteBook(int i)
{
	String q="delete from book where bid=?";
	return jt.update(q,i);
}
public List<Book>Showall()
{
	List<Book> blist=new ArrayList<Book>();
	jt.query("Select * from book",new RowMapper<Book>()

			{

				@Override
				public Book mapRow(ResultSet  rs, int rowno) throws SQLException 
				{
					// TODO Auto-generated method stub
					Book b=new Book(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4));
					blist.add(b);
					
					return b;
				}
			});
	return blist;
	
			
}
}
