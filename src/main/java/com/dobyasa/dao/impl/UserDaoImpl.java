package com.dobyasa.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import com.dobyasa.dao.UserDao;
import com.dobyasa.entity.Users;
import com.dobyasa.exception.IdIsNullException;

public class UserDaoImpl implements UserDao {

	@Override
	public int addUser(Users users) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delUserById(Integer id) throws IdIsNullException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delUserByName(String name) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateUserById(Integer id) throws IdIsNullException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Users> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean checkUser(Users users) {
		
		boolean flag=true;
		
		String name = users.getName();
		String pwd = users.getPwd();
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mariadb://localhost:3306/test", "root", "Hjj20021022");
			stmt=conn.createStatement();
			String sql="select * from users where name='"+name+"' and pwd='"+pwd+"'";
			rs=stmt.executeQuery(sql);
			
			// 封装Users
			if(rs.next()){
				flag=true;
			}else{
				flag=false;
			}
			
//		Users users =new Users();
//		users.setId(rs.getInt("id"));
//		users.setName(rs.getString("name"));
//		users.setNickName(rs.getString("nickName"));
//		users.setPwd(rs.getString("pwd"));
//		users.setGender(rs.getString("gender"));
//		users.setBirthday(rs.getDate("birthday"));
//		users.setHobby(rs.getString("hobby"));
//		users.setTel(rs.getString("tel"));
//		users.setEmail(rs.getString("email"));
//		users.setGrade(rs.getInt("grade"));
//		users.setDescription(rs.getString("description"));
			
//		System.out.println(users);
			
			// 6、关闭资源
			if(rs!=null){
				rs.close();
				rs=null;	//垃圾回收，上！
			}
			if(stmt!=null){
				stmt.close();
				stmt=null;	//垃圾回收，上！
			}
			if(conn!=null){
				conn.close();
				conn=null;	//垃圾回收，上！
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return flag;
	}

}
