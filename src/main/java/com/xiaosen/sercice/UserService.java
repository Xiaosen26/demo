package com.xiaosen.sercice;

import com.xiaosen.pojo.dto.UserDTO;
import com.xiaosen.pojo.dto.UserLoginDTO;
import com.xiaosen.pojo.dto.UserPageQueryDTO;
import com.xiaosen.pojo.entity.User;
import com.xiaosen.result.PageResult;

public interface UserService {
    /**
     * 用户登录
     * @param userLoginDTO
     * @return
     */
    User login(UserLoginDTO userLoginDTO);

    /**
     * 用户注册
     * @param userDTO
     */
    void save(UserDTO userDTO);

    /**
     * 用户分页查询
     * @param userPageQueryDTO
     * @return
     */
    PageResult pageQuery(UserPageQueryDTO userPageQueryDTO);
}
