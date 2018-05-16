package dao;

import model.Room;
import util.DBUtil;

import java.sql.*;

public class RoomDao
{
    public int getTotal(int id)
    {
        int total=0;
        try(Connection c=DBUtil.getConnection(); Statement s=c.createStatement();)
        {
            String sql="select count(*) from room where id="+id;

            ResultSet rs=s.executeQuery(sql);
            while(rs.next())
            {
                total = rs.getInt(1);
            }
            catch(SQLException e)
            {
                e.printStackTrace();
            }
            return total;
        }
    }

    public void add(Room bean)
    {
        String sql="insert into room values(null,?,?,?,?,?,?)";
        try(Connection c=DBUtil.getConnection(); PreparedStatement ps=c.prepareStatement(sql);)
        {
            ps.setLong(1,bean.getHotel());
            ps.setString(2,bean.getStatus());
            ps.setDouble(3,bean.getPrice());
            ps.setString(4,bean.getDescription());
            ps.setString(5,bean.getParking_set());
            ps.setString(6,bean.getWifi());
            ps.execute();

            ResultSet rs=ps.getGeneratedKeys();
            if(rs.next())
            {
                int id=rs.getInt(1);
                bean.getId(id);
            }
            catch(SQLException e)
            {
                e.printStackTrace();
            }
        }
    }

    public void delete(int id)
    {
        try(Connection c=DBUtil.getConnection();Statement s=c.createStatement();)
        {
            String sql="delete from room where id="+id;
            s.execute();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void update(Room bean)
    {
        String sql="update room set hotel=?,status=?,price=?,description=?,parking_set=?,wifi=? where id=?";
        try(Connection c=DBUtil.getConnection();PreparedStatement ps=c.prepareStatement(sql);)
        {
            ps.setLong(1,bean.getHotel());
            ps.setString(2,bean.getStatus());
            ps.setDouble(3,bean.getPrice());
            ps.setString(4,bean.getDescription());
            ps.setString(5,bean.getParking_set());
            ps.setString(6,bean.getWifi());
            ps.setLong(7,bean.getId());
            ps.execute();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    public Room get(int id)
    {
        Room bean=new Room();
        try(Connection c=DBUtil.getConnection();Statement s=c.createStatement();)
        {
            String sql="select * from room where id="+id;
            ResultSet rs=s.executeQuery(sql);
            if(rs.next())
            {
                long hotel=rs.getLong("hotel");
                String status=rs.getString("status");
                double price=rs.getInt("price");
                String description=rs.getString("description");
                String parking_set=rs.getString("parking_set");
                String wifi=rs.getString("wifi");

                bean.setHotel(hotel);
                bean.setStatus(status);
                bean.setPrice(price);
                bean.setDescription(description);
                bean.setParking_set(parking_set);
                bean.setWifi(wifi);
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return bean;
    }

}
