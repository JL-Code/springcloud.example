package junit.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.*;

/**
 * <p>描述: [类型描述] </p>
 * <p>创建时间: 2020/3/16 </p>
 *
 * @author <a href="mailto:jiangy@highzap.com" rel="nofollow">蒋勇</a>
 * @version v1.0
 */
@ExtendWith(MockitoExtension.class)
public class TestUserService {

    @MockBean
    private UserService userService;
    @Mock
    private UserRepository userRepository;
//    private UserRepository userRepository = Mockito.mock(UserRepository.class);

    @BeforeEach
    public void setup() {
//        userService = new UserService(userRepository);
    }

    @Test
    public void testSaveUserHasRegisterDate() {
        User user = new User(1, "jiangy", null);
        // 当 userRepository 调用 save 时它将返回 save 方法的第一个实参
        // @see https://reflectoring.io/unit-testing-spring-boot/
        when(userRepository.save(any(User.class))).then(returnsFirstArg());
        User savedUser = userService.save(user);
        // @see https://assertj.github.io/doc/
        assertThat(savedUser.getRegistrationDate()).isNotNull();
    }
}
