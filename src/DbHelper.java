import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


    public class DbHelper {
       //Connection codes
        private String userName="*********"; //essential username and password
        private String password="*********";
        private String dbUrl="jdbc:mysql://localhost:3306/world?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        // this url explain; you set localhost.World is database

        public Connection getConnection() throws SQLException {
            return DriverManager.getConnection(dbUrl,userName,password);
        }

        public void showErrorMessage(SQLException exception){
            System.out.println("Error: "+exception.getMessage());//writes error message on the screen
            System.out.println("Error code: "+exception.getErrorCode());
        }
    }



