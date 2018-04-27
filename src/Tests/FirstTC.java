package Tests;

import org.testng.annotations.Test;

public class FirstTC extends BaseTest
{

	@Test
	public void FirstTC() 
	{
		test = extent.createTest("FirstTC");
		test.info("start the test");
		int i=1; int k=2;
		for (int j=1;j<5;j++){
			if (k>i)
			{
				test.pass(i+" is greater than "+k);
			}else{
				test.fail(i+" is NOT greater than "+k);
			}
		}
	}

}