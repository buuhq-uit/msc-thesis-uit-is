package dpl.be.domain.vo;

public record RoleName (String value) {
    public RoleName {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Role name must not be empty");
        }
    }
}
