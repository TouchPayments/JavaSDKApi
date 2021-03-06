package au.com.touchpayments;

import au.com.touchpayments.objects.*;
import com.googlecode.jsonrpc4j.Base64;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;

import static org.junit.Assert.*;

public class TouchClientTestJunit {

    private static final String privateApiKey = "fde25580b4e0f7371dc7e9f5203332041cd402a098d3b350edadbc2f2b7eff7d8aeea097";

    private String merchantRefNumber = ""; // Fill when you have them
    private String orderSecurityToken = "";
    private String smsCode = "";

    @Test
    public void testErrorCodes() {
        assertEquals("Error codes has changed!", 
                "Internal error",
                TouchMessageCodes.forHumans.get(TouchMessageCodes.ERR_INTERNAL));
        
    }
    

    @Test
    public void testPing() throws Throwable {
        TouchClient tc = new TouchClient(this.getPrivateApiKey());
        String invoRespo = tc.ping();
        assertEquals("Error: Ping nok",
                "It freackn works !", 
                invoRespo);
    }
    

    @Test
    public void testIsApiActive() throws Throwable {
        TouchClient tc = new TouchClient(this.getPrivateApiKey());
        boolean active = tc.isApiActive();
        assertTrue(active);
    }
    
    @Test
    public void testGetMaximumCheckoutValue() throws Throwable {
        TouchClient tc = new TouchClient(this.getPrivateApiKey());
        float max = tc.getMaximumCheckoutValue();
        assertEquals(200.0f, max, 0f);
    }

    @Test
    public void testGetFee() throws Throwable {
        TouchClient tc = new TouchClient(this.getPrivateApiKey());
        float fee = tc.getFeeAmount(this.getOrder().getGrandTotal());
        assertEquals(0f, fee, 0f);
    }

    @Test
    public void testGenerateOrder() throws Throwable {
        TouchClient tc = new TouchClient(this.getPrivateApiKey());
        TouchResponseGenerateOrder trgo = tc.generateOrder(this.getOrder());
        System.out.println(trgo.getToken());
    }

    
    @Test
    public void testGetOrderStatusFromToken() throws Throwable {
        TouchClient tc = new TouchClient(this.getPrivateApiKey());
        TouchResponseOrderStatus tros = tc.getOrderStatusFromToken(this.orderSecurityToken);
        System.out.println(tros.getStatus());
        assertEquals(tros.getStatus(), "new");
    }

    /**
     * Before this test, the SMS code, if sent, must have been clicked on
     */
    @Test
    public void testApproveOrderByToken() throws Throwable {
        TouchClient tc = new TouchClient(this.getPrivateApiKey());
        TouchResponseOrderStatus tros = tc.approveOrderByToken(
                this.orderSecurityToken, this.merchantRefNumber, this.getOrder().getGrandTotal());
        System.out.println(tros.getStatus());
        assertEquals(tros.getStatus(), "approved");
    }

    @Test
    public void testUpdateOrderArticlesBeforeShipment() throws Throwable {
        TouchClient tc = new TouchClient(this.getPrivateApiKey());
        TouchOrderItemsUpdate to = this.getOrderItemsUpdate();
        TouchResponseOrderStatus tros = tc.updateOrderArticlesBeforeShipment(this.merchantRefNumber, to);
        System.out.println(tros);
    }
    
    @Test
    public void testApproveOrderBySmsCode() throws Throwable {
        TouchClient tc = new TouchClient(this.getPrivateApiKey());
        TouchResponseOrderStatus tros = tc.approveOrderBySmsCode(
                this.orderSecurityToken, this.merchantRefNumber, this.getOrder().getGrandTotal(), this.smsCode);
        assertEquals(tros.getStatusCode(), 3);
    }
    
    @Test
    public void testGetOrder() throws Throwable {
        TouchClient tc = new TouchClient(this.getPrivateApiKey());
        TouchResponseOrderStatus tros = tc.getOrder(this.merchantRefNumber);
        assertEquals(tros.getMerchantRefNumber(), this.merchantRefNumber);
    }
    
    @Test
    public void testSetOrderStatusCancelled() throws Throwable {
        TouchClient tc = new TouchClient(this.getPrivateApiKey());
        TouchResponseOrderStatus tros = tc.setOrderStatusCancelled(this.merchantRefNumber, "BECAUSE");
        assertEquals(tros.getStatusCode(), 16);
    }
    

    @Test
    public void testSetOrderItemStatusCancelled() throws Throwable {
        TouchClient tc = new TouchClient(this.getPrivateApiKey());
        TouchResponseOrderStatus tros = tc.setOrderItemStatusCancelled(this.merchantRefNumber, new int[]{3688}, "BECAUSE");
        assertEquals(tros.getStatusCode(), 16);
    }

    @Test
    public void testSetOrderStatusShipped() throws Throwable {
        TouchClient tc = new TouchClient(this.getPrivateApiKey());
        TouchResponseOrderStatus tros = tc.setOrderStatusShipped(this.merchantRefNumber);
        assertEquals(tros.getStatusCode(), 5);
    }

    @Test
    public void testSetOrderItemStatusReturnPending() throws Throwable {
        TouchClient tc = new TouchClient(this.getPrivateApiKey());
        TouchResponseOrderStatus tros = tc.setOrderItemStatusReturnPending(this.merchantRefNumber, new int[]{3688});
        assertEquals(tros.getStatusCode(), 14);
    }
    
    @Test
    public void testSetOrderItemStatusReturned() throws Throwable {
        TouchClient tc = new TouchClient(this.getPrivateApiKey());
        TouchResponseOrderStatus tros = tc.setOrderItemStatusReturned(this.merchantRefNumber, new int[]{3688});
        assertEquals(tros.getStatusCode(), 15);
    }

    @Test
    public void testSetOrderItemStatusReturnDenied() throws Throwable {
        TouchClient tc = new TouchClient(this.getPrivateApiKey());
        TouchResponseOrderStatus tros = tc.setOrderItemStatusReturnDenied(this.merchantRefNumber, new int[]{3688});
        assertEquals(tros.getStatusCode(), 20);
    }
    
    @Test
    public void testGetInvoice() throws Throwable {
        TouchClient tc = new TouchClient(this.getPrivateApiKey());
        String filestream = tc.getInvoice(this.merchantRefNumber);
        
        byte[] raw = Base64.decode(filestream);
        FileOutputStream out = new FileOutputStream(
                "./invoice.pdf");
        out.write(raw);
        out.close();
        File tmp = new File("./invoice.pdf");
        assertTrue(tmp.delete());
    }
    
    @Test
    public void testGetExtensions() throws Throwable {
        TouchClient tc = new TouchClient(this.getPrivateApiKey());
        TouchExtension[] tes = tc.getExtensions();
        for (TouchExtension te : tes) {
            System.out.println(te);   
        }
    }

    @Test
    public void testGetCustomer() throws Throwable {
        TouchClient tc = new TouchClient(this.getPrivateApiKey());
        TouchResponseCustomer tCustomer = tc.getCustomer(this.getCustomer().getEmail());
        System.out.println(tCustomer);
    }

    @Test
    public void testGetJavascriptSources() throws Throwable {
        TouchClient tc = new TouchClient(this.getPrivateApiKey());
        String sid = UUID.randomUUID().toString();
        TouchResponseJavascriptSources js = tc.getJavascriptSources(sid);
        System.out.println(js);
        assertNotNull(js.getUrl());
    }
    @Test
    public void testGenerateExpressOrder() throws Throwable {
        TouchClient tc = new TouchClient(this.getPrivateApiKey());
        TouchResponseGenerateOrder tgo = tc.generateExpressOrder(this.getOrder());
        System.out.println(tgo);
    }

    ///////////////
    // TEST SETS //
    ///////////////
    private TouchOrder getOrder() {
        TouchOrder order = new TouchOrder();

        order.setAddressBilling(this.getAddress());
        order.setAddressShipping(order.getAddressBilling());
        order.setCustomer(this.getCustomer());

        order.setGrandTotal(15.20f);
        order.setGst(1.1f);
        order.setItems(this.getItems());
        order.setShippingCosts(0f);

        return order;
    }
    private TouchCustomer getCustomer() {
        TouchCustomer customer = new TouchCustomer();
        customer.setEmail("test@touchpayments.com.au");
        customer.setDob("12/07/1998");
        customer.setTelephoneMobile("0400000000");
        return customer;
    }
    private TouchAddress getAddress() {
        TouchAddress address = new TouchAddress(TouchAddress.COUNTRY_AU);
        address.setFirstName("Victor");
        address.setLastName("M");
        address.setMiddleName("");
        address.setNumber("301/441-449");
        address.setAddressOne("Elizabeth Street");
        address.setPostcode("2010");
        address.setSuburb("Surry Hills");
        address.setState("NSW");
        return address;
    }
    private TouchItem[] getItems() {
        TouchItem[] items = new TouchItem[]{new TouchItem()};
        items[0].setPrice(15.20f);
        items[0].setQuantity(1);
        items[0].setSku("TestSKU123");
        return items;
    }
    private TouchOrderItemsUpdate getOrderItemsUpdate() {
        TouchOrderItemsUpdate orderUpdate = new TouchOrderItemsUpdate();
        orderUpdate.setItems(new TouchItem[]{new TouchItem()});
        orderUpdate.getItems()[0] = getOrder().getItems()[0];
        orderUpdate.getItems()[0].setPrice(14.20f);

        orderUpdate.setGrandTotal(14.20f);
        return orderUpdate;
    }
    private String getPrivateApiKey() {
        return privateApiKey;
    }
}
