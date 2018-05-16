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

    public void add(Room beam)
    {
        String sql="insert into room values(null,?,?,?,?,?,?)";
        try(Connection c=DBUtil.getConnection(); PreparedStatement ps=c.prepareStatement(sql);)
        {
            ps.setLong(,beam.get);
        }
    }

}
