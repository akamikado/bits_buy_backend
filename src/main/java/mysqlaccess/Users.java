package mysqlaccess;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "users")
public class Users {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Column(name = "user_id")
  private Integer id;

  @Column(name = "name")
  private String name;

  @Column(name = "email")
  @NotNull
  private String email;

  @Column(name = "mobile_no")
  private Integer mobile_no;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Integer getMobileNo() {
    return mobile_no;
  }

  public void setMobileNo(Integer mobile_no) {
    this.mobile_no = mobile_no;
  }
}