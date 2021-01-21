package org.stone.security.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@TableName("user")
public class Users {
    private Integer id;
    private String username;
    private String password;
}
