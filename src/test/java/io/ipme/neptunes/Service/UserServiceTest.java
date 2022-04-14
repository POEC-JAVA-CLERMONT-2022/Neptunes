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

/*  // Essai Charle de mock
    @Test
    public void testCreationLegume()
    {
        when(mockedLegumeRepo.save(Mockito.any(Legume.class))).thenReturn(new Legume(null, null, 0, 0, null, false, false, null));
        Legume testLegume = legumeService.create(null, 0, 0, null, false, false, null);
        // test null
        assertNotNull(testLegume);
        // test id null comme dans le test
        Assertions.assertEquals(testLegume.getIdLegume(), null);
        // test objet non null
        assertThat(testLegume).isNotNull();
        // test id null comme dans le test
        assertThat(testLegume.getIdLegume()).isNull();
        // test si les références sont égales
        assertThat(testLegume).isSameAs(new Legume(null, null, 0, 0, null, false, false, null));
        // test si tous les champs sont ok par rapport au premier argument
        assertThat(testLegume).usingRecursiveComparison().isEqualTo(new Legume (null, null, 0, 0, null, false, false, null));

        // Vérifie une fois l'utilisation du repo mocked avec un legume mocked
        Mockito.verify(mockedLegumeRepo, times(1)).save(Mockito.any(Legume.class));
    }
*/

}
