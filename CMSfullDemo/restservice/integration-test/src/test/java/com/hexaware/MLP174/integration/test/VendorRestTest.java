package com.hexaware.MLP174.integration.test;

import static com.jayway.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.net.URISyntaxException;

import com.jayway.restassured.http.ContentType;

import org.junit.Test;

public class VendorRestTest {

    @Test
    public void testshowVendor() throws AssertionError, URISyntaxException {
    Vendor[] res = given().when().accept(ContentType.JSON)
        .get(CommonUtil.getURI("/api/vendor")).getBody().as(Vendor[].class);
    assertEquals(6, res.length);
    assertEquals(1, res[0].getVendorId());
    assertEquals("Sougata", res[0].getVendorName());
    assertEquals("9876543210", res[0].getVendorNumber());
    assertEquals("SOUGATA@GMAIL.COM", res[0].getVendorEmail());
    }

    @Test
    public void testfindByVendorName() throws AssertionError, URISyntaxException {
    Vendor m = given().
                  accept(ContentType.JSON).
                  when().
                  get(CommonUtil.getURI("/api/vendor/vendorName/Sougata")).
                  getBody().as(Vendor.class);
    assertEquals(1, m.getVendorId());
    assertEquals("Sougata", m.getVendorName());
    assertEquals("9876543210", m.getVendorNumber());
    assertEquals("SOUGATA@GMAIL.COM", m.getVendorEmail());
    }

    // @Test
    // public void testvalidateVendor() throws AssertionError, URISyntaxException {
    // Vendor m = given().
    //               accept(ContentType.JSON).
    //            when().
    //               get(CommonUtil.getURI("/api/vendor/validateVendor/1")).
    //            getBody().as(Vendor.class);
    // assertEquals(6, m.getVendorId());
    // assertEquals("Sougata", m.getVendorName());
    // assertEquals("9876543210", m.getVendorNumber());
    // assertEquals("SOUGATA@GMAIL.COM", m.getVendorEmail());
    // }

    @Test
    public void testVendorById200() throws AssertionError, URISyntaxException {
        given().accept(ContentType.JSON).when()
        .get(CommonUtil.getURI("/api/vendor/vendorName/Sougata")).then().assertThat().statusCode(200);
    }

    @Test
    public void testVendorById404() throws AssertionError, URISyntaxException {
        given().accept(ContentType.JSON).when()
        .get(CommonUtil.getURI("/api/vendor/vendorName/Sougata1")).then().assertThat().statusCode(404);
    }
    
}