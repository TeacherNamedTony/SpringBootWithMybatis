package cn.am.controller;

import cn.am.bean.DataJSONResult;
import cn.am.bean.User;
import cn.am.service.UserService;
import cn.am.util.Md5Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

@RestController
@CrossOrigin
@SessionAttributes("userNow")
public class LoginController {
    @Autowired
    private UserService userService;

    /**
     * 登录验证
     * @param user
     * @return
     */
    @GetMapping("/login")
    public DataJSONResult login(User user, Model model) {
        user.setPassword(Md5Token.getInstance().getLongToken(user.getPassword()));
        User userNow = userService.login(user);
        if (userNow != null) {
//            model.addAttribute("userNow", userNow);
            return DataJSONResult.build(200,"用户信息查询成功", userNow);
        } else {
            return DataJSONResult.errorMsg("用户名密码错误");
        }
    }

    /**
     * 退出
     * @return
     */
    @GetMapping("toLogin")
    public DataJSONResult toLogin() {
        return DataJSONResult.build(401, "用户名或密码错误。", null);
    }
}
