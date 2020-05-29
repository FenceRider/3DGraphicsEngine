/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine;

/**
 * 
 * YES this class deals with translations despite the name.
 * 
 * 
 */
public class TransformationMatrix {
    
    
    
    public double[][] matrix;
    
    //quick refrence| This is not used for this class but in others 
    //Rotate 
    public static final int xy = 1;
    public static final int xz = 2;
    public static final int yz = 3;
    
    //Translate
    public static final int Tx = 4;
    public static final int Ty = 5;
    public static final int Tz = 6;
    
    
    
    
    
    
    
    public static double[][] rotate_xy(double theta){
        
        double[][] a = new double[3][3];
        
        a[0][0]=Math.cos(theta);
        a[0][1]=0-(Math.sin(theta));
        a[0][2]=0;
        
        a[1][0]=Math.sin(theta);
        a[1][1]=Math.cos(theta);
        a[1][2]=0;
        
        a[2][0]=0;
        a[2][1]=0;
        a[2][2]=1;
        
        
        return a;
    }
    
    public static double[][] rotate_xz(double theta){
        
        double[][] a = new double[3][3];
        
        a[0][0]=Math.cos(theta);
        a[0][1]=0;
        a[0][2]=Math.sin(theta);
        
        a[1][0]=0;
        a[1][1]=1;
        a[1][2]=0;
        
        a[2][0]=0-(Math.sin(theta));
        a[2][1]=0;
        a[2][2]=Math.cos(theta);
        
        
        return a;
    }
    
    public static double[][] rotate_yz(double theta){
        double[][] a = new double[3][3];
        
        a[0][0]=1;
        a[0][1]=0;
        a[0][2]=0;
        
        a[1][0]=0;
        a[1][1]=Math.cos(theta);
        a[1][2]=0-Math.sin(theta);
        
        a[2][0]=0;
        a[2][1]=Math.sin(theta);
        a[2][2]=Math.cos(theta);
        
        
        return a;
    }
    
    
    /*
     * Translations ||
     *              \/
     */
    
    
    
    public static double[][] translate_x(double scaler){
        double[][] a = new double[3][1];
        a[0][0]= scaler;
        a[1][0] = 0;
        a[2][0] = 0;
        return a;
    }
    
    public static double[][] translate_y(double scaler){
        double[][] a = new double[3][1];
        a[0][0] = 0;
        a[1][0] = scaler;
        a[2][0] = 0;
        return a;
    }
    public static double[][] translate_z(double scaler){
        double[][] a = new double[3][1];
        a[0][0] = 0;
        a[1][0] = 0;
        a[2][0] = scaler;
        return a;
    }
    
    
    
    
    
}
