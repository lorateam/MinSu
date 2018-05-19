package controller;
import com.alibaba.fastjson.JSONObject;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class Gotrip extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response){
        doPost(request,response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response){
        String actionName = request.getParameter("action");
        //将request数据解析到Map
        Enumeration enu=request.getParameterNames();
        Map data = new HashMap();
        while(enu.hasMoreElements()){
            String paraName=(String)enu.nextElement();
            data.put(paraName, request.getParameter(paraName));
        }
        System.out.println(data);
        try
        {
            Execute executor = new Execute();
            PrintWriter out = response.getWriter();
            //执行对应action
            JSONObject json = executor.execute(actionName, data);
            out.print(json);
            out.flush();
            out.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
