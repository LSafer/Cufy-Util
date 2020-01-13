package cufy.util;

import org.junit.Test;

import java.io.IOException;

@SuppressWarnings("JavaDoc")
public class ThrowableUtilTest {
	@Test(expected = IOException.class)
	public void ignite() {
		ThrowableUtil.ignite(new IOException());
	}
}
