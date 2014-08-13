package au.com.touchpayments.objects;

/**
 * A protected version of a customer
 * Created by Victor on 13/08/2014.
 * @since 2.0
 */
public class TouchResponseCustomer {
    /**
     * Status of the query
     * success or error
     */
    protected String status;

    /**
     * Masked mobile phone of the customer
     */
    protected String telephoneMobile;

    /**
     * Masked date of birth of the customer
     */
    protected String dob;

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
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

    public String toString() {
        return this.status + "\t" + this.telephoneMobile + "\t" + this.dob;
    }
}
