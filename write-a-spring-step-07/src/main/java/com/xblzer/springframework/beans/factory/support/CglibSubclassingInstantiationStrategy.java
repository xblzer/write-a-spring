package com.xblzer.springframework.beans.factory.support;

import com.xblzer.springframework.beans.BeansException;
import com.xblzer.springframework.beans.factory.config.BeanDefinition;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

import java.lang.reflect.Constructor;

/**
 * @author 行百里者
 * @date 2022-07-25 23:13
 */
public class CglibSubclassingInstantiationStrategy implements InstantiationStrategy {
    /**
     * 实例化对象
     *
     * @param beanDefinition Bean 信息定义
     * @param beanName       Bean 名称
     * @param ctor           构造方法
     * @param args           参数
     * @return 实例化对象
     * @throws BeansException 抛出 BeansException 异常
     */
    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(beanDefinition.getBeanClass());
        enhancer.setCallback(new NoOp() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });
        if (ctor != null) {
            return enhancer.create(ctor.getParameterTypes(), args);
        }
        return enhancer.create();
    }
}
