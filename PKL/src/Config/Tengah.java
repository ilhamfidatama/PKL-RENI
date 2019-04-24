/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Config;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 *
 * @author windows 7
 */
public class Tengah {
    public Tengah(JFrame form) {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (dim.width - form.getSize().width)/2;
        int y = (dim.height - form.getSize().height)/2;
        form.setLocation(x,y);
    }
}
