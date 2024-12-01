<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="db.BookDAO" %>

<%
	request.setCharacterEncoding("UTF-8");

	BookDAO bookDAO = new BookDAO();
	String temp = bookDAO.getAllBooks();
	temp.trim();
	// 로그인 결과 출력
	out.print(temp);
%>