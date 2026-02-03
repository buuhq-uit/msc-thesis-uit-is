package dpl.be.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
//@RequiredArgsConstructor
public class UserController {
    @GetMapping("/admin")
//    @PreAuthorize("hasRole('ADMIN')")
    public String onlyAdmin() {
        return "Hello Admin!";
    }
}
