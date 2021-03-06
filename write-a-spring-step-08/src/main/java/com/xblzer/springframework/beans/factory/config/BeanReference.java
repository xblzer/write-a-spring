package com.xblzer.springframework.beans.factory.config;

/**
 * @author 行百里者
 * @date 2022-08-03 18:10
 */
public class BeanReference {

    private final String beanName;

    public BeanReference(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }
}
