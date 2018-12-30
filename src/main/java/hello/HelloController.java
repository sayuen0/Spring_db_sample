
package hello;

import java.util.Arrays;
import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

  @GetMapping({ "/hello", "/" })
  public String hello(Model model) {
    model.addAttribute("hoge", new Hoge()).addAttribute("modelValue", "Model Value");
    return "hello";
  }

  // 内部クラス
  public static class Hoge {
    public int publicField = 1;

    public int publicMethod() {
      return 2;
    }

    public int getPublicValue() {
      return 3;
    }
  }

  @GetMapping("/greet")
  public String greet(Model model) {
    Greeting greet = new Greeting(1, "Hello thymeleaf!!");
    model.addAttribute("id", greet.getId()).addAttribute("content", greet.getContent());
    return "greet";
  }

  @GetMapping("/map")
  public String map(Model model) {
    HashMap<String, String> map = new HashMap<>();
    map.put("message", "hello world!");

    model.addAttribute("map", map);
    return "map";
  }

  @GetMapping("/each")
  public String each(Model model) {
    // Listをadd
    model.addAttribute("list", Arrays.asList("hoge", "huga", "poyo"));
    // Mapをadd
    HashMap<String, String> map = new HashMap<>();
    map.put("hoge", "HOGE");
    map.put("fuga", "FUGA");
    map.put("piyo", "PIYO");
    model.addAttribute("map", map);
    return "each";

  }

}
