package dpl.be.rest.user;

import dpl.be.application.user.usecase.AssignRoleToUserUseCase;
import dpl.be.application.user.usecase.CreateUserUseCase;
import dpl.be.application.user.usecase.DisableUserUseCase;
import dpl.be.domain.vo.RoleName;
import dpl.be.rest.user.dto.AssignRoleRequest;
import dpl.be.rest.user.dto.CreateUserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final CreateUserUseCase createUserUseCase;
    private final AssignRoleToUserUseCase assignRoleToUserUseCase;
    private final DisableUserUseCase disableUserUseCase;

    @PostMapping
//    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> create(@RequestBody CreateUserRequest request) {
        // demo: hash giả, thực tế dùng PasswordEncoder
        String hashed = "hashed-" + request.password();

        var user = createUserUseCase.createLocalUser(UUID.randomUUID(), hashed);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/{id}/roles")
    public ResponseEntity<?> assignRole(
            @PathVariable UUID id,
            @RequestBody AssignRoleRequest request
    ) {
        assignRoleToUserUseCase.assign(id, RoleName.valueOf(request.role()));
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}/disable")
    public ResponseEntity<?> disable(@PathVariable UUID id) {
        disableUserUseCase.disable(id);
        return ResponseEntity.ok().build();
    }

}
