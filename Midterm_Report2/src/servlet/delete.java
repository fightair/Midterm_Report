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

import model.dao.PeopleDAOjdbc;


@WebServlet("/delete")
public class delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public delete() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
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
			RequestDispatcher rd = request.getRequestDispatcher("delete.jsp");
			rd.forward(request, response);
			return;
		}
		PeopleDAOjdbc dao = null;
		try {
			dao = new PeopleDAOjdbc();
			int delete = dao.delete(town_id);
			System.out.println(delete);
			if(delete==1) {
				response.sendRedirect("Success.jsp");
			}else {
			errorMessage.put("id", "無此區碼");
			RequestDispatcher rd = request.getRequestDispatcher("delete.jsp");
			rd.forward(request, response);
			}
			return;
		} catch (SQLException e) {
			e.printStackTrace(); 
			
			return;
		}finally {
			try {
				dao.closeConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
