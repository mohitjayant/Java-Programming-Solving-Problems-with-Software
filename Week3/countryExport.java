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

    public void numberOfExporters(CSVParser parser,String product)
    {
        int count=0;
        for(CSVRecord record:parser)
        {
            String export=record.get("Exports");
            if(export.contains(product))
            {
                count++;
            }
        }
        System.out.println("Number of Exporters of "+product+" : "+count);
    } 

    public void bigExporters(CSVParser parser,String value)
    {
        int len=value.length();
        System.out.println("Big Exporters: ");
        for(CSVRecord record:parser)
        {
            String cal=record.get("Value (dollars)");
            int big=cal.length();
            if(big>len)
            {
                System.out.println(record.get("Country")+" "+cal);
            }
        }
    }

    public void testListExport()
    {
        FileResource fr=new FileResource();
        CSVParser parser=fr.getCSVParser();

        listExport(parser,"diamonds");
        parser=fr.getCSVParser();
        countryInfo(parser,"Nauru");
        parser=fr.getCSVParser();
        listExportersTwoProducts(parser,"gold","diamonds");
        parser=fr.getCSVParser();
        numberOfExporters(parser,"sugar");
        parser=fr.getCSVParser();
        bigExporters(parser,"$999,999,999,999");
    }

    public static void main(String[] args) {
        countryExport ce=new countryExport();
        ce.testListExport();
    }
    
}