package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;


    @Transactional(readOnly = true)
    public List<User> getAll() {
        return userDao.getAll();
    }


    @Transactional
    public void save(User user) {
        userDao.save(user);
    }


    @Transactional(readOnly = true)
    public User getById(Long id) {
        return userDao.getById(id);
    }


    @Transactional
    public void delete(Long id) {
        userDao.delete(id);
    }

    @Override
    @Transactional
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    @Transactional(readOnly = true)
    public User getByName(String name) {
        return userDao.getByName(name);
    }
}
