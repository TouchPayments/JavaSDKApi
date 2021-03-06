package au.com.touchpayments.objects;

/**
 * 
 * @author Victor Mignot
 * @since 1.0
 *
 */
public class TouchItem {
    public static final String STATUS_ACTIVE = "active";
    public static final String STATUS_ACTIVEDUE = "activeDue";
    public static final String STATUS_APPROVED = "approved";
    public static final String STATUS_CANCELLED = "cancelled";
    public static final String STATUS_INCOLLECTION = "inCollection";
    public static final String STATUS_MIXED = "mixed";
    public static final String STATUS_NEW = "new";
    public static final String STATUS_OVERDUE = "overdue";
    public static final String STATUS_PAID = "paid";
    public static final String STATUS_PAYMENTDELAYED = "paymentDelayed";
    public static final String STATUS_PAYMENTREFUSED = "paymentRefused";
    public static final String STATUS_PENDING = "pending";
    public static final String STATUS_RETURNAPPROVALPENDING = "returnApprovalPending";
    public static final String STATUS_RETURNAPPROVALPENDINGAFTERPAYMENT = "returnApprovalPendingAfterPayment";
    public static final String STATUS_RETURNED = "returned";
    public static final String STATUS_RETURNEDAFTERPAYMENT = "returnedAfterPayment";
    public static final String STATUS_SHIPPED = "shipped";
    public static final String STATUS_UNABLETOFULLFILL = "unableToFullFill";
    
    /**
     * Stock keeping unit
     * @since 1.0
     */
    protected String sku;
    
    /**
     * The price of the item, GST included 
     * @since 1.0
     */
    protected float price;
    
    /**
     * The description of this item
     * @since 1.0
     */
    protected String description;
    
    /**
     * Quantity of the item ordered
     * @since 1.0
     */
    protected int quantity;
    
    /**
     * The image URL
     * @since 1.0
     */
    protected String image;

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
