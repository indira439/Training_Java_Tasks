package com.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bean.Login;

@Repository
public class LoginRepo {
	
	@Autowired
	JdbcTemplate JDBCTemp;

	public int saveUser(Login login) {
		// TODO Auto-generated method stub
		try
		{
			return JDBCTemp.update("INSERT INTO Login Values(?,?,?)", login.getEmailId(),login.getPassword(), login.getUserType());
		}
		catch(Exception ex)
		{
			System.err.println(ex);
			return 0;
		}
	}

	public int getUserByEmailId(String emailId) {
		// TODO Auto-generated method stub
		try
		{
//			return JDBCTemp.query("SELECT COUNT(*) FROM Login WHERE EmailID = ?", new LoginRowMapper(), login.getEmailId());
			return JDBCTemp.queryForList("SELECT * FROM Login WHERE EmailID = ?", emailId).size();
		}
		catch(Exception ex)
		{
			System.err.println(ex);
		} 
		return 0;
	}
	
//	 public class LoginRowMapper implements RowMapper<Login>{
//		public Login mapRow(ResultSet rs, int rowNum) throws SQLException {
//			Login l = new Login();
//			l.setEmailId(rs.getString(1));
//			l.setPassword(rs.getString(2));
//			l.setUserType(rs.getString(3));
//		
//			return l;
//		}
//
//	}


}
