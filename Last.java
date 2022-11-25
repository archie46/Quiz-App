import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Last implements ActionListener {
    JFrame f;
    JLabel line1, line2, line3,line4,line5;
    JButton Yes, No;
    JOptionPane ifyes;

    Last(){
        int result = Quiz.eval();
        int a = Quiz.a();
        int na = Quiz.na();
        int no = 5-result;
        int o = result;
        f = new JFrame("Final Submission");
        line1 = new JLabel("Number of Question Answered: " +a );
        line2 = new JLabel("Number of Question Not Answered: "+na);
        line3 = new JLabel("Your Result : "+result);
        line4 = new JLabel("InCorrect : "+no);
        line5 = new JLabel("Correct  : "+o);

        line1.setBounds(30, 50, 300, 30);
        line2.setBounds(30, 90, 300, 30);
        line4.setBounds(30, 130, 300, 30);
        line5.setBounds(30, 170, 300, 30);
        line3.setBounds(100, 300, 300, 30);
        Yes = new JButton("Re Attempt");
        No = new JButton("NO");

        Yes.setBounds(200, 330, 180, 20);
        No.setBounds(400, 330, 180, 20);

        Yes.addActionListener(this);

        f.add(line1); f.add(line2); f.add(line3);f.add(line4);f.add(line5); f.add(Yes); f.add(No);

        f.setSize(700, 500);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setLayout(null);
        f.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == Yes){
            ifyes = new JOptionPane();
            JOptionPane.showMessageDialog(ifyes, "Submitted Successfully!");
            f.setVisible(false);
            new LoginDemo();
        }
        if(e.getSource() == No){
            f.setVisible(false);
            f.dispose();
        }
    }

    public static void main(String[] args) {
        new Last();
    }
}
