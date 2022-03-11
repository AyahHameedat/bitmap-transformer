package bitmap;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class bitmapLab {

    private int heightImg;
    private int widthImg;
    private BufferedImage img;

    public void read(String pathImg)
    {
        File fileImg = new File (pathImg);

        try {
            img = ImageIO.read(fileImg);
            heightImg = img.getHeight();
            widthImg = img.getWidth();
            System.out.println(heightImg);
            System.out.println(widthImg);
        } catch (IOException e) {
            e.printStackTrace();

            }
    }



    public void conversionImage() {
        for (int i = 0; i < widthImg; i++) {
            for (int j = 0; j < heightImg; j++) {
                int p = img.getRGB(i, j);

                int a = (p >> 20) & 0xff;
                int r = (p >> 16) & 0xff;
                int g = (p >> 8) & 0xff;
                int b = p & 0xff;

                r = 255 - r;
                g = 255 - g;
                b = 255 - b;

                p = (a << 24) | (r << 16) | (g << 8) | b;
                img.setRGB(i, j, p);
            }
        }
//        return img;

    }


    public void brighterImage() {

        for (int i = 0; i < widthImg; i++) {
            for (int j = 0; j < heightImg; j++) {
               Color colorImg = new Color (img.getRGB(i,j));
               colorImg = colorImg.brighter();
               img.setRGB(i,j,colorImg.getRGB());
            }
        }
//        return img;
    }


    public void write(String pathImg){
        try {
            ImageIO.write(img , "bmp",new File(pathImg));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}






//    public static void conversionImage() throws IOException {
//
//        File inputFileName = new File("C:/Users/ayoos/bitmap-transformer/app/src/main/resources/Hourglass.bmp");
//        File outputFileName =new File("C:/Users/ayoos/bitmap-transformer/app/src/main/resources/AYA.bmp");
//        String transformationName = "invertImage" ;
//
//
//        BufferedImage image = ImageIO.read(inputFileName);
//        int width = image.getWidth();
//        int height = image.getHeight();
//        BufferedImage result = new BufferedImage(width,height , BufferedImage.TYPE_BYTE_BINARY);
//
//
//        for (int i = 0; i < width ; i++) {
//            for (int j = 0; j < height; j++) {
//                int p = image.getRGB(i,j);
//
//                int a = (p>>24)&0xff;
//                int r = (p>>16)&0xff;
//                int g = (p>>8)&0xff;
//                int b = p&0xff;
//
//                r = 255-r;
//                g = 255-g;
//                b = 255-b;
//
//                p = (a<<24) | (r<<16) | (g<<8) |b;
//                image.setRGB(i,j,p);
//
//            }
//
//        }
//        ImageIO.write(image , "bmp", outputFileName);
//        //        bitmapLab Hourglass = new bitmapLab(inputFileName , outputFileName, transformationName);
//
//    }
//
//
//    public static void rotate90() throws IOException {
//
//        final int ROTATE_LEFT = 1;
//        int direction = ROTATE_LEFT;
//        final int ROTATE_RIGHT = -1;
//       try {
//           File inputFileName = new File("C:/Users/ayoos/bitmap-transformer/app/src/main/resources/Hourglass.bmp");
//           File outputFileName =new File("C:/Users/ayoos/bitmap-transformer/app/src/main/resources/AYA.bmp");
//           BufferedImage image = ImageIO.read(inputFileName);
//           int width = image.getWidth();
//           int height = image.getHeight();
//           BufferedImage resultRotated = new BufferedImage(width, height, image.getType());
//
//           for (int i = 0; i < height; i++) {
//               for (int j = 0; j < width; j++) {
//                   switch(direction){
//                       case ROTATE_LEFT:
//                           resultRotated.setRGB(i,(width-1) - j , image.getRGB(j,i));
//                           break;
//                       case ROTATE_RIGHT:
//                           resultRotated.setRGB((height-1) - i, j , image.getRGB(j,i));
//                   }
//
//               }
//           }
//           ImageIO.write(image , "bmp", outputFileName);
//
//           }
//       catch (IOException ex)
//       {
//           ex.printStackTrace();
//       }
//    }
//
//}
