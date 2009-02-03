package uk.co.exahertz.friendlysociety.core;

/**
 *
 * Describe a method of payment
 * For now each different method of payment is identified
 * by the "name" field, later if more information to store then make this class
 * abstract and create child classes 
 * (e.g DirectDebitPayment extends MethodOfPayment)
 * but prefer to keep it simple now.
 * 
 * @author gp79
 */
public class MethodOfPayment {

    //static field to set possible values
    //If more information to store then make this class abstract and
    //create child classes, but I prefer to keep it simple now.
    public static final String CASH = "Cash";
    public static final String DIRECT_DEBIT = "Direct debit";
    
    // The name of the payment method:
    private String name;
    
    /**
     * 
     * @param name the name of the payment method
     */
    public MethodOfPayment(String name){
        
        //check if name provided
        if (name == null) throw new IllegalArgumentException(" The name of the" +
                "payment method must be provided");
        
        //Check right name for the method of payment:
        if ( !( name.equals(CASH) || name.equals(DIRECT_DEBIT) ))
            throw new IllegalArgumentException(" This method of payment " +
                    "doesn't exist");
        this.name = name;
    }

    /**
     * 
     * @return The name of the method of payment
     */
    public String getName() {
        return name;
    }

    
    
}
