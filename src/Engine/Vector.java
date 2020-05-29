/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine;

import java.awt.Graphics;

public class Vector {
    
    public Point a;
    public Point b;
    
    private boolean isVisible = true;
  
    public Vector(){
        definePoints();   
    }
    
    private void definePoints(){
        a = new Point();
        b=new Point();
    }
  
  public static boolean draw(Graphics g, Vector v){
     boolean isVisible = false;
      
      isVisible = Functional_Point.draw(g,v.a) || isVisible;
      
      isVisible =  Functional_Point.draw(g,v.b) ||  isVisible;
      
      
      if(isVisible){
          //connect the dots
          Point sa = Functional_Point.findScreenLoc(v.a);
          Point sb = Functional_Point.findScreenLoc(v.b);
          
          g.drawLine((int)sa.x, (int)sa.y, (int)sb.x, (int)sb.y); 
          
          //System.out.println(" x1:"+a.x+" y1:"+a.y+" z1:"+a.z + "          x2:"+b.x+" y2:"+b.y);
      }else{
          //System.out.println("Could Not Draw");
      }
      
      
      return isVisible;
  }
    
    /*
     * Checks if the vector is in anyway in the view area of the camera
     * @param v
     * @return true if 1 point of vector is in camera view area
     */
 
  
    
  public static Vector vTransform(double[][] a, Vector v){
      Vector v2 = new Vector();
      
      v2.a =Functional_Point.Transform(a,v.a);
      v2.b =Functional_Point.Transform(a,v.b);
      
      return v2;
  } 
  
  public static Vector vTranslate(double[][] a, Vector v){
      Vector v2 = new Vector();
      
      v2.a = Functional_Point.Translate(a, v.a);
      v2.b = Functional_Point.Translate(a, v.b);
      
      return v2;
  
  }
  
  public static Vector AdjustForOrigin(Vector v, Point o){
       Vector v2 = new Vector();
      v2.a = Functional_Point.AdjustForOrigin(v.a, o);
      v2.b = Functional_Point.AdjustForOrigin(v.b, o);
      return v2;
  }
  
  
  
  
  
  
  
}
