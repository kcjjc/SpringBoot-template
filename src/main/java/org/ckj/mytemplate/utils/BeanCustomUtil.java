package org.ckj.mytemplate.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.beans.PropertyDescriptor;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author: ckj
 * @CreateTime: 2024-11-07  17:41
 * @Description: 工具类
 * @Version: 1.0
 */
public class BeanCustomUtil {

    public BeanCustomUtil(){
    }

    
    /**
     * @description: 获取空属性名数组
     * @author: ckj
     * @date: 2024/11/8 上午9:17
     * @param: [source]
     * @return: java.lang.String[]
    **/
    public static String[] getNullPropertyNames(Object source){
        BeanWrapper beanWrapper =new BeanWrapperImpl(source);
        PropertyDescriptor[] pds = beanWrapper.getPropertyDescriptors();
        Set<String> emptyNames = new HashSet<>();
        PropertyDescriptor[] var4 = pds;
        int var5 = pds.length;
        for(int var6 = 0; var6 < var5; ++var6) {
            PropertyDescriptor pd = var4[var6];
            Object srcValue = beanWrapper.getPropertyValue(pd.getName());
            if ("".equals(srcValue)) {
                emptyNames.add(pd.getName());
            }
        }

        String[] result = new String[emptyNames.size()];
        return (String[])emptyNames.toArray(result);
    }

    /**
     * @description: 拷贝属性
     * @author: ckj
     * @date: 2024/11/8 上午9:31
     * @param: [src, dst]
     * @return: void
    **/
    public static void copyProperties(Object src, Object dst) {
        BeanUtils.copyProperties(src, dst, getNullPropertyNames(src));
    }

    /**
     * @description: 对象转map
     * @author: ckj
     * @date: 2024/11/8 上午9:32
     * @param: [obj]
     * @return: java.util.Map
    **/
    public static Map toMap(Object obj) {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.convertValue(obj, Map.class);
    }
}
