<%@page import="member.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	String userId = request.getParameter("uId");
	String userPw = request.getParameter("uPw");
	
	//1.사용자가 입력한 id로 회원정보 검색
	//2.존재 : 해당 객체를 받는다. -> 해당 객체의 pw와 사용자가 입력한 pw를 비교; 같다면 - 로그인 처리 : 세션 영역에 회원 정보를 저장 틀리면- 오류메세지 전달>로그인 페이지로 이동
	//3.존재안함 : 오류메세지 전달>로그인 페이지로 이동
	
	Member memberInfo = (Member)application.getAttribute(userId);

	if(memberInfo != null && memberInfo.getuPw().equals(userPw)){
		//회원 정보가 존재 && 비밀번호 일치
		//세션에 회원 로그인 정보 저장	
		session.setAttribute("loginInfo", memberInfo.toLoginInfo());
		if(request.getParameter("idSave")!=null){
			session.setAttribute("savedId", memberInfo.getuId() );
		}else{
			session.setAttribute("savedId", null);
		}
		//로그인 처리후 메인 페이지로 이동
		response.sendRedirect(request.getContextPath());
	}else{
		//아이디 검색 결과가 null 또는 pw 비교해서 같지 않은 경우
		out.print("<script>alert('아이디 혹은 비밀번호가 틀립니다. \\n 다시 로그인 해주세요.'); history.go(-1);</script>");
	}
	
%>
<%-- 
	<!-- 헤더 시작  -->
	<%@ include file="../frame/header.jsp" %>
	<!-- 헤더 끝  -->
	
	<!-- 네비게이션 시작  -->
	<%@ include file="../frame/nav.jsp" %>
	<!-- 네비게이션 끝  -->
	
	<!-- 컨텐츠 시작  -->
	<div id="contents">
	
		<h3>로그인 요청 처리 페이지</h3>
		<hr>
		<table>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="uId" value="<%=userId%>"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="uPw" name="uId" value="<%=userPw%>"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="로그인"></td>
			</tr>
		</table>
	</div>
	<!-- 컨텐츠 끝  -->
	
	<!-- 풋터 시작  -->
	<%@ include file="../frame/footer.jsp" %>
	<!-- 풋터 끝  -->
</body>
</html> --%>