package script;

import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Excel;
import page.EnterTimeTrackPage;
import page.LoginPage;

public class ValidLogin extends BaseTest {
	
	@Test(priority=1,groups= {"Login","Smoke"})
	public void testValidLogin() {
		String un=Excel.getValue(XL_PATH, "ValidLogin", 1, 0);
		String pw=Excel.getValue(XL_PATH, "ValidLogin", 1, 1);
		String eTitle=Excel.getValue(XL_PATH, "ValidLogin", 1, 2);
		
		LoginPage l=new LoginPage(driver);
		//enetr valid username
		l.setUserName(un);
		
		//enter valid password
		l.setPassword(pw);
		
		//click login 
		l.clickLogin();
		
		//verify home page is displayed
		EnterTimeTrackPage p=new EnterTimeTrackPage(driver);
		p.verifyHomePageIsDisplayed(driver, eTitle);
	}

}
