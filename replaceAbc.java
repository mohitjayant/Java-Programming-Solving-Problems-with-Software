public class replaceAbc {

    public void findAbc(String input){
        int index = input.indexOf("abc");
        while (true){
            if (index == -1 || index >= input.length() - 3){
                break;
            }
           // System.out.println(index);
            //System.out.println("check string "+input.substring(index, index+3));
            String found = input.substring(index+1, index+4);
            System.out.println(found);
            index = input.indexOf("abc",index+3);
            //System.out.println("check string"+input.substring(index, index+3));
        }
        //System.out.println("index after updating " + index);
    }
 
    public void test(){
        //findAbc("abcd");
        findAbc("abcabcabcabca");
    }

    public static void main(String[] args) {
        replaceAbc rep=new replaceAbc();
        rep.test();
    }
    
}