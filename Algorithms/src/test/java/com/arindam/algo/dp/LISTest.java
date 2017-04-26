package com.arindam.algo.dp;

import java.util.Arrays;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by arpaul on 9/9/14.
 */
public class LISTest {
    LIS seq;

    @Before
    public void setUp() throws Exception {
        seq = new LIS();
    }

    @After
    public void tearDown() throws Exception {
        seq = null;
    }

    @Test
    public void testLIS() {
        int[] A = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] B = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] C = {50, 2, 45, 3, 5, 44, 1, 8, 40, 12, 37, 15};
        int[] D = {2, 3, 5, 8, 12, 37};
        int[] E = {3, 2, 6, 4, 5, 1};
        int[] R = {3, 4, 5};

        int[] actual = seq.solve(A);
        assertTrue(Arrays.equals(A, actual));

        assertEquals(1, seq.solve(B).length);

        actual = seq.solve(C);
        assertTrue(Arrays.equals(D, actual));

        actual = seq.solve(E);
        assertArrayEquals(R,actual);
    }
}
