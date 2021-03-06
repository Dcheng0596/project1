
public class Base4CalcState {
	private String totalValue; // value of current calculation
	private String tempValue;  // number to be combined to totalValue
	private String operation;    // if or what operation to be used
	private int base;
	
	Base4CalcState()
	{
	    totalValue = new String();
	    tempValue = new String();
	    operation = new String();
	    base = 10;
	}
	void setOperation(String op) { operation = op; }
	
	String getOperation() { return operation; }
	
	void clearTotalValue() { totalValue = ""; }

	void clearTempValue() { tempValue = ""; }

	String getTempValue() { return tempValue; }
    
    void setTempValue(String digit) { tempValue = tempValue.concat(digit); }

	String getTotalValue() { return totalValue; }
	
	void setTotalValue(String digit) { totalValue = totalValue.concat(digit); }
	
	void setBase(int radix) { base = radix; }
	
	int getBase() { return base; }
	
	// What other methods will you need?
}
