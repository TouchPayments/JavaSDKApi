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
    protected String firstName;
    /**
     * The last name
     * @since 1.0
     */
    protected String lastName;
    /**
     * Middle name, if any
     * @since 1.0
     */
    protected String middleName;
    /**
     * Number of the house in the street
     * @since 1.0
     */
    protected String number;

    /**
     * Address (street type, street name)
     * @since 1.0
     */
    protected String addressOne;

    /**
     * Address complement (apt number, etc)
     * @since 1.0
     */
    protected String addressTwo;

    /**
     * The postcode
     * @since 1.0
     */
    protected String postcode;

    /**
     * The suburd
     * @since 1.0
     */
    protected String suburb;

    /**
     * The state
     * @since 1.0
     */
    protected String state;

    /**
     * The country
     * @since 1.0
     */
    protected String country;
    
    /**
     * @since 1.0
     * @param country of this address
     */
    public TouchAddress(String country) {
        this.country = country;
    }

    public static String getCountryAu() {
        return COUNTRY_AU;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAddressOne() {
        return addressOne;
    }

    public void setAddressOne(String addressOne) {
        this.addressOne = addressOne;
    }

    public String getAddressTwo() {
        return addressTwo;
    }

    public void setAddressTwo(String addressTwo) {
        this.addressTwo = addressTwo;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
