/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine;

import java.awt.Graphics;

/**
 *
 */
public class Shape {
    
    Point origin;
    private Part[] parts;
    
    
    public Shape(Point o){
        origin = o;
        parts = new Part[0];
    }
    
    public void draw(Graphics g){
        for(int i =0; i<parts.length;i++){
            parts[i].draw(g,origin);
        }
    }


    public void addPart(Part p){   
        /**
        Part[] a = parts; //MAKE THIS BETTER IM TOO TIRED 
        Part[] b = new Part[parts.length+1];
        System.arraycopy(a, 0, b, 0, parts.length);
        b[parts.length] = p;
        parts = b;
        **/
        
        Part[] a = parts;
        parts = new Part[parts.length+1];
        
        for(int i=0; i<parts.length-1;i++){
        
            parts[i]=a[i];
        }
        parts[parts.length-1] = p;
        
        
    }
    
    
   /**
    * Translates the shape using the local coordinate system 
    * @param a 
    */ 
    public void translate(double[][] a){
        for(int i =0 ; i<parts.length;i++){
            parts[i].translate(a);
        }
    }
    
    /**
    * Transforms the shape using the local coordinate system 
    * @param a 
    */ 
    public void transform(double[][] a){
        for(int i =0 ; i<parts.length;i++){
            parts[i].transformation(a);
        }
    }
    
    public void Gloabal_Translate(double[][] a){
        origin = Functional_Point.Translate(a, origin);
    }

    public void Gloabal_Transform(double[][] a){
        origin = Functional_Point.Transform(a,origin);
    }
    
    
}
