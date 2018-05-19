package dao;

import com.sun.org.apache.regexp.internal.RE;
import model.User;
import util.DBUtil;

import java.sql.*;

public class UserDao
{
    public int getTotal()
    {
        int total=0;
        try(Connection c= DBUtil.getConnection(); Statement s=c.createStatement();)
        {
            String sql="select count(*) from user";

            ResultSet rs=s.executeQuery(sql);
            while(rs.next())
            {
                total=rs.getInt(1);
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return total;
    }

    public void add(User bean)throws Exception
    {
        Statement s = DBUtil.getStatement();
            String sql = String.format(" INSERT INTO user(account, password, name, head_image, email) values('%s', '%s', '%s', '%s', '%s');",
                    bean.getAccount(), bean.getPassword(), bean.getName(), bean.getHead_image(), bean.getEmail());
            System.out.print(sql);
            s.execute(sql);
    }

    public void delete(long id)
    {
        try(Connection c=DBUtil.getConnection();Statement s=c.createStatement();)
        {
            String sql="delete from user where id="+id;
            s.execute(sql);
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(User bean)
    {
        String sql="update user set account=?,password=?,name=?,create_time=?,head_image=?,email=? where id=?";
        try(Connection c=DBUtil.getConnection();PreparedStatement ps=c.prepareStatement(sql);)
        {
            ps.setString(1,bean.getAccount());
            ps.setString(2,bean.getPassword());
            ps.setString(3,bean.getName());
            ps.setString(4,bean.getCreate_time());
            ps.setString(5,bean.getHead_image());
            ps.setString(6,bean.getEmail());
            ps.setLong(7,bean.getId());
            ps.execute();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public User get(long id)
    {
        User bean=new User();
        try(Connection c=DBUtil.getConnection();Statement ps=c.createStatement();)
        {
            String sql="select * from User where id="+id;
            ResultSet rs= ps.executeQuery(sql);
            if(rs.next())
            {
                String account=rs.getString("account");
                String password=rs.getString("password");
                String name=rs.getString("name");
                String create_time=rs.getString("create_time");
                String head_image=rs.getString("head_image");
                String email=rs.getString("email");

                bean.setAccount(account);
                bean.setPassword(password);
                bean.setName(name);
                bean.setCreate_time(create_time);
                bean.setHead_image(head_image);
                bean.setEmail(email);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }
}
