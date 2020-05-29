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
public class CubePart implements Part {

    public Cube c;
    
    public CubePart(){
        c = new Cube();
    }
    
    
    
    @Override
    public void draw(Graphics g, Point o) {
        Cube.draw(g, Cube.AdjustForOrigin(c, o));
    }

    @Override
    public void translate(double[][] a) {
      c = Cube.cTranslate(a, c);
    }

    @Override
    public void transformation(double[][] a) {
        c = Cube.cTranform(a, c);
    }
    
}
