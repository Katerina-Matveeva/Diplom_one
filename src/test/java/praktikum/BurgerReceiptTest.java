package praktikum;

import org.assertj.core.api.SoftAssertions;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.when;

public class BurgerReceiptTest extends BaseTest {

    @Before
    public void setUp() {
        super.setUp();
        when(mockIngredient1.getType()).thenReturn(IngredientType.SAUCE);
        when(mockIngredient2.getType()).thenReturn(IngredientType.FILLING);
    }

    // Проверка чека с двумя ингредиентами
    @Test
    public void testGetReceiptWithMultipleIngredients() {
        SoftAssertions softly = new SoftAssertions();

        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);

        String receipt = burger.getReceipt();
        String[] lines = receipt.split("\n");
       // System.out.println("Receipt: " + receipt);

        softly.assertThat(lines[0].trim())
                .isEqualTo("(==== Test Bun ====)");

        softly.assertThat(lines[1].trim())
                .isEqualTo("= sauce Test Ingredient 1 =");

        softly.assertThat(lines[2].trim())
                .isEqualTo("= filling Test Ingredient 2 =");

        softly.assertThat(lines[3].trim())
                .isEqualTo("(==== Test Bun ====)");

        softly.assertThat(lines[4])
                .isBlank();

        softly.assertThat(lines[5])
                .startsWith("Price: ");

        softly.assertAll();
    }
}
