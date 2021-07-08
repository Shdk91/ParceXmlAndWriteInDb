import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Set;

public class Main {

  public static void main(String[] args) {
    System.out.println
        ("Введите путь к фалйу в формате \"C:/Users/Desktop/example/filename.xml\"");

    Path path;

    try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
      String fileName = reader.readLine();
      path = Path.of(fileName);

      while (!Files.exists(path)) {
        System.out.println("Такого файла не существует. Введите еще раз");
        path = Path.of(reader.readLine());
      }

      DeserializerCompany deserializeCompany = new DeserializerCompany(path);
      Set<Company> companies = deserializeCompany.deserialize();
      DeletingDuplicates.deleteDuplicates(companies);
      CompanySetHandler.writeInDb(companies);

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
