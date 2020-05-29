/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine;
/**
 *
 */
public class ScreenManager {
    
    private static int x_Size;
    private static int y_Size; 
    
    private static int x_center;
    private static int y_center;
    
    public static int zoom = 1;
    
    
    
    public static void set_x_Size(int x){
        x_Size= x;
        x_center=x_Size/2;
    }
    
    public static void set_y_Size(int y){
        y_Size= y;
        y_center=y_Size/2;
    }
    
    
    public static int x_Size(){
        return x_Size;
    }
    
    public static int y_Size(){
        return y_Size;
    }
    
    public static int x_centre(){
        return x_center;
    }
    
    public static int y_centre(){
        return y_center;
    }
    
    
    
    
    
}