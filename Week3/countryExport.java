package Week3;
import edu.duke.*;
import org.apache.commons.csv.*;

public class countryExport {

    public void listExport(CSVParser parser,String exportInterest)
    {
        for(CSVRecord record:parser)
        {
            String export=record.get("Exports");
            if(export.contains(exportInterest))
            {
                String country=record.get("Country");
                System.out.println(country);
            }
        }
    }

    public void countryInfo(CSVParser parser,String country) {
        String res="";
        for(CSVRecord record:parser)
        {
            
            String co=record.get("Country");
            if(co.contains(country))
            {
                res=co+": "+record.get("Exports")+": "+record.get("Value (dollars)");
                System.out.println(res);
                break;
            }
        }

        if(res=="")
        {
            System.out.println("NOT FOUND");
        }
    }

    public void testListExport()
    {
        FileResource fr=new FileResource();
        CSVParser parser=fr.getCSVParser();

        //listExport(parser,"sugar");
        countryInfo(parser,"Germany");
    }

    public static void main(String[] args) {
        countryExport ce=new countryExport();
        ce.testListExport();
    }
    
}