package assignments.google;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class P3SecretMessageTest {

    @Test
    void testEncode() {
        P3SecretMessage sol = new P3SecretMessage();
        assertEquals("Ifmmp!", sol.encode("Hello!", 1));
        assertEquals("Hello!", sol.encode("Ifmmp!", 25));
    }

    @Test
    void testDecode() {
        P3SecretMessage sol = new P3SecretMessage();
        assertEquals(
                "Metaphysics is a restaurant where they give you a thirty thousand page menu, " +
                        "and no food. - Robert M. Pirsig",
                sol.decode(
                        "Zrgnculfvpf vf n erfgnhenag jurer gurl tvir lbh n guvegl gubhfnaq cntr zrah, " +
                                "naq ab sbbq. - Eboreg Z. Cvefvt",
                        "page"
                )
        );
    }
}