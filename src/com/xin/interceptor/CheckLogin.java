package com.xin.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
/**
 * 
    * @ClassName: BonusAction
    * @Description: TODO(这里用一句话描述这个类的作用)
    * @author 追鑫少年
    * @date 2017年6月1日
    *
 */
public class CheckLogin implements Interceptor {

	private static final long serialVersionUID = 1L;

	@Override
	public void destroy() {
		System.out.println("------CheckLogin.destroy------");
	}

	@Override
	public void init() {
		System.out.println("------CheckLogin.init------");

	}

	@SuppressWarnings("rawtypes")
	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		
		System.out.println("------CheckLogin.intercept------");
		
		Map session=ActionContext.getContext().getSession();
		
		System.out.println(session.get("user.id"));
		
		if(session.get("user.id")!=null)
		{			
			return arg0.invoke();
		}
		
		return "checkLoginFail";
	}

}
