package Week3;
import edu.duke.*;
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

    public void testTemp() 
    {
        FileResource fr=new FileResource();
        CSVParser parser=fr.getCSVParser();

        CSVRecord temp=calMaxTemp(parser);
        double temperature=Double.parseDouble(temp.get("TemperatureF"));
        System.out.println("Maxm. Temperature: "+temperature + " at "+temp.get("TimeEST"));
    }

    public static void main(String[] args) {
        maxmTemp mt=new maxmTemp();
        mt.testTemp();
    }
    
};