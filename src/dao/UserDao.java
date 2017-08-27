package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.db.JdbcUtil;
import vo.UserVo;

public class UserDao {
	
	//사용자 로그인
	
	public int isId(String userId){
		Connection conn= JdbcUtil.getConnection();
		PreparedStatement pstmt= null;
		ResultSet rs= null;
		
		String SQL= "select 1 from users where user_id=?";
		
		try{
			pstmt= conn.prepareStatement(SQL);
			pstmt.setString(1, userId);
			rs= pstmt.executeQuery();
			
			if(rs.next()){
				return 1;
			}else{
				return 0;
			}
			
		} catch(Exception e){
			e.printStackTrace();
		} finally{
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
		return -1; //데이터베이스 오류
	}
	
	public int UserAuth(String userId, String userPassword){
		Connection conn= JdbcUtil.getConnection();
		PreparedStatement pstmt= null;
		ResultSet rs= null;
		
		String SQL= "select user_password from users where user_id=?";
		
		try{
			pstmt= conn.prepareStatement(SQL);
			pstmt.setString(1, userId);
			rs= pstmt.executeQuery();
			
			if(rs.next()){
				if(rs.getString("user_password").equals(userPassword)){
					return 1;	//로그인 성공
				}else{
					return 0;	//비밀번호 불일치
				}
			}else{
				return 0;	//아이디가 없음
			}
			
		} catch(Exception e){
			e.printStackTrace();
		} finally{
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
		return -1; //데이터베이스 오류
		
	}//login method end
	
	
	//회원 가입
	public int join(UserVo vo){
		Connection conn= JdbcUtil.getConnection();
		PreparedStatement pstmt= null;
		
		//user_id, user_password, user_name, user_address1, user_address2, user_phone, user_email
		String SQL= "INSERT INTO users VALUES (?, ?, ?, ?, ?, ?, ?)";
		
		try{
			pstmt= conn.prepareStatement(SQL);
			pstmt.setString(1, vo.getUserId());
			pstmt.setString(2, vo.getUserPassword());
			pstmt.setString(3, vo.getUserName());
			pstmt.setString(4, vo.getUserAddress1());
			pstmt.setString(5, vo.getUserAddress2());
			pstmt.setString(6, vo.getUserPhone());
			pstmt.setString(7, vo.getUserEmail());
			
			return pstmt.executeUpdate();

		} catch(Exception e){
			e.printStackTrace();
		} finally{
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
		return -1; //데이터베이스 오류
		
	}//end join method
	
	
	//회원정보 가져오기
	public UserVo getUserInfo(String userId){
		Connection conn= JdbcUtil.getConnection();
		PreparedStatement pstmt= null;
		ResultSet rs= null;
		
		String SQL= "SELECT * FROM users WHERE user_id=?";
		
		try{
			pstmt= conn.prepareStatement(SQL);
			pstmt.setString(1, userId);
			rs= pstmt.executeQuery();
			
			UserVo vo= new UserVo();
			
			if(rs.next()){
				vo.setUserId(rs.getString("user_id"));
				vo.setUserPassword(rs.getString("user_password"));
				vo.setUserName(rs.getString("user_name"));
				vo.setUserAddress1(rs.getString("user_address1"));
				vo.setUserAddress2(rs.getString("user_address2"));
				vo.setUserPhone(rs.getString("user_phone"));
				vo.setUserEmail(rs.getString("user_email"));
			}
			return vo;
			
		} catch(Exception e){
			e.printStackTrace();
		} finally{
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
		return null; //데이터베이스 오류
	}// UserVo method end
	
	
	//회원 정보 수정
	public int modify(UserVo vo){
		Connection conn= JdbcUtil.getConnection();
		PreparedStatement pstmt= null;
		
		//user_id, user_password, user_name, user_address1, user_address2, user_phone, user_email
		String SQL= "UPDATE users SET user_password=?, user_name=?, user_address1=?, user_address2=?, user_phone=?, user_email=? WHERE user_id=?";
		
		try{
			pstmt= conn.prepareStatement(SQL);
			pstmt.setString(7, vo.getUserId());
			pstmt.setString(1, vo.getUserPassword());
			pstmt.setString(2, vo.getUserName());
			pstmt.setString(3, vo.getUserAddress1());
			pstmt.setString(4, vo.getUserAddress2());
			pstmt.setString(5, vo.getUserPhone());
			pstmt.setString(6, vo.getUserEmail());
			
			return pstmt.executeUpdate();

		} catch(Exception e){
			e.printStackTrace();
		} finally{
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
		return -1; //데이터베이스 오류
		
	}//end join method
	
}//end class
