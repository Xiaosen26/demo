package com.xiaosen.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO implements Serializable {
    private String name;
    private String password;
    private Integer sId;
    private Integer number;
    private String phone;
    private String email;

}
