function getVideoTree() {
    $.post(BASE_URL + "/map/getVideoTree.action", {}, function(data) {
        //视频监控树
        var setting = {
            data: {
                simpleData: {
                    enable: true,
                    idKey: "id",
                    pIdKey: "pId",
                    rootPId: -1
                }
            },
            view: {
                fontCss : {color:"white"}
            },
            callback: {
                onClick: zTreeOnClick
            }
        };

        var zNodes =[
            { id:1, pId:0, name:"德宏中心", open:false, iconOpen:"${ctx}/images/map/left_menu/department.png", iconClose:"${ctx}/images/map/left_menu/department.png"},
            { id:11, pId:1, name:"摄像头1", icon:"${ctx}/images/map/left_menu/bolt.png"},
            { id:12, pId:1, name:"摄像头2", icon:"${ctx}/images/map/left_menu/bolt.png"},
            { id:13, pId:1, name:"摄像头3", icon:"${ctx}/images/map/left_menu/ball.png"},
            { id:2, pId:0, name:"武装部", open:false, icon:"${ctx}/images/map/left_menu/department.png"},
            { id:21, pId:2, name:"摄像头1", icon:"${ctx}/images/map/left_menu/ball.png"},
            { id:22, pId:2, name:"摄像头2", icon:"${ctx}/images/map/left_menu/ball.png"},
            { id:23, pId:2, name:"摄像头3", icon:"${ctx}/images/map/left_menu/bolt.png"},
            { id:3, pId:0, name:"边防办", open:false ,icon:"${ctx}/images/map/left_menu/department.png"},
            { id:31, pId:3, name:"摄像头1", icon:"${ctx}/images/map/left_menu/bolt.png"},
            { id:32, pId:3, name:"摄像头2", icon:"${ctx}/images/map/left_menu/ball.png"},
            { id:33, pId:3, name:"摄像头3", icon:"${ctx}/images/map/left_menu/ball.png"},
            { id:4, pId:0, name:"公安部", open:false ,icon:"${ctx}/images/map/left_menu/department.png"},
            { id:41, pId:4, name:"摄像头1", icon:"${ctx}/images/map/left_menu/bolt.png"},
            { id:42, pId:4, name:"摄像头2", icon:"${ctx}/images/map/left_menu/ball.png"},
            { id:43, pId:4, name:"摄像头3", icon:"${ctx}/images/map/left_menu/ball.png"},
            { id:5, pId:0, name:"外交部", open:false ,icon:"${ctx}/images/map/left_menu/department.png"},
            { id:51, pId:5, name:"摄像头1", icon:"${ctx}/images/map/left_menu/bolt.png"},
            { id:52, pId:5, name:"摄像头2", icon:"${ctx}/images/map/left_menu/ball.png"},
            { id:53, pId:5, name:"摄像头3", icon:"${ctx}/images/map/left_menu/ball.png"},
            { id:6, pId:0, name:"国土局", open:false ,icon:"${ctx}/images/map/left_menu/department.png"},
            { id:61, pId:6, name:"摄像头1", icon:"${ctx}/images/map/left_menu/bolt.png"},
            { id:62, pId:6, name:"摄像头2", icon:"${ctx}/images/map/left_menu/ball.png"},
            { id:63, pId:6, name:"摄像头3", icon:"${ctx}/images/map/left_menu/ball.png"}

        ];
        console.log(data);

        $(document).ready(function(){
            $.fn.zTree.init($("#videoTree"), setting, data);
        });
    });
}

function zTreeOnClick(event, treeId, treeNode) {
    if (!treeNode.isParent) {
        //            select id + 1000
        if (treeNode.id > 1000) {
            alert('视频播放：'+(treeNode.id-1000) + ", " + treeNode.name);
        }
    }

}

function getResourceTree() {

    $.post(BASE_URL + "/map/getResourceTree.action", {}, function(data) {
        //综合资源树
        var setting = {
            check: {
                enable: true
            },
            view: {
                fontCss : {color:"white"}
            },
            data: {
                simpleData: {
                    enable: true
                }
            },
            callback: {
                onCheck: zTreeOnCheck
            }
        };

        var zNodes =[
            { id:1, pId:0, name:"单位资源", open:true,icon:"${ctx}/images/map/left_menu/layer.png"},
            { id:11, pId:1, name:"德宏中心", open:true,icon:"${ctx}/images/map/left_menu/layer.png"},
            { id:111, pId:11, name:"瑞丽",icon:"${ctx}/images/map/left_menu/layer.png"},
            { id:112, pId:11, name:"武装部",icon:"${ctx}/images/map/left_menu/layer.png"},
            { id:12, pId:1, name:"镜头资源", open:true,icon:"${ctx}/images/map/left_menu/layer.png"},
            { id:121, pId:12, name:"军工事业部枪机",icon:"${ctx}/images/map/left_menu/layer.png"},
            { id:122, pId:12, name:"项目集成部球机",icon:"${ctx}/images/map/left_menu/layer.png"},
            { id:2, pId:0, name:"交通设施", checked:true, open:true,icon:"${ctx}/images/map/left_menu/layer.png"},
            { id:21, pId:2, name:"直升机坪",icon:"${ctx}/images/map/left_menu/layer.png"},
            { id:22, pId:2, name:"巡逻路", open:true,icon:"${ctx}/images/map/left_menu/layer.png"},
            { id:221, pId:22, name:"手持机", checked:true,icon:"${ctx}/images/map/left_menu/layer.png"},
            { id:222, pId:22, name:"车载电话",icon:"${ctx}/images/map/left_menu/layer.png"},
            { id:23, pId:2, name:"气象雷达",icon:"${ctx}/images/map/left_menu/layer.png"}
        ];
        $(document).ready(function(){
            $.fn.zTree.init($("#resourceTree"), setting, data);
        });
    })
}

function zTreeOnCheck(event, treeId, treeNode) {
    layer.getSource().clear(true);
    var treeObj = $.fn.zTree.getZTreeObj("resourceTree");
    var nodes = treeObj.getCheckedNodes(true);
    for (var i = 0; i < nodes.length; i++) {
        if (!nodes[i].isParent) {
            if (nodes[i].type === 'department') {
                locateDepartment(parseInt(nodes[i].id));
            } else if (nodes[i].type === 'camera') {
                locateCamera(parseInt(nodes[i].id));
            } else if (nodes[i].type === 'equipment') {

            }
        }
    }
}

//还未添加开关js
function toogle(th) {
    var ele = $(th).children(".move");
    if (ele.attr("data-state") === "on") {
        ele.animate({
            left: "0"
        }, 300, function() {
            ele.attr("data-state", "off");
            $('.float-news').animate({
                left: '-450px'
            }, 300, function(){
                $('.float-open').delay(50).animate({
                    left: '-2px'
                }, 300);
            });

            $('.right-panel').delay(50).animate({
                right: '-250px'
            }, 300);
        });
        $(th).removeClass("on").addClass("off");
    } else if (ele.attr("data-state") === "off") {
        ele.animate({
            left: '48px'
        }, 300, function() {
            $(this).attr("data-state", "on");
            $('.float-open').animate({
                left: '-70px'
            }, 100, function(){
                $('.float-news').delay(50).animate({
                    left: '0px'
                }, 300);
            });
            $('.right-panel').delay(50).animate({
                right: '0px'
            }, 300);
        });
        $(th).removeClass("off").addClass("on");
    }
}