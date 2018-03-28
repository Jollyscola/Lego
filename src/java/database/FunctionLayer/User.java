package database.FunctionLayer;

import java.util.TreeMap;
import java.util.TreeSet;

public class User {

    public User(String email, String password, String role) {
        this.email = email;
        this.password = password;
        this.role = role;
        this.orderMap = new TreeMap<>();
    }

    private int id; // just used to demo retrieval of autogen keys in UserMapper
    private String email;
    private String password; // Should be hashed and all
    private String role;
    private TreeMap<String, Order> orderMap;
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public Order getOrderFromMap(int id) {
        String key = ""+id;
        return this.orderMap.get(key);
    }

}
