package com.xm.counter;

import junit.framework.TestCase;

/**
 * Created by peter on 2016/9/17.
 */
public class UtilTest extends TestCase {
    Counter counter = new Counter();
    public void testSerializeCounter() throws Exception {
        Util.SerializeCounter(counter);
    }

    public void testDeserializeCounter() throws Exception {

    }

    public void testGetFileName() throws Exception {

    }

}