package com.mabiao.controller;

import org.joda.time.DateTime;
import org.springframework.beans.factory.FactoryBean;

/**
 * 自定义实现工厂bean  生成的bean对象为datetime类型
 * <bean id="nextDayDate" class="NextDayDateFactoryBean"></bean>
 * @author created by mabiao on 2018/6/6
 */
public class NextDayDateFactoryBean implements FactoryBean {
	@Override
	public Object getObject() {
		return new DateTime().plusDays(1);
	}

	@Override
	public Class<?> getObjectType() {
		return DateTime.class;
	}

	@Override
	public boolean isSingleton() {
		return false;
	}
}
