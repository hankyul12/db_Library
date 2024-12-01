<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="db.LoanDAO" %>
<%
	request.setCharacterEncoding("UTF-8");
	String inputID = request.getParameter("id");
	LoanDAO loanDAO = new LoanDAO();
	String temp = loanDAO.getLoansByMemberId(inputID);
	temp.trim();
	out.print(temp);

%>