package com.xiaosen.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    private Long id;

    private String name;

    private String password;

    private String phone;

    private String email;
    private Integer sId;
    //0:禁用账号 1:普通用户  2:管理员
    private Integer state;
    private Integer number;

    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
}
