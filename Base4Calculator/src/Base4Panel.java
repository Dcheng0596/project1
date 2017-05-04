import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Base4Panel extends JPanel {
    private Base4CalcState calc; // this object will actually do the calculating work
	JButton zero, one, two, three, four, five, six, seven, eight, nine, A, B, C, D, E, F,  
	plus, minus, multiply, divide, clear, equal, negative, back;
    JTextField screen;
    JSlider base;
	
	Base4Panel() {
	    
	    calc = new Base4CalcState();
		this.setLayout(new BorderLayout());
		JPanel grid = new JPanel();
		grid.setLayout(new GridLayout(0, 5));
		back = new JButton("<-");
		zero = new JButton("0"); 
		one = new JButton("1");
		two = new JButton("2"); 
		three = new JButton("3"); 
		four = new JButton("4");
		five = new JButton("5");
		six = new JButton("6");
		seven = new JButton("7");
		eight = new JButton("8");
		nine = new JButton("9");
		A = new JButton("A");
		B = new JButton("B");
		C = new JButton("C");
		D = new JButton("D");
		E = new JButton("E");
		F = new JButton("F");
		plus = new JButton("+"); 
		minus = new JButton("-"); 
		multiply = new JButton("x"); 
		divide = new JButton("/"); 
		clear = new JButton("CE");
		equal = new JButton("=");
		negative = new JButton("(-)");
		screen = new JTextField(24);
		base = new JSlider(2, 16, 10); // set slider to 10 by default
		A.setEnabled(false); B.setEnabled(false); 
		C.setEnabled(false); D.setEnabled(false);
		E.setEnabled(false); F.setEnabled(false);
		
		
		A.addActionListener(new NumberListener());
		B.addActionListener(new NumberListener());
		C.addActionListener(new NumberListener());
		D.addActionListener(new NumberListener());
		E.addActionListener(new NumberListener());
		F.addActionListener(new NumberListener());
		nine.addActionListener(new NumberListener());
		eight.addActionListener(new NumberListener());
		seven.addActionListener(new NumberListener());
		six.addActionListener(new NumberListener());
		five.addActionListener(new NumberListener());
		four.addActionListener(new NumberListener());
		three.addActionListener(new NumberListener());
		two.addActionListener(new NumberListener());
		one.addActionListener(new NumberListener());
		zero.addActionListener(new NumberListener());
		negative.addActionListener(new NegativeListener());
		plus.addActionListener(new OperationListener());
		minus.addActionListener(new OperationListener());
		multiply.addActionListener(new OperationListener());
		divide.addActionListener(new OperationListener());
		clear.addActionListener(new ClearListener());
		equal.addActionListener(new EqualListener());
		base.addChangeListener(new SliderListener());
		back.addActionListener(new BackListener());
		
		add(screen, BorderLayout.NORTH);
		add(base, BorderLayout.SOUTH);
		grid.add(plus);
	    grid.add(minus);
	    grid.add(multiply);
	    grid.add(divide);
	    grid.add(back);
	    grid.add(seven);
	    grid.add(eight);
	    grid.add(nine);
	    grid.add(A);
		grid.add(B);
		grid.add(four);
		grid.add(five);
		grid.add(six);
		grid.add(C);
		grid.add(D);
		grid.add(one);
		grid.add(two);
		grid.add(three);
	    grid.add(E);
        grid.add(F);
        grid.add(zero);
		grid.add(negative);
		grid.add(clear);
		grid.add(equal);
		add(grid);
		
		screen.setPreferredSize(new Dimension(20, 30));  // set dimensions
		screen.setFont(screen.getFont().deriveFont(20f)); // increase font
		screen.setEditable(false); 
		screen.setBackground(Color.WHITE); //set screen color to white
		screen.setHorizontalAlignment(SwingConstants.RIGHT); // right justify screen
		screen.setText("0");    // displays 0 by default
		base.setPreferredSize(new Dimension(10, 50)); // set slider size
		base.setPaintTicks(true);
		base.setMajorTickSpacing(1);
		base.setPaintLabels(true);
		base.setLabelTable(base.createStandardLabels(2));

	}
    class NumberListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            String buttonText = new String(((AbstractButton) e.getSource()).getText());  // gets button text
            if(screen.getText().equals("0") && buttonText.equals("0"))  // checks if pressed zero while zero on screen
                    return;
            if(calc.getOperation().isEmpty())       // appends buttonText to either total or temp depending if an operation has been pressed
            {
                calc.setTotalValue(buttonText);     // appends the digit to total
                screen.setText(calc.getTotalValue()); // prints to the screen the button text  
            }
            else
            {
                    calc.setTempValue(buttonText);      // appends the digit to temp
                    screen.setText(calc.getTempValue()); // prints to the screen the button text  
            }              
        } 
    }
    class OperationListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            calc.setOperation(((AbstractButton) e.getSource()).getText()); // sets operation member to the corresponding button
        }
    }
    
    class ClearListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            screen.setText("0");             // clear screen and set member variables to the empty string
            calc.clearTempValue();
            calc.clearTotalValue();
            calc.setOperation("");
        }
    }
    class EqualListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            try
            {
                Long.parseLong(calc.getTotalValue(), calc.getBase());        // convert total and temp value to base 10
                Long.parseLong(calc.getTempValue(), calc.getBase()); 
            }
            catch(NumberFormatException ex)
            {
                return;   // Does nothing if total or temp is empty string
            }
            long value1 = Long.parseLong(calc.getTotalValue(), calc.getBase());        // convert total and temp value to base 10
            long value2 = Long.parseLong(calc.getTempValue(), calc.getBase()); 
            String sum = new String();      // contains new total
            if(calc.getOperation().equals("+"))     // sets sum equal to the combined values converted to the desired base as a string
                sum = new String(Long.toString((value1 + value2), calc.getBase()));
            if(calc.getOperation().equals("-"))
                sum = new String(Long.toString((value1 - value2), calc.getBase()));
            if(calc.getOperation().equals("x"))
                sum = new String(Long.toString((value1 * value2), calc.getBase()));
            if(calc.getOperation().equals("/"))
                sum = new String(Long.toString((value1 / value2), calc.getBase()));
            calc.clearTotalValue();
            calc.setTotalValue(sum);             // update current total  
            calc.clearTempValue();
            calc.setOperation("");
            screen.setText(calc.getTotalValue().toUpperCase());   // shows the current total and formats string to uppercase
            
        }
    }
    class SliderListener implements ChangeListener
    {
        JButton[] digitList = new JButton[]{two, three, four, five, six, seven, eight, nine, A, B, C, D, E, F}; // array of varaiblew digits
        @Override
        public void stateChanged(ChangeEvent e)
        {
            
            int baseNum = base.getValue();
            int preBase = calc.getBase();
            calc.setBase(baseNum); 
            if(!screen.getText().equals("0"))
            {
                Long decimal = Long.parseLong(screen.getText(), preBase);
                String string = new String(Long.toString(decimal, baseNum).toUpperCase());
                screen.setText(string);
          
                if(calc.getOperation().isEmpty())  // sets the screen and temp or total to the new base
                { 
                    calc.clearTotalValue();
                    calc.setTotalValue(string);  
                }
                else
                {
                    calc.clearTempValue();
                    calc.setTempValue(string);  
                } 
            }
            for(int i = 0; i < 14; i++)     // enables or disables buttons depending on slider value
            {
                if(i < baseNum - 2)
                    digitList[i].setEnabled(true);
                else
                    digitList[i].setEnabled(false);      
            }  
        }
    }
    
    class NegativeListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if(calc.getOperation().isEmpty())
            {
                if(calc.getTotalValue().isEmpty()) // checks if theres something to make negative
                    return;
                String temp = new String("-" + calc.getTotalValue());   // turns string negative and displays it on screen
                calc.clearTotalValue();
                calc.setTotalValue(temp);
                screen.setText(calc.getTotalValue());
            }
            else
            {
                if(calc.getTempValue().isEmpty())  // checks if theres something to make negative
                    return;
                String temp = new String("-" + calc.getTempValue());
                calc.clearTempValue();
                calc.setTempValue(temp);
                screen.setText(calc.getTempValue());
            }
        }
    }
    class BackListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if(screen.getText().length() == 1)  // does not delete if theres only one digit
                return;
            if(calc.getOperation().isEmpty())
            {
                String string =new String(calc.getTotalValue());   // deletes last character and displays it on screen
                StringBuilder sb = new StringBuilder(string);
                sb.deleteCharAt(string.length() - 1);
                calc.clearTotalValue();
                calc.setTotalValue(sb.toString());
                screen.setText(calc.getTotalValue());
            }
            else
            {
                String string = new String(calc.getTempValue());   // deletes last character and displays it on screen
                StringBuilder sb = new StringBuilder(string);
                sb.deleteCharAt(string.length() - 1);
                calc.clearTempValue();
                calc.setTempValue(sb.toString());
                screen.setText(calc.getTempValue());
            }
        }
    }
}
