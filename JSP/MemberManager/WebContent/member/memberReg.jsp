<%@page import="member.LoginInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>

<jsp:useBean id="memberInfo" class="member.Member"/>
<jsp:setProperty property="*" name="memberInfo"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/mm/css/default.css" rel="stylesheet" type="text/css">
<style>
</style>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
</head>
<body>
<%
	if(memberInfo.getuPhoto()==null){
		memberInfo.setuPhoto("noimg.jpg");
	}
	//내장 객체에 회원정보 객체를 저장
	application.setAttribute(memberInfo.getuId(),memberInfo);
%>

	<!-- 헤더 시작  -->
	<%@ include file="../frame/header.jsp" %>
	<!-- 헤더 끝  -->
	
	<!-- 네비게이션 시작  -->
	<%@ include file="../frame/nav.jsp" %>
	<!-- 네비게이션 끝  -->
	
	<!-- 컨텐츠 시작  -->
	<div id="contents">
		<h3>회원가입 요청 처리 페이지</h3>
		<hr>
			<table>
				<tr>
					<td>아이디(이메일)</td>
					<td>${memberInfo.uId}</td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td>${memberInfo.uPw}</td>
				</tr>
				<tr>
					<td>이름</td>
					<td>${memberInfo.uName}</td>
				</tr>
			</table>
	</div>
	<!-- 컨텐츠 끝  -->
	
	<!-- 풋터 시작  -->
	<%@ include file="../frame/footer.jsp" %>
	<!-- 풋터 끝  -->
</body>
</html>