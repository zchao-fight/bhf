package cn.ccf.controller.map;

import cn.ccf.mapper.StatisticsMapper;
import cn.ccf.pojo.*;
import cn.ccf.service.PanelService;
import com.alibaba.fastjson.JSONObject;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("map")

public class PanelController {

    @Autowired
    private PanelService panelService;
    @Autowired
    private StatisticsMapper statisticsMapper;

    @RequestMapping("getVideoTree")
    @ResponseBody
    public List<VideoTreeNode> getVideoTree() {
        return panelService.getVideoTree();
    }

    @RequestMapping("getResourceTree")
    @ResponseBody
    public List<ResourceTree> getResourceTree() {
        return panelService.getResourceTree();
    }

    @RequestMapping(value = "getEventAddr", method = RequestMethod.POST)
    @ResponseBody
    public List<String> getEventAddr() {
        List<String> addrs = statisticsMapper.getDistinctAddr();
        return addrs;
    }

    @RequestMapping(value = "getEventStatistics", method = RequestMethod.POST)
    @ResponseBody
    public  List<Map<String, Object>> getEventType(HttpServletRequest request, @RequestParam(value = "addr[]") String[] addr, String eventBeginTime, String eventEndTime, String type)  {

        if (eventEndTime.equals("")) {
            Date date = new Date();
            SimpleDateFormat df = new SimpleDateFormat("y/M/d HH:mm:ss");
            eventEndTime = df.format(date);
        }


        switch (type) {
            case "eventType":
                return statisticsMapper.getEventType(addr, eventBeginTime, eventEndTime);
            case "eventNum":
                break;
            case "eventProp":
                break;
            case "eventRegion":
                break;
        }
        return new ArrayList<>();
    }

}
