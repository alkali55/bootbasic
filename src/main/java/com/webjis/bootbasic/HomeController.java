package com.webjis.bootbasic;

import com.webjis.bootbasic.domain.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(){
        return "index";
    }

    @GetMapping("/textbasic")
    public String textBasic(Model model){

        model.addAttribute("data", "Hello, Thymeleaf!");
        model.addAttribute("unescapedData", "<Strong>Hello, Thymeleaf!</strong>");

        return "/basic/textbasic";
    }

    @GetMapping("/variable")
    public String variable(Model model){

        User hong = new User("hong", 10);
        User choi = new User("choi", 20);

        List<User> list = new ArrayList<>();
        list.add(hong);
        list.add(choi);

        Map<String, User> map = new HashMap<>();
        map.put("choi", choi);
        map.put("hong", hong);

        model.addAttribute("user", choi);
        model.addAttribute("users", list);
        model.addAttribute("userMap", map);

        return "/basic/variable";
    }

    @GetMapping("/basicobject")
    public String basicObject(Model model, HttpSession session){

        session.setAttribute("sessionData", "세션데이터");

        return "/basic/basicobject";
    }
}
