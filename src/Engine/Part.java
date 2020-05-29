package Engine;

import java.awt.Graphics;

/**
 * @author Nicholas Elek
 */
public interface Part {
    public void draw(Graphics g, Point o);
    public void translate(double[][] a);
    public void transformation(double[][] a);
}