package com.oauth.util;

/**
 * @author ：zhangqiang
 * @create ：2019-01-24 19:14
 **/
public class BaiduResultUtil{

	//0 :成功
	public static BaiduResult Success(Object data){
		BaiduResult result=new BaiduResult();
		result.setErrno(0);
		result.setData(data);
		result.setMessage("success");
		return result;
	}

	//1 :请求参数错误
	public static BaiduResult ParamError(){
		BaiduResult result=new BaiduResult();
		result.setErrno(1);
		result.setMessage("请求参数错误");
		return result;
	}

	//2 :token校验失败
	public static BaiduResult TokenCheckError(){
		BaiduResult result=new BaiduResult();
		result.setErrno(2);
		result.setMessage("token校验失败");
		return result;
	}


	//3 :系统错误
	public static BaiduResult SystemError(){
		BaiduResult result=new BaiduResult();
		result.setErrno(3);
		result.setMessage("系统错误");
		return result;
	}

	//10 :用户未登录（必须登录的接口，未传token或者token非法
	public static BaiduResult NotLogin(){
		BaiduResult result=new BaiduResult();
		result.setErrno(10);
		result.setMessage("token错误");
		return result;
	}


	//11 :access token已过期（必须登录的接口，已传token，但是token过期）
	public static BaiduResult TokenExpired(){
		BaiduResult result=new BaiduResult();
		result.setErrno(11);
		result.setMessage("token过期,请刷新");
		return result;
	}

	//12 :用户无权限（用户需要购买）
	public static BaiduResult NeedBuy(){
		BaiduResult result=new BaiduResult();
		result.setErrno(12);
		result.setMessage("未购买");
		return result;
	}

	//13 :用户已有权限（不允许重复购买)
	public static BaiduResult RepeatPurchase(){
		BaiduResult result=new BaiduResult();
		result.setErrno(13);
		result.setMessage("不允许重复购买");
		return result;
	}

	//100 :其他错误
	public static BaiduResult OtherError(){
		BaiduResult result=new BaiduResult();
		result.setErrno(100);
		result.setMessage("其他错误");
		return result;
	}
}


