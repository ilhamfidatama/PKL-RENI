/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JTextField;

/**
 *
 * @author windows 7
 */
public class textFieldTransparan extends JTextField{
        private Color color;
    
    public textFieldTransparan(){
        setOpaque(false);
        color = new Color (0, 0, 0, 100);
    }
    @Override
    public void setBackground(Color background){
        super.setBackground(background);
        
        color =new Color (0, 0, 0, 100);
        repaint();
    }
    
    @Override
    protected void paintComponent(Graphics graphics){
        super.paintComponent(graphics);
        
        Graphics2D graphics2D = (Graphics2D) graphics.create();
        graphics2D.setColor(color);
        graphics2D.fillRect(0, 0, getWidth(), getHeight());
        graphics2D.dispose();
    }
}
