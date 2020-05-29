package Engine;

import java.awt.Graphics;

public class VectorPart implements Part {

    public Vector v;
    
    public VectorPart(Point a,Point b){
        v = new Vector();
        v.a = a;
        v.b = b;
    }
    
    public VectorPart(){
        v = new Vector();
        //define points later    
        //untill points have been defined vectorpart cannot be used
    }
    
    @Override
    public void draw(Graphics g, Point o) {
        Vector a = v;
        a.a.x +=o.x; a.a.y +=o.y; a.a.z +=o.z;
        a.b.x +=o.x; a.b.y +=o.y; a.b.z +=o.z;
        Vector.draw(g, a);
    }

    @Override
    public void translate(double[][] a) {
        v = Vector.vTranslate(a, v);        
    }

    @Override
    public void transformation(double[][] a) {
        v = Vector.vTransform(a, v);
    }
}