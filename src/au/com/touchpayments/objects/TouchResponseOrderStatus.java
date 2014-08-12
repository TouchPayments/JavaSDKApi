package au.com.touchpayments.objects;

import java.util.Arrays;

/**
 * This object is used to follow the status of an order
 * An order is supposed to follow a defined workflow
 * pending (2), approved (3), shipped (4), active (5)  
 * Other status can be:
 * returnApprovalPending (14), returned (15), returnDenied (20) or cancelled (16)    
 * 
 * @author Victor Mignot
 * @since 1.0
 *
 */
public class TouchResponseOrderStatus {
    /**
     * The status of the order
     */
    public String status;
    
    /**
     * The status code of the order
     */
    public int statusCode;
    
    /**
     * If cancelled, the reason of the cancellation
     */
    public String reasonCancelled;

    /**
     * The reference of the order
     */
    public String refNumber;

    /**
     * The reference of the order merchant side
     */
    public String merchantRefNumber;

    /**
     * 
     */
    public float fee;
    
    /**
     * 
     */
    public TouchResponseOrderItemsStatus[] items;

    /**
     * Label of the shipping method
     */
    public String shippingMethodLabel;
    /**
     * Extension fees for this order
     * @since 2.0
     */
    public float extensionFee;

    @Override
    public String toString() {
        return "TouchResponseOrderStatus [status=" + status + ", statusCode="
                + statusCode + ", reasonCancelled=" + reasonCancelled
                + ", refNumber=" + refNumber + ", merchantRefNumber="
                + merchantRefNumber + ", fee=" + fee + ", items="
                + Arrays.toString(items) + ", getClass()=" + getClass() + "]";
    }

}
