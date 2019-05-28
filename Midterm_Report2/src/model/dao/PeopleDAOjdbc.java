package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class PeopleDAOjdbc implements IPeoDAO {
	private static final String INSERT_STMT = "INSERT INTO TaipeiTownPeopleCount VALUES(?, ?, ?, ?, ?, ?, ?)";
	private static final String UPDATE_STMT = "UPDATE TaipeiTownPeopleCount SET TOWN_NAME=?, H_NUM=?, P_NUM=?, M_NUM=?, F_NUM=?, INFO_TIME=? WHERE TOWN_ID=?";
	private static final String DELETE_STMT = "DELETE FROM TaipeiTownPeopleCount WHERE TOWN_ID=?";
	private static final String GET_ONE_STMT = "SELECT TOWN_ID, TOWN_NAME, H_NUM, P_NUM, M_NUM, F_NUM, INFO_TIME FROM TaipeiTownPeopleCount WHERE TOWN_ID=?";

	DataSource ds = null;

	public PeopleDAOjdbc() {
		try {
			Context context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/jdbc/PeoDB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	Connection conn = null;

	@Override
	public int insert(PeoBean peo) throws SQLException {
		int updateCount = 0;
		conn = ds.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(INSERT_STMT);
		pstmt.setInt(1, peo.getTown_id());
		pstmt.setString(2, peo.getTown_name());
		pstmt.setInt(3, peo.getH_num());
		pstmt.setInt(4, peo.getP_num());
		pstmt.setInt(5, peo.getM_num());
		pstmt.setInt(6, peo.getF_num());
		pstmt.setInt(7, peo.getInfo_time());
		updateCount = pstmt.executeUpdate();
		return updateCount;
	}

	@Override
	public int update(PeoBean peo) throws SQLException {
		int updateCount = 0;
		conn = ds.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(UPDATE_STMT);
		pstmt.setString(1, peo.getTown_name());
		pstmt.setInt(2, peo.getH_num());
		pstmt.setInt(3, peo.getP_num());
		pstmt.setInt(4, peo.getM_num());
		pstmt.setInt(5, peo.getF_num());
		pstmt.setInt(6, peo.getInfo_time());
		pstmt.setInt(7, peo.getTown_id());
		updateCount = pstmt.executeUpdate();
		return updateCount;
	}

	@Override
	public int delete(int town_id) throws SQLException {
		int updateCount = 0;
		conn = ds.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(DELETE_STMT);
		pstmt.setInt(1, town_id);
		updateCount = pstmt.executeUpdate();
		System.out.println(updateCount);
		return updateCount;
	}

	@Override
	public PeoBean search(int town_id) throws SQLException {
		PeoBean peo = null;
		conn = ds.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(GET_ONE_STMT);
		pstmt.setInt(1, town_id);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			peo = new PeoBean();
			peo.setTown_id(rs.getInt("town_id"));
			peo.setTown_name(rs.getString("town_name"));
			peo.setH_num(rs.getInt("h_num"));
			peo.setP_num(rs.getInt("p_num"));
			peo.setM_num(rs.getInt("m_num"));
			peo.setF_num(rs.getInt("f_num"));
			peo.setInfo_time(rs.getInt("info_time"));

		}
		return peo;
	}

	@Override
	public void closeConn() throws SQLException {
		if (conn != null)
			conn.close();

	}

}
