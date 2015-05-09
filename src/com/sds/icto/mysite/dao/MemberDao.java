package com.sds.icto.mysite.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sds.icto.mysite.vo.MemberVo;

public class MemberDao {

	private Connection getConnection() throws ClassNotFoundException,
			SQLException {

		Connection con = null;

		Class.forName("oracle.jdbc.driver.OracleDriver");
		String dburl = "jdbc:oracle:thin:@localhost:1521:xe";
		con = DriverManager.getConnection(dburl, "webdb", "webdb");

		return con;
	}

	public void insert(MemberVo vo) throws ClassNotFoundException, SQLException {
		Connection conn = getConnection();
		String sql = 
		" insert into member VALUES(member_no_seq.nextval,?, ?, ?, ?)";
			
		PreparedStatement st = conn.prepareStatement(sql);
		st.setString(1, vo.getName());
		st.setString(2, vo.getEmail());
		st.setString(3, vo.getPassword());
		st.setString(4, vo.getGender());
		st.executeUpdate();
		
		if (st != null) {st.close();}
		if (conn != null) {conn.close();}
	}

	public MemberVo getMember(MemberVo vo) throws ClassNotFoundException, SQLException {
		
		
		Connection conn = getConnection();
		String sql = 
		"select * from member where email=? and password=?";
		
		PreparedStatement st = conn.prepareStatement(sql);
		st.setString(1, vo.getEmail());
		st.setString(2, vo.getPassword());	
		ResultSet rs = st.executeQuery();
		
		MemberVo memberVo = null;
		
		if(rs.next()){
			vo = new MemberVo();
			Long no = rs.getLong(1);
			String name = rs.getString(2);
			String email = rs.getString(3);
			//String password = rs.getString(4);
			String gender = rs.getString(5);
			
			
			memberVo = new MemberVo();
			memberVo.setNo(no);
			memberVo.setName(name);
			memberVo.setEmail(email);
			memberVo.setGender(gender);
		}
		
		if(rs!= null){rs.close();}
		if (st != null) {st.close();}
		if (conn != null) {conn.close();}
		
		
		return memberVo;
	}
}
