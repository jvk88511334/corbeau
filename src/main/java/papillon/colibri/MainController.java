package papillon.colibri;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import papillon.colibri.dao.SauterelleDao;

import java.sql.SQLException;
import java.util.Objects;

@Controller
public class MainController {
    @GetMapping("/")
    @ResponseBody
    public String home() throws SQLException {
        return String.valueOf(SauterelleDao.getAllUsers());
    }
}
