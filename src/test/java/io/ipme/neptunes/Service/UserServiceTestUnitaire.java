package io.ipme.neptunes.Service;

import io.ipme.neptunes.Model.User;
import io.ipme.neptunes.Repository.PlaylistRepository;
import io.ipme.neptunes.Repository.UserGameRepository;
import io.ipme.neptunes.Repository.UserRepository;
import io.ipme.neptunes.Service.dto.UserDTO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@DisplayName("Test unitaire du UserService")
@ExtendWith(MockitoExtension.class)
public class UserServiceTestUnitaire {

    @Mock
    private UserRepository userRepository;

    @Mock
    private PlaylistRepository playlistRepository;

    @Mock
    private UserGameRepository userGameRepository;

    @Autowired
    private UserService userService;

    @BeforeEach
    void setupBeforeEach() {
        userService = new UserService(userRepository, playlistRepository, userGameRepository);
    }

    @Test
    @DisplayName("Test de la méthode findAll")
    public void testFindAll() {
        // data creation
        List<User> users = new ArrayList<>();
        users.add(new User("user1", "user1@neptunes.com", "user1mdp", "user1avatar", false));
        users.add(new User("user2", "user2@neptunes.com", "user2mdp", "user2avatar", true));
        Mockito.when(userRepository.findAll()).thenReturn(users);

        // call method to test
        List<UserDTO> userDTOS = userService.findAll();

        // assertions
        Assertions.assertThat(userDTOS).isNotEmpty();
        org.junit.jupiter.api.Assertions.assertEquals(2, userDTOS.size(), "La liste ne contient pas 2 users !");
        for (UserDTO userDTO :
                userDTOS) {
            Assertions.assertThat(userDTO.getUserName()).isNotNull();
            Assertions.assertThat(userDTO.getAvatar()).isNotNull();
        }
    }


}
