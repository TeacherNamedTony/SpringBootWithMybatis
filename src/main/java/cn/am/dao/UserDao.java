package cn.am.dao;

import cn.am.bean.Apply;
import cn.am.bean.State;
import cn.am.bean.User;

import java.util.List;

public interface UserDao {
    /**
     * 登录
     *
     * @param user
     * @return
     */
    public User login(User user);

    /**
     * 查询所有状态
     *
     * @param uid
     * @return
     */
    public List<State> getState(String uid);

    /**
     * 查询未被授权记录
     *
     * @param uid
     * @return list
     */
    public List<State> getUntreatedState(String uid);

    /**
     * 查询已经被授权记录
     *
     * @param uid
     * @return list
     */
    public List<State> getAuditedState(String uid);

    /**
     * 查询过期授权
     *
     * @param uid
     * @return list
     */
    public List<State> getEndState(String uid);

    /**
     * 查询异常授权
     *
     * @param uid
     * @return
     */
    public List<State> getRevoke(String uid);

    /**
     * 查询不足30天授权
     *
     * @param uid
     * @return
     */
    public List<State> getNearOverdue(String uid);

    /**
     * 添加新的申请
     *
     * @param apply
     * @return
     */
    public int addNewApply(Apply apply);

    /**
     * 添加新的申请时创建状态
     *
     * @param state
     * @return
     */
    public int addNewState(State state);

    /**
     * 动态更新state
     *
     * @param state
     * @return
     */
    public int updateState(State state);

    /**
     * 动态更新apply
     *
     * @param apply
     * @return
     */
    public int updateApply(Apply apply);

    /**
     * 用户修改密码
     * @param u
     * @return
     */
    public int changePassword(User u);

    /**
     * 按ID查询apply
     *
     * @param aid
     * @return
     */
    public Apply selectApplyByID(String aid);

    /**
     * 按ID查询state
     *
     * @param sid
     * @return
     */
    public State selectStateByID(String sid);


}
