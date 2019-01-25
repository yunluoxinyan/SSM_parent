package com.mabiao.controller;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;

import java.beans.PropertyEditor;
import java.util.Date;

/**
 * @author created by mabiao on 2018/6/8
 */
public class DatePropertyEditorRegistrar implements PropertyEditorRegistrar{

	private PropertyEditor propertyEditor;

	@Override
	public void registerCustomEditors(PropertyEditorRegistry propertyEditorRegistry) {
		propertyEditorRegistry.registerCustomEditor(Date.class,getPropertyEditor());
	}

	public PropertyEditor getPropertyEditor() {
		return propertyEditor;
	}

	public void setPropertyEditor(PropertyEditor propertyEditor) {
		this.propertyEditor = propertyEditor;
	}
}
