import java.awt.Color;
import java.lang.reflect.*;
import java.awt.event.*;

import javax.swing.*;

class SwingProgram1 implements  ItemListener{
    JFrame frame ;
    JRadioButton jbr; 
    SwingProgram1(){
        jbr = new JRadioButton();
        frame = new JFrame();
        frame.add(jbr);
        frame.setVisible(true);
        frame.setSize(200 , 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jbr.addItemListener(this);

    }
    public void itemStateChanged(ItemEvent e){
       if(e.getStateChange() == ItemEvent.SELECTED){
        frame.getContentPane().setBackground(Color.BLUE);
       }
       else{
        frame.getContentPane().setBackground(Color.red);
       }
    }
    public static void main(String args[]){
        new SwingProgram1();
        Class<?> cl = StringBuilder.class;
        Method[]  m = cl.getMethods();
        for(Method m1 : m){
            System.out.println(m1);
        }
    }
}
