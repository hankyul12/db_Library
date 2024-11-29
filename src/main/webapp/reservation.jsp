
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="db.ReservationDAO" %>
<%
	String bookId = request.getParameter("id");
	String memberId = request.getParameter("memberId");
	ReservationDAO reservationDAO = new ReservationDAO();
	Boolean temp = reservationDAO.processReservation(memberId,Integer.parseInt(bookId));
	out.print(temp);
%>
