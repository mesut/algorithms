package algo4editions.chapter1;

import org.junit.Assert;
import org.junit.Test;

public class FixedCapacityStackOfStringsTest {

    @Test
    public void it_should_check_whether_is_full() {
        FixedCapacityStackOfStrings s = new FixedCapacityStackOfStrings(1);
        s.push("hello");

        Assert.assertTrue(s.isFull());
    }
}