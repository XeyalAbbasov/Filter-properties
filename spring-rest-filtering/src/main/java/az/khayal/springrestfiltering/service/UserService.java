package az.khayal.springrestfiltering.service;

import az.khayal.springrestfiltering.converter.UserDtoConverter;
import az.khayal.springrestfiltering.dto.UserDto;
import az.khayal.springrestfiltering.exception.EmailRepitionException;
import az.khayal.springrestfiltering.exception.UserNotFoundException;
import az.khayal.springrestfiltering.model.User;
import az.khayal.springrestfiltering.request.CreateUserRequest;
import az.khayal.springrestfiltering.repository.UserRepository;
import az.khayal.springrestfiltering.filter.MyFiltering;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserDtoConverter converter;
    private final ModelMapper mapper;

    public User getUserById(Integer id) {
        User user = findUserById(id);
        return userRepository.findById(id).get();
    }

    public MappingJacksonValue getAllForUsers() {

            return MyFiltering.filter(MyFiltering.dtos(userRepository.findAll(),mapper),
                    "userFilter","name","surname");
    }

    public MappingJacksonValue getAllForManager() {

        return MyFiltering.filter(MyFiltering.dtos(userRepository.findAll(),mapper),
                "userFilter","name","surname","phone");
    }

    public MappingJacksonValue getAllForAdmin() {

        return MyFiltering.filter(MyFiltering.dtos(userRepository.findAll(),mapper),
                "userFilter","name","surname","phone","address","email");

    }
    public UserDto createUser(final CreateUserRequest request) {

          boolean emailExists= userRepository.existsByEmail(request.getEmail());
            if (!emailExists) {
            User user = new User(request.getName(),
                    request.getSurname(),
                    request.getPhone(),
                    request.getAddress(),
                    request.getEmail());
            return converter.convert(userRepository.save(user));
        } else {
            throw new EmailRepitionException("This email has already been used!");
        }
    }

    protected User findUserById(Integer id){

        return userRepository.findById(id).orElseThrow(()-> new UserNotFoundException("User not found by following id: " + id));
    }

    @ExceptionHandler
    public ResponseEntity<String> handleAllTypesOfExceptions(EmailRepitionException exception){

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(exception.getMessage());
    }


}
