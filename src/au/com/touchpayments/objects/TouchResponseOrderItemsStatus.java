package au.com.touchpayments.objects;
/**
 * 
 * @author Victor Mignot
 * @since 1.0
 * TODO unused
 *
 */
public class TouchResponseOrderItemsStatus {
    /**
     * Uniq id of the item
     */
    protected int id;

    /**
     * Status of the item
     * @see TouchItem
     */
    protected String status;

    /**
     * Code of the status
     */
    protected int statusCode;

    /**
     * Reason for cancellation, if any
     */
    protected String reasonCancelled;

    /**
     * SKU of the item
     */
    protected String sku;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }
}
