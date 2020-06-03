package Week3;
import edu.duke.*;
import java.io.*;
import org.apache.commons.csv.*;

public class maxmTemp {

    public CSVRecord calMaxTemp(CSVParser parser)
    {
        CSVRecord largestSoFar=null;
        for(CSVRecord currentRow:parser)
        {
            if(largestSoFar==null)
            {
                largestSoFar=currentRow;
            }
            else
            {
                double currentTemp=Double.parseDouble(currentRow.get("TemperatureF"));
                double largesttemp=Double.parseDouble(currentRow.get("TemperatureF"));

                if(currentTemp>largesttemp)
                {
                    largestSoFar=currentRow;
                }
            }
        }

        return largestSoFar;
    }

    public void testSingleTemp() 
    {
        FileResource fr=new FileResource();
        CSVParser parser=fr.getCSVParser();

        CSVRecord temp=calMaxTemp(parser);
        double temperature=Double.parseDouble(temp.get("TemperatureF"));
        System.out.println("Maxm. Temperature: "+temperature + " at "+temp.get("TimeEST"));
    }

    public void testManyDaysTemp() {
         CSVRecord largestSoFar=null;
         DirectoryResource dr=new DirectoryResource();

         for(File f:dr.selectedFiles())
         {
             FileResource fr=new FileResource(f);
             CSVRecord currentRow=calMaxTemp(fr.getCSVParser());
             if(largestSoFar==null)
             {
                 largestSoFar=currentRow;
             }
             else
             {
                double currentTemp=Double.parseDouble(currentRow.get("TemperatureF"));
                double largesttemp=Double.parseDouble(currentRow.get("TemperatureF"));

                if(currentTemp>largesttemp)
                {
                    largestSoFar=currentRow;
                }
             }
         }
         System.out.println("Maxm. Temperature: "+Double.parseDouble(largestSoFar.get("TemperatureF")) + " at "+largestSoFar.get("DateUTC"));
        
    }

    public static void main(String[] args) {
        maxmTemp mt=new maxmTemp();
        //Function for maxm Temperature in a day
        //mt.testSingleTemp();
        //Function for maxm Temperature in many days
        mt.testManyDaysTemp();

    }
    
};