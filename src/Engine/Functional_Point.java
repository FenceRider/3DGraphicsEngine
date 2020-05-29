
package Engine;

import java.awt.Graphics;

/**
 *
 */
public class Functional_Point extends Point {

    public static boolean draw(Graphics g, Point p) {

        //check if on screen then draw if true
        return  Functional_Point.CheckPoint(p);
    }

    public static boolean CheckPoint(Point p) {
        //check that the point falls in the screen's bounds
        
            boolean isVisible = false;
        if (p.x < CameraHolder.CAM.minx || p.x > CameraHolder.CAM.maxx) {
            isVisible = false;
            //System.out.println("THIS x");
        } else if (p.y < CameraHolder.CAM.miny || p.y > CameraHolder.CAM.maxy) {
            isVisible = false;
            //System.out.println("THIS y");
        } else if (p.z < CameraHolder.CAM.minz || p.z > CameraHolder.CAM.maxz) {
            isVisible = false;
            //System.out.println("THIS z");
        } else {
            isVisible = true;
        }

        return isVisible;
    }

   

    public static Point findScreenLoc(Point p) {
        double z = p.z;
        
        if(p.z<0){
            z = 0.000001;
        }
        
        Point p2 = new Point();
        p2.x = (p.x / z*ScreenManager.zoom) + ScreenManager.x_centre();
        p2.y = (p.y / z*ScreenManager.zoom) + ScreenManager.y_centre();
         
        p2.z = p.z;
        return p2;
    }

    
    
    /**
     * converts a Point to matrix form
     * @param p
     * @return 
     */
    public static double[][] ToMatrix(Point p){
        double[][] a = new double[3][1];

        a[0][0] = (double) p.x;
        a[1][0] = (double) p.y;
        a[2][0] = (double) p.z;
        return a;
    }
    
    /**
     * converts a matrix to point form
     * @param a
     * @return 
     */
    public static Point ToPoint(double[][] a){
       Point p = new Point();
        p.x =  a[0][0];
        p.y =  a[1][0];
        p.z =  a[2][0];
        return p;
    }
    
    /**
     *
     * @param transform a transformation matrix
     * @param p
     * @return
     */
    public static Point Transform(double[][] transform, Point p) {
        return ToPoint(Matrix.multiply(transform, ToMatrix(p)));
    }

    public static Point Translate(double[][] translate, Point p ){
        return ToPoint(Matrix.add(translate, ToMatrix(p)));
    }
     
    public static Point AdjustForOrigin(Point p, Point o){
        Point a = new Point();
        a.x = p.x+o.x;
        a.y = p.y+o.y;
        a.z = p.z+o.z;
        
        return a;
    }
    
    
    
}
