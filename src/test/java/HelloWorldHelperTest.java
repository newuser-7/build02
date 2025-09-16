import static org.junit.Assert.*;
import org.junit.Test;
public class HelloWorldHelperTest {
@Test
public void testEnglish() {
HelloWorldHelper helper = new
HelloWorldHelper();
assertTrue(helper.useEnglish().contains("World"));
}
@Test
public void testSpanish() {
HelloWorldHelper helper = new
HelloWorldHelper();
assertTrue(helper.useSpanish().contains("Mundo"));
}
}
