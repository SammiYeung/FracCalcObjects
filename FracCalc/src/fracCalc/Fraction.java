package fracCalc;
public class Fraction {
	private int whole; //defining fields for the fraction object
	private int num;
	private int denom;
	private int[] improperFrac;
	private String fractionStr;
 
		public Fraction() { //this instance of Fraction takes in nothing as a parameter
			whole = 0; //initializes an empty fraction
			num = 0;
			denom = 1;
		}
		
		public Fraction(String op) {
		    String[] splitOperand = op.split("_"); //split wholes and fractions
		    	
		    /*if (splitOperand.length == 1) {
		        	String[] splitFrac = splitOperand[0].split("/");
		        	if (splitFrac.length == 1) { //no fraction
		        		whole = splitFrac[0];
		        		num = 0;
		        		denom = 1;
		        	}
		        	else { //no whole, no fraction
		        		whole = "0";
		        		num = splitFrac[0];
		            	denom = splitFrac[1];
		        	}
		    	}
		    	else { //normal mixed number, with both a whole and a fraction*/
		    
		    whole = Integer.parseInt(splitOperand[0]); //Parsed all three into integers
		        String [] splitFrac = splitOperand[1].split("/");
		        	num = Integer.parseInt(splitFrac[0]);	
		        	denom = Integer.parseInt(splitFrac[1]);	
			improperFrac = toImproperFrac(whole, num, denom); //updated int[] field with the improper fraction written as [num, denom]
		}	
		
		public Fraction doMath(Fraction op1, Fraction op2, String operator) { //accesses the methods for operators
			Fraction answer = new Fraction(); //new fraction object created for answer of doMath
			if(operator.equals("+")) { 
				answer = add(op1, op2);
			}
			else  if(operator.equals("-")) {
				answer = subtract(op1, op2);
			 }
			else if(operator.equals("*")) {
				answer = multiply(op1, op2);
			}
			else if(operator.equals("/")) {
				answer = divide(op1, op2);
			}
			return answer;
		}
		
		public Fraction add(Fraction op1, Fraction op2) { //accessed by doMath to add
			Fraction answer = new Fraction();
			int numAnswer = (op1.improperFrac[0]*op2.improperFrac[1])+(op2.improperFrac[0]*op1.improperFrac[1]); 
        	int denomAnswer = commonDenominator(op1.improperFrac[1], op2.improperFrac[1]); //common denominator found
        	answer.fractionStr = numAnswer + "/" + denomAnswer;
			return answer;
		}
		
		public Fraction subtract(Fraction op1, Fraction op2) { //accessed by doMath to subtract
			Fraction answer = new Fraction();
			int numAnswer = (op1.improperFrac[0]*op2.improperFrac[1])-(op2.improperFrac[0]*op1.improperFrac[1]); 
        	int denomAnswer = commonDenominator(op1.improperFrac[1], op2.improperFrac[1]); //common denominator found
        	answer.fractionStr = numAnswer + "/" + denomAnswer;
			return answer;
		}
		
		public Fraction multiply(Fraction op1, Fraction op2) { //accessed by doMath to multiply
			Fraction answer = new Fraction();
			int numAnswer = op1.improperFrac[0] * op2.improperFrac[0];
        	int denomAnswer = op1.improperFrac[1] * op2.improperFrac[1];
        	answer.fractionStr = numAnswer + "/" + denomAnswer;
			return answer;
        }
		public Fraction divide(Fraction op1, Fraction op2) { //accessed by doMath to divide
			Fraction answer = new Fraction();
			int numAnswer = op1.improperFrac[0] * op2.improperFrac[1];
        	int denomAnswer = op1.improperFrac[1] * op2.improperFrac[0];
        	answer.fractionStr = numAnswer + "/" + denomAnswer;
			return answer;
		}
		
		public static int commonDenominator(int denom1, int denom2) {
	    	int common = denom1 * denom2;
	    	return common;
	    }
		public static int[] toImproperFrac(int whole, int num, int denom) { //converts mixed number to improper fraction
			 if (whole < 0 && num > 0) {//negative whole numbers, stays negative when converted to improper fractions
				  num = num * -1;
			   }
			int[] answer = {(whole*denom)+num, denom};
			return answer; 
		}
}