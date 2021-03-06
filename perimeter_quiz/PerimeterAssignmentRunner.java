import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }
    
    public double largestLength(Shape s)
    {
        double maxm=0.0;
        int pt=0;
        Point prevPt=s.getLastPoint();
        for(Point currPt:s.getPoints())
        {
            double currDist=prevPt.distance(currPt);
            maxm+=currDist;
            prevPt=currPt;
            pt+=1;
            
        }
        
        return maxm/pt;
    }


    public void testPerimeter () {
        FileResource fr = new FileResource("datatest4.txt");
        Shape s = new Shape(fr);
        //double length = getPerimeter(s);
        double length=largestLength(s);
        System.out.println("perimeter = " + length);
    }


    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }


    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
    }
}
