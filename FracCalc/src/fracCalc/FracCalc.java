package fracCalc;
import static org.junit.Assert.assertArrayEquals;
import java.util.Scanner;

public class FracCalc {
    public static void main(String[] args){
    	Scanner userInput = new Scanner(System.in);
    	System.out.println("Please input the fraction expression you would like to evaluate:");
     	String input = userInput.nextLine();
    	
    	while (!input.equals("quit")) {
    		System.out.println(produceAnswer(input));
    		System.out.println("Do you want to keep going? Type \"quit\" to end.");
			input = userInput.nextLine();
    	}
    	userInput.close();
    }
    public static String produceAnswer(String input){ 
    	String[] expression = input.split(" "); //separating the operands and operators
    	String operator = expression[1];
    	Fraction operand1 = new Fraction(expression[0]); //set Fraction objects for each operand
    	Fraction operand2 = new Fraction(expression[2]);
    	Fraction answer = new Fraction(); //creating the answer object
    	answer = operand1.doMath(expression[1], operand2);
    	
    	/*int gcf = gcf(answerArray[1], answerArray[2]);
    	String answer = "";
    	if (gcf == 0) { //if the numerator or denominator is 0
    		answer += toMixedNum(answerArray[1], answerArray[2]);
    	}
    	else { //if the numerator or denominator is not 0
    		answer += toMixedNum(answerArray[1]/gcf, answerArray[2]/gcf);
    	}
    	
		return answer;*/
    }    	
	
	public static String toMixedNum(int num, int denom) { //converts improper to mixed fraction
		int wholenum = (num/denom);
		int newnumer = (num%denom);
		String answer = wholenum + "_" + newnumer + "/" + denom;
		if (newnumer > 0 && denom < 0) {
    		newnumer *= -1;
    		denom = Math.abs(denom);
    	}
		if (newnumer == 0) { //simplifies numbers like 5_0/1
    		answer = wholenum + "";
    	}
		else if (wholenum < 0) { //simplifies numbers like -5_-0/1
			newnumer = Math.abs(newnumer);
			denom = Math.abs(denom);
    		answer = wholenum + "_" + newnumer + "/" + denom;	
    	}
		if (wholenum == 0) { //simplifies numbers like 0_1/2
    		answer = newnumer + "/" + denom;	
    	}
    	if (wholenum == 0 && newnumer == 0) { //simplifies numbers like 0_0/1
    		answer = "0";
    	}
    	else if (newnumer < 0 && denom < 0) { //simplies numbers like -5/-8
    		newnumer = Math.abs(newnumer);
    		denom = Math.abs(denom);
			answer = wholenum + "_" + newnumer + "/" + denom;
    	}
		return answer; 
	}
	
	
	//ALL IMPORTS FROM CALCULATE NOT YET MODIFIED
	public static boolean isDivisibleBy(int dividend, int divisor) { //returns true if a is divisible by b
		if (divisor==0) throw new IllegalArgumentException("numbers cannot be divided by zero as it is undefined");
		if (dividend%divisor == 0) {
	    return true;
		}
		else
		return false;
	}
	
	public static int gcf(int a, int b){  //returns the greatest common denominator of the two inputed numbers
	    int answer = a;
	    a = Math.abs(a);
	    b = Math.abs(b);
	    if (a == 0) {
	    	answer = 0;
	    }
	    else {
	    	for(int i = a; i>=1; i--) {
	    		if(isDivisibleBy(a, i) && isDivisibleBy(b, i)) {
	    			answer = i; 
	    			i = 0;
	    		}
	    	}
	    }
		return answer;
	}
}


