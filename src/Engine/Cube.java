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
public class Cube {
private boolean isVisible = true;
    
   /**
    * All of the sides of this cube
    */
    public Vector[] v = new Vector[12];
    
    
    
    public Cube(){
        this.FillVectorArray();    
    }
    
    private void FillVectorArray(){
        for(int i =0; i<v.length;i++){
            v[i] = new Vector();
        }
    }
    
    public static boolean draw(Graphics g, Cube c){
        boolean isVisible = false;
        
            for(int i =0; i<c.v.length;i++){    
                isVisible  = Vector.draw(g,c.v[i]) || isVisible;
        }
            return isVisible;
    }
   
    public static Cube cTranform(double[][] a, Cube c){
        Cube c2 = new Cube();        
        for(int i = 0; i< c.v.length; i++){
            c2.v[i] = Vector.vTransform(a, c.v[i]);
        }
        return c2;
    }
    
    
    public static Cube cTranslate(double[][] a, Cube c){
        Cube c2 = new Cube();   
        
        for(int i = 0; i< c.v.length; i++){
            c2.v[i] = Vector.vTranslate(a, c.v[i]);
        }
        return c2;
    }
    
    public static Cube AdjustForOrigin(Cube c, Point o){
        Cube a = new Cube();
        for(int i=0; i<c.v.length;i++){
            a.v[i] = Vector.AdjustForOrigin(c.v[i], o);
        }
        return a;
    }
    
    
    
    
    
    
   
    /**
     * Creates a cube object 
     * The point given is the center of the cube
     * @param p
     * @param x_length
     * @param y_length
     * @param z_length
     * @return 
     */
    public static Cube MakeCube(Point p, int x_length, int y_length, int z_length){
        Cube FinalCube = new Cube();
        
        p.x = p.x-(x_length/2);
        p.y = p.y-(y_length/2);
        p.z = p.z-(z_length/2);
        
        
       //
        FinalCube.v[0].a.x =p.x;
        FinalCube.v[0].a.y =p.y; 
        FinalCube.v[0].a.z =p.z; 
        
        FinalCube.v[0].b.x =p.x+x_length;
        FinalCube.v[0].b.y =p.y;
        FinalCube.v[0].b.z =p.z;
        
        
        FinalCube.v[1].a.x =p.x;
        FinalCube.v[1].a.y =p.y;
        FinalCube.v[1].a.z =p.z;
        
        FinalCube.v[1].b.x =p.x;
        FinalCube.v[1].b.y =p.y+y_length;
        FinalCube.v[1].b.z =p.z;
        
        
        FinalCube.v[2].a.x =p.x;
        FinalCube.v[2].a.y =p.y;
        FinalCube.v[2].a.z =p.z;
        
        FinalCube.v[2].b.x =p.x;
        FinalCube.v[2].b.y =p.y;
        FinalCube.v[2].b.z =p.z+z_length;
        //
        
        
        //
        FinalCube.v[3].a.x =p.x + x_length;
        FinalCube.v[3].a.y =p.y + y_length;
        FinalCube.v[3].a.z =p.z;
        
        FinalCube.v[3].b.x =p.x+x_length;
        FinalCube.v[3].b.y =p.y;
        FinalCube.v[3].b.z =p.z;
        
        
        FinalCube.v[4].a.x =p.x + x_length;
        FinalCube.v[4].a.y =p.y + y_length;
        FinalCube.v[4].a.z =p.z;
        
        FinalCube.v[4].b.x =p.x;
        FinalCube.v[4].b.y =p.y+y_length;
        FinalCube.v[4].b.z =p.z;
        
        
        FinalCube.v[5].a.x =p.x + x_length;
        FinalCube.v[5].a.y =p.y + y_length;
        FinalCube.v[5].a.z =p.z;
        
        FinalCube.v[5].b.x =p.x+x_length;
        FinalCube.v[5].b.y =p.y+y_length;
        FinalCube.v[5].b.z =p.z+z_length;
        //
        
        //
        FinalCube.v[6].a.x =p.x;
        FinalCube.v[6].a.y =p.y;
        FinalCube.v[6].a.z =p.z+z_length;
        
        FinalCube.v[6].b.x =p.x+x_length;
        FinalCube.v[6].b.y =p.y;
        FinalCube.v[6].b.z =p.z+z_length;
        
        
        FinalCube.v[7].a.x =p.x;
        FinalCube.v[7].a.y =p.y;
        FinalCube.v[7].a.z =p.z+z_length;
        
        FinalCube.v[7].b.x =p.x;
        FinalCube.v[7].b.y =p.y+y_length;
        FinalCube.v[7].b.z =p.z+z_length;
        //
        
        
        //
        FinalCube.v[8].a.x =p.x+x_length;
        FinalCube.v[8].a.y =p.y+y_length;
        FinalCube.v[8].a.z =p.z+z_length;
        
        FinalCube.v[8].b.x =p.x+x_length;
        FinalCube.v[8].b.y =p.y;
        FinalCube.v[8].b.z =p.z+z_length;
        
        
        FinalCube.v[9].a.x =p.x+x_length;
        FinalCube.v[9].a.y =p.y+y_length;
        FinalCube.v[9].a.z =p.z+z_length;
        
        FinalCube.v[9].b.x =p.x;
        FinalCube.v[9].b.y =p.y+y_length;
        FinalCube.v[9].b.z =p.z+z_length;
        //
        
        FinalCube.v[10].a.x =p.x+x_length;
        FinalCube.v[10].a.y =p.y;
        FinalCube.v[10].a.z =p.z+z_length;
        
        FinalCube.v[10].b.x =p.x+x_length;
        FinalCube.v[10].b.y =p.y;
        FinalCube.v[10].b.z =p.z;
        
        
        
        FinalCube.v[11].a.x =p.x;
        FinalCube.v[11].a.y =p.y+y_length;
        FinalCube.v[11].a.z =p.z+z_length;
        
        FinalCube.v[11].b.x =p.x;
        FinalCube.v[11].b.y =p.y+y_length;
        FinalCube.v[11].b.z =p.z;
        
        
        return FinalCube;
    }
    
    
    
    
    
    
    
}