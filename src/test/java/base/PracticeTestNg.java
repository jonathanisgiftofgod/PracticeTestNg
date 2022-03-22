package base;

import java.io.IOException;

import org.testng.annotations.Test;

import pageElements.PageElementOfLogin;

public class PracticeTestNg extends BaseClass{
	@Test
	public void tc1() {
		launchUrl("http://adactinhotelapp.com/");
	}
	@Test
	public void tc2() throws IOException {
		PageElementOfLogin l = new PageElementOfLogin();
		enterText(l.getUser(), readFile("Sheet1", 0, 0));
	}
	
}
