package com.xin.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.xin.bean.Employee;
import com.xin.bean.User;
import com.xin.security.Md5;
import com.xin.service.IEmployeeManage;
import com.xin.service.IUserManage;
/**
 * 
    * @ClassName: BonusAction
    * @Description: TODO(这里用一句话描述这个类的作用)
    * @author 追鑫少年
    * @date 2017年6月1日
    *
 */
public class LoginAction extends ActionSupport {
    /**
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
     */
    private static final long serialVersionUID = 1L;
    private User user;// 用户实例
    private String inputCaptcha;// 输入的验证码
    private String autoCaptcha;// session中保存的验证码

    @Resource
    private IUserManage userManage;

    @Resource
    private IEmployeeManage iEmployeeManage;

    public User getUser() {
	return user;
    }

    public void setUser(User user) {
	this.user = user;
    }

    public IUserManage getUserManage() {
	return userManage;
    }

    public void setUserManage(IUserManage userManage) {
	this.userManage = userManage;
    }

    public String getInputCaptcha() {
	return inputCaptcha;
    }

    public void setInputCaptcha(String inputCaptcha) {
	this.inputCaptcha = inputCaptcha;
    }

    public String getAutoCaptcha() {
	return autoCaptcha;
    }

    public void setAutoCaptcha(String autoCaptcha) {
	this.autoCaptcha = autoCaptcha;
    }

    public IEmployeeManage getiEmployeeManage() {
	return iEmployeeManage;
    }

    public void setiEmployeeManage(IEmployeeManage iEmployeeManage) {
	this.iEmployeeManage = iEmployeeManage;
    }

    
        
        
        
        /**
         * 创建一个新的实例 LoginAction.
         *
         */
        
    public LoginAction() {
        super();
    }

        /**
         * 创建一个新的实例 LoginAction.
         *
         * @param user
         * @param inputCaptcha
         * @param autoCaptcha
         * @param userManage
         * @param iEmployeeManage
         */
        
    public LoginAction(User user, String inputCaptcha, String autoCaptcha, IUserManage userManage,
                       IEmployeeManage iEmployeeManage) {
        super();
        this.user = user;
        this.inputCaptcha = inputCaptcha;
        this.autoCaptcha = autoCaptcha;
        this.userManage = userManage;
        this.iEmployeeManage = iEmployeeManage;
    }


    /*
     * 判断字符串是否为整数形式
     */
    public static boolean isInteger(String value) {
	try {
	    Integer.parseInt(value);
	    return true;
	} catch (NumberFormatException e) {
	    return false;
	}
    }

    /*
     * 判断数字是否满足特定职工号码段范围
     */
    public static boolean isValid(int value) {
	if (value >= 100000 && value <= 999999)
	    return true;
	return false;
    }

    @SuppressWarnings({ "unused", "rawtypes", "unchecked" })
    @Override
    public String execute() throws Exception {
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss E");// 系统当前时间
	String loginErrorInfo;// 登录错误信息
	System.out.println(dateFormat.format(new Date()));// 打印系统当前时间
	Map session = ActionContext.getContext().getSession();// 获取login页面中的session信息
	HttpServletRequest request = ServletActionContext.getRequest();// 获取request请求
	System.out.println(request.getCharacterEncoding());// 打印login页面的字符集

	System.out.println("用户登录，职工号=" + user.getId());// 打印用户名
	String userIdString = user.getId().toString(), UserPassword = user.getPassword();

	if (!isInteger(userIdString)) {// 判断职工号是否是纯数字
	    System.out.println("登录失败，用户名=" + userIdString + "，用户名应为纯数字");
	    session.put("loginErrorInfo", "职工号应为纯数字！");// 设置loginErrorInfo的内容
	    return "fail";
	}

	Integer userNameInteger = Integer.parseInt(userIdString);// 将字符串转换为整型

	if (!isValid(userNameInteger)) {// 判断数字是否满足特定职工号码段范围
	    System.out.println("登录失败，用户名=" + user.getId().toString() + "，用户名应为满足职工号范围的6位数字");
	    session.put("loginErrorInfo", "职工号应为六位数字！");
	    return "fail";
	}

	if (userManage.findUserById(userNameInteger) == null) {// 用户不存在
	    System.out.println("登录失败，用户名=" + user.getId().toString() + "，用户名不存在");
	    session.put("loginErrorInfo", "职工号不存在！");
	    return "fail";
	}

	String CorrectUserPassword = userManage.findUserById(user.getId()).getPassword();// 保存数据库中对应用户的密码

	System.out.println(CorrectUserPassword);// 打印数据库中加密的密码

	autoCaptcha = (String) session.get("SESSION_SECURITY_CODE");// 获取session中的验证码

	if (Md5.validatePassword(CorrectUserPassword, UserPassword)) {// 判断用户录入的密码是否与数据库中的一致

	    System.out.println(inputCaptcha);// 打印输入的验证码
	    System.out.println(autoCaptcha);// 打印session中的验证码
	    if (inputCaptcha.equalsIgnoreCase(autoCaptcha)) {// 判断验证码是否一致
		session.put("user.id", userIdString);// 将用户名保存到session中
		session.put("user.userType", userManage.findUserById(Integer.parseInt(userIdString)).getUserType());// 将用户类型保存到session中
		System.out.println("登录成功，用户名=" + userIdString + "  密码Md5=" + CorrectUserPassword);

		Employee employeeLogin = iEmployeeManage.findEmployeeById(userNameInteger);// 查询职工号用户名的职工信息
		// System.out.println(employeeLogin);

		session.put("employeeLogin", employeeLogin);// 将职工信息保存到session中

		if (userManage.findUserById(userNameInteger).getUserType() == 1) {// 1表示操作员
		    return "admin";
		} else if (userManage.findUserById(userNameInteger).getUserType() == 0)// 0表示普通用户
		    return "success";
		else {
		    System.out.println("用户类型未定义");
		    return "fail";
		}
	    } else {
		System.out.println(inputCaptcha);// 打印用户录入的验证码
		System.out.println(autoCaptcha);// 打印session中的验证码
		System.out.println("验证码错误");
		session.put("loginErrorInfo", "验证码错误！");// 将错误信息保存到session中
		return "fail";
	    }
	}

	System.out.println("登录失败，用户名=" + userIdString + "  正确密码Md5=" + CorrectUserPassword + "   您的密码Md5="
		+ Md5.generatePassword(UserPassword));
	session.put("loginErrorInfo", "密码错误！");
	return "fail";
    }

    /**
     * 
     * @Title: logout @Description: TODO(登出)
     * @author Hou Dongchang @return @throws
     */
    public String logout() {
	Map<String, Object> session = ActionContext.getContext().getSession();
	if (session.containsKey("user.id")) {
	    session.remove("user.id");
	    session.clear();
	    session.put("loginErrorInfo", "注销成功！");
	    return "success";
	} else {
	    return "fail";
	}
    }
}