import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TransactionTest {

    @Test
    public void test() throws SQLException, ClassNotFoundException {

        String url = "jdbc:mysql://localhost:3306/jdbc";
        String username = "root";
        String password = "rootpassword";

        // 1.加载驱动 （下面是新版本的驱动）
        Class.forName("com.mysql.cj.jdbc.Driver");
        // 2.连接数据库 conn代表数据库
        Connection   conn = DriverManager.getConnection(url, username, password);

        String sql1 = "update `account` set money = money - 100 where `name` = 'A';";
        String error = "update `account` set money = money - 100 where `name` = 'S';";
        String sql2 = "update `account` set money = money + 100 where `name` = 'B';";


        // 通知数据库开启事务
        conn.setAutoCommit(false);

        try{
            // 3.向数据库发送SQL的对象
            conn.prepareStatement(sql1).executeUpdate();
            conn.prepareStatement(error).executeUpdate();
            int i = 1/0; // 制造错误
            conn.prepareStatement(sql2).executeUpdate();

            conn.commit(); // 以上两条SQL都执行成功才commit
            System.out.println("事务提交成功！");
        } catch (Exception e){
            try {
                System.out.println("事务被回滚了");
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }finally {
            // 关闭连接
            conn.close();
        }

    }
}
