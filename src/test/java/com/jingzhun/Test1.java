package com.jingzhun;



import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sun.security.util.LegacyAlgorithmConstraints;

import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2019/2/26 0026.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes= App.class)
@Slf4j
public class Test1 {
    /*@Autowired
    private UserService us;
    @Test
    public void Test1(){
        List<User> users = us.selectAll();
        System.out.println(users);
    }*/
    @Test
    public void test1(){
        String s=UUID.randomUUID().toString().replace("-","");
        int length = s.length();
        log.error(length+"长度为");
        for (int i = 0; i < 8; i++) {
            log.error(UUID.randomUUID().toString().replace("-",""));

        }

    }



}
