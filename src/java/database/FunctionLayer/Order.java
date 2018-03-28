package database.FunctionLayer;

import java.util.Date;

/**
 * The purpose of Order is to store information about the different orders made
 * by customers.
 *
 * @author Gert Lehmann Madsen
 */
public class Order {

    private int id;
    private int userId;
    private final int length;
    private final int width;
    private final int height;
    private boolean shipped;
    private User user;

    private Date date;
    private Date shippingDate;

    public Order(int id, int userId, int length, int width, int height) {
        this.id = id;
        this.userId = userId;
        this.length = length;
        this.width = width;
        this.height = height;
        this.shipped = false;

    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setShipped(boolean shipped) {
        this.shipped = shipped;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setShippingDate(Date shippingDate) {
        this.shippingDate = shippingDate;
    }

    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public boolean isShipped() {
        return shipped;
    }

    public User getUser() {
        return user;
    }

    public Date getDate() {
        return date;
    }

    public Date getShippingDate() {
        return shippingDate;
    }

}
