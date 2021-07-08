import java.util.HashSet;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "companies")
@XmlAccessorType(XmlAccessType.FIELD)
public class CompanySet {

  @XmlElement(name = "company")
  private HashSet<Company> companies;

  public HashSet<Company> getCompanies() {
    return companies;
  }

  public void setCompanies(HashSet<Company> companies) {
    this.companies = companies;
  }
}
