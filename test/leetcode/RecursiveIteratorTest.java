package leetcode;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static junit.framework.Assert.assertEquals;

/**
 * User: huangd
 * Date: 3/23/13
 * Time: 9:53 PM
 */
public class RecursiveIteratorTest {
    @Test
    public void testIterator_noEmptySet() throws Exception {
        Set recursiveSet = new HashSet();
        recursiveSet.add(new Integer(1));
        Set recursiveSubSet = new HashSet();
        recursiveSubSet.add(new Integer(2));
        recursiveSet.add(recursiveSubSet);
        recursiveSet.add(new Integer(3));

        RecursiveIterator recursiveIterator = new RecursiveIterator(recursiveSet);

        Set result = new HashSet();
        while (recursiveIterator.hasNext()) {
            result.add(recursiveIterator.next());
        }

        Set expected = new HashSet();
        expected.add(new Integer(1));
        expected.add(new Integer(2));
        expected.add(new Integer(3));

        assertEquals(expected, result);
    }

    @Test
    public void testIterator_withEmptySet() throws Exception {
        Set recursiveSet = new HashSet();
        recursiveSet.add(new Integer(1));
        Set emptySet = new HashSet();
        recursiveSet.add(emptySet);
        Set recursiveSubSet = new HashSet();
        recursiveSubSet.add(new Integer(2));
        recursiveSubSet.add(new Integer(4));
        recursiveSubSet.add(new HashSet());
        recursiveSet.add(recursiveSubSet);
        recursiveSet.add(new Integer(3));

        RecursiveIterator recursiveIterator = new RecursiveIterator(recursiveSet);

        Set result = new HashSet();
        while (recursiveIterator.hasNext()) {
            result.add(recursiveIterator.next());
        }

        Set expected = new HashSet();
        expected.add(new Integer(1));
        expected.add(new Integer(2));
        expected.add(new Integer(3));
        expected.add(new Integer(4));

        assertEquals(expected, result);
    }
}
