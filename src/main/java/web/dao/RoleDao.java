package web.dao;

import web.model.Role;

import java.util.List;

public interface RoleDao {
    List<Role> getAll();
    void save(Role role);
    Role getById(Long id);
    void delete(Long id);
    void update(Role role);
    Role getByName(String name);
}