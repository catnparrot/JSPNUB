package sec02.ex01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {
	private PreparedStatement pst;
	private Connection conn;
	private DataSource dFact;
	
	public MemberDAO() {
		try {
			Context ctx = new InitialContext();
			Context envCtx = (Context) ctx.lookup("java:/comp/env");
			dFact = (DataSource) envCtx.lookup("jdbc/oracle");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public List listMembers(MemberVO memberVO) {
		List memberList = new ArrayList();
		String _name=memberVO.getName();
		try {
			conn = dFact.getConnection();
			String sql = "select * from t_member ";
			if((_name!=null && _name.length()!=0)) {
				sql += " where name=?";
				pst=conn.prepareStatement(sql);
				pst.setString(1, _name);
			}else {
				pst = conn.prepareStatement(sql);
			}
			System.out.println("prepareStatement: "+sql);
			ResultSet rs = pst.executeQuery();
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
				memberList.add(vo);
			}
			rs.close();
			pst.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return memberList;
	}
	
	public void addMember(MemberVO memberVO) {
		try {
			conn=dFact.getConnection();
			String id= memberVO.getId();
			String pwd= memberVO.getPwd();
			String name= memberVO.getName();
			String email= memberVO.getEmail();
			
			String sql = "insert into t_member";
			sql += " (id, pwd, name, email)";
			sql += " values(?, ?, ?, ?)";
			System.out.println("preparedStatement: " + sql);
			pst = conn.prepareStatement(sql);
			pst.setString(1, id);
			pst.setString(2, pwd);
			pst.setString(3, name);
			pst.setString(4, email);
			pst.executeUpdate();
			pst.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void delMember(String id) {
		try {
			conn=dFact.getConnection();
			
			String sql = "delete from t_member" + " where id=?";
			System.out.println("preparedStatement: " + sql);
			pst=conn.prepareStatement(sql);
			pst.setString(1, id);
			pst.executeUpdate();
			pst.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public boolean isExisted(MemberVO memberVO) {
		boolean result = false;
		String id = memberVO.getId();
		String pwd = memberVO.getPwd();
		try {
			conn=dFact.getConnection();
			String sql = "select decode(count(*),1,'true','false') as result from t_member";
				sql += " where id=? and pwd=?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, id);
			pst.setString(2, pwd);
			ResultSet rs = pst.executeQuery();
			rs.next();
			result = Boolean.parseBoolean(rs.getString("result"));
			System.out.println("result=" + result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}

