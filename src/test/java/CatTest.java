
import com.example.Cat;
import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

public class CatTest {
    private Cat cat;
    private Feline feline;

    @Before
    public void setUp() {
        feline = Mockito.mock(Feline.class);
        cat = new Cat(feline);
    }

    @Test
    public void getSoundReturnsMeow() {
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void getFoodReturnsExpectedFoodList() throws Exception {
        List<String> expected = Arrays.asList("мясо", "рыба", "птица");
        when(feline.eatMeat()).thenReturn(expected);

        List<String> actual = cat.getFood();

        assertEquals(expected, actual);
        verify(feline).eatMeat();
    }

    @Test(expected = Exception.class)
    public void getFoodWhenPredatorFailsThrowsException() throws Exception {
        doThrow(new Exception("Нет еды")).when(feline).eatMeat();
        cat.getFood();
    }
}