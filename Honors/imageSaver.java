package Honors;
import edu.duke.*;
import java.io.*;

public class imageSaver 
{

    public void doSave() {
        DirectoryResource dr=new DirectoryResource();
        for(File f:dr.selectedFiles())
        {
            ImageResource image=new ImageResource(f);
            String fName=image.getFileName();
            String newName="copy-"+fName;
            image.setFileName(newName);
            image.draw();
            image.save();
        }
    }

    public static void main(String[] args) {
        imageSaver ims=new imageSaver();
        ims.doSave();
    }
}