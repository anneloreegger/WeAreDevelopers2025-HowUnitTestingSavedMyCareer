package parametrizedtests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PermissionServiceTest {

    private final PermissionService permissionService = new PermissionService();

    @ParameterizedTest
    @EnumSource(value = UserRole.class, names = {"ADMIN", "MODERATOR"})
    void testRolesWithAdminAccess(UserRole role) {
        assertTrue(permissionService.canAccessAdminPanel(role));
    }

    @ParameterizedTest
    @EnumSource(value = UserRole.class, names = {"ADMIN", "MODERATOR"}, mode = EnumSource.Mode.EXCLUDE)
    void testRolesWithoutAdminAccess(UserRole role) {
        assertFalse(permissionService.canAccessAdminPanel(role));
    }
}

