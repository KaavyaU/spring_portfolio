package com.example.sping_portfolio.MiniLabs.Christopher;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import org.apache.tomcat.util.codec.binary.Base64;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ImageInfo {
    public String file_path;
    public String author;
    public String title;
    public int height;
    public int width;
    public int[][][] rgb_matrix;
    public int[][][] gray_matrix;
    public char[][] ascii_image;
    BufferedImage rgb_img;
    BufferedImage ascii_img;
    int ascii_height;
    int ascii_width;
    public List<String> asciilist;

    public static final String GRAYSCALE_CHARS  = "@#BW8gMN6&9RQqE0d$DbpmOa5AH2GZeKPS3X4U%kwohFVyzIsCu{xfn}tJTi17c=jYL?l[]v<>+|)r(/\\*_!;^~\":,-'.`";
    // The lookup table of the brightness of each char, from 0 to 1
    public static final double[] GRAYSCALE_VALUES = {0, 0.07863, 0.08205, 0.1316, 0.1453, 0.147, 0.1504, 0.1641, 0.1761, 0.1761, 0.1778, 0.2017, 0.2154, 0.2274, 0.2274, 0.2291, 0.2427, 0.2598, 0.2615, 0.2684, 0.2752, 0.2769, 0.2889, 0.2923, 0.294, 0.2974, 0.3026, 0.3077, 0.3077, 0.3094, 0.3162, 0.3197, 0.3333, 0.3333, 0.3385, 0.3538, 0.3607, 0.3795, 0.3846, 0.4017, 0.4034, 0.4068, 0.4291, 0.4325, 0.4444, 0.4598, 0.4632, 0.4667, 0.4752, 0.4855, 0.5077, 0.5128, 0.5128, 0.5128, 0.5179, 0.5214, 0.5231, 0.535, 0.535, 0.5368, 0.5385, 0.5436, 0.5624, 0.5624, 0.5624, 0.5641, 0.5778, 0.5829, 0.5846, 0.5863, 0.5863, 0.5915, 0.6017, 0.6068, 0.641, 0.6581, 0.6889, 0.694, 0.6974, 0.7333, 0.7333, 0.7402, 0.7675, 0.7744, 0.7863, 0.8068, 0.8342, 0.8427, 0.8598, 0.894, 0.947, 0.959, 0.9675, 1};


    public ImageInfo(String file, String author, String name) {
        this.file_path = file;
        this.author = author;
        this.title = name;
        this.ascii_height = 8;
        this.ascii_width = 4;
        asciilist = new ArrayList<>();
    }

    public Exception read_image() {
        File f = null;

        //read image
        try{
            //f = new File(file_path);
            rgb_img = ImageIO.read(new URL(this.file_path));

            //get image width and height
            this.width = rgb_img.getWidth();
            this.height = rgb_img.getHeight();

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
        BufferedImage img = new BufferedImage(this.width, this.height, BufferedImage.TYPE_INT_ARGB);

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

    public String anyimg_to_base64(BufferedImage img) throws IOException {
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

    public String asciiimg_base64() {
        try {
            graytoascii();
            String base64 = anyimg_to_base64(ascii_img);
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

    public char getAsciichar(double z) {
        for(int i = 0; i<GRAYSCALE_VALUES.length; i++) {
            if (z <= GRAYSCALE_VALUES[i]) {
                return GRAYSCALE_CHARS.charAt(i);
            }
        }

        return GRAYSCALE_CHARS.charAt(0);
    };

    public void graytoascii() {
        int groupheight = height / ascii_height;
        int groupwidth = width / ascii_width;
        this.ascii_image = new char[groupheight][groupwidth];

        for(int h=0; h < groupheight; h++) {
            for(int w = 0; w < groupwidth; w++) {
                double sum_gray = 0;

                for(int gh = ascii_height * h; gh < ascii_height * h + ascii_height; gh++) {
                    for(int gw = ascii_width * w; gw < ascii_width * w + ascii_width; gw++) {
                        sum_gray += gray_matrix[gh][gw][0];
                    }
                }

                double average_gray = sum_gray / (ascii_height * ascii_width);
                double percentage_gray = 1 - average_gray / 256; //draws white on black
                //double percentage_gray = average_gray / 256; //draws black on while

                ascii_image[h][w] = getAsciichar(percentage_gray);
            }
        }
        drawAscii();
        printascii();
    };

    public void printascii() {
        int groupheight = height / ascii_height;
        int groupwidth = width / ascii_width;
        for(int h=0; h < groupheight; h++) {
            for (int w = 0; w < groupwidth; w++) {
                System.out.print(ascii_image[h][w]);
            }
            System.out.print("\n");
        }
        System.out.print("\n\n\n");
    }

    public void drawAscii() {
        int groupheight = height / ascii_height;
        int groupwidth = width / ascii_width;

        //Font fnt = new Font("JetBrains Mono", Font.PLAIN, ascii_height);
        Font fnt = new Font("monospaced", Font.BOLD, ascii_height);

        ascii_img = new BufferedImage((int)(this.width*1.3), (int)(this.height*1.3), BufferedImage.TYPE_INT_RGB);
        Graphics g = ascii_img.getGraphics();
        g.setFont(fnt);
        Graphics2D graphics = (Graphics2D) g;
        graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        for(int h=0; h < groupheight; h++) {
            String line = new String("");

            for (int w = 0; w < groupwidth; w++) {
                line = line + ascii_image[h][w];
            }

            asciilist.add(line);
            g.drawString(line, 0, h * g.getFontMetrics().getHeight());
        }
    }

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
