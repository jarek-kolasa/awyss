package war.data;

import org.springframework.web.bind.annotation.GetMapping;

public class Data {
    @GetMapping("data")
    public String signin() {
        return "data/data";
    }
}
