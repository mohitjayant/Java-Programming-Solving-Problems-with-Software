package Week3;
import edu.duke.*;
import org.apache.commons.csv.*;

public class countryExport {

    public void listExport(CSVParser parser,String exportInterest)
    {
        System.out.println("Country which export a specific product: ");
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
        System.out.println("Conuntry Exports and Value: ");
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

    public void listExportersTwoProducts(CSVParser parser,String product1,String product2) 
    {
        System.out.println("Countries which export both Products: ");
        for(CSVRecord record:parser)
        {
            String product=record.get("Exports");
            
            if(product.contains(product1) && product.contains(product2))
            {
                System.out.println(record.get("Country"));
            }
        }
    }

    public void testListExport()
    {
        FileResource fr=new FileResource();
        CSVParser parser=fr.getCSVParser();

        listExport(parser,"diamonds");
        parser=fr.getCSVParser();
        countryInfo(parser,"Germany");
        parser=fr.getCSVParser();
        listExportersTwoProducts(parser,"gold","diamonds");
    }

    public static void main(String[] args) {
        countryExport ce=new countryExport();
        ce.testListExport();
    }
    
}