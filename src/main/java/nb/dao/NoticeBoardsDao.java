package nb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import nb.db.DBCon;
import nb.vo.NoticeBoards;

public class NoticeBoardsDao {
	public List<NoticeBoards> getList(String field, String questionVal) throws Exception {
		Connection conn = DBCon.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
//		String sql = "select * from noticeboards order by seq desc";
		String sql = "select * from noticeboards where "+field+" like '%"+questionVal+"%' order by seq desc";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();

		//리스트를 담을 그릇
		List<NoticeBoards> list = new ArrayList<NoticeBoards>();
		while(rs.next()) {
			NoticeBoards nb = new NoticeBoards();
			nb.setSeq(rs.getInt("seq"));
			nb.setTitle(rs.getString("title"));
			nb.setWriter(rs.getString("writer"));
			nb.setContent(rs.getString("content"));
			nb.setRegdate(rs.getDate("regdate"));
			nb.setHit(rs.getInt("hit"));
			
			list.add(nb);
		}
		return list;
	}
	
	public int delete(NoticeBoards nb) throws Exception {
		int cnt = 0;
		
		Connection conn = DBCon.getConnection();
		PreparedStatement pstmt = null;

		String sql = "delete from noticeboards where seq=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, nb.getSeq());

		cnt = pstmt.executeUpdate();
		return cnt;
	}
	
	public int insert(NoticeBoards nb) throws Exception {
		int resultNum = 0;
		//db연결하여 insert
		Connection conn = DBCon.getConnection();
		PreparedStatement pstmt = null;

		String sql = "insert into noticeboards(seq, title, writer, content, regdate, hit)";
				sql+= " values((select max(seq)+1 from noticeboards)";
				sql+= ", ?, ?, ?, systimestamp, 0)";
		pstmt = conn.prepareStatement(sql);

		pstmt.setString(1, nb.getTitle());
		pstmt.setString(2, nb.getWriter());
		pstmt.setString(3, nb.getContent());

		resultNum = pstmt.executeUpdate();
		System.out.println("resultNum : "+resultNum);
		
		return resultNum;
	}
	
	public int edit(NoticeBoards nb) throws Exception {
		Connection conn = DBCon.getConnection();

		String sql = "update noticeboards set title=?, content=? where seq=?";

		PreparedStatement pstmt = null;
		pstmt = conn.prepareStatement(sql);

		pstmt.setString(1, nb.getTitle());
		pstmt.setString(2, nb.getContent());
		pstmt.setInt(3, nb.getSeq());

		//ResultSet rs = null;
		//rs = pstmt.executeQuery();
		//rs.next();

		int cnt = pstmt.executeUpdate();
		
		return cnt;
	}
	
	public NoticeBoards getNBD(String num) throws Exception {
		Connection conn = DBCon.getConnection();

		String sql = "select * from noticeboards where seq=?";

		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, Integer.parseInt(num));

		ResultSet rs = pstmt.executeQuery();
		rs.next();
		
		//NoticeBoards.java에 저장(setting)
		NoticeBoards nb = new NoticeBoards();
		nb.setSeq(rs.getInt("seq"));
		nb.setHit(rs.getInt("hit"));
		nb.setWriter(rs.getString("writer"));
		nb.setRegdate(rs.getDate("regdate"));
		nb.setTitle(rs.getString("title"));
		nb.setContent(rs.getString("content"));
		
		rs.close();
		pstmt.close();
		conn.close();
		
		return nb;
	}
	
	public NoticeBoards getNBD(String num, String hit) throws Exception {
		Connection conn = DBCon.getConnection();
		
		//조회수 추가
		hitUp(num, hit);

		String sql = "select * from noticeboards where seq=?";

		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, Integer.parseInt(num));

		ResultSet rs = pstmt.executeQuery();
		rs.next();
		
		//NoticeBoards.java에 저장(setting)
		NoticeBoards nb = new NoticeBoards();
		nb.setSeq(rs.getInt("seq"));
		nb.setHit(rs.getInt("hit"));
		nb.setWriter(rs.getString("writer"));
		nb.setRegdate(rs.getDate("regdate"));
		nb.setTitle(rs.getString("title"));
		nb.setContent(rs.getString("content"));
		
		rs.close();
		pstmt.close();
		conn.close();
		
		return nb;
	}

	private void hitUp(String num, String hit) throws Exception {
		Connection conn = DBCon.getConnection();
		
		String sqlHit = "update noticeboards set hit=? where seq=?";
		
		PreparedStatement pstmtHit = conn.prepareStatement(sqlHit);
		pstmtHit.setInt(1, Integer.parseInt(hit)+1);
		pstmtHit.setInt(2, Integer.parseInt(num));
		pstmtHit.executeUpdate();
	}
}
