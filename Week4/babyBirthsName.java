package Week4;
import edu.duke.*;
import org.apache.commons.csv.*;

public class babyBirthsName 
{

    public void printNames() 
    {
        FileResource fr=new FileResource();
        for(CSVRecord rec:fr.getCSVParser(false))
        {
            System.out.println("Names "+rec.get(0)+" Gender "+rec.get(1)+" Num. Born "+rec.get(2));
        }
    }

    public static void main(String[] args) {
        babyBirthsName bbn=new babyBirthsName();
        bbn.printNames();
    }
}