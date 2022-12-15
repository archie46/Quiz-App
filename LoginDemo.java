
import java.awt.event.*;
import javax.swing.*;
class LoginDemo extends JFrame implements ActionListener {
    static String password;
    static String userName;
    static  String roll ="20010409";
    static  String branch ="CSE (AI & ML)";

   // JPanel panel;
    JLabel user_label, password_label;
    JTextField userName_text;
    JPasswordField password_text;
    JButton submit;
    LoginDemo() {
        // Username Label
        user_label = new JLabel();
        user_label.setText("User Name :");
        user_label.setBounds(50,50,100,30);
        userName_text = new JTextField();
        userName_text.setBounds(150,50,200,30);

        // Password Label
        password_label = new JLabel();
        password_label.setText("Password :");
        password_label.setBounds(50,150,100,30);
        password_text = new JPasswordField();
        password_text.setBounds(150,150,200,30);
        // Submit
        submit = new JButton("SUBMIT");
      //  panel = new JPanel(new GridLayout(3, 1));
        add(user_label);
        add(userName_text);
        add(password_label);
        add(password_text);

        submit.setBounds(245,400,150,30);
        add(submit);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Adding the listeners to components..
        submit.addActionListener(this);
       // add(panel, BorderLayout.CENTER);
        setTitle("Please Login Here !");
        setSize(700,500);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public static void main(String[] args) {

        new LoginDemo();
    }

    public void actionPerformed(ActionEvent ae) {
        userName = userName_text.getText();
        password = new String(password_text.getPassword());
        if (userName.trim().equals("Abhinav") && password.trim().equals("1234")) {
            this.setVisible(false);
            new Introduction();
         //   message.setText(" Hello " + userName + "");
        } else {
            JOptionPane message = new JOptionPane();
            JOptionPane.showMessageDialog(message,"Invalid User");

        }
    }
}