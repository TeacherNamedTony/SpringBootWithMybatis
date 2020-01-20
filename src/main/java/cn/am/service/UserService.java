package cn.am.service;

import cn.am.bean.Apply;
import cn.am.bean.State;
import cn.am.bean.User;
import cn.am.dao.UserDao;
import cn.am.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserDao userDao;

    /**
     * 登录验证
     */
    public User login(User u) {
        return userDao.login(u);
    }

    /**
     * 查询该用户所有授权
     *
     * @param uid
     * @return
     */
    public List<State> getState(String uid) {
        return userDao.getState(uid);
    }

    /**
     * 查询该用户未被授权
     *
     * @param uid
     * @return
     */
    public List<State> getUntreatedState(String uid) {
        return userDao.getUntreatedState(uid);
    }

    /**
     * 查询该用户已经被授权
     *
     * @param uid
     * @return
     */
    public List<State> getAuditedState(String uid) {
        return userDao.getAuditedState(uid);
    }

    /**
     * 查询该用户过期授权
     *
     * @param uid
     * @return
     */
    public List<State> getEndState(String uid) {
        return userDao.getEndState(uid);
    }

    /**
     * 查询该用户异常授权
     *
     * @param uid
     * @return
     */
    public List<State> getRevoke(String uid) {
        return userDao.getRevoke(uid);
    }

    /**
     * 查询改用户授权不足15天
     *
     * @param uid
     * @return
     */
    public List<State> getNearOverdue(String uid) {
        return userDao.getNearOverdue(uid);
    }

    /**
     * 重新申请授权三个月
     * 修改授权状态为未授权
     * 修改apply起始时间
     *
     * @param state
     * @return
     */
    public boolean reApply(State state) {
        //修改状态改为0未授权
        State s = userDao.selectStateByID(state.getSid());
        s.setSid(state.getSid());
        s.setIsgrant("0");
        int res1 = userDao.updateState(s);
        //修改apply起始时间
        Apply apply = new Apply();
        String startTime = DateUtil.dateToSimpleStr(new Date());
        Calendar c = Calendar.getInstance();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = sf.parse(startTime);
        } catch (Exception e) {
            e.printStackTrace();
        }
        c.setTime(date);
        c.add(Calendar.MONTH, 3);   //增加三个月
        String endTime = sf.format(c.getTime());
        apply.setApplyid(s.getApplyid());
        apply.setGrantbegindate(startTime);
        apply.setGrantenddate(endTime);
        int res2 = userDao.updateApply(apply);
        if (res1 > 0 && res2 > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 添加新的申请
     * 1.apply添加记录
     * 2.状态表添加未授权状态
     *
     * @param apply
     * @return
     */
    public boolean addNewApply(String loginUserId,Apply apply, HttpSession session) {
        //创建申请表apply
        int ret1 = userDao.addNewApply(apply);
        //创建申请表同步状态表state
        State state = new State();
        state.setApplyid(apply.getApplyid());
        //获取前端传过来的用户id
        state.setUid(loginUserId);
        state.setIsgrant("0"); //未授权
        state.setIsdel("0"); //0是正常

        int ret2 = userDao.addNewState(state);
        if (ret1 > 0 && ret2 > 0) {
            return true;
        } else {
            return false;
        }

    }

    /**
     * 用户修改密码
     * @param u
     * @return
     */
    public boolean changePassword(User u) {
        int ret = userDao.changePassword(u);
        if (ret > 0) {
            return true;
        } else {
            return false;
        }
    }
}
