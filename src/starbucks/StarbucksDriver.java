/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package starbucks;

import java.util.Scanner;

/**
 *
 * @author Venkat Sai Jarugula
 */
public class StarbucksDriver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         Scanner scanner= new Scanner(System.in);
        System.out.println("***** Welcome to Starbucks *****");
        
       String orderMore="";
   do{
          
        System.out.print("\nPlease enter the full name (Firstname Lastname): ");
        String customerName=scanner.nextLine();
        if(customerName.isEmpty()){
            System.out.print("Please enter the name");
            customerName=scanner.nextLine();
        }
        System.out.print("Please enter the Address: "); 
        String address=scanner.nextLine();
         if(address.isEmpty()){
            System.out.print("Please enter the Address:");
            address=scanner.nextLine();
        }
        System.out.print("Please enter Contact Number: ");
        String contactNumber=scanner.nextLine();
          if(contactNumber.isEmpty()|| contactNumber.length()!=10 ){
               System.out.print("Please enter Contact Number: ");
                contactNumber=scanner.nextLine();
          }
        System.out.print("Please enter Customer Type(Regular/New): ");
 
        String customerType=scanner.nextLine();
         if(!(customerType.equals("Regular")|| customerType.equals("New")) ){
               System.out.print("Please enter Customer Type(Regular/New): ");
                customerType=scanner.nextLine();
          }
        Starbucks starbucks = new Starbucks(customerName, address, contactNumber, customerType);
        System.out.println("\n!*!*!*!*! Welcome Board "+customerName+" !*!*!*!*!");
        String continueTransaction="";
        do{
        System.out.println("\nSelect items from following list"+
	"\n    1.Ham & Swiss Panini"+
	"\n    2.Cheese & Fruit Bistro Box"+
	"\n    3.Turkey Pesto Panini"+
	"\n    4.Salted Caramel or Birthday Cake Pop"+
	"\n    5.Roasted Tomato & Mozzarella Panini");
        int itemNumber=scanner.nextInt();
        if(!(itemNumber>=1 && itemNumber<=5)){
            System.out.println("Please choose the number 1 to 5");
            itemNumber=scanner.nextInt();
        }
    
        System.out.print("Enter the quantity: ");
        int quantity= scanner.nextInt();
        starbucks.updateReceipt(quantity, itemNumber);
        System.out.print("Do you want to add one more item(Y/N))? ");
        continueTransaction=scanner.next();
        
        }while(continueTransaction.equals("Y"));
        


        System.out.println("Bill amount is "+starbucks.getFinalBillAmount());
        System.out.print("Enter the cash paid: $");
        double cashPaid=scanner.nextDouble();
        starbucks.printReciept(cashPaid);
        System.out.println("***************************************");
        System.out.print("Do you want add one more order(Y/N))? ");
        orderMore=scanner.next();
        scanner.nextLine();
        }while(orderMore.equals("Y"));

        scanner.close();
        System.out.println("Thank you!");
    }
    
}
