import java.sql.*;

public class DBManager {
    String JDBC_DRIVER = "com.mysql.jdbc.Driver"; //드라이버
    String DB_URL = "jdbc:mysql://localhost/salary?&useSSL=false"; //접속할 DB 서버

    String USER_NAME = "athenathdus"; //DB에 접속할 사용자 이름
    String PASSWORD = "x465011"; //사용자의 비밀번호

    public DBManager() {
        Connection conn = null;
        Statement state = null;
        try { //Reflection 방식
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD); //db 내의 데이터를 저장
            state = conn.createStatement(); //sql 문을 실행하기 위해 conn 연결 정보를 state로 생성

            String sql;
            sql = "SELECT * FROM subway.sub_line_name_info;";
            ResultSet rs = state.executeQuery(sql); // sql 실행결과를 rs에 저장
            while (rs.next()) {
                int id = rs.getInt("line_id");

                System.out.println("Id: "+ id);

            }

            rs.close();
            state.close();
            conn.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try{
                if(state != null)
                    state.close();
            } catch(SQLException e){
                e.printStackTrace();
            }
            try{
                if(conn != null)
                    conn.close();
            }catch (SQLException e){

            }
        }
    }

}