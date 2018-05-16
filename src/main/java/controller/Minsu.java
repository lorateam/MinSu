package controller;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class Minsu extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response){
        doPost(response,request);
    }

    public void doPost(HttpServletResponse response, HttpServletRequest request){
        String url = request.getPathInfo();
        String[] urls = url.split("/");
        Map<String, String[]> data = request.getParameterMap();
        
    }
}
