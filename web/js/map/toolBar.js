/*document.getElementById('export-png').addEventListener('click', function() {
    map.once('postcompose', function(event) {
        var canvas = event.context.canvas;
        if (navigator.msSaveBlob) {
            navigator.msSaveBlob(canvas.msToBlob(), 'map.png');
        } else {
            canvas.toBlob(function(blob) {
                saveAs(blob, 'map.png');
            });
        }
    });
    map.renderSync();
});*/






/**
 * @author zc
 * @function 移动到本级区域
 */
function moveToCenter() {
    var view = map.getView();
    // 设置地图中心为芒市的坐标，即可让地图移动到芒市
    view.setCenter([98.5847, 24.4365]);
    view.setZoom(14);
    map.render();
}

/**
 * @author zc
 * @function 移动到要素位置
 */
function moveToFeature(coor) {
    var view = map.getView();
    view.setCenter(coor);
    //增加动画效果
    view.animate({
        zoom: 14,
        duration: 250
    });
    map.render();
}

/*  function moveToLeft() {
      var view = map.getView();
      var mapCenter = view.getCenter();
      // 让地图中心的x值增加，即可使得地图向左移动，增加的值根据效果可自由设定
      mapCenter[0] += 50000;
      view.setCenter(mapCenter);
      map.render();
  }*/

/**
 * @author zc
 * @function 动画放大
 */
function zoomOut() {
    var view = map.getView();
    view.animate({
        zoom: view.getZoom() + 1,
        duration: 250
    })
}

/**
 * zc 动画缩小
 */
function zoomIn() {
    var view = map.getView();
    view.animate({
        zoom: view.getZoom() - 1,
        duration: 250
    })
}

/**
 * zc 标绘
 */
var source, plotVector, draw, snap;

/**
 * 创建图层显示样式
 */
function createPlotVector() {
    if (typeof(source) == 'undefined' || typeof(plotVector) == 'undefined' || plotVector == null) {
        source = new ol.source.Vector();
        plotVector = new ol.layer.Vector({
            source: source,
            style: new ol.style.Style({
                fill: new ol.style.Fill({
                    color: 'rgba(255, 255, 255, 0.2)'
                }),
                stroke: new ol.style.Stroke({
                    color: '#ffcc33',
                    width: 2
                }),
                image: new ol.style.Circle({
                    radius: 7,
                    fill: new ol.style.Fill({
                        color: '#ffcc33'
                    })
                })
            })
        });
        var modify = new ol.interaction.Modify({
            source: source
        });
        map.addInteraction(modify);
        map.addLayer(plotVector);
    }
}

/**
 * zc 画点
 */
function drawPoint() {
    createPlotVector();
    if (typeof(draw) != 'undefined' || typeof(snap) != 'undefined') {
        map.removeInteraction(draw);
        map.removeInteraction(snap);
    }
    draw = new ol.interaction.Draw({
        source: source,
        type: 'Point'
    });
    map.addInteraction(draw);
    snap = new ol.interaction.Snap({
        source: source
    });
    map.addInteraction(snap);
}

/**
 * zc 画线
 */
function drawLine() {
    createPlotVector();
    if (typeof(draw) != 'undefined' || typeof(snap) != 'undefined') {
        map.removeInteraction(draw);
        map.removeInteraction(snap);
    }
    draw = new ol.interaction.Draw({
        source: source,
        type: 'LineString'
    });
    map.addInteraction(draw);
    snap = new ol.interaction.Snap({
        source: source
    });
    map.addInteraction(snap);

    draw.on('drawend', drawEndCallBackAlarm, this);


}
var geo;
function drawEndCallBackAlarm(evt) {



    currentFeature = evt.feature; //当前绘制的要素
    console.log(evt);
    geo = currentFeature.getGeometry(); //获取要素的几何信息
    var coordinates = geo.getCoordinates(); //获取几何坐标
    console.log(coordinates);
    //将几何坐标拼接为字符串

        geoStr = coordinates.join(";");
        console.log(geoStr);

    map.removeInteraction(draw);
}

/**
 * zc 画多边形
 */
function drawPolygon() {
    createPlotVector();
    if (typeof(draw) !== 'undefined' || typeof(snap) !== 'undefined') {
        map.removeInteraction(draw);
        map.removeInteraction(snap);
    }
    draw = new ol.interaction.Draw({
        source: source,
        type: 'Polygon'
    });
    map.addInteraction(draw);
    snap = new ol.interaction.Snap({
        source: source
    });
    map.addInteraction(snap);
    draw.on('drawend', drawEndCallBackAlarm, this);
}

/**
 * zc 画圆
 */
function drawCircle() {
    createPlotVector();
    if (typeof(draw) != 'undefined' || typeof(snap) != 'undefined') {
        map.removeInteraction(draw);
        map.removeInteraction(snap);
    }
    draw = new ol.interaction.Draw({
        source: source,
        type: 'Circle'
    });
    map.addInteraction(draw);
    snap = new ol.interaction.Snap({
        source: source
    });
    map.addInteraction(snap);
}

/**
 * zc 漫游
 */
function wander() {
    map.removeInteraction(draw);
    map.removeInteraction(measureDraw);
    document.getElementById('map').style.cursor = 'pointer';
}

/**
 * zc 合并测距与测面
 * @type {ol.control.MeasureTool}
 */
var MeasureTool = new ol.control.MeasureTool({
    sphereradius: 6378137//sphereradius
});
map.addControl(MeasureTool);

/**
 * @author zc
 * @function 清除
 */
function clearPlotting() {
    layer.getSource().clear(true);
    drawOverlay.getSource().clear(true);
}

/**
 * @author zc
 * @function 确定标绘类型
 */
var objType = null;

function createResource(type, seq, geometry) {
    var resourceLayerBody = $('#resourceLayerBody');
    resourceLayerBody.html('');
    if (type === 'facility') {
        $('#resourceContent').css('width', '600px');
        var temp1 = '<div>设施名称：<input type="text"  name="name" style="width:150px;margin-right:50px;"> 建设地址（段）: <input name="address" type="text" style="width: 150px;"></div>';
        var temp2 = '<div>设施状态：<select name="status"  style="width: 154px;margin-right:50px;"><option value="1">良好</option><option value="0">正常</option><option value="-1">损坏</option></select> &#12288;投资（万元）: <input name="invest" type="text" style="width: 150px;"></div>';
        var tempStr = '';
        var temp3 = '<div>竣工时间：<input id="completionTime" name="finishtime" style="width: 152px;margin-right:50px;" type="text" class="Wdate" onClick="WdatePicker({dateFmt:\'yyyy-MM-dd\'})" />' +
            '&#12288;&#12288;&nbsp;&nbsp;&nbsp;管理单位：<select name="managerunit" style="width: 154px;">';
        $.ajaxSettings.async = false;
        $.post(BASE_URL + '/map/getManagementUnit.action', function (data) {
            $.each(data, function (i, item) {
                tempStr += '<option>' + item.name + '</option>';
            });
            temp3 += tempStr + '</select></div>';
        });
        $.ajaxSettings.async = true;


        $("#submitResourceButton").unbind("click").bind("click", function () {
            submitFacilityData();
        });
        var temp4 = null;
        if (geometry === 'point') {
            addInteraction();
            temp4 = '<div>&#12288;&#12288;经度：<input  id="longitude" name="longitude" type="text" style="width: 150px;margin-right:50px;" readonly="readonly">&#12288;&#12288;&#12288;&#12288;&nbsp;&nbsp;&nbsp;维度：<input name="latitude" id="latitude" type="text" style="width:150px;" readonly="readonly"></div>';

        } else if (geometry === 'line') {
            addlineInteraction();
            temp4 = '<div>&#12288;&#12288;位置：<input type="text" value="已获取" readonly><input type="text" style="display: none" id="lineLocation" name="location" >';
        }

        var temp5 = '<div>&#12288;多媒体：<input type="file" name="file" style="margin-bottom:10px;margin-top:5px;display: inline"></div>';
        var temp6 = '<div>&#12288;&#12288;备注：<textarea name="remark" placeholder="......" style="width: 470px;height:150px;"></textarea></div>';
        var rest = temp1 + temp2 + temp3 + temp4 + temp5 + temp6;

        var temp = null;
        switch (seq) {
            //资源管理
            case 1000:
                temp = '<div><input name="objtype" value="11" style="display: none">项目类别：<input type="text" value="界碑" readonly="readonly" style="width: 150px;margin-right:50px;">&#12288;&#12288;&nbsp;&nbsp;&nbsp;界碑类型：<select name="childtype" style="width: 154px;margin-left: -1px;"><option selected="selected">同号三立柱</option><option>同号双立柱</option><option>单立柱</option></select></div>';
                break;
            case 1001:
                temp = '<div><input name="objtype" value="11" style="display: none">项目类别：<input type="text" value="国门" readonly="readonly" style="width: 150px;margin-right:50px;">&#12288;&#12288;&nbsp;&nbsp;&nbsp;国门类型：<select name="childtype" style="width: 154px;margin-left: -1px;"><option selected="selected">其他</option></select></div>';
                break;
            case 1002:
                temp = '<div><input name="objtype" value="11" style="display: none">项目类别：<input type="text" value="监控中心" readonly="readonly" style="width: 150px;margin-right:50px;">&#12288;监控中心类型：<select name="childtype" style="width: 154px;margin-left: -2px;"><option selected="selected">地级</option><option>县级</option></select></div>';
                break;
            case 1003:
                temp = '<div><input name="objtype" value="11" style="display: none">项目类别：<input type="text" value="监控站" readonly="readonly" style="width: 150px;margin-right:50px;">&#12288;&#12288;监控站类型：<select name="childtype" style="width: 154px;margin-left: -2px;"><option selected="selected">其他</option></select></div>';
                break;
            case 1004:
                temp = '<div><input name="objtype" value="11" style="display: none">项目类别：<input type="text" value="传输线路" readonly="readonly" style="width: 150px;margin-right:50px;">&#12288;传输线路类型：<select name="childtype" style="width: 154px;margin-left: -2px;"><option selected="selected">网络线</option><option>租用中国电信光缆</option><option>租用中国移动光缆</option><option>租用中国联通光缆</option><option>复用军队光缆</option><option>其他</option></select></div>';
                break;
            case 1005:
                temp = '<div><input name="objtype" value="11" style="display: none">项目类别：<input type="text" value="报警装置" readonly="readonly" style="width: 150px;margin-right:50px;">&#12288;报警装置类型：<select name="childtype" style="width: 154px;margin-left: -2px;"><option selected="selected">其他</option></select></div>';
                break;
            case 1006:
                temp = '<div><input name="objtype" value="11" style="display: none">项目类别：<input type="text" value="执勤房" readonly="readonly" style="width: 150px;margin-right:50px;">&#12288;&#12288;执勤房类型：<select name="childtype" style="width: 154px;margin-left: -2px;"><option selected="selected">其他</option></select></div>';
                break;
            case 1007:
                temp = '<div><input name="objtype" value="11" style="display: none">项目类别：<input type="text" value="瞭望塔" readonly="readonly" style="width: 150px;margin-right:50px;">&#12288;&#12288;瞭望塔类型：<select name="childtype" style="width: 154px;margin-left: -2px;"><option selected="selected">砖瓦结构</option><option>钢架结构</option><option>其他</option></select></div>';
                break;
            case 1008:
                temp = '<div><input name="objtype" value="11" style="display: none">项目类别：<input type="text" value="标志牌" readonly="readonly" style="width: 150px;margin-right:50px;">&#12288;&#12288;标志牌类型：<select name="childtype" style="width: 154px;margin-left: -2px;"><option selected="selected">其他</option></select></div>';
                break;
            case 1009:
                temp = '<div><input name="objtype" value="11" style="display: none">项目类别：<input type="text" value="灯塔" readonly="readonly" style="width: 150px;margin-right:50px;">&#12288;&#12288;&#12288;灯塔类型：<select name="childtype" style="width: 154px;margin-left: -2px;"><option selected="selected">其他</option></select></div>';
                break;
            case 1010:
                temp = '<div><input name="objtype" value="11" style="display: none">项目类别：<input type="text" value="巡逻路" readonly="readonly" style="width: 150px;margin-right:50px;">&#12288;&#12288;巡逻路类型：<select name="childtype" style="width: 154px;margin-left: -2px;"><option selected="selected">国道</option><option>省道</option><option>其他</option></select></div>';
                break;
            case 1011:
                temp = '<div><input name="objtype" value="11" style="display: none">项目类别：<input type="text" value="桥梁" readonly="readonly" style="width: 150px;margin-right:50px;">&#12288;&#12288;&#12288;桥梁类型：<select name="childtype" style="width: 154px;margin-left: -2px;"><option selected="selected">吊桥</option><option>索道桥</option><option>人行桥</option><option>车行桥</option><option>其他</option></select></div>';
                break;
            case 1012:
                temp = '<div><input name="objtype" value="11" style="display: none">项目类别：<input type="text" value="执勤码头" readonly="readonly" style="width: 150px;margin-right:50px;">&#12288;执勤码头类型：<select name="childtype" style="width: 154px;margin-left: -2px;"><option selected="selected">其他</option></select></div>';
                break;
            case 1013:
                temp = '<div><input name="objtype" value="11" style="display: none">项目类别：<input type="text" value="直升机停机坪" readonly="readonly" style="width: 150px;margin-right:35px;">直升机停机坪类型：<select name="childtype" style="width: 154px;margin-left: -2px;"><option selected="selected">直升机</option><option>其他</option></select></div>';
                break;
            case 1014:
                temp = '<div><input name="objtype" value="11" style="display: none">项目类别：<input type="text" value="通道" readonly="readonly" style="width: 150px;margin-right:50px;">&#12288;&#12288;&#12288;通道类型：<select name="childtype" style="width: 154px;margin-left: -2px;"><option selected="selected">协议通道</option><option>非法便道</option><option>双边协议通道</option><option>双边非协议通道</option></select></div>';
                break;
            case 1015:
                temp = '<div><input name="objtype" value="11" style="display: none">项目类别：<input type="text" value="口岸" readonly="readonly" style="width: 150px;margin-right:50px;">&#12288;&#12288;&#12288;口岸类型：<select name="childtype" style="width: 154px;margin-left: -2px;"><option selected="selected">民间渡口</option><option>非法渡口</option><option>一级口岸</option><option>二级口岸</option></select></div>';
                break;
            case 1016:
                temp = '<div><input name="objtype" value="11" style="display: none">项目类别：<input type="text" value="铁丝网" readonly="readonly" style="width: 150px;margin-right:50px;">&#12288;&#12288;铁丝网类型：<select name="childtype" style="width: 154px;margin-left: -2px;"><option selected="selected">敷设通信线路型</option><option>租用中国电信光缆</option><option>T型铁丝网</option><option>单列桩铁丝网</option><option>其他</option></select></div>';
                break;
            case 1017:
                temp = '<div><input name="objtype" value="11" style="display: none">项目类别：<input type="text" value="铁栅栏" readonly="readonly" style="width: 150px;margin-right:50px;">&#12288;&#12288;铁栅栏类型：<select name="childtype" style="width: 154px;margin-left: -2px;"><option selected="selected">其他</option></select></div>';
                break;
            case 1018:
                temp = '<div><input name="objtype" value="11" style="display: none">项目类别：<input type="text" value="隔离带" readonly="readonly" style="width: 150px;margin-right:50px;">&#12288;&#12288;隔离带类型：<select name="childtype" style="width: 154px;margin-left: -2px;"><option selected="selected">其他</option></select></div>';
                break;
            case 1019:
                temp = '<div><input name="objtype" value="11" style="display: none">项目类别：<input type="text" value="车辆拦阻设施" readonly="readonly" style="width: 150px;margin-right:35px;">车辆拦阻设施类型：<select name="childtype" style="width: 154px;margin-left: -2px;"><option selected="selected">其他</option></select></div>';
                break;
        }
        resourceLayerBody.append(temp, rest);
        return;

    } else if (type === 'equipment') {
        addInteraction();
        $('#resourceContent').css('width', '500px');

        var ownedUnit = "<select style='width:304px;' name='departmentid'>";
        $.ajaxSettings.async = false;
        $.post(BASE_URL + '/map/getManagementUnit.action', function (data) {
            $.each(data, function (i, item) {
                tempStr += '<option value="' + item.id + '">' + item.name + '</option>';
            });
            ownedUnit += tempStr + '</select>';
        });
        $.ajaxSettings.async = true;

        var equipmentStr = "<div style='text-align: center'><div style='margin-left:10px;'>装备名称： <input style='width:300px;' type='text' name='name' placeholder='请输入名称'> *</div>" +
            "<div style='margin-left:10px;'>型号规格： <input type='text' style='width:300px;' name='model' placeholder='请输入规格'> *</div>" +
            "<div style='margin-left:10px;'>装备数量： <input type='text' style='width:300px;' name='count' placeholder='请输入数字'> *</div>" +
            "<div>装备类型： <select type='text' style='width:304px;' name='type'><option>车载</option><option>手持机</option><option>武器</option><option>雷达</option></select></div>" +
            "<div>所属单位： " + ownedUnit + "</div>" +
            "<div>生产厂家： <input type='text' name='factory' style='width:300px;' placeholder='请输入厂家'></div>" +
            "<div style='margin:5px 25px 5px 0'>&#12288;多媒体： <input style='display: inline;' type='file' name='file'> </div>" +
            "<div>&#12288;&#12288;经度： <input style='width: 100px;margin-right:50px;' type='text' name='longitude' id='longitude' >维度： <input style='width:100px;' type='text' name='latitude' id='latitude'></div>" +
            "<div style='margin-top:5px;'>&#12288;&#12288;备注： <textarea style='width: 302px;height: 150px;' type='text' name='remark'></textarea></div></div>";
        resourceLayerBody.append(equipmentStr);
        $("#submitResourceButton").unbind("click").bind("click", function () {
            submitEquipment();
        });

        return;
    }
    if (type === 'camera') {
        addInteraction();
        $('#resourceContent').css('width', '580px');
        var userUnit = "<select name='userunit' style='width: 160px;'>";
        var managerUnit = "<select name='managerunit' style='width: 160px;'>";
        $.ajaxSettings.async = false;
        $.post(BASE_URL + '/map/getManagementUnit.action', function (data) {
            $.each(data, function (i, item) {
                tempStr += '<option value="' + item.id + '">' + item.name + '</option>';
            });
            userUnit += tempStr + '</select>';
            managerUnit += tempStr + '</select>';

        });
        $.ajaxSettings.async = true;
        var cameraStr = "<table><tr><td>镜头名称</td><td>安装位置</td><td>设施状态</td></tr>" +
            "<tr class='event'><td><input type='text' name='name'></td><td><input type='text' name='address'></td><td ><select style='width: 162px;' name='status'><option value='0'>良好</option><option value='1'>损坏</option><option value='2'>废弃</option></select></td></tr>" +
            "<tr style='margin-top:20px;'><td>编解码设备类型</td><td>用户名</td><td>密码</td></tr>" +
            "<tr class='event'><td><select name='type' style='width: 162px;'><option value='0'>海康</option><option value='1'>大华</option></select></td><td><input type='text' name='username' value='admin'></td><td><input type='text' name='password' value='12345'></td></tr>" +
            "<tr style='margin-top:20px;'><td>IP地址</td><td>端口号</td><td>通道号</td></tr>" +
            "<tr class='event'><td><input type='text' name='ip'></td><td><input type='text' name='port' value='8000'></td><td><input type='text' name='channel' value='1'></td></tr>" +
            "<tr style='margin-top:20px'><td>竣工时间</td><td>镜头类型</td><td>图层（默认为0）</td></tr>" +
            "<tr class='event'><td><input class='Wdate' onclick='WdatePicker()' name='finishtime'></td><td><select style='width: 162px;' name='objtype'><option value='983569'>枪机</option><option value='983570'>球机</option><option value='983571'>大球</option></select></td><td><input type='text' name='layerid'></td></tr>" +
            "<tr style='margin-top:20px'><td>使用单位</td><td>管理单位</td><td>位置</td></tr>" +
            "<tr class='event'><td>" + userUnit + "</td><td>" + managerUnit + "</td><td><input type='text' style='width: 78px;' id='longitude' name='longitude' readonly><input type='text' id='latitude' style='width:78px;' name='latitude' readonly></td></tr>" +
            "<tr><td>组播地址</td></tr>" +
            "<tr class='event'><td colspan='3'><input type='text' style='width:520px;' name='playurl'></td></tr>" +
            "<tr style='margin-top:20px;'><td>备注</td></tr>" +
            "<tr><td colspan='3'><textarea style='width:520px;height:150px;' name='remark'></textarea></td></tr>";
        // "<tr><td colspan='3'><input type='file'></td></tr>";
        resourceLayerBody.append(cameraStr);
        $("#submitResourceButton").unbind("click").bind("click", function () {
            submitCameraData();
        });
    }


}

function setObjType(type) {

    switch (type) {
        case 1:
            objType = 1;
            break;
        case 2:
            objType = 2;
            break;
        case 3:
            objType = 3;
            break;
        case 4:
            objType = 4;
            break;
        case 5:
            objType = 5;
            break;
        case 6:
            objType = 6;
            break;
        case 100:
            objType = 100;
            break;
        case 101:
            objType = 101;
            break;
        case 102:
            objType = 102;
            break;
        case 103:
            objType = 103;
            break;
        case 104:
            objType = 104;
            break;
        case 105:
            objType = 105;
            break;
        case 106:
            objType = 106;
            break;
        case 107:
            objType = 107;
            break;
        case 108:
            objType = 108;
            break;
        case 109:
            objType = 109;
            break;
        case 110:
            objType = 110;
            break;
        case 111:
            objType = 111;
            break;
        case 112:
            objType = 112;
            break;
        case 113:
            objType = 113;
            break;
        case 114:
            objType = 114;
            break;
        case 115:
            objType = 115;
            break;
        case 116:
            objType = 116;
            break;
        case 117:
            objType = 117;
            break;

    }

}

var jointStr = "";
var geoStr = null; // 当前绘制图形的坐标串
var currentFeature = null; //当前绘制的几何要素


/**
 * 绘制结束事件的回调函数，
 * @param {ol.interaction.DrawEvent} evt 绘制结束事件
 */
function drawEndCallBack(evt) {
    // var geoType = $("#type option:selected").val();//绘制图形类型
    var geoType = 'Point';

    currentFeature = evt.feature; //当前绘制的要素
    var geo = currentFeature.getGeometry(); //获取要素的几何信息
    var coordinates = geo.getCoordinates(); //获取几何坐标
    console.log(coordinates);
    //将几何坐标拼接为字符串
    if (geoType === "Polygon") {
        geoStr = coordinates[0].join(";");
    }
    else {
        geoStr = coordinates.join(";");
        $('#longitude').val(coordinates[0]);
        $('#latitude').val(coordinates[1]);
    }
    $('#resourceLayer').modal('show'); //打开属性信息设置对话框
    map.removeInteraction(draw);
}

/**
 * 绘制结束事件线型的回调函数，
 * @param {ol.interaction.DrawEvent} evt 绘制结束事件
 */
function drawEndClineBack(evt) {
    // var geoType = $("#type option:selected").val();//绘制图形类型
    var geoType = 'LineString';

    currentFeature = evt.feature; //当前绘制的要素
    var geo = currentFeature.getGeometry(); //获取要素的几何信息
    var coordinates = geo.getCoordinates(); //获取几何坐标
    console.log(coordinates);
    //将几何坐标拼接为字符串
    if (geoType === "Point") {
        geoStr = coordinates[0].join(";");
        $('#longitude').val(coordinates[0]);
        $('#latitude').val(coordinates[1]);

    }
    else {
        geoStr = coordinates.join(";");
        console.log(coordinates);
        console.log(coordinates[0]);
        console.log(geoStr);
        $('#lineLocation').val(geoStr);
    }
    $('#resourceLayer').modal('show'); //打开属性信息设置对话框
    map.removeInteraction(draw);
}

/**
 * 根据绘制类型进行交互绘制图形处理
 */
function addInteraction() {
    // var value = typeSelect.value; //绘制类型
    //实例化交互绘制类对象并添加到地图容器中
    draw = new ol.interaction.Draw({
        source: source, //绘制层数据源
        type: 'Point'  //几何图形类型
    });
    map.addInteraction(draw);
    //添加绘制结束事件监听，在绘制结束后保存信息到数据库
    draw.on('drawend', drawEndCallBack, this);
}

/**
 * 根据绘制线性进行交互绘制图形处理
 */
function addlineInteraction() {
    // var value = typeSelect.value; //绘制类型
    //实例化交互绘制类对象并添加到地图容器中
    draw = new ol.interaction.Draw({
        source: source, //绘制层数据源
        type: 'LineString'  //几何图形类型
    });
    map.addInteraction(draw);
    //添加绘制结束事件监听，在绘制结束后保存信息到数据库
    draw.on('drawend', drawEndClineBack, this);
}


/**
 * 将绘制的几何数据与对话框设置的属性数据提交到后台处理
 * 提交facility
 */
function submitFacilityData() {
    // var geoType = $("#type option:selected").val(); //绘制图形类型
    $("#resourceLayerBody").attr("enctype", "multipart/form-data");
    var form = new FormData(document.getElementById("resourceLayerBody"));
    $.ajax({
        url: BASE_URL + '/map/createFacility.action',
        type: "POST",
        data: form,
        async: false,
        cache: false,
        contentType: false,
        processData: false,
        success: function (data) {
            $('#resourceLayer').modal('hide');
            console.log("data" + data);
            alert('新建资源成功');
        },
        error: function (data) {
            alert("error:" + '资源错误');
        }
    });
    currentFeature = null;  //置空当前绘制的几何要素
    geoStr = null; //置空当前绘制图形的geoStr
}

/**
 * 将绘制的几何数据与对话框设置的属性数据提交到后台处理
 * 提交camera
 */
function submitCameraData() {
    var resourceLayerBody = $("#resourceLayerBody");
    resourceLayerBody.attr("enctype", "application/x-www-form-urlencoded");
    var data = resourceLayerBody.serialize();

    $.post(BASE_URL + '/map/createCamera.action', data, function () {
        alert('新建资源成功');
        $('#resourceLayer').modal('hide');
    });
    currentFeature = null;  //置空当前绘制的几何要素
    geoStr = null; //置空当前绘制图形的geoStr
}

/**
 * 将绘制的几何数据与对话框设置的属性数据提交到后台处理
 * 提交equipment
 */
function submitEquipment() {
    $("#resourceLayerBody").attr("enctype", "multipart/form-data");
    var form = new FormData(document.getElementById("resourceLayerBody"));
    console.log(form);
    $.ajax({
        url: BASE_URL + '/map/createEquipment.action',
        type: "POST",
        data: form,
        async: false,
        cache: false,
        contentType: false,
        processData: false,
        success: function (data) {
            $('#resourceLayer').modal('hide');
            console.log("data" + data);
            alert('新建资源成功');
        },
        error: function (data) {
            alert("error:" + '资源错误');
        }
    });
    currentFeature = null;  //置空当前绘制的几何要素
    geoStr = null; //置空当前绘制图形的geoStr
}

function addIcon(coord, type) {
    if (type === null) {
        return;
    } else {
        var picSrc = null;
        if(geo.intersectsCoordinate(coord)) {
            alert("报警区域内");
        }
        objType = null;
        switch (type) {
            case 1:
                picSrc = "../images/map/military/soldier.png";
                break;
            case 2:
                picSrc = "../images/map/military/vehicle.png";
                break;
            case 3:
                picSrc = "../images/map/military/plane.png";
                break;
            case 4:
                picSrc = "../images/map/department/department.png";
                break;
            case 5:
                picSrc = "../images/map/military/pin.png";
                break;
            case 6:
                picSrc = "../images/map/military/water.png";
                break;
            case 100:
                picSrc = "../images/map/military/military_pic/100.png";
                break;
            case 101:
                picSrc = "../images/map/military/military_pic/101.png";
                break;
            case 102:
                picSrc = "../images/map/military/military_pic/102.png";
                break;
            case 103:
                picSrc = "../images/map/military/military_pic/103.png";
                break;
            case 104:
                picSrc = "../images/map/military/military_pic/104.png";
                break;
            case 105:
                picSrc = "../images/map/military/military_pic/105.png";
                break;
            case 106:
                picSrc = "../images/map/military/military_pic/106.png";
                break;
            case 107:
                picSrc = "../images/map/military/military_pic/107.png";
                break;
            case 108:
                picSrc = "../images/map/military/military_pic/108.png";
                break;
            case 109:
                picSrc = "../images/map/military/military_pic/109.png";
                break;
            case 110:
                picSrc = "../images/map/military/military_pic/110.png";
                break;
            case 111:
                picSrc = "../images/map/military/military_pic/111.png";
                break;
            case 112:
                picSrc = "../images/map/military/military_pic/112.png";
                break;
            case 113:
                picSrc = "../images/map/military/military_pic/113.png";
                break;
            case 114:
                picSrc = "../images/map/military/military_pic/114.png";
                break;
            case 115:
                picSrc = "../images/map/military/military_pic/115.png";
                break;
            case 116:
                picSrc = "../images/map/military/military_pic/116.png";
                break;
            case 117:
                picSrc = "../images/map/military/military_pic/117.png";
                break;
            default:
                return;
        }

    }


    //添加feature
    var iconFeature = new ol.Feature({
        geometry: new ol.geom.Point(coord),
        type: 'military_pic',
        coordinate: coord
    });


    iconFeature.setStyle(new ol.style.Style({
        image: new ol.style.Icon({
            src: picSrc,
            scale: map.getView().getZoom() / 14
        }),
        text: new ol.style.Text({
            textAlign: 'center', //位置
            offsetY: (type < 100) ? 24 : 32,
            textBaseline: 'middle', //基准线
            font: 'normal 14px 微软雅黑',  //文字样式
            text: '新建标注',  //文本内容
            fill: new ol.style.Fill({color: '#aa3300'}), //文本填充样式（即文字颜色）
            stroke: new ol.style.Stroke({color: '#ffcc33', width: 2})
        })
    }));


    // iconStyle.getImage().setScale(0.3);
    // iconFeature.setStyle(iconStyle);

    layer.getSource().addFeature(iconFeature);


    // var fea = iconFeature;
    //
    // fea.setStyle(new ol.style.Style({
    //     image: new ol.style.Icon({
    //         src: picSrc,
    //         scale: map.getView().getZoom() / 14
    //     }),
    //     text: new ol.style.Text({
    //         textAlign: 'center', //位置
    //         offsetY: (type < 100) ? 24 : 32,
    //         textBaseline: 'middle', //基准线
    //         font: 'normal 14px 微软雅黑',  //文字样式
    //         text: '我只是一个测试',  //文本内容
    //         fill: new ol.style.Fill({color: '#aa3300'}), //文本填充样式（即文字颜色）
    //         stroke: new ol.style.Stroke({color: '#ffcc33', width: 2})
    //     })
    // }));
    // layer.getSource().addFeature(fea);
}

/**
 * @author zc
 * @description 图标动态缩放i
 */
map.getView().on('change:resolution', function () {
    var temp = layer.getSource();
    var features = temp.getFeatures();
    // 重新设置图标的缩放率，基于层级13来做缩放
    for (index in features) {
        features[index].getStyle().getImage().setScale(this.getZoom() / 14);
    }
});

$('.totalResultNumbers').on('click', function () {
    var el = $(this);
    if (el.hasClass('totalResultNumbers')) {
        el.removeClass('totalResultNumbers').addClass('fold');
        el.parent().attr('title', '折叠');
        el.html('-&nbsp;');
    } else {
        el.removeClass('fold').addClass('totalResultNumbers');
        el.parent().attr('title', '展开');
        el.html('+');
    }
});

/**
 * @description 暂时没有使用
 */
function showSaveLayerModal() {
    var features = layer.getSource().getFeatures();
    var vectorFeatures = drawOverlay.getSource().getFeatures();
    $('#myModal').show();
    if (features.length === 0 && vectorFeatures.length === 0) {
        $('#layerRemark').innerHTML = '提示信息：当前图层无要素，不建议保存，但您仍可以保存';
    }

}

function saveLayer() {
    var layerName = $('#layerName').val();
    var layerRemark = $('#layerRemark').val();

    //正则表达式 可以去除空格 制表符等特殊符号
    if ($.trim(layerName).replace(/(^\s*)|(\s*$)/g, "").length === 0) {
        alert('请输入保存图层名称');
        return;
    }


    /**
     * @author zc
     * @function 遍历feature属性
     * @type {Array.<ol.Feature>|ol.Collection.<ol.Feature>|Array.<ol.Feature|ol.render.Feature>|*}
     */
    var features = layer.getSource().getFeatures();
    var picSrc = '';
    var coordinate = '';
    var picText = '';
    var offsetY = '';

    for (var i in features) {
        // console.log(features[i].getStyle().getText().getText());
        // console.log(features[i].getStyle().getText().getOffsetY());
        // console.log(features[i].getStyle().getImage().getSrc());
        // console.log(features[i].get('type'));
        // console.log(features[i].get('coordinate'));
        // jointStr += '['+features[i].get('coordinate') + '];';
        // console.log(jointStr);
        picSrc += features[i].getStyle().getImage().getSrc() + ';';
        coordinate += '[' + features[i].get('coordinate') + '];';
        picText += features[i].getStyle().getText().getText() + ';';
        offsetY += features[i].getStyle().getText().getOffsetY() + ';';

    }
    console.log(picSrc + ',' + coordinate + ',' + picText + ',' + offsetY);

    var vectorFeatures = drawOverlay.getSource().getFeatures();
    var wktText = '';
    for (var i in vectorFeatures) {
        var format = new ol.format.WKT(),
            wkt = format.writeGeometry(vectorFeatures[i].getGeometry());
        wktText += wkt + ';';

        // console.log("测试经纬度："+ vectorFeatures[i].getGeometry().getCoordinates());
    }
    console.log(wktText);
    $('#layerName').val('');
    $('#layerRemark').val('');

    $('#myModal').modal('hide');


    // var savetime = new Date().Format("yyyy/MM/dd hh:mm:ss");
    var savetime = new Date().Format("yyyy/MM/dd");


    $.post(BASE_URL + '/map/saveLayer.action', {
        name: layerName,
        wkttext: wktText,
        picsrc: picSrc,
        coordinate: coordinate,
        pictext: picText,
        offsety: offsetY,
        savetime: savetime,
        remark: layerRemark
    }, function () {
        alert('图层保存成功');
    });

}

// 对Date的扩展，将 Date 转化为指定格式的String
// 月(M)、日(d)、小时(h)、分(m)、秒(s)、季度(q) 可以用 1-2 个占位符，
// 年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字)
// 例子：
// (new Date()).Format("yyyy-MM-dd hh:mm:ss.S") ==> 2006-07-02 08:09:04.423
// (new Date()).Format("yyyy-M-d h:m:s.S")      ==> 2006-7-2 8:9:4.18
Date.prototype.Format = function (fmt) { //author: meizz
    var o = {
        "M+": this.getMonth() + 1, //月份
        "d+": this.getDate(), //日
        "h+": this.getHours(), //小时
        "m+": this.getMinutes(), //分
        "s+": this.getSeconds(), //秒
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度
        "S": this.getMilliseconds() //毫秒
    };
    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
        if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
};

/*提交事件查询统计*/
function bindSubmitEvent(type) {
    /*    $('.selectpicker').selectpicker('val', '');
        $('.selectpicker').selectpicker('refresh');
        $(".selectpicker").selectpicker({
            noneSelectedText : '请选择'//默认显示内容
        });*/
    $('#eventStatistics').modal('show');
    $('#submitEventButton').unbind('click').bind('click', function () {
        var addr = $('#eventAddr').val();
        var eventBeginTime = $('#eventBeginTime').val();
        var eventEndTime = $('#eventEndTime').val();

        if ((eventBeginTime !== '' && eventEndTime === '') || (eventBeginTime === '' && eventEndTime !== '')) {
            alert("请同时选择开始与结束时间");
            return;
        }
        if (eventEndTime < eventBeginTime) {
            alert("结束时间不能小于开始时间");
            return;
        }

        if (addr === null) {
            $.ajaxSettings.async = false;
            $.post(BASE_URL + '/map/getEventAddr.action', function (data) {
                addr = data;
            });
            $.ajaxSettings.async = true;
        }
        $.post(BASE_URL + '/map/getEventStatistics.action', {
            'addr': addr,
            'eventBeginTime': eventBeginTime,
            'eventEndTime': eventEndTime,
            'type': type
        }, function (data) {
            console.log(data);
            // console.log(data);
            // console.log(data.length);
            if (data.length === 0) {
                alert("查询统计结果为空，请重新查询");
                return;
            }
            var myChart = null;
            if (type === 'eventType') {
                // 基于准备好的dom，初始化echarts实例
                myChart = echarts.init(document.getElementById('eventType'));

                // 指定图表的配置项和数据
                option = {
                    toolbox: {
                        show: true,
                        feature: {
                            mark: {show: true},
                            magicType: {
                                show: true,
                                type: ['pie', 'funnel'],
                                option: {
                                    grid: {left: '1%', right: '0', bottom: '1%', top: '0%', containLabel: true},
                                    funnel: {
                                        x: '25%',
                                        width: '50%',
                                        funnelAlign: 'left',
                                        max: 1548
                                    }
                                }
                            },
                            saveAsImage: {show: true}
                        }
                    },
                    calculable: true,

                    series: [
                        {
                            name: '事件来源',
                            type: 'pie',
                            radius: '55%',
                            center: ['50%', '60%'],
                            data: data
                        }
                    ]
                };
                // 使用刚指定的配置项和数据显示图表。
                myChart.setOption(option);
            } else if (type === 'eventNum') {
                var months = [];
                var nums = [];
                $.each(data, function (index, item) {
                    months.push(item.time);
                    nums.push(item.value);
                });

                // 基于准备好的dom，初始化echarts实例
                myChart = echarts.init(document.getElementById('eventNum'));

                // 指定图表的配置项和数据
                var option = {
                    grid: {left: '1%', right: '0', bottom: '1%', y: 10, containLabel: true},
                    xAxis: {
                        data: months,
                        axisLine: {
                            lineStyle: {
                                color: 'white'
                            }
                        }
                    },
                    yAxis: {
                        axisLine: {
                            lineStyle: {
                                color: 'white'
                            }
                        }
                    },
                    series: [{
                        itemStyle:{
                            normal:{
                                color:'#4ad2ff'
                            }
                        },
                        name: '数量',
                        type: 'bar',
                        data: nums
                    }]
                };

                // 使用刚指定的配置项和数据显示图表。
                myChart.setOption(option);
            } else if (type === 'eventProp') {
                var level = [];
                var nums = [];
                $.each(data, function (index, item) {
                    if (item.level === 1) {
                        level.push('轻度');
                        nums.push(item.value);
                    }
                    if (item.level === 2) {
                        level.push('中度');
                        nums.push(item.value);
                    }
                    if (item.level === 3) {
                        level.push('重度');
                        nums.push(item.value);
                    }
                });

                // 基于准备好的dom，初始化echarts实例
                myChart = echarts.init(document.getElementById('eventProp'));

                // 指定图表的配置项和数据
                option = {

                    tooltip: {
                        trigger: 'axis'
                    },
                    grid: {left: '1%', bottom: '1%', containLabel: true},
                    toolbox: {
                        show: true,
                        feature: {
                            magicType: {show: true, type: ['line', 'bar']},
                            saveAsImage: {show: true}
                        }
                    },
                    calculable: true,
                    xAxis: [
                        {
                            type: 'value',
                            axisLine: {
                                lineStyle: {
                                    color: 'white'
                                }
                            }
                        }
                    ],
                    yAxis: [
                        {
                            type: 'category',
                            data: level,
                            axisLine: {
                                lineStyle: {
                                    color: 'white'
                                }
                            }
                        }
                    ],
                    series: [
                        {
                            name: '数量',
                            type: 'bar',
                            data: nums,
                            itemStyle:{
                                normal:{
                                    color:'#4ad2ff'
                                }
                            }
                        }
                    ]
                };


                // 使用刚指定的配置项和数据显示图表。
                myChart.setOption(option);
            } else if (type === 'eventRegion') {
                var regions = [];
                var nums = [];
                var max = data[0].value;
                $.each(data, function (index, item) {
                    regions.push({text: item.addr, max: max});
                    nums.push(item.value);
                });

                // 基于准备好的dom，初始化echarts实例
                myChart = echarts.init(document.getElementById('eventRegion'));

                // 指定图表的配置项和数据
                option = {
                    grid: {left: '10%', right: '0', bottom: '1%', y: 10, containLabel: true},
                    tooltip: {
                        trigger: 'axis'
                    },
                    toolbox: {
                        show: true,
                        feature: {
                            mark: {show: true},
                            saveAsImage: {show: true}
                        }
                    },
                    radar: [
                        {
                            indicator: regions,
                            radius: 40
                        }
                    ],
                    series: [
                        {
                            type: 'radar',
                            tooltip: {
                                trigger: 'item'
                            },
                            itemStyle: {normal: {areaStyle: {type: 'default'}}},
                            data: [
                                {
                                    value: nums,
                                    name: '区域统计：'
                                }
                            ]
                        }
                    ]
                };
                // 使用刚指定的配置项和数据显示图表。
                myChart.setOption(option);
            }
            $('#eventStatistics').modal('hide');
        });
    });
}

function initStatistics(type) {
    var eventBeginTime = '';
    var eventEndTime = '';
    var addr = null;
    $.ajaxSettings.async = false;
    $.post(BASE_URL + '/map/getEventAddr.action', function (data) {
        addr = data;
    });
    $.ajaxSettings.async = true;

    $.post(BASE_URL + '/map/getEventStatistics.action', {
        'addr': addr,
        'eventBeginTime': eventBeginTime,
        'eventEndTime': eventEndTime,
        'type': type
    }, function (data) {
        console.log(data);
        var myChart = null;
        if (type === 'eventType') {
            // 基于准备好的dom，初始化echarts实例
            myChart = echarts.init(document.getElementById('eventType'));

            // 指定图表的配置项和数据
            option = {
                toolbox: {
                    show: true,
                    feature: {
                        mark: {show: true},
                        magicType: {
                            show: true,
                            type: ['pie', 'funnel'],
                            option: {
                                grid: {left: '1%', right: '0', bottom: '1%', top: '0%', containLabel: true},
                                funnel: {
                                    x: '25%',
                                    width: '50%',
                                    funnelAlign: 'left',
                                    max: 1548
                                }
                            }
                        },
                        saveAsImage: {show: true}
                    }
                },
                calculable: true,
                color:['white', '#4ad2ff','yellow','#E98F6F'],
                tooltip : {
                    trigger: 'item',
                    formatter: "{a} <br/>{b} : {c} ({d}%)"
                },
                series: [
                    {

                        name: '事件类型',
                        type: 'pie',
                        radius: '55%',
                        center: ['50%', '60%'],
                        data: data

                    }
                ]
            };
            // 使用刚指定的配置项和数据显示图表。
            myChart.setOption(option);
        } else if (type === 'eventNum') {
            var months = [];
            var nums = [];
            $.each(data, function (index, item) {
                months.push(item.time);
                nums.push(item.value);
            });

            // 基于准备好的dom，初始化echarts实例
            myChart = echarts.init(document.getElementById('eventNum'));

            // 指定图表的配置项和数据
            var option = {
                grid: {left: '1%', right: '0', bottom: '1%', y: 10, containLabel: true},
                tooltip : {
                    trigger: 'axis'
                },
                xAxis: {
                    axisLine: {
                        lineStyle: {
                            color: 'white'
                        }
                    },
                    data: months
                },
                yAxis: {
                    axisLine: {
                        lineStyle: {
                            color: 'white'
                        }
                    }
                },
                series: [{
                    itemStyle:{
                        normal:{
                            color:'#4ad2ff'
                        }
                    },
                    name: '数量',
                    type: 'bar',
                    data: nums
                }]
            };

            // 使用刚指定的配置项和数据显示图表。
            myChart.setOption(option);
        } else if (type === 'eventProp') {
            var level = [];
            var nums = [];
            $.each(data, function (index, item) {
                if (item.level === 1) {
                    level.push('轻度');
                    nums.push(item.value);
                }
                if (item.level === 2) {
                    level.push('中度');
                    nums.push(item.value);
                }
                if (item.level === 3) {
                    level.push('重度');
                    nums.push(item.value);
                }
            });

            // 基于准备好的dom，初始化echarts实例
            myChart = echarts.init(document.getElementById('eventProp'));

            // 指定图表的配置项和数据
            option = {
                tooltip: {
                    trigger: 'axis'
                },
                grid: {left: '1%', bottom: '1%', y: 20, containLabel: true},
                toolbox: {
                    show: true,
                    feature: {
                        magicType: {show: true, type: ['line', 'bar']},
                        saveAsImage: {show: true}
                    }
                },
                calculable: true,
                xAxis: [
                    {
                        type: 'value',
                        axisLine: {
                            lineStyle: {
                                color: 'white'
                            }
                        }
                    }
                ],
                yAxis: [
                    {
                        type: 'category',
                        data: level,
                        axisLine: {
                            lineStyle: {
                                color: 'white'
                            }
                        }
                    }
                ],
                series: [
                    {
                        itemStyle:{
                            normal:{
                                color:'#4ad2ff'
                            }
                        },
                        name: '数量',
                        type: 'bar',
                        data: nums
                    }
                ]
            };


            // 使用刚指定的配置项和数据显示图表。
            myChart.setOption(option);
        } else if (type === 'eventRegion') {
            var regions = [];
            var nums = [];
            var max = data[0].value;
            $.each(data, function (index, item) {
                regions.push({text: item.addr, max: max});
                nums.push(item.value);
            });

            // 基于准备好的dom，初始化echarts实例
            myChart = echarts.init(document.getElementById('eventRegion'));

            // 指定图表的配置项和数据
            option = {
                grid: {left: '10%', right: '0', bottom: '1%', y: 10, containLabel: true},
                tooltip: {
                    trigger: 'axis'
                },
                toolbox: {
                    show: true,
                    feature: {
                        mark: {show: true},
                        saveAsImage: {show: true}
                    }
                },
                radar: [
                    {
                        indicator: regions,
                        radius: 40
                    }
                ],
                series: [
                    {
                        type: 'radar',
                        tooltip: {
                            trigger: 'item'
                        },
                        // symbol: "none", // 去掉图表中各个图区域的边框线拐点
                        itemStyle: {
                            color:'#005AAF', // 图表中各个图区域的边框线拐点颜色
                            normal: {
                                lineStyle: {
                                    color :"#4ad2ff",// 图表中各个图区域的边框线颜色
                                    width : 2
                                },
                                areaStyle: {
                                    color:"#4ad2ff",
                                    type: 'default'
                                }
                            }
                        },
                        data: [
                            {
                                value: nums,
                                name: '区域统计：'

                            }
                        ]
                    }
                ]
            };
            // 使用刚指定的配置项和数据显示图表。
            myChart.setOption(option);
        }
        $('#eventStatistics').modal('hide');
    });
}

function changeTheme(type) {

    if(type === 'black') {
        $('#searchResult').css('background-color', '#313833');
        $('#filling_header').css('background-color', '#313833');
        $('#searchKeyword').css('background-color', '#313833');
        $('#searchButton').css('background-color', '#313833');
        $('#float-news').css('cssText', 'background-color: #313833 !important');
    } else if (type === 'purple') {
        $('#searchResult').css('background-color', 'purple');
        $('#filling_header').css('background-color', 'purple');
        $('#searchKeyword').css('background-color', 'purple');
        $('#searchButton').css('background-color', 'purple');
        $('#float-news').css('cssText', 'background-color: purple !important');
    }
}


function modifySystemSet() {
    changeTheme($("input[name='theme']:checked").val())
}


