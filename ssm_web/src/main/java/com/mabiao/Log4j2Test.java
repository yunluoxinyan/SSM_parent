package com.mabiao;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author created by mabiao on 2018/8/22
 */
public class Log4j2Test {

	public static void main(String[] args) {
		Logger logger = LoggerFactory.getLogger(Log4j2Test.class);

		logger.trace("trace");
		logger.debug("debug");
		logger.info("mabiao");
		logger.warn("warn");
		logger.error("error");
	}
}
