package controller;
import dao.OrderDao;
import dao.RoomDao;
import dao.OrderDao;
import dao.RoomDao;
import dao.SellerDao;
import dao.UserDao;
import model.Seller;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import util.Page;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
    /*
        这个是个servlet抽象出来的基类
        增删改查编辑的接口
        在操作时不用再去new 对象了
    */
public abstract class BaseBackServlet extends HttpServlet
{
    protected BaseBackServlet() throws Exception {
    }

    public abstract String add(HttpServletRequest request, HttpServletResponse response, Page page);
    public abstract String delete(HttpServletRequest request,HttpServletResponse response,Page page);
    public abstract String edit(HttpServletRequest request,HttpServletResponse response,Page page);
    public abstract String update(HttpServletRequest request,HttpServletResponse response,Page page);
    public abstract String list(HttpServletRequest request,HttpServletResponse response,Page page);

    protected OrderDao orderDao=new OrderDao();
    protected RoomDao roomDao=new RoomDao();
    protected SellerDao sellerDao=new SellerDao();
    protected UserDao userDao=new UserDao();

    public void service(HttpServletRequest request,HttpServletResponse response)
    {
        try
        {

            int start=0;
            int count=5;
            try
            {
                start=Integer.parseInt(request.getParameter("page.start"));
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            try
            {
                count=Integer.parseInt(request.getParameter("page.count"));
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            Page page=new Page(start,count);

            //借助反射，调用相应的方法
            String method=(String)request.getAttribute("method");
            Method m=this.getClass().getMethod(method,javax.servlet.http.HttpServletRequest.class,javax.servlet.http.HttpServletResponse.class,Page.class);
            String redirect=m.invoke(this,request,response,page).toString();

            //根据方法的反射值，进行相应的客户端跳转"头部是@"，服务器跳转"头部是%"，或者其他输出字符串操作
            if(redirect.startsWith("@"))
                response.sendRedirect(redirect.substring(1));
            else if(redirect.startsWith("%"))
                response.getWriter().print(redirect.substring(1));
            else
                request.getRequestDispatcher(redirect).forward(request,response);

        }
        catch (Exception e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public InputStream parseUpload(HttpServletRequest request,Map<String,String> params)
    {
          //这是上传图片的函数，因为我们的房源各种需要图片上传
        InputStream is=null;
        try
        {
            DiskFileItemFactory factory=new DiskFileItemFactory();
            ServletFileUpload upload=new ServletFileUpload(factory);

            factory.setSizeThreshold(1024*1024*10);

            List items=upload.parseRequest(request);
            Iterator iter=items.iterator();
            while(iter.hasNext())
            {
                FileItem item=(FileItem)iter.next();
                if(!item.isFormField())
                {
                    is=item.getInputStream();
                }
                else
                {
                    String paramName=item.getFieldName();
                    String paramValue=item.getString();
                    paramValue=new String(paramValue.getBytes("ISO-8859-1"),"utf-8");
                    params.put(paramName,paramValue);
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return is;
    }
}