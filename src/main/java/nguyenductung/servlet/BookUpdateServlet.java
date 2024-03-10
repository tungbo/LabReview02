package nguyenductung.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import nguyenductung.beans.Book;
import nguyenductung.dao.BookDAO;

import java.io.IOException;

/**
 * Servlet implementation class BookUpdateServlet
 */
@WebServlet("/BookUpdate")
public class BookUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bookId = request.getParameter("id");
	    BookDAO bookDAO = new BookDAO();
	    Book book = bookDAO.getBookById(bookId);
	    if (book != null) {
	        request.setAttribute("book", book);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/BookUpdate.jsp");
	        dispatcher.forward(request, response);
	    } else {
	        response.getWriter().println("Book not found!");
	    }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("bookId");
		String title = request.getParameter("title");
        String author = request.getParameter("author");
        int release = Integer.parseInt(request.getParameter("release"));
        float price = Float.parseFloat(request.getParameter("price"));
        String picture = request.getParameter("picture");
        int publisherId = Integer.parseInt(request.getParameter("publisherId"));
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));

        Book book = new Book(id, title, author, release, price, picture, publisherId, categoryId);
        BookDAO bookDAO = new BookDAO();
        boolean isSuccess = bookDAO.updateBook(book);

        if (isSuccess) {
            response.sendRedirect(request.getContextPath() + "/BookList");
        } else {
            response.getWriter().println("Failed to update book!");
        }
	}

}
