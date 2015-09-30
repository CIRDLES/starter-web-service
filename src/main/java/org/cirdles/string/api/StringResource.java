package org.cirdles.string.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * A resource is a collection of related HTTP endpoints. This class is a
 * resource comprised of string operations.
 * <p/>
 * Each method in this class corresponds to a single endpoint. Each endpoint's
 * path is a combination of class and method {@link Path} annotations (i.e.
 * {@code "string/reverse"} from {@code @Path("string")} on this class and
 * {@code @Path("reverse")} on the method {@link #reverseString(String)}). Paths
 * maybe also be influences by the {@code web.xml} and the resource's container
 * (i.e. Jetty or Tomcat). Each endpoint's HTTP verb is specified by its
 * method's {@link javax.ws.rs.DELETE}, {@link javax.ws.rs.GET}, {@link POST},
 * or {@link javax.ws.rs.PUT} annotation.
 * <p/>
 * Endpoints should also specify expected and provided
 * <a href="https://en.wikipedia.org/wiki/Media_type">media types</a>. These are
 * given using the {@link Produces} and {@link Consumes} annotations. An
 * endpoint's set of media types comes from both its method's and its class's
 * annotations.
 * <p/>
 * Notice that this class's only imports are from the package
 * {@link javax.ws.rs}. This package provides the
 * <a href="https://en.wikipedia.org/wiki/Java_API_for_RESTful_Web_Services">
 * Java API for RESTful Web Services (JAX-RS)</a>. JAX-RS is an interface for
 * specifying web resources. In this project, it is implemented by Jersey, the
 * reference implementation for JAX-RS. Jersey connects to its resources through
 * {@code src/main/webapp/WEB-INF/web.xml}.
 * <p/>
 * This resource delegates it logic to {@link StringService}. Doing this makes
 * this class more readable and makes the logic quickly and easily testable. It
 * is recommended that other projects follow this pattern as a best practice.
 *
 * @see <a href="http://www.oracle.com/splash/java.net/index.html">Jersey User
 * Guide</a>
 * @see StringService
 */
@Path("string")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class StringResource {

    private StringService stringService;

    public StringResource() {
        stringService = new StringService();
    }

    @POST
    @Path("reverse")
    public String reverseString(String string) {
        return stringService.reverseString(string);
    }

    @POST
    @Path("upcase")
    public String upperCaseString(String string) {
        return stringService.upcaseString(string);
    }

}
