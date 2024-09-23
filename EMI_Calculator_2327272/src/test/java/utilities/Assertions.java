package utilities;

import org.testng.Assert;

public class Assertions {
	public void assertIt(String a, String b, String message) {
		Assert.assertEquals(a, b, message);
	}
	public void assertIt(boolean a, boolean b, String message) {
		Assert.assertEquals(a, b, message);
	}
	public void fail() {
		Assert.fail();
	}
	public void pass() {
		Assert.assertTrue(true);
	}
}
