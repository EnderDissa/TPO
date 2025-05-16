package trig_task.redis_work

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import redis.clients.jedis.Jedis

class RedisExcel(
    private val host: String,
    private val port: Int
) {
    fun saveFile(name: String, userId: Int, connectId: Int): String {
        val currentDateTime = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
        val formatted = currentDateTime.format(formatter)

        val fullName = "${name}_${userId}_${connectId}_${formatted}"

        Jedis(host, port).use { jedis ->
            jedis.set("${userId}_${connectId}", fullName)
        }
        return fullName
    }

    fun getFile(userId: Int, connectId: Int): String? {
        val fullName: String?
        Jedis(host, port).use { jedis ->
            fullName = jedis.get("${userId}_${connectId}")
        }
        return fullName
    }
}