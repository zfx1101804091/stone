package org.stone.security.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@TableName("stone_user")
public class Users {
    private Long id;
    private String username;
    private String password;
}
