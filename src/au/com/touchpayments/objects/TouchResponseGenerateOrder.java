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
    protected String token;
    
    /**
     * The fees for the customer
     * @since   1.0
     */
    protected float customerFee;
    
    /**
     * Has an approval SMS been sent?
     * @since   1.0
     */
    protected boolean approvalSmsSent;


    /**
     * Has an activation SMS been sent?
     * @since   2.0
     */
    protected boolean activationSmsSent;

    @Override
    public String toString() {
        return "TouchResponseGenerateOrder [token=" + getToken() + ", customerFee="
                + getCustomerFee() + ", approvalSmsSent=" + isApprovalSmsSent()
                + ", getClass()=" + getClass() + "]";
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public float getCustomerFee() {
        return customerFee;
    }

    public void setCustomerFee(float customerFee) {
        this.customerFee = customerFee;
    }

    public boolean isApprovalSmsSent() {
        return approvalSmsSent;
    }

    public void setApprovalSmsSent(boolean approvalSmsSent) {
        this.approvalSmsSent = approvalSmsSent;
    }

    public boolean isActivationSmsSent() {
        return activationSmsSent;
    }

    public void setActivationSmsSent(boolean activationSmsSent) {
        this.activationSmsSent = activationSmsSent;
    }
}
