/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package vu.main.mirrorfocallenght;

/**
 *
 * @author Emma
 */

// import ...

// QUESTION TWO PART B...

import java.util.Scanner;

public class MirrorFocalLenght {
    
    public static void main(String[] args) {
        double u;
        double v;
        
        try (Scanner sc = new Scanner(System.in)) {
            
            System.out.print("Enter object distance u (in cm, positive value will be converted to negative): ");
            u = sc.nextDouble();
            System.out.print("Enter image distance v (in cm, positive for real images): ");
            v = sc.nextDouble();
        }

      
        
        if (v <= 0) {
            System.out.println("Error: Image distance (v) must be positive for real images.");
            return;
        }
        
   
        
        u = -Math.abs(u);
        System.out.println("Using object distance u = " + u + " cm (negative for concave mirror)");

        
        if (v == 0 || u == 0) {
            
            System.out.println("Error: Object or image distance cannot be zero.");
            return;
        }

        // Calculate focal length using mirror formula: 1/f = 1/v + 1/u   //
        
        double invF = (1.0 / v) + (1.0 / u);
        
        if (invF == 0) {
            
            System.out.println("Error: Cannot calculate focal length (1/f = 0).");
            return;
        }
        
        double f = 1.0 / invF;

        System.out.printf("Calculated focal length f = %.4f cm%n", f);

        // Check if focal length is in acceptable range (9.0 to 11.0 as per exam question) //
        
        if (f >= 9.0 && f <= 11.0) {
            
            System.out.println("Mirror is ACCEPTABLE (f between 9.0 cm and 11.0 cm inclusive).");
        } 
        else {
            
            System.out.println("Mirror is NOT acceptable (f outside 9.0-11.0 cm).");
            
        }
    }
}
        