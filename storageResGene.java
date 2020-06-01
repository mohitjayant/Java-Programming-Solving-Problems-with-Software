import edu.duke.*;
import java.io.*;
public class storageResGene {

    public int findStopCodon(String dnaStr,int startIndex,String stopCodon) {
        
        int currIndex= dnaStr.indexOf(stopCodon,startIndex+3);

        while(currIndex!=-1)
        {
            if((currIndex-startIndex)%3==0)
            {
                return (currIndex);
            }
            else
            {
                currIndex=dnaStr.indexOf(stopCodon, currIndex+3);
            }
        }

        return dnaStr.length();
        
    }

    public String geneTest(String dna,int where) {
        
        int startIndex=dna.indexOf("ATG",where);
        //System.out.println(startIndex);
        if(startIndex==-1)
        {
            return "";
        }
        int taaIndex=findStopCodon(dna, startIndex, "TAA");
        int tagIndex=findStopCodon(dna, startIndex, "TAG");
        int tgaIndex=findStopCodon(dna, startIndex, "TGA");
        //int temp=Math.min(taaIndex, tagIndex);
        //int minm=Math.min(temp,tgaIndex);
        int minm=0;
        if(taaIndex==-1 || ((tgaIndex!=-1) && (tgaIndex<taaIndex)))
        {
            minm=tgaIndex;
        }
        else
        {
            minm=taaIndex;
        }
        if(minm==-1||((tagIndex!=-1) && (tagIndex<minm)))
        {
            minm=tagIndex;
        }

        if(minm==-1)
        {
            return "";
        }

        return dna.substring(startIndex, minm+3);
        
        
    }

    public double cgRatio(String dna)
    {
        int c=0;
        int g=0;
        char ch='C';
        char gh='G';
        for(int i=0;i<dna.length();i++)
        {
            if(dna.charAt(i)==ch)
            {
                c++;
            }
            if(dna.charAt(i)==gh)
            {
                g++;
            }
        }
        return (double)(c+g)/dna.length();
    }

    public int countCTG(String dna)
    {
        int res=0;
        int index=dna.indexOf("CTG");

        while(index!=-1)
        {
            res++;
            index=dna.indexOf("CTG",index+3);

        }

        return res;
    }

    public void testFindGene() {
        String dna="ATGCTGTAACTG";
        System.out.println("DNA strand is " + dna);
        double cg=cgRatio(dna);
        System.out.println("cg Ratio: "+cg);
        System.out.println("No. of CTG is "+countCTG(dna));
        //System.out.println("Gene is ");
        StorageResource sr=new StorageResource();

        int startIndex=0;
        while(true)
        {
            String gene=geneTest(dna,startIndex);
            if(gene.isEmpty())
            {
                break;
            }
            sr.add(gene);
            startIndex=dna.indexOf(gene,startIndex)+gene.length();
        }
        System.err.println("Gene are: ");
        for(String gene:sr.data())
        {
            System.out.println(gene);
        }
        
    }

    
    public static void main(String[] args) {
        storageResGene srg=new storageResGene();
        srg.testFindGene();
    }
}