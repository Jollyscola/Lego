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

    public static void main(String[] args) {

        database.FunctionLayer.Brickcalculateor i = new Brickcalculateor();
        i.choice_of_bricks(4, 5, 10);

    }

    public void choice_of_bricks(int height, int width, int depth) {

     
        if (height < 2) {
            throw new Error("height too small");

        }
        if (depth < 5) {
            throw new Error("depth too small");
        }

        if (width < 5) {
            throw new Error("Width too small");
        }

        int total_no_of_4x2_dot_bricks = 0;
        int total_no_of_2x2_dot_bricks = 0;
        int total_no_of_1x2_dot_bricks = 0;
        for (int height_number = 0; height_number < height; height_number++) {
            final int displacement      = height_number % 4; //den længeste klods har 4 brikker
            final int front_side_length = width - displacement;
            System.out.println("front side length " + front_side_length);    
            total_no_of_1x2_dot_bricks += displacement % 2;
          //total_no_of_2x2_dot_bricks += displacement / 2;
            total_no_of_4x2_dot_bricks += front_side_length / 4;
            total_no_of_1x2_dot_bricks += front_side_length % 2;
            int right_side_length;            
            if ((front_side_length % 4) / 2 == 1){
              right_side_length = depth;
              }
            else{
              right_side_length = depth - 2;
              }
            System.out.println("rigth side length " + right_side_length);
            total_no_of_1x2_dot_bricks += right_side_length % 2;
            total_no_of_4x2_dot_bricks += right_side_length / 4; 
            final int rear_side_length;
            if ((right_side_length % 4) / 2 == 1)
              rear_side_length = width;
            else
              rear_side_length = width - 2;
            System.out.println("rear side length " + rear_side_length);
            total_no_of_1x2_dot_bricks += rear_side_length % 2;
            total_no_of_4x2_dot_bricks += rear_side_length / 4;
            int left_side_length;
            if ((rear_side_length % 4) / 2 == 1)
              left_side_length = depth;
            else
              left_side_length = depth - 2;
            System.out.println("left side length " + left_side_length);
            total_no_of_1x2_dot_bricks += left_side_length % 2;
            total_no_of_4x2_dot_bricks += left_side_length / 4;
            if (displacement / 2 == 1)
            total_no_of_2x2_dot_bricks += (left_side_length % 4) / 2;

            System.out.println("1x2 bricks: "
                    + total_no_of_1x2_dot_bricks
                    + " 2x2 bricks: "
                    + total_no_of_2x2_dot_bricks
                    + " 4x2 bricks: "
                    + total_no_of_4x2_dot_bricks);
        } // for height_number

    }

}
