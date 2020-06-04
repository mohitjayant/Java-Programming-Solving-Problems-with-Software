package Honors;
import edu.duke.*;
import java.io.*;

public class batchGrayScale 
{

    public ImageResource makeGray(ImageResource image)
    {
        ImageResource outImage=new ImageResource(image.getWidth(),image.getHeight());
        for(Pixel pixel:outImage.pixels())
        {
            Pixel inPixel=image.getPixel(pixel.getX(), pixel.getY());
            int avg=inPixel.getRed()+inPixel.getGreen()+inPixel.getBlue();
            avg=avg/3;
            pixel.setRed(avg);
            pixel.setGreen(avg);
            pixel.setBlue(avg);
        }

        return outImage;
    }

    public void selectAndConvert() 
    {
        DirectoryResource dr=new DirectoryResource();
        for(File f:dr.selectedFiles())
        {
            ImageResource inImage=new ImageResource(f);
            String fName=inImage.getFileName();
            String newName="gray-"+fName;
            ImageResource gray=makeGray(inImage);
            gray.setFileName(newName);
            gray.save();
            gray.draw();
        }
    }
    public static void main(String[] args) {
        batchGrayScale bsc=new batchGrayScale();
        bsc.selectAndConvert();
    }
    

}