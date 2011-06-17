/*
 * UnixTimeTest.java
 * Created by Sassy on 11/05/15
 */

package com.blogspot.sassylog.unixtime;

import junit.framework.TestCase;

public class UnixTimeTest extends TestCase {
    public UnixTimeTest(String name) {
        super(name);
    }

    public void testUnixTimeTest01() {
        UnixTime time = new UnixTime();
        assertEquals(time.getYear(), 1970);
        assertEquals(time.getMonth(), 1);
        assertEquals(time.getDay(), 1);
    }

    public void testUnixTimeTest02() {
        UnixTime time = new UnixTime(86400);
        assertEquals(time.getYear(), 1970);
        assertEquals(time.getMonth(), 1);
        assertEquals(time.getDay(), 2);
    }
    
    public void testUnixTimeTest03() {
        UnixTime time = new UnixTime(2678400);
        assertEquals(time.getYear(), 1970);
        assertEquals(time.getMonth(), 2);
        assertEquals(time.getDay(), 1);
    }
    
    public void testUnixTimeTest04() {
        UnixTime time = new UnixTime(31535999);
        assertEquals(time.getYear(), 1970);
        assertEquals(time.getMonth(), 12);
        assertEquals(time.getDay(), 31);
    }

    public void testUnixTimeTest05() {
        UnixTime time = new UnixTime(31449600);
        assertEquals(time.getYear(), 1970);
        assertEquals(time.getMonth(), 12);
        assertEquals(time.getDay(), 31);
    }

    public void testUnixTimeTest06() {
        UnixTime time = new UnixTime(31536000);
        assertEquals(time.getYear(), 1971);
        assertEquals(time.getMonth(), 1);
        assertEquals(time.getDay(), 1);
    }

    public void testUnixTimeTest07() {
        UnixTime time = new UnixTime(31536001);
        assertEquals(time.getYear(), 1971);
        assertEquals(time.getMonth(), 1);
        assertEquals(time.getDay(), 1);
    }

    public void testUnixTimeTest08() {
        UnixTime time = new UnixTime(62985600);
        assertEquals(time.getYear(), 1971);
        assertEquals(time.getMonth(), 12);
        assertEquals(time.getDay(), 31);
    }

    public void testUnixTimeTest09() {
        UnixTime time = new UnixTime(68083200);
        assertEquals(time.getYear(), 1972);
        assertEquals(time.getMonth(), 2);
        assertEquals(time.getDay(), 28);
        
        time.setUnixTime(68169599);
        assertEquals(time.getYear(), 1972);
        assertEquals(time.getMonth(), 2);
        assertEquals(time.getDay(), 28);

        time.setUnixTime(68169600);
        assertEquals(time.getYear(), 1972);
        assertEquals(time.getMonth(), 2);
        assertEquals(time.getDay(), 29);

        time.setUnixTime(68255999);
        assertEquals(time.getYear(), 1972);
        assertEquals(time.getMonth(), 2);
        assertEquals(time.getDay(), 29);

        time.setUnixTime(68256000);
        assertEquals(time.getYear(), 1972);
        assertEquals(time.getMonth(), 3);
        assertEquals(time.getDay(), 1);
    }

    public void testUnixTimeTest10() {
        UnixTime time = new UnixTime(951696000);
        assertEquals(time.getYear(), 2000);
        assertEquals(time.getMonth(), 2);
        assertEquals(time.getDay(), 28);

        time.setUnixTime(951782399);
        assertEquals(time.getYear(), 2000);
        assertEquals(time.getMonth(), 2);
        assertEquals(time.getDay(), 28);

        time.setUnixTime(951782400);
        assertEquals(time.getYear(), 2000);
        assertEquals(time.getMonth(), 2);
        assertEquals(time.getDay(), 29);

        time.setUnixTime(951868799);
        assertEquals(time.getYear(), 2000);
        assertEquals(time.getMonth(), 2);
        assertEquals(time.getDay(), 29);

        time.setUnixTime(951868800);
        assertEquals(time.getYear(), 2000);
        assertEquals(time.getMonth(), 3);
        assertEquals(time.getDay(), 1);
    }
    
    public void testUnixTimeTest11() {
        UnixTime time = new UnixTime(2147483647);
        assertEquals(time.getYear(), 2038);
        assertEquals(time.getMonth(), 1);
        assertEquals(time.getDay(), 19);
    }

    public void testUnixTimeTest12() {
        UnixTime time = new UnixTime(-1);
        assertEquals(time.getYear(), 1970);
        assertEquals(time.getMonth(), 1);
        assertEquals(time.getDay(), 1);
        
        time.setUnixTime(-2147483648);
        assertEquals(time.getYear(), 1970);
        assertEquals(time.getMonth(), 1);
        assertEquals(time.getDay(), 1);

    }

    public void testUruu01() {
        assertFalse(UnixTime.calcUruu(1700));
        
        assertFalse(UnixTime.calcUruu(1703));
        assertTrue(UnixTime.calcUruu(1704));
        assertFalse(UnixTime.calcUruu(1705));

        assertFalse(UnixTime.calcUruu(1899));
        assertFalse(UnixTime.calcUruu(1900));
        assertFalse(UnixTime.calcUruu(1901));

        assertFalse(UnixTime.calcUruu(1971));
        assertTrue(UnixTime.calcUruu(1972));
        assertFalse(UnixTime.calcUruu(1973));

        assertFalse(UnixTime.calcUruu(1999));
        assertTrue(UnixTime.calcUruu(2000));
        assertFalse(UnixTime.calcUruu(2001));
    }

}
