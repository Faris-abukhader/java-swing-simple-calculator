import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener{
	
	// declaring calculator components . . . 
	private JPanel mainPanel ,upperPanel,lowerPanel;
	private JLabel text;
	private double firstNum,secondNum;
	private String operation;
	Calculator(){
		// initial our components
		mainPanel = new JPanel(new BorderLayout());
		upperPanel = new JPanel(new BorderLayout());
		lowerPanel = new JPanel(new GridLayout(5,4));
		text = new JLabel("0",SwingConstants.RIGHT);
		operation = "";
		
		
		// fix upper panel size
		upperPanel.setPreferredSize(new Dimension(300,80));
//		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

		
	
		// set up textField . . . 
		text.setOpaque(true);
		text.setBackground(Color.black);
		text.setForeground(Color.white);
		text.setFont(new Font("serif",Font.PLAIN,24));
		text.setPreferredSize(new Dimension(300,80));
		
		
		
		// adding textField to upper panel
		upperPanel.add(text);
		
		
		// adding button to lower panel
		String buttons[][]= {
				{"C","∓","%","÷"},
				{"7","8","9","×"},
				{"4","5","6","−"},
				{"1","2","3","+"},
		};
		for(int i=0;i<4;i++) {
			JPanel panel = new JPanel(new GridLayout(1,4));
			for(int j=0;j<4;j++) {
				JButton button = new JButton(buttons[i][j]);
				button.addActionListener(this);
				panel.add(button);
			}
			lowerPanel.add(panel); 
		}
		String btn[]= {"0",".","="};
		JPanel pa = new JPanel(new BorderLayout());
		JButton b1 = new JButton(btn[0]);
		JButton b2 = new JButton(btn[1]);
		JButton b3 = new JButton(btn[2]);
		
		// add event 
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		
		b1.setPreferredSize(new Dimension(150,30));
		b2.setPreferredSize(new Dimension(75,30));
		b3.setPreferredSize(new Dimension(75,30));

		
				
		
		pa.add(b1,BorderLayout.WEST);
		pa.add(b2,BorderLayout.CENTER);
		pa.add(b3,BorderLayout.EAST);
		
		lowerPanel.add(pa);
		
		
		// adding sub panel to main panel
		mainPanel.add(upperPanel,BorderLayout.NORTH);
		mainPanel.add(lowerPanel,BorderLayout.CENTER);

		
		
		// adding main panel to frame
		this.add(mainPanel);
		
		
		// settuing up the frame
		this.setTitle("Calculator");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300,500);
		this.setResizable(false);
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton clickedButton = (JButton) e.getSource();
		if(clickedButton.getText().equals("1")) {
			upDateNumbers(1);
		}else if(clickedButton.getText().equals("2")) {
			upDateNumbers(2);
		}else if(clickedButton.getText().equals("3")) {
			upDateNumbers(3);
		}else if(clickedButton.getText().equals("4")) {
			upDateNumbers(4);
		}else if(clickedButton.getText().equals("5")) {
			upDateNumbers(5);
		}else if(clickedButton.getText().equals("6")) {
			upDateNumbers(6);
		}else if(clickedButton.getText().equals("7")) {
			upDateNumbers(7);
		}else if(clickedButton.getText().equals("8")) {
			upDateNumbers(8);
		}else if(clickedButton.getText().equals("9")) {
			upDateNumbers(9);
		}else if(clickedButton.getText().equals("0")) {
			upDateNumbers(0);
		}else if(clickedButton.getText().equals("C")) {
			reset();
		}else if(clickedButton.getText().equals("∓")) {
			text.setText("-"+text.getText());
		}else if(clickedButton.getText().equals(".")) {
			text.setText(text.getText()+".");
		}else if(clickedButton.getText().equals("%")) {
			double temp = Double.parseDouble(text.getText());
			temp/=100;
			text.setText(String.valueOf(temp));
		}else if(clickedButton.getText().equals("÷")) {
			operation = "division";
			text.setText("0");
		}else if(clickedButton.getText().equals("×")) {
			operation = "multi";
			text.setText("0");
		}else if(clickedButton.getText().equals("−")) {
			operation = "subtract";
			text.setText("0");
			
		}else if(clickedButton.getText().equals("+")) {
			operation = "addition";
			text.setText("0");
		}else if(clickedButton.getText().equals("=")) {
			upDateNumbers(-1);
			if(operation.length()>0) {
				text.setText(String.valueOf(result()));
			}
		}
		
	}
	
	void upDateNumbers(int num) {
		if(num>0) {
		if(text.getText().equals("-0")) {
			text.setText("-"+num);
		}else if(text.getText().equals("0")) {
			text.setText(""+num);
		}else {
			text.setText(text.getText()+num);
		}
	  }
		if(operation.length()==0) {
			firstNum = Double.parseDouble(text.getText());
		}else {
			secondNum = Double.parseDouble(text.getText());
		}
		
	}
	
	void reset() {
		text.setText("0");
		firstNum = secondNum = 0;
		operation = "";

	}
	
	double result() {
		switch(operation) {
		case "addition":
			return firstNum + secondNum;
		case "subtract":
			return firstNum - secondNum;
		case "multi":
			return firstNum * secondNum;
		case "division":
			return firstNum / secondNum;
		default:
			return -1;
		}
	}


	public static void main(String[] args) {
		new Calculator();
	}


}

