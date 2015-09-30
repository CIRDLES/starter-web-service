package org.cirdles.string.api;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Integration tests (IT) for {@link StringResource}. The purpose of these
 * tests is not to be exhaustive, but to check each endpoint, focusing on the
 * HTTP response status and media type.
 * <p/>
 * Note that this integration test class differs from typical JUnit integration
 * test classes in two ways. First, this class extends {@link JerseyTest}, which
 * provides utilities for starting and interacting with a test server. Second,
 * this class has the method {@link #configure()}, which specifies the resource
 * to be used in conjunction with these integration tests.
 * <p/>
 * To verify content correctness, create a second class containing the logic
 * backing the resource and write separate unit tests for that class.
 *
 * @see <a href="https://jersey.java.net/documentation/latest/test-framework.html">
 * Jersey Test Framework Documentation</a>
 * @see StringResource
 * @see StringService
 * @see StringServiceTest
 */
public class StringResourceIT extends JerseyTest {

    @Override
    protected Application configure() {
        return new ResourceConfig(StringResource.class);
    }

    @Test
    public void testReverseString() {
        Response response = target()
                .path("string/reverse")
                .request()
                .post(Entity.text("Hello"));

        assertThat(response.getStatus(), is(200));
        assertThat(response.getMediaType(), is(MediaType.TEXT_PLAIN_TYPE));
        assertThat(response.readEntity(String.class), is("olleH"));
    }

    @Test
    public void testUpcaseString() {
        Response response = target()
                .path("string/upcase")
                .request()
                .post(Entity.text("Hello"));

        assertThat(response.getStatus(), is(200));
        assertThat(response.getMediaType(), is(MediaType.TEXT_PLAIN_TYPE));
        assertThat(response.readEntity(String.class), is("HELLO"));
    }

}
