package org.cirdles.string.api;

/**
 * This class is used to separate business logic from the HTTP interface in
 * {@link StringResource}, improving the quality of the code base. If dealing
 * with more complex services, it is often useful to add an extra layer of
 * indirection by creating a separate interface and implementation for a
 * service.
 *
 * @see StringResource
 */
public class StringService {

    public String reverseString(String string) {
        StringBuilder reversedString = new StringBuilder();

        for (int i = string.length() - 1; i >= 0; i--) {
            reversedString.append(string.charAt(i));
        }

        return reversedString.toString();
    }

    public String upcaseString(String string) {
        return string.toUpperCase();
    }

}
