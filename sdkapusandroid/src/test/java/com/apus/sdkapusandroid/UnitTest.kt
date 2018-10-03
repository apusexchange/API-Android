package com.apus.sdkapusandroid

import com.apus.sdkapusandroid.comom.toSha256
import junit.framework.Assert.assertEquals
import org.junit.Test

class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals("03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4", "1234".toSha256())
    }
}