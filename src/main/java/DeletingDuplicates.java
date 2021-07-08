import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

public class DeletingDuplicates {

  public static void deleteDuplicates(Set<Company> companies) {
    String SQL = "SELECT * FROM company;";

    try (Connection connection = DataBaseConnectionFactory.getConnection()) {

      try (Statement statement = connection.createStatement()) {

        ResultSet resultSet = statement.executeQuery(SQL);

        Set<Company> resultCompanies = new HashSet<>();

        while (resultSet.next()) {
          Company company = new Company(resultSet.getString("name"),
              resultSet.getLong("inn"));
          resultCompanies.add(company);
        }

        companies.removeAll(resultCompanies);
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
  }

}
