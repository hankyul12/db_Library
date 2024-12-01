
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="db.BookDAO" %>
<%
	request.setCharacterEncoding("UTF-8");
	String inputID = request.getParameter("id");
	BookDAO bookDAO = new BookDAO();
	String temp = bookDAO.getBook_Num(inputID);
	temp.trim();
	out.print(temp);

%>