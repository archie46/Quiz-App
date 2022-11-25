import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Question implements ActionListener {
    JFrame j;
    JLabel title;
    JLabel ques;
    JLabel name = new JLabel(LoginDemo.userName);
    JLabel roll = new JLabel("20010409");
    JLabel branch = new JLabel("CSE( AI & ML)");

    JRadioButton o1;
    JRadioButton o2;
    JRadioButton o3;
    JRadioButton o4;
    ButtonGroup qg;
    JButton save;
    JButton prev;
    JButton clear;
    JOptionPane o = new JOptionPane();
    static  JButton[] arr = new JButton[5];

    int ind;
    static void check() {
        for (int i = 0; i < 5; i++) {
            if (Quiz.val.get(i) != -1) {
                arr[i].setBackground(Color.GREEN);
            }
            if(Quiz.val.get(i) == -1){
                arr[i].setBackground(Color.WHITE);
            }
        }
    }
    void end(){
        if(this.ind==5){
            int reply = JOptionPane.showConfirmDialog(o,"Are You Sure ?");
            if(reply == JOptionPane.YES_OPTION){
                ind--;
                j.setVisible(false);
                new Last();
            }
            if(reply == JOptionPane.NO_OPTION || reply == JOptionPane.CANCEL_OPTION){
                ind--;
            }

        }

    }
    Question(){
        ind =0;
        for(int i =0;i<5;i++){
            int c = i+1;
            String q = "Q" + c;
            arr[i] = new JButton(q);
       //     j.add(arr[i]);
        }
        j = new JFrame("JAVA ONLINE QUIZ");
        title = new JLabel();
        ques = new JLabel();
        ques = new JLabel();
        qg = new ButtonGroup();
        o1 = new JRadioButton(Quiz.quiz.get(0).op1);
        o2 = new JRadioButton(Quiz.quiz.get(0).op2);
        o3 = new JRadioButton(Quiz.quiz.get(0).op3);
        o4 = new JRadioButton(Quiz.quiz.get(0).op4);
        save = new JButton("Save & Next");
        prev = new JButton("Previous");
        clear = new JButton("Clear Response");
        ques.setText(Quiz.quiz.get(0).Qu);
        title.setText("Question "+Quiz.quiz.get(0).index);
        j.add(title);
        j.add(ques);
        j.add(o1);
        j.add(o2);
        j.add(o3);
        j.add(o4);
        j.add(arr[0]);
        j.add(arr[1]);
        j.add(arr[2]);
        j.add(arr[3]);
        j.add(arr[4]);
        j.add(save);
        j.add(prev);
        j.add(clear);
        j.add(name);
        j.add(roll);
        j.add(branch);
        qg.add(o1);
        qg.add(o2);
        qg.add(o3);
        qg.add(o4);
        if(Quiz.val.get(Quiz.quiz.get(0).index-1)==1)
            o1.setSelected(true);
        if(Quiz.val.get(Quiz.quiz.get(0).index-1)==2)
            o2.setSelected(true);
        if(Quiz.val.get(Quiz.quiz.get(0).index-1)==3)
            o3.setSelected(true);
        if(Quiz.val.get(Quiz.quiz.get(0).index-1)==4)
            o4.setSelected(true);

        save.addActionListener(this);
        clear.addActionListener(this);
        prev.addActionListener(this);
        o1.addActionListener(this);
        o2.addActionListener(this);
        o3.addActionListener(this);
        o4.addActionListener(this);
        ques.setBounds(250,100,500,20);
        title.setBounds(250,0,200,20);
        o1.setBounds(250,150,200,20);
        o2.setBounds(250,200,200,20);
        o3.setBounds(250,250,200,20);
        o4.setBounds(250,300,200,20);
        save.setBounds(245,400,150,30);
        clear.setBounds(405,400,150,30);
        prev.setBounds(565,400,150,30);
        arr[0].setBounds(10,100,50,30);
        arr[1].setBounds(10,160,50,30);
        arr[2].setBounds(10,220,50,30);
        arr[3].setBounds(10,280,50,30);
        arr[4].setBounds(10,340,50,30);
        name.setBounds(900,100,200,20);
        roll.setBounds(900,150,200,20);
        branch.setBounds(900,200,200,20);
        j.setLayout(null);
        j.setSize(1000,500);
        j.setLocationRelativeTo(null);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==clear){
            Quiz.val.set(ind,-1);
            qg.clearSelection();
            check();

         //   System.out.println(Quiz.val);
        }
        if(e.getSource()==save){
            check();
            ind++;
            end();
            ques.setText(Quiz.quiz.get(ind).Qu);
            title.setText("Question "+Quiz.quiz.get(ind).index);
            o1.setText(Quiz.quiz.get(ind).op1);
            o2.setText(Quiz.quiz.get(ind).op2);
            o3.setText(Quiz.quiz.get(ind).op3);
            o4.setText(Quiz.quiz.get(ind).op4);
            if(Quiz.val.get(Quiz.quiz.get(ind).index-1)==1)
                o1.setSelected(true);
            if(Quiz.val.get(Quiz.quiz.get(ind).index-1)==2)
                o2.setSelected(true);
            if(Quiz.val.get(Quiz.quiz.get(ind).index-1)==3)
                o3.setSelected(true);
            if(Quiz.val.get(Quiz.quiz.get(ind).index-1)==4)
                o4.setSelected(true);
            if(Quiz.val.get(Quiz.quiz.get(ind).index-1)==-1)
                qg.clearSelection();
        }
        if(o1.isSelected()){
            Quiz.val.set(ind,1);
        }
        else if(o2.isSelected()){
            Quiz.val.set(ind,2);
        }
        else if(o3.isSelected()){
            Quiz.val.set(ind,3);
        }
        else if(o4.isSelected()){
            Quiz.val.set(ind,4);
        }
        else
            Quiz.val.set(ind,-1);
       // System.out.println(Quiz.val);
        if(e.getSource()==prev){
            check();
            ind--;
            ques.setText(Quiz.quiz.get(ind).Qu);
            title.setText("Question "+Quiz.quiz.get(ind).index);
            o1.setText(Quiz.quiz.get(ind).op1);
            o2.setText(Quiz.quiz.get(ind).op2);
            o3.setText(Quiz.quiz.get(ind).op3);
            o4.setText(Quiz.quiz.get(ind).op4);
            if(Quiz.val.get(Quiz.quiz.get(ind).index-1)==1)
                o1.setSelected(true);
            if(Quiz.val.get(Quiz.quiz.get(ind).index-1)==2)
                o2.setSelected(true);
            if(Quiz.val.get(Quiz.quiz.get(ind).index-1)==3)
                o3.setSelected(true);
            if(Quiz.val.get(Quiz.quiz.get(ind).index-1)==4)
                o4.setSelected(true);
            if(Quiz.val.get(Quiz.quiz.get(ind).index-1)==-1)
                qg.clearSelection();
        }
    }
    public static void main(String[] args) {
    //    new Question();
    }
}
