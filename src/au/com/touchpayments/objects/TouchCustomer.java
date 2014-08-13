package au.com.touchpayments.objects;

/**
 * 
 * @author Victor Mignot
 * @since 1.0
 *
 */
public class TouchCustomer {
    /**
     * The email of the customer
     * @since 1.0
     */
    protected String email;
    /**
     * The first name of the customer
     * @since 1.0
     */
    protected String firstName;
    /**
     * The last name of the customer
     * @since 1.0
     */
    protected String lastName;
    /**
     * The gender the customer is defining itself
     * (m or f)
     * @since 1.0
     */
    protected String gender;
    /**
     * The customer's mobile phone number
     * @since 1.0
     */
    protected String telephoneMobile;

    /**
     * Date of birth
     * @since 2.0
     */
    protected String dob;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTelephoneMobile() {
        return telephoneMobile;
    }

    public void setTelephoneMobile(String telephoneMobile) {
        this.telephoneMobile = telephoneMobile;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }
}
