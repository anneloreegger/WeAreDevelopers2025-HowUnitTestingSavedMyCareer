package parametrizedtests;

public class PermissionService {

    public boolean canAccessAdminPanel(UserRole role) {
        return switch (role) {
            case ADMIN, MODERATOR -> true;
            default -> false;
        };
    }
}

