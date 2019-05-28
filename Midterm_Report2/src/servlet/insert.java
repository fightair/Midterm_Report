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

@WebServlet("/insert")
public class insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
   

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

		String town_name = request.getParameter("town_name");
		if (town_name == null || town_name.trim().length() == 0) {
			errorMessage.put("town_name", "不可空白");
		}
		String h_nums = request.getParameter("h_num");
		int h_num = 0;
		if (h_nums != null && h_nums.trim().length() > 0) {
			h_num = Integer.parseInt(h_nums);
		} else {
			errorMessage.put("h_num", "不可空白");
		}

		String p_nums = request.getParameter("p_num");
		int p_num = 0;

		if (p_nums != null && p_nums.trim().length() > 0) {
			p_num = Integer.parseInt(p_nums);
		} else {
			errorMessage.put("p_num", "不可空白");
		}

		String m_nums = request.getParameter("m_num");
		int m_num = 0;
		if (m_nums != null && m_nums.trim().length() > 0) {
			m_num = Integer.parseInt(m_nums);
		} else {
			errorMessage.put("m_num", "不可空白");
		}

		String f_nums = request.getParameter("f_num");
		int f_num = 0;
		if (f_nums != null && f_nums.trim().length() > 0) {
			f_num = Integer.parseInt(f_nums);
		} else {
			errorMessage.put("f_num", "不可空白");
		}

		String info_times = request.getParameter("info_time");
		int info_time = 0;
		if (info_times != null && info_times.trim().length() > 0) {
			info_time = Integer.parseInt(info_times);
		} else {
			errorMessage.put("info_time", "不可空白");
		}
		
		if (!errorMessage.isEmpty()) {
			
			RequestDispatcher rd = request.getRequestDispatcher("insert.jsp");
			rd.forward(request, response);
			return;
		}
		
		PeoBean mb = new PeoBean(town_id, town_name, h_num, p_num, m_num, f_num, info_time);
		PeopleDAOjdbc dao = null;
		try {
			dao = new PeopleDAOjdbc();
			dao.insert(mb);
			session.setAttribute("PeoBean", mb);
			response.sendRedirect("Success.jsp");
			return;
		} catch (SQLException e) {
			if (e.getMessage().indexOf("重複的索引鍵") != -1 || e.getMessage().indexOf("Duplicate entry") != -1) {
				errorMessage.put("id", "區碼重複，請重新輸入");
				e.printStackTrace();
			} else {
				errorMessage.put("exception", "資料庫存取錯誤:" + e.getMessage());
			}
			RequestDispatcher rd = request.getRequestDispatcher("insert.jsp");
			rd.forward(request, response);
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
