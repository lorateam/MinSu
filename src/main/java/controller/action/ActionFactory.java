package controller.action;
import com.sun.deploy.net.HttpRequest;

import javax.servlet.http.HttpServletRequest;

public class ActionFactory {
    public static Action getAction(String actionName, HttpServletRequest request){
        if(actionName.equals("getuser")){
            //未完成从request解析数据
            return new GetUsers();
        }
        return null;
    }
}
