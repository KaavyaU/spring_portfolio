package com.example.sping_portfolio.controllers.Grayscale;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class AddWatermark {
    static String imageDesc = "Project Recycle";
    public static void addTextWatermark(URL sourceImageFile, URL destImageFile) {
       try {

           BufferedImage sourceImage = ImageIO.read(sourceImageFile);
           BufferedImage destImage = ImageIO.read(destImageFile);

           Graphics2D watermark = (Graphics2D) sourceImage.getGraphics();

            // initializes necessary graphic properties
            AlphaComposite alphaChannel = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.1f);
            watermark.setComposite(alphaChannel);
            watermark.setColor(Color.BLUE);
            watermark.setFont(new Font("Calibri", Font.BOLD, 30));
            FontMetrics fontMetrics = watermark.getFontMetrics();
            Rectangle2D rect = fontMetrics.getStringBounds(imageDesc, watermark);

            // calculates the coordinate where the String is added
            int centerX = (sourceImage.getWidth() - (int) rect.getWidth()) / 2;
            int topY = sourceImage.getHeight();

            // paints the textual watermark
            watermark.drawString(imageDesc, centerX, topY);

            ImageIO.write(sourceImage, "jpeg", (ImageOutputStream) destImage);
            watermark.dispose();

            System.out.println("Watermark added");

        } catch (IOException ex) {
            System.err.println(ex.getMessage()+ ex.getMessage());
        }
        System.out.println("Watermark added");

    }
}
