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
    protected String status;
    
    /**
     * The status code of the order
     */
    protected int statusCode;
    
    /**
     * If cancelled, the reason of the cancellation
     */
    protected String reasonCancelled;

    /**
     * The reference of the order
     */
    protected String refNumber;

    /**
     * The reference of the order merchant side
     */
    protected String merchantRefNumber;

    /**
     * 
     */
    protected float fee;
    
    /**
     * 
     */
    protected TouchResponseOrderItemStatus[] items;

    /**
     * Label of the shipping method
     */
    protected String shippingMethodLabel;
    /**
     * Extension fees for this order
     * @since 2.0
     */
    protected float extensionFee;

    @Override
    public String toString() {
        return "TouchResponseOrderStatus [status=" + getStatus() + ", statusCode="
                + getStatusCode() + ", reasonCancelled=" + getReasonCancelled()
                + ", refNumber=" + getRefNumber() + ", merchantRefNumber="
                + getMerchantRefNumber() + ", fee=" + getFee() + ", items="
                + Arrays.toString(getItems()) + ", getClass()=" + getClass() + "]";
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getReasonCancelled() {
        return reasonCancelled;
    }

    public void setReasonCancelled(String reasonCancelled) {
        this.reasonCancelled = reasonCancelled;
    }

    public String getRefNumber() {
        return refNumber;
    }

    public void setRefNumber(String refNumber) {
        this.refNumber = refNumber;
    }

    public String getMerchantRefNumber() {
        return merchantRefNumber;
    }

    public void setMerchantRefNumber(String merchantRefNumber) {
        this.merchantRefNumber = merchantRefNumber;
    }

    public float getFee() {
        return fee;
    }

    public void setFee(float fee) {
        this.fee = fee;
    }

    public TouchResponseOrderItemStatus[] getItems() {
        return items;
    }

    public void setItems(TouchResponseOrderItemStatus[] items) {
        this.items = items;
    }

    public String getShippingMethodLabel() {
        return shippingMethodLabel;
    }

    public void setShippingMethodLabel(String shippingMethodLabel) {
        this.shippingMethodLabel = shippingMethodLabel;
    }

    public float getExtensionFee() {
        return extensionFee;
    }

    public void setExtensionFee(float extensionFee) {
        this.extensionFee = extensionFee;
    }
}
