package com.example.sping_portfolio.MiniLabs.Christopher;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import org.apache.tomcat.util.codec.binary.Base64;
import java.io.*;
import java.net.URL;

public class ImageInfo {
    public String file_path;
    public String author;
    public String title;
    public int height;
    public int width;
    public int[][][] rgb_matrix;
    public int[][][] gray_matrix;
    BufferedImage rgb_img;

    public ImageInfo(String file, String author, String name) {
        this.file_path = file;
        this.author = author;
        this.title = name;
    }

    public Exception read_image() {
        File f = null;

        //read image
        try{
            //f = new File(file_path);
            rgb_img = ImageIO.read(new URL(this.file_path));

            //get image width and height
            width = rgb_img.getWidth();
            height = rgb_img.getHeight();

            this.rgb_matrix = new int[this.height][this.width][4];
            this.gray_matrix = new int[this.height][this.width][4];

            //initialize rgb_matrix
            for (int y = 0; y < height; y++){
                for (int x = 0; x < width; x++) {
                    int p = rgb_img.getRGB(x, y);

                    int a = (p >> 24) & 0xff;
                    int r = (p >> 16) & 0xff;
                    int g = (p >> 8) & 0xff;
                    int b = p & 0xff;

                    rgb_matrix[y][x][0] = r;
                    rgb_matrix[y][x][1] = g;
                    rgb_matrix[y][x][2] = b;
                    rgb_matrix[y][x][3] = a;
                }
            }
        }catch(IOException e){
            System.out.println(e);
        }

        return null;
    };

    public String getFile_path() {
        return file_path;
    };

    public int getHeight() {
        return this.height;
    };

    public int getWidth() {
        return this.width;
    };

    public String getAuthor() {
        return this.author;
    };

    public String getTitle() {
        return this.title;
    };

    public int argb(int a, int r, int g, int b) {
        return ((a&0x0ff)<<24)|((r&0x0ff)<<16)|((g&0x0ff)<<8)|(b&0x0ff);
    }

    public String img_to_base64() throws IOException {
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        for(int y=0;y<height;y++) {
            for (int x = 0; x < width; x++) {
                img.setRGB(x, y, argb(gray_matrix[y][x][3], gray_matrix[y][x][0], gray_matrix[y][x][1], gray_matrix[y][x][2]));
            }
        }

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ImageIO.write(img, "png", bos);

        byte[] data = bos.toByteArray();
        return Base64.encodeBase64String(data);
    };

    public String grayscale_base64() {
        try {
            grayscale();
            String base64 = img_to_base64();
            return "data:image/jpg;base64," + base64;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    };


    public void grayscale() {
        //convert to grayscale
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++){

                int a = rgb_matrix[y][x][3];
                int r = rgb_matrix[y][x][0];
                int g = rgb_matrix[y][x][1];
                int b = rgb_matrix[y][x][2];

                //calculate average
                //int avg = (r+g+b)/3;
                int avg = (int)(0.3*r + 0.59*g + 0.11*b);

                gray_matrix[y][x][0] = avg;
                gray_matrix[y][x][1] = avg;
                gray_matrix[y][x][2] = avg;
                gray_matrix[y][x][3] = a;

            }
        }
    };

    public String getRGB(int row, int col) {
        return "(" + rgb_matrix[row][col][0] +
                "," + rgb_matrix[row][col][1] +
                "," + rgb_matrix[row][col][2] +
                ")" ;
    };

    public String getHexCode(int row, int col) {
        return "#" +
                String.format("%02X",rgb_matrix[row][col][0]) +
                String.format("%02X",rgb_matrix[row][col][1]) +
                String.format("%02X",rgb_matrix[row][col][2]) ;
    };

    public String getBinary(int row, int col) {
        return  String.format("%8s", Integer.toBinaryString(rgb_matrix[row][col][0])).replace(' ', '0') +
                " " +
                String.format("%8s", Integer.toBinaryString(rgb_matrix[row][col][1])).replace(' ', '0') +
                " " +
                String.format("%8s", Integer.toBinaryString(rgb_matrix[row][col][2])).replace(' ', '0') ;
    };
}
