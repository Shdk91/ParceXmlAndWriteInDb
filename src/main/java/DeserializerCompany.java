import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class DeserializerCompany {

  private Path path;

  public DeserializerCompany(Path path) {
    this.path = path;
  }

  public Path getPath() {
    return path;
  }

  public void setPath(Path path) {
    this.path = path;
  }

  public HashSet<Company> deserialize() {
    CompanySet list = null;

    try (BufferedReader reader = Files.newBufferedReader(this.path)) {
      JAXBContext jaxbContext = JAXBContext.newInstance(CompanySet.class);
      Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
      list = (CompanySet) unmarshaller.unmarshal(reader);
    } catch (JAXBException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }


    return list.getCompanies();
  }

}
