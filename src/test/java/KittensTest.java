import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class KittensTest {

    private final int inputCount;
    private final int expectedCount;

    public KittensTest(int inputCount, int expectedCount) {
        this.inputCount = inputCount;
        this.expectedCount = expectedCount;
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { 0, 0 },
                { 1, 1 },
                { 2, 2 },
                { 5, 5 },
                { 10, 10 },
        }) ;
    }

    @Test
    public void testGetKittens() {
        Feline feline = new Feline();
        int actual = feline.getKittens(inputCount);
        assertEquals(expectedCount, actual);
    }
}
