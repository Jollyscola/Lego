/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.FunctionLayer;

public class Bricks {

    private int four;
    private int two;
    private int one;

    public Bricks(int four, int two, int one) {
        this.four = four;
        this.two = two;
        this.one = one;
    }

    public void setFour(int four) {
        this.four = four;
    }

    public void setTwo(int two) {
        this.two = two;
    }

    public void setOne(int one) {
        this.one = one;
    }
    

    public int getFour() {
        return four;
    }

    public int getTwo() {
        return two;
    }

    public int getOne() {
        return one;
    }

    
}
