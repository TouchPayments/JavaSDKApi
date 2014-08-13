package au.com.touchpayments.objects;

/**
 * 
 * @author Victor Mignot
 * @since 1.1
 *
 */
public class TouchExtension {
    /**
     * Number of day max this extensions gives you
     * @since 1.1
     */
    protected int days;
    /**
     * The amount of fees this extensions costs
     * @since 1.1
     */
    protected float amount;

    @Override
    public String toString() {
        return days + "\t" + amount;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
}
