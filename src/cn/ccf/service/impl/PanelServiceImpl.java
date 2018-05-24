package cn.ccf.service.impl;

import cn.ccf.mapper.TreeMapper;
import cn.ccf.pojo.*;
import cn.ccf.service.PanelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @Value("${FILE}")
    private String iconFile;



    @Override
    public List<VideoTreeNode> getVideoTree() {
        List<VideoTreeNode> videoTreeNodes = new ArrayList<>();
        List<TreeNode> parentTreeNode = treeMapper.getParentTreeNode();
//测试lambda表达式
//        parentTreeNode.forEach(treeNode -> System.out.println(treeNode.getName()));


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
    public List<ResourceTree> getComprehensiveAnalysis() {
        List<ResourceTree> resourceTrees = new ArrayList<>();
        List<Preplan> preplans = treeMapper.getPreplan();
        //增加父节点
        if (preplans != null) {
            ResourceTree resourceTree = new ResourceTree();
            resourceTree.setId("preplan");
            resourceTree.setpId("-1");
            resourceTree.setName("预案");
            resourceTree.setType("parent");
            resourceTree.setIcon(iconFile);
            resourceTrees.add(resourceTree);
        }
        //增加子节点
        if (preplans != null) {
            for (Preplan preplan : preplans) {
                ResourceTree resourceTree = new ResourceTree();
                resourceTree.setId(preplan.getId().toString());
                resourceTree.setpId("preplan");
                resourceTree.setName(preplan.getName());
                resourceTree.setType("preplan");
                resourceTree.setIcon(iconFile);
                resourceTrees.add(resourceTree);
            }
        }

        List<Case> cases = treeMapper.getCase();

        //增加父节点
        if (cases != null) {
            ResourceTree resourceTree = new ResourceTree();
            resourceTree.setId("case");
            resourceTree.setpId("-1");
            resourceTree.setName("案例");
            resourceTree.setType("parent");
            resourceTree.setIcon(iconFile);
            resourceTrees.add(resourceTree);
        }
        //增加子节点
        if (cases != null) {
            for (Case caseTemp : cases) {
                ResourceTree resourceTree = new ResourceTree();
                resourceTree.setId(caseTemp.getId().toString());
                resourceTree.setpId("case");
                resourceTree.setName(caseTemp.getName());
                resourceTree.setType("case");
                resourceTree.setIcon(iconFile);
                resourceTrees.add(resourceTree);
            }
        }

        List<Professor> professors = treeMapper.getProfessor();

        //增加父节点
        if (professors != null) {
            ResourceTree resourceTree = new ResourceTree();
            resourceTree.setId("professor");
            resourceTree.setpId("-1");
            resourceTree.setName("专家");
            resourceTree.setType("parent");
            resourceTree.setIcon(iconFile);
            resourceTrees.add(resourceTree);
        }
        //增加子节点
        if (professors != null) {
            for (Professor professor : professors) {
                ResourceTree resourceTree = new ResourceTree();
                resourceTree.setId(professor.getId().toString());
                resourceTree.setpId("professor");
                resourceTree.setName(professor.getName());
                resourceTree.setType("professor");
                resourceTree.setIcon(iconFile);
                resourceTrees.add(resourceTree);
            }
        }




        return resourceTrees;
    }

    @Override
    public List<ResourceTree> getResourceTree() {

        /*StopWatch stopWatch = new StopWatch("资源树获取时间测试");
        stopWatch.start("资源树开始");
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());*/

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

        //增加父节点 地点图层
        ResourceTree parentPlace = new ResourceTree();
        parentPlace.setId("place");
        parentPlace.setpId("-1");
        parentPlace.setName("地点");
        parentPlace.setType("parent");
        parentPlace.setIcon(iconLayer);
        resourceTrees.add(parentPlace);

        HashMap<String, String> map = new HashMap<>();
        map.put("ccf_bhf:point", "厂");
        map.put("ccf_bhf:country", "县");

/*        for (String key : map.keySet()) {
            ResourceTree childPlace = new ResourceTree();
            childPlace.setId(key);
            childPlace.setpId("place");
            childPlace.setName(map.get(key));
            childPlace.setType("place");
            childPlace.setIcon(iconLayer);
            resourceTrees.add(childPlace);
        }*/
//效率更高
        for (Map.Entry<String, String> entry : map.entrySet()) {
            ResourceTree childPlace = new ResourceTree();
            childPlace.setId(entry.getKey());
            childPlace.setpId("place");
            childPlace.setName(entry.getValue());
            childPlace.setType("place");
            childPlace.setIcon(iconLayer);
            resourceTrees.add(childPlace);
        }

/*        //lambda方式
        map.forEach((k, v) -> {
            ResourceTree childPlace = new ResourceTree();
            childPlace.setId(k);
            childPlace.setpId("place");
            childPlace.setName(v);
            childPlace.setType("place");
            childPlace.setIcon(iconLayer);
            resourceTrees.add(childPlace);
        });*/

//        map.forEach((k, v) -> System.out.println(k + ":" + v));



     /*   //lambda
        map.forEach((k, v) -> System.out.println(k + ":" + v));*/
/*
        Set<Map.Entry<String, String>> entries = map.entrySet();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "::" + entry.getValue());
        }*/


     /*   Logger logger = Logger.getLogger(PanelServiceImpl.class);
        logger.info("日志：资源树已获取成功");*/

        return resourceTrees;
    }
}
