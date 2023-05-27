package az.khayal.springrestfiltering.filter;

import az.khayal.springrestfiltering.model.User;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.modelmapper.ModelMapper;
import org.springframework.http.converter.json.MappingJacksonValue;

import java.util.ArrayList;
import java.util.List;

public class MyFiltering {

    public static List<UserFilter> dtos(List<User> users, ModelMapper mapper) {
        List<UserFilter> userFilters = new ArrayList<>();
        for (User s : users) {
            UserFilter dto = new UserFilter();
            mapper.map(s, dto);
            userFilters.add(dto);
        }
        return userFilters;
    }

    public static MappingJacksonValue filter(Object data,String type,String ... states){
    SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter
            .filterOutAllExcept(states);
    FilterProvider provider = new SimpleFilterProvider()
            .addFilter(type, filter);

    MappingJacksonValue value = new MappingJacksonValue(data);
            value.setFilters(provider);
            return value;
    }
}
