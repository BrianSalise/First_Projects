
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class CalculatorApp implements ActionListener {
	
	JFrame frame;
	JPanel panel;
	JTextField textfield;
	JButton[] numberButtons = new JButton[10];
	JButton[] functionButtons = new JButton[8];
	JButton add,sub,divide,mult,decimal,equals,del,alc;
	Font myFont = new Font("Ink Free",Font.BOLD,30);
	double num1 = 0,num2 = 0,result;
	char operator;
	
	CalculatorApp(){
		// Frame and textfields
		frame_textfield();
	
		// Function buttons
		functions();
	
		//Panel
		panels();
		
		frame.add(panel);
		frame.add(textfield);
		frame.add(del);
		frame.add(alc);
		frame.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		CalculatorApp calc = new CalculatorApp();	
	}
	
	public void functions() {
		add = new JButton("+");
		sub = new JButton("-");
		divide = new JButton("/");
		mult = new JButton("*");
		decimal = new JButton(".");
		equals = new JButton("=");
		del = new JButton("Clear");
		alc = new JButton("AC");
		
		functionButtons[0] = add;
		functionButtons[1] = sub;
		functionButtons[2] = divide;
		functionButtons[3] = mult;
		functionButtons[4] = decimal;
		functionButtons[5] = equals;
		functionButtons[6] = del;
		functionButtons[7] = alc;
		
		for(int i = 0;i < 8;i++) {
			functionButtons[i].addActionListener(this);
			functionButtons[i].setFont(myFont);
			functionButtons[i].setFocusable(false);
		}
		for(int i = 0;i < 10;i++) {
			numberButtons[i] = new JButton(String.valueOf(i));
			numberButtons[i].addActionListener(this);
			numberButtons[i].setFont(myFont);
			numberButtons[i].setFocusable(false);
			
		}
		del.setBounds(50, 430, 145, 50);
        alc.setBounds(205,430, 145, 50);
		
	}
	public void frame_textfield() {
		frame = new JFrame("CALCULATOR");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400,600);
		frame.setLayout(null);
		//Text Field
		textfield = new JTextField();
		textfield.setBounds(50, 35, 300, 50);
		textfield.setEditable(false);
		textfield.setFont(myFont);
	}
	public void panels() {
		panel = new JPanel();
		panel.setBounds(50,100,300,300);
		panel.setLayout(new GridLayout(4,4,10,10));
		
		panel.add(numberButtons[1]);
		panel.add(numberButtons[2]);
		panel.add(numberButtons[3]);
		panel.add(add);
		panel.add(numberButtons[4]);
		panel.add(numberButtons[5]);
		panel.add(numberButtons[6]);
		panel.add(sub);
		panel.add(numberButtons[7]);
		panel.add(numberButtons[8]);
		panel.add(numberButtons[9]);
		panel.add(divide);
		panel.add(decimal);
		panel.add(numberButtons[0]);
		panel.add(equals);
		panel.add(mult);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i = 0;i < 10;i++) {
			if(e.getSource() == numberButtons[i]) {
				textfield.setText(textfield.getText().concat(String.valueOf(i)));
			}
		}
		if(e.getSource() == decimal) {
			textfield.setText(textfield.getText().concat("."));
				
		}
		if(e.getSource() == add) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '+';
			textfield.setText("");
		}
		if(e.getSource() == sub) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '-';
			textfield.setText("");
		}
		if(e.getSource() == divide) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '/';
			textfield.setText("");
		}
		if(e.getSource() == mult) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '*';
			textfield.setText("");
		}
		if(e.getSource() == equals) {
			num2 = Double.parseDouble(textfield.getText());
				
			switch(operator) {
				case '+':
					result = num1 + num2;
					break;
				case '-':
					result = num1 - num2;
					break;
				case '/':
					result = num1 / num2;
					break;
				case '*':
					result = num1 * num2;
					break;
				}
				textfield.setText(String.valueOf(result));
				num1 = result;
		}
		if(e.getSource() == alc) {
			textfield.setText("");
		}
		if(e.getSource() == del) {
			String numbers = textfield.getText();
			textfield.setText("");
			for(int j = 0;j < numbers.length()-1;j++) {
				textfield.setText(textfield.getText() + numbers.charAt(j));
			}	
		}
		
	}

}
