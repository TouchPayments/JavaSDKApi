package au.com.touchpayments.objects;

/**
 * 
 * @author Victor Mignot
 * @since 1.0
 *
 */
public class TouchAddress {
    public final static String COUNTRY_AU = "au";

     /**
     * The first name
     * @since 1.0
     */
    public String firstName;
    /**
     * The last name
     * @since 1.0
     */
    public String lastName;
    /**
     * Middle name, if any
     * @since 1.0
     */
    public String middleName;
    /**
     * Number of the house in the street
     * @since 1.0
     */
    public String number;

    /**
     * Address (street type, street name)
     * @since 1.0
     */
    public String addressOne;

    /**
     * Address complement (apt number, etc)
     * @since 1.0
     */
    public String addressTwo;

    /**
     * The postcode
     * @since 1.0
     */
    public String postcode;

    /**
     * The suburd
     * @since 1.0
     */
    public String suburb;

    /**
     * The state
     * @since 1.0
     */
    public String state;

    /**
     * The country
     * @since 1.0
     */
    public String country;
    
    /**
     * @since 1.0
     * @param country
     */
    public TouchAddress(String country) {
        this.country = country;
    }
}
