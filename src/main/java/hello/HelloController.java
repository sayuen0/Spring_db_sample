
package hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

  @GetMapping("/hello")
  public String hello(Model model) {
    model.addAttribute("hoge", new Hoge()).addAttribute("modelValue", "Model Value");
    return "hello";
  }

  public static class Hoge {
    public int publicField = 1;

    public int publicMethod() {
      return 2;
    }

    public int getPublicValue() {
      return 3;
    }
  }
}
