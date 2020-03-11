package com.hexaware.MLP174.integration.test;

import static com.jayway.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.net.URISyntaxException;

import com.jayway.restassured.http.ContentType;

import org.junit.Test;

public class MenuRestTest {

    @Test
    public void testlistMenu() throws AssertionError, URISyntaxException {
    Menu[] res = given().when().accept(ContentType.JSON)
        .get(CommonUtil.getURI("/api/menu")).getBody().as(Menu[].class);
    //assertEquals(6, res.length);
    assertEquals(101, res[0].getMenuId());
    assertEquals(" VEG BIRIYANI", res[0].getMenuItem());
    assertEquals(4, res[0].getMenuRating());
    }

    @Test
    public void testshowMenu() throws AssertionError, URISyntaxException {
    Menu m = given().
                  accept(ContentType.JSON).
                  when().
                  get(CommonUtil.getURI("/api/menu/101")).
                  getBody().as(Menu.class);
    assertEquals(101, m.getMenuId());
    assertEquals(" VEG BIRIYANI", m.getMenuItem());
    assertEquals(4, m.getMenuRating());
    }

    @Test
    public void testMenuById404() throws AssertionError, URISyntaxException {
        given().accept(ContentType.JSON).when()
        .get(CommonUtil.getURI("/api/menu/201")).then().assertThat().statusCode(204);
    }
        @Test
    public void testMenuById200() throws AssertionError, URISyntaxException {
        given().accept(ContentType.JSON).when()
        .get(CommonUtil.getURI("/api/menu/101")).then().assertThat().statusCode(200);
    }
    
}
