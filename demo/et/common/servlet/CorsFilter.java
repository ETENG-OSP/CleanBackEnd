package et.common.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * Title: 跨域访问控制器
 * </p>
 * <p>
 * Copyright: Copyright (c) 2014
 * </p>
 * <p>
 * Company: Eteng
 * </p>
 * 
 * @author Wsg
 * @version 1.0
 */
public class CorsFilter implements Filter {
	
	protected FilterConfig filterConfig;

	public void init(FilterConfig config) throws ServletException {
		this.filterConfig = config;
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {	

		HttpServletResponse res =(HttpServletResponse)response;
		res.addHeader("Access-Control-Allow-Origin","*");
		res.addHeader("Access-Control-Allow-Headers","Origin, X-Requested-With, Content-Type, Accept");		
		chain.doFilter(request, response);
	}

	public void destroy() {
		this.filterConfig = null;
	}

}