package org.cirdles.string.api;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Unit tests for {@link StringService}. Neither this test class (nor the string
 * service) know that the service is being exposed as a web API. Instead, the
 * purpose of these tests is to quickly check business logic without the
 * overhead of running a test server.
 *
 * @see StringService
 */
public class StringServiceTest {

    private StringService stringService;

    @Before
    public void setUp() {
        stringService = new StringService();
    }

    @Test
    public void testReverseString() throws Exception {
        assertThat(stringService.reverseString(""), is(""));
        assertThat(stringService.reverseString("Hello"), is("olleH"));
    }

    @Test
    public void testUpcaseString() {
        assertThat(stringService.upcaseString(""), is(""));
        assertThat(stringService.upcaseString("hello"), is("HELLO"));
        assertThat(stringService.upcaseString("HeLlO"), is("HELLO"));
        assertThat(stringService.upcaseString("HELLO"), is("HELLO"));
    }

}