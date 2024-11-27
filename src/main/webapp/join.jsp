<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="db.MemberDAO" %>
<%
    request.setCharacterEncoding("UTF-8");

    String inputId = request.getParameter("num1");
    String inputPw = request.getParameter("num2");

    // MemberDAO 객체 생성
    MemberDAO memberDAO = new MemberDAO();
    String loginResult = memberDAO.login(inputId, inputPw);

    // 로그인 결과 출력
    out.print(loginResult);
%>
