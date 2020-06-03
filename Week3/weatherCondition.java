package Week3;
import edu.duke.*;
import java.io.*;
import org.apache.commons.csv.*;

public class weatherCondition {

    public CSVRecord minmOfTwo(CSVRecord currentRow,CSVRecord minmSoFar) 
    {
        if(minmSoFar==null)
            {
                minmSoFar=currentRow;
            }
        else
        {
            double current=Double.parseDouble(currentRow.get("TemperatureF"));
            double largest=Double.parseDouble(minmSoFar.get("TemperatureF"));
            if(current==-9999.0)
            {
                current=largest;
            }

            if(current<largest)
            {
                minmSoFar=currentRow;
            }
        }
        return minmSoFar;
    }

    public CSVRecord calMaxTemp(CSVParser parser)
    {
        CSVRecord minmSoFar=null;
        for(CSVRecord currentRow:parser)
        {
            minmSoFar=minmOfTwo(currentRow, minmSoFar);
        }

        return minmSoFar;
    }

    public double avgTemperature(CSVParser parser) 
    {
        double avg=0.0;
        int count=0;
        for(CSVRecord record:parser)
        {
            
            double temp=Double.parseDouble(record.get("TemperatureF"));
            count++;
            avg+=temp;
        }
        avg=avg/count;
        return avg;
    }

    public void testSingleTemp() 
    {
        FileResource fr=new FileResource();
        CSVParser parser=fr.getCSVParser();

        CSVRecord temp=calMaxTemp(parser);
        parser=fr.getCSVParser();
        double temperature=avgTemperature(parser);
        System.out.println("Avg. Temperature: "+ temperature + " at "+temp.get("DateUTC"));
        System.out.println("Minm. Temperature: "+temp.get("TemperatureF") + " at "+temp.get("DateUTC"));
    }

    public void testManyDaysTemp() 
    {
         CSVRecord smallSoFar=null;
         DirectoryResource dr=new DirectoryResource();

         for(File f:dr.selectedFiles())
         {
             FileResource fr=new FileResource(f);
             CSVRecord currentRow=calMaxTemp(fr.getCSVParser());
             smallSoFar=minmOfTwo(currentRow, smallSoFar);
         }
         System.out.println("Minm. Temperature: "+smallSoFar.get("TemperatureF") + " at "+smallSoFar.get("DateUTC"));
        
    }

    public CSVRecord lowestHumidityInFile(CSVParser parser)
    {
        CSVRecord minmSoFar=null;
        for(CSVRecord currentRow:parser)
        {
            minmSoFar=minmOfTwo(currentRow, minmSoFar);
        }

        return minmSoFar;
    }

    public void testLowestHumidityInFile() 
    {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        CSVRecord csv = lowestHumidityInFile(parser);
        System.out.println("Minm. Humidity: "+csv.get("Humidity") + " at "+csv.get("DateUTC"));
    }

    public void testLowestHumidityInManyFile() 
    {
         CSVRecord smallSoFar=null;
         DirectoryResource dr=new DirectoryResource();

         for(File f:dr.selectedFiles())
         {
             FileResource fr=new FileResource(f);
             CSVRecord currentRow=lowestHumidityInFile(fr.getCSVParser());
             smallSoFar=minmOfTwo(currentRow, smallSoFar);
         }
         System.out.println("Minm. Humidity: "+Double.parseDouble(smallSoFar.get("Humidity")) + " at "+smallSoFar.get("DateUTC"));
        
    }

    public static void main(String[] args) {
        weatherCondition mt=new weatherCondition();
        //Function for maxm Temperature in a day
        //mt.testSingleTemp();
        //Function for maxm Temperature in many days
        mt.testManyDaysTemp();
        //Test lowest humidity
        //mt.testLowestHumidityInFile();
        //mt.testLowestHumidityInManyFile();

    }
    
};