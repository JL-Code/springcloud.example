package junit.example;

/**
 * <p>描述: [类型描述] </p>
 * <p>创建时间: 2020/3/16 </p>
 *
 * @author <a href="mailto:jiangy@highzap.com" rel="nofollow">蒋勇</a>
 * @version v1.0
 */
public class UserRepository {
    public User save(User user) {
        user.setRegistrationDate("2020年03月16日15:53:09");
        return user;
    }
}
