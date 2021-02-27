package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import calcApp.Calc;
import server.CalcImplementation;

public class CalcClient
{
	CalcClient(){
		System.out.println("Executing " + this.getClass());
	}
    public void showMenu()
    {
        System.out.println("----------------------------------");
        System.out.println("0.Exit");
        System.out.println("1.Addition");
        System.out.println("2.Subtraction");
        System.out.println("3.Multiplicatin");
        System.out.println("4.Division");
        System.out.println("----------------------------------");
        System.out.print("Enter your choice : ");

    }
    public float getValue() throws IOException
    {
        float val=0;
        try
        {
            System.out.print("Enter the value : ");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String s = br.readLine();
            val = Float.parseFloat(s);
        }
        catch (IOException e)
        {
            System.out.println(e);
        }
        return val;
    }
    public int getChoice() throws IOException
    {
        int val=0;
        try
        {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            val = Integer.parseInt(br.readLine());
            System.out.println("----------------------------------");
        }
        catch (IOException e)
        {
            System.out.println(e);
        }
        return val;
    }

	public static void main(String args[])
    {

        Calc calcImpl = null ;
        calcImpl = new CalcImplementation();
        CalcClient cc = new CalcClient();
        
        try
        {
 
            float val1 = 0;
            float val2 = 0;
            float res = 0;
            int ch = 1;

            while (ch != 0 )
            {
                cc.showMenu();
                ch = cc.getChoice();
                
                if(ch == 0) {
                	return ;
                }
                if(ch > 4 || ch < 0) {
                	System.out.println("You've entered incorrect option!!!\n \t Choose AGAIN...");
                	continue;
                }

                val1 = cc.getValue();
                val2 = cc.getValue();

                switch (ch)
                {
                    case 1:
                        res = calcImpl.operation(val1, val2, "+");
                        break;
                    case 2:
                        res = calcImpl.operation(val1, val2, "-");
                        break;
                    case 3:
                        res = calcImpl.operation(val1, val2, "*");
                        break;
                    case 4:
                        res = calcImpl.operation(val1, val2, "/");
                        break;
                    case 0:
                        return ; 
                    
                }
                System.out.println("----------------------------------");
                System.out.println("Result : "+res);
                System.out.println("----------------------------------");
            }

                
        }
        catch (Exception e) 
        {
            System.out.println("ERROR : " + e) ;
            e.printStackTrace();
            
        }
        finally {
        	System.out.println("Closing client Application...");
        }
    }

}