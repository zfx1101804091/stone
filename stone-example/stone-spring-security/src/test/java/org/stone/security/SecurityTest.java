package org.stone.security;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class SecurityTest {

    @Test
    public void test(){

        //对密码进行加密 BCrypt.gensalt() 生产随机盐
        String hashpw = BCrypt.hashpw("123", BCrypt.gensalt());

        System.out.println(hashpw);

        //校验
        boolean checkpw = BCrypt.checkpw("123", "$2a$10$BnG13tbzLxgRsaDi5rad6ui6nrJ0bbV6IIj5MQE2K9TN4kVnkFK3i");
        System.out.println(checkpw);
    }
}
