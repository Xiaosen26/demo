package com.xiaosen.mapper;

import com.github.pagehelper.Page;
import com.xiaosen.pojo.dto.UserPageQueryDTO;
import com.xiaosen.pojo.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("select * from user where phone=#{phone}")
    User getByPhone(String phone);
    @Insert("insert into user(name,phone,password,email,state,s_id,number,create_time)" +
        "VALUES (#{name},#{phone},#{password},#{email},#{state},#{sId},#{number},#{createTime})")
    void insert(User user);

    Page<User> pageQuery(UserPageQueryDTO userPageQueryDTO);
}
