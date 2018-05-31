package cn.ccf.pojo;

import com.alibaba.fastjson.JSON;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Message {
    private String welcome;
    private List<String> users;
    private String content;
    private Integer isPlotting;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setContent(String name, String content, Integer isPlotting) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if (isPlotting == 1) {
            this.content = content;
            this.isPlotting = 1;
        } else if (isPlotting == 0){
            this.isPlotting = 0;
            this.content = "<div style='color:#808080;margin-left:5px;'>" + name + " " + simpleDateFormat.format(new Date()) + "</div>"
                    + "<div style='color:#000000;font-size:16px;margin-left:5px;margin-bottom:10px;background-color:#CED6CD;border-radius:5px;padding:10px 5px 0px 5px;display:inline-block;'>" + content + "</div>";
        }

    }

    public String getWelcome() {
        return welcome;
    }

    public Integer isPlotting() {
        return isPlotting;
    }

    public void setPlotting(Integer plotting) {
        isPlotting = plotting;
    }

    public void setWelcome(String welcome) {
        this.welcome = welcome;
    }

    public List<String> getUsers() {
        return users;
    }

    public void setUsers(List<String> users) {
        this.users = users;
    }

    public String toJson() {
        return JSON.toJSONString(this);
    }
}
