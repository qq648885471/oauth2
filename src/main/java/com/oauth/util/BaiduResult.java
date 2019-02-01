package com.oauth.util;

import java.io.Serializable;

/**
 * @author ：zhangqiang
 * @create ：2019-01-24 19:15
 **/
public class BaiduResult implements Serializable {
	private int errno;
	private Object data;
	private String message;

	public int getErrno() {
		return errno;
	}

	public void setErrno(int errno) {
		this.errno = errno;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
