package com.xiaosen.controller.admin;

import com.github.pagehelper.PageInfo;
import com.xiaosen.constant.JwtClaimsConstant;
import com.xiaosen.pojo.dto.UserDTO;
import com.xiaosen.pojo.dto.UserLoginDTO;
import com.xiaosen.pojo.dto.UserPageQueryDTO;
import com.xiaosen.pojo.entity.User;
import com.xiaosen.pojo.vo.UserLoginVO;
import com.xiaosen.properties.JwtProperties;
import com.xiaosen.result.PageResult;
import com.xiaosen.sercice.UserService;
import com.xiaosen.utils.JwtUtil;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@Slf4j
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    private JwtProperties jwtProperties;


//    $ContentRoot$

    /**
     * 登录
     * @param phone
     * @param password
     * @param model
     * @param session
     * @return
     */
    @PostMapping("/login")
    public String login(String phone,String password , Model model, HttpSession session) {
        log.info("用户{}登录",phone);
        UserLoginDTO userLoginDTO =new UserLoginDTO(phone,password);
        User user=userService.login(userLoginDTO);
        Map<String, Object> claims = new HashMap<>();
        claims.put(JwtClaimsConstant.EMP_ID, user.getId());
        String token = JwtUtil.createJWT(
                jwtProperties.getAdminSecretKey(),
                jwtProperties.getAdminTtl(),
                claims);

        UserLoginVO userLoginVO = UserLoginVO.builder()
                .id(user.getId())
                .name(user.getName())
                .token(token)
                .build();
        // 将用户对象添加到Session
        session.setAttribute("USER_SESSION", userLoginVO);
        //用户登录成功，转发到系统首页
        return "name";
//        //如果用户名和密码不匹配，转发到登录页面，并进行提醒
//        model.addAttribute("msg", "用户名或密码错误，请重新登录！");
//        return "jsp/login";
    }

    /**
     * 员工分页查询
     * @param userPageQueryDTO
     * @param model
     * @return
     */
    @GetMapping("/page")
    public String list(UserPageQueryDTO userPageQueryDTO,Model model) {
        log.info("员工分页查询：{}",userPageQueryDTO);
        PageResult pageResult=userService.pageQuery(userPageQueryDTO);
        model.addAttribute("pageResult",pageResult);
        return "list";
    }
    /**
     * 用户注册
     * @param userDTO
     * @return
     */
    @PostMapping("/register")
    public String save(UserDTO userDTO){
        log.info("插入员工：{}",userDTO);
        userService.save(userDTO);
        return "login";
    }

    /**
     * 用户退出
     */
    @PostMapping("/logout")
    public String logout(HttpSession session) {
        // 清除Session
        session.invalidate();
        // 退出登录后重定向到登录页面
        return "login";
    }
}
