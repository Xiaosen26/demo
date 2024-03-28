package com.xiaosen.sercice;

import com.xiaosen.pojo.dto.UserLoginDTO;
import com.xiaosen.pojo.entity.User;

public interface UserService {
    User login(UserLoginDTO userLoginDTO);
}
