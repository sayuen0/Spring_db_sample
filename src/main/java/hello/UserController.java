package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import hello.User;
import hello.UserRepository;

@Controller
@RequestMapping(path = "/demo")

public class UserController {
  @Autowired
  private UserRepository userRepository;

  @GetMapping(path = "/add")
  public @ResponseBody String addNewUser(@RequestParam String name, @RequestParam String email) {
    // Responsebodyクラスは、帰ってくるStringがViewでなくresponseであると意味する
    // @RequestParam means it is a parameter from the GET or POST request

    User u = new User();
    u.setName(name);
    u.setEmail(email);
    userRepository.save(u);
    return "Saved";
  }

  @GetMapping(path = "/all")
  public @ResponseBody Iterable<User> getAllUsers() {
    return userRepository.findAll();
  }
}
