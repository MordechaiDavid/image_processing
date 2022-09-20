import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.swing.*;

public class Filters {
    static AppPanels panels;
    public Filters(AppPanels panels){
        this.panels = panels;
    }


    //1.
    public static void ColorShiftRight(BufferedImage img) throws Exception {
        for (int x = 0; x < img.getWidth(); x++) {
            for (int y = 0; y < img.getHeight(); y++) {
                int pixel = img.getRGB(x, y);
                Color color = new Color(pixel);

                int red = color.getRed();
                int green = color.getGreen();
                int blue = color.getBlue();

                Color newColor = new Color(green, blue, red);
                img.setRGB(x, y, newColor.getRGB());
            }
        }
        updatePhoto(img);
    }

    public static void EliminateRed(BufferedImage img) throws Exception {
        for (int x = 0; x < img.getWidth(); x++) {
            for (int y = 0; y < img.getHeight(); y++) {
                int pixel = img.getRGB(x, y);
                Color color = new Color(pixel);

                int red = color.getRed();
                int green = color.getGreen();
                int blue = color.getBlue();

                Color newColor = new Color(0, green, blue);
                img.setRGB(x, y, newColor.getRGB());
            }
        }
        updatePhoto(img);
    }

    public static void ColorShiftLeft(BufferedImage img) throws Exception {
        for (int x = 0; x < img.getWidth(); x++) {
            for (int y = 0; y < img.getHeight(); y++) {
                int pixel = img.getRGB(x, y);
                Color color = new Color(pixel);

                int red = color.getRed();
                int green = color.getGreen();
                int blue = color.getBlue();

                Color newColor = new Color(blue, red, green);
                img.setRGB(x, y, newColor.getRGB());
            }
        }
        updatePhoto(img);
    }

    public static void Grayscale(BufferedImage img) throws Exception {
        //get image width and height
        int width = img.getWidth();
        int height = img.getHeight();

        //convert to grayscale
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int p = img.getRGB(x, y);

                int a = (p >> 24) & 0xff;
                int r = (p >> 16) & 0xff;
                int g = (p >> 8) & 0xff;
                int b = p & 0xff;

                //calculate average
                int avg = (r + g + b) / 3;

                //replace RGB value with avg
                p = (a << 24) | (avg << 16) | (avg << 8) | avg;

                img.setRGB(x, y, p);
            }
        }

//        try {
//            File output = new File("C:\\files2\\027.png");
//            ImageIO.write(img, "png", output);
        updatePhoto(img);

//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    //2.
    public static void mirror(BufferedImage img) throws Exception {

        int width = img.getWidth();
        int height = img.getHeight();

        // Create mirror image pixel by pixel
        for (int y = 0; y < height; y++) {
            for (int lx = 0, rx = width - 1; lx < width; lx++, rx--) {

                // lx starts from the left side of the image
                // rx starts from the right side of the
                // image lx is used since we are getting
                // pixel from left side rx is used to set
                // from right side get source pixel value
                int p = img.getRGB(lx, y);

                // set mirror image pixel value
                img.setRGB(rx, y, p);
            }
        }
        updatePhoto(img);


    }



    public static void sepia(BufferedImage img) throws Exception {
        for (int y = 0; y < img.getHeight(); y++) {
            for (int x = 0; x < img.getWidth(); x++) {
                //Retrieving the values of a pixel
                int pixel = img.getRGB(x, y);
                //Creating a Color object from pixel value
                Color color = new Color(pixel, true);
                //Retrieving the R G B values
                int red = color.getRed();
                int green = color.getGreen();
                int blue = color.getBlue();
                int avg = (red + green + blue) / 3;
                int depth = 20;
                int intensity = 30;
                red = avg + (depth * 2);
                green = avg + depth;
                blue = avg - intensity;
                //Making sure that RGB values lies between 0-255
                if (red > 255) red = 255;
                if (green > 255) green = 255;
                if (blue > 255) blue = 255;
                if (blue < 0) blue = 0;
                //Creating new Color object
                color = new Color(red, green, blue);
                //Setting new Color object to the image
                img.setRGB(x, y, color.getRGB());
            }
        }
        updatePhoto(img);
    }

    //4.

    public static void negative(BufferedImage img) throws Exception {
        int width = img.getWidth();
        int height = img.getHeight();

        // Convert to negative
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int p = img.getRGB(x, y);
                int a = (p >> 24) & 0xff;
                int r = (p >> 16) & 0xff;
                int g = (p >> 8) & 0xff;
                int b = p & 0xff;

                // subtract RGB from 255
                r = 255 - r;
                g = 255 - g;
                b = 255 - b;

                // set new RGB value
                p = (a << 24) | (r << 16) | (g << 8) | b;
                img.setRGB(x, y, p);
            }
        }
        updatePhoto(img);
    }

    public static void contract(BufferedImage img) throws Exception {
        int width = img.getWidth();
        int height = img.getHeight();

        // Convert to negative
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int p = img.getRGB(x, y);
                int a = (p >> 24) & 0xff;
                int r = (p >> 16) & 0xff;
                int g = (p >> 8) & 0xff;
                int b = p & 0xff;

                // subtract RGB from 255
                r = 255 - r;
                g = 255 - g;
                b = 255 - b;

                // set new RGB value
                p = (a << 48) | (r << 32) | (g << 16) | b;
                img.setRGB(x, y, p);
            }
        }
        updatePhoto(img);
    }

    //5.
    public static void lighter(BufferedImage img) throws Exception {
        int rgb[];

        // Setting custom brightness
        int brightnessValue = 100;

        // Outer loop for width of image
        for (int i = 0; i < img.getWidth(); i++) {

            // Inner loop for height of image
            for (int j = 0; j < img.getHeight(); j++) {

                rgb = img.getRaster().getPixel(
                        i, j, new int[3]);

                // Using(calling) method 1
                int red
                        = Truncate(rgb[0] + brightnessValue);
                int green
                        = Truncate(rgb[1] + brightnessValue);
                int blue
                        = Truncate(rgb[2] + brightnessValue);

                int arr[] = {red, green, blue};

                // Using setPixel() method
                img.getRaster().setPixel(i, j, arr);
            }
        }

        updatePhoto(img);
    }

    //6.
    public static void darker(BufferedImage img) throws Exception {
        int rgb[];

        // Setting custom brightness
        int brightnessValue = 100;

        // Outer loop for width of image
        for (int i = 0; i < img.getWidth(); i++) {

            // Inner loop for height of image
            for (int j = 0; j < img.getHeight(); j++) {

                rgb = img.getRaster().getPixel(
                        i, j, new int[3]);

                // Using(calling) method 1
                int red
                        = Truncate(rgb[0] - brightnessValue);
                int green
                        = Truncate(rgb[1] - brightnessValue);
                int blue
                        = Truncate(rgb[2] - brightnessValue);

                int arr[] = {red, green, blue};

                // Using setPixel() method
                img.getRaster().setPixel(i, j, arr);
            }
        }

        updatePhoto(img);
    }

    public static boolean isSimilarColor(Color color1, Color color2) {
        boolean similar = false;
        int redDiff = Math.abs(color1.getRed() - color2.getRed());
        int greenDiff = Math.abs(color1.getGreen() - color2.getGreen());
        int blueDiff = Math.abs(color1.getBlue() - color2.getBlue());
        if (redDiff + greenDiff + blueDiff < 25)
            similar = true;

        return similar;
    }

    //פונקציה משלימה להבהרת או השחרת תמונה
    public static int Truncate(int value) {

        if (value < 0) {
            value = 0;
        } else if (value > 255) {
            value = 255;
        }
        return value;
    }

    private static void updatePhoto(BufferedImage scanImage2) throws IOException {

        try {
            panels.procImgPanel.image.setIcon(new ImageIcon(scanImage2));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(new JFrame(),
                    e.getMessage(),
                    "error",
                    JOptionPane.PLAIN_MESSAGE);
        }
        ButtonsPanel.setScanImage2(ButtonsPanel.getImageUrl());

    }

}
