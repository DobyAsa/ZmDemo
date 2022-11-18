package com.dobyasa.dao.impl;

import com.dobyasa.Utils.DBCPUtil;
import com.dobyasa.dao.UserDao;
import com.dobyasa.entity.Users;
import com.dobyasa.exception.IdIsNullException;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import javax.sql.DataSource;
import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public boolean addUser(Users users) {
        try{
            if (selectUser(users) != null){
                return false;
            }else {
                DataSource dataSource = DBCPUtil.getDataSource();
                QueryRunner queryRunner = new QueryRunner(dataSource);

                queryRunner.update("insert into users (name, pwd) values(?,?)", users.getName(), users.getPwd());
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public Users selectUser(Users users){
        try {
            DataSource dataSource = DBCPUtil.getDataSource();
            QueryRunner queryRunner = new QueryRunner(dataSource);

            return queryRunner.query("select * from users where name=?", new BeanHandler<>(Users.class), users.getName());
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
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

        try {
            DataSource dataSource = DBCPUtil.getDataSource();
            QueryRunner queryRunner = new QueryRunner(dataSource);
            Users u = queryRunner.query("select * from users where name = ? and pwd = ?",
                    new BeanHandler<>(Users.class), users.getName(), users.getPwd());
            if(u == null){
                return false;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
