import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;  //실시간 시간 가져오기
import java.util.Locale;

public class test {

    public static void main(String[] args) {

        String user = "athenathdus";
        String password = "x465011";
        String url = "jdbc:mysql://localhost:3306/subway";
        try (
                Connection conn = DriverManager.getConnection(url, user, password);
        ) {
        System.out.println("DB connection success\n");

            //현재시간 중 '분' 만 추출
            long systemTime = System.currentTimeMillis();
            SimpleDateFormat mm = new SimpleDateFormat("mm", Locale.KOREA);
            String mTime = mm.format(systemTime);
            SimpleDateFormat hh = new SimpleDateFormat("HH", Locale.KOREA);
            String hTime = hh.format(systemTime);
            System.out.println(mTime); //check
            int m_int_Time = Integer.parseInt(mTime); //string 형을 int형으로 변환

            //m이 0~29 이면 00으로 변환, m이 30~59면 30으로 변환
            int m = m_int_Time%100;
            if(m>=0 &&m<30) {
                m = 0;
            }
            else if(m>=30&&m<=59)
                m= 30;

            //현재 시와 계산한 분을 합침 = ct
            String m_string_Time = Integer.toString(m);
            String ct = hTime+"h"+m_string_Time+"m";
            System.out.println(ct); //check

            String sql = "SELECT * FROM subway.sub_congest_data ";
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            PrintData(rs, "station_name", "line_direction","week_type");
           /* while(rs.next()) {
                System.out.print(rs.getString("station_name"));
                System.out.println(rs.getString("station_code"));
            }*/

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


