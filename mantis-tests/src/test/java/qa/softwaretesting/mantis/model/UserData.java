package qa.softwaretesting.mantis.model;

/**
 * Created by paulgladoon on 11.07.17.
 */
public class UserData {
  private String username;
  private String email;

  public UserData(String username, String email) {
    this.username = username;
    this.email = email;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
