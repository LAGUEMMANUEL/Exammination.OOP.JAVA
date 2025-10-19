/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package vu.main.babyfeedingscheudle;

/**
 *
 * @author Emma
 */

public class BabyFeedingSchedule {
    
    public static void main(String[] args) {
        
        //======= Given quantities=======//
         // =========liters========//
         
        double porridgeAvailable = 2.0;
        double milkAvailable = 2.0; // liters//
        
        // Baby's consumption per feeding
        // half cup = 0.25 liters//
        
        double porridgePerFeeding = 0.25; 
        
        //========= full cup = 0.5 liters================//
        double milkPerFeeding = 0.5; 
        
        //======= Time intervals between feedings (minutes)========//
        
        int porridgeInterval = 45;
        int milkInterval = 30;
        
        // =========Finding  remaining quantities and time==================//
        
        double porridgeLeft = porridgeAvailable;
        double milkLeft = milkAvailable;
        int time = 0;
        
        // Simulate the feeding process minute by minute//
        
        while (porridgeLeft > 0 || milkLeft > 0) {
            
            // Check if it's time for porridge feeding
            
            if (porridgeLeft > 0 && time % porridgeInterval == 0) {
                
                porridgeLeft -= porridgePerFeeding;
                
            // Prevent negative//
            
                if (porridgeLeft < 0) porridgeLeft = 0; 

                System.out.println("Time " + time + "min: Fed porridge. Remaining: " + porridgeLeft + "L");
            }
            
            // Check if it's time for milk feeding//
            
            if (milkLeft > 0 && time % milkInterval == 0) {
                
                milkLeft -= milkPerFeeding;
                
            // Prevent negative//
            
                if (milkLeft < 0) milkLeft = 0; 
                System.out.println("Time " + time + "min: Fed milk. Remaining: " + milkLeft + "L");
            }
            
            time++;
            
            // Safety break to prevent infinite loop//
            
            if (time > 24 * 60) { // 24 hours maximum //
                
                System.out.println("Safety break: Exceeded 24 hours");
                break;
            }
        }
        
        // ======Changing total time to hours and minutes========//
        
        int hours = (time - 1) / 60;
        
        // Subtract 1 because we increment time at the end of the loop
        int minutes = (time - 1) % 60;
        
        System.out.println("\n--- Final Results ---");
        System.out.println("Porridge consumed: " + (porridgeAvailable - porridgeLeft) + "L");
        System.out.println("Milk consumed: " + (milkAvailable - milkLeft) + "L");
        System.out.println("Total time to finish both: " + hours + " hours and " + minutes + " minutes");
        
        // Alternative calculation method mathematical approach
        
        calculateMathematically(porridgeAvailable, milkAvailable, porridgePerFeeding, 
                              milkPerFeeding, porridgeInterval, milkInterval);
    }
    
    // Mathematical approach for verification
    
    public static void calculateMathematically(double porridgeAvailable, double milkAvailable,
                                            double porridgePerFeeding, double milkPerFeeding,
                                            int porridgeInterval, int milkInterval) {
        
        System.out.println("\n--- Mathematical Verification ---");
        
        // Calculate number of feedings needed//
        
        int porridgeFeedings = (int) Math.ceil(porridgeAvailable / porridgePerFeeding);
        int milkFeedings = (int) Math.ceil(milkAvailable / milkPerFeeding);
        
        // Calculate time until last feeding starts//
        
        int porridgeTime = (porridgeFeedings - 1) * porridgeInterval;
        int milkTime = (milkFeedings - 1) * milkInterval;
        
        // The total time is determined by whichever food takes longer to finish//
        // accounting for concurrent feeding schedules//
        
        int totalTimeMinutes = Math.max(porridgeTime, milkTime);
        
        
        // Since feedings happen at regular intervals, we need to find when both are completely consumed//
        // This happens at the maximum of the two completion times//
        
        totalTimeMinutes = findCompletionTime(porridgeAvailable, milkAvailable, 
                                            porridgePerFeeding, milkPerFeeding,
                                            porridgeInterval, milkInterval);
        
        int hours = totalTimeMinutes / 60;
        int minutes = totalTimeMinutes % 60;
        
        System.out.println("Mathematical calculation: " + hours + " hours and " + minutes + " minutes");
    }
    
    // More accurate mathematical calculation//
    
    public static int findCompletionTime(double porridgeAmt, double milkAmt,
                                       double porridgePerFeed, double milkPerFeed,
                                       int porridgeInt, int milkInt) {
        
        // Find the LCM of the intervals to determine when schedules align//
        
        int lcm = findLCM(porridgeInt, milkInt);
        
        // Calculate feedings needed//
        
        int pFeedings = (int) Math.ceil(porridgeAmt / porridgePerFeed);
        int mFeedings = (int) Math.ceil(milkAmt / milkPerFeed);
        
        // Time when last feeding starts for each//
        
        int pTime = (pFeedings - 1) * porridgeInt;
        int mTime = (mFeedings - 1) * milkInt;
        
        // Return the maximum time when either food is completely consumed//
        
        return Math.max(pTime, mTime);
    }
    
    // Helper method to find Least Common Multiple//
    
    public static int findLCM(int a, int b) {
        
        return Math.abs(a * b) / findGCD(a, b);
    }
    
    // Helper method to find Greatest Common Divisor//
    
    public static int findGCD(int a, int b) {
        
        if (b == 0) {
            return a;
        }
        
        return findGCD(b, a % b);
    }
}
