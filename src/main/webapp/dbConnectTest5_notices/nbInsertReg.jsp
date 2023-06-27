<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
%>
<%
String loginId = (String)session.getAttribute("sessionId");
//System.out.println("loginIddddddd : "+loginId);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>my jsp file</title>
<link rel="stylesheet" href="../css/nstyle.css" />
</head>
<body>
<h3>nbInsertReg.jsp</h3>
<form action="nbInsertPro.do" method="post">
	
	<table class="twidth">
		<colgroup>
			<col width="30%"/>
			<col width="70%"/>
		</colgroup>
		<caption>WRITE</caption>
		<tbody>
			<tr>
				<td>제목</td>
				<td>
					<input type="text" name="title" placeholder="제목을 입력하세요" size="48"/>
				</td>
			</tr>
			<tr>
				<td>내용</td>
				<td>
					<textarea rows="5" cols="50" name="content" id="txtcontent" class="txtcontent" placeholder="내용을 입력하세요"></textarea>
				</td>
			</tr>
			<tr>
				<td>첨부파일</td>
				<td>
					<input type="file" name="txtFile" />
				</td>
			</tr>
		</tbody>
	</table>
	<input type="hidden" name="loginId" value="<%=loginId %>" />
	<input type="submit" value="insert" />
</form>
</body>
</html>