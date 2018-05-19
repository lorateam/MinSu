package model;

import com.alibaba.fastjson.JSONObject;


import java.lang.reflect.Field;
//Mosel抽象类，提供共用方法。
public abstract class BaseModel {

    //将model对象转化为json
    public JSONObject toJSON() throws Exception{
        Class clazz = Class.forName(this.getClass().getName());
        Field[] fields = clazz.getDeclaredFields();
        JSONObject json = new JSONObject();
        for(Field f: fields){
            f.setAccessible(true);
            json.put(f.getName(),f.get(this));
        }
        return json;
    }


}
