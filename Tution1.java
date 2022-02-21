package programs;
import java.awt.*;
import java.awt.event.*;


public class Login {
    private Frame f = new Frame("Log In");
    private Frame f1 = new Frame("Main Window");
    private Frame f2 = new Frame("Reverse");
    private Frame f3 = new Frame("Area of Rectangle");
    private Label name = new Label("Enter Username");
    private Label pass = new Label("Enter Password");
    private TextField nameBox = new TextField();
    private TextField passBox = new TextField();
    private Button submit = new Button("Log in");
    private Button cancel = new Button("Cancel");
    private Label message = new Label();
    
    Login() {
        f.setVisible(true);
        f.setSize(240, 280);
        f.setLayout(null);
        f.setFont(new Font("Ariel", Font.PLAIN, 18));
        message.setFont(new Font("Monospace", Font.PLAIN, 12));
        f.setBackground(new Color(224,255,255));
        passBox.setEchoChar('*');
        
        name.setBounds(45, 40, 150, 35);
        pass.setBounds(45, 110, 150, 35);
        nameBox.setBounds(40, 75, 150, 35);
        passBox.setBounds(40, 145, 150, 35);
        submit.setBounds(45, 200, 65, 30);
        cancel.setBounds(115, 200, 65, 30);
        message.setBounds(50, 245, 200, 30);
        
        f.add(name);
        f.add(pass);
        f.add(nameBox);
        f.add(passBox);
        f.add(cancel);
        f.add(submit);
        f.add(message);
        
        cancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });
        
        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                if(nameBox.getText().equals("bca3") && passBox.getText().equals("12345")) {
                    f.setVisible(false);
                    
                    mainWindow();
                }else {
                    message.setText("Invalid Login Credentials");
                }
            }
        });
        
        
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }
    
    public static void main(String[] args) {
        new Login();

    }
    
    private void mainWindow() {
        
        Button reverse = new Button("Reverse Calculator");
        Button area = new Button("Area of Rectangle");
        Button close = new Button("Close");
        f1.setForeground(new Color(36,160,247));
        f1.setFont(new Font("Lucida", Font.PLAIN, 20));
        
        
        f1.setVisible(true);
        f1.setSize(280, 300);
        f1.setVisible(true);
        GridLayout gl = new GridLayout(3, 1);
        f1.setLayout(gl);
        
        f1.add(area);
        f1.add(reverse);
        f1.add(close);
        
        close.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
//              f.setVisible(true);
//              f1.dispose();
                
                System.exit(0);
            }
        });
        
        reverse.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                f1.setVisible(false);
                reverse();
            }
        });
        
        area.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                f1.setVisible(false);
                area();
            }
        });
        
        
        f1.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    private void reverse(){
        f2.setSize(300, 180);
        f2.setVisible(true);
        f2.setLayout(null);
        f2.setBackground(new Color(176,224,220));
        
        Label l1 = new Label("Enter any number");
        Label l2 = new Label("Reverse is ");
        TextField t1 = new TextField();
        TextField t2 = new TextField();
        Button ok = new Button("OK");
        Button cancel = new Button("Cancel");
        
        t2.setEditable(false);
        
        
        l1.setBounds(20, 35, 100, 30);
        l2.setBounds(20, 70, 100, 30);
        t1.setBounds(160, 35, 100, 30);
        t2.setBounds(160, 70, 100, 30);
        ok.setBounds(70, 115, 60, 30);
        cancel.setBounds(150, 115, 60, 30);
        
        f2.add(l1);
        f2.add(l2);
        f2.add(t1);
        f2.add(t2);
        f2.add(ok);
        f2.add(cancel);
        
        cancel.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                f1.setVisible(true);
                f2.dispose();
            }
        });
        
        
        ok.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder num = new StringBuilder(t1.getText());
                
                for(int i = 0; i < num.length(); i++) {
                    if(!Character.isDigit(num.charAt(i))) {
                        t2.setText("Number is not valid!");
                        return;
                    }
                }
                
                
                String ans = String.valueOf(num.reverse());
                t2.setText(ans);
            }
        });
        
        
        f2.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }
    
    private void area() {
        f3.setSize(300, 200);
        f3.setVisible(true);
        f3.setLayout(null);
        f3.setBackground(new Color(216,191,216));
        
        Label l1 = new Label("Enter length");
        Label l2 = new Label("Enter breadth");
        Label l3 = new Label("Area is");
        TextField t1 = new TextField();
        TextField t2 = new TextField();
        TextField ans = new TextField();
        Button ok = new Button("OK");
        Button cancel = new Button("Cancel");
        
        ans.setEditable(false);
        
        
        l1.setBounds(20, 35, 100, 30);
        l2.setBounds(20, 70, 100, 30);
        l3.setBounds(20, 110, 100,30);
        t1.setBounds(160, 35, 100, 30);
        t2.setBounds(160, 70, 100, 30);
        ans.setBounds(160, 110, 100, 30);
        ok.setBounds(70, 155, 60, 30);
        cancel.setBounds(150, 155, 60, 30);
        
        f3.add(l1);
        f3.add(l2);
        f3.add(l3);
        f3.add(t1);
        f3.add(t2);
        f3.add(ans);
        f3.add(ok);
        f3.add(cancel);
        
        cancel.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                f1.setVisible(true);
                f3.dispose();
            }
        });
        
        ok.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                float len = Float.parseFloat(t1.getText());
                float wid = Float.parseFloat(t2.getText());
                
                ans.setText(String.valueOf(len*wid));
            }
        });
        
        f3.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }
}
