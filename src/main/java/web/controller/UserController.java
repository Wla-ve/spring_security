package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.User;
import web.service.UserServiceImpl;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping("/")
    public String getUsers(ModelMap model) {
        List<User> allUsers = userService.getAll();
        model.addAttribute("users", allUsers);
        return "users";
    }

    @RequestMapping("/addNewUser")
    public String addNewUser(ModelMap model) {
        User user = new User();
        model.addAttribute("user", user);
        return "user";
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/";
    }

    @RequestMapping("/updateInfo")
    public String update(@RequestParam("usId") Long id, ModelMap model) {
        User user = userService.getById(id);
        model.addAttribute("user", user);
        return "user";
    }

    @RequestMapping("/deleteUser")
    public String deleteUsers(@RequestParam("usId") Long id) {
        userService.delete(id);
        return "redirect:/";
    }
}
