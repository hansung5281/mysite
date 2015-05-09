<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.sds.icto.mysite.vo.*"%>
<%@ page import="com.sds.icto.mysite.dao.*"%>
<%
	GuestBookDao dao = new GuestBookDao();
	List<GuestBookVo> list = dao.fetch();
	
	MemberVo nVo = (MemberVo)session.getAttribute("authMember");
%>

<!doctype html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="/mysite/assets/css/guestbook.css" rel="stylesheet"
	type="text/css">
</head>
<body>
	<div id="container">
		<div id="header">
			<jsp:include page="/views/include/header.jsp" flush="false" />
		</div>
		<div id="content">
			<div id="guestbook">
				<form action="/mysite/guestBook" method="post">
					<input type="hidden" name="a" value="insert">
					<table>
						<tr>
							<td>이름</td>
							<td><input type="text" name="name"
							 <%if(nVo!=null){
							 %>
							 value="<%=nVo.getName()%>"
							 <%}else{
							 %>	 
							 value=""></td>
							 <%}%>

							<td>비밀번호</td>
							<td><input type="password" name="pass"></td>
						</tr>
						<tr>
							<td colspan=4><textarea name="content" id="content"></textarea></td>
						</tr>
						<tr>
							<td colspan=4 align=right><input type="submit" VALUE=" 확인 "></td>
						</tr>
					</table>
				</form>
				<br>
				<%
					for (GuestBookVo vo : list) {
				%>
				<table width=510 border=1>
					<tr>
						<td><%=vo.getNo()%></td>
						<td><%=vo.getName()%></td>
						<td><%=vo.getDate()%></td>
						<td><a
							href="/mysite/views/guestbook/deleteform.jsp?a=delete&no=<%=vo.getNo()%>">삭제</a></td>
					</tr>
					<tr>
						<td colspan=4><%=vo.getMessage()%></td>
					</tr>
				</table>
				<br>
				<%
					}
				%>
			</div>
		</div>
		<div id="navigation">
			<jsp:include page="/views/include/navigation.jsp" />
		</div>
		<div id="footer">
			<p>(c)opyright 2014</p>
		</div>
	</div>
</body>
</html>