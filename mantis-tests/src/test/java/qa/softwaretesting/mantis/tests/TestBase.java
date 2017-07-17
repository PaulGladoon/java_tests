package qa.softwaretesting.mantis.tests;

import biz.futureware.mantis.rpc.soap.client.IssueData;
import biz.futureware.mantis.rpc.soap.client.MantisConnectPortType;
import org.openqa.selenium.remote.BrowserType;
import org.testng.SkipException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import qa.softwaretesting.mantis.appmanager.ApplicationManager;
import qa.softwaretesting.mantis.appmanager.SoapHelper;

import javax.xml.rpc.ServiceException;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.rmi.RemoteException;

public class TestBase {

  protected static final ApplicationManager app
          = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));

  boolean isIssueOpen(int issueId) throws MalformedURLException, ServiceException, RemoteException {
    String username = "administrator";
    String password = "root";
    MantisConnectPortType mc = app.soap().getMantisConnect();
    IssueData issueData = mc.mc_issue_get(username, password, BigInteger.valueOf(issueId));
    String issueState = issueData.getStatus().getName();
    if (issueState.equals("Open")) {
      return true;
    } else {
      return false;
    }
  }

  public void skipIfNotFixed(int issueId) throws RemoteException, ServiceException, MalformedURLException {
    if (isIssueOpen(issueId)) {
      throw new SkipException("Ignored because of issue " + issueId);
    }
  }

  @BeforeSuite
  public void setUp() throws Exception {
    app.init();
    app.ftp().upload(new File("src/test/resources/config_inc.php"), "config_inc.php", "config_inc.php.bak");
  }

  @AfterSuite(alwaysRun = true)
  public void tearDown() throws IOException {
    app.ftp().restore("config_inc.php.bak", "config_inc.php");
    app.stop();
  }

}
