<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<title>Insert title here</title>
</head>
<body>



<table border="1" align="center">
<tr><td align="center">
<form action='add.do' method='post'>
<textarea id="content" name='content' rows='10' cols='80'></textarea><br>
Email : <input type='text' name='email'>암호 : <input type='password' name='pwd'>
<input type='submit' value='등록'>
</form>
</td></tr>
<c:forEach var="guestbook" items="${ guestbooks }">
<tr><td align="center">
${ guestbook.no } ${ guestbook.email } ${ guestbook.createdDate }
암호 : <input type='password'><input type='submit' value='수정'><br>
<textarea id="content" name='content' rows='10' cols='80' readonly>${ guestbook.content }</textarea>
</td></tr>
</c:forEach>
</table>
</body>
</html>