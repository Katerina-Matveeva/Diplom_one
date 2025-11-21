package praktikum;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class BurgerPriceTest extends BaseTest {

    @Before
    public void setUp() {
        super.setUp();
        when(mockBun.getPrice()).thenReturn(100f);
        when(mockIngredient1.getPrice()).thenReturn(50f);
        when(mockIngredient2.getPrice()).thenReturn(75f);
    }

    // Цена бургера с булочкой и двумя ингредиентами
    @Test
    public void testGetPrice() {
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);
        assertEquals(325f, burger.getPrice(), 0.01f);
    }

    // Цена только с булочкой, без ингредиентов
    @Test
    public void testGetPriceWithNoIngredients() {
        burger.setBuns(mockBun);
        assertEquals(200f, burger.getPrice(), 0.01f);
    }
}
