package cufy.util;

import org.junit.Assert;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

@SuppressWarnings("JavaDoc")
public class Iterator$Test {
	@Test
	public void combine() {
		Iterator<String> a = Array$.iterator("a", "B", "c");
		Iterator<String> b = Array$.iterator("a", "B", "c");
		Iterator<String> c = Array$.iterator("a", "B", "c");

		Iterator<String> x = Iterator$.combine(a, b, c);

		StringBuilder string = new StringBuilder();

		while (x.hasNext())
			string.append(x.next());

		Assert.assertEquals("Some elements are missing", "aBcaBcaBc", string.toString());

		try {
			x.next();
			Assert.fail("No such element!");
		} catch (NoSuchElementException ignored) {
		}
	}
}
