/**
@author : Jeff DeSain, John Le
Due: 4/22/14
Lab 3
This program simulates a calculator
*/

   public interface RationalExpressions
   {
   
      public RationalNumber add(RationalNumber r);
      public RationalNumber sub(RationalNumber r);
      public RationalNumber mlt(RationalNumber r);
      public RationalNumber div(RationalNumber r);
      public boolean lt(RationalNumber r);
      public boolean gt(RationalNumber r);
      public boolean eq(RationalNumber r);
      public boolean le(RationalNumber r);
      public boolean ge(RationalNumber r);
      public int getNumerator();
      public int getDenominator();
   }