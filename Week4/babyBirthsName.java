package Week4;
import edu.duke.*;
import org.apache.commons.csv.*;

public class babyBirthsName 
{
    public void totalBirths(FileResource fr) 
    {
        int totalBir=0;
        int totalBoys=0;
        int totalGirls=0;
        for(CSVRecord rec:fr.getCSVParser(false))
        {
            int numBorn=Integer.parseInt(rec.get(2)); 
            totalBir+=numBorn;
            if(rec.get(1).equals("M"))
            {
                totalBoys+=numBorn;
            } 
            else
            {
                totalGirls+=numBorn;
            }
        }
        System.out.println("Total Birth: "+totalBir);
        System.out.println("Total Girls: "+totalGirls);
        System.out.println("Total Boys: "+totalBoys);

    }

    public void printNames() 
    {
        FileResource fr=new FileResource();
        totalBirths(fr);
        
    }

    public static void main(String[] args) {
        babyBirthsName bbn=new babyBirthsName();
        bbn.printNames();
    }
}