package com.dobyasa.jdbc;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcDemo {

	public static void main(String[] args) throws Exception {
		
		// 1、加载驱动
		Class.forName("com.mysql.jdbc.Driver");
		// 2、得到数据库链接
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test?serverTimezone=GMT&useUnicode=true&characterEncoding=utf-8&useSSL=false", "root", "root");
		// 3、创建表示sql的语句对象
		Statement stmt=conn.createStatement();
		// 4、执行sql，如果有结果，写入结果集
		String sql="insert into users(name,nickName,pwd,gender,birthday,hobby,tel,email,grade,description) "
				+ "values('张三','老三','123','0','2022-01-01','吃饭，睡觉，写程序','13900000123','123@qq.com',5,'项目经理')";
		int res=stmt.executeUpdate(sql);
		// 5、遍历结果集
		System.out.println("影响了"+res+"行。");
		// 6、关闭资源
		if(stmt!=null){
			stmt.close();
			stmt=null;	//垃圾回收，上！
		}
		if(conn!=null){
			conn.close();
			conn=null;	//垃圾回收，上！
		}
		
	}

}
