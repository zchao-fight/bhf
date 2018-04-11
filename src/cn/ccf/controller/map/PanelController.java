package cn.ccf.controller.map;

import cn.ccf.pojo.*;
import cn.ccf.service.PanelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("map")

public class PanelController {

    @Autowired
    private PanelService panelService;

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
}
