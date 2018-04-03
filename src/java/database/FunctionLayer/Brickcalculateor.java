/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.FunctionLayer;

/**
 *
 * @author Jollys
 */
public class Brickcalculateor {

    public static void main(String[] args) throws LegohusException {

        database.FunctionLayer.Brickcalculateor i = new Brickcalculateor();
        i.choice_of_bricks(4, 5, 5);

    }

    int four = 0;
    int two = 0;
    int one = 0;

    public Bricks choice_of_bricks(int height, int width, int length) {

        Bricks bricksCalculated = new Bricks();

        for (int height_number = 0; height_number < height; height_number++) {
            final int displacement = height_number % 4; //den længeste klods har 4 brikker
            final int front_side_length = width - displacement;
            System.out.println("front side length " + front_side_length);
            one += displacement % 2;
            //total_no_of_2x2_dot_bricks += displacement / 2;
            four += front_side_length / 4;
            one += front_side_length % 2;
            int right_side_length;
            if ((front_side_length % 4) / 2 == 1) {
                right_side_length = length;
            } else {
                right_side_length = length - 2;
            }
            System.out.println("rigth side length " + right_side_length);
            one += right_side_length % 2;
            four += right_side_length / 4;
            final int rear_side_length;
            if ((right_side_length % 4) / 2 == 1) {
                rear_side_length = width;
            } else {
                rear_side_length = width - 2;
            }
            System.out.println("rear side length " + rear_side_length);
            one += rear_side_length % 2;
            four += rear_side_length / 4;
            int left_side_length;
            if ((rear_side_length % 4) / 2 == 1) {
                left_side_length = length;
            } else {
                left_side_length = length - 2;
            }
            System.out.println("left side length " + left_side_length);
            one += left_side_length % 2;
            four += left_side_length / 4;
            if (displacement / 2 == 1) {
                two += (left_side_length % 4) / 2;
            }

            System.out.println("1x2 bricks: "
                    + one
                    + " 2x2 bricks: "
                    + two
                    + " 4x2 bricks: "
                    + four);

        } // for height_number
        bricksCalculated.addBricks(four, two, one);

        return bricksCalculated;
    }

}
