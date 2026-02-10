package dpl.be.domain.model;

import dpl.be.domain.vo.RoleName;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
@AllArgsConstructor
public class Role {
//    private Long id;
    private final RoleName name;


}
