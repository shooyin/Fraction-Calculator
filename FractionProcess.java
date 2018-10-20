/**
@author : Jeff DeSain, John Le
Due: 4/22/14
Lab 3
This program simulates a calculator
*/

import java.util.*;

public class FractionProcess
{
   
   private static final char LESS_THAN_EQUALS = 'l';
   private static final char GREATER_THAN_EQUALS = 'g';
   private static final String OPERATIONS = "+-/*=><";
   	
		
   public FractionProcess()
   {
   }	
		
   
	
   public String calculate(String exp)
   {
      Expression expression = parse(exp);
      String answer = "";
      
      switch(expression.operator)
      {
         case '+':
            answer = expression.num1.add(expression.num2).toString();
            break;
         case '-':
            answer = expression.num1.sub(expression.num2).toString();
            break;
         case '*':
            answer = expression.num1.mlt(expression.num2).toString();
            break;
         case '/':
            answer = expression.num1.div(expression.num2).toString();
            break;
         case '=':
            if (expression.num1.eq(expression.num2))
               answer = "TRUE";
            else
               answer = "FALSE";
            break;
         case '>':
            if (expression.num1.gt(expression.num2))
               answer = "TRUE";
            else
               answer = "FALSE";
            break;
         case '<':
            if (expression.num1.lt(expression.num2))
               answer = "TRUE";
            else
               answer = "FALSE";  
            break;    
         case GREATER_THAN_EQUALS:
            if (expression.num1.ge(expression.num2))
               answer = "TRUE";
            else
               answer = "FALSE";
            break;
         case LESS_THAN_EQUALS:
            if (expression.num1.le(expression.num2))
               answer = "TRUE";
            else
               answer = "FALSE";
            break;   
      }                     
      
      return (exp + " = " + answer);
   }
		
		
   private Expression parse(String exp)
   {
      StringTokenizer tk = new StringTokenizer(exp);
      String[] opers = new String[3];
   		
      if(tk.countTokens() != 3)
a      else
      {
         opers[0] = tk.nextToken();
         opers[1] = tk.nextToken();
         opers[2] = tk.nextToken();
      }	
   		
      RationalNumber num1 = parseNum(opers[0]);
      RationalNumber num2 = parseNum(opers[2]);
   		
      char operation = parseOper(opers[1]);
      
      return new Expression(num1, num2, operation);
   }
	
   private RationalNumber parseNum(String str)
   {
      RationalNumber answer = new RationalNumber();
      StringTokenizer tk = new StringTokenizer(str, "/");
   		
      try
      {
         if (tk.countTokens() == 2)
         {
            answer = new RationalNumber(Integer.parseInt(tk.nextToken()), Integer.parseInt(tk.nextToken()));
         }
         else
         {
            answer = new RationalNumber(Integer.parseInt(tk.nextToken()));
         }
         
      }
      catch(Exception e)
      {
         throw new IllegalArgumentException("Invalid Number: " + str);
      }
      return answer;
   }
		
   private char parseOper(String str)
   {
      char answer;
   
      if(str.length() == 1 && OPERATIONS.indexOf(str) != -1)
      {
         answer = str.charAt(0);
      }
      else if(str.equals(">="))
      {
         answer = GREATER_THAN_EQUALS;
      }
      else if(str.equals("<="))
      {
         answer = LESS_THAN_EQUALS;
      }
      else
         throw new IllegalArgumentException("Invalid Operator: " + str);
   
      return answer;
   }
	
}

class Expression
{

   protected RationalNumber num1, num2;
   protected char operator;

   Expression(RationalNumber num1, RationalNumber num2, char operator)
   {
      this.num1 = num1;
      this.num2 = num2;
      this.operator = operator;
   }

}