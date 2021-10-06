package com.example.sping_portfolio.controllers.Grayscale;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public abstract class GrayscaleImages {
    protected File image;
    protected List<ImageInfo> imageList;
    protected List<ImageProp> imageDetails;
    protected String imageDesc;
    protected String base64;
    protected List<Integer> RGB;
    protected Array rbgVal;
    protected List<String> hexadecimal;
    protected Array binaryVal;
}
