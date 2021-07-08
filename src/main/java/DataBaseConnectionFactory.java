import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataBaseConnectionFactory {

  public static Connection getConnection() throws SQLException {
    Properties appProps = new Properties();
    try {
      appProps.load(Files.newBufferedReader(Path.of("src/main/resources/app.properties")));
    } catch (IOException e) {
      e.printStackTrace();
    }
    String url = appProps.getProperty("URL");
    String user = appProps.getProperty("USER");
    String password = appProps.getProperty("PASS");

    return DriverManager.getConnection(url, user, password);
  }

}
