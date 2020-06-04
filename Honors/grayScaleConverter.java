package Honors;
import edu.duke.*;

public class grayScaleConverter 
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

    public void testMakeGray() 
    {
        ImageResource ir=new ImageResource();
        ImageResource gray=makeGray(ir);
        gray.draw();
    }

    public static void main(String[] args) {
        grayScaleConverter gsc=new grayScaleConverter();
        gsc.testMakeGray();
    }
}