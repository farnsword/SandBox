package tddexercises;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class StringNameTests {

    @Test
    public void testNamePrintedCorrectly() {
        assertEquals("Hello, Bob", NameUtils.getGreeting("Bob"), "Greeting is incorrect");
    }

    @Test
    public void whenNameIsNull_GreetingHasMyFriend() {
        assertEquals("Hello, my friend", NameUtils.getGreeting(null), "Greeting is incorrect");
    }

    @Test
    public void whenNameIsUpperCase_GreetingIsUpperCase() {
        assertTrue(NameUtils.getGreeting("BOB").matches("[A-Z\\s,]+"),  "Greeting is not uppercase");
    }

    @Test
    public void twoNames() {
        assertEquals("Hello, Alice and Bob", NameUtils.getGreeting("Alice", "Bob"),
                "Greeting for 2 names is incorrect");
    }

    @Test
    public void multipleNames() {
        assertEquals("Hello, Alice, Bob, and Eve", NameUtils.getGreeting("Alice", "Bob", "Eve"),
                "Multiple names greeting is incorrect");
    }
}
