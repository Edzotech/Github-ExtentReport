package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ThirdTC extends BaseTest
{
	@Test
	public void ThirdTC()
	{
		test = extent.createTest("ThirdTC");
		Assert.fail("Failing the third tc");
	}



}