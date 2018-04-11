package cn.ccf.pojo;

public class Command {
    private Integer id;
    private Integer userid;
    private String clientip;
    private Integer usetype;
    private String commandtype;
    private String commandparam;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getClientip() {
        return clientip;
    }

    public void setClientip(String clientip) {
        this.clientip = clientip;
    }

    public Integer getUsetype() {
        return usetype;
    }

    public void setUsetype(Integer usetype) {
        this.usetype = usetype;
    }

    public String getCommandtype() {
        return commandtype;
    }

    public void setCommandtype(String commandtype) {
        this.commandtype = commandtype;
    }

    public String getCommandparam() {
        return commandparam;
    }

    public void setCommandparam(String commandparam) {
        this.commandparam = commandparam;
    }
}
