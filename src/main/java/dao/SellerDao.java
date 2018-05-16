package dao;

import model.Seller;
import util.DBUtil;

import java.sql.*;

public class SellerDao
{
    public int getTotal()
    {
        int total=0;
        try(Connection c= DBUtil.getConnection(); Statement s=c.createStatement();)
        {
            String sql="select count(*) from seller";
            ResultSet rs=s.executeQuery(sql);
            while(rs.next())
            {
                total=rs.getInt(1);
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return total;
    }

    public void add(Seller bean)
    {
        String sql="insert into seller values(null,?,?)";
        try(Connection c=DBUtil.getConnection(); PreparedStatement ps=c.prepareStatement(sql);)
        {
            ps.setString(1,bean.getWechat());
            ps.setString(2,bean.getId_card());
            ps.execute();

            ResultSet rs=ps.getGeneratedKeys();
            if(rs.next())
            {
                int id=rs.getInt(1);
                bean.setId(id);
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void delete(long id)
    {
        try(Connection c=DBUtil.getConnection();Statement s=c.createStatement();)
        {
            String sql="delete * from seller where id="+id;
            s.execute(sql);
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void update(Seller bean)
    {
        String sql="update seller set wechat=?,id_card=? where id=?";

        try(Connection c=DBUtil.getConnection();PreparedStatement ps=c.prepareStatement(sql);)
        {
            ps.setString(1,bean.getWechat());
            ps.setString(2,bean.getId_card());
            ps.setLong(3,bean.getId());
            ps.execute();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    public Seller get(long id)
    {
        Seller bean=new Seller();
        try(Connection c=DBUtil.getConnection();Statement s=c.createStatement();)
        {
            String sql="select * from seller where id="+id;
            ResultSet rs=s.executeQuery(sql);

            if(rs.next())
            {
                String wechat=rs.getString("wechat");
                String id_card=rs.getString("id_card");

                bean.setWechat(wechat);
                bean.setId_card(id_card);
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return bean;
    }
}
