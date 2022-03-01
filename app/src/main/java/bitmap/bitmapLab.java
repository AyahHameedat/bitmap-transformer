package bitmap;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class bitmapLab {

    private String inputFileName;
    private String outputFileName;
    private String transformationName;

    public bitmapLab(String inputFileName, String outputFileName, String transformationName)
    {
        this.inputFileName = "C:/Users/ayoos/bitmap-transformer/app/src/main/resources/Hourglass.bmp";
        this.outputFileName = "C:/Users/ayoos/bitmap-transformer/app/src/main/resources/AYA.bmp";

        if (transformationName.equals("invertImage")){
            invertImage();
        }

    }
    BufferedImage image;
//    graphic.frame = new JFrame();

    public void invertImage() {

        try {
            File file = new File("C:/Users/ayoos/bitmap-transformer/app/src/main/resources/Hourglass.bmp");
            BufferedImage image = ImageIO.read(file);
            BufferedImage result = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_BYTE_BINARY);
//


            for (int i = 0; i < image.getHeight(); i++) {
                for (int j = 0; j < image.getWidth(); j++) {
                    Pixel p = getPixel(j,i,image);
                    int redValue = 255 - p.getRedValue();
                    int blueValue = 255 - p.getBlueValue();
                    int greenValue = 255 - p.getGreenValue();

                    p.setRGB(redValue, blueValue, greenValue);

                }
            }
            
            Graphics graphics = result.getGraphics();
            graphics.drawImage(result, 0, 0, null);
            graphics.dispose();
            System.out.println(result);
            
            
//            String newFile = "AYA";
//            newFile = "C:/Users/ayoos/bitmap-transformer/app/src/main/resources/"+ newFile + ".bmp";;
            File output = new File(outputFileName);
            ImageIO.write(result, "bmp", output);

            System.out.println(output);

//            Graphics graphic = result.createGraphics();
//            graphic.drawImage(image, 0, 0, null);
////            graphic.dispose();
//            System.out.println(result);
        }
        catch (FileNotFoundException fileNotFoundException) {
            System.err.println(fileNotFoundException.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Pixel getPixel(int column, int row, BufferedImage image) {
        Color currentPixelColor = new Color(image.getRGB(column, row));
        int red = currentPixelColor.getRed();
        int green = currentPixelColor.getGreen();
        int blue = currentPixelColor.getBlue();
        return new Pixel(red,green,blue,column,row);
    }

    class Pixel {

        final private int red;
        final private int green;
        final private int blue;
        final private int column;
        final private int row;

        Pixel(int r, int g, int b, int column, int row) {
            red = r;
            green = g;
            blue = b;
            this.column = column;
            this.row = row;
        }

        public int getRedValue() {
            return red;
        }

        public int getGreenValue() {
            return green;
        }

        public int getBlueValue() {
            return blue;
        }

        public void setRGB(int r, int g, int b)
        {
            Color c = new Color(r,g,b);
            image.setRGB(column, row, c.getRGB());
        }
    }
}
