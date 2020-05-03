package com.as.samples;

// package com.wrox.util;
// From "Professional Java Server Programming", Patzer et al.,

public class loanTools
{
   public static float stringToFloat(String inputString)
          throws NumberFormatException
   {
      Float f = new Float(inputString);
      return f.floatValue();
   }

   public static int calculateLoanPeriod (float principal, float interest, float payment)
          throws IllegalArgumentException
   {
      int months = 0;

      float balance = principal;

      // quick and dirty loop to calculate the loan period
      while (balance > 0)
      {
         balance += ((balance * interest) / 12);  //  Add interest
         balance -= payment;                      //  Subtract payment
         months  += 1;                            //  Increment months
         // check to see if the repayments are working,
         // or if the interest is pushing the balance up higher
         if (balance >= principal)
         {
            throw new IllegalArgumentException("The values entered will "
                       + "not ever allow the loan to be paid off.");
         }
      }
      return months;
   }
}