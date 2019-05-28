package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.PeoBean;
import model.dao.PeopleDAOjdbc;

@WebServlet("/search")
public class search extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Map<String, String> errorMessage = new HashMap<>();
		request.setAttribute("ErrorMsg", errorMessage);
		request.setCharacterEncoding("UTF-8");

		String town_ids = request.getParameter("town_id");
		int town_id = 0;
		if (town_ids != null && town_ids.trim().length() > 0) {
			town_id = Integer.parseInt(town_ids);
		} else {
			errorMessage.put("town_id", "不可空白");
		}
		if (!errorMessage.isEmpty()) {
			RequestDispatcher rd = request.getRequestDispatcher("search.jsp");
			rd.forward(request, response);
			return;
		}
	

		PeopleDAOjdbc dao = null;
		try {
			dao = new PeopleDAOjdbc();
			PeoBean search = dao.search(town_id);
			if(search!=null) {
			session.setAttribute("PeoBean", search);
			response.sendRedirect("Success.jsp");
			}else {
				RequestDispatcher rd = request.getRequestDispatcher("search.jsp");
				errorMessage.put("id", "查無此區碼請新輸入");
				rd.forward(request, response);
			}
			return;
		} catch (SQLException e) {
			e.printStackTrace(); 
			
		}finally {
			try {
				dao.closeConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
