package cn.ccf.pojo;

public class ContentVo {
    private String to;
    private String msg;
    private Integer type;
    private Integer isPlotting;
    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public Integer getIsPlotting() {
        return isPlotting;
    }

    public void setIsPlotting(Integer isPlotting) {
        this.isPlotting = isPlotting;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
