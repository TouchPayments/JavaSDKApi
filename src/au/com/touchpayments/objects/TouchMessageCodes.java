package au.com.touchpayments.objects;

import java.util.HashMap;
import java.util.Map;

/**
 * Error code for handling exceptions
 * 
 * <pre>
 * {@code
 * TouchClient tc = new TouchClient("NOT_A_VALID_KEY");
 *       try {
 *           tc.ping();
 *       } catch (Throwable e) {
 *           JsonRpcClientException jrce = (JsonRpcClientException) e;
 *           System.out.println(jrce.getCode());
 *           // Should print -32003
 *       }
 * }
 * </pre>
 * 
 * @author  Victor Mignot
 * @since   1.0
 * 
 */

public final class TouchMessageCodes {
    public static final int ERR_INTERNAL =                      -32000;
    public static final int ERR_VALIDATION =                    -32001;
    public static final int ERR_ORDER_NOT_FOUND =               -32002;
    public static final int ERR_AUTHENTICATION_FAILURE =        -32003;
    public static final int ERR_ITEM_WRONG_FORMAT =             -32004;
    public static final int ERR_NO_MULTIPLE_ITEMS =             -32005;
    public static final int ERR_WRONG_SMS_CODE =                -32006;
    public static final int ERR_INVALID_ADDRESS =               -32007;
    public static final int ERR_INVALID_CHARACTERS =            -32008;
    public static final int ERR_INVALID_POSTCODE_SUBURB_COMBINATION = -32009;
    public static final int ERR_DEVICE_SCORE_TOO_LOW =          -32010;
    public static final int ERR_CUSTOMER_DETAILS_MISSING =      -32011;
    public static final int ERR_ARTICLES_CANNOT_BE_UPDATED =    -32012;


    public static final Map<Integer, String> forHumans = new HashMap<Integer, String>(); 
    
    static {
        forHumans.put(ERR_VALIDATION,               "Validation Error");
        forHumans.put(ERR_ORDER_NOT_FOUND,          "Order could not be found");
        forHumans.put(ERR_AUTHENTICATION_FAILURE,   "Authentication failure");
        forHumans.put(ERR_ITEM_WRONG_FORMAT,        "Order Items have the wrong format");
        forHumans.put(ERR_NO_MULTIPLE_ITEMS,        "Multiple items not supported");
        forHumans.put(ERR_WRONG_SMS_CODE,           "Wrong sms code provided");
        forHumans.put(ERR_INVALID_ADDRESS,          "Invalid Address provided");
        forHumans.put(ERR_INVALID_CHARACTERS,       "Invalid Characters used eg \"<\" or \">\"");
        forHumans.put(ERR_INVALID_POSTCODE_SUBURB_COMBINATION, "Invalid Postcode and suburb Combination provided.");
        forHumans.put(ERR_DEVICE_SCORE_TOO_LOW,     "Given device is not trustworthy.");
        forHumans.put(ERR_INTERNAL,                 "Internal error");
    }
}
