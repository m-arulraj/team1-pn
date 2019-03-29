<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html lang="en">
<body>
	<jsp:include page="../fragments/menulessheader.jsp" />
	<h1>HTTP Status 403 - Access is denied</h1>
	<c:choose>
		<c:when test="${empty username}">
			<h2>You do not have permission to access this page!</h2>
		</c:when>
		<c:otherwise>
			<h2>
				Username : ${username} <br /> You do not have permission to access
				this page!
			</h2>
		</c:otherwise>
	</c:choose>

	<jsp:include page="../fragments/footer.jsp" />
</body>
</html>