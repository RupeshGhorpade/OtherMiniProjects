import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
public class LibraryManagement  extends JFrame implements ActionListener
{
JLabel lblId,lblName,lblAuthor,lblPrice;
JTextField txtId,txtName,txtAuthor,txtPrice;
JButton btnInsert,btnUpdate,btnDelete,btnSearch,btnShowAll,btnClear;
Container cp;
String url="jdbc:mysql://localhost:3306/db",
	user="root",pass="root";
	Connection con;
	PreparedStatement ps;
	
	public void createConnection()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,user,pass);
			
		}catch(Exception e) {
		e.printStackTrace();
		}
	}
	public LibraryManagement(String t)
	{
		super(t);
		createConnection();
		cp=getContentPane();
		cp.setLayout(new GridLayout(7,2,5,5));
		
		lblId=new JLabel("BookId");
		txtId=new JTextField();
		cp.add(lblId);
		cp.add(txtId);
		
		lblName=new JLabel("BookName");
		txtName=new JTextField();
		cp.add(lblName);
		cp.add(txtName);
		
		lblAuthor=new JLabel("Author");
		txtAuthor=new JTextField();
		cp.add(lblAuthor);
		cp.add(txtAuthor);
		
		lblPrice=new JLabel("Price");
		txtPrice=new JTextField();
		cp.add(lblPrice);
		cp.add(txtPrice);
		
		btnInsert=new JButton("Insert");
		btnInsert.addActionListener(this);
		cp.add(btnInsert);
		
		btnUpdate=new JButton("Update");
		btnUpdate.addActionListener(this);
		cp.add(btnUpdate);
		
		btnDelete=new JButton("Delete");
		btnDelete.addActionListener(this);
		cp.add(btnDelete);
		
		btnSearch=new JButton("Search");
		btnSearch.addActionListener(this);
		cp.add(btnSearch);
		
		btnShowAll=new JButton("ShowAll");
		btnShowAll.addActionListener(this);
		cp.add(btnShowAll);
		
		btnClear=new JButton("Clear");
		btnClear.addActionListener(this);
		cp.add(btnClear);
		setSize(500,500);
		setVisible(true);
		
		
	}
 

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		new LibraryManagement("MyLibrary");
	}

	public void InsertBook(BookPojo obj)
	{
		try{
			ps=con.prepareStatement("insert into book values(?,?,?,?)");
			ps.setInt(1, obj.getBid());
			ps.setString(2,obj.getBname());
			ps.setString(3,obj.getAuthor());
			ps.setDouble(4, obj.getPrice());
			
	
		int ans=ps.executeUpdate();
		
		if(ans>0)
		JOptionPane.showMessageDialog(this,"Record Inserted...");
		
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			
		}
	}
	public void DeleteBook(int bid)
	{
		try {
			ps=con.prepareStatement("delete from book where bid=?");
			ps.setInt(1, bid);
			int ans=ps.executeUpdate();
			
			if(ans>0)
				JOptionPane.showMessageDialog(this,"Record Deleted...");
			else
				JOptionPane.showMessageDialog(this,"Record not Found..");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	public void UpdateBook(BookPojo obj)
	{
		try
		{
			ps=con.prepareStatement("Update Book set bname=?,author=?,price=? where bid=?");
			ps.setString(1,obj.getBname());
			ps.setString(2,obj.getAuthor());
			ps.setDouble(3,obj.getPrice());
			ps.setInt(4,obj.getBid());
			int ans=ps.executeUpdate();
			
			if(ans>0)
				JOptionPane.showMessageDialog(this,"Record Update");
			else
				JOptionPane.showMessageDialog(this, "Record not Found...");
			
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	public void SearchBook(int bid)
	{
		try {
			ps=con.prepareStatement("select * from book where bid=?");
			ps.setInt(1, bid);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				txtName.setText(rs.getString(2));
				txtAuthor.setText(rs.getString(3));
				txtPrice.setText(""+rs.getDouble(4));
			}
			else
				JOptionPane.showMessageDialog(this,"Record not Found");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	

	
	
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		if(e.getSource()==btnInsert)
			{
			int i=Integer.parseInt(txtId.getText());
			String nm=txtName.getText();
			String au=txtAuthor.getText();
			double p=Double.parseDouble(txtPrice.getText());
			
			BookPojo obj=new BookPojo(i,nm,au,p);
			InsertBook(obj);
			
		}
		else if(e.getSource()==btnDelete)
		{
		int bid=Integer.parseInt(txtId.getText());
		DeleteBook(bid);
		}
		else if(e.getSource()==btnUpdate)
		{
			int i=Integer.parseInt(txtId.getText());
			String nm=txtName.getText();
			String au=txtAuthor.getText();
			double p=Double.parseDouble(txtPrice.getText());
			BookPojo obj=new BookPojo(i,nm,au,p);
			UpdateBook(obj);
			
		}
		else if(e.getSource()==btnSearch)
		{
			int bid=Integer.parseInt(txtId.getText());
			SearchBook(bid);
		}
		else if(e.getSource()==btnClear)
		{
			txtId.setText("");
			txtName.setText("");
			txtAuthor.setText("");
			txtPrice.setText("");
		}
	}
}
	
	
