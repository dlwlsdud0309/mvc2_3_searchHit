<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
request.setCharacterEncoding("utf-8");
%>

<%
/* Connection conn=null;
//PreparedStatement pstmt=null;
Statement stmt=null;
ResultSet rs=null;

String driver="oracle.jdbc.driver.OracleDriver";
String url="jdbc:oracle:thin:@localhost:1521:xe";
String user="hr";
String pw="123456";

Class.forName(driver);
conn=DriverManager.getConnection(url, user, pw);

String sql="select * from noticeboards order by seq desc";
//pstmt=conn.prepareStatement(sql);
stmt=conn.createStatement();
rs=stmt.executeQuery(sql);
//rs.next();
//System.out.println(rs.getString("title")); */
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>my jsp file</title>
<link rel="stylesheet" href="../css/nb_style.css" />
</head>
<body>
<h3><a href="noticeboards.do">Noticeboards</a></h3>

<div id="loginCheck">
	<%
	if(session.getAttribute("sessionId")==null){
		//response.sendRedirect("../dbConnectTest5_login/loginForm.jsp");
		//return;
		//위의 주석을 해제하면 정상작동하나 로그인하지 않으면 게시글 읽기 자체도 불가능하게 됨
		System.out.println("noticeboards에 로그인하지않고 접근");
	}else{
	%>
		<%=session.getAttribute("sessionId") %>님이 로그인하셨습니다.
		<input type="button" value="logout" onclick="logoutProc();" /> <br />
	<%
	}
	%>
</div>
${uid }님이 로그인하셨습니다. dfdf
<div class="nbList">
	<form action="noticeboards.do" method="get">
		<select name="search">
			<option ${param.search=="title"?"selected":"" } value="title">제목</option>
			<option ${param.search=="content"?"selected":"" } value="content">내용</option>
		</select>
		<input type="text" id="questionVal" name="questionVal" value="${questionVal }" onclick="clearVal();" size="40"/>
		<input type="submit" value="검색" />
	</form>
</div>

<table border="1" width="100%">
	<tr>
		<td>번호</td>
		<td>제목</td>
		<td>작성자</td>
		<td>작성일</td>
		<td>조회수</td>
	</tr>
<c:forEach items="${list }" var="nb">
	<tr>
		<td>${nb.seq }</td>
		<td>
			<a href="noticeboardsDetail.do?no=${nb.seq }&hit=${nb.hit}">${nb.title }</a>
		</td>
		<td>${nb.writer }</td>
		<td>${nb.regdate }</td>
		<td>${nb.hit }</td>
	</tr>
</c:forEach>
</table>
<%
if(session.getAttribute("sessionId")!=null){
%>
	<a href="nbInsertReg.do">글쓰기</a>
<%
}else {
%>
	<a href="../dbConnectTest5_login/loginForm.do">login</a>
<%
}
%>

<script>
	function logoutProc(){
		location.href="../dbConnectTest5_login/logoutProc.jsp";
	}
	
	function clearVal(){
		//alert("hi"); 검색창을 클릭만 해도 alert 창이 활성화 됨
		var inputVal = document.getElementById("questionVal");
		inputVal.value = "";
	}
</script>
</body>
</html>