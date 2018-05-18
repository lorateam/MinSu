package filter;
/**
 *  过滤器BackServletFilter进行拦截，判断访问的地址是否以/admin_开头
 *  如果是，那么做如下操作
 *  取出两个下划线之间的值 room
 *  取出最后一个下划线之后的值 list
 *  然后根据这个值，服务端跳转到roomServlet，并且把list这个值传递过去
 *  roomServlet 继承了BaseBackServlet，其service方法会被调用。 在service中，借助反射技术，根据传递过来的值 list，调用对应roomServlet 中的方法lis
 *  如果访问的路径是admin_room_delete，就会调用roomServlet.delete()方法
 */

/*
import org.apache.commons.lang.StringUtils;
import java.io.IOException;
import javax.servlet.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@javax.servlet.annotation.WebFilter(filterName = "BackServletFilter")
public class BackServletFilter implements Filter {
    public void destroy() {
    }
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws ServletException, IOException
    {

        HttpServletRequest request=(HttpServletRequest)req;
        HttpServletResponse response=(HttpServletResponse)res;

        String contextPath=request.getServletContext().getContextPath();
        String uri=request.getRequestURI();
        uri= StringUtils.remove(uri,contextPath);
        if(uri.startsWith("/admin_"))
        {
            String servletPath=StringUtils.subStringBetween(uri,"_"，"_")+"Servlet";
            String method=StringUtils.subStringAfterLast(uri,"_");
            request.setAttribute("method",method);
            req.getRequestDispatcher("/"+servletPath).forward(request,response);
            return;
        }
        chain.doFilter(request, response);
    }

    public void init(FilterConfig arg0) throws ServletException {

    }

}
*/