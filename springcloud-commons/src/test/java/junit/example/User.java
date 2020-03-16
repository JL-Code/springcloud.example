package junit.example;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * <p>描述: [类型描述] </p>
 * <p>创建时间: 2020/3/16 </p>
 *
 * @author <a href="mailto:jiangy@highzap.com" rel="nofollow">蒋勇</a>
 * @version v1.0
 */
@Data
@AllArgsConstructor
public class User {
    private int id;
    private String name;
    private String registrationDate;
}
