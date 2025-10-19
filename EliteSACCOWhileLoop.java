/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package vu.main.elitesaccowhileloop;

/**
 *
 * @author Emma
 */

// while loop...

public class EliteSACCOWhileLoop {
    
    public static void main(String[] args) {
        
        // ==========Example principal amount===================//
        
        double principal = 100000;
        
        //====== =========5% interest rate===================//
        
        double rate = 0.05; 
        
        // ============Example time frame in years=========//
        
        int time = 5; 

        double investmentValue = principal;
        int year = 1;
        while (year <= time) {
            
            //=========== Calculate interest annually=======//
            
            year++;
            investmentValue += investmentValue * rate; 
        }
        System.out.printf("The value of the investment after %d years is: UGX %.2f%n", time, investmentValue);
    }
}
