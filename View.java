package calculator_mvc;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class View extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel calcPanel;
	private JPanel numberPanel = new JPanel();
	static JTextField ansField;
	static double plusMinus;
	static int clearField;
		
	private JButton addButton = new JButton("+");
	private JButton subtractButton = new JButton("-");
	private JButton multiplyButton = new JButton("*");
	private JButton divideButton = new JButton("/");
	private JButton equalsButton = new JButton("=");
	private JButton zeroButton = new JButton("0");
	private JButton oneButton = new JButton("1");
	private JButton twoButton = new JButton("2");
	private JButton threeButton = new JButton("3");
	private JButton fourButton = new JButton("4");
	private JButton fiveButton = new JButton("5");
	private JButton sixButton = new JButton("6");
	private JButton sevenButton = new JButton("7");
	private JButton eightButton = new JButton("8");
	private JButton nineButton = new JButton("9");
	private JButton clearButton = new JButton("C");
	private JButton decimalButton = new JButton(".");
	private JButton plusMinusButton = new JButton("+/-");
		
	View() {
	    Dimension expectedDimension = new Dimension(355, 550);

	    setTitle("MVC Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(expectedDimension);
		setMinimumSize(expectedDimension);
		this.setForeground(Color.WHITE);
		
		calcPanel = new JPanel();
		calcPanel.setPreferredSize(expectedDimension);
		calcPanel.setMaximumSize(expectedDimension);
		calcPanel.setMinimumSize(expectedDimension);        
		calcPanel.setLayout(new BorderLayout(10, 10));
		
		numberPanel.setLayout(new GridLayout(5, 4, 6, 6));
		
		ansField = new JTextField();
		
		styleButtons();
		
		numberPanel.add(clearButton);
		numberPanel.add(plusMinusButton);
		numberPanel.add(divideButton);
		numberPanel.add(multiplyButton);
		numberPanel.add(sevenButton);
		numberPanel.add(eightButton);
		numberPanel.add(nineButton);
		numberPanel.add(subtractButton);
		numberPanel.add(fourButton);
		numberPanel.add(fiveButton);
		numberPanel.add(sixButton);
		numberPanel.add(addButton);
		numberPanel.add(oneButton);
		numberPanel.add(twoButton);
		numberPanel.add(threeButton);
		numberPanel.add(equalsButton);
		numberPanel.add(zeroButton);
		numberPanel.add(decimalButton);
		
		calcPanel.add(ansField, BorderLayout.NORTH);
		calcPanel.add(numberPanel, BorderLayout.CENTER);
		
		this.getContentPane().add(calcPanel, BorderLayout.CENTER);
		this.pack();
		this.setVisible(true);
		
		zeroButton.addActionListener(this);
		oneButton.addActionListener(this);
		twoButton.addActionListener(this);
		threeButton.addActionListener(this);
		fourButton.addActionListener(this);
		fiveButton.addActionListener(this);
		sixButton.addActionListener(this);
		sevenButton.addActionListener(this);
		eightButton.addActionListener(this);
		nineButton.addActionListener(this);
		ansField.addActionListener(this);
		plusMinusButton.addActionListener(this);
		decimalButton.addActionListener(this);
		clearButton.addActionListener(this);
		addButton.addActionListener(this);
		subtractButton.addActionListener(this);
		multiplyButton.addActionListener(this);
		divideButton.addActionListener(this);
		equalsButton.addActionListener(this);
	}
	
	public JButton getAdd() { return addButton; }
	public JButton getMulti() { return multiplyButton; }
	public JButton getDiv() { return divideButton; }
	public JButton getSub() { return subtractButton; }
	public JButton getEquals() { return equalsButton; }
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		JButton clickedButton = (JButton) e.getSource();
		String buttonText = clickedButton.getText();
		
		if (clickedButton == zeroButton || clickedButton == oneButton || clickedButton == twoButton || clickedButton == threeButton || clickedButton == fourButton || clickedButton == fiveButton || clickedButton == sixButton || clickedButton == sevenButton || clickedButton == eightButton || clickedButton == nineButton ) {
			if(ansField.getText().length() < 16) {
				if(clearField == 1) {
					ansField.setText(buttonText);
					clearField = 0;
				} else ansField.setText(ansField.getText() + buttonText);
			}
		}
		
		if(e.getSource() == addButton || e.getSource() == subtractButton || e.getSource() == multiplyButton || e.getSource() == divideButton || e.getSource() == equalsButton) {
			clearField = 1;
		}

		if(e.getSource() == clearButton) {
			ansField.setText("");
		}
		
		if(e.getSource() == plusMinusButton) {
			if(ansField.getText().equals("") || ansField.getText().equals("-")) {
				ansField.setText("-");
			}else{
				plusMinus = (Double.parseDouble(String.valueOf(ansField.getText())));
				plusMinus *= -1;
				ansField.setText(String.valueOf(plusMinus));
			}
		}
		
		if(e.getSource() == decimalButton) {
			if(ansField.getText().contains(".")) {
				ansField.setText(ansField.getText());
			}else{
				ansField.setText(ansField.getText() + ".");
			}
		}
	}
	
	public void setAnsField(String text) {
		ansField.setText(text);
	}
		
	public String getFieldText() { 
		return String.valueOf(ansField.getText()); 
	}
	
	public void styleButtons() {
	    ansField.setEditable(false);
		ansField.setFont(new Font("Arial",Font.BOLD,36));
		ansField.setBackground(Color.decode("#08a08d"));
		ansField.setForeground(Color.WHITE);
		addButton.setFont(new Font("Arial",Font.BOLD,24));
		addButton.setBackground(Color.decode("#6e6f72"));
		addButton.setForeground(Color.WHITE);
		subtractButton.setBackground(Color.decode("#6e6f72"));
		subtractButton.setFont(new Font("Arial",Font.BOLD,24));
		subtractButton.setForeground(Color.WHITE);
		multiplyButton.setFont(new Font("Arial",Font.BOLD,24));
		multiplyButton.setBackground(Color.decode("#6e6f72"));
		multiplyButton.setForeground(Color.WHITE);
		divideButton.setFont(new Font("Arial",Font.BOLD,24));
		divideButton.setBackground(Color.decode("#6e6f72"));
		divideButton.setForeground(Color.WHITE);
		equalsButton.setFont(new Font("Arial",Font.BOLD,24));
		equalsButton.setBackground(Color.decode("#6e6f72"));
		equalsButton.setForeground(Color.WHITE);
		zeroButton.setFont(new Font("Arial",Font.BOLD,24));
		zeroButton.setBackground(Color.decode("#7794a7"));
		zeroButton.setForeground(Color.WHITE);
		oneButton.setFont(new Font("Arial",Font.BOLD,24));
		oneButton.setBackground(Color.decode("#7794a7"));
		oneButton.setForeground(Color.WHITE);
		twoButton.setFont(new Font("Arial",Font.BOLD,24));
		twoButton.setBackground(Color.decode("#7794a7"));
		twoButton.setForeground(Color.WHITE);
		threeButton.setFont(new Font("Arial",Font.BOLD,24));
		threeButton.setBackground(Color.decode("#7794a7"));
		threeButton.setForeground(Color.WHITE);
		fourButton.setFont(new Font("Arial",Font.BOLD,24));
		fourButton.setBackground(Color.decode("#7794a7"));
		fourButton.setForeground(Color.WHITE);
		fiveButton.setFont(new Font("Arial",Font.BOLD,24));
		fiveButton.setBackground(Color.decode("#7794a7"));
		fiveButton.setForeground(Color.WHITE);
		sixButton.setFont(new Font("Arial",Font.BOLD,24));
		sixButton.setBackground(Color.decode("#7794a7"));
		sixButton.setForeground(Color.WHITE);
		sevenButton.setFont(new Font("Arial",Font.BOLD,24));
		sevenButton.setBackground(Color.decode("#7794a7"));
		sevenButton.setForeground(Color.WHITE);
		eightButton.setFont(new Font("Arial",Font.BOLD,24));
		eightButton.setBackground(Color.decode("#7794a7"));
		eightButton.setForeground(Color.WHITE);
		nineButton.setFont(new Font("Arial",Font.BOLD,24));
		nineButton.setBackground(Color.decode("#7794a7"));
		nineButton.setForeground(Color.WHITE);
		clearButton.setFont(new Font("Arial",Font.BOLD,24));
		clearButton.setBackground(Color.decode("#6e6f72"));
		clearButton.setForeground(Color.WHITE);
		decimalButton.setFont(new Font("Arial",Font.BOLD,24));
		decimalButton.setBackground(Color.decode("#7794a7"));
		decimalButton.setForeground(Color.WHITE);
		plusMinusButton.setFont(new Font("Arial",Font.BOLD,24));
		plusMinusButton.setBackground(Color.decode("#6e6f72"));
		plusMinusButton.setForeground(Color.WHITE);
		
	}
}
