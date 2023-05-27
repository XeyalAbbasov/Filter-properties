package az.khayal.springrestfiltering.request;

import lombok.Getter;

@Getter
public class CreateUserRequest {
    private String name;
    private String surname;
    private String phone;
    private String address;
    private String email;
}
