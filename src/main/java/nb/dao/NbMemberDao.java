package nb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class NbMemberDao {
	public NbMember getMember() throws Exception {
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String pw = "123456";

		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, user, pw);

		String sql = "select id,pwd from nbmember where id=?";

		PreparedStatement pstmt = conn.prepareStatement(sql);
		//pstmt.setString(1, id);

		ResultSet rs = pstmt.executeQuery();
		
		return null;
	}
}
