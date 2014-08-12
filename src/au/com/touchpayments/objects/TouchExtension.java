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
    public int days;
    /**
     * The amount of fees this extensions costs
     * @since 1.1
     */
    public float amount;

    @Override
    public String toString() {
        return "Extensions [days=" + days + ", fees=" + amount + "]";
    }
}
