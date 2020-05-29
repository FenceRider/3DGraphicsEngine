/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Engine.ScreenManager;
import Engine.TransformationMatrix;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

public class MainGUI extends JFrame implements KeyListener {
    
    Panel p;
    
    public MainGUI(){
        super("3D Graphics Test");
        
        ScreenManager.set_x_Size(1920); //set size
       ScreenManager.set_y_Size(1080);
       this.setSize(1920,1080);
       
       p = new Panel(); //add panel
       add(p);
       
       
       p.addKeyListener(this);
        p.setFocusable(true);
        p.requestFocus();
        
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
         int ei = e.getKeyCode();
        
         double move = 0.5;
         
        switch(ei){
            case 39:
                
                p.Global_Transform(-1, TransformationMatrix.xz);
                break;
            case 37:
               
                p.Global_Transform(1, TransformationMatrix.xz);
               break;
        
            case 38:
                //up 
               
                p.Global_Transform(-1, TransformationMatrix.yz);
                break;
            
            case 40:
                //down
               
                p.Global_Transform(1, TransformationMatrix.yz);
                break;
            case 90:
                //right rot
                
                p.Global_Transform(1, TransformationMatrix.xy);
                break;
                
            case 88:
                //left rot
               
                p.Global_Transform(-1, TransformationMatrix.xy);
                break;
                
                
                
        
            case 32:
                //space up
               // p.ChangeCube(Math.toRadians(10),TransformationMatrix.Ty);
                p.Global_Translate(move, TransformationMatrix.Ty);
                break;
            case 65:
                //a
                //p.ChangeCube(Math.toRadians(10),TransformationMatrix.Tx);
                p.Global_Translate(move, TransformationMatrix.Tx);
                break;
            case 16:
                //shift down
               // p.ChangeCube(Math.toRadians(-10),TransformationMatrix.Ty);
                p.Global_Translate(-move, TransformationMatrix.Ty);
                break;
            case 68:
                //d
                //p.ChangeCube(Math.toRadians(-10),TransformationMatrix.Tx);
                p.Global_Translate(-move, TransformationMatrix.Tx);
                break;
            case 87:
               // p.ChangeCube(Math.toRadians(-10),TransformationMatrix.Tz);
                p.Global_Translate(-move, TransformationMatrix.Tz);
                break;
            case 83:
                //p.ChangeCube(Math.toRadians(10),TransformationMatrix.Tz);
                p.Global_Translate(move, TransformationMatrix.Tz);
                break;
                
                
        
        }
        
        
        p.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
    public static void main(String[] arg){
        MainGUI mg = new MainGUI();
    }
}
