package com.xiaosen.sercice.impl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xiaosen.constant.MessageConstant;
import com.xiaosen.constant.StatusConstant;
import com.xiaosen.exception.AccountLockedException;
import com.xiaosen.exception.AccountNotFoundException;
import com.xiaosen.exception.PasswordErrorException;
import com.xiaosen.mapper.UserMapper;
import com.xiaosen.pojo.dto.UserDTO;
import com.xiaosen.pojo.dto.UserLoginDTO;
import com.xiaosen.pojo.dto.UserPageQueryDTO;
import com.xiaosen.pojo.entity.User;
import com.xiaosen.result.PageResult;
import com.xiaosen.sercice.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.time.LocalDateTime;
import java.util.List;


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

    public void save(UserDTO userDTO) {
        User user=new User();
        BeanUtils.copyProperties(userDTO,user);
        //1、根据用户名查询数据库中的数据
        User u = userMapper.getByPhone(user.getPhone());

        //2、处理各种异常情况（用户名不存在、密码不对、账号被锁定）
        if (u != null) {
            //账号已存在
            throw new AccountNotFoundException(MessageConstant.ALREADY_EXISTS);
        }
        //密码加密
        String password = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
        user.setPassword(password);
        //状态
        user.setState(StatusConstant.ENABLE);
        //设置时间
        user.setCreateTime(LocalDateTime.now());
        userMapper.insert(user);
    }

    public PageResult pageQuery(UserPageQueryDTO userPageQueryDTO) {
        //开始分页查询
        PageHelper.startPage(userPageQueryDTO.getPage(),userPageQueryDTO.getPageSize());
        Page<User> page=userMapper.pageQuery(userPageQueryDTO);
        long total = page.getTotal();
        List<User> result = page.getResult();
        return new PageResult(total,result);
    }
}
