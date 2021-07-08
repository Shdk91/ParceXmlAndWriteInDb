import java.util.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "company")
@XmlAccessorType(XmlAccessType.FIELD)
public class Company {

  private String name;
  private Long inn;

  public Company() {
  }

  public Company(String name, Long inn) {
    this.name = name;
    this.inn = inn;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Long getInn() {
    return inn;
  }

  public void setInn(Long inn) {
    this.inn = inn;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Company company = (Company) o;
    return Objects.equals(name, company.name) && Objects.equals(inn, company.inn);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, inn);
  }

  @Override
  public String toString() {
    return "Company{" +
        "name='" + name + '\'' +
        ", inn=" + inn +
        '}';
  }
}
