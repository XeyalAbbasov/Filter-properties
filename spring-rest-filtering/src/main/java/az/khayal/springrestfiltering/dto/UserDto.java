package az.khayal.springrestfiltering.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDto {

        private String name;
        private String surname;
        private String phone;
        private String address;
        private String email;

    public UserDto(String name, String surname, String phone, String address, String email) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.address = address;
        this.email = email;
    }
}
