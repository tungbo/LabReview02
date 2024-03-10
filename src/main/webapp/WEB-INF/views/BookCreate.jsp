<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Update Book Information</h2>
    <form action="BookUpdate" method="post">
        <label for="bookId">Book ID:</label>
        <input type="text" id="bookId" name="bookId" value="${book.bookId}" readonly><br>
        <label for="title">Title:</label>
        <input type="text" id="title" name="title" value="${book.title}"><br>
        <label for="author">Author:</label>
        <input type="text" id="author" name="author" value="${book.author}"><br>
        <label for="release">Release:</label>
        <input type="text" id="release" name="release" value="${book.release}"><br>
        <label for="price">Price:</label>
        <input type="text" id="price" name="price" value="${book.price}"><br>
        <label for="picture">Picture:</label>
        <input type="text" id="picture" name="picture" value="${book.picture}"><br>
        <label for="publisherId">PublisherId:</label>
        <input type="text" id="publisherId" name="publisherId" value="${book.publisherId}"><br>
        <label for="categoryId">CategoryId:</label>
        <input type="text" id="categoryId" name="categoryId" value="${book.categoryId}"><br>
        
        <input type="submit" value="Update Book">
    </form>
</body>
</html>