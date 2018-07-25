package com.xk.p2p.base.service.impl;

import com.xk.p2p.base.domain.Account;
import com.xk.p2p.base.mapper.AccountMapper;
import com.xk.p2p.base.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by admin on 2018/6/13.
 */
@Service
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public void update(Account account) {
        int count = this.accountMapper.updateByPrimaryKey(account);
        if (count <= 0){
            throw new RuntimeException("乐观锁失败,Account:" +account.getId());
        }
    }

    @Override
    public void save(Account account) {
        this.accountMapper.insert(account);
    }

    @Override
    public Object get(Long id) {
        return this.accountMapper.selectByPrimaryKey(id);
    }
}
