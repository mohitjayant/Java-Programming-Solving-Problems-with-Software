import edu.duke.*;

public class calPerimeter {
    
    public double getPerimeter(Shape s)
    {
        double totPerimeter=0.0;
        Point prevPt=s.getLastPoint();
        for(Point currPt:s.getPoints())
        {
            double currDist=prevPt.distance(currPt);
            totPerimeter+=currDist;
            prevPt=currPt;
        }
        return totPerimeter;
    }

    public void testPerimeter()
    {
        FileResource fr=new FileResource("datatest1.txt");
        Shape s=new Shape(fr);
        
        double length=getPerimeter(s);
        System.out.println(length);
    }

    public static void main(String[] args) {
        
        calPerimeter cp=new calPerimeter();
        cp.testPerimeter();

    }
}