package io.ipme.neptunes.Service;

import io.ipme.neptunes.Service.dto.UserDTO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@DisplayName("Test integration du UserService")
public class UserServiceTestIntegration {

    @Autowired
    private UserService userService;

    @Test
    public void testFindAll() {
        List<UserDTO> userDTOS = userService.findAll();

        Assertions.assertThat(userDTOS).isNotEmpty();
        org.junit.jupiter.api.Assertions.assertEquals(3, userDTOS.size(), "La liste ne contient pas 3 users");
        for (UserDTO userDTO :
                userDTOS) {
            Assertions.assertThat(userDTO.getUserName()).isNotNull();
            Assertions.assertThat(userDTO.getAvatar()).isNotNull();
        }
    }

}
