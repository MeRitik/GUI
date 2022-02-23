package programs;
import java.awt.*;
import java.awt.event.*;
//import java.io.File;
//import java.io.IOException;
import java.util.Stack;

public class Calculator {
    Frame f = new Frame("Calculator");
    Panel p = new Panel();
    Label box = new Label();

    Button b = new Button("=");
    Button b0 = new Button("0");
    Button b1 = new Button("1");
    Button b2 = new Button("2");
    Button b3 = new Button("3");
    Button b4 = new Button("4");
    Button b5 = new Button("5");
    Button b6 = new Button("6");
    Button b7 = new Button("7");
    Button b8 = new Button("8");
    Button b9 = new Button("9");
    Button s = new Button("\u221A");
    Button add = new Button("+");
    Button sub = new Button("-");
    Button div = new Button("\u00F7");
    Button mul = new Button("*");
    Button bksp = new Button("< -");
    Button clr = new Button("C");
    Button b00 = new Button("00");
    Button off = new Button("OFF");
    
    Font myFont;

    public Calculator() {
        f.setLayout(null);
        f.setSize(460, 440);
        f.setVisible(true);
        
//        try {
//        	myFont = Font.createFont(Font.TRUETYPE_FONT, new File("digital.ttf")).deriveFont(36f);
//        	GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
//        	ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("digital.ttf")));
//        }catch(IOException | FontFormatException ioe) {
//        	
//        	// for checking
//        	System.out.println("Not found");
//        }



        // Add Buttons
        p.setBounds(0, 120, 455, 320);
        p.setLayout(null);

        b0.setBounds(15, 190, 100, 50);
        b9.setBounds(15, 10, 100, 50);
        b6.setBounds(15, 70, 100, 50);
        b3.setBounds(15, 130, 100, 50);
        b8.setBounds(125, 10, 100, 50);
        b7.setBounds(235, 10, 100, 50);
        b2.setBounds(125, 130, 100, 50);
        b5.setBounds(125, 70, 100, 50);
        b4.setBounds(235, 70, 100, 50);
        b1.setBounds(235, 130, 100, 50);
        s.setBounds(235, 190, 100, 50);
        b00.setBounds(125, 190, 100, 50);
        bksp.setBounds(345, 10, 100, 50);
        div.setBounds(345, 70, 100, 50);
        mul.setBounds(345, 130, 100, 50);
        sub.setBounds(345, 190, 100, 50);


        add.setBounds(345, 250, 100, 50);
        clr.setBounds(125, 250, 100, 50);
        b.setBounds(235, 250, 100, 50);
        off.setBounds(15, 250, 100, 50);

        p.add(b9);
        p.add(b8);
        p.add(b7);
        p.add(b6);
        p.add(b5);
        p.add(b4);
        p.add(b3);
        p.add(b2);
        p.add(b1);
        p.add(b0);
        p.add(b);
        p.add(s);
        p.add(add);
        p.add(sub);
        p.add(mul);
        p.add(div);
        p.add(bksp);
        p.add(clr);
        p.add(b00);
        p.add(off);


        p.setBackground(Color.DARK_GRAY);
        p.setForeground(Color.WHITE);
        
        off.setBackground(new Color(220, 0, 0));
        clr.setBackground(new Color(220, 0, 0));
        b.setFont(new Font("Lucida", Font.BOLD, 40));
        
        add.setBackground(new Color(151, 151, 151));
        div.setBackground(new Color(151, 151, 151));
        mul.setBackground(new Color(151, 151, 151));
        sub.setBackground(new Color(151, 151, 151));
        bksp.setBackground(new Color(151, 151, 151));
        s.setBackground(new Color(151, 151, 151));
        b.setBackground(new Color(170, 200, 225));
        
        b0.setBackground(new Color(192, 192, 192));
        b1.setBackground(new Color(192, 192, 192));
        b2.setBackground(new Color(192, 192, 192));
        b3.setBackground(new Color(192, 192, 192));
        b4.setBackground(new Color(192, 192, 192));
        b5.setBackground(new Color(192, 192, 192));
        b6.setBackground(new Color(192, 192, 192));
        b7.setBackground(new Color(192, 192, 192));
        b8.setBackground(new Color(192, 192, 192));
        b9.setBackground(new Color(192, 192, 192));
        b00.setBackground(new Color(192, 192, 192));
        
        box.setBounds(0, 40, 455, 80);
        box.setText("");
        box.setBackground(new Color(223, 223, 223));
        box.setAlignment(Label.RIGHT);
        box.setFont(new Font("Sans Serif", Font.BOLD, 32));
        p.setFont(new Font("Times new Roman", Font.PLAIN, 28));
        f.add(box);
        f.add(p);
        
        



        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

        off.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });


        b9.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                box.setText(box.getText() + "9");
            }
        });

        b8.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                box.setText(box.getText() + "8");
            }
        });

        b7.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                box.setText(box.getText() + "7");
            }
        });

        b6.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                box.setText(box.getText() + "6");
            }
        });

        b5.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                box.setText(box.getText() + "5");
            }
        });

        b4.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                box.setText(box.getText() + "4");
            }
        });

        b3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                box.setText(box.getText() + "3");
            }
        });

        b2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                box.setText(box.getText() + "2");
            }
        });


        b1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                box.setText(box.getText() + "1");
            }
        });

        b00.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (box.getText().equals(""))
                    box.setText("");
                else
                    box.setText(box.getText() + "00");
            }
        });

        b0.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (box.getText().equals(""))
                    box.setText("");
                else
                    box.setText(box.getText() + "0");
            }
        });



        clr.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                box.setText("");
            }
        });


        bksp.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (box.getText().equals(""))
                    box.setText("");
                else
                    box.setText(box.getText().substring(0, box.getText().length() - 1));
            }
        });
        
        b.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	String exp = box.getText();
//            	int len = exp.length();
            	
            	if(isLastOperator(exp)) {
            		box.setText("Invalid Expression!");
            		return;
            	}
                box.setText(String.valueOf(evaluate(box.getText())));
            }
        });
        
        
        sub.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String txt = box.getText();
                int len = txt.length();
                
                if(len == 0)
                	return;
                
                if(isLastOperator(txt))
                	box.setText(txt.substring(0, len-1) + "-");
                else
                	box.setText(txt + "-");
            }
        });
        
        mul.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String txt = box.getText();
                int len = txt.length();
                
                if(len == 0)
                	return;
                
                if(isLastOperator(txt))
                	box.setText(txt.substring(0, len-1) + "*");
                else
                	box.setText(txt + "*");
            }
        });
        
        
        add.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String txt = box.getText();
                int len = txt.length();
                
                if(len == 0)
                	return;
                
                if(isLastOperator(txt))
                	box.setText(txt.substring(0, len-1) + "+");
                else
                	box.setText(txt + "+");
            }
        });
        
        div.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String txt = box.getText();
                int len = txt.length();
                
                if(len == 0)
                	return;
                
                if(isLastOperator(txt))
                	box.setText(txt.substring(0, len-1) + "/");
                else
                	box.setText(txt + "/");
            }
        });
        
        s.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	 String txt = box.getText();
                 int len = txt.length();
                 
                 if(len == 0) {
                 	box.setText("\u221A");
                 	return;
                 }
                 
                 if(len == 1 && isLastOperator(txt)) {
                	 box.setText("\u221A");
                	 return;
                 }
                 
                 if(txt.charAt(len-1) == '\u221A') {
                	 return;
                 }
                 else
                	 box.setText(txt + "\u221A");
            }
        });
        


    }

    public static void main(String[] args) {
        new Calculator();

    }
    
    private boolean isLastOperator(String exp){
    	int len = exp.length();
    	
    	if(len == 0)
    		return false;
    	
    	char ch = exp.charAt(len-1);
    	if(ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '\u221A')
    		return true;
    	else
    		return false;
    }


    public long evaluate(String exp) {
    	if(exp.equals(""))
    		return 0;
    	
    	String expression = sqrtHelper(exp);
    	
        char[] tokens = expression.toCharArray();

        Stack<Long> values = new Stack<Long>();

        Stack<Character> ops = new Stack<Character>();

        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i] == ' ')
                continue;
            
//            System.out.println(tokens[i]);

            if (tokens[i] >= '0' && tokens[i] <= '9') {
                StringBuffer sbuf = new StringBuffer();

                while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9')
                    sbuf.append(tokens[i++]);
                	values.push(Long.parseLong(sbuf.toString()));
                	i--;
            }

            else if (tokens[i] == '(')
                ops.push(tokens[i]);


            else if (tokens[i] == ')') {
                while (ops.peek() != '(')
                    values.push(applyOp(ops.pop(),
                                        values.pop(),
                                        values.pop()));
                ops.pop();
            }


            else if (tokens[i] == '+' ||
                     tokens[i] == '-' ||
                     tokens[i] == '*' ||
                     tokens[i] == '/') {
                while (!ops.empty() && hasPrecedence(tokens[i], ops.peek()))

                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));

                ops.push(tokens[i]);
            }
        }

//        System.out.print(values);
//        System.out.println(ops);
        while (!ops.empty()) {
            values.push(applyOp(ops.pop(), values.pop(), values.pop()));
        }
        return values.pop();
    }


    public static boolean hasPrecedence(
        char op1, char op2) {
        if (op2 == '(' || op2 == ')')
            return false;
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
            return false;
        else
            return true;
    }

    public static long applyOp(char op, long b, long a) {
        switch (op) {
        case '+':
            return a + b;
        case '-':
            return a - b;
        case '*':
            return a * b;
        case '/':
            if (b == 0)
                throw new UnsupportedOperationException("Cannot divide by zero");
            return a / b;
        }
        return 0;
    }
    
    private String sqrtHelper(String exp){
    	char tokens[] = exp.toCharArray();
    	StringBuffer res = new StringBuffer();
    	
    	for(int i = 0; i < tokens.length; i++) {
    		if(tokens[i] == '\u221A') {
            	StringBuffer obj = new StringBuffer();
            	i++;
            	long x;
            	
            	while(i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9'){
            		obj.append(tokens[i++]);
            	}
            	
            	double d = Double.parseDouble(obj.toString());
            	x = (long)Math.sqrt(d);
            	if(isLastOperator(res.toString()))
            		res.append(String.valueOf(x));
            	else
            		res.append("*" + String.valueOf(x));

            	i--;
            }
    		else {
    			res.append(exp.charAt(i));
    		}
    	}
    	
//    	System.out.println(res);
    	if(res.charAt(0)=='*')
    		res.deleteCharAt(0);
    	
    	return res.toString();
    }

}
