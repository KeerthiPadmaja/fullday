package com.hexaware.MLP174.integration.test;

import static com.jayway.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.net.URISyntaxException;

import com.jayway.restassured.http.ContentType;

import org.junit.Test;

public class WalletRestTest {

    @Test
    public void testvalidateWallet() throws AssertionError, URISyntaxException {
    Wallet[] res = given().when().accept(ContentType.JSON)
        .get(CommonUtil.getURI("/api/wallet")).getBody().as(Wallet[].class);
    assertEquals(6, res.length);
    assertEquals(30, res[0].getWalletId());
    assertEquals(WalletType.CREDIT_CARD, res[0].getWalletType());
    assertEquals(27300.89, res[0].getWalletAmount(),0.1);
    assertEquals(1, res[0].getCustomerId());
    }

    // @Test
    // public void testshowWallet() throws AssertionError, URISyntaxException {
    // Wallet[] res = given().
    //               accept(ContentType.JSON).
    //            when().
    //               get(CommonUtil.getURI("/api/wallet/1")).
    //            getBody().as(Wallet[].class);
    // assertEquals(30, res.getWalletId());
    // assertEquals("CREDIT_CARD", res.getWalletType());
    // assertEquals(27300.89, res.getWalletAmount(),0.1);
    // assertEquals(1, res.getCustomerId());
    // }

    // @Test
    // public void testWalletById200() throws AssertionError, URISyntaxException {
    //  given().accept(ContentType.JSON).when()
    //  .get(CommonUtil.getURI("/api/wallet/1010")).then().assertThat().statusCode(200);
    // }
        @Test
    public void testWalletById200() throws AssertionError, URISyntaxException {
        given().accept(ContentType.JSON).when()
        .get(CommonUtil.getURI("/api/wallet/1")).then().assertThat().statusCode(200);
    }
    
}
