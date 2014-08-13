package au.com.touchpayments.objects;

/**
 * Response container for requesting javascript file
 * Created by Victor on 13/08/2014.
 * @since 2.0
 */
public class TouchResponseJavascriptSources {
    /**
     * id of the session
     */
    protected String idSession;

    /**
     * URL of the JavaScript file
     */
    protected String url;

    public String getIdSession() {
        return idSession;
    }

    public void setIdSession(String idSession) {
        this.idSession = idSession;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String toString() {
        return this.idSession + "\t" + this.url;
    }
}
