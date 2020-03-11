package com.hexaware.MLP174.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
//import static org.junit.Assert.assertTrue;

// import static org.junit.Assert.assertEquals;
// import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
//import static org.junit.Assert.assertNull;

import java.text.ParseException;
import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;

 //import mockit.Expectations;
 //import mockit.MockUp;
 //import mockit.Mocked;
 //import mockit.Mock;
 import mockit.integration.junit4.JMockit;
//// import java.util.ArrayList;

//import com.hexaware.MLP174.model.GstDemo;

/**
 * Test class for GstDemo.
 */
@RunWith(JMockit.class)
public class GstDemoTest {
    /**
   * setup method.
   */
  @Before
  public void initInput() {

  }
  /**
   * Tests for equals.
   */
  @Test
  public final void testEquals() {
    GstDemo m = new GstDemo();
    GstDemo m1 = null;
    GstDemo m2 = new GstDemo(1,1.50,1.50,2);
    GstDemo m3 = new GstDemo(1,1.50,1.50,2);
    assertFalse(m2.equals(m1));
    // assertTrue(m2.equals(m3));
    // assertEquals(m2.hashCode(), m3.hashCode());
    Vendor vendor = new Vendor();
    assertFalse(m2.equals(vendor));
    assertFalse(m.equals(m2));
    GstDemo m4 = new GstDemo();
    assertFalse(m4.equals(m2));
    // assertEquals(m2.hashCode(), m3.hashCode());
  }
  /**
   * Tests the toString() methods of the GstDemo class.
   * @throws ParseException for date format validation.
   */
  @Test
  public final void testToString() throws ParseException {
    GstDemo m = new GstDemo(1,1.50,1.50,2);
    String result = String.format("%15s %15s %15s %15s",
          m.getVenId(), m.getCgst(), m.getSgst(), m.getMonthNo());
    // assertEquals(result, m.toString());
  }
  /**
   * Tests the equals/hashcode methods of the employee class.
   */
  @Test
  public final void testGstDemo() {
    GstDemo m = new GstDemo();
    assertNotNull(m);
    GstDemo GstDemo = new GstDemo(1,1.50,1.50,2);
    GstDemo.setVenId(1);
    assertEquals(1, GstDemo.getVenId());
    GstDemo.setCgst(1.50);
    assertEquals(1.50, GstDemo.getCgst(),0);
    GstDemo.setSgst(1.50);
    assertEquals(1.50, GstDemo.getSgst(), 0);
    GstDemo.setMonthNo(2);
    assertEquals(2, GstDemo.getMonthNo());

    m.setVenId(1);
    m.setCgst(1.50);
    m.setSgst(1.50);
    m.setMonthNo(2);

    assertEquals(1, m.getVenId());
    assertEquals(1.50, m.getCgst(), 0);
    assertEquals(1.50, m.getSgst(), 0);
    assertEquals(2, m.getMonthNo());
  }
//   /**
//    * tests that empty employee list is handled correctly.
//    * @param dao mocking the dao class
//    */
//   @Test
//    public final void testListAllEmpty(@Mocked final GstDemoDAO dao) {
//     new Expectations() {
//       {
//         dao.show(); result = new ArrayList<GstDemo>();
//       }
//     };
//     new MockUp<GstDemoFactory>() {
//       @Mock
//        GstDemoDAO dao() {
//         return dao;
//       }
//     };
//     GstDemo[] me = GstDemoFactory.showGstDemo();
//     assertEquals(0, me.length);
//   }
//   /**
//    * Tests that a list with some employees is handled correctly.
//    * @param dao mocking the dao class
//    */
//   @Test
//    public final void testListAllSome(@Mocked final GstDemoDAO dao) {
//     final GstDemo m2 = new GstDemo(101, GstDemoCat.VEG, "VEG BIRIYANI", 1, 60, 4);
//     final GstDemo m3 = new GstDemo(105, GstDemoCat.NONVEG, "FISH FRY", 1, 250, 5);
//     final ArrayList<GstDemo> mn = new ArrayList<GstDemo>();
//     new Expectations() {
//       {
//         mn.add(m2);
//         mn.add(m3);
//         dao.show(); result = mn;
//       }
//     };
//     new MockUp<GstDemoFactory>() {
//       @Mock
//        GstDemoDAO dao() {
//         return dao;
//       }
//     };
//     GstDemo[] mn1 = GstDemoFactory.showGstDemo();
//     assertEquals(2, mn1.length);
//     assertEquals(101, mn1[0].getGstDemoId());
//     assertEquals(105, mn1[1].getGstDemoId());
//     assertEquals(GstDemoCat.VEG, mn1[0].getGstDemoCat());
//     assertEquals(GstDemoCat.NONVEG, mn1[1].getGstDemoCat());
//     assertEquals("VEG BIRIYANI", mn1[0].getGstDemoItem());
//     assertEquals("FISH FRY", mn1[1].getGstDemoItem());
//     assertEquals(1, mn1[0].getGstDemoQuantity());
//     assertEquals(1, mn1[1].getGstDemoQuantity());
//     assertEquals(60, mn1[0].getGstDemoCost());
//     assertEquals(250, mn1[1].getGstDemoCost());
//     assertEquals(4, mn1[0].getGstDemoRating());
//     assertEquals(5, mn1[1].getGstDemoRating());
}
