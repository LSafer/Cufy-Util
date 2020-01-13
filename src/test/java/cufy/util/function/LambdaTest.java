package cufy.util.function;

import org.junit.Assert;
import org.junit.Test;

import java.util.function.BiFunction;
import java.util.function.Function;

@SuppressWarnings("JavaDoc")
public class LambdaTest {
	@Test
	public void it() {
		Function<Integer, Integer> f = Lambda::it;
		BiFunction<Integer, Object, Integer> f0 = Lambda::it0;
		BiFunction<Object, Integer, Integer> f1 = Lambda::it1;

		Assert.assertEquals("Not the expected", (Integer) 1, f.apply(1));
		Assert.assertEquals("Not the expected", (Integer) 2, f0.apply(2, 3));
		Assert.assertEquals("Not the expected", (Integer) 5, f1.apply(4, 5));
	}
}
