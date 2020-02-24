package cn.am.controller;

import cn.am.bean.Apply;
import cn.am.bean.DataJSONResult;
import cn.am.bean.State;
import cn.am.bean.User;
import cn.am.service.AdminService;
import cn.am.util.Clibrary;
import cn.am.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.nio.ByteBuffer;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
//@RequestMapping("admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    /**
     * 管理员首页-待处理 查询所有未授权的state isgrant=0
     * @return list-state[state的字段，userDetail，applyDetail]
     */
    @GetMapping("getAllStateNotPass")
    public DataJSONResult getAllStateNotPass() {
        List<State> list = adminService.getAllStateNotPass();
        return DataJSONResult.build(200, "管理员查询所有未授权成功", list);
    }

    /**
     * 管理员首页-已审核 查询所有授权的state  isgrant=1
     * @return list-state[state的字段，userDetail，applyDetail]
     */
    @GetMapping("getAllPassState")
    public DataJSONResult getAllPassState() {
        List<State> list = adminService.getAllPassState();
        return DataJSONResult.build(200, "管理员查询所有已授权成功", list);
    }

    /**
     * 管理员首页-授权过期  isgrant=2
     * @return list-state[state的字段，userDetail，applyDetail]
     */
    @GetMapping("getAllEndState")
    public DataJSONResult getAllEndState() {
        List<State> list = adminService.getAllEndState();
        return DataJSONResult.build(200, "管理员查询过期授权成功", list);
    }


    /**
     * 管理员首页-注销 查询所有授权异常的state  isgrant=3
     * @return list-state[state的字段，userDetail，applyDetail]
     */
    @GetMapping("getAllRevoke")
    public DataJSONResult getAllRevoke() {
        List<State> list = adminService.getAllRevoke();
        return DataJSONResult.build(200, "管理员查询异常授权成功", list);
    }

    /**
     * 管理员首页-注销 查询所有授权不足30天
     * @return list-state[state的字段，userDetail，applyDetail]
     */
    @GetMapping("getAllNearOverdue")
    public DataJSONResult getAllNearOverdue() {
        List<State> list = adminService.getAllNearOverdue();
        return DataJSONResult.build(200, "管理员查询授权不足30天成功", list);
    }

    /**
     * 管理员批准授权
     * @param sid     state->sid
     * @param applyid state->applyid
     * @return
     */
    @GetMapping("ratify/{loginUserId}")
    public DataJSONResult ratify(@PathVariable("loginUserId") String loginUserId,
                                  @RequestParam(value = "applyId",required = false) String applyId,
                                  @RequestParam(value = "sid",required = false) String sid, HttpSession session) {

        String aid = loginUserId;
        String isgrant = "1";
        String grantdate = DateUtil.dateToSimpleStr(new Date());

//        根据applyId查询applyDetail
        Apply applyDetail = adminService.getApplyByApplyid(applyId);
        String machinenum = applyDetail.getMachinenum();
        String productversion = applyDetail.getProductversion();
        String desktopcon = applyDetail.getDesktopcon();
        String grantbegindate = applyDetail.getGrantbegindate().replace("-","");
        String grantenddate = applyDetail.getGrantenddate().replace("-","");

        System.out.println("----------------------------------------------------------" +
                "-----------------------------CSSE平台授权-----------------------------" +
                "---------------------------------------------------------------------");
//		  机器码和授权信息
        String inputStr = new String();
//        inputStr组成结构：机器码|平台版本号|桌面连接数|开始时间|结束时间
        inputStr = machinenum+"|"+productversion+"|"+desktopcon+"|"+grantbegindate+"|"+grantenddate;
        System.out.println("    机器授权信息===>"+inputStr);

//		  计算输入长度长度l
        int input_src_len = inputStr.length();
        System.out.println("    授权机器信息码长度===>"+input_src_len);

//		计算输出长度
        int base64de_len;
        if (input_src_len < 256) {
            base64de_len = 1024;
        }
        else
        {
            base64de_len=input_src_len*2;
        }
        System.out.println("    分配授权码输出空间===>"+base64de_len);


//		输出空间
        ByteBuffer bBuf = ByteBuffer.allocate(4096);


//      生成license
        Clibrary instance = Clibrary.INSTANCE;
        //d加密内容
        int realer = instance.RsaLicenseEncode(inputStr,input_src_len+1, bBuf.array(), base64de_len);
        String license = new String(bBuf.array()).trim();

        State s = new State();
        s.setSid(sid);
        s.setAid(aid);
        s.setIsgrant(isgrant);
        s.setGrantdate(grantdate);
        s.setLicense(license);
        System.out.println("    授权码预览===>"+license);
        System.out.println("-----------------------------------------------------------" +
                "----------------------------------------------------------------------" +
                "----------------------------------------------------------------------");
        boolean ret = adminService.ratify(s);
        if (ret) {
            return DataJSONResult.ok("aid="+aid+"批准授权sid="+sid+"成功");
        } else {
            return DataJSONResult.errorMsg("管理员授权失败。");
        }
    }

    /**
     * 管理员撤销授权
     * @param sid     state->sid
     * @param applyid state->applyid
     * @return
     */
    @GetMapping("unratify/{loginUserId}")
    public DataJSONResult unratify(@PathVariable("loginUserId") String loginUserId,
                                   @RequestParam(value = "sid",required = false) String sid, HttpSession session) {
        String aid = loginUserId;
        String isgrant = "3";
//        String license = " ";
        State s = new State();
        s.setSid(sid);
        s.setIsgrant(isgrant);
//        s.setLicense(license);
        System.out.println(s.toString());
        boolean ret = adminService.unratify(s);
        if (ret) {
            return DataJSONResult.ok("aid="+aid+"撤销授权sid="+sid+"成功");
        } else {
            return DataJSONResult.errorMsg("管理员取消授权失败。");
        }
    }
    /**
     * 管理员首页-追踪所有记录
     *
     * @return list-state[state的字段，userDetail，applyDetail]
     */
    @GetMapping("getAllState")
    public DataJSONResult getAllState() {
        List<State> list = adminService.getAllState();
        return DataJSONResult.build(200, "管理员查询所有授权成功", list);
    }

    /**
     * 管理员添加用户
     * @param user
     * @return
     */
    @GetMapping("addUser")
        public DataJSONResult reApply(User user) {

            boolean ret = adminService.addUser(user);
            if (ret) {
                return DataJSONResult.ok("管理员添加用户成功");
            } else {
                return DataJSONResult.errorMsg("添加失败");
            }
        }

    /**
     * 管理员查询用户信息
     * @return
     */
    @GetMapping("getAllUser")
    public DataJSONResult getAllUser() {
        List<State> list = adminService.getAllUser();
        return DataJSONResult.build(200, "管理员查询用户信息成功", list);
    }

    /**
     * g管理员重置用户密码
     * @param user
     * @return
     */
    @GetMapping("ResetPassword")
    public DataJSONResult ResetPassword(User user){
        adminService.ResetPassword(user.getId());
        return DataJSONResult.ok("管理员重置用户密码成功");
    }

    /**
     * 管理员冻结账户
     * @param user
     * @return
     */
    @GetMapping("FrozenUser")
    public DataJSONResult FrozenUser(User user){
        adminService.FrozenUser(user.getId());
        return DataJSONResult.ok("管理员冻结账户成功");
    }

    /**
     * 管理员恢复账户
     * @param user
     * @return
     */
    @GetMapping("ReUser")
    public DataJSONResult ReUser(User user){
        adminService.ReUser(user.getId());
        return DataJSONResult.ok("管理员恢复账户成功");
    }

    /**
     * 管理员删除账户
     * @param user
     * @return
     */
    @GetMapping("DeleteUser")
    public DataJSONResult DeleteUser(User user){
        adminService.DeleteUser(user.getId());
        return DataJSONResult.ok("管理员删除账户成功");
    }

}
