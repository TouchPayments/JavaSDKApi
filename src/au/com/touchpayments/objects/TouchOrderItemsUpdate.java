package au.com.touchpayments.objects;

/**
 * An object to update an order
 * @author Victor Mignot
 * @since 1.0
 *
 */


public class TouchOrderItemsUpdate {
    /**
     * The updated total of the order
     * @since 1.0
     */
    public float grandTotal;
    
    /**
     * The updated shipping costs
     * @since 1.0
     */
    public float shippingCosts;
    
    /**
     * The updated GST
     * @since 1.0
     */
    public float gst;

    /**
     * The updated array of items in the order 
     * @since 1.0
     */
    public TouchItem[] items;

}