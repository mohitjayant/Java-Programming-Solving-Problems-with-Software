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

    public void testListExport()
    {
        FileResource fr=new FileResource();
        CSVParser parser=fr.getCSVParser();

        listExport(parser,"sugar");
    }

    public static void main(String[] args) {
        countryExport ce=new countryExport();
        ce.testListExport();
    }
    
}