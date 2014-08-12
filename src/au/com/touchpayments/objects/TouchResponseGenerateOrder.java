package au.com.touchpayments.objects;

/**
 * 
 * @author Victor Mignot
 * @since 1.0
 *
 */
public class TouchResponseGenerateOrder {
    /**
     * The token of the order, to retrieve it later
     * @since   1.0
     */
    public String token;
    
    /**
     * The fees for the customer
     * @since   1.0
     */
    public float customerFee;
    
    /**
     * Has an approval SMS been sent?
     * @since   1.0
     */
    public boolean approvalSmsSent;


    /**
     * Has an activation SMS been sent?
     * @since   2.0
     */
    public boolean activationSmsSent;

    @Override
    public String toString() {
        return "TouchResponseGenerateOrder [token=" + token + ", customerFee="
                + customerFee + ", approvalSmsSent=" + approvalSmsSent
                + ", getClass()=" + getClass() + "]";
    }
}
