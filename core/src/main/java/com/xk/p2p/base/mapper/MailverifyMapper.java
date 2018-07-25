package com.xk.p2p.base.mapper;

import com.xk.p2p.base.domain.MailVerify;

public interface MailverifyMapper {

    int insert(MailVerify record);

    MailVerify selectByUUID(String uuid);

}