package praktikum;

import org.junit.Test;

import static org.junit.Assert.*;

public class BurgerBasicTest extends BaseTest {

    // Проверка, что булочка правильно устанавливается в бургер
    @Test
    public void testSetBuns() {
        burger.setBuns(mockBun);
        assertEquals(mockBun, burger.bun);
    }

    // Добавление ингредиента: размер списка увеличивается, и ингредиент добавляется правильно
    @Test
    public void testAddIngredient() {
        burger.addIngredient(mockIngredient1);
        assertEquals(1, burger.ingredients.size());
        assertEquals(mockIngredient1, burger.ingredients.get(0));

    }

    // Удаление ингредиента: после добавления и удаления список пустой
    @Test
    public void testRemoveIngredient() {
        burger.addIngredient(mockIngredient1);
        burger.removeIngredient(0);
        assertTrue(burger.ingredients.isEmpty());
    }

    // Перемещение ингредиента: первый ингредиент переходит на вторую позицию
    @Test
    public void testMoveIngredient() {
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);
        burger.moveIngredient(0, 1);
        assertEquals(mockIngredient2, burger.ingredients.get(0));
        assertEquals(mockIngredient1, burger.ingredients.get(1));
    }
}