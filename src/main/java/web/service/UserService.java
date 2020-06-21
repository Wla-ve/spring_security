package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    List<User> getAll();
    void save(User user);
    User getById(Long id);
    void delete(Long id);
    void update(User user);
    User getByName(String name);
}
