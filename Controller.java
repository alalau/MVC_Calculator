package calculator_mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Controller implements ActionListener{

    private Model model;
    private View view;
    private double num1, num2, ans;
    private JButton addButton, subtractButton, multiplyButton, divideButton, equalsButton;
    
    private boolean addClick = false;
    private boolean subClick = false;
    private boolean divClick = false;
    private boolean multiClick = false;
    
    public Controller(Model model, View view){
        this.model = model;
        this.view = view;

    	addButton = view.getAdd();
    	subtractButton = view.getSub();
    	multiplyButton = view.getMulti();
    	divideButton = view.getDiv();
    	equalsButton = view.getEquals();
    	
    	addButton.addActionListener(this);
    	subtractButton.addActionListener(this);
    	multiplyButton.addActionListener(this);
    	divideButton.addActionListener(this);
    	equalsButton.addActionListener(this);    	
    }
    
    
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == addButton) {
			if(view.getFieldText() != null) {
				num1 = Double.parseDouble(String.valueOf(view.getFieldText()));
				addClick = true;
			}
		}
		if(e.getSource() == subtractButton) {
			if(view.getFieldText() != null) {
				num1 = Double.parseDouble(String.valueOf(view.getFieldText()));
				subClick = true;
			}
		}
		if(e.getSource() == multiplyButton) {
			if(view.getFieldText() != null) {
				num1 = Double.parseDouble(String.valueOf(view.getFieldText()));
				multiClick = true;
			}
		}
		if(e.getSource() == divideButton) {
			if(view.getFieldText() != null) {
				num1 = Double.parseDouble(String.valueOf(view.getFieldText()));
				divClick = true;
			}
		}
		
		if(e.getSource() == equalsButton) {
			num2 = Double.parseDouble(String.valueOf(view.getFieldText()));
			if(addClick == true) {
				ans = model.add(num1, num2);
				addClick = false;
			}
			if(subClick == true) {
				ans = model.subtract(num1, num2);
				subClick = false;
			}
			if(multiClick == true) {
				ans = model.multiply(num1, num2);
				multiClick = false;
			}
			if(divClick == true) {
				ans = model.divide(num1, num2);
				divClick = false;
			}
			view.setAnsField(String.valueOf(ans));
		}
	}

}
