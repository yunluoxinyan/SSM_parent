package com.mabiao.validate;

import com.mabiao.domain.web.User;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * @author created by mabiao on 2018/6/16
 */
@Component
public class FormValidate implements Validator {
	@Override
	public boolean supports(Class<?> aClass) {
		return ClassUtils.isAssignable(aClass, User.class);
	}

	@Override
	public void validate(Object o, Errors errors) {
//		HelloController helloController = (HelloController) o;
		ValidationUtils.rejectIfEmpty(errors,"username","用户名为空");
		ValidationUtils.rejectIfEmpty(errors,"password","密码为空");
	}
}
