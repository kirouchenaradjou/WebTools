package com.raghavi.insurance.filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * Servlet Filter implementation class InsuranceFilter
 */
public class InsuranceFilter implements Filter {

    /**
     * Default constructor. 
     */
    public InsuranceFilter() {
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
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		chain.doFilter(new FilteredRequest(request), response);

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
	static class FilteredRequest extends HttpServletRequestWrapper {

		public FilteredRequest(ServletRequest request) {
			super((HttpServletRequest) request);
		}

		public String sanitize(String c) {
			Pattern pt = Pattern.compile("[^a-zA-Z0-9]");
			if (c != null) {
				Matcher match = pt.matcher(c);
				while (match.find()) {
					String s = match.group();
					c = c.replaceAll("\\" + s, "");
				}
			}
			return c;
		}

		public String getParameter(String paramName) {
			String value = super.getParameter(paramName);
			value = sanitize(value);
			return value;
		}

		public String[] getParameterValues(String paramName) {
			String values[] = super.getParameterValues(paramName);
			for (int index = 0; index < values.length; index++) {
				values[index] = sanitize(values[index]);
			}
			return values;
		}

		public Map getParameterMap() {
			Map<String, String[]> map1 = super.getParameterMap();
			Map<String, String[]> map = new HashMap<String, String[]>();
			for (Map.Entry<String, String[]> entry : map1.entrySet()) {
				String[] strs = {};
				int i = 0;
				for (String str : entry.getValue()) {
					strs[i++] = sanitize(str);
				}
				map.put(entry.getKey(), strs);
			}

			return map;
		}
	}
}
