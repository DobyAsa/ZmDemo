package com.dobyasa.Utils;

import com.dobyasa.entity.Users;
import org.apache.commons.dbcp2.BasicDataSourceFactory;
import org.apache.commons.dbutils.QueryRunner;

import javax.sql.DataSource;
import java.io.InputStream;
import java.util.Properties;

public class DBCPUtil {
    private static final DataSource dataSource;
    static {

        try {
            InputStream in = DBCPUtil.class.getClassLoader().getResourceAsStream("dbcpconfig.properties");
            Properties props = new Properties();
            props.load(in);
            dataSource = BasicDataSourceFactory.createDataSource(props);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ExceptionInInitializerError(e);
        }
    }
    /**
     * 获取DataSource对象
     * @return
     */
    public static DataSource getDataSource() {
        return dataSource;
    }
}
