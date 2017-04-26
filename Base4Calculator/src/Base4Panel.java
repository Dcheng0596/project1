import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Base4Panel extends JPanel {
    private Base4CalcState calc; // this object will actually do the calculating work
	JButton zero, one, two, three, four, five, six, seven, eight, nine, A, B, C, D, E, F,  
	plus, minus, multiply, divide, 
	clear;
    JTextField screen;
    JSlider base;
	

	Base4Panel() {
	    calc = new Base4CalcState();
		this.setLayout(new FlowLayout()); 
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
		clear = new JButton("Clear");
		screen = new JTextField(24);
		base = new JSlider(2, 16, 10);
		
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
		plus.addActionListener(new OperationListener());
		minus.addActionListener(new OperationListener());
		multiply.addActionListener(new OperationListener());
		divide.addActionListener(new OperationListener());
		clear.addActionListener(new ClearListener());
		
			
		add(screen);
		add(base);
		add(plus);
		add(minus);
		add(multiply);
		add(divide);
		add(F);
		add(E);
		add(D);
		add(C);
		add(B);
		add(A);
		add(nine);
		add(eight);
		add(seven);
		add(six);
		add(five);
		add(four);
		add(three);
		add(two);
		add(one);
		add(zero);
		add(clear); 
		
		screen.setEditable(false); 
		screen.setHorizontalAlignment(SwingConstants.RIGHT); // right justify screen
		base.setPreferredSize(new Dimension(250, 20)); // set slider size

	}
    class NumberListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            screen.setText(screen.getText()+((AbstractButton) e.getSource()).getText()); // prints to the screen the button text  
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
            screen.setText("");
            calc.clearTempValue();
            calc.clearTotalValue();
            calc.setOperation("");
            
        }

    }
	// you need to deal with event handling. before you go too crazy writing code, 
	// think about when the calc object needs to be involved, and when it doesn't 

}
