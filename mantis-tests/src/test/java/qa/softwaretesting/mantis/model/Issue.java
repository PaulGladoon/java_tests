package qa.softwaretesting.mantis.model;

public class Issue {

  private int id;
  private String summary;
  private String description;
  private Project projectl;

  public int getId() {
    return id;
  }

  public Issue withId(int id) {
    this.id = id;
    return this;
  }

  public String getSummary() {
    return summary;
  }

  public Issue withSummary(String summary) {
    this.summary = summary;
    return this;
  }

  public String getDescription() {
    return description;
  }

  public Issue withDescription(String description) {
    this.description = description;
    return this;
  }

  public Project getProject() {
    return projectl;
  }

  public Issue withProjectl(Project projectl) {
    this.projectl = projectl;
    return this;
  }
}
