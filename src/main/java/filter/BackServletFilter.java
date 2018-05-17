package filter;

import com.sun.xml.internal.ws.util.StringUtils;

import java.io.IOException;
import java.util.logging.Filter;

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
            String servletPath=StrtingUtils.subStringBetween(uri,"_"，"_")+"Servlet";
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
