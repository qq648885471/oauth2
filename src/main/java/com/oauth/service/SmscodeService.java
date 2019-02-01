package com.oauth.service;

/**
 * @author ：zhangqiang
 * @create ：2019-01-23 16:24
 **/
public interface SmscodeService {

	String sendSmscode(String mobile);

	boolean checkSmscode(String mobile, String code);


}
