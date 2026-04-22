import com.example.Feline;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class FelineTest {

    @Test
    public void getFamilyReturnsCatFamily() {
        Feline feline = new Feline();
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void getKittensNoParams_ReturnsOne() {
        Feline feline = new Feline();
        assertEquals(1, feline.getKittens());
    }

    @Test
    public void getKittensWithParamReturnsSameValue() {
        Feline feline = new Feline();
        assertEquals(5, feline.getKittens(5));
    }

    @Test
    public void eatMeat_ReturnsPredatorFood() throws Exception {
        Feline feline = new Feline();
        List<String> food = feline.eatMeat();

        assertNotNull(food);
        assertEquals(3, food.size());
    }
}