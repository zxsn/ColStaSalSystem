package com.xin.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 
    * @ClassName: BonusAction
    * @Description: TODO(统一设置字符集)
    * @author 追鑫少年
    * @date 2017年6月1日
    *
 */
public class CharsetEncodingFilter implements Filter {
	
	private String encoding;
	
	public void destroy() {
	}

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
			FilterChain filterChain) throws IOException, ServletException {
	    //设置字符集
		servletRequest.setCharacterEncoding(encoding);
		filterChain.doFilter(servletRequest, servletResponse);
	}

	public void init(FilterConfig filterConfig) throws ServletException {
	  //取得初始化参数
		this.encoding = filterConfig.getInitParameter("encoding");
	}
}
