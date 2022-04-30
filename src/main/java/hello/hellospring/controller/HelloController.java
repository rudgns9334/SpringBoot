package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello") // url hello를 받을 때
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        return "hello"; // /resources/templates/hello.html 을 찾아가라
    }

    @GetMapping("hello-mvc") //파라미터 보는건 컨트롤 p
    public String hellMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody   // http에서의 body부에 데이터를 직접 넣겠다.
    public String helloString(@RequestParam("name") String name){
        return "hello " + name; // "hello param"
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello; // json 방식
    }

    static class Hello {
        private String name;
        // generate 단축키 alt + insert
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
//view는 화면에 관련된 로직만 controller는 서버 뒷단의 로직을 담는다