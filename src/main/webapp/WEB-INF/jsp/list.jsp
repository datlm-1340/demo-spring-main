<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"
    import="java.util.List, java.util.ArrayList, com.demo.models.Product"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>

    
<table border=1> 
   <tr>
		<td>ID</td>
		<td>Product Name</td>
		<td>Origin</td>
		<td>Date</td>
		<td>Price</td>
	</tr>
	<c:forEach items="${requestScope.productList}" var="product">
		
	    <tr>
	        <td><c:out value="${product.id}"/></td>
	        <td><c:out value="${product.productName}"/></td>
	        <td><c:out value="${product.origin}"/></td>
	        <td><c:out value="${product.productDate}"/></td>
	        <td><c:out value="${product.price}"/></td>  	         
	    </tr>
	</c:forEach>
</table>
</body>
</html>