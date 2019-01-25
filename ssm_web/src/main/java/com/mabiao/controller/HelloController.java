package com.mabiao.controller;

import com.mabiao.domain.web.User;
import com.mabiao.validate.FormValidate;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

import java.util.List;

import static com.mongodb.util.MyAsserts.assertTrue;

/**
 * @author created by mabiao on 2018/6/6
 */
@Controller
public class HelloController {

	@Resource
	private FormValidate formValidate;

	@RequestMapping("/hello")
	public String hello(){
		return "index";
	}

	@RequestMapping("/submit")
	public String submit(User user){
		BindException errors = new BindException(user,"usermd");
		ValidationUtils.invokeValidator(formValidate,user,errors);
		assertTrue(errors.hasErrors());
//		Map<String, Object> map = errors.getBindingResult().getModel();
//		BindingResult result = (BindingResult)map.get("org.springframework.validation.BindingResult.usermd");
//		Map<String, Object> model = result.getModel();
//		for (Map.Entry<String, Object> entry : model.entrySet()) {
//			System.out.println("key:" + entry.getKey());
//			System.out.println("value:" + entry.getValue());
//			System.out.println("-----------------");
//		}
		List<ObjectError> allErrors = errors.getAllErrors();
		for (ObjectError error : allErrors) {
			System.out.println(error.getCode());
			System.out.println(error.getDefaultMessage());
		}
		return null;
	}
}
