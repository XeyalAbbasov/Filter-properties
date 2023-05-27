package az.khayal.springrestfiltering.converter;

import az.khayal.springrestfiltering.dto.UserDto;
import az.khayal.springrestfiltering.model.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserDtoConverter {

    public UserDto convert(User from){
        return new UserDto(from.getName(),from.getSurname(),from.getPhone(),from.getAddress(),from.getEmail());
    }

    public List<UserDto> convert(List<User> fromList) {

        return fromList.stream().map(this::convert).collect(Collectors.toList());
    }
}
