package com.xin.action;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.xin.security.SecurityCode;
import com.xin.security.SecurityImage;

import java.io.ByteArrayInputStream;
/**
 * 
    * @ClassName: BonusAction
    * @Description: TODO(这里用一句话描述这个类的作用)
    * @author 追鑫少年
    * @date 2017年6月1日
    *
 */
public class InitCaptcha{  
    //图片流
    private ByteArrayInputStream imageStream;

    public ByteArrayInputStream getImageStream() {
        return imageStream;
    }

    public void setImageStream(ByteArrayInputStream imageStream) {
        this.imageStream = imageStream;
    }

    
    
        /**
         * 创建一个新的实例 InitCaptcha.
         *
         */
        
    public InitCaptcha() {
        super();
    }

    
            /**
             * 创建一个新的实例 InitCaptcha.
             *
             * @param imageStream
             */
            
        public InitCaptcha(ByteArrayInputStream imageStream) {
            super();
            this.imageStream = imageStream;
        }

    public String execute() throws Exception {     
    	
        //获取默认难度和长度的验证码
        String securityCode = SecurityCode.getSecurityCode();
        System.out.println(securityCode);
        imageStream = SecurityImage.getImageAsInputStream(securityCode);
        //放入session中
        Map<String, Object> session = ActionContext.getContext().getSession();
        session.put("SESSION_SECURITY_CODE", securityCode);
        
        return Action.SUCCESS;
    }
}
