package com.ke.css.cimp.vo;

import java.lang.reflect.Method;

public class ObjectVo {
	private Object parserObj = new Object();
	private Object xmlDisplayerObj = new Object();
	private Method parserMethod = null;
	private Method ruleMethod = null;

	public ObjectVo(Object parserObj, Object xmlDisplayerObj, Method parserMethod, Method ruleMethod) {
		super();
		this.parserObj = parserObj;
		this.xmlDisplayerObj = xmlDisplayerObj;
		this.parserMethod = parserMethod;
		this.ruleMethod = ruleMethod;
	}

	public ObjectVo() {
		super();
	}

	public Object getParserObj() {
		return parserObj;
	}

	public void setParserObj(Object parserObj) {
		this.parserObj = parserObj;
	}

	public Object getXmlDisplayerObj() {
		return xmlDisplayerObj;
	}

	public void setXmlDisplayerObj(Object xmlDisplayerObj) {
		this.xmlDisplayerObj = xmlDisplayerObj;
	}

	public Method getParserMethod() {
		return parserMethod;
	}

	public void setParserMethod(Method parserMethod) {
		this.parserMethod = parserMethod;
	}

	public Method getRuleMethod() {
		return ruleMethod;
	}

	public void setRuleMethod(Method ruleMethod) {
		this.ruleMethod = ruleMethod;
	}

}
