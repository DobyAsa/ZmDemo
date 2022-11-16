//package com.dobyasa.jdbc;
//
//import java.sql.ResultSet;
//import java.sql.Statement;
//import java.sql.Connection;
//import java.sql.DriverManager;
//
//import com.dobyasa.entity.Users;
//import com.zm.entity.Users;
//
//public class JdbcDemo2 {
//
//	public static void main(String[] args) throws Exception {
//
//		// 1、加载驱动
//		Class.forName("com.mysql.jdbc.Driver");
//		// 2、得到数据库链接
//		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test?serverTimezone=GMT&useUnicode=true&characterEncoding=utf-8&useSSL=false", "root", "root");
//		// 3、创建表示sql的语句对象
//		Statement stmt=conn.createStatement();
//		// 4、执行sql，如果有结果，写入结果集
//		String sql="select * from users where name='李逵' and pwd='123'";
//		ResultSet rs=stmt.executeQuery(sql);
//		// 5、遍历结果集
////		System.out.println("影响了"+res+"行。");
//
//		// 封装Users
//		rs.next();
//
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
//
//		System.out.println(users);
//
//		// 6、关闭资源
//		if(stmt!=null){
//			stmt.close();
//			stmt=null;	//垃圾回收，上！
//		}
//		if(conn!=null){
//			conn.close();
//			conn=null;	//垃圾回收，上！
//		}
//
//	}
//
//}
