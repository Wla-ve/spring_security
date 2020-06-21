package web.service;

import web.model.Role;

import java.util.List;

public interface RoleService {
    List<Role> getAll();
    void save(Role role);
    Role getById(Long id);
    void delete(Long id);
    void update(Role role);
    Role getByName(String name);
}
