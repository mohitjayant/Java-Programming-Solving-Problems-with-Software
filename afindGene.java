import edu.duke.*;

public class afindGene {

    public String findGeneSample(String dna) {
        String result="";
        int startIn=dna.indexOf("ATG");
        if(startIn==-1)
        {
            return "";
        }
        int endIn=dna.indexOf("TAA",startIn+3);
        if(endIn==-1)
        {
            return "";
        }
        if((endIn-startIn)%3!=0)
        {
            return "";
        }
        result=dna.substring(startIn, endIn+3);
        return result;
        
    }

    public void geneTest() {
        String dna="AAATGCCCTAACTAGATTAAGAAACC";
        System.out.println("DNA strand is " + dna);
        String gene=findGeneSample(dna);
        System.out.println("Gene is " + gene);
    }

    public static void main(String[] args) {
        afindGene fd=new afindGene();
        fd.geneTest();
    }
}