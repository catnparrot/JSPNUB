package sec01.ex02;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
	private static final String driver = "oracle.jdbc.OracleDriver";
	private static final String url = "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String user = "hr";
	private static final String pw = "12345";
	private PreparedStatement pst;
	private Connection conn;
	
	public List<MemberVO> listMembers() {
		List<MemberVO> list = new ArrayList<MemberVO>();
		try {
			connDB();
			String sql = "select * from t_member ";
			System.out.println("prepareStatement"+sql);
			pst=conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery(sql);
			while (rs.next()) {
				String id= rs.getString("id");
				String pwd= rs.getString("pwd");
				String name= rs.getString("name");
				String email= rs.getString("email");
				Date joinDate = rs.getDate("joinDate");
				MemberVO vo = new MemberVO();
				vo.setId(id);
				vo.setPwd(pwd);
				vo.setName(name);
				vo.setEmail(email);
				vo.setJoinDate(joinDate);
				list.add(vo);
			}
			rs.close();
			pst.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public void connDB() {
		try {
			Class.forName(driver);
			System.out.println("Driver loading");
			conn=DriverManager.getConnection(url, user, pw);
			System.out.println("Connection creation sucess");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

