package qa.softwaretesting.mantis.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.softwaretesting.mantis.appmanager.HttpSession;
import qa.softwaretesting.mantis.model.MailMessage;
import qa.softwaretesting.mantis.model.UserData;
import ru.lanwen.verbalregex.VerbalExpression;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertTrue;
import static qa.softwaretesting.mantis.tests.TestBase.app;

public class ChangePasswordTests extends TestBase {

  @BeforeMethod
  public void startMailServer() {
    app.mail().start();
  }

  @Test
  public void testChangePassword() throws IOException, MessagingException, InterruptedException {
    String password = "12345";
    app.changePasswordHelper().login("administrator", "root");
    UserData dataUser = app.changePasswordHelper().changePassword();
    String email = dataUser.getEmail();
    String username = dataUser.getUsername();
    List<MailMessage> mailMessages = app.mail().waitForMail(1, 10000);
    String confirmationLink = findConfirmationLink(mailMessages, email);
    app.changePasswordHelper().finish(confirmationLink, password);

    HttpSession session = app.newSession();
    assertTrue(session.login(username, password));
    assertTrue(session.isLoggedInAs(username));
  }

  private String findConfirmationLink(List<MailMessage> mailMessages, String email) {
    MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(email)).findFirst().get();
    VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
    return regex.getText(mailMessage.text);
  }

  @AfterMethod(alwaysRun = true)
  public void stopMailServer() {
    app.mail().stop();
  }
}
