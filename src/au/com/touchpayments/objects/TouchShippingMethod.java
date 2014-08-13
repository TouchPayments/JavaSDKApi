package au.com.touchpayments.objects;

/**
 * Created by Victor on 13/08/2014.
 * @since Express
 * You should set it in Touch_Order when sending the order to the touch API if and _ONLY IF_ the shipping methods are
 * linked to the order and would not change according to the address
 * (note that at the moment, Touch Payment is only offering its service in Australia)
 */
public class TouchShippingMethod {
    /**
     * Name of this shipping method
     * Keep It Short
     */
    protected String label;

    /**
     * Longueur description of this shipping methods. This will be displayed side by side with the label
     * It should contains short and important information, such as expecting days or price by KG
     */
    protected String description;

    /**
     * This contains additional details, as long as you want to make it
     */
    protected String additionalDetails;

    /**
     * Enable a method for a certain order
     * This field should be used to send additional methods which could be available to the user _if_
     * For example, for an order of 9 AUD
     *  ShippingMethod {
     *      [label] => "Free shipping"
     *      [description] => "3 to 5 days Australia-wide!"
     *      [additionalDetails] => "For a cart superior or equals to 10 AUD"
     *      [isEligible] => false
     *  }
     * BUT this should NOT be used to send ShippingMethod irrelevent to the customer
     * (eg: how much it could cost him to ship his order to Reykjavik if he does not live here)
     */
    protected boolean isEligible;

    /**
     * Cost of the shipping method
     */
    protected float cost;


    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAdditionalDetails() {
        return additionalDetails;
    }

    public void setAdditionalDetails(String additionalDetails) {
        this.additionalDetails = additionalDetails;
    }

    public boolean isEligible() {
        return isEligible;
    }

    public void setEligible(boolean isEligible) {
        this.isEligible = isEligible;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }
}
