package controller.action;

public class ActionFactory {
    public static ServiceInterface getService(String actionName, ){
        if(actionName.equals("getuser")){
            return new ActionFactory()
        }
        return null;
    }
}
