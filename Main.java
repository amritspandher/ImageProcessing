// Amrit Pandher
// 1/27/2021
// Assignment 2 CS351

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner input = new Scanner(new File("C:\\Users\\ritod\\OneDrive\\Documents\\Winter 2021\\CS 351\\image.dat")); //Insert file path here

        int height = input.nextInt();
        int width = input.nextInt();

        BufferedImage canvas = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB); //generate empty canvas
        int x = 0, y = 0;

        String[] rgbValues; //array to hold rgb values before split

        while(input.hasNext()){ //loops through every position while assigning values to specified coordinate

            String fullString = input.next();

            rgbValues = fullString.split(",");
            canvas.setRGB(x, y, getRGB(rgbValues)); //calls calculation method and sets at current coordinate

            if(x==width-1){
                x=0;
                y++;
            }
            else {
                x++;
            }
            if(y==height){
                break;
            }
        }

        input.close();

        ImageIO.write(canvas,"PNG",new File("image.png"));
    }

    public static int getRGB(String[] values){ //store string values as ints and perform bitwise shift to return the rgb value
        int red = Integer.valueOf(values[0]);
        int green = Integer.valueOf(values[1]);
        int blue = Integer.valueOf(values[2]);
        int rgb = (red<<16) + (green<<8) + blue;
        return rgb;
    }
}
