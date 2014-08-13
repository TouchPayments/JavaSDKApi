package au.com.touchpayments;

import au.com.touchpayments.objects.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.googlecode.jsonrpc4j.JsonRpcClientException;
import com.googlecode.jsonrpc4j.JsonRpcHttpClient;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
/**
 * TODO setOrderItemStatusCancelled returns a TouchResponseOrderStatus
 * Shouldn't it returns a TouchResponseOOrderItemStatus , which is btw unused? 
 */


/**
 * Java SDK for TouchPayements
 *
 * @author Victor Mignot
 * @version 1.1
 */
public class TouchClient {
    /**
     * Protocol to use.
     *
     * @since 1.0
     */
    private static final String protocol = "https";
    /**
     * URL of the server
     *
     * @since 1.0
     */
    private static final String url = "test.touchpayments.com.au";
    /**
     * Port of the service, if exotic
     *
     * @since 1.0
     */
    private static final int port = 443;
    /**
     * Path to the API on the server
     *
     * @since 1.0
     */
    private static final String pathToAPI = "/api/v2";
    /**
     * API key of the client
     *
     * @since 1.0
     */
    private final String apiKey;
    /**
     * The JsonRpcHttpClient for Remote procedure call in json
     *
     * @since 1.0
     */
    private final JsonRpcHttpClient mJsonRpcHttpClient;

    /**
     * Public constructor.
     * Give it the API key
     *
     * @param apiKey a valid API key API key of an active client
     * @since 1.0
     */
    public TouchClient(String apiKey) {
        URL url = null;
        try {
            url = this.buildApiUrl();
        } catch (MalformedURLException e) {
            // Should not happen, as the URL is provided
            // so we handle it here.
            e.printStackTrace();
        }

        this.apiKey = apiKey;
        this.mJsonRpcHttpClient = new JsonRpcHttpClient(new ObjectMapper(),
                url,
                new HashMap<String, String>()
        );
    }


    /**
     * Ping touchpayment API. A good start!
     *
     * @return a ping success message
     * @throws Throwable
     * @since 1.0
     */
    public String ping() throws Throwable {
        return this.invoke("ping", String.class);
    }

    /**
     * Get a maximum checkout Value
     *
     * @return a float : the maximum checkout value
     * @throws Throwable
     * @since 1.0
     */
    public float getMaximumCheckoutValue() throws Throwable {
        return this.invoke("getMaximumCheckoutValue", float.class);
    }

    /**
     * Check if Api is available at the time
     *
     * @return boolean true if active
     * @throws Throwable
     * @since 1.0
     */
    public boolean isApiActive() throws Throwable {
        return this.invoke("apiActive", boolean.class);
    }

    /**
     * Get the fees applicable to a grand total
     *
     * @param grandTotal grand Total of the order
     * @return the applicable fees
     * @throws Throwable
     * @since 1.0
     */
    public float getFeeAmount(float grandTotal) throws Throwable {
        float fee;
        try {
            fee = this.invoke("getFeeAmount", new Object[]{grandTotal}, float.class);
        } catch (JsonRpcClientException e) {
            fee = 0f;
        }
        return fee;
    }

    /**
     * Generate an new order
     * The new order will be pending until approval
     *
     * @param order a TouchOrder
     * @return a response with the order token so we can retrieve it later
     * for example, to approve it
     * @throws Throwable
     * @see au.com.touchpayments.objects.TouchOrder
     * @see au.com.touchpayments.objects.TouchResponseGenerateOrder
     * @since 1.0
     */
    public TouchResponseGenerateOrder generateOrder(TouchOrder order) throws Throwable {
        return this.invoke("generateOrder", new Object[]{order}, TouchResponseGenerateOrder.class);
    }

    /**
     * Generate an order for express
     * The new order will be pending until approval
     *
     * @param order a TouchOrder
     * @return a response with the order token so we can retrieve it later
     * @throws Throwable
     * @since Express
     */
    public TouchResponseGenerateOrder generateExpressOrder(TouchOrder order) throws Throwable {
        return this.invoke("generateExpressOrder", new Object[]{order}, TouchResponseGenerateOrder.class);
    }

    /**
     * Validation of the order
     * TouchResponseOrderStatus::statusCode goes from 2 (pending) to 3 (approved)
     *
     * @param token        security token of the order
     * @param newRefNumber your shop reference number of the order. This will be used for any further request
     * @param grandTotal   total of the order. Asked again to compare it with the grand total given in TouchClient::generateOrder(TouchOrder order)
     * @return TouchResponseOrderStatus
     * @throws Throwable
     * @see TouchResponseOrderStatus
     * @since 1.0
     */
    public TouchResponseOrderStatus approveOrderByToken(String token, String newRefNumber, float grandTotal) throws Throwable {
        return this.invoke("approveOrderByToken", new Object[]{token, newRefNumber, grandTotal}, TouchResponseOrderStatus.class);
    }

    /**
     * Validation of the order by SMS.
     * TouchResponseOrderStatus::statusCode goes from 2 (pending) to 3 (approved)
     *
     * @param token        security token of the order
     * @param newRefNumber your shop reference number of the order. This will be used for any further request.
     * @param grandTotal   total of the order. Asked again to compare it with the grand total given in TouchClient::generateOrder(TouchOrder order)
     * @param smsCode      the SMS code. You can do that if the TouchResponseGenerateOrder returned by TouchClient::generateOrder is true.
     * @return TouchResponseOrderStatus
     * @throws Throwable
     * @since 1.0
     */
    public TouchResponseOrderStatus approveOrderBySmsCode(String token, String newRefNumber, float grandTotal, String smsCode) throws Throwable {
        return this.invoke("approveOrderBySmsCode", new Object[]{token, newRefNumber, grandTotal, smsCode}, TouchResponseOrderStatus.class);
    }

    /**
     * Cancel an order
     * TouchResponseOrderStatus::statusCode goes from x (any state) to 16 (cancelled)
     *
     * @param refNumber reference of the order
     * @param reason    reason of the cancellation
     * @return TouchResponseOrderStatus
     * @throws Throwable
     * @see TouchResponseOrderStatus
     * @since 1.0
     */
    public TouchResponseOrderStatus setOrderStatusCancelled(String refNumber, String reason) throws Throwable {
        return this.invoke("setOrderStatusCancelled", new Object[]{refNumber, reason}, TouchResponseOrderStatus.class);
    }

    /**
     * Get available extensions for a merchant
     *
     * @return TouchExtension[]
     * @throws Throwable
     * @see au.com.touchpayments.objects.TouchExtension
     * @since 1.1
     */
    public TouchExtension[] getExtensions() throws Throwable {
        return this.invoke("getExtensions", TouchExtension[].class);
    }

    /**
     * Cancel an item in an order
     * TouchResponseOrderStatus::statusCode goes to 16 (cancelled)
     *
     * @param refNumber reference of the order
     * @param itemIds   an int array of item ids that will be cancelled
     * @param reason    reason of the cancellation
     * @return TouchResponseOrderStatus
     * @throws Throwable
     * @see TouchResponseOrderStatus
     * @since 1.0
     */
    public TouchResponseOrderStatus setOrderItemStatusCancelled(String refNumber, int[] itemIds, String reason) throws Throwable {
        return this.invoke("setOrderItemStatusCancelled", new Object[]{refNumber, itemIds, reason}, TouchResponseOrderStatus.class);
    }

    /**
     * Every time an item is unable to fulfill or an Item is cancelled or returned
     * the order can be updated with this method.
     * <p/>
     * Every article will be updated
     * It should only be called in case of fulfillment issues, so this can only be called before an order is
     * set to "shipped" so only in Approved for all items
     *
     * @param refNumber   reference of the order
     * @param orderUpdate TouchOrder (customer can be null)
     * @return TouchResponseOrderStatus
     * @throws Throwable
     * @see TouchOrder
     * @see TouchResponseOrderStatus
     * @since 1.0
     */
    public TouchResponseOrderStatus updateOrderArticlesBeforeShipment(String refNumber, TouchOrderItemsUpdate orderUpdate) throws Throwable {
        return this.invoke("updateOrderArticlesBeforeShipment", new Object[]{refNumber, orderUpdate}, TouchResponseOrderStatus.class);
    }

    /**
     * Ship an order
     * TouchResponseOrderStatus::statusCode goes from 3 (approved) to 4 (shipped) to 5 (active)
     *
     * @param refNumber reference of the order
     * @return TouchResponseOrderStatus
     * @throws Throwable
     * @see TouchResponseOrderStatus
     * @since 1.0
     */
    public TouchResponseOrderStatus setOrderStatusShipped(String refNumber) throws Throwable {
        return this.invoke("setOrderStatusShipped", new Object[]{refNumber}, TouchResponseOrderStatus.class);
    }

    /**
     * Get the invoice of an order
     * <pre>
     * {@code
     *  byte[] rawInvoiceBitstream = Base64.decode(mTouchClient.getInvoice(refNumber));
     *  FileOutputStream out = new FileOutputStream("./invoice.pdf");
     *  out.write(rawInvoiceBitstream);
     *  out.close();
     * }
     * </pre>
     *
     * @param refNumber reference of the order
     * @return a String (base64) of the invoice file
     * @throws Throwable
     * @since 1.0
     */
    public String getInvoice(String refNumber) throws Throwable {
        return this.invoke("getInvoice", new Object[]{refNumber}, String.class);
    }


    /**
     * Set the status of items to "returnApprovalPending"
     * TouchResponseOrderStatus goes from 5 (active) to 14 (returnApprovalPending)
     *
     * @param refNumber reference of the order
     * @param itemIds   an int array of item ids
     * @return TouchResponseOrderStatus
     * @throws Throwable
     * @see TouchResponseOrderStatus
     * @since 1.0
     */
    public TouchResponseOrderStatus setOrderItemStatusReturnPending(String refNumber, int[] itemIds) throws Throwable {
        return this.invoke("setOrderItemStatusReturnPending", new Object[]{refNumber, itemIds}, TouchResponseOrderStatus.class);
    }

    /**
     * Set the status of item to "returned"
     * TouchResponseOrderStatus goes from 14 (returnApprovalPending) to 15 (returned)
     *
     * @param refNumber reference of the order
     * @param itemIds   an int array of item ids
     * @return TouchResponseOrderStatus
     * @throws Throwable
     * @see TouchResponseOrderStatus
     * @since 1.0
     */
    public TouchResponseOrderStatus setOrderItemStatusReturned(String refNumber, int[] itemIds) throws Throwable {
        return this.invoke("setOrderItemStatusReturned", new Object[]{refNumber, itemIds}, TouchResponseOrderStatus.class);
    }

    /**
     * Set the status of item to "returnDenied"
     * TouchResponseOrderStatus goes from 14 (returnApprovalPending) to 20 (returnDenied)
     *
     * @param refNumber reference of the order
     * @param itemIds   an int array of item ids
     * @return TouchResponseOrderStatus
     * @throws Throwable
     * @see TouchResponseOrderStatus
     * @since 1.0
     */
    public TouchResponseOrderStatus setOrderItemStatusReturnDenied(String refNumber, int[] itemIds) throws Throwable {
        return this.invoke("setOrderItemStatusReturnDenied", new Object[]{refNumber, itemIds}, TouchResponseOrderStatus.class);
    }

    /**
     * Get the status of an order
     *
     * @param refNumber reference number of the order
     * @return TouchResponseOrderStatus
     * @throws Throwable
     * @see TouchResponseOrderStatus
     * @since 1.0
     */
    public TouchResponseOrderStatus getOrder(String refNumber) throws Throwable {
        return this.invoke("getOrder", new Object[]{refNumber}, TouchResponseOrderStatus.class);
    }

    /**
     * Returns masked user details for the account linked to the provided email address
     * or null if the customer can not be find
     * @param email email of the customer
     * @return TouchResponseCustomer|null
     * @throws Throwable
     * @since 2.0
     */
    public TouchResponseCustomer getCustomer(String email) throws Throwable {
        return this.invoke("getCustomer", new Object[]{email}, TouchResponseCustomer.class);
    }

    /**
     * Retrieve a JS file Url to include and an id to be used in order submissions, for device identification
     *
     * The session_id parameter is a temporary identifier that is unique to the
     * visitor’s session. This must be generated by your web-app. It can be up
     * to 128 bytes long and must consist of the following characters only:
     *
     * - Upper and lowercase English letters (a-z, A-Z)
     * - Digits (0-9)
     * - Underscore (_)
     * - Hyphen (-)
     *
     * @param idClient id of the client
     * @return String
     * @throws Throwable
     * @since 2.0
     */
    public TouchResponseJavascriptSources getJavascriptSources(String idClient) throws Throwable {
        return this.invoke("getJavascriptSources", new Object[]{idClient}, TouchResponseJavascriptSources.class);
    }

    /**
     * Get the status of an order as given when generated
     *
     * @param token security token of the order
     * @return TouchResponseOrderStatus
     * @throws Throwable
     * @see TouchResponseOrderStatus
     * @since 1.0
     */
    public TouchResponseOrderStatus getOrderStatusFromToken(String token) throws Throwable {
        return this.invoke("getOrderStatusFromToken", new Object[]{token}, TouchResponseOrderStatus.class);
    }

    ////////////////////////////////////////
    //     Privates functions
    ///////////////////////////////////////    

    /**
     * JsonRpcHttpClient invocation wrapper
     *
     * @param method the method name that you want to call on the server
     * @param params the parameters of the methods you are gonna call
     *               in the good order
     * @param clazz  hey... What do you actually expect
     * @return the required object (of clazz type)
     * @throws Throwable so you can return whatever you want in your catch code
     * @since 1.0
     */
    private <T> T invoke(String method, Object[] params, Class<T> clazz) throws Throwable {
        Object[] paramsWithAPIKey = new Object[params.length + 1];
        System.arraycopy(new Object[]{this.apiKey}, 0, paramsWithAPIKey, 0, 1);
        System.arraycopy(params, 0, paramsWithAPIKey, 1, params.length);

        return mJsonRpcHttpClient.invoke(method, paramsWithAPIKey, clazz);
    }

    /**
     * JsonRpcHttpClient invocation wrapper.
     * No Params? Might mean minimum params.
     *
     * @param method you want to call on the server
     * @param clazz  Hey... What do you actually expect
     * @return the required object (of clazz type)
     * @throws Throwable so you can return whatever you want in your catch code
     * @since 1.0
     */
    private <T> T invoke(String method, Class<T> clazz) throws Throwable {
        return mJsonRpcHttpClient.invoke(method, new Object[]{this.apiKey}, clazz);
    }


    /**
     * Debug function: Raw RPC requests.
     *
     * @param method you want to call
     * @param params of this methods
     * @return just a String. Deal with it!
     * @throws Throwable
     * @since 1.0
     */
    @SuppressWarnings("unused")
    private String invokeRaw(String method, Object[] params) throws Throwable {
        URLConnection uc = this.buildApiUrl().openConnection();
        uc.setDoOutput(true);
        uc.setDoInput(true);
        uc.setRequestProperty("Accept", "application/json");
        uc.setRequestProperty("Content-Type", "application/json; charset=UTF-8");

        OutputStream ops = uc.getOutputStream();
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(ops));
        String paramsStr = "\"" + this.apiKey + "\"";
        for (Object o : params) {
            paramsStr += ",\"" + o + "\"";
        }
        String request = "{\"jsonrpc\":\"2.0\",\"method\":\"" + method +
                "\",\"params\":[" + paramsStr + "],\"id\":2}";
        writer.write(request);
        writer.close();
        ops.close();
        BufferedReader br = new BufferedReader(new InputStreamReader(uc.getInputStream()));
        String line;
        String jsonString = null;
        while ((line = br.readLine()) != null) {
            jsonString += line;
        }
        br.close();
        return jsonString;
    }

    /**
     * Building the API url
     *
     * @return an URL object for the API
     * @throws java.net.MalformedURLException
     * @since 1.0
     */
    private URL buildApiUrl() throws MalformedURLException {
        return new URL(
                TouchClient.protocol,
                TouchClient.url,
                TouchClient.port,
                TouchClient.pathToAPI
        );
    }


}

