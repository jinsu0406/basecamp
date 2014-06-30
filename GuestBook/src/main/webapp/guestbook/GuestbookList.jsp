<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>

<script type='text/javaScript'>
$(document).ready(function(){
    var u_email = $('#user_email');

    $('#regBtn').click(function(){
        var regEmail = /([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;

        if( !u_email.val() ){
            alert('이메일주소를 입력 해 주세요');
            u_email.focus();
            return false;
        } else {
            if(!regEmail.test(u_email.val())) {
                alert('이메일 주소가 유효하지 않습니다');
                u_email.focus();
                return false;
            }
        }
    });
});
</script>

<title>GuestBook</title>
</head>
<body>

<table border="1" align="center">

<tr><td align="center">
<form action='add.do' method='post'>
<textarea id="content" name='content' rows='10' cols='80'></textarea><br>
Email : <input type='text' name='email' id="user_email">암호 : <input type='password' name='pwd'>
<input type='submit' id="regBtn" value='등록'>
</form>
</td></tr>

<c:forEach var="guestbook" items="${ guestbooks }">
<tr><td style="border-color:#88ffaa" align="center" bgcolor='#aaff00'>
<form action='update.do' method='post'>
<input type="text" style="width:25px; float:left;" name='no' value="${ guestbook.no }" align="middle" readonly>
<p style="margin:1px 1px; float:left;">${ guestbook.createdDate }</p><br>
<textarea style="overflow:hidden; background-color:#88ffaa" id="content" name='content' rows='10' cols='80'>
${ guestbook.content }</textarea><br><br><br>
Email : <input type="text" name='email' value="${ guestbook.email }" readonly> &nbsp;&nbsp;&nbsp;Password : <input type='password' name='pwd'>
<input type='submit' value='수정'><br>
</form>

</td></tr>
</c:forEach>

</table>

</body>
</html>