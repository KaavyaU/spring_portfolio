package com.example.sping_portfolio.controllers.Grayscale;

import java.io.File;
import java.lang.reflect.Array;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class GrayscaleImages {
    public List<ImageInfo> imageList;
    /*
    protected List<ImageProp> imageDetails;
    protected File image;
    protected String imageDesc;
    protected String base64;
    protected List<Integer> RGB;
    protected int [][][] rbgVal;
    protected List<String> hexadecimal;
    protected Array binaryVal;
     */
    public void addWatermark(List<ImageInfo> imageList){
        File thisImage;
        String colorPath;
        File colorWatermark;
        for (int i = 0; i <imageList.size(); i++){
            thisImage = imageList.get(i).image;
            colorPath = "resources/static/images/colorWatermark" + String.valueOf(i) +".png";
            colorWatermark = new File(colorPath);
            //AddWatermark.addTextWatermark(thisImage, colorWatermark);
        }
    }
}
