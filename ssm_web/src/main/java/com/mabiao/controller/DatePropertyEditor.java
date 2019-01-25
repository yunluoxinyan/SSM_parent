package com.mabiao.controller;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.beans.PropertyEditorSupport;
import java.util.Date;

/**
 * @author created by mabiao on 2018/6/8
 */
public class DatePropertyEditor extends PropertyEditorSupport {
	private String datePattern;

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(getDatePattern());
		Date dateValue = dateTimeFormatter.parseDateTime(text).toDate();
		setValue(dateValue);
	}

	public String getDatePattern() {
		return datePattern;
	}

	public void setDatePattern(String datePattern) {
		this.datePattern = datePattern;
	}
}
