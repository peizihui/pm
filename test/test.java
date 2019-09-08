import com.pm.dao.datasource.User;
import com.pm.process.UserProcess;

public class test {


    public static void main(String[] args) {
        UserProcess up = new UserProcess();
        User user = up.queryUser(1);

        System.out.println(user.getUserName());
    }
}
