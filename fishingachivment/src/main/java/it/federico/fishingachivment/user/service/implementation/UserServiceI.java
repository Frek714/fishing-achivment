package it.federico.fishingachivment.user.service.implementation;

import it.federico.fishingachivment.user.dao.UserDAO;
import it.federico.fishingachivment.user.model.User;
import it.federico.fishingachivment.user.service.UserSERVICE;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceI implements UserSERVICE {

    @Autowired
    private final UserDAO userDAO;


    @Override
    public Optional<User> getUser(Long id) {
        return userDAO.findById(id);
    }

    @Override
    public List<User> getUsers() {
        return userDAO.findAll();
    }

    @Override
    public User postUser(User user) {
        return userDAO.save(user);
    }

    @Override
    public void updateUser(Long id, User user) {
        userDAO.findById(id).ifPresent(u -> userDAO.save(setUserField(u, user)));
    }

    @Override
    public void deleteUser(Long id) {
        userDAO.deleteById(id);
    }

    private User setUserField(User u, User user) {
        u.setPassword(user.getPassword());
        u.setUsername(user.getUsername());
        return u;
    }
}
