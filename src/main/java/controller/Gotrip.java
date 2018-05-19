package controller;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import util.DirUtils;
import util.UUIDUtils;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//--------------------------------------------------重写Gotrip，因为需要包括文件信息
//public class Gotrip extends HttpServlet{
//    public void doGet(HttpServletRequest request, HttpServletResponse response){
//        doPost(request,response);
//    }
//
//    public void doPost(HttpServletRequest request, HttpServletResponse response){
//        System.out.println("处理post请求");
//        String actionName = request.getParameter("action");
//        //将request数据解析到Map
//        Enumeration enu=request.getParameterNames();
//        Map data = new HashMap();
//        while(enu.hasMoreElements()){
//            String paraName=(String)enu.nextElement();
//            data.put(paraName, request.getParameter(paraName));
//        }
//        System.out.println(data);
//        try
//        {
//            Execute executor = new Execute();
//            PrintWriter out = response.getWriter();
//            //执行对应action
//            JSONObject json = executor.execute(actionName, data);
//            out.print(json);
//            out.flush();
//            out.close();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
//}
//***********************************************重写Gotrip，因为需要包括文件信息
public class Gotrip extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response){
        doPost(request,response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response){
        //创建一个用生产FileItem(表单中的每一项)的工厂
        FileItemFactory factory = new DiskFileItemFactory();
        // 创建文件上传组件的解析对象
        ServletFileUpload upload = new ServletFileUpload(factory);
        try {
            // 通过upload.parseRequest拿到表单中的每一项
            List<FileItem> items = upload.parseRequest(request);

            // 手动创建一个Map对象,用于之后转化为bean
            Map <String,String>dataMap = new HashMap<String,String>();

            // 遍历表单项，找到文件,使用isFormField()方法，判断是否是普通的表单项
            for (FileItem item : items) {
                // 普通表单项
                if (item.isFormField()) {
                    String key = item.getFieldName();//获取input中name值
                    String value = item.getString("UTF-8");//获取input中value值
                    // 把获取到的数据保存到map中
                    dataMap.put(key, value);
                }
                // 文件
                else {
                    /* TODO：文件的抽象，此处仅就图片存储进行了操作
                     * 获取文件名称 这个文件名称，不能直接使用，因为可能存在同名的图片
                     *
                     * 这个不需要下载图片，因此文件名称可以不要
                     */
                    String fileName = item.getName();
                    // 获取文件后缀名 1.jpg，先拿到最后一个点的位置
                    int index = fileName.lastIndexOf(".");
                    // 拿到的是“.jpg”
                    fileName = fileName.substring(index);
                    // 为文件重命名dsagdasgdsadgasd
                    String UUID = UUIDUtils.getUUID();
                    // 文件的保存到服务器的名称
                    fileName = UUID + fileName;
                    // 指定图片在服务器中保存的路径
                    String savePath = "/upload";
                    // 目录分离（目录打散）,保存到服务器中的最终的目录为“/upload/2/3”
                    String dirs = DirUtils.getDir(fileName);

                    // 获取服务器的真实路径"
                    String realPath = request.getServletContext().getRealPath(
                            "");
                    // 判断保存路径是否存在，需要使用File类
                    String filePath = realPath + savePath + dirs;
                    System.out.println(filePath);
                    File file = new File(filePath);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    file = new File(file, fileName);
                    // 将文件保存到服务器中指定的位置
                    item.write(file);
                    // 保存商品的图片路径
                    dataMap.put("imgurl", savePath + dirs + "/" + fileName);
                }
            }
            //获取前端传来的Action名称
            String actionName = dataMap.get("action");
            System.out.print(actionName);

            try{
                Execute executor = new Execute();
                PrintWriter out = response.getWriter();
                //执行对应action
                JSONObject json = executor.execute(actionName, dataMap);
                out.print(json);
                out.flush();
                out.close();
            }catch (Exception e)
            {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}