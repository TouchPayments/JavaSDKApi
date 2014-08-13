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
    protected float grandTotal;
    
    /**
     * The updated shipping costs
     * @since 1.0
     */
    protected float shippingCosts;
    
    /**
     * The updated GST
     * @since 1.0
     */
    protected float gst;

    /**
     * The updated array of items in the order 
     * @since 1.0
     */
    protected TouchItem[] items;

    public float getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(float grandTotal) {
        this.grandTotal = grandTotal;
    }

    public float getShippingCosts() {
        return shippingCosts;
    }

    public void setShippingCosts(float shippingCosts) {
        this.shippingCosts = shippingCosts;
    }

    public float getGst() {
        return gst;
    }

    public void setGst(float gst) {
        this.gst = gst;
    }

    public TouchItem[] getItems() {
        return items;
    }

    public void setItems(TouchItem[] items) {
        this.items = items;
    }
}