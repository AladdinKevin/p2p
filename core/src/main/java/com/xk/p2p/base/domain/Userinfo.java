package com.xk.p2p.base.domain;

import com.xk.p2p.base.util.BitStatesUtils;

/**
 * Created by admin on 2018/6/5.
 */
public class Userinfo extends BaseDomain {
    private int version;//版本号（用作乐观锁）
    private Long bitState = 0L;//用户状态值
    private String realName;//真实姓名
    private String idNumber;//身份证
    private String phoneNumber;//手机号
    private String email;      //邮箱
    private int score;//用户当前的风控材料分数汇总
    private SystemDictionaryItem incomeGrade;//收入
    private SystemDictionaryItem marriage;//婚姻情况
    private SystemDictionaryItem kidCount;//子女情况
    private SystemDictionaryItem educationBackground;//学历
    private SystemDictionaryItem houseCondition;//住房条件


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public Long getBitState() {
        return bitState;
    }

    public void setBitState(Long bitState) {
        this.bitState = bitState;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String inNumber) {
        this.idNumber = inNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public SystemDictionaryItem getIncomeGrade() {
        return incomeGrade;
    }

    public void setIncomeGrade(SystemDictionaryItem incomeGrade) {
        this.incomeGrade = incomeGrade;
    }

    public SystemDictionaryItem getMarriage() {
        return marriage;
    }

    public void setMarriage(SystemDictionaryItem marriage) {
        marriage = marriage;
    }

    public SystemDictionaryItem getKidCount() {
        return kidCount;
    }

    public void setKidCount(SystemDictionaryItem kidCount) {
        this.kidCount = kidCount;
    }

    public SystemDictionaryItem getEducationBackground() {
        return educationBackground;
    }

    public void setEducationBackground(SystemDictionaryItem educationBackground) {
        this.educationBackground = educationBackground;
    }

    public SystemDictionaryItem getHouseCondition() {
        return houseCondition;
    }

    public void setHouseCondition(SystemDictionaryItem houseCondition) {
        this.houseCondition = houseCondition;
    }

    /**
     * 判断用户是否已经绑定手机号
     * @return
     */
    public boolean getHasBindPhone(){
        return BitStatesUtils.hasState(this.bitState, BitStatesUtils.OP_BIND_PHONE);
    }
    /**
     * 判断用户是否已经绑定邮箱
     * @return
     */
    public boolean getHasBindEmail(){
        return BitStatesUtils.hasState(this.bitState, BitStatesUtils.OP_BIND_EMAIL);
    }
    /**
     * 判断用户是否已经实名认证
     */
    public boolean getIsRealAuth(){
        return BitStatesUtils.hasState(this.bitState, BitStatesUtils.OP_REAL_AUTH);
    }
    /**
     * 基本材料
     * @return
     */
    public boolean getIsBasicInfo(){
        return BitStatesUtils.hasState(this.bitState, BitStatesUtils.OP_BASIC_INFO);
    }
    /**
     * 视频认证
     */
    public boolean getIsVedioAuth(){
        return BitStatesUtils.hasState(this.bitState, BitStatesUtils.OP_VEDIO_AUTH);
    }
}
