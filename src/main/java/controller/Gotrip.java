package controller;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controller.action.*;

public class Gotrip extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response){
        doPost(response,request);
    }

    public void doPost(HttpServletResponse response, HttpServletRequest request){
        String actionName = (String)request.getAttribute("action");
        Action action = ActionFactory.getAction("action",request);
    }
}
