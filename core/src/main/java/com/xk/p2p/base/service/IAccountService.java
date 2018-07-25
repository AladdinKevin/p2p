package com.xk.p2p.base.service;

import com.xk.p2p.base.domain.Account;

/** 账户服务
 * Created by admin on 2018/6/13.
 */
public interface IAccountService {

    /**
     * 修改账户信息,设计乐观锁
     * @param account
     */
    void update(Account account);

    void save(Account account);

    Object get(Long id);
}
