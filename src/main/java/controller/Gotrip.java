package controller;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Gotrip extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response){
        doPost(response,request);
    }

    public void doPost(HttpServletResponse response, HttpServletRequest request){
        String actionName = (String)request.getAttribute("action");
        Execute executor = (String)
    }
}
