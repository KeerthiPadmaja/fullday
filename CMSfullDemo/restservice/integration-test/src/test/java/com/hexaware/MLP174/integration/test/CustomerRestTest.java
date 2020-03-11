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

public class CustomerRestTest {

    @Test
    public void testCustomerList() throws AssertionError, URISyntaxException {
    Customer[] res = given().when().accept(ContentType.JSON)
        .get(CommonUtil.getURI("/api/customer")).getBody().as(Customer[].class);
    assertEquals(6, res.length);
    assertEquals(1, res[0].getCustomerId());
    assertEquals("Leela", res[0].getCustomerName());
    assertEquals("LEELA@GMAIL.COM", res[0].getCustomerEmail());
    assertEquals("9999988888", res[0].getCustomerNumber());
    }

    @Test
    public void testCustomerByName() throws AssertionError, URISyntaxException {
    Customer c = given().
                  accept(ContentType.JSON).
                  when().
                  get(CommonUtil.getURI("/api/customer/customerName/Leela")).
                  getBody().as(Customer.class);
    assertEquals(1, c.getCustomerId());
    assertEquals("Leela", c.getCustomerName());
    assertEquals("LEELA@GMAIL.COM", c.getCustomerEmail());
    assertEquals("9999988888", c.getCustomerNumber());
    }

    //  @Test
    // public void testvalidateCustomer() throws AssertionError, URISyntaxException {
    // Customer c = given().
    //               accept(ContentType.JSON).
    //            when().
    //               get(CommonUtil.getURI("/api/customer/validateCustomer/1")).
    //            getBody().as(Customer.class);
    // assertEquals(1, c.getcustomerId());
    // assertEquals("Leela", c.getcustomerName());
    // assertEquals("LEELA@GMAIL.COM", c.getcustomerEmail());
    // assertEquals("9999988888", c.getcustomerNumber());
    // }


    @Test
    public void testCustomerByName200() throws AssertionError, URISyntaxException {
        given().accept(ContentType.JSON).when()
        .get(CommonUtil.getURI("/api/customer/customerName/Leela")).then().assertThat().statusCode(200);
    }
    
    @Test
    public void testCustomerByName404() throws AssertionError, URISyntaxException {
        given().accept(ContentType.JSON).when()
        .get(CommonUtil.getURI("/api/customer/customerName/Leela1")).then().assertThat().statusCode(404);
    }   
}
