package redis;

import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

public class UserRepository {

	@Resource(name = "redisTemplate")
	private RedisTemplate<String, User> template;

	public void add(User user) {
		template.opsForValue().set(user.getLogin(), user);
	}

	public User get(String key) {
		return template.opsForValue().get(key);
	}
	
}
