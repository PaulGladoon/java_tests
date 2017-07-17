package qa.softwaretesting.rest;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.jayway.restassured.RestAssured;
import org.testng.SkipException;

public class TestBase {

  boolean isIssueOpen(int issueId) {
    String json = RestAssured.get("http://demo.bugify.com/api/issues/"+issueId+".json").asString();
    JsonElement parsed = new JsonParser().parse(json);
    String issueState = parsed.getAsJsonObject().get("issues")
            .getAsJsonArray().get(0)
            .getAsJsonObject().get("state_name")
            .getAsString();
    if (issueState.equals("Open")) {
      return true;
    } else {
      return false;
    }
  }

  public void skipIfNotFixed(int issueId) {
    if (isIssueOpen(issueId)) {
      throw new SkipException("Ignored because of issue " + issueId);
    }
  }
}
