import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;

public class Base4Panel extends JPanel {
	private Base4CalcState calc; // this object will actually do the calculating work
	JButton zero, one, two, three, four, five, six, seven, eight, nine, A, B, C, D, E, F,  
	plus, minus, multiply, divide, 
	clear;
    JTextField screen;
    JSlider base;
	

	Base4Panel() {
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
		base.setPreferredSize(new Dimension(250, 20));

		// do you need any other layout elements? 

		// you may decide you want to improve the appearance of the layout, 
		// which is fine. But defer that until you get the calculator working. 
		// (You can spend HOURS messing with layout, which is not the point of this exercise!)


	}

	// you need to deal with event handling. before you go too crazy writing code, 
	// think about when the calc object needs to be involved, and when it doesn't 

}
