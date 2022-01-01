import com.mysql.cj.jdbc.Driver;

import java.sql.*;

public class TestJDBC {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/jdbc";
        String username = "root";
        String password = "rootpassword";

        // 1.加载驱动 （下面是新版本的驱动）
        Class.forName("com.mysql.cj.jdbc.Driver");
        // 2.连接数据库 conn代表数据库
        Connection conn = DriverManager.getConnection(url, username, password);
        // 3.向数据库发送SQL的对象
        Statement statement = conn.createStatement();

        // 4.编写SQL
        String querySql = "select * from users;"; // 这里是否有分号都可以
        
        // 5.执行SQL
        ResultSet rs = statement.executeQuery(querySql);
        while(rs.next()){
            System.out.println("id=" + rs.getObject("id"));
            System.out.println("name=" + rs.getObject("name"));
            System.out.println("password=" + rs.getObject("password"));
            System.out.println("email=" + rs.getObject("email"));
            System.out.println("=======================================================");
        }

        String deleteSql = "DELETE FROM users where id = 4;";
        // 这里返回的是受影响的行数，并且增删改都使用executeUpdate()即可
        int i = statement.executeUpdate(deleteSql);

        // 关闭连接，释放资源，先开的后关
        rs.close();
        statement.close();
        conn.close();

    }
}
