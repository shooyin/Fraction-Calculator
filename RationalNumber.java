/**
@author : Jeff DeSain, John Le
Due: 4/22/14
Lab 3
This program simulates a calculator
*/


   public class RationalNumber implements RationalExpressions
   {
   
      private int num;
      private int deno;
   
      public RationalNumber(int num, int deno)
      {
         this.num = num;
         if(deno == 0)
            throw new IllegalArgumentException("Cannot divide by 0!");
         else
            this.deno = deno;
      }
   
      public RationalNumber(int num)
      {
         this.num = num;
         deno = 1;
      }
   
      public RationalNumber()
      {
         num = 0;
         deno = 1;	
      }
   
   
      public RationalNumber add(RationalNumber r)
      {
         int num1, num2, deno1;
      
         num1 = num * r.getDenominator();
         num2 = r.getNumerator() * deno;
         deno1 = deno * r.getDenominator();
      
         return new RationalNumber(num1 + num2, deno1);
      }
   
      public RationalNumber sub(RationalNumber r)
      {
         int num1, num2, deno1;
      
         num1 = num * r.getDenominator();
         num2 = r.getNumerator() * deno;
         deno1 = deno * r.getDenominator();
      
         return new RationalNumber(num1 - num2, deno1);
      }
   
      public RationalNumber mlt(RationalNumber r)
      {
         int num1, deno1;
      
         num1 = num * r.getNumerator();
         deno1 = deno * r.getDenominator();
      
         return new RationalNumber(num1, deno1);
      }
   
      public RationalNumber div(RationalNumber r)
      {
         int num1, deno1;
      
         num1 = num * r.getDenominator();
         deno1 = deno * r.getNumerator();
      
         return new RationalNumber(num1, deno1);
      }
   
      public boolean lt(RationalNumber r)
      {
         double num1, num2;
      
         num1 = (double)num/deno;
         num2 = (double)r.getNumerator()/r.getDenominator();
      
         return (num1 < num2);
      }
   
      public boolean gt(RationalNumber r)
      {
         double num1, num2;
      
         num1 = (double)num/deno;
         num2 = (double)r.getNumerator()/r.getDenominator();
      
         return (num1 > num2);
      }
   
      public boolean eq(RationalNumber r)
      {
         double num1, num2;
      
         num1 = (double)num/deno;
         num2 = (double)r.getNumerator()/r.getDenominator();
      
         return (num1 == num2);
      }
   
      public boolean le(RationalNumber r)
      {
         double num1, num2;
      
         num1 = (double)num/deno;
         num2 = (double)r.getNumerator()/r.getDenominator();
      
         return (num1 <= num2);
      }
   
      public boolean ge(RationalNumber r)
      {
         double num1, num2;
      
         num1 = (double)num/deno;
         num2 = (double)r.getNumerator()/r.getDenominator();
      
         return (num1 >= num2);
      }
   
      public int getNumerator()
      {
         return num;
      }
   
      public int getDenominator()
      {
         return deno;
      }
      
      public String toString()
      {
      if(num == 0)
         return ("0");
      else if(deno == 1)
         return ("" + num);         
      else
         return (num + "/" + deno);  
      }
   
   }