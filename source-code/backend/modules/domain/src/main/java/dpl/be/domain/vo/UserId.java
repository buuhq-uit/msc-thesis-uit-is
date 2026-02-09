package dpl.be.domain.vo;

import java.util.UUID;

public record UserId(UUID value) {
    public static UserId newId() {
        return new UserId(UUID.randomUUID());
    }
}
