
package Tests;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
 
public class CustomTable extends BaseTest
{
    
    @Test
    public void CustomTable() 
    {
    	test = extent.createTest("Custom Table");
		//throw new SkipException("Skipping the second tc");
    	Markup m = MarkupHelper.createLabel("Custom Table", ExtentColor.BLUE);
    	test.pass(m);
    	String[][] data = {
    		    { "Header1", "Header2", "Header3"},
    		    { "Content.1.1", "Content.2.1", "Content.3.1"},
    		    { "Content.1.2", "Content.2.2", "Content.3.2"},
    		    { "Content.1.3", "Content.2.3", "Content.3.3"},
    		    { "Content.1.4", "Content.2.4", "Content.3.4"}
    		};
    		m = MarkupHelper.createTable(data);

    		test.pass(m);
    }

}