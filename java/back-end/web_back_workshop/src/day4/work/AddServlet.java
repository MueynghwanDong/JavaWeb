package day4.work;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddServlet
 */
@WebServlet("/addServlet")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num1 = request.getParameter("num1");
		String name = request.getParameter("name");
		String publisher = request.getParameter("publisher");
		String author = request.getParameter("author");
		int price = Integer.parseInt(request.getParameter("price"));
		String description = request.getParameter("description");
		// 모델 연동
		Book book = new Book(num1, name,publisher, price, description,1);
		BookDAO dao = BookDAO.getDao();
		dao.insertBook(book);
		
		//마지막 등록 도서 정보 확인을 위해 쿠키 생성
		Cookie cookie = new Cookie("lastBook",book.toString());
		cookie.setMaxAge(60*60*24*7);
		response.addCookie(cookie);
		
		
		
		List<Book> books = dao.listBooks();
		request.setAttribute("books", books);
		RequestDispatcher disp = request.getRequestDispatcher("booklist.jsp");
		disp.forward(request, response);
		//response.sendRedirect("booklist.jsp");
	}

}
