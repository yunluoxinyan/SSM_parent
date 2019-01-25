package com.mabiao.util;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.PropertyFilter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.mabiao.domain.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class JsonUtil {

	private static final Logger log = LogManager.getLogger();

	public static String toString(Object obj, PropertyFilter propertyFilter) {
		if (obj == null) {
			return null;
		}

		try {
			return JSON.toJSONString(obj, propertyFilter, SerializerFeature.WriteMapNullValue);
		} catch (Throwable t) {
			log.error("toString err!", t);
		}
		return null;
	}

	public static String toStringWithDateFormat(Object obj) {
		if (obj == null) {
			return null;
		}

		try {
			return JSON.toJSONString(obj, SerializerFeature.WriteDateUseDateFormat, SerializerFeature.WriteMapNullValue);
		} catch (Throwable t) {
			log.error("toString err!", t);
		}
		return null;
	}

	public static String toString(Object obj) {
		if (obj == null)
			return null;

		try {
			return JSON.toJSONString(obj, SerializerFeature.WriteMapNullValue, SerializerFeature.DisableCircularReferenceDetect);
		} catch (Throwable t) {
			log.error("toString err!", t);
		}
		return null;
	}

	public static String toString(Object obj, SerializerFeature... serializerFeature) {
		if (obj == null)
			return null;
		try {
			return JSON.toJSONString(obj, serializerFeature);
		} catch (Throwable t) {
			log.error("toString err!", t);
		}
		return null;
	}

	public static <T> T toObject(String json, TypeReference<T> tr) {
		if (BaseUtil.isNullOrEmpty(json))
			return null;

		try {
			return JSON.parseObject(json, tr);
		} catch (Throwable t) {
			log.error("toObject by TypeReference err!", t);
		}
		return null;
	}

	public static <T> T toObject(String json, Class<T> clz) {
		if (BaseUtil.isNullOrEmpty(json))
			return null;

		try {
			return JSON.parseObject(json, clz);
		} catch (Throwable t) {
			log.error("toObject err!", t);
		}
		return null;
	}

	public static <T> List<T> toArray(String json, Class<T> clz) {
		if (BaseUtil.isNullOrEmpty(json))
			return null;

		try {
			return JSON.parseArray(json, clz);
		} catch (Throwable t) {
			log.error("toObject err!", t);
		}
		return null;
	}


	public static void main(String[] args) {
		User u = new User();
		u.setAge(18);
		u.setName("tom");
		System.out.println(JsonUtil.toString(u));
	}
}