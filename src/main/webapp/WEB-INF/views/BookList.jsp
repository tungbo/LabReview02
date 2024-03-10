<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book List</title>
</head>
<body>
<h1>List of Books</h1>
    <table border="1">
        <tr>
            <th>Id</th>
            <th>Title</th>
            <th>Author</th>
            <th>Release Year</th>
            <th>Price</th>
            <th>Picture</th>
            <th>Publisher</th>
            <th>Category</th>
            <th></th>
        </tr>
        <c:forEach items="${bookList}" var="book">
            <tr>
                <td>${book.bookId}</td>
                <td>${book.title}</td>
                <td>${book.author}</td>
                <td>${book.release}</td>
                <td>${book.price}</td>
                <td><img src="${book.picture}"></td>
                <td>${book.publisherName}</td>
                <td>${book.categoryName}</td>
                <td><a href="BookUpdate?id=${book.bookId}">Edit</a></td>
                <td><a href="BookDelete?id=${book.bookId}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
    <a href="BookCreate">Create Book</a>
</body>
</html>