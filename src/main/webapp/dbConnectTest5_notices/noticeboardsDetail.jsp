<%@page import="nb.vo.NoticeBoards"%>
<%@page import="nb.dao.NoticeBoardsDao"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
%>
<%
/* String num = request.getParameter("no");

if(num==null){
	System.out.println("null");
	response.sendRedirect("noticeboards.jsp");
	return;
	//참조사이트 : https://findmypiece.tistory.com/55
}

NoticeBoardsDao dao = new NoticeBoardsDao();
NoticeBoards nb = dao.getNBD(num);
String loginId = nb.getWriter(); */


/* String driver = "oracle.jdbc.driver.OracleDriver";
String url = "jdbc:oracle:thin:@localhost:1521:xe";
String user = "hr";
String pw = "123456";

Class.forName(driver);
Connection conn = DriverManager.getConnection(url, user, pw);

//String sql = "select * from noticeboards where seq='"+num+"'"; //num이 String이기 때문에 작은따옴표 사용

//Statement st = conn.createStatement();
//ResultSet rs = st.executeQuery(sql);

String sql = "select * from noticeboards where seq=?";

PreparedStatement pstmt = conn.prepareStatement(sql);
pstmt.setInt(1, Integer.parseInt(num));

ResultSet rs = pstmt.executeQuery();
rs.next(); */


//System.out.println(rs.getString("title"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>my jsp file</title>
<link rel="stylesheet" href="../css/nstyle.css" />
</head>
<body>
<h3>noticeboardsDetail.jsp</h3>

<table class="twidth">
	<colgroup>
		<col width="15%"/>
		<col width="35%"/>
		<col width="5%"/>
		<col width="35%"/>
	</colgroup>
	<caption>Detail</caption>
	<tbody>
		<tr>
			<th class="left">글번호</th>
			<td>${nb.seq}</td>
			<th class="left">조회수</th>
			<td>${nb.hit}</td>
		</tr>
		<tr>
			<th class="left">작성자</th>
			<td>${nb.writer}</td>
			<th class="left">작성일</th>
			<td>${nb.regdate}</td> <!-- rs.setDate 사용 -->
		</tr>
		<tr>
			<th class="left">제목</th>
			<td colspan="3" id="title">${nb.title}</td>
		</tr>
		<tr>
			<th class="left">내용</th>
			<td colspan="3" id="content">${nb.content}</td>
		</tr>
		<tr>
			<th class="left">첨부</th>
			<td colspan="3" id="addfile">첨부</td>
		</tr>
	</tbody>
</table>

<a href="noticeboards.jsp">목록</a>
<%
if(session.getAttribute("sessionId")!=null){ //로그인 되어있을 경우
	if(session.getAttribute("sessionId").equals(request.getAttribute("writerId"))) {
	System.out.println("sessionId : "+session.getAttribute("sessionId"));
	System.out.println("writerId !!! : "+request.getAttribute("writerId"));
	//String sendInsertProWriterId = (String)request.getAttribute("sessionId");
	//session.setAttribute("sendInsertProWriterId", sendInsertProWriterId);
%>
	<a href="noticeboardsEdit.do?no=${nb.seq}">수정</a>
	<a href="noticeboardsDelProc.do?no=${nb.seq}">삭제</a>
<%
	}
}else if(session.getAttribute("sessionId")==null){ //로그인 되어있지 않은 경우
%>
	<a href="../dbConnectTest5_login/loginForm.jsp">login</a>
<%
}
%>

</body>
</html>