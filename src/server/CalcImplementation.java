package server;

import calcApp.Calc;

public class CalcImplementation implements Calc {
	public final static String CHARACTER_ADD = "+";
    public final static String CHARACTER_MIN = "-";
    public final static String CHARACTER_DIV = "/";
    public final static String CHARACTER_MUL = "*";
    
    public CalcImplementation(){
    	System.out.println("Executing " + this.getClass());
    }
    
	public float operation(float val1, float val2, String op) throws Exception
    {
        if(op.equals(CHARACTER_ADD))
        	return val1  +  val2;
        else if(op.equals(CHARACTER_MIN))
        	return val1 -  val2;
    
        else if(op.equals(CHARACTER_MUL))
        	return val1 *  val2;
        else if(op.equals(CHARACTER_DIV))
        {
        	if(val2 != 0)
        		return val1 /  val2;
        	else {
        		throw new Exception("ZeroDivisibilityException...");
        	}
        }	
		return -1;
    }

}
