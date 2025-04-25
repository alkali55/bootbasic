package com.webjis.bootbasic;

import com.webjis.bootbasic.domain.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.*;

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

    @GetMapping("link")
    public String link(Model model){

        model.addAttribute("name", "hong");
        model.addAttribute("age", "10");

        return "/basic/link";
    }

    @GetMapping("/date")
    public String date(Model model){

        model.addAttribute("localDateTime", LocalDateTime.now());
        model.addAttribute("calendar", Calendar.getInstance());
        model.addAttribute("date", new Date());
        model.addAttribute("timestamp", new Timestamp(System.currentTimeMillis()));
        return "/basic/date";
    }

    @GetMapping("/literal")
    public String literal(Model model){

        model.addAttribute("data", "thymeleaf");
        model.addAttribute("isValid", true);
        model.addAttribute("isNull", null);
        return "/basic/literal";
    }

    @GetMapping("/operation")
    public String operation(Model model) {

        model.addAttribute("isValid", true);
        model.addAttribute("isNull", null);
        model.addAttribute("data", "thymeleaf");
        return "/basic/operation";

    }

    @GetMapping("/attr")
    public String attr() {


        return "/basic/attr";

    }

    @GetMapping("/theach")
    public String theach(Model model) {

        User hong = new User("hong", 10);
        User choi = new User("choi", 20);
        User lee = new User("lee", 30);

        List<User> list = new ArrayList<>();
        list.add(hong);
        list.add(choi);
        list.add(lee);

        Map<String, User> map = new HashMap<>();
        map.put("choi", choi);
        map.put("hong", hong);
        map.put("lee", lee);


        model.addAttribute("userMap", map);
        model.addAttribute("users", list);
        return "/basic/theach";

    }

    @GetMapping("/comments")
    public String comments() {

        return "/basic/comments";

    }

    @GetMapping("/inlinejs")
    public String inlinejs(Model model) {
        model.addAttribute("user", new User("hong", 10));

        User hong = new User("hong", 10);
        User choi = new User("choi", 20);
        User lee = new User("lee", 30);

        List<User> list = new ArrayList<>();
        list.add(hong);
        list.add(choi);
        list.add(lee);

        model.addAttribute("users", list);
        return "/basic/inlinejs";

    }

}
