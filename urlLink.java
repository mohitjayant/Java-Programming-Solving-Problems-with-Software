import edu.duke.*;
public class urlLink {
public void urlFind() {
    URLResource file=new URLResource("http://www.dukelearntoprogram.com/course2/data/manylinks.html ");
    for(String item:file.words())
    {
        String itemLower=item.toLowerCase();
        int pos=itemLower.indexOf("youtube.com");
        if(pos!=-1)
        {
            int beg=item.lastIndexOf("\"",pos);
            int last=item.indexOf("\"",pos+1);
            System.out.println(item.substring(beg,last));
        }
    }
}

    public static void main(String[] args) {
        urlLink url=new urlLink();
        url.urlFind();
    }
}