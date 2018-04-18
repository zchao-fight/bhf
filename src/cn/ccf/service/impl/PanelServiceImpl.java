package cn.ccf.service.impl;

import cn.ccf.mapper.TreeMapper;
import cn.ccf.pojo.*;
import cn.ccf.service.PanelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PanelServiceImpl implements PanelService {

    @Autowired
    private TreeMapper treeMapper;

    @Value("${DEPARTMENT}")
    private String iconDepartment;
    @Value("${BALL}")
    private String iconBall;
    @Value("${BOLT}")
    private String iconBolt;
    @Value("${LAYER}")
    private String iconLayer;

    @Override
    public List<VideoTreeNode> getVideoTree() {
        List<VideoTreeNode> videoTreeNodes = new ArrayList<>();
        List<TreeNode> parentTreeNode = treeMapper.getParentTreeNode();

        parentTreeNode.forEach(treeNode -> System.out.println(treeNode.getName()));



        for (int i = 0; i < parentTreeNode.size(); i++) {
            VideoTreeNode videoTreeNode = new VideoTreeNode();
            videoTreeNode.setId(parentTreeNode.get(i).getId());
            videoTreeNode.setpId(parentTreeNode.get(i).getpId());
            videoTreeNode.setName(parentTreeNode.get(i).getName());
            videoTreeNode.setIcon(iconDepartment);
            videoTreeNodes.add(videoTreeNode);
        }

/*        Iterator<TreeNode> it = parentTreeNode.iterator();
        while (it.hasNext()) {
            TreeNode treeNode = it.next();
            System.out.println(treeNode.getName());
        }*/


        List<YZTCamera> childTreeNode = treeMapper.getChildTreeNode();
        for (YZTCamera yztCamera : childTreeNode) {
            VideoTreeNode videoTreeNode = new VideoTreeNode();
            videoTreeNode.setId(yztCamera.getId() + 1000);
            videoTreeNode.setpId(Integer.parseInt(yztCamera.getUserunit()));
            videoTreeNode.setName(yztCamera.getName());
            if (yztCamera.getObjtype() == 983569) {
                videoTreeNode.setIcon(iconBolt);
            } else {
                videoTreeNode.setIcon(iconBall);
            }

            videoTreeNodes.add(videoTreeNode);
        }

        return videoTreeNodes;
    }

    @Override
    public List<ResourceTree> getResourceTree() {
        List<ResourceTree> resourceTrees = new ArrayList<>();

        List<YZTCamera> camera = treeMapper.getCamera();

        //增加父节点
        if (camera != null) {
            ResourceTree resourceTree = new ResourceTree();
            resourceTree.setId("camera");
            resourceTree.setpId("-1");
            resourceTree.setName("镜头资源");
            resourceTree.setType("parent");
            resourceTree.setIcon(iconLayer);
            resourceTrees.add(resourceTree);
        }
        //增加子节点
        if (camera != null) {
            for (YZTCamera yztCamera : camera) {
                ResourceTree resourceTree = new ResourceTree();
                resourceTree.setId(yztCamera.getId().toString());
                resourceTree.setpId("camera");
                resourceTree.setName(yztCamera.getName());
                resourceTree.setLat(yztCamera.getLatitude());
                resourceTree.setLog(yztCamera.getLongitude());
                resourceTree.setType("camera");
                resourceTree.setIcon(iconLayer);
                resourceTrees.add(resourceTree);
            }
        }

        List<Department> departments = treeMapper.getDepartment();

        //增加父节点
        if (departments != null) {
            ResourceTree resourceTree = new ResourceTree();
            resourceTree.setId("department");
            resourceTree.setpId("-1");
            resourceTree.setName("单位资源");
            resourceTree.setType("parent");
            resourceTree.setIcon(iconLayer);
            resourceTrees.add(resourceTree);
        }

        if (departments != null) {
            for (Department department : departments) {
                ResourceTree resourceTree = new ResourceTree();
                resourceTree.setId(department.getId().toString());
                resourceTree.setpId("department");
                resourceTree.setName(department.getName());
                resourceTree.setLat(department.getLat());
                resourceTree.setLog(department.getLng());
                resourceTree.setType("department");
                resourceTree.setIcon(iconLayer);
                resourceTrees.add(resourceTree);
            }
        }

        List<Equipment> equipments = treeMapper.getEquipment();

        //增加父节点
        if (equipments != null) {
            ResourceTree resourceTree = new ResourceTree();
            resourceTree.setId("equipment");
            resourceTree.setpId("-1");
            resourceTree.setName("装备");
            resourceTree.setType("parent");
            resourceTree.setIcon(iconLayer);
            resourceTrees.add(resourceTree);
        }

        if (equipments != null) {
            for (Equipment equipment : equipments) {
                ResourceTree resourceTree = new ResourceTree();
                resourceTree.setId(equipment.getId().toString());
                resourceTree.setpId("equipment");
                resourceTree.setName(equipment.getName());
                resourceTree.setLat(equipment.getLatitude());
                resourceTree.setLog(equipment.getLongitude());
                resourceTree.setType("equipment");
                resourceTree.setIcon(iconLayer);
                resourceTrees.add(resourceTree);
            }
        }

        return resourceTrees;
    }
}
