package web.dao;

import web.model.Role;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class RoleDaoImpl implements RoleDao {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Role> getAll() {
        return entityManager.createQuery("select roles from Role roles", Role.class).getResultList();
    }

    @Override
    public void save(Role role) {
        entityManager.persist(role);
    }

    @Override
    public Role getById(Long id) {
        return entityManager.find(Role.class, id);
    }

    @Override
    public void delete(Long id) {
        entityManager.createQuery("delete from Role role where role.id = :id").
                setParameter("id", id).
                executeUpdate();
    }

    @Override
    public void update(Role role) {
        entityManager.merge(role);
    }

    @Override
    public Role getByName(String name) {
        return entityManager.createQuery("SELECT role FROM Role role WHERE role.name = : name", Role.class).
                setParameter("name",name).
                getSingleResult();
    }
}
