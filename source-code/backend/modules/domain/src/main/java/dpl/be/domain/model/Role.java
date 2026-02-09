package dpl.be.domain.model;

import dpl.be.domain.vo.RoleName;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class Role {
    private final RoleName name;

    public Role(RoleName name) {
        this.name = name;
    }
}
