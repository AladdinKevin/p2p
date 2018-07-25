package com.xk.p2p.base.domain;

import com.xk.p2p.base.util.BidConst;

import java.math.BigDecimal;

/**
 * Created by admin on 2018/6/5.
 */
public class Account extends BaseDomain{
    private int version;
    private String     tradePassword;//交易密码
    private BigDecimal usableAmount = BidConst.ZERO;//账户可用余额
    private BigDecimal freezedAmount = BidConst.ZERO;//账户冻结金额
    private BigDecimal unReceiveInterest = BidConst.ZERO;//账户代收利息
    private BigDecimal unReceivePrincipal = BidConst.ZERO;//账户代收本金
    private BigDecimal unReturnAmount = BidConst.ZERO;//账户代还金额
    private BigDecimal remainBorrowLimit = BidConst.INIT_BORROW_LIMIT;//账户剩余授信额度
    private BigDecimal borrowLimitAmount = BidConst.INIT_BORROW_LIMIT;//账户授信额度

    public BigDecimal getTotalAmount(){
        return this.usableAmount.add(this.freezedAmount).add(this.unReceiveInterest)
                .add(this.unReceivePrincipal);
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getTradePassword() {
        return tradePassword;
    }

    public void setTradePassword(String tradePassword) {
        this.tradePassword = tradePassword;
    }

    public BigDecimal getUsableAmount() {
        return usableAmount;
    }

    public void setUsableAmount(BigDecimal usableAmount) {
        this.usableAmount = usableAmount;
    }

    public BigDecimal getFreezedAmount() {
        return freezedAmount;
    }

    public void setFreezedAmount(BigDecimal freezedAmount) {
        this.freezedAmount = freezedAmount;
    }

    public BigDecimal getUnReceiveInterest() {
        return unReceiveInterest;
    }

    public void setUnReceiveInterest(BigDecimal unReceiveInterest) {
        this.unReceiveInterest = unReceiveInterest;
    }

    public BigDecimal getUnReceivePrincipal() {
        return unReceivePrincipal;
    }

    public void setUnReceivePrincipal(BigDecimal unReceivePrincipal) {
        this.unReceivePrincipal = unReceivePrincipal;
    }

    public BigDecimal getUnReturnAmount() {
        return unReturnAmount;
    }

    public void setUnReturnAmount(BigDecimal unReturnAmount) {
        this.unReturnAmount = unReturnAmount;
    }

    public BigDecimal getRemainBorrowLimit() {
        return remainBorrowLimit;
    }

    public void setRemainBorrowLimit(BigDecimal remainBorrowLimit) {
        this.remainBorrowLimit = remainBorrowLimit;
    }

    public BigDecimal getorrowLimitAmount() {
        return borrowLimitAmount;
    }

    public void setBorrowLimitAmount(BigDecimal borrowLimitAmount) {
        this.borrowLimitAmount = borrowLimitAmount;
    }
}
