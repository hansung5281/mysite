<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.sds.icto.mysite.vo.*" %>
<%
	MemberVo vo = (MemberVo)session.getAttribute("authMember");
%>
<!doctype html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="/mysite/assets/css/user.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<div id="header">
		<jsp:include page="/views/include/header.jsp" flush="false"/>
		</div>
		<div id="content">
			<div id="user">

				<form id="join-form" name="joinForm" method="post" action="/mysite/member">
					<input type="hidden" name="a" value="join">
					<label class="block-label" for="name">이름</label>
					<input id="name" name="name" type="text" 
					value="<%=vo.getName()%>">

					<label class="block-label" for="email">이메일</label>
					<input id="email" name="email" type="text"
					value="<%=vo.getEmail()%>">
					<input type="button" value="id 중복체크">
					
					<label class="block-label">패스워드</label>
					<input name="password" type="password" value="">
					<fieldset>
						<legend>성별</legend>
						<label>여</label> <input type="radio" name="gender" value="female"
						
						<%
							if("female".equals(vo.getGender())){
						%>
								checked="checked">
						<%}
						%>
						
						<label>남</label> <input type="radio" name="gender" value="male"
						<%
							if("male".equals(vo.getGender())){
						%>
								checked="checked">
						<%}
						%>
					</fieldset>
					
					<input type="submit" value="변경하기">
					
				</form>
			</div>
		</div>
		<div id="navigation">
			<jsp:include page="/views/include/navigation.jsp"/>
		</div>
		<div id="footer">
			<jsp:include page="/views/include/footer.jsp"/>
		</div>
	</div>
</body>
</html>