import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Introduction implements ActionListener {
    JFrame f;
    JButton StartQ, back;
    JPanel panel;
    JLabel name, reg_no, branch, iHead, intro;
    Introduction(){
        f = new JFrame("Introduction");
        back = new JButton("Back");
        back.setBounds(600, 30, 80, 20);

        name = new JLabel("Name: "+LoginDemo.userName);
        name.setBounds(30, 20, 200, 30);
        reg_no = new JLabel("Reg. No.: "+LoginDemo.roll);
        reg_no.setBounds(30, 50, 200, 30);
        branch = new JLabel("Branch :"+LoginDemo.branch);
        branch.setBounds(30, 80, 200, 30);

        panel = new JPanel();
        panel.setBounds(30, 110, 600,300);
        panel.setBackground(Color.gray);

        iHead = new JLabel("Introduction");
        iHead.setBounds(300, 120, 150, 30);
        panel.add(iHead);
        intro = new JLabel("");
        StartQ = new JButton("Start Quiz");
        StartQ.setBounds(300, 430, 100, 30);
//        panel.add(StartQ);
        StartQ.addActionListener(this);
        back.addActionListener(this);
        f.add(back); f.add(name); f.add(reg_no); f.add(branch);  f.add(panel); f.add(StartQ);

        f.setSize(700, 500);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setLayout(null);
        f.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         if(e.getSource()==StartQ){
             f.setVisible(false);
             Quiz.main(null);
             new Question();
         }
         if(e.getSource()==back){
             f.setVisible(false);
             new LoginDemo();
         }
    }

    public static void main(String[] args) {
        new Introduction();
    }
}
