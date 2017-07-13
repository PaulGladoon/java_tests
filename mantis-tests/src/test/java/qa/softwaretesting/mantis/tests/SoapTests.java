package qa.softwaretesting.mantis.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.softwaretesting.mantis.model.Issue;
import qa.softwaretesting.mantis.model.Project;

import javax.xml.rpc.ServiceException;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.Set;

public class SoapTests extends TestBase{

  @BeforeMethod
  public void issueStatus() throws RemoteException, ServiceException, MalformedURLException {
    int issueId = app.soap().issueId("administrator", "root","Test issue");
    skipIfNotFixed(issueId);
  }

  @Test
  public void testGetProjects() throws MalformedURLException, ServiceException, RemoteException {
    Set<Project> projects = app.soap().getProjects();
    System.out.println(projects.size());
    for (Project project : projects) {
      System.out.println(project.getName());
    }
  }

  @Test
  public void testCreateIssue() throws MalformedURLException, ServiceException, RemoteException {
    Set<Project> projects = app.soap().getProjects();
    Issue issue = new Issue().withSummary("Test issue")
            .withDescription("Test issue description")
            .withProjectl(projects.iterator().next());
    Issue created = app.soap().addIssue(issue);
    Assert.assertEquals(issue.getSummary(), created.getSummary());
  }

  @Test
  public void issueTest() throws RemoteException, ServiceException, MalformedURLException {
    int issueId = app.soap().issueId("administrator", "root","Test issue");
    System.out.println(issueId);
  }
}

