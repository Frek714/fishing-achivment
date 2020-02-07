package it.federico.fishingachivment.user.service;

import it.federico.fishingachivment.user.model.User;

import java.util.List;
import java.util.Optional;

public interface UserSERVICE {

    Optional<User> getUser(Long id);

    List<User> getUsers();

    User postUser(User user);

    void updateUser(Long id, User user);

    void deleteUser(Long id);
}
