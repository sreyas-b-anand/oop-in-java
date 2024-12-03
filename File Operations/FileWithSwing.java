import java.io.*;
import java.util.*;
import javax.swing.*;

import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.*;

class FileOperations {

    static String readFile() throws Exception {
        File f = new File("sample.txt");
        FileReader fr = new FileReader("sample.txt");
        BufferedReader br = new BufferedReader(fr);
        String line = null;
        String readInput = null;
        while ((readInput = br.readLine()) != null) {
            line = readInput; // return a string array for better usage
        }

        fr.close();
        br.close();
        return line;
    }

    static void writeFile(String l) throws Exception {
        File f = new File("sample.txt");
        FileWriter fw = new FileWriter("sample.txt", true);
        fw.write(l);
        

        fw.close();
        

    }
}

class FileWithSwing implements ActionListener  {
    JFrame jfr;
    JTextField jtf1;
    JTextArea jta;
    JButton jbw;
    JButton jbr;
    JLabel jl;
    JPanel jp;
    String se;
    FileWithSwing() {
        jfr = new JFrame("File Operations");
        jta = new JTextArea(4, 1);
        // panel
        jtf1 = new JTextField(4);// write
        jl = new JLabel("Write something");
        jbw = new JButton("write");//
        jbr = new JButton("read");//
        jp = new JPanel(new GridLayout(3, 1, 5, 5));
        jfr.setSize(600, 600);
        jp.add(jl);
        jp.add(jtf1);
        jp.add(jbw);

        jp.setSize(100, 200);
        jfr.add(jp);
        jfr.add(jta);
        jfr.add(jbr);
        jfr.setLayout(new GridLayout(3, 1, 30, 10));
        jfr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfr.setVisible(true);
        jbr.addActionListener(this);
        jbw.addActionListener(this);

    }
    public void actionPerformed(ActionEvent ae ){
        String buttonCommand = ae.getActionCommand();
        String text = jtf1.getText();
        try {
            if (buttonCommand.equalsIgnoreCase("write")) {
                // then
                FileOperations.writeFile(text);
                jl.setText("Written successfully");
                jtf1.setText("");
            } else {
               String d = FileOperations.readFile();
              // System.out.println(d);
                jl.setText("Read file");
                jta.setText(d.strip());
            }

        } catch (Exception e) {
            jl.setText("Error occured");
        }

        
    }
   

    public static void main(String args[]) {
        new FileWithSwing();
    }
}
