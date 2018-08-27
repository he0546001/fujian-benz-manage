package fujian.benz.manage.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * 统一编码过滤器
 * @author APPle
 *
 */
public class EncodingFilter implements Filter{

	public void destroy() {
	}

	//执行业务
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		//POST问题
		req.setCharacterEncoding("utf-8");
		
		
		//GET问题，使用装饰者模式
		//创建一个request的装饰类
		MyRequest myRequest = new MyRequest((HttpServletRequest) req);
		
		//放行（注意：必须放行的是装饰后的request对象）
		chain.doFilter(myRequest, resp);
	}

	public void init(FilterConfig arg0) throws ServletException {
	}

	
}

//装饰HttpServletRequest
//装饰步骤
//1.写一个装饰类，去继承被装饰类（如果是接口，则找它的实现类） （非final） 
class MyRequest extends HttpServletRequestWrapper{

	//2.声明一个被装饰类类型的引用
	private HttpServletRequest request;
	
	public MyRequest(HttpServletRequest request) {
		super(request);
		//3.接收传入的被装饰类对象
		this.request = request;
	}
	
	//4.重写需要装饰的方法
	@Override
	public String getParameter(String name) {
		try {
			String value = request.getParameter(name);
			if(value!=null && "GET".equals(request.getMethod())){
				value = new String(value.getBytes("iso-8859-1"),"utf-8");
			}
			return value;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public String[] getParameterValues(String name) {
		try {
			String[] values = request.getParameterValues(name);
			if(values!=null && "GET".equals(request.getMethod())){
				for(int i=0;i<values.length;i++){
					values[i] = new String(values[i].getBytes("iso-8859-1"),"utf-8");
				}
			}
			return values;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	
} 





