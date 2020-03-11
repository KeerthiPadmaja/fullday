package com.hexaware.MLP174.integration.test;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import org.junit.Test;
import static org.junit.Assert.*;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import static com.jayway.restassured.RestAssured.given;

public class OrdersRestTest {

    @Test
    public void testOrders() throws AssertionError, URISyntaxException {
    Orders[] res = given().when().accept(ContentType.JSON)
        .get(CommonUtil.getURI("/api/orders")).getBody().as(Orders[].class);
    // assertEquals(6, res.length);
    assertEquals(1,res[0].getOrderId());
    assertEquals(1,res[0].getCustomerId());
    assertEquals(4,res[0].getVendorId());
    assertEquals(101,res[0].getMenuId());
    }
 @Test
    public void testshowCustomerHistory() throws AssertionError, URISyntaxException {
    Orders[] c = given().
                  accept(ContentType.JSON).
                  when().
                  get(CommonUtil.getURI("/api/orders/customerhistory/1")).
                  getBody().as(Orders[].class);
    //    assertEquals(1, c.length);
    assertEquals(1,c[0].getOrderId());
    assertEquals(1,c[0].getCustomerId());
    assertEquals(4,c[0].getVendorId());
    assertEquals(101,c[0].getMenuId());
    }
     @Test
    public void testOrderById200() throws AssertionError, URISyntaxException {
        given().accept(ContentType.JSON).when()
        .get(CommonUtil.getURI("/api/orders/customerhistory/1")).then().assertThat().statusCode(200);
    }
    
    @Test
    public void testOrderById404() throws AssertionError, URISyntaxException {
        given().accept(ContentType.JSON).when()
        .get(CommonUtil.getURI("/api/orders/customerhistory/11111")).then().assertThat().statusCode(200);
    }   
}