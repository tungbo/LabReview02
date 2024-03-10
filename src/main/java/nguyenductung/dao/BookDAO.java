package nguyenductung.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import nguyenductung.beans.Book;
import nguyenductung.conn.ConnectionUtils;

public class BookDAO {
	public List<Book> getAllBooks() {
		List<Book> list = new ArrayList<>();
		try (Connection conn = ConnectionUtils.getMSSQLConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT b.*, c.CategoryName, p.PublisherName "
						+ "FROM Book b JOIN Category c ON b.CategoryId = c.CategoryId JOIN Publisher p ON b.PublisherId = p.PublisherId")) {
			while(rs.next()) {
                Book book = new Book();
                book.setBookId(rs.getString("BookId"));
                book.setTitle(rs.getString("Title"));
                book.setAuthor(rs.getString("Author"));
                book.setRelease(rs.getInt("Release"));
                book.setPrice(rs.getFloat("Price"));
                book.setPicture(rs.getString("Picture"));
                book.setPublisherId(rs.getInt("PublisherId"));
                book.setCategoryId(rs.getInt("CategoryId"));
                book.setCategoryName(rs.getString("CategoryName"));
                book.setPublisherName(rs.getString("PublisherName"));
                
                list.add(book);
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public boolean insertBook(Book book) {
		try(Connection conn = ConnectionUtils.getMSSQLConnection();
				PreparedStatement pstmt = conn.prepareStatement("INSERT INTO Book (BookId, Title, Author, Release, Price, Picture, PublisherId, CategoryId) VALUES (?, ?, ?, ?, ?, ?, ?, ?)")) {
			pstmt.setString(1, book.getBookId());
			pstmt.setString(2, book.getTitle());
	        pstmt.setString(3, book.getAuthor());
	        pstmt.setInt(4, book.getRelease());
	        pstmt.setFloat(5, book.getPrice());
	        pstmt.setString(6, book.getPicture());
	        pstmt.setInt(7, book.getPublisherId());
	        pstmt.setInt(8, book.getCategoryId());
	        
	        int rowAffected = pstmt.executeUpdate();
	        return rowAffected > 0;
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean updateBook(Book book) {
	    try (Connection conn = ConnectionUtils.getMSSQLConnection();
	         PreparedStatement pstmt = conn.prepareStatement("UPDATE Book SET Title=?, Author=?, Release=?, Price=?, Picture=?, PublisherId=?, CategoryId=? WHERE BookId=?")) {
	        pstmt.setString(1, book.getTitle());
	        pstmt.setString(2, book.getAuthor());
	        pstmt.setInt(3, book.getRelease());
	        pstmt.setFloat(4, book.getPrice());
	        pstmt.setString(5, book.getPicture());
	        pstmt.setInt(6, book.getPublisherId());
	        pstmt.setInt(7, book.getCategoryId());
	        pstmt.setString(8, book.getBookId());
	        
	        int rowsAffected = pstmt.executeUpdate();
	        return rowsAffected > 0;
	    } catch (SQLException | ClassNotFoundException e) {
	        e.printStackTrace();
	        return false;
	    }
	}
	
	public boolean deleteBook(String bookId) {
	    try (Connection conn = ConnectionUtils.getMSSQLConnection();
	         PreparedStatement pstmt = conn.prepareStatement("DELETE FROM Book WHERE BookId=?")) {
	        pstmt.setString(1, bookId);
	        
	        int rowsAffected = pstmt.executeUpdate();
	        return rowsAffected > 0;
	    } catch (SQLException | ClassNotFoundException e) {
	        e.printStackTrace();
	        return false;
	    }
	}
	
	public List<Book> searchBooks(String keyword) {
	    List<Book> list = new ArrayList<>();
	    try (Connection conn = ConnectionUtils.getMSSQLConnection();
	         PreparedStatement pstmt = conn.prepareStatement("SELECT b.*, c.CategoryName, p.PublisherName "
	                + "FROM Book b JOIN Category c ON b.CategoryId = c.CategoryId JOIN Publisher p ON b.PublisherId = p.PublisherId "
	                + "WHERE b.Title LIKE ? OR b.Author LIKE ?")) {
	        pstmt.setString(1, "%" + keyword + "%");
	        pstmt.setString(2, "%" + keyword + "%");
	        
	        try (ResultSet rs = pstmt.executeQuery()) {
	            while (rs.next()) {
	                Book book = new Book();
	                book.setBookId(rs.getString("BookId"));
	                book.setTitle(rs.getString("Title"));
	                book.setAuthor(rs.getString("Author"));
	                book.setRelease(rs.getInt("Release"));
	                book.setPrice(rs.getFloat("Price"));
	                book.setPicture(rs.getString("Picture"));
	                book.setPublisherId(rs.getInt("PublisherId"));
	                book.setCategoryId(rs.getInt("CategoryId"));
	                book.setCategoryName(rs.getString("CategoryName"));
	                book.setPublisherName(rs.getString("PublisherName"));
	                
	                list.add(book);
	            }
	        }
	    } catch (SQLException | ClassNotFoundException e) {
	        e.printStackTrace();
	    }
	    return list;
	}

	public Book getBookById(String bookId) {
		Book book = null;
	    try (Connection conn = ConnectionUtils.getMSSQLConnection();
	         PreparedStatement pstmt = conn.prepareStatement("SELECT b.*, c.CategoryName, p.PublisherName "
		                + "FROM Book b JOIN Category c ON b.CategoryId = c.CategoryId JOIN Publisher p ON b.PublisherId = p.PublisherId "
		                + "WHERE b.BookId = ?")) {
	        pstmt.setString(1, bookId);

	        try (ResultSet rs = pstmt.executeQuery()) {
	            if (rs.next()) {
	                book = new Book();
	                book.setBookId(rs.getString("BookId"));
	                book.setTitle(rs.getString("Title"));
	                book.setAuthor(rs.getString("Author"));
	                book.setRelease(rs.getInt("Release"));
	                book.setPrice(rs.getFloat("Price"));
	                book.setPicture(rs.getString("Picture"));
	                book.setPublisherId(rs.getInt("PublisherId"));
	                book.setCategoryId(rs.getInt("CategoryId"));
	                book.setCategoryName(rs.getString("CategoryName"));
	                book.setPublisherName(rs.getString("PublisherName"));
	            }
	        }
	    } catch (SQLException | ClassNotFoundException e) {
	        e.printStackTrace();
	    }
	    return book;
	}
}
