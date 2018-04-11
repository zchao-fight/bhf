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
        //资源管理
        case 1000:
            objType = 1000;
            break;
        case 1001:
            objType = 1001;
            break;
        case 1002:
            objType = 1002;
            break;
    }

}

var jointStr = "";
var geoStr = null; // 当前绘制图形的坐标串
var currentFeature = null; //当前绘制的几何要素

function addIcon(coord, type) {
    if (type === null) {
        return;
    } else {
        var picSrc = null;
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
            case 1000:
                picSrc = '';
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
 * 绘制结束事件的回调函数，
 * @param {ol.interaction.DrawEvent} evt 绘制结束事件
 */
function drawEndCallBack(evt) {
    var geoType = $("#type option:selected").val();//绘制图形类型
    $("#dialog-confirm").dialog("open"); //打开属性信息设置对话框
    currentFeature = evt.feature; //当前绘制的要素
    var geo = currentFeature.getGeometry(); //获取要素的几何信息
    var coordinates = geo.getCoordinates(); //获取几何坐标
    //将几何坐标拼接为字符串
    if (geoType === "Polygon") {
        geoStr = coordinates[0].join(";");
    }
    else {
        geoStr = coordinates.join(";");
    }
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
}


