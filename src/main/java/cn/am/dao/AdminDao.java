package cn.am.dao;

import cn.am.bean.Apply;
import cn.am.bean.State;
import cn.am.bean.User;

import java.util.List;

public interface AdminDao {
    /**
     * 查询所有授权记录
     *
     * @return
     */
    public List<State> getAllState();

    /**
     * 根据sid查询授权相关信息
     * @param sid
     * @return
     */
    public Apply getApplyByApplyid(String applyId);

    /**
     * 查询所有待审批state授权
     *
     * @return
     */
    public List<State> getAllStateNotPass();

    /**
     * 查询所有已审批state授权
     *
     * @return
     */
    public List<State> getAllPassState();

    /**
     * 查询所有过期state授权
     *
     * @return
     */
    public List<State> getAllEndState();

    /**
     * 查询所有异常 未通过 撤销 授权
     *
     * @return
     */
    public List<State> getAllRevoke();

    /**
     * 查询所有不足30天授权
     *
     * @return
     */
    public List<State> getAllNearOverdue();
    /**
     * 动态更新state
     *
     * @param state
     * @return
     */
    public int updateState(State state);
    /**
     * 管理员添加用户
     * @param user
     * @return
     */
    public int addUser(User user);

    /**
     * 查询所有用户信息
     * @return
     */
    public List<State> getAllUser();

    /**
     *管理员重置用户密码
     * @param id
     * @return
     */
    public int ResetPassword(String id);

    /**
     *管理员冻结账户
     * @param id
     * @return
     */
    public int FrozenUser(String id);

    /**
     *管理员恢复账户
     * @param id
     * @return
     */
    public int ReUser(String id);

    /**
     *管理员删除账户
     * @param id
     * @return
     */
    public int DeleteUser(String id);

}
