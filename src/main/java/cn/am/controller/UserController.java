package cn.am.controller;

import cn.am.bean.DataJSONResult;
import cn.am.bean.Apply;
import cn.am.bean.State;
import cn.am.bean.User;
import cn.am.service.UserService;
import cn.am.util.Md5Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@CrossOrigin
//@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 查询所有授权记录
     * isgrant 是否被授权
     * 0未授权，待授权
     * 1授权，已授权
     * 2授权过期
     * 3授权异常
     *
     * @return
     */
    @GetMapping("getState")
    public DataJSONResult getState(User user) {
        List<State> list = userService.getState(user.getId());
        return DataJSONResult.build(200, "用户查询所有授权申请情况成功", list);
    }

    /**
     * 查询未被授权记录
     *
     * @return
     */
    @GetMapping("getUntreatedState")
    public DataJSONResult getUntreatedState(User user) {
        List<State> list = userService.getUntreatedState(user.getId());
        return DataJSONResult.build(200, "用户未授权查询成功", list);
    }

    /**
     * 查询被授权记录
     *
     * @return
     */
    @GetMapping("getAuditedState")
    public DataJSONResult getAuditedState(User user) {
        List<State> list = userService.getAuditedState(user.getId());
        return DataJSONResult.build(200, "用户已授权查询成功", list);
    }

    /**
     * 查询用户到期记录授权
     *
     * @param user
     * @return
     */
    @GetMapping("getEndState")
    public DataJSONResult getEndState(User user) {
        List<State> list = userService.getEndState(user.getId());
        return DataJSONResult.build(200, "用户授权到期查询成功", list);
    }

    /**
     * \
     * 查询用户异常授权
     *
     * @param user
     * @return
     */
    @GetMapping("getRevoke")
    public DataJSONResult getRevoke(User user) {
        List<State> list = userService.getRevoke(user.getId());
        return DataJSONResult.build(200, "用户授权异常查询成功", list);
    }

    /**
     * 查询用户不足30天授权
     *
     * @param user
     * @return
     */
    @GetMapping("getNearOverdue")
    public DataJSONResult getNearOverdue(User user) {
        List<State> list = userService.getNearOverdue(user.getId());
        return DataJSONResult.build(200, "用户授权不足30天查询成功", list);
    }

    /**
     * 普通用户申请授权
     *
     * @param apply
     * @return
     */
    @GetMapping("addNewApply/{loginUserId}")
    public DataJSONResult addNewApply(@PathVariable("loginUserId") String loginUserId,
                                      Apply apply, HttpSession session) {
        userService.addNewApply(loginUserId,apply, session);
        return DataJSONResult.ok();
    }

    /**
     * 用户重新申请授权三个月
     *
     * @param state
     * @return
     */
    @GetMapping("reApply")
    public DataJSONResult reApply(State state) {

        boolean ret = userService.reApply(state);
        if (ret) {
            return DataJSONResult.ok();
        } else {
            return DataJSONResult.errorMsg("更新失败");
        }
    }

    /**
     * 用户修改密码
     * @param newPassword
     * @param id
     * @param session
     * @return
     */
    @GetMapping("changePassword/{newPassword}")
    public DataJSONResult changePassword(@PathVariable("newPassword") String newPassword,
                                         @RequestParam(value = "id",required = false) String id, HttpSession session) {
        String password = newPassword;
        String p = Md5Token.getInstance().getLongToken(password);
        System.out.print(p);
        User u = new User();
        u.setId(id);
        u.setPassword(p);
        System.out.println(u.toString());
        boolean ret = userService.changePassword(u);
        if (ret) {
            return DataJSONResult.ok();
        } else {
            return DataJSONResult.errorMsg("修改密码失败。");
        }
    }
}
