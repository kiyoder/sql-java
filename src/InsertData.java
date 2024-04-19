import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertData {
    public static void main(String[] args) {
        try(Connection c = mySQLConnection.getConnection();
            PreparedStatement statement = c.prepareStatement(
                    "INSERT INTO users (name, email) VALUES (?,?)"
            )){
            String name = "Jay Vince Serato";
            String email = "jayvince.serato@cit.edu";
            String query = "INSERT INTO users (name, email) VALUES ("+name+", "+email+")";
            statement.setString(1, name);
            statement.setString(2, email);
            Statement boringStatement = c.createStatement();
            int rows = statement.executeUpdate();
            System.out.println("Rows Inserted: " + rows);
        }catch(SQLException e){
            throw new RuntimeException();
        }
    }
}
