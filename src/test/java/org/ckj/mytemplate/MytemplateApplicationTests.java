package org.ckj.mytemplate;

import org.ckj.mytemplate.utils.BeanCustomUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest
class MytemplateApplicationTests {

    @Test
    void contextLoads() {
        String a = "";
        System.out.println(Arrays.toString(BeanCustomUtil.getNullPropertyNames(a)));
    }

}
