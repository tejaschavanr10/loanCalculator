package com.as.samples;

import java.io.IOException;
import java.text.DecimalFormat;

//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
import javax.servlet.*;
import javax.servlet.http.*;
/**
 * Servlet implementation class pageOneProcess
 */
//@WebServlet("/pageOneProcess")
public class LoanCalculator extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static DecimalFormat x = new DecimalFormat("0.00");
       
    /**
     * @see HttpServlet#HttpServlet()
     */

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	// retrieve parameter values as strings	
	String amountstring = request.getParameter("amount");
	String ratestring = request.getParameter("rate");
	String periodstring = request.getParameter("period");
	
	double principal = Double.parseDouble(amountstring);
	double interest_rate = Double.parseDouble(ratestring);
    int period = Integer.parseInt(periodstring);
	
    
	int payment_no = 0;
	double installment,interest,principal_amount,outstanding_balance,mRate,powers;
	String[][] Messages = new String[period][5];
	
	
	if (interest_rate == 0) {
		mRate = 1;
		powers = Math.pow(1 + mRate, period);
		installment = (principal ) * powers / (powers - 1);
    	} 
	else {
    	mRate = (interest_rate)/1200.0;
    	powers = Math.pow(1 + mRate, period);
    	installment = (principal * mRate) * powers / (powers - 1);
    	}
	
	
    for (int i = 1; i <= period; i++){//loop for monthly calculation
    	
    	double denominator = (Math.pow((1 + mRate), (1 + period - i)));
    	
    	principal_amount = installment / denominator;
    	interest = installment - principal_amount;//interest paid for the current month
    	outstanding_balance = mRate == 0 ? principal_amount : (interest/mRate) - principal_amount;
    	payment_no++;//number indication for payment made
    	
   		
   		Messages[i-1][0] = Integer.toString(payment_no);
   		Messages[i-1][1] = x.format(principal_amount);
   		Messages[i-1][2] = x.format(interest);
   		Messages[i-1][3] = x.format(outstanding_balance);
   		Messages[i-1][4] = x.format(installment);
 
   	 }	   
    
    
    
    String htmlResponse;
    html h = new html("Loan Calculator: Results\n");
    h.add(html.HEADING, "Loan Calculator Results", false);
    h.add(html.LINE, "", false);
    h.add(html.NORMAL, "Principal Amount: $", false);
    h.add(html.NORMAL, Double.toString(principal), true);
    h.add(html.NORMAL, "Interest:  ", false);
    h.add(html.NORMAL, Double.toString(interest_rate), true);
    h.add(html.NORMAL, "Months Until Payoff: ", false);
    h.add(html.NORMAL, Integer.toString(period), true);
    htmlResponse = h.getPage();
	
    request.getSession().setAttribute("amount", principal);
	request.getSession().setAttribute("rate", interest_rate);
	request.getSession().setAttribute("period",period );
	request.getSession().setAttribute("op",htmlResponse );
	request.getSession().setAttribute("messageList", Messages);
	
	response.sendRedirect("jsp/Results.jsp");
	
	
	
	
	}
	
//	private void handleError (Exception e, HttpServletResponse response)   {
//	      // You can use response.setStatus () here to inform the client's browser
//	      // that this response represents an error, not a successful request
//	      // response.setStatus (400);
//	      response.setContentType ("text/html");
//	      try
//	      {
//	         //PrintWriter out = response.getWriter ();
//
//	         html h = new html("Loan Calculator: Error");
//	         h.add(html.HEADING, "An error has occurred...", false);
//	         h.add(html.LINE, "", false);
//	         h.add(html.NORMAL, e.getMessage(), false);
//	         //out.println(h.getPage());
//	         //out.close();
//	      }
//	      catch (Exception e1)
//	      {  // had to add this catch as exception needs to be handled.
//	         e1.printStackTrace();
//	      }
//	   }

}
