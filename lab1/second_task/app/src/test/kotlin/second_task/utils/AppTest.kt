package second_task.utils

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class HashTableJUnit5Test {

    @Test
    fun `test empty table`() {
        val table = HashTable<String>()
        assertEquals(0, table.count())
        assertEquals(0.0, table.loadFactor())
        assertNull(table["test"])
        assertFalse("test" in table)
    }

    @Test
    fun `test insertion and lookup`() {
        val table = HashTable<String>(4) // Small size to test resizing
        
        table += "a"
        table += "b"
        
        assertEquals(2, table.count())
        assertTrue("a" in table)
        assertTrue("b" in table)
        assertEquals("a", table["a"])
        assertEquals("b", table["b"])
    }

    @Test
    fun `test collision handling`() {
        val table = HashTable<String>(4)
        
        table += "a"
        table += "a"
        table += "a"
        
        assertEquals(3, table.count())
        assertTrue("a" in table)
        assertFalse("b" in table)
        assertFalse("c" in table)
    }

    @Test
    fun `test removal`() {
        val table = HashTable<String>(4)
        
        table += "a"
        table += "b"
        table.remove("a")
        
        assertEquals(1, table.count())
        assertFalse("a" in table)
        assertTrue("b" in table)
    }

    @Test
    fun `test resizing`() {
        val table = HashTable<String>(4)
        
        table += "a"
        table += "b"
        assertEquals(4, table.getSize())
        table += "c"
        table += "d"
        assertEquals(8, table.getSize())
        assertEquals(4, table.count())
    }

    @Test
    fun `test load factor calculation`() {
        val table = HashTable<String>(10)
        assertEquals(0.0, table.loadFactor())
        
        table += "a"
        assertEquals(0.1, table.loadFactor())
        
        repeat(6) { table += "$it" }
        assertEquals(0.7, table.loadFactor())
    }

    @Test
    fun `test contains operator`() {
        val table = HashTable<String>()
        assertFalse("a" in table)
        
        table += "a"
        assertTrue("a" in table)
    }
}