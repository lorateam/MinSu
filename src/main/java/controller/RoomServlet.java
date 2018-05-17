package controller;
/*
import dao.RoomDao;
import jdk.internal.util.xml.impl.Input;
import model.Room;
import sun.net.httpserver.HttpServerImpl;
import util.ImageUtil;
import util.Page;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@javax.servlet.annotation.WebServlet(name = "RoomServlet")
public class RoomServlet extends BaseBackServlet
{
    public String add(HttpServletRequest request, HttpServletResponse response, Page page)
    {
        Map<String,String> params=new HashMap<>();
        InputStream is=super.parseUpload(request,params);
        String room_type=params.get("room_type");
        Room r=new Room();
        r.setRoom_type(room_type);

        File imageFolder=new File(request.getSession().getServletContext().getRealPath("img/room"))
        File file=new File(imageFolder,r.getId()+".jpg");
        try
        {
            if(null!=is&&0!=is.available())
            {
                try(FileOutputStream fos=new FileOutputStream(file))
                {
                    byte b[]=new byte[2014*1024];
                    int length=0;
                    while(-1!=(length=is.read(b)))
                    {
                        fos.write(b,0,length);
                    }
                    fos.flush();
                    BufferedImage img= ImageUtil.chageToJpg(file);
                    ImageIO.write(img,"jpg",file);
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        return "@admin_room_list";
    }

    public String delete(HttpServletRequest request,HttpServletResponse response,Page page)
    {
        long id=Integer.parseInt(request.getParameter("id"));
        RoomDao.delete(id);
        return "@admin_room_list";
    }

    public String edit(HttpServletRequest request,HttpServletResponse response,Page page)
    {
        long id=Integer.parseInt(request.getParameter("id"));
        Room r=RoomDao.get(id);
        request.setAttribute("r",r);
        return "page/admin/editRoom.jsp";
    }

    public String update(HttpServletRequest request,HttpServletResponse response,Page page)
    {
        Map<String,String> params=new HashMap<>();
        InputStream is=super.parseUpload(request,params);
        String room_type=params.get("room_type");
        long id=Integer.parseInt(params.get("id"));

        Room r=new Room();
        r.setId(id);
        r.setRoom_type(room_type);
        roomDao.update(r);

        File imageFolder=new File(request.getSession().getServletContext().getRealPath("img/room"));
        File file=new File(imageFolder,r.getId()+".jpg");
        file.getParentFile().mkdirs();

        try
        {
            if(null!=is&&0!=available())
            {
                try(FileOutputStream fos=new FileOutputStream(file))
                {
                    byte b[]=new byte[2014*1024];
                    int length=0;
                    while(-1!=(length=is.read(b)))
                    {
                        fos.write(b,0,length);
                    }
                    fos.flush();
                    BufferedImage img=ImageUtil.chageToJpg(file);
                    ImageIO.write(img,"jpg",file);
                }
                catch (Exception E)
                {
                    E.printStackTrace();
                }
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return "@admin_room_list";
    }

    public String list(HttpServletRequest request,HttpServletResponse response,Page page)
    {
        List<Room> rs=roomDao.list(page.getStart(),page.getCount());
        int total=roomDao.getTotal();
        page.setTotal(total);
        request.setAttribute("thers",rs);
        request.setAttribute("page",page);
        return "admin/listRoom.jsp";

    }

}
*/