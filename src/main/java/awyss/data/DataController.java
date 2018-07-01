package awyss.data;

import awyss.account.Account;
import awyss.account.Role;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class DataController {

    @GetMapping("/data")
    public String signin() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        authentication.getAuthorities();
//        data.addAttribute("data", data);
        return "data/data";
    }
}
