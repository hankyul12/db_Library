
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.net.URLDecoder" %>
<%@ page import="db.BookDAO" %>
<%
	request.setCharacterEncoding("UTF-8");
	String title = request.getParameter("text");
	title.trim();
	
	BookDAO bookDAO = new BookDAO();
	String temp = bookDAO.getBook_title(title);
	temp.trim();
	out.print(temp);
%>
	