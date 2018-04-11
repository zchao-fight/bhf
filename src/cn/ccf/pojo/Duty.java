package cn.ccf.pojo;

public class Duty {
    private Integer id;

    private String leadername;

    private String advisername;

    private String opertorname;

    private String predate;

    private String type;

    private String starttime;

    private String endtime;

    private String contactinfo;

    private String taskcompletion;

    private String eventinfo;

    private String departmentid;

    private String shiftevents;

    private Integer issign;

    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLeadername() {
        return leadername;
    }

    public void setLeadername(String leadername) {
        this.leadername = leadername == null ? null : leadername.trim();
    }

    public String getAdvisername() {
        return advisername;
    }

    public void setAdvisername(String advisername) {
        this.advisername = advisername == null ? null : advisername.trim();
    }

    public String getOpertorname() {
        return opertorname;
    }

    public void setOpertorname(String opertorname) {
        this.opertorname = opertorname == null ? null : opertorname.trim();
    }

    public String getPredate() {
        return predate;
    }

    public void setPredate(String predate) {
        this.predate = predate == null ? null : predate.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime == null ? null : starttime.trim();
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime == null ? null : endtime.trim();
    }

    public String getContactinfo() {
        return contactinfo;
    }

    public void setContactinfo(String contactinfo) {
        this.contactinfo = contactinfo == null ? null : contactinfo.trim();
    }

    public String getTaskcompletion() {
        return taskcompletion;
    }

    public void setTaskcompletion(String taskcompletion) {
        this.taskcompletion = taskcompletion == null ? null : taskcompletion.trim();
    }

    public String getEventinfo() {
        return eventinfo;
    }

    public void setEventinfo(String eventinfo) {
        this.eventinfo = eventinfo == null ? null : eventinfo.trim();
    }

    public String getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(String departmentid) {
        this.departmentid = departmentid == null ? null : departmentid.trim();
    }

    public String getShiftevents() {
        return shiftevents;
    }

    public void setShiftevents(String shiftevents) {
        this.shiftevents = shiftevents == null ? null : shiftevents.trim();
    }

    public Integer getIssign() {
        return issign;
    }

    public void setIssign(Integer issign) {
        this.issign = issign;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}