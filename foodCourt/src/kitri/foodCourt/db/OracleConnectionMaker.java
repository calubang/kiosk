package kitri.foodCourt.db;

import java.sql.*;

public class OracleConnectionMaker implements ConnectionMaker{

	@Override
	public Connection makeConnection() {
		Connection c = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			c = DriverManager.getConnection(
					"jdbc:oracle:thin:@192.168.14.111:1521:orcl", "fook", "fook");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}
	
	@Override
	public void closeConnection(Connection con, PreparedStatement ps, ResultSet rs) throws SQLException {
		if(rs != null) {
			rs.close();
		}
		if(ps != null) {
			ps.close();
		}
		if(con != null) {
			con.close();
		}
	}
}
