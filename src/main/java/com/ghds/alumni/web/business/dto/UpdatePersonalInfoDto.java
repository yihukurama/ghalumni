package com.ghds.alumni.web.business.dto;
/**
 * 说明： 小程序更新个人信息包装类
 * @author dengshuai
 * @date Created in 10:18 2018/5/30
 * @modified by autor in 10:18 2018/5/30
 */
public class UpdatePersonalInfoDto {
    /**
     * 用户id
     */
    private String userId;
    /**
     * 员工id
     */
    private String empId;
    /**
     * 部门id
     */
    private String departMentId;
    /**
     * 机构id
     */
    private String orgId;
    /**
     * 电话号码
     */
    private String phoneNum;
    /**
     * 真实姓名
     */
    private String realName;
    /**
     * 年限
     */
    private Integer workAge;
    /**
     * 编码
     */
    private String code;
    /**
     * 备注
     */
    private String note;


    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getDepartMentId() {
        return departMentId;
    }

    public void setDepartMentId(String departMentId) {
        this.departMentId = departMentId;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Integer getWorkAge() {
        return workAge;
    }

    public void setWorkAge(Integer workAge) {
        this.workAge = workAge;
    }
}
