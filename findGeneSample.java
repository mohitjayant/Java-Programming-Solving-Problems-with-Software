public class findGeneSample {

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

    public void testfindGene() {
        String dna="ATGATCTAATTTATGCTGCAACGGTGAAGA";
        System.out.println("DNA strand is " + dna);
        System.out.println("Gene is ");
        int startIndex=0;
        while(true)
        {
            String gene=geneTest(dna,startIndex);
            if(gene.isEmpty())
            {
                break;
            }
            System.out.println(gene);
            startIndex=dna.indexOf(gene,startIndex)+gene.length();
        }
        
        
    }

    public static void main(String[] args) {
        findGeneSample fd=new findGeneSample();
        fd.testfindGene();
    }
    
}