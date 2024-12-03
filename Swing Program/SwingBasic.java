import javax.swing.*;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.*;

class SwingBasic implements ActionListener{
    static JFrame jfr;
    static JLabel jlb;
    JButton jb1;
    JButton jb2;
    SwingBasic(){
        jfr = new JFrame("Swing basic");
        jlb = new JLabel("Click a button");
        jb1 = new JButton("Hello");
        jb2 = new JButton("Hi");
        jfr.add(jlb);
        jfr.add(jb1);
        jfr.add(jb2);
        jfr.setVisible(true);
        jfr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfr.setSize(200 , 200);
        jfr.setBackground(Color.LIGHT_GRAY);
        jfr.setCursor(Cursor.HAND_CURSOR);
        jfr.setLayout(new GridLayout(3, 0));
        
        
        jb1.addActionListener(this);
        
        jb2.addActionListener(this);
    }
    
        public void actionPerformed(ActionEvent ae){
            String s = ae.getActionCommand();
            if(s.equalsIgnoreCase("Hello")){
                jlb.setText("Hello pressed");
            }
            String s1 = ae.getActionCommand();
            if(s1.equalsIgnoreCase("Hi")){
                jlb.setText("Hi pressed");
            }

    
    }
    public static void main(String args[]){
       SwingBasic s =  new SwingBasic();
    }

}