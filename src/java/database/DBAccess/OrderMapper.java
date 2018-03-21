
package database.DBAccess;

import Exceptions.LegohusException;
import Exceptions.WritingToSQLException;
import database.FunctionLayer.Order;
import database.FunctionLayer.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;


public class OrderMapper {
  
    public static Order createOrder(Order order) throws LegohusException, WritingToSQLException {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO orders (user_id, length, width, height, shipped ) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, order.getUser().getId());
            ps.setInt(2, order.getLength());
            ps.setInt(3, order.getWidth());
            ps.setInt(4, order.getHeight());
            ps.setBoolean(5, order.isShipped());
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt(1);
            order.setId(id);
            return getOrderDate(order);
        } catch (SQLException  ex) {
            throw new WritingToSQLException(ex.getMessage());
        }
    }
    
    public static Order getOrderDate(Order order) throws LegohusException {
        try {
            
            Connection con = Connector.connection();
            String SQL = "SELECT date FROM orders WHERE id=?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, order.getId());
            ResultSet rs = ps.executeQuery();           
            while (rs.next()) {
                Date date = rs.getTimestamp("date");
                order.setDate(date);
            }
            return order;
        } catch (SQLException  ex) {
            throw new LegohusException(ex.getMessage());
        }
    }
    
    public static Date getShippingDate(int id) throws LegohusException {
        try {
            Date shippingDate = null;
            Connection con = Connector.connection();
            String SQL = "SELECT shipping_date FROM orders WHERE id=?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();           
            while (rs.next()) {
                shippingDate = rs.getTimestamp("shipping_date");
            }
            return shippingDate;
        } catch (SQLException ex) {
            throw new LegohusException(ex.getMessage());
        }
    }
 
    public static void setShipped(int id) throws LegohusException {
        try {
            Connection con = Connector.connection();
            String SQL = "UPDATE orders SET shipped = 1 WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, id);
            ps.executeUpdate();
            SQL = "UPDATE orders SET shipping_date = CURRENT_TIMESTAMP WHERE id = ?";
            ps = con.prepareStatement(SQL);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            throw new LegohusException(ex.getMessage());
        }
    }


}
