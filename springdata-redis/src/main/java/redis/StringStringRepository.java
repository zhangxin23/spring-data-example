package redis;

import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

public class StringStringRepository {
	
	@Resource(name = "redisTemplate")
	private RedisTemplate<String, String> template;	
	
	public void add(String key, String value) {
		template.opsForValue().set(key, value);

	}
	
	public String getValue(String key) {
		return template.opsForValue().get(key);
	}
	
	public void delete(String key) {
		template.opsForValue().getOperations().delete(key);
	}
}
