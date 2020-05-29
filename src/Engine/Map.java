package Engine;

import java.awt.Graphics;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;
import java.util.Set;

/**
 *
 */
public class Map {

    public Shape[] shapes;
    public final int maxLimit = 10;
    
    
    public Map(){
       
        MakeRandCubes(500);
        //MakeVarFloor();
        //Hallway();
        
    }
    
    public void MakeCube(){
        CubePart cp = new CubePart();
        Point p  = new Point();
        p.x=0; p.y=0; p.z=0;
        cp.c = Cube.MakeCube(p,5,5,5);
        shapes[0].addPart(cp);
        
    }
    
    
    public void MakeRandCubes(int amount){
        Random r = new Random();
        
        shapes = new Shape[amount];
        for(int i=0;i<amount;i++){
            Point p = new Point();
            p.x = r.nextInt(500);
            p.y = r.nextInt(500);
            p.z =r.nextInt(500);
            shapes[i] = new Shape(p);
            
            Point p2a  = new Point();
        p2a.x=0; p2a.y=0; p2a.z=0;
        CubePart cp2 = new CubePart();
        cp2.c = Cube.MakeCube(p2a, r.nextInt(10),r.nextInt(10),r.nextInt(10));
            //cp2.c = Cube.MakeCube(p2a, 5,5,5);
        shapes[i].addPart(cp2);
            
            
            
        }
        
        
        
    }
    
    
    public void MakeVarFloor(){
        Random r = new Random();
        shapes = new Shape[500];
        int i = 0;
        for(int x =0; x<10;x++){
            for(int y=0;y<50;y++){
                Point p = new Point();
                p.x = x*5;
                p.y = y*5;
                p.z = 0;
                
                shapes[i] = new Shape(p);
               
                Point p2 = new Point();
                 p2.x = 0;
                p2.y = 0;
                p2.z = 0;
                
                CubePart cp2 = new CubePart();
        cp2.c = Cube.MakeCube(p2, 2, 2, r.nextInt(2));
            
        shapes[i].addPart(cp2);
                
                
                
                i++;
            }
        }
        
        
        
        
        
    }
    
    
    public void Hallway(){
        Random r = new Random();
        shapes = new Shape[500];
        
        for(int i =0; i<shapes.length;i++){
            
                Point p = new Point();
                p.x = 0;
                p.y = i*20;
                p.z = 0;
                
                shapes[i] = new Shape(p);
               
                Point p2 = new Point();
                 p2.x = 0;
                p2.y = 0;
                p2.z = 0;
                
                CubePart cp2 = new CubePart();
        cp2.c = Cube.MakeCube(p2, i*1, i*1, i*1);
            
            Point p3 = new Point();
                 p3.x = 30;
                p3.y = 0;
                p3.z = 0;
        
        CubePart cp3 = new CubePart();
        cp3.c = Cube.MakeCube(p3, i*1, i*1, i*1);
        
        shapes[i].addPart(cp2);
        shapes[i].addPart(cp3);
                
                
                
                
            
        }
    }
    
    
    
    
    
    /*
    Yes i understand that a local and gloabal translate will result in the same
    image being displayed to the screen i have written it out here so that i 
    may not forget that there is a differnece between the two
    */
    
    
    /**
     * Transform all shapes, locally
     * @param a 
     */
    public void transform(double[][] a){
        for(int i =0; i<shapes.length;i++){
            shapes[i].transform(a);
        }
    }
    
    /**
     * Translate all shapes, locally
     * @param a 
     */
    public void translate(double[][] a){
        for(int i =0 ; i<shapes.length;i++){
            shapes[i].translate(a);
        }
    }
    
    /**
     * Transform all shapes, globally
     */
    public void Global_Transform(double[][] a){
        for(int i =0; i<shapes.length;i++){
            shapes[i].Gloabal_Transform(a);
            shapes[i].transform(a);
        }
    }
    
    /**
     * Translate all shapes, globally
     */
    public void Global_Translate(double[][] a){
        for(int i =0; i<shapes.length;i++){
            shapes[i].Gloabal_Translate(a);
        }
    }
    
    public void drawMap(Graphics g){
        for(int i=0; i<shapes.length;i++){
            
            shapes[i].draw(g);
            
        }
    }
    
    
    

}