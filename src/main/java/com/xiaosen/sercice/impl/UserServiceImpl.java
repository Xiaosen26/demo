package com.xiaosen.sercice.impl;


import com.xiaosen.constant.MessageConstant;
import com.xiaosen.constant.StatusConstant;
import com.xiaosen.exception.AccountLockedException;
import com.xiaosen.exception.AccountNotFoundException;
import com.xiaosen.exception.PasswordErrorException;
import com.xiaosen.mapper.UserMapper;
import com.xiaosen.pojo.dto.UserLoginDTO;
import com.xiaosen.pojo.entity.User;
import com.xiaosen.sercice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    public User login(UserLoginDTO userLoginDTO) {
        String phone = userLoginDTO.getPhone();
        String password = userLoginDTO.getPassword();

        //1、根据用户名查询数据库中的数据
        User user = userMapper.getByPhone(phone);

        //2、处理各种异常情况（用户名不存在、密码不对、账号被锁定）
        if (user == null) {
            //账号不存在
            throw new AccountNotFoundException(MessageConstant.ACCOUNT_NOT_FOUND);
        }

        //密码比对
        //进行md5加密，然后再进行比对
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        System.out.println(password);
        if (!password.equals(user.getPassword())) {
            //密码错误
            throw new PasswordErrorException(MessageConstant.PASSWORD_ERROR);
        }

        if (user.getState() == StatusConstant.DISABLE) {
            //账号被锁定
            throw new AccountLockedException(MessageConstant.ACCOUNT_LOCKED);
        }

        //3、返回实体对象
        return user;
    }
}
