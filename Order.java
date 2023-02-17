/*
 * Assignment: Project 4
 * Description: I am creating a restraunt menu in which the user will order food and the total
 * accumulate until the order is finished. Then the user will be given an option to provide
 * a tip
 * Name: Dani Luna
 * ID: 921793519
 * Class: CSC 210-01
 * Semester: Spring 2022
 */


import java.util.Scanner;

public class Order {

    public static void main(String[] args) {

        // Set up scanner object
        Scanner input = new Scanner(System.in);

        System.out.println("नमस्ते! Welcome to Himalayan Kitchen.");

        // Declare food on the menu with string and integer data types
        int momoPrice = 12;
        String momo = "1. Pork Momo--$" + momoPrice + ".00";
        int choilaPrice = 11;
        String choila = "2. Chicken Choila--$" + choilaPrice + ".00";
        int biryaniPrice = 9;
        String biryani = "3. Vegetarian Biryani--$" + biryaniPrice + ".00";
        System.out.println();

        // This will trigger the loop
        int order = 1;

        // Declare other objects
        // total and choice are intialized to 0 and null however they will change
        int total = 0;
        String choice = null;
        double totalTaxed = 0;
        double totalTaxedTip = 0;
        // For this project I will use the Berkeley tax rate
        double taxRate = 0.1025;

        // This loop will keep displaying the menu until the order equals 0
        while (order != 0) {
            //Display menu
            System.out.println("Here is our menu:");
            // Print premade string variables
            System.out.println(momo);
            System.out.println(choila);
            System.out.println(biryani);
            // Prompt user to order
            System.out.println("please choose one option (1-3) at a time using the number 0 to end the order");
            order = input.nextInt();
            // This method will be called to compute the total
            // I will pass over these parameters to carry over the order number and prices associated
            // I have set the total += to the method call because the value returned will be the
            // total computed in the called method and will accumulate until the order = 0
            total += menu_received(order, momoPrice, choilaPrice, biryaniPrice);

            // These print statements will confirm the total with the user based on what is ordered
            if (order == 1) {
                // This is where my String choice changes from null
                choice = "Pork Momo";
                System.out.println();
                System.out.println("Thank you for ordering " + choice);
                // the total that is returned from the menu_received method will print out and accumulate
                System.out.println("Your total is: $" + total + ".00");
                System.out.println();

            }
            else if (order == 2) {
                choice = "Chicken Choila";
                System.out.println();
                System.out.println("Thank you for ordering " + choice);
                System.out.println("Your total is: $" + total + ".00");
                System.out.println();
            }
            else if (order == 3) {
                    choice = "Vegearian Biryani";
                System.out.println();
                System.out.println("Thank you for ordering " + choice);
                System.out.println("Your total is: $" + total + ".00");
                System.out.println();
                }
            else {
                if (order == 0) {
                    // When the user enters 0, the loop will end but the user prompted to answer the following
                    // questions displayed by the print statements
                    // compute the total with tax
                    totalTaxed = (taxRate * total) + total;
                    System.out.println();
                    System.out.println("Thank you for ordering.");
                    // Use the Math.round class method to keep the nearest 2 decimal places
                    System.out.println("Your total with tax is: $" + (double) Math.round(totalTaxed * 100)/100.0);
                    System.out.println();

                    // initialize the totaltaxedtip variable
                    // to totaltaxed + the tip_calculator method call where the tip will be generated
                    // Doing so will return the tip computed and add on to the taxed total giving
                    // a more accurate total if the user wants to give a tip
                    totalTaxedTip = tip_calculator(total) + totalTaxed;

                    System.out.println("Your total after tax and tip is: $" + totalTaxedTip);
                    System.out.println("Thank you for ordering.");
                }
            }
            }

        }

    public static int menu_received(int order, int momo, int choila, int biryani) {
        // The purpose of this method is to proccess the order received and determine what
        // the total will be based on the order passed over

        // menuprice is a value I am going to return
        int menuPrice = 0;

        // I created these conditional statements to generate menu price and total depending on order
        // example: if the user ordered number one, menu price will be set to the price of pork momo
        // which I passed over and will be returned to the main method to further compute the total
        if (order == 1) {
            menuPrice = momo;
        }
        else if (order == 2) {
            menuPrice = choila;
        }
        else {
            if (order == 3) {
                menuPrice = biryani;
            }
        }
        return menuPrice;
    }

    public static double tip_calculator(int total) {
        // Set up scanner object
        Scanner input = new Scanner(System.in);

        // newTotal is a value I am going to return and it will change
        // based on a few conditions
        // so intialize it to 0
        double newTotal = 0;

        // Initialize computed tip amounts
        double percent10 = (0.10 * total);
        double percent15 = (0.15 * total);
        double percent20 = (0.20 * total);
        String ten = "1. tip 10% = $" + percent10;
        String fifteen = "2. tip 15% = $" + percent15;
        String twenty = "3. tip 30% = $" + percent20;

        // now display tip options
        System.out.println("Suggested Gratuity");
        System.out.println("please choose one option (1-3)");
        System.out.println(ten);
        System.out.println(fifteen);
        System.out.println(twenty);
        // initialize the choices provided to the user input
        int tipChoice = input.nextInt();

        // Based on the choice, set the new total equal to the computed tip amounts
        if (tipChoice == 1) {
            newTotal = percent10;
            return (double) Math.round(newTotal * 100)/100.0;
        }
        else if (tipChoice == 2) {
            newTotal = percent15;
           return (double) Math.round(newTotal * 100)/100.0;
        }
        else {
            if (tipChoice == 3) {
                newTotal = percent20;
                return (double) Math.round(newTotal * 100)/100.0;
            }
        }
        // Use the Math.round class method to keep the nearest 2 decimal places
        return (double) Math.round(newTotal * 100)/100.0;
    }


}