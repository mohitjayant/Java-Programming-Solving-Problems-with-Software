public class multipleOccurance {

    public int howMany(String str1,String str2)
    {
        int res=0;
        int start=str2.indexOf(str1);
        if(start==-1)
        {
            return res;
        }
        res++;
        int curr=start;
        while(curr!=-1)
        {
            curr=str2.indexOf(str1,curr+str1.length());
            if(curr!=-1)
            {
                res++;
            }
        }
        return res;
    }

    public void testHowMany() {
        String str1="AA";
        String str2="ATAAAA";

        int res=howMany(str1,str2);
        System.out.println(res);
        
    }
    
    public static void main(String[] args) {
        multipleOccurance mc=new multipleOccurance();
        mc.testHowMany();
    }
}