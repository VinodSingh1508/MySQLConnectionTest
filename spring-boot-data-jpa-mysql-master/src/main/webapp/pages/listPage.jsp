
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Hi There! List Page





	<c:choose>
		<c:when test="${customerList eq null || empty customerList}">
			<div class="alert alert-danger" role="alert">Customer List Not
				Found</div>
		</c:when>
		<c:otherwise>
			<table>
				<thead>
					<tr>
						<th>#</th>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="cust" items="${customerList}" varStatus="i">
						<tr>
							<td><c:out value="${i.count}" /></td>
							<td><c:out value="${cust.first_name}" /></td>
							<td><c:out value="${cust.last_name}" /></td>
							<td><c:out value="${cust.email}" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:otherwise>
	</c:choose>











</body>
</html>