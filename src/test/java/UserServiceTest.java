import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tracker.data.UserService;
import tracker.structure.Goal;
import tracker.structure.Transaction;
import tracker.structure.User;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserServiceTest {
    private UserService userService;
    private static final String TEST_EMAIL = "test@example.com";
    private static final String TEST_PASSWORD = "password";
    private static final String TEST_NAME = "Test User";

    @BeforeEach
    public void setUp() {
        userService = new UserService();
    }


    @Test
    public void testRegisterUserWithExistingEmail() {
        userService.registerUser(TEST_EMAIL, TEST_PASSWORD, TEST_NAME);
        assertThrows(RuntimeException.class, () -> {
            userService.registerUser(TEST_EMAIL, TEST_PASSWORD, TEST_NAME);
        });
    }

    @Test
    public void testAuthenticateUserWithInvalidCredentials() {
        assertThrows(RuntimeException.class, () -> {
            userService.authenticateUser(TEST_EMAIL, "wrongpassword");
        });
    }
}
