<<<<<<< HEAD
package controller;

import dao.OrderDao;
import dao.RoomDao;
import dao.SellerDao;
import dao.UserDao;
import model.Seller;
import util.Page;

public abstract class BaseBackServlet extends HttpServlet
{
    public abstract String add(HttpServletRequest request,HttpServletResponse response,Page page);
    public abstract String delete(HttpServletRequest request,HttpServletResponse response,Page page);
    public abstract String edit(HttpServletRequest request,HttpServletResponse response,Page page);
    public abstract String update(HttpServletRequest request,HttpServletResponse response,Page page);
    public abstract String list(HttpServletRequest request,HttpServletResponse response,Page page);

    protected OrderDao orderDao=new OrderDao();
    protected RoomDao roomDao=new RoomDao();
    protected SellerDao sellerDao=new SellerDao();
    protected UserDao userDao=new UserDao();

    public void service(HttpservletRequest request,HttpServletResponse response)
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
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
=======
//package controller;
//
//import dao.OrderDao;
//import dao.RoomDao;
//import dao.SellerDao;
//import dao.UserDao;
//import model.Seller;
//
//public abstract class BaseBackServlet extends HttpServlet
//{
//    public abstract String add(HttpServletRequest request,HttpServletResponse response,Page page);
//    public abstract String delete(HttpServletRequest request,HttpServletResponse response,Page page);
//    public abstract String edit(HttpServletRequest request,HttpServletResponse response,Page page);
//    public abstract String update(HttpServletRequest request,HttpServletResponse response,Page page);
//    public abstract String list(HttpServletRequest request,HttpServletResponse response,Page page);
//
//    protected OrderDao orderDao=new OrderDao();
//    protected RoomDao roomDao=new RoomDao();
//    protected SellerDao sellerDao=new SellerDao();
//    protected UserDao userDao=new UserDao();
//
//    public void service(HttpservletRequest request,HttpServletResponse response)
//    {
//        try
//        {
//            int start=0;
//            int count=5;
//            try
//            {
//                start=Integer.parseInt(request.getParameter("page.start"));
//            }
//            catch (Exception e)
//            {
//                e.printStackTrace();
//            }
//            try
//            {
//                count=Integer.parseInt(request.getParameter("page.count"));
//            }
//            catch(Exception e)
//            {
//                e.printStackTrace();
//            }
//            Page page=new Page(start,count);
//        }
//        catch ()
//        {
//
//        }
//    }
//}
>>>>>>> 5248630f2bcba3fb6b72326a81e0617cbc5aa28b
