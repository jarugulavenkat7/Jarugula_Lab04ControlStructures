/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package starbucks;

/**
 *
 * @author Venkat Sai Jarugula
 */
public class Starbucks {
    private String customerName;
    private String address;
    private String contactNumber;
    private String customerType;
    private String billReciept;
    private double billAmount;
    private String order;
    private static int orderNumber = 1;

    /**
     * Constructs Starbucks with the given customerName, address, contactNumber 
     * and customerType
     * @param customerName Name of the Customer
     * @param address Address of the Customer
     * @param contactNumber Contact Number of the Customer 
     * @param customerType Type of the Customer
     */
    public Starbucks(String customerName, String address, String contactNumber,
            String customerType) {
        this.customerName = customerName;
        this.address = address;
        this.contactNumber = contactNumber;
        this.customerType = customerType;
        this.billReciept = "";
        this.billAmount = 0;
        this.order = "";
    }

    /**
     * Returns the customer name
     * @return Returns the customer name
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * Sets the customer name
     * @param customerName The customerName to set
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * Returns the address of the customer
     * @return Returns the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the address of the customer
     * @param address The address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Returns the contact number of the customer
     * @return Returns the contact number
     */
    public String getContactNumber() {
        return contactNumber;
    }

    /**
     * Sets the contact number of the customer
     * @param contactNumber The contactNumber to set
     */
    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    /**
     * Returns the customer type
     * @return Returns the customer type
     */
    public String getCustomerType() {
        return customerType;
    }

    /**
     * Sets the customer type
     * @param customerType The customerType to set
     */
    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    /**
     *  Returns the bill receipt of the customer
     * @return Returns the bill receipt
     */
    public String getBillReciept() {
        return billReciept;
    }

    /**
     * Sets the bill receipt of the customer
     * @param billReciept The billReciept to set
     */
    public void setBillReciept(String billReciept) {
        this.billReciept = billReciept;
    }

    /**
     * Returns the bill amount of the customer 
     * @return Returns the bill amount
     */
    public double getBillAmount() {
        return billAmount;
    }

    /**
     * Sets the bill amount of the customer
     * @param billAmount the billAmount to set
     */
    public void setBillAmount(double billAmount) {
        this.billAmount = billAmount;
    }

    /**
     * Returns the order of the customer
     * @return Returns the order
     */
    public String getOrder() {
        return order;
    }

    /**
     * Sets the order of the customer
     * @param order The order to set
     */
    public void setOrder(String order) {
        this.order = order;
    }

    /**
     * Returns the Initials of the customer separated by a dot.For example
        Customer name: margaret Mary emily Anne Hyra
        Return value: M.M.E.A.H.

     * @return Returns the Initials of the customer separated by a dot
     */
    public String getNameInitials(){
               String finalString=customerName.substring(0, 1).toUpperCase().concat(".");
               for(int index=0;index<customerName.length();index++){
                   String s=customerName.substring(index,index+1 );
                   if(s.equals(" ")){
                       
                     finalString=finalString.concat(customerName.substring(index+1,index+2).toUpperCase()+".");
               }
        
        
               }
               return finalString;
    }
    /**
     * Returns the item name by taking item number as a parameter 
     * @param itemNumber unique id for the item
     * @return Returns the item name
     */
    private  String getItemName(int itemNumber){
        String itemName="";
       switch(itemNumber) {
        case 1:
        itemName="Ham & Swiss Panini";
        break;
        case 2:
        itemName="Cheese & Fruit Bistro Box";
        break;
        case 3:
        itemName="Turkey Pesto Panini";
        break;
        case 4:
        itemName="Salted Caramel or Birthday Cake Pop";
        break;
        case 5:
        itemName="Roasted Tomato & Mozzarella Panini";
        break;
       }
        return itemName;
    }
/**
 * Returns the item cost by taking the item number as a parameter 
 * @param itemName Name of the item
 * @return Returns the item cost
 */
    private double getItemCost(String itemName){
        double itemCost = 0;
       switch(itemName) {
        case "Ham & Swiss Panini":
        itemCost = 5.25;
        break;
        case "Cheese & Fruit Bistro Box":
        itemCost = 4.95;
        break;
        case "Turkey Pesto Panini":
        itemCost = 5.96;
        break;
        case "Salted Caramel or Birthday Cake Pop":
        itemCost = 3.50;
        break;
        case "Roasted Tomato & Mozzarella Panini":
        itemCost = 3.46;
        break;
       }
        return itemCost;
        
    }

    /**
     * Updates the receipt with the given item and quantity
     * @param quantity quantity of the item
     * @param itemNumber unique id for the item
     */
    public void updateReceipt(int quantity,int itemNumber){
        String calculateLength=getItemName(itemNumber)+
                    "("+getItemCost(getItemName(itemNumber))+")"+"*"+quantity+" = ";
     
        String calculationString=getItemName(itemNumber)+
                    "("+getItemCost(getItemName(itemNumber))+")"+" ".repeat(48-calculateLength.length())+"*"+quantity+" = "
                    +String.format("%.2f",Math.round((getItemCost(getItemName(itemNumber))*quantity)*100)/100.0)+"\n";
        billAmount =billAmount+getItemCost(getItemName(itemNumber))*quantity;
        if(billReciept.isEmpty()){
            billReciept="\nThe Following is the bill for purchased products\n"+calculationString;
        }
        else{
           billReciept= billReciept+calculationString;
        }
        
       
    }
    /**
     * Returns the discount according to the customer type
     * @return Returns the discount
     */
    private double getDiscount(){
       double discount=0;
        if(customerType.equals("Regular") && billAmount>10){
           return Math.round((billAmount*(10/100.0))*100)/100.0;
            }
        return discount;
    }
    /**
     * Calculates and returns the sales tax
     * @return Returns the sales tax
     */
    private double getSalesTax(){
        return Math.round((billAmount*(8/100.0))*100)/100.0;
    }

    /**
     * Calculates and returns the final bill amount
     * @return Returns the final bill amount
     */
    public double getFinalBillAmount(){
        return Math.round((billAmount+getSalesTax()-getDiscount())*100)/100.0;
    }
    /**
     * Returns the final bill receipt
     * @return  Returns the final bill receipt
     */
    private String getFinalBillReciept(){
        return billReciept+
        "                                    Sales Tax = "+getSalesTax()+ 
        "\n                                     discount = -"+getDiscount()+   
        "\n-------------------------------------------------------"+
        "\n                                   Total Bill = "+getFinalBillAmount()+
        "\n-------------------------------------------------------";
               
                
    }
    /**
     * Returns the order number with initials
     * @return Returns the order number with initials
     */
    private String getOrderWithName(){
        
      return "Order - "+(orderNumber++)+" by "+ getNameInitials();
}
    /**
     * Returns the contact details of the customer
     * @return Returns the contact details of the customer
     */
    private String getContactDetails(){
        return "\nAddress: "+address+"\nContact: "+contactNumber;
    }
    /**
     * Calculates and returns the balance to a customer with the minimum notes 
     * and coins by taking cash paid by customer as a the parameter.
     * Available money denominations are ($50, $10, $5, $1, $0.25, $0.10, $0.05, $0.01)
     * @param cashPaid
     * @return Returns the balance amount to the customer
     */
    private String getBalance(double cashPaid){
        String balanceString="\nChange received is as follow ";
        //double remainingBalance=0;
        double remainingBalance=Math.round((cashPaid-getFinalBillAmount())*100)/100.0;
        if(remainingBalance!=0 && remainingBalance>=50){
            int numberOfFifties=(int)(remainingBalance/50);
            remainingBalance=remainingBalance-50*numberOfFifties;
            
            //balanceString=balanceString+"\n$50.00  * "+numberOfFifties+" = "+50.00*numberOfFifties;
            balanceString=  numberOfFifties!=0 ?     (balanceString+"\n$50.00   * "+numberOfFifties+" = "+String.format("%.2f", 50.00*numberOfFifties)) : "";
            
        }if(remainingBalance!=0 && remainingBalance>=10){
                        int  numberOfTens=(int) remainingBalance/10;
                        remainingBalance=remainingBalance-10*numberOfTens;
                       
                 
                balanceString=  numberOfTens!=0 ?     (balanceString+"\n$10.00  * "+numberOfTens+" = "+String.format("%.2f",10.00*numberOfTens)) : ""  ;
                }
                if(remainingBalance!=0 && remainingBalance>=5){
                        int numberOfFives=(int) remainingBalance/5;
                            remainingBalance=remainingBalance-5*numberOfFives;
                            
                 
                     balanceString=  numberOfFives!=0 ?     (balanceString+"\n$5.00   * "+numberOfFives+" = "+String.format("%.2f",5.00*numberOfFives)) : ""  ;
                }            
                    
                if(remainingBalance!=0 && remainingBalance>=1){
                        int numberOfOnes=(int) remainingBalance/1;
                            remainingBalance=remainingBalance-1*numberOfOnes;
                            
                 
                            balanceString= numberOfOnes!=0? (balanceString+"\n$1.00   * "+numberOfOnes+" = "+String.format("%.2f",1.00*numberOfOnes)):"";
                           
                }    
                if(remainingBalance!=0 && remainingBalance>=0.25){
                        int numberOfQuaters=(int)(remainingBalance/0.25);
                            remainingBalance=remainingBalance-0.25*numberOfQuaters;
                           balanceString= numberOfQuaters!=0? (balanceString+"\n$0.25   * "+numberOfQuaters+" = "+String.format("%.2f",0.25*numberOfQuaters)):"";
                           
                }    
                if(remainingBalance!=0 && remainingBalance>=0.10){
                        int numberOfDimes= (int)(remainingBalance/0.10);
                            remainingBalance=remainingBalance-0.10*numberOfDimes;
                            
                 
                            balanceString= numberOfDimes!=0? balanceString+"\n$0.10   * "+numberOfDimes+" = "+String.format("%.2f",0.10*numberOfDimes):"";
                           
                }    
                if(remainingBalance!=0 && remainingBalance>=0.05){
                        int numberOfFiveCents=(int)(remainingBalance/0.05);
                            remainingBalance=remainingBalance-0.05*numberOfFiveCents;
                            
                 
                            balanceString= numberOfFiveCents!=0? balanceString+"\n$0.05   * "+numberOfFiveCents+" = "+String.format("%.2f",0.05*numberOfFiveCents):"";
                           
                }    
                if(remainingBalance!=0 && remainingBalance>=0.01){
                        int numberOfOneCents=(int)(remainingBalance/0.01);
                        
                
                            remainingBalance= remainingBalance-0.01*numberOfOneCents;
                            
                           balanceString=numberOfOneCents!=0?balanceString+"\n$0.01   * "+numberOfOneCents+" = "+String.format("%.2f",0.01*numberOfOneCents):"";
                }
                   
                   

                    
        return balanceString+"\n--------------------"+"\n  Total Bal = "+Math.round((cashPaid-getFinalBillAmount())*100)/100.0+"\n--------------------";
 


    }


    /**
     * Returns the customer details and final bill receipt in given format 
     * @return Returns the customer details and final bill receipt in given format 
     */
    @Override
    public String toString() {
    return    getOrderWithName()+
       getContactDetails()+
       getFinalBillReciept();



    }

   /**
    * Prints the receipt by taking cash paid by customer as parameter
    * @param cashPaid cash paid by the customer
    */
    public void printReciept(double cashPaid ){
        System.out.println("***************************************\n"+toString()+getBalance(cashPaid));
       
    }
}