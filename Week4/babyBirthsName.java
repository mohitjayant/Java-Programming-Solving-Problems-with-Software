package Week4;
import edu.duke.*;
import java.io.*;
import org.apache.commons.csv.*;

public class babyBirthsName 
{
    public int totalBirths(FileResource fr) 
    {
        //FileResource fr=new FileResource();
        int totalBir=0;
        int totalBoys=0;
        int totalGirls=0;
        for(CSVRecord rec:fr.getCSVParser(false))
        {
            int numBorn=Integer.parseInt(rec.get(2)); 
            totalBir+=+1;
            if(rec.get(1).equals("M"))
            {
                totalBoys+=1;
            } 
            else
            {
                totalGirls+=1;
            }
        }
        return totalBoys;
        //System.out.println("Total Birth: "+totalBir);
        //System.out.println("Total Girls: "+totalGirls);
        //System.out.println("Total Boys: "+totalBoys);

    }

    public int calRank(FileResource fr,String gender,String name)
    {
        int rank=-1;
        int count=0;
        for(CSVRecord rec:fr.getCSVParser(false))
        {
            if(rec.get(1).equals(gender))
            {
                if(rec.get(0).equals(name))
                {
                    rank=count+1;
                    break;
                }
                else
                {
                    count++;
                }
            }
            
        }
        return rank;
    }

    public void getRank(String name,int year,String gender)
    {
        
        String fName="Week4/us_babynames/us_babynames_by_year/yob"+year+".csv";
        System.out.println(fName);
        FileResource fr=new FileResource(fName);
        
        int rank=calRank(fr, gender, name);
        System.out.println("Rank of "+ name +" : "+rank);
    }

    public void getName(int year,int rank,String gender)
    {
        String fName="Week4/us_babynames/us_babynames_by_year/yob"+year+".csv";
        System.out.println(fName);
        FileResource fr=new FileResource(fName);
        String name="NO NAME";
        int count=0;
        for(CSVRecord rec:fr.getCSVParser(false))
        {
            if(rec.get(1).equals(gender))
            {
                count++;
                if(count==rank)
                {
                    name=rec.get(0);
                    break;
                }
            }
        }

        System.out.println("Name at "+rank+" : "+name);
    }


    public void rankInManyFiles() 
    {
        double avg=0;
        int count=0;
        int highestRank=Integer.MIN_VALUE;
        DirectoryResource dr=new DirectoryResource();
        for(File f:dr.selectedFiles())
         {
             FileResource fr=new FileResource(f);
             int currentRank=calRank(fr,"M","Mich");
             count++;
             avg+=currentRank;
             if((currentRank>highestRank) && currentRank!=-1)
             {
                 highestRank=currentRank;
             }
         }
         avg=avg/count;
         System.out.println("Avg. rank of All Files: "+avg);
         System.out.println("Highest rank: "+highestRank);
    }

    public void totalChild(String name,String gender,int year) 
    {
        String fName="Week4/us_babynames/us_babynames_by_year/yob"+year+".csv";
        System.out.println(fName);
        FileResource fr=new FileResource(fName);
        //int rank=calRank(fr, gender, name);
        int total=0;
        int child=totalBirths(fr);
        for(CSVRecord rec:fr.getCSVParser(false))
        {
            if(rec.get(1).equals(gender))
            {
                if(rec.get(0).equals(name))
                {
                    //System.out.println(rec.get(0));
                    break;
                }
                else
                {
                    
                    total=total+1;
                    
                    //System.out.println(total);
                }
            }
        }

        System.out.println("Num. of  Rank > Drew: "+(child-total));
    }

    public void printNames() 
    {
        
        //totalBirths();
        //getRank("Owen",1974,"M");
        //getName(1982,450,"M");
        //rankInManyFiles();
        totalChild("Drew","M",1990);
        
    }

    public static void main(String[] args) {
        babyBirthsName bbn=new babyBirthsName();
        bbn.printNames();
    }
}