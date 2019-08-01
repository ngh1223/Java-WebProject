<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="https://fonts.googleapis.com/css?family=Sunflower:300&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Black+Han+Sans&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Monoton&display=swap" rel="stylesheet">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script> 
<script src="../js/bootstrap.js"></script>
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<style>
* {
	margin: 0;
	padding: 0;
}

li {
	list-style: none;
}

a {
	text-decoration: none;
	color: black;
}

a:visited {
	text-decoration: none;
}

#ntc {
	margin: 0 auto;
	width: 40%;
}

textarea {
	width: 100%;
	border: 0 solid #fff;
	background-color: #F2F2F2;
}

input[type=submit] {
	width: 50px;
	height: 25px;
	background-color: #A69A94;
	color: #fff;
	font-size: 15px;
	border-style: none;
}
input[type=button] {
	width: 50px;
	height: 25px;
	background-color: #A69A94;
	color: #fff;
	font-size: 15px;
	border-style: none;
}
#fork{
	position:fixed;
 	bottom: 50px;
    right: 2%;
    width: 90px;
   }
</style>
</head>
<body>
<!----------------- 네비게이션  시작-------------------->
	<jsp:include page ="/WEB-INF/nav/nav.jsp"/>
	<script>
		$(document).ready(function(){
			$('#notice').addClass('active');
		});
	</script>
<!----------------- 네비게이션  끝------------------------>
<%
		String userID = null;
		String company_ID = null;
		if (session.getAttribute("userID") != null || session.getAttribute("company_ID") != null){
			userID = (String)session.getAttribute("userID");
			company_ID = (String)session.getAttribute("company_ID");
		}
%>
<%
if(userID==null){
%>
<script>
$(document).ready(function(){
	alert("로그인 후에 사용할 수 있습니다.");
	location.href = "../member/login.jsp";
});
</script>
<%
} else if(userID.equals("admin")){
%> 
	<div id="ntc">
	<br>
		<h2>공지사항 작성</h2>
		<hr>
		<form action="writtenNotice.jsp" method="post" enctype="multipart/form-data">
			<div>
				<textarea rows="1" cols="80" name="title" placeholder="타이틀을 입력해주세요"></textarea><br> 
				<input type="file" name="photo"> <br>
				<textarea rows="30" cols="80" name="con" placeholder="내용을 입력해주세요"></textarea><br> 
				<input type="submit" value="확인" name="submit"> <input type="button" value="취소" name="calcel" id="cancel">
			</div>
		</form>
	</div>
	<script>
		$(document).ready(function() {
			$("#cancel").on("click",function(){
				location.href = "noticeList.jsp";
			});
		})
	</script>
	 <%
}else {
%>
<script>
$(document).ready(function(){
	alert("관리자만 작성할 수 있는 페이지입니다.\n일반회원은 뽈레/잡답 게시판을\n사업자 회원은 광고 게시판을 이용해주세요");
	location.href = "../main.jsp";
});
</script>
<%
}
%>
<br>
<br>
<img src="../img/fork.png" id="fork">
</body>
</html>