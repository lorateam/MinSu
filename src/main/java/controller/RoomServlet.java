package controller;

import model.Room;
import util.Page;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

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

    }
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }
}
