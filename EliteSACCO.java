/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package vu.main.elitesacco;

/**
 *
 * @author Emma
 */
// FORLOOP....


public class EliteSACCO {
    
    public static void main(String[] args) {
        
        double principal = 100000; // Example principal amount
        double rate = 0.05;
        
// =====5% interest rate============//

        int time = 5; 
        
//======== Example time frame in years========//

        double investmentValue = principal;
        for (int year = 1; year <= time; year++) {
            
    //========= Calculate interest annually========//
            
            investmentValue += investmentValue * rate;
            
        }
        System.out.printf("The value of the investment after %d years is: UGX %.2f%n", time, investmentValue);
    }
}
