package dao;

import model.Room;
import util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoomDao
{
    public int getTotal()
    {
        int total=0;
        try(Connection c=DBUtil.getConnection(); Statement s=c.createStatement();)
        {
            String sql="select count(*) from room";

            ResultSet rs=s.executeQuery(sql);
            while(rs.next())
            {
                total = rs.getInt(1);
            }

        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return total;
    }

    public void add(Room bean)
    {
        String sql="insert into room values(null,?,?,?,?,?,?,?)";
        try(Connection c=DBUtil.getConnection(); PreparedStatement ps=c.prepareStatement(sql);)
        {
            ps.setLong(1,bean.getHotel());
            ps.setString(2,bean.getStatus());
            ps.setDouble(3,bean.getPrice());
            ps.setString(4,bean.getDescription());
            ps.setString(5,bean.getParking_set());
            ps.setString(6,bean.getWifi());
            ps.setString(7,bean.getRoom_type());
            ps.execute();

            ResultSet rs=ps.getGeneratedKeys();
            if(rs.next())
            {
                long id=rs.getInt(1);
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
            String sql="delete from room where id="+id;
            s.execute(sql);
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void update(Room bean)
    {
        String sql="update room set hotel=?,status=?,price=?,description=?,parking_set=?,wifi=?,room_type=? where id=?";
        try(Connection c=DBUtil.getConnection();PreparedStatement ps=c.prepareStatement(sql);)
        {
            ps.setLong(1,bean.getHotel());
            ps.setString(2,bean.getStatus());
            ps.setDouble(3,bean.getPrice());
            ps.setString(4,bean.getDescription());
            ps.setString(5,bean.getParking_set());
            ps.setString(6,bean.getWifi());
            ps.setString(7,bean.getRoom_type());
            ps.setLong(8,bean.getId());
            ps.execute();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    public Room get(long id)
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
                double price=rs.getDouble("price");
                String description=rs.getString("description");
                String parking_set=rs.getString("parking_set");
                String wifi=rs.getString("wifi");
                String room_type=rs.getString("room_type");

                bean.setHotel(hotel);
                bean.setStatus(status);
                bean.setPrice(price);
                bean.setDescription(description);
                bean.setParking_set(parking_set);
                bean.setWifi(wifi);
                bean.setRoom_type(room_type);
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return bean;
    }

    public List<Room> list()
    {
        return list(0,Short.MAX_VALUE);
    }

    public List<Room> list(int start,int count)
    {
        List<Room> beans=new ArrayList<Room>();
        String sql="select * from room order by od desc limit ?,?";
        try(Connection c=DBUtil.getConnection();PreparedStatement ps=c.prepareStatement(sql);)
        {
            ps.setInt(1,start);
            ps.setInt(2,count);

            ResultSet rs=ps.executeQuery();

            while(rs.next())
            {
                Room bean=new Room();
                int id=rs.getInt(1);
                String room_type=rs.getString(2);
                bean.setId(id);
                bean.setRoom_type(room_type);
                beans.add(bean);
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return beans;
    }
}
