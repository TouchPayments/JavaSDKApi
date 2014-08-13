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
    protected float grandTotal;
    
    /**
     * The shipping cost 
     * @since 1.0
     */
    protected float shippingCosts;

    /**
     * The GST of the order in AUD. 
     * @since 1.0
     */
    protected float gst;

    /**
     * The array of items included in this order
     * {@link TouchItem}
     * @since 1.0
     */
    protected TouchItem[] items;

    /**
     * The address of shipping
     * {@link TouchAddress}
     * @since 1.0
     */
    protected TouchAddress addressShipping;

    /**
     * The address of billing
     * {@link TouchAddress}
     * @since 1.0
     */
    protected TouchAddress addressBilling;

    /**
     * The customer that has made the order
     * {@link au.com.touchpayments.objects.TouchCustomer}
     * @since 1.0
     */
    protected TouchCustomer customer;

        
    /** 
     * Extending days for this order
     * @since 1.1
     */
    protected int extendingDays;

    @Override
    public String toString() {
        return "TouchOrder [grandTotal=" + getGrandTotal() + ", shippingCosts="
                + getShippingCosts() + ", gst=" + getGst() + ", items="
                + Arrays.toString(getItems()) + ", addressShipping="
                + getAddressShipping() + ", addressBilling=" + getAddressBilling()
                + ", customer=" + getCustomer() + ", extendingDays=" + getExtendingDays()
                + "]";
    }

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

    public TouchAddress getAddressShipping() {
        return addressShipping;
    }

    public void setAddressShipping(TouchAddress addressShipping) {
        this.addressShipping = addressShipping;
    }

    public TouchAddress getAddressBilling() {
        return addressBilling;
    }

    public void setAddressBilling(TouchAddress addressBilling) {
        this.addressBilling = addressBilling;
    }

    public TouchCustomer getCustomer() {
        return customer;
    }

    public void setCustomer(TouchCustomer customer) {
        this.customer = customer;
    }

    public int getExtendingDays() {
        return extendingDays;
    }

    public void setExtendingDays(int extendingDays) {
        this.extendingDays = extendingDays;
    }
}
