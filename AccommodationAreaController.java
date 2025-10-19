/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package vu.main.accommodationareacontroller;

/**
 *
 * @author Emma
 */

// import .

//  QUESTION ONE PART C.

import java.util.Scanner;

public class AccommodationAreaController {
    
    private static String activeArea = "Gym"; 
    private static int gymOccupants = 0;
    private static int swimmingOccupants = 0;
    private static final boolean[] gymLights = {false, false, false}; 
    private static final boolean[] swimmingLights = {false, false, false};

    public static void main(String[] args) {
        
        try (Scanner scanner = new Scanner(System.in)) {
            
            char choice;
            
            do {
                
                //   Display Menu   //
                System.out.println("\n--- Speke Apartments Accommodation Control ---");
                System.out.println("Active Area: " + activeArea);
                System.out.println("S -- Select active area (G = Gym, P = Swimming)");
                System.out.println("W -- Add n occupants");
                System.out.println("X -- Remove n occupants");
                System.out.println("Y -- Switch ON a light (1-3)");
                System.out.println("Z -- Switch OFF a light (1-3)");
                System.out.println("R -- Report status");
                System.out.println("Q -- Quit");
                System.out.print("Enter your choice: ");
                
                choice = scanner.next().toUpperCase().charAt(0);
                
                switch (choice) {
                    
                    case 'S' -> selectArea(scanner);
                    case 'W' -> addOccupants(scanner);
                    case 'X' -> removeOccupants(scanner);
                    case 'Y' -> switchLight(scanner, true);
                    case 'Z' -> switchLight(scanner, false);
                    case 'R' -> reportStatus();
                    case 'Q' -> System.out.println("Thank you for using the system. Goodbye!");
                    default -> System.out.println("Invalid option. Please try again.");
                    
                }
                
            } while (choice != 'Q');
        }
    }

    // ----------selectArea------------//
    
    private static void selectArea(Scanner scanner) {
        
        System.out.print("Select area (G for Gym, P for Swimming): ");
        char area = scanner.next().toUpperCase().charAt(0);
        switch (area) {
            
            case 'G' -> {
                activeArea = "Gym";
                System.out.println("Gym area is now active.");
            }
            case 'P' -> {
                
                activeArea = "Swimming";
                System.out.println("Swimming area is now active.");
            }
            default -> System.out.println("Invalid area selection. Please enter 'G' or 'P'.");
        }
    }

    
    // -----------------addoccupants-----------------------------------//
    
    private static void addOccupants(Scanner scanner) {
        
        System.out.print("Enter number of occupants to add: ");
        if (scanner.hasNextInt()) {
            
            int n = scanner.nextInt();
            
            if (n > 0) {
                if (activeArea.equals("Gym")) {
                    
                    gymOccupants += n;
                } else {
                    
                    swimmingOccupants += n;
                }
                System.out.println(n + " occupant(s) added to the " + activeArea + " area.");
            }
            else {
                
                System.out.println("Please enter a positive integer.");
            }
        } 
        else {
            
            System.out.println("Invalid input. Please enter an integer.");
            scanner.next(); 
        }
    }

    //--------------- removeoccupants--------------//
    
    private static void removeOccupants(Scanner scanner) {
        
        System.out.print("Enter number of occupants to remove: ");
        
        if (scanner.hasNextInt()) {
            
            int n = scanner.nextInt();
            if (n > 0) {
                
                if (activeArea.equals("Gym")) {
                    
                    gymOccupants = Math.max(0, gymOccupants - n);
                } else {
                    swimmingOccupants = Math.max(0, swimmingOccupants - n);
                }
                System.out.println(n + " occupant(s) removed from the " + activeArea + " area.");
            } 
            else {
                
                System.out.println("Please enter a positive integer.");
            }
        } 
        else {
            
            System.out.println("Invalid input. Please enter an integer.");
            scanner.next(); // Clear the invalid input
        }
    }

    // switchlight.
    
    private static void switchLight(Scanner scanner, boolean turnOn) {
        
        System.out.print("Enter light number (1, 2, or 3): ");
        if (scanner.hasNextInt()) {
            int lightNum = scanner.nextInt();
            
            if (lightNum >= 1 && lightNum <= 3) {
                
                boolean[] lights = activeArea.equals("Gym") ? gymLights : swimmingLights;
                lights[lightNum - 1] = turnOn;
                String action = turnOn ? "ON" : "OFF";
                System.out.println("Light " + lightNum + " in the " + activeArea + " area is switched " + action + ".");
            }
            else {
                
                System.out.println("Invalid light number. Please enter 1, 2, or 3.");
            }
        } 
        else {
            
            System.out.println("Invalid input. Please enter an integer.");
            scanner.next(); 
        }
    }

    // -----------resport stutus------------------------//
    
    private static void reportStatus() {
        
        System.out.println("\n--- Status Report ---");
        System.out.println("Area: Gym");
        System.out.println("  Occupants: " + gymOccupants);
        System.out.println("  Lights: 1-" + (gymLights[0] ? "ON" : "OFF") +
                ", 2-" + (gymLights[1] ? "ON" : "OFF") +
                ", 3-" + (gymLights[2] ? "ON" : "OFF"));

        // --------------system.out.println---------------//
        
        System.out.println("Area: Swimming");
        System.out.println("  Occupants: " + swimmingOccupants);
        System.out.println("  Lights: 1-" + (swimmingLights[0] ? "ON" : "OFF") +
                ", 2-" + (swimmingLights[1] ? "ON" : "OFF") +
                ", 3-" + (swimmingLights[2] ? "ON" : "OFF"));
    }
}