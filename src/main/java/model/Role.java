package model;

public enum Role {
    ADMIN("admin"), USER("user"), DEFAULT("default");

    private final String value;

    Role(String value) {
        this.value = value;
    }
}
