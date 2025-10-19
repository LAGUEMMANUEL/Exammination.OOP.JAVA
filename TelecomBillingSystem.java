/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package vu.main.telecombillingsystem;

/**
 *
 * @author Emma
 */

public class TelecomBillingSystem {
    
    public static void main(String[] args) {
        
        // Initial airtime load
        
        double airtimeLoad = 10000; // UGX
        
        // Calculate 10% charge
        
        double serviceCharge = airtimeLoad * 0.10;
        
        // Balance after service charge
        
        double balanceAfterCharge = airtimeLoad - serviceCharge;
        
        // Call details
        
        int callMinutes = 5;
        int callSeconds = callMinutes * 60;
        double callRatePerSecond = 200; // UGX per second
        double callCost = callSeconds * callRatePerSecond;
        
        // Final balance
        
        double finalBalance = balanceAfterCharge - callCost;
        
        // Display results
        
        System.out.println("Airtime loaded: UGX " + airtimeLoad);
        System.out.println("Service charge (10%): UGX " + serviceCharge);
        System.out.println("Balance after charge: UGX " + balanceAfterCharge);
        System.out.println("Call duration: " + callMinutes + " minutes (" + callSeconds + " seconds)");
        System.out.println("Call cost: UGX " + callCost);
        System.out.println("Final balance: UGX " + finalBalance);
        
        
        if (finalBalance < 0) {
            
            System.out.println("Warning: Negative balance! Please top up.");
            
        }
    }
}