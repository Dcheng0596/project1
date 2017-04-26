
public class Base4CalcState {
	private String totalValue; // value of current calculation
	private String tempValue;  // number to be combined to totalValue
	private String operation;    // if or what operation to be used
	
	Base4CalcState()
	{
	    totalValue = "";
	    tempValue = "";
	    operation = "";
	}
	void setOperation(String op) { operation = op; }
	
	String getOperation() { return operation; }
	
	void clearTotalValue() { totalValue = ""; }

	void clearTempValue() { tempValue = ""; }

	String getTempValue() { return tempValue; }
    
    void setTempValue(String digit) { tempValue += digit; }

	String getTotalValue() { return totalValue; }
	
	void setTotalValue(String digit) { totalValue += digit; }
	
	// What other methods will you need?
}
