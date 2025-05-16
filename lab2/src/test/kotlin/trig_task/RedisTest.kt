package trig_task

import org.testcontainers.containers.GenericContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers
import org.testcontainers.utility.DockerImageName
import redis.clients.jedis.Jedis
import kotlin.test.assertEquals
import kotlin.test.Test
import kotlin.test.assertNull
import trig_task.redis_work.RedisExcel

@Testcontainers
class RedisTest {
    companion object {
        @JvmStatic
        @Container
        var redisContainer: GenericContainer<*> = GenericContainer<Nothing>(DockerImageName.parse("redis:7-alpine"))
            .withExposedPorts(6379)
    }
    @Test
    fun testRedisInsertion() {
        val address = redisContainer.host
        val port = redisContainer.getMappedPort(6379)

        val redisExcel = RedisExcel(address, port)

        Jedis(address, port).use { jedis ->
            assertNull(jedis.get("39_71"))

            val name = redisExcel.saveFile("comp", 39, 71)

            assertEquals(name, jedis.get("39_71"))

            val rName = redisExcel.getFile(39, 71)

            assertEquals(rName, jedis.get("39_71"))

            jedis.del("39_71")

            assertNull(redisExcel.getFile(39, 71))
        }
    }
}