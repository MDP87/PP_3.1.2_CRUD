package ru.crud.crud_312.controller;


import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.crud.crud_312.model.User;
import ru.crud.crud_312.service.UserServiceImp;

@Controller
@RequestMapping("/")
public class UserController {
  private final UserServiceImp userServiceImp;
  @Autowired
  public UserController (UserServiceImp userServiceImp) {
    this.userServiceImp = userServiceImp;
  }

  @GetMapping(value = "/")
  public String printWelcome(ModelMap model) {
    List<String> messages = new ArrayList<>();
    messages.add("Hello!");
    model.addAttribute("messages", messages);
    return "index";
  }

  @GetMapping("/users")
  public String showAllUsers(Model model) {
    List<User> list = userServiceImp.findAll();
    model.addAttribute("users", list);
    return "users";
  }
  @GetMapping("/add")
  public String addToIndexUser(Model model) {
    model.addAttribute("user", new User());
    return "add";
  }
  @PostMapping("/addNewUser")
  public String addNewUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
    if (bindingResult.hasErrors())
      return "add";

    userServiceImp.save(user);
    return "redirect:/users";
  }
  @GetMapping("/update/{id}")
  public String editUser(@PathVariable("id") long id, Model model) {
    model.addAttribute("user", userServiceImp.findById(id));
    return "update";
  }
  @PatchMapping("/user/{id}")
  public String updateUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult, @PathVariable("id") long id ) {
    if (bindingResult.hasErrors())
      return "update";
    userServiceImp.updateUser(id, user);

    return "redirect:/users";
  }
  @DeleteMapping("/delete/{id}")
  public String deleteUser(@PathVariable("id") long id) {
    userServiceImp.delete(id);
    return "redirect:/users";
  }

}
