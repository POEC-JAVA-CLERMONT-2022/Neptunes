package io.ipme.neptunes.Service;

import io.ipme.neptunes.Service.dto.UserDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@DisplayName("Test des méthodes de UserService")
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    @DisplayName("Test de findAll")
    public void testFindAll() {
        // Creation de données
        /* Utilisation données en base */

        // Appel de la méthode testée
        List<UserDTO> userDTOS = userService.findAll();

        // test des valeurs
        for (UserDTO userDTO : userDTOS) {
            Assertions.assertNotNull(userDTO.getUserName(), "UserName is not set");
            Assertions.assertNotNull(userDTO.getAvatar(), "Avatar is not set");
        }

    }

}
