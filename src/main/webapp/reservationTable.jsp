<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="db.ReservationDAO" %>
<%
    request.setCharacterEncoding("UTF-8");
    String inputID = request.getParameter("id");
    ReservationDAO reservationDAO = new ReservationDAO();
    String reservationRecords = reservationDAO.getReservationsByMemberId(inputID);  // 예약 기록

    reservationRecords.trim();

    out.print(reservationRecords);
%>
