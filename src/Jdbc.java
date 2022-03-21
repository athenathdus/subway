
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Jdbc {

    public static void main(String[] args) {

        String user = "athenathdus";
        String password = "x465011";
        String url = "jdbc:mysql://localhost:3306";
        try(
                Connection conn = DriverManager.getConnection(url, user, password);
        ) {
            System.out.println(conn.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

/*

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;  //실시간 시간 가져오기
import java.util.Locale;

public class Jdbc {

    public static void main(String[] args) {

        String user = "athenathdus";
        String password = "x465011";
        String url = "jdbc:mysql://localhost:3306/subway";
        try (
                Connection conn = DriverManager.getConnection(url, user, password);
        ) {
            System.out.println("DB connection success\n");

            String sql = "SELECT * FROM subway.sub_line_name_info";
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);


            long systemTime = System.currentTimeMillis();
            SimpleDateFormat formatter = new SimpleDateFormat("HHmm", Locale.KOREA);
            String dTime = formatter.format(systemTime);
            System.out.println(dTime);
            int Time = Integer.parseInt(dTime);
            System.out.println(Time);

            int m = (Time%1000)%100;
            if(m>=0 &&m<30)
                m = 00;
            else if(m>=30&&m<=59)
                m= 30;

            SimpleDateFormat t = new SimpleDateFormat("HH", Locale.KOREA);
            String correctT = t.format(systemTime);

            System.out.print(correctT+m);
            PrintData(rs, "station_name", "station_code", "line_id");
           */
/* while(rs.next()) {
                System.out.print(rs.getString("station_name"));
                System.out.println(rs.getString("station_code"));
            }*//*


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private static void PrintData (ResultSet rs, String col1, String col2, String col3 )throws SQLException
    {
        while(rs.next()) {
            System.out.print(rs.getString(col1));
            System.out.print("\t"+rs.getString(col2));
            System.out.println("\t"+rs.getString(col3));
        }
    }
}


*/

