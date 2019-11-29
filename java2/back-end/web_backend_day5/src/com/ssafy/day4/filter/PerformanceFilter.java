package com.ssafy.day4.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class PerformanceFilter
 */
@WebFilter("/*")
public class PerformanceFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public PerformanceFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		// 전처리
		long start = System.currentTimeMillis();
		// pass the request along the filter chain
		chain.doFilter(request, response);
		// 후처리
		long end = System.currentTimeMillis();
		// 서블릿 정보 획득 :
		ServletContext ctx = request.getServletContext();
		System.out.println(ctx.getContextPath());
		HttpServletRequest hReq = (HttpServletRequest) request;
		System.out.println(hReq.getServletPath());
		System.out.println("동작 소요 시간 : " + (end - start));
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
