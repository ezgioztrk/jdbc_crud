import java.sql.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws SQLException {
        // select();
        //insert();
        // delete();
        update();
    }
    public static void select() throws SQLException {
        DbHelper helper=new DbHelper();
        Connection connection=null;
        Statement statement=null; //sql statement
        ResultSet resultSet;//query result

        try {
            connection=helper.getConnection();
            statement=connection.createStatement();
            resultSet=statement.executeQuery("select Adı, Soyadı, Telefon, Sehir from personel");
            ArrayList<Personel> personels=new ArrayList<Personel>();
            while(resultSet.next()){
                personels.add(new Personel( //datas add personels arrays
                        resultSet.getString("Adı"),
                        resultSet.getString("Soyadı"),
                        resultSet.getInt("Telefon"),
                        resultSet.getString("Sehir")));
            }
            System.out.println(personels.size());

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            connection.close();
        }
    }
    public static void insert() throws SQLException {
        DbHelper helper=new DbHelper();
        Connection connection=null;
        PreparedStatement statement=null;

        try {
            connection=helper.getConnection();
            String sql="insert into personel(Adı,Soyadı,Telefon,Sehir) values(?,?,?,?)";
            //Direk verileri de yazabilirdik.
            statement=connection.prepareStatement(sql);
            statement.setString(1,"Pakize");
            statement.setString(2,"Şener");
            statement.setInt(3,852147963);
            statement.setString(4,"İstanbul");

            int result=statement.executeUpdate();
            System.out.println(result);
            System.out.println("kayıt eklendi");
        } catch (SQLException e) {
            helper.showErrorMessage(e);
        }finally {
            statement.close();
            connection.close();
        }
    }
    public static void delete() throws SQLException {
        DbHelper helper=new DbHelper();
        Connection connection=null;
        PreparedStatement statement=null;

        try {
            connection=helper.getConnection();
            String sql="delete from personel where idpersonel=?";
            statement=connection.prepareStatement(sql);
            statement.setInt(1,5);
            statement.executeUpdate();
            System.out.println("kayıt silindi");
        } catch (SQLException e) {
            helper.showErrorMessage(e);
        }finally {
            statement.close();
            connection.close();
        }
    }

    public static void update() throws SQLException {
        DbHelper helper=new DbHelper();
        Connection connection=null;
        PreparedStatement statement=null;
        try {
            connection=helper.getConnection();
            String sql="update personel set Telefon=0555555555 where idpersonel=?";
            statement=connection.prepareStatement(sql);
            statement.setInt(1,2);
            statement.executeUpdate();
            System.out.println("kayıt güncellendi");
        } catch (SQLException e) {
            helper.showErrorMessage(e);
        }finally {
            connection.close();
            statement.close();
        }
    }
}

