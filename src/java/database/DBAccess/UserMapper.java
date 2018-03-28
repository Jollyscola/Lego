package database.DBAccess;

import database.FunctionLayer.LoginSampleException;
import database.FunctionLayer.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserMapper {

    public static void createUser( User user ) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO users (email, password, role) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement( SQL, Statement.RETURN_GENERATED_KEYS );
            ps.setString( 1, user.getEmail() );
            ps.setString( 2, user.getPassword() );
            ps.setString( 3, user.getRole() );
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt( 1 );
            user.setId( id );
        } catch ( SQLException ex ) {
            throw new LoginSampleException( ex.getMessage() );
        }
    }

    public static User login( String email, String password ) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT id, role FROM users "
                    + "WHERE email=? AND password=?";
            PreparedStatement ps = con.prepareStatement( SQL );
            ps.setString( 1, email );
            ps.setString( 2, password );
            ResultSet rs = ps.executeQuery();
            if ( rs.next() ) {
                String role = rs.getString( "role" );
                int id = rs.getInt( "id" );
                User user = new User( email, password, role );
                user.setId( id );
                return user;
            } else {
                throw new LoginSampleException( "Could not validate user" );
            }
        } catch ( SQLException ex ) {
            throw new LoginSampleException(ex.getMessage());
        }
    }

    public static User get(int userid) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String sql = "SELECT * FROM lego.users where id=?";
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, userid);
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
            String role = rs.getString( "role" );
           String password = rs.getString("password");
            String email = rs.getString("email");
            User user = new User(email, password, role);
            }
            
        } catch (SQLException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
        return null;
    }

}
