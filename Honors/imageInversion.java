package Honors;
import edu.duke.*;
import java.io.*;

public class imageInversion 
{
    public ImageResource makeInversion(ImageResource image)
    {
        ImageResource outImage=new ImageResource(image.getWidth(),image.getHeight());
        for(Pixel pixel:outImage.pixels())
        {
            Pixel inPixel=image.getPixel(pixel.getX(), pixel.getY());
            pixel.setRed(255-inPixel.getRed());
            pixel.setGreen(255-inPixel.getGreen());
            pixel.setBlue(255-inPixel.getBlue());
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
            String newName="inverted-"+fName;
            ImageResource gray=makeInversion(inImage);
            gray.setFileName(newName);
            gray.save();
            gray.draw();
        }
    }

    public static void main(String[] args) {
        imageInversion imi=new imageInversion();
        imi.selectAndConvert();
    }
}