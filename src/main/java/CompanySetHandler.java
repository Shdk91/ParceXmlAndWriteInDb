import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Set;

public class CompanySetHandler {

  public static void writeInDb(Set<Company> companies) {

    Iterator<Company> iterator = companies.iterator();

    String SQL = "INSERT INTO company(name, inn) VALUES (?,?);";

    try (Connection connection = DataBaseConnectionFactory.getConnection()) {
      connection.setAutoCommit(false);

      while (iterator.hasNext()) {
        int i = 1000;
        if (companies.size() < 1000) {
          i = companies.size();
        }
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {
          for (int j = 0; j < i; j++) {
            Company company = iterator.next();
            preparedStatement.setString(1, company.getName());
            preparedStatement.setLong(2, company.getInn());
            preparedStatement.addBatch();
            iterator.remove();
          }
          preparedStatement.executeBatch();
          connection.commit();
        }
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
  }

}
