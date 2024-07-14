package BasePackage;
import org.testng.annotations.*;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
public class dataproviderclass {
	
	
	@DataProvider (name = "TestDataforlogin")
	public String[][] datasupplier() {
			String [][] data= {{"hemangmahajani10@gmail.com", "123456"}	,
					{"hemangmahajani09@gmail.com", "12345",}};
		
			return data;
		}

}
