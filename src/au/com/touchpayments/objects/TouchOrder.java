package au.com.touchpayments.objects;

import java.util.Arrays;


/**
 * 
 * @author Victor Mignot
 * @since 1.0
 *
 */
public class TouchOrder {
    /**
     * The total amount of the order, in AUD, GST included
     * @since 1.0
     */
    public float grandTotal;
    
    /**
     * The shipping cost 
     * @since 1.0
     */
    public float shippingCosts;

    /**
     * The GST of the order in AUD. 
     * @since 1.0
     */
    public float gst;

    /**
     * The array of items included in this order
     * {@link TouchItem}
     * @since 1.0
     */
    public TouchItem[] items;

    /**
     * The address of shipping
     * {@link TouchAddress}
     * @since 1.0
     */
    public TouchAddress addressShipping;

    /**
     * The address of billing
     * {@link TouchAddress}
     * @since 1.0
     */
    public TouchAddress addressBilling;

    /**
     * The customer that has made the order
     * {@link au.com.touchpayments.objects.TouchCustomer}
     * @since 1.0
     */
    public TouchCustomer customer;

        
    /** 
     * Extending days for this order
     * @since 1.1
     */
    public int extendingDays;

    @Override
    public String toString() {
        return "TouchOrder [grandTotal=" + grandTotal + ", shippingCosts="
                + shippingCosts + ", gst=" + gst + ", items="
                + Arrays.toString(items) + ", addressShipping="
                + addressShipping + ", addressBilling=" + addressBilling
                + ", customer=" + customer + ", extendingDays=" + extendingDays
                + "]";
    }
}
