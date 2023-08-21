package com.spring.model;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class HomeController 
{
ApplicationContext ctx=new ClassPathXmlApplicationContext("spring.xml");
BookDao dao=ctx.getBean("dao",BookDao.class);
@RequestMapping("insert")
public ModelAndView add(HttpServletRequest req,HttpServletResponse res)
{
	int bid=Integer.parseInt(req.getParameter("bid"));
	String bname=req.getParameter("bname");
	String author=req.getParameter("author");
	Double p=Double.parseDouble(req.getParameter("price"));
	
	Book b=new Book(bid,bname,author,p);
	
	int r=dao.SaveBook(b);
	return new ModelAndView("result","msg","insertion sucessful...");
}

@RequestMapping("update")
public ModelAndView update(HttpServletRequest req,HttpServletResponse res)
{
	int bid=Integer.parseInt(req.getParameter("bid"));
	String bname=req.getParameter("bname");
	String author=req.getParameter("author");
	double p=Double.parseDouble(req.getParameter("price"));
	
	Book b=new Book(bid,bname,author,p);
	int r=dao.UpdateBook(b);
	if(r>0)
		return new ModelAndView("result","msg","record updated");
	else
		return new ModelAndView("result","msg","record not found");
}
@RequestMapping("delete")
public ModelAndView delete(HttpServletRequest req,HttpServletResponse res)
{
	int bid=Integer.parseInt(req.getParameter("bid"));

	int r=dao.deleteBook(bid);
	if(r>0)
		return new ModelAndView("result","msg","record deleted");
	else
		return new ModelAndView("result","msg","record not found");
	
}
@RequestMapping("showall")
public ModelAndView show()
{
	List<Book>blist=dao.Showall();
	
	return new ModelAndView("showall","blist",blist);
}
}
