<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Movie</title>
</head>
<body>
	<form method="post" action="movie/addMovie.htm">


		Movie Title <input type="text" name="title" /><br>
		<br> Lead Actor <input type="text" name="actor" /> <br>
		<br> Lead Actress <input type="text" name="actress" /><br>
		<br> Movie Genre <input type="text" name="genre" /><br>
		<br> Movie Year <input type="number" name="year" /> <br>
		<br> <br />
		<input type="submit" value="SUBMIT" />
	</form>
</body>
</html>