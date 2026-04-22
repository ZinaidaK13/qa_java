import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class LionTest {

    @Test
    public void maleLionShouldHaveMane() throws Exception {
        Lion lion = new Lion("Самец");
        assertTrue("У самца должна быть грива", lion.doesHaveMane());
    }

    @Test
    public void femaleLionShouldNotHaveMane() throws Exception {
        Lion lion = new Lion("Самка");
        assertFalse("У самки не должно быть гривы", lion.doesHaveMane());
    }

    @Test
    public void invalidSexShouldThrowException() {
        try {
            new Lion("Другое", new Feline());
            fail("Ожидалось исключение");
        } catch (Exception e) {
            assertEquals("Используйте допустимые значения пола животного - Cамец или Cамка",
                    e.getMessage());
        }
    }
    @Test
    public void getKittensWithMockFelineReturnsExpectedValue() {
        Feline mockFeline = Mockito.mock(Feline.class);
        when(mockFeline.getKittens()).thenReturn(5);
        try {
            Lion lion = new Lion("Самец", mockFeline);
            int actualKittens = lion.getKittens();
            assertEquals("Количество котят должно совпадать", 5, actualKittens);
            verify(mockFeline).getKittens();
        } catch (Exception e) {
            fail("Неожиданное исключение: " + e.getMessage());
        }
    }

    @Test
    public void getFoodShouldReturnFelineFood() throws Exception{
        Feline mockFeline = Mockito.mock(Feline.class);
        List<String> expectedFood = Arrays.asList("мясо", "рыба");
        when(mockFeline.getFood("Хищник")).thenReturn(expectedFood);

        Lion lion = new Lion("Самец", mockFeline);
        List<String> actualFood = lion.getFood();

        assertEquals("Список продуктов должен совпадать с тем, что вернула Feline", actualFood, expectedFood);
        verify(mockFeline).getFood("Хищник"); // Проверяем вызов метода
    }
}