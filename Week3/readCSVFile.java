package Week3;

import edu.duke.*;
import org.apache.commons.csv.*;
public class readCSVFile {
    public void testReadCSV() {

        FileResource fr=new FileResource();
        CSVParser parser=fr.getCSVParser();

        for(CSVRecord record:parser)
        {
            System.out.print(record.get("Name")+" ");
            System.out.print(record.get("Favorite Color")+" ");
            System.out.println(record.get("Favorite Food"));
        }
    }

    public static void main(String[] args) {
        readCSVFile tt=new readCSVFile();
        tt.testReadCSV();
    }
    
}