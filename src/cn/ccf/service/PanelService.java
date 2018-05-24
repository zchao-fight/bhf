package cn.ccf.service;

import cn.ccf.pojo.ResourceTree;
import cn.ccf.pojo.VideoTreeNode;

import java.util.List;

public interface PanelService {
    List<VideoTreeNode> getVideoTree();
    List<ResourceTree> getResourceTree();
    List<ResourceTree> getComprehensiveAnalysis();

}
