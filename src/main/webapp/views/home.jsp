<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://jakarta.ee/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>

	${name}
    <form action="home" method="post">
		<label>Há» tÃªn</label>
		<input type="text" name="ten">
		<input type="text" name="holot">
		<input type="submit" value="OK">
	</form>
</body>
</html>
