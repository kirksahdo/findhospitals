package br.com.pelk.findhospital.backend.services;

import br.com.pelk.findhospital.backend.serialization.UserSerialization;
import br.com.pelk.findhospital.models.User;

public final class UserService {
    public static void createUser(User user) {
        UserSerialization.writeFile(user);
    }
}
