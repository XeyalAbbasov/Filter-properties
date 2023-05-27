package az.khayal.springrestfiltering.controller;

import az.khayal.springrestfiltering.dto.UserDto;
import az.khayal.springrestfiltering.model.User;
import az.khayal.springrestfiltering.request.CreateUserRequest;
import az.khayal.springrestfiltering.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(Integer id){

        return ResponseEntity.ok(userService.getUserById(id));
    }

    @GetMapping("for-users")
    public ResponseEntity<MappingJacksonValue> getAllForUsers(){

        return ResponseEntity.ok(userService.getAllForUsers());
    }

    @GetMapping("for-manager")
    public ResponseEntity<MappingJacksonValue> getAllForManager(){

        return ResponseEntity.ok(userService.getAllForManager());
    }

    @GetMapping("for-admin")
    public ResponseEntity<MappingJacksonValue> getAllForAdmin(){

        return ResponseEntity.ok(userService.getAllForAdmin());
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody final CreateUserRequest createUserRequest){

        return ResponseEntity.ok(userService.createUser(createUserRequest));
    }

}
