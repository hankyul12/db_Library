
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@page import="java.sql.PreparedStatement"%>
<%@ page import="db.MemberDAO" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 가입 완료</title>
<style>
    h2 {
        color: #AE3A1E; /* 이전에 사용하던 색상으로 변경하세요 */
    }

    button {
        background-color: #F15F5F; /* 이전에 사용하던 색상으로 변경하세요 */
        color: #fff; /* 흰색 텍스트 */
        padding: 10px 20px;
        border: none;
        border-radius: 5px;
        font-size: 16px;
        cursor: pointer;
        transition: background-color 0.3s, color 0.3s;
    }

    button:hover {
        background-color: #CC0000; /* 호버 시 배경색 변경 */
        color: #fff; /* 호버 시 글씨 색상 변경 */
    }
</style>
</head>
<body>

<%
	request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("Member_ID");
	String pw = request.getParameter("Password");
	String name = request.getParameter("Name");
	String contact = request.getParameter("Contact");
	String Email = request.getParameter("Email");
	String address = request.getParameter("Address");
	String memberType = request.getParameter("Member_Type");
	
	

	MemberDAO memberDAO = new MemberDAO();
	int result = memberDAO.joinMember(id, pw, name, contact, Email, address,memberType);
	
	if(result==1){
%>
		<h2>등록 완료!</h2>
		<button onclick="window.location.href='index.jsp'">로그인으로 돌아가기</button>
<%
		} else{ // 실패
%>
		<h2>등록 실패..</h2>
		<button onclick="window.location.href='joinMember.html'">다시 회원가입으로 돌아가기</button>
		<%}%>

</body>
</html>
