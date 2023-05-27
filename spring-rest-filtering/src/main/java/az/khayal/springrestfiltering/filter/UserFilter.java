package az.khayal.springrestfiltering.filter;

import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonFilter(value = "userFilter")
public class UserFilter {

    private String name;
    private String surname;
    private String phone;
    private String address;
    private String email;

}
