
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="db.LoanDAO" %>
<%
	String bookId = request.getParameter("id");
	String memberId = request.getParameter("memberId");
	LoanDAO loanDAO = new LoanDAO();
	Boolean temp = loanDAO.processLoan(memberId,Integer.parseInt(bookId));
	System.out.println(temp);
	out.print(temp);
%>
