package controller;
import org.json.JSONObject;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class Gotrip extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response){
        doPost(response,request);
    }

    public void doPost(HttpServletResponse response, HttpServletRequest request){
        String actionName = (String)request.getAttribute("action");
        Execute executor = new Execute();
        try
        {
            PrintWriter out = response.getWriter();
            JSONObject json = executor.execute(actionName,request);
            out.print(json);
            out.flush();
            out.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
