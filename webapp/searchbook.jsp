
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.net.URLDecoder" %>
<%@ page import="db.BookDAO" %>
<%
	request.setCharacterEncoding("UTF-8");
	String title = request.getParameter("text");
	title.trim();
	
	String type = request.getParameter("type");
	type.trim();
	
	BookDAO bookDAO = new BookDAO();
	String temp = bookDAO.getBook_search(type, title);
	out.println(temp);
			
%>
	