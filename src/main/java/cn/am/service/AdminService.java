package cn.am.service;

import cn.am.bean.Apply;
import cn.am.bean.State;
import cn.am.bean.User;
import cn.am.dao.AdminDao;
import cn.am.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AdminService {
    @Autowired
    private AdminDao adminDao;

    /**
     * 查询所有授权记录
     *
     * @return
     */
    public List<State> getAllState() {
        return adminDao.getAllState();
    }

    /**
     * 根据sid查询授权相关信息
     *
     * @return
     */
    public Apply getApplyByApplyid(String applyId) { return adminDao.getApplyByApplyid(applyId); }

    /**
     * 查询所有未授权的state
     */
    public List<State> getAllStateNotPass() {
        return adminDao.getAllStateNotPass();
    }

    /**
     * 查询所有正常的state
     */
    public List<State> getAllPassState() { return adminDao.getAllPassState(); }

    /**
     * 查询所有授权过期state
     */
    public List<State> getAllEndState() {
        return adminDao.getAllEndState();
    }

    /**
     * 查询所有异常 未通过  过期state
     */
    public List<State> getAllRevoke() {
        return adminDao.getAllRevoke();
    }

    /**
     * 查询所有不足30天授权
     *
     * @return
     */
    public List<State> getAllNearOverdue() {
        return adminDao.getAllNearOverdue();
    }

    /**
     * 批准授权
     */
    public boolean ratify(State s) {
        int ret = adminDao.updateState(s);
        if (ret > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 取消授权
     */
    public boolean unratify(State s) {
        int ret = adminDao.updateState(s);
        if (ret > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 管理员添加用户
     * @param user
     * @return
     */
    public boolean addUser(User user){
        int ret1 = adminDao.addUser(user);
        if (ret1 > 0 ) {
            return true;
        } else {
            return false;
        }
    }

    /**
     *管理员查询用户信息
     * @return
     */
    public List<State> getAllUser() { return adminDao.getAllUser();
    }

    /**
     * 管理员恢复初始密码
     * @param id
     * @return
     */
    public boolean ResetPassword(String id) {
        int ret = adminDao.ResetPassword(id);
        if ( ret > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     *管理员冻结账户
     * @param id
     * @return
     */
    public boolean FrozenUser(String id) {
        int ret = adminDao.FrozenUser(id);
        if ( ret > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     *管理员恢复账户
     * @param id
     * @return
     */
    public boolean ReUser(String id) {
        int ret = adminDao.ReUser(id);
        if ( ret > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     *管理员删除账户
     * @param id
     * @return
     */
    public boolean DeleteUser(String id) {
        int ret = adminDao.DeleteUser(id);
        if ( ret > 0) {
            return true;
        } else {
            return false;
        }
    }
}