package model.dao;

import java.sql.SQLException;
import java.util.*;

public interface IPeoDAO {
	public int insert(PeoBean peo) throws SQLException;
	public int update(PeoBean peo) throws SQLException;
	public int delete(int TOWN_ID) throws SQLException;
	public PeoBean search(int town_id) throws SQLException;
	public void closeConn() throws SQLException;
	
}