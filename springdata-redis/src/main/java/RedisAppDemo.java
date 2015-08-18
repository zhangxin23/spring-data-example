import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import redis.StringStringRepository;
import redis.User;
import redis.UserRepository;

/**
 * Author: zhangxin
 * Date:   15-8-18
 */
public class RedisAppDemo {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("redis/StringStringRepositoryTest-context.xml");

        StringStringRepository repository = (StringStringRepository)context.getBean("stringStringRepository");
        repository.add("12345", "11111");
        String rtn = repository.getValue("12345");
        System.out.printf("Key: %s, Value: %s\n", "12345", rtn);

        context = new ClassPathXmlApplicationContext("redis/UserRepositoryTest-context.xml");
        UserRepository userRepository = (UserRepository)context.getBean("userRepository");
        userRepository.add(new User("a", "b"));
        User user = userRepository.get("a");
        System.out.printf("User[login: %s, fullName: %s, lastLogin: %s]\n", user.getLogin(), user.getFullName(), user.getLastLogin().toString());
    }
}
