package database.DBAccess;

import database.FunctionLayer.LegohusException;
import database.FunctionLayer.LoginSampleException;
import database.FunctionLayer.Order;
import database.FunctionLayer.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderMapper {

    public Order Order(int id) throws LegohusException {
        try {
            Connection con = Connector.connection();
            String sql = "SELECT * FROM orders where user_id =?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (!rs.first()) {
                return null;
            }
            
            return createorder(rs);

        } catch (SQLException e) {
            throw new LegohusException(e.getMessage());
        }

    }
    
    public Order createOrder(int userId,int length, int width, int heigth) {
        try  {
            Connection connection = Connector.connection();
            Order order;
            String sql = " INSERT INTO `lego`.`orders` (`user_id`, `length`, `width`, `heigth`, `shipped`)"
                    + " values (?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, userId);
            ps.setInt(2, length);
            ps.setInt(3, width);
            ps.setInt(4, heigth);       
            ps.setInt(5, 0);
            ps.executeUpdate();

            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt(1);
            order = new Order(id, userId, length, width, heigth);
            order.setId(id);
                
           
            return order;

        } catch (SQLException e) {
                throw new IllegalStateException(e);
        }
    }
    

    public Order getOrder(int orderid) throws LegohusException {
        try {
            Connection con = Connector.connection();
            String sql = "SELECT * FROM orders where order_id =?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, orderid);
            ResultSet rs = ps.executeQuery();
            

            
            return createorder(rs);
        } catch (SQLException e) {
            throw new LegohusException(e.getMessage());
        }

    }
    
     public List<Order> getUserOrders(int orderid)  {
        try {
            Connection con = Connector.connection();
            String sql = "SELECT * FROM orders where user_id =?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, orderid);
            ResultSet rs = ps.executeQuery();
            List<Order> orders = new ArrayList<>();
            
            while(rs.next()){
            orders.add(createorder(rs));
            }
            return orders;
            
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }

    }

    private Order createorder(ResultSet results) throws SQLException {

        return new Order(
                results.getInt("order_id"),
                results.getInt("user_id"),
                results.getInt("length"),
                results.getInt("width"),
                results.getInt("heigth")
        );

    }
}
