//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import tracker.data.DataBaseTracker;
//
//import static org.junit.jupiter.api.Assertions.assertThrows;
//
//
//public class TestDataBaseTracker {
//    private DataBaseTracker dataBaseTracker;
//
//    @BeforeEach
//    public void setUp() {
//        dataBaseTracker = new DataBaseTracker();
//    }
//
//    @Test
//    public void testRegisterUser() {
//        dataBaseTracker.registration("test@example.com", "password");
//        User user = userService.getUser("test@example.com");
//        assertThat(user).isNotNull();
//        assertThat(user.getEmail()).isEqualTo("test@example.com");
//    }
//
//    @Test
//    public void testAuthenticateUser() {
//        userService.registerUser("test@example.com", "password");
//        User user = userService.authenticateUser("test@example.com", "password");
//        assertThat(user).isNotNull();
//    }
//
//    @Test
//    public void testUpdateUserPassword() {
//        userService.registerUser("test@example.com", "password");
//        userService.updateUserPassword("test@example.com", "newpassword");
//        User user = userService.getUser("test@example.com");
//        assertThat(user.getPassword()).isEqualTo("newpassword");
//    }
//
//    @Test
//    public void testDeleteUser() {
//        userService.registerUser("test@example.com", "password");
//        userService.deleteUser("test@example.com");
//        User user = userService.getUser("test@example.com");
//        assertThat(user).isNull();
//    }
//
//    @Test
//    public void testRegisterUserWithExistingEmail() {
//        userService.registerUser("test@example.com", "password");
//        assertThrows(RuntimeException.class, () -> {
//            userService.registerUser("test@example.com", "password");
//        });
//    }
//
//    @Test
//    public void testAuthenticateUserWithInvalidCredentials() {
//        assertThrows(RuntimeException.class, () -> {
//            userService.authenticateUser("test@example.com", "wrongpassword");
//        });
//    }
//}
