package database.FunctionLayer;

import database.DBAccess.OrderMapper;
import database.DBAccess.UserMapper;
import database.DBAccess.WritingToSQLException;
import java.sql.SQLException;
import java.util.ArrayList;
import  database.DBAccess.OrderMapper;
import database.FunctionLayer.Brickcalculateor;
import java.util.List;
/**
 * The purpose of LogicFacade is to...
 * @author kasper
 */
public class LogicFacade {

    public static User login( String email, String password ) throws LoginSampleException {
        return UserMapper.login( email, password );
    } 

    public static User createUser( String email, String password ) throws LoginSampleException {
        User user = new User(email, password, "customer");
        UserMapper.createUser( user );
        return user;
    }
    
   public static Order getOrder(int order_id) throws LegohusException{
       OrderMapper mapper = new OrderMapper();
      return mapper.getOrder(order_id);
       
   }
  
   public static Order createOrder(int user_id,int length, int width, int heigth ){
       OrderMapper mapper = new OrderMapper();
        return mapper.createOrder(user_id, length, width, heigth);
   }
   public static List<Order> getUserOrders(int userId){
       OrderMapper mapper = new OrderMapper();
       return mapper.getUserOrders(userId);
   } 
   
    public static boolean Dimensions(int length, int width, int height) {
        boolean result;
        
        result = (height > 0) & (length > 3) & (width > 3);
        return result;
    }
    public static Bricks calcBricks(User user,int id){
   Brickcalculateor brick = new Brickcalculateor();
   Order order = user.getOrderFromMap(id);
    return brick.choice_of_bricks(order.getHeight(), order.getWidth(), order.getLength()); 
    }

    
   
}
