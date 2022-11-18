package com.dobyasa.service;


import com.dobyasa.entity.Users;
import com.dobyasa.exception.IdIsNullException;

import java.util.List;

public interface UserService {

    /**
     * 添加单个用户
     *
     * @param users
     * @return
     */
	boolean addUser(Users users);

    /**
     * 根据id删除单个用户
     *
     * @param id
     * @return
     */
	int delUserById(Integer id) throws IdIsNullException;

    /**
     * 根据name删除单个用户
     *
     * @param name
     * @return
     */
	int delUserByName(String name);

    /**
     * 根据id修改单个用户
     *
     * @param id
     * @return
     */
	int updateUserById(Integer id) throws IdIsNullException;

    /**
     * 查询所有用户
     *
     * @return
     */
	List<Users> getAllUsers();

    /**
     * 检查用户名是否存在且密码是否匹配
     *
     * @param users
     * @return
     */
	boolean checkUser(Users users);

}
