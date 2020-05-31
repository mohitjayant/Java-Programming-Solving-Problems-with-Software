
public class pt {
    
    private int x;
    private int y;

    public pt(int startx,int starty)
    {
        x=startx;
        y=starty;
    }

    public int getX()
    {
        return x;
    }
    public int getY()
    {
        return y;
    }

    public double distance(pt oth)
    {
        int dx=x-oth.getX();
        int dy=y-oth.getY();
        double res=Math.sqrt(dx*dx+dy*dy);
        return res;
    }

    public static void main(String[] args) {
        pt p1=new pt(3,4);
        pt p2=new pt(6, 8);
        double d=3.14;
        int p=(int) d;
        System.out.println(p);
        System.out.println(p1.distance(p2));
    }
    
}


