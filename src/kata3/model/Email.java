package kata3.model;

import java.util.Objects;

public record Email(String email) {

    /**
     * @throws NullPointerException If {@code email} is null.
     */
    public Email {
        Objects.requireNonNull(email);
    }

    public String getDomain() {
        return email.substring(email.indexOf("@") + 1);
    }
}
