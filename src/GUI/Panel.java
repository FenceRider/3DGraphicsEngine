/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Engine.CameraHolder;
import Engine.Map;
import Engine.ScreenManager;
import Engine.TransformationMatrix;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Panel extends JPanel {

    Map m = new Map();

    public Panel() {
        super();
        //CameraHolder.CAM = new Camera();
        CameraHolder.CAM.maxx = ScreenManager.x_centre();
        CameraHolder.CAM.minx = 0 - ScreenManager.x_centre();
        CameraHolder.CAM.maxy = ScreenManager.y_centre();
        CameraHolder.CAM.miny = 0 - ScreenManager.y_centre();
        CameraHolder.CAM.minz = 0;
        CameraHolder.CAM.maxz = 1000;
        ScreenManager.zoom = 1500;

    }

    @Override
    public void paintComponent(Graphics g) {
        g.clearRect(0, 0, 1920, 1080);
        //draw shape here
        m.drawMap(g);
    }

    public void Global_Transform(double theta, int type) {
        double a[][] = null;
        switch (type) {
            case TransformationMatrix.xy:
                a= TransformationMatrix.rotate_xy(Math.toRadians(theta));
                break;
            case TransformationMatrix.xz:
                a=TransformationMatrix.rotate_xz(Math.toRadians(theta));
                break;
            case TransformationMatrix.yz:
                a=TransformationMatrix.rotate_yz(Math.toRadians(theta));
                break;
        }

        m.Global_Transform(a);
        
        
    }

    public void Global_Translate(double scaler, int type) {
        double a[][] = null;
        switch (type) {
            case TransformationMatrix.Tx:
                a = TransformationMatrix.translate_x(scaler);
                break;
            case TransformationMatrix.Ty:
                a = TransformationMatrix.translate_y(scaler);
                break;
            case TransformationMatrix.Tz:
                a = TransformationMatrix.translate_z(scaler);
                break;

        }
        m.Global_Translate(a);

    }

}
