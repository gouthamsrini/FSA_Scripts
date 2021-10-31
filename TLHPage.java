package threadLocalPages;

import base.BaseTest;

public class TLHPage extends BaseTest {

	public TLHPage getPageTitle()  {
		remoteWebDriver.get().getTitle();
		return this;
	}
}