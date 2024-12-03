import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

class Palindrome {
    static boolean isPalindrome(StringBuilder str) {
        StringBuilder rev = new StringBuilder(str).reverse();
        return str.toString().equals(rev.toString());
    }
}

class FileOperations {
    static void writeFile(String ss) throws Exception {
        File f = new File("sample.txt");
        FileWriter fw = new FileWriter(f);
        fw.write(ss);
        fw.close();
    }

    static StringBuilder readFile() throws Exception {
        File f = new File("sample.txt");
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        String l = br.readLine();
        br.close();
        fr.close();
        return l != null ? new StringBuilder(l) : new StringBuilder();
    }
}

class SwingDemo implements ActionListener {
    JFrame jfr;
    JButton jb1;
    JButton jb2;
    JTextField jt;
    JLabel jl;

    SwingDemo() {
        jfr = new JFrame("Swing Program");
        jb1 = new JButton("Write");
        jb2 = new JButton("Is a Palindrome");
        jt = new JTextField(15);
        jl = new JLabel();

        jfr.setVisible(true);
        jfr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfr.setSize(400, 300);
        jfr.setLayout(new FlowLayout(FlowLayout.TRAILING));
        jfr.getContentPane().setBackground(Color.BLUE);
        jl.setForeground(Color.RED);

        jfr.add(jt);
        jfr.add(jb1);
        jfr.add(jb2);
        jfr.add(jl);

        jb1.addActionListener(this);
        jb2.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        String d = e.getActionCommand();
        if (d.equalsIgnoreCase("write")) {
            try {
                String ssd = jt.getText();
                FileOperations.writeFile(ssd);
                jt.setText("");
                jl.setText("Text written to file.");
            } catch (Exception ex) {
                System.out.println(ex);
            }
        } else if (d.equalsIgnoreCase("is a Palindrome")) {
            try {
                StringBuilder c = FileOperations.readFile();
                if (Palindrome.isPalindrome(c)) {
                    jl.setText("The string written to the file is a palindrome.");
                } else {
                    jl.setText("The string from the file is not a palindrome.");
                }
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
    }

    public static void main(String args[]) {
        new SwingDemo();
    }
}
