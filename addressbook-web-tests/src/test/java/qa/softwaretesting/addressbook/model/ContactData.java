package qa.softwaretesting.addressbook.model;

public class ContactData {
  private int id;
  private final String firstName;
  private final String middleName;
  private String group;
  private final String lastName;
  private final String nickname;
  private final String title;
  private final String company;
  private final String address;
  private final String home;
  private final String mobile;
  private final String work;
  private final String fax;
  private final String email;
  private final String homepage;
  private final String year;
  private final String year2;
  private final String address2;
  private final String phone2;
  private final String notes;

  public ContactData(int id, String firstName, String middleName, String group, String lastName, String nickname, String title, String company, String address, String home, String mobile, String work, String fax, String email, String homepage, String year, String year2, String address2, String phone2, String notes) {
    this.id = id;
    this.firstName = firstName;
    this.middleName = middleName;
    this.group = group;
    this.lastName = lastName;
    this.nickname = nickname;
    this.title = title;
    this.company = company;
    this.address = address;
    this.home = home;
    this.mobile = mobile;
    this.work = work;
    this.fax = fax;
    this.email = email;
    this.homepage = homepage;
    this.year = year;
    this.year2 = year2;
    this.address2 = address2;
    this.phone2 = phone2;
    this.notes = notes;
  }

  public ContactData(String firstName, String middleName, String group, String lastName, String nickname, String title, String company, String address, String home, String mobile, String work, String fax, String email, String homepage, String year, String year2, String address2, String phone2, String notes) {
    this.id = Integer.MAX_VALUE;
    this.firstName = firstName;
    this.middleName = middleName;
    this.group = group;
    this.lastName = lastName;
    this.nickname = nickname;
    this.title = title;
    this.company = company;
    this.address = address;
    this.home = home;
    this.mobile = mobile;
    this.work = work;
    this.fax = fax;
    this.email = email;
    this.homepage = homepage;
    this.year = year;
    this.year2 = year2;
    this.address2 = address2;
    this.phone2 = phone2;
    this.notes = notes;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    return firstName != null ? firstName.equals(that.firstName) : that.firstName == null;
  }

  @Override
  public int hashCode() {
    return firstName != null ? firstName.hashCode() : 0;
  }

  public int getId() { return id; }

  public String getFirstName() {
    return firstName;
  }

  public String getMiddleName() {
    return middleName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getNickname() {
    return nickname;
  }

  public String getTitle() {
    return title;
  }

  public String getCompany() {
    return company;
  }

  public String getAddress() {
    return address;
  }

  public String getHome() {
    return home;
  }

  public String getMobile() {
    return mobile;
  }

  public String getWork() {
    return work;
  }

  public String getFax() {
    return fax;
  }

  public String getEmail() {
    return email;
  }

  public String getHomepage() {
    return homepage;
  }

  public String getYear() {
    return year;
  }

  public String getYear2() { return year2; }

  public String getAddress2() {
    return address2;
  }

  public String getPhone2() {
    return phone2;
  }

  public String getNotes() {
    return notes;
  }

  public String getGroup() { return group;
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id=" + id +
            ", firstName='" + firstName + '\'' +
            '}';
  }

  public void setId(int id) {
    this.id = id;
  }
}
