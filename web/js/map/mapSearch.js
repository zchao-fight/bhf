function hideSearchResult() {
    $('#searchResult').hide(1000);
}

function showResult() {
    var keywordStr = $('#searchKeyword').val();
    //去除前后空格
    var keyword = $.trim(keywordStr);
    //正则表达式 可以去除空格 制表符等特殊符号
    // if (keyword.replace(/(^\s*)|(\s*$)/g, "").length == 0) {
    //     alert('请输入搜索内容');
    //     return;
    // }


    /**
     * 展示shp图层，地名搜索
     */

    if (keyword !== '') {
        var filterParams = {
            'FILTER': null,
            'CQL_FILTER': null,
            'FEATUREID': null
        };
        var searchSHP = "NAME LIKE '%"+keyword+"%'";
        filterParams["CQL_FILTER"] = searchSHP;
        tileLayer.getSource().updateParams(filterParams);


        var wmsFeature = new ol.format.WMSGetFeatureInfo(['bhf']);
        console.log(wmsFeature);
        var tempArray = wmsFeature.readFeatures();
        console.log(tempArray);


    } else {
        var filterParams = {
            'FILTER': null,
            'CQL_FILTER': '',
            'FEATUREID': null
        };
        tileLayer.getSource().updateParams(filterParams);
    }







    $.post(BASE_URL + '/map/search.action', {keyword: keyword}, function (data) {

        for (var temp = 1; temp < 11; temp++) {
            $(".panel-whole" + temp).hide();
        }
        var totalNum = 0;
        $.each(data, function (i, entry) {
            totalNum += entry.length;
            resultStr = '<div style="margin-left: 10px;">符合条件个数：' + entry.length + '</div>'
            $.each(entry, function (j, item) {
                switch (i) {
                    case '#departmentResult':
                        $(".panel-whole1").show();
                        resultStr += ' <li onclick="locateDepartment(' + item.id + ')"><span>名称：' + item.name + '</span><a onclick=sendCommand("call_tel",'+item.phone+') style="float: right;margin-right: 20px;">' + item.phone + '</a> <br> <span  style="margin-top: 10px;display: block"">地址：' + item.addr + '</span> </li>';
                        break;
                    case '#cameraResult':
                        $(".panel-whole2").show();
                        resultStr += ' <li onclick="locateCamera(' + item.id + ')"><span>名称：' + item.name + '</span><span style="float: right;margin-right: 20px"><a onclick=sendCommand("play_video",'+item.id+')>播放</a></span> <br> <span style="margin-top: 10px;display: block"">地址：' + item.address + '</span> </li>';
                        break;
                    case '#facilityResult':
                        $(".panel-whole3").show();
                        resultStr += '<li onclick="locateFacility(' + item.id + ')"><span>名称：' + item.name + '</span> <br> <span style="margin-top: 10px;display: block"">地址：' + item.address + '</span> </li>';
                        break;
                    case '#preplanResult':
                        $(".panel-whole5").show();
                        resultStr += ' <li onclick="checkPreplanDetails(' + item.id + ')"><span style="overflow: hidden;white-space: nowrap;-ms-text-overflow: ellipsis;text-overflow: ellipsis;">名称：' + item.name + '</span> <span style="float: right;margin-right: 20px">' + item.type + '</span><br> <div style="overflow: hidden;white-space: nowrap;-ms-text-overflow: ellipsis;text-overflow: ellipsis;margin-top: 10px;">描述：' + item.decribe + '</div> </li>';
                        break;
                    case '#caseResult':
                        $(".panel-whole6").show();
                        resultStr += ' <li onclick="checkCaseDetails(' + item.id + ')"><span>名称：' + item.name + '</span> <span style="float: right;margin-right: 20px">' + item.eventtime + '</span><br> <span style="margin-top: 10px;display: block">地址：' + item.eventaddress + '</span> </li>';
                        break;
                    case '#professorResult':
                        $(".panel-whole7").show();
                        resultStr += ' <li onclick="checkProfessorDetails(' + item.id + ')"><span>名称：' + item.name + '</span> <span style="float: right;margin-right: 20px">' + item.mobiephone + '</span><br> <span style="display: block;overflow: hidden;white-space: nowrap;-ms-text-overflow: ellipsis;text-overflow: ellipsis;margin-top: 10px;">描述：' + item.remark + '</span> </li>';
                        break;
                    case '#lawResult':
                        $(".panel-whole8").show();
                        resultStr += ' <li onclick="checkLawDetails(' + item.id + ')"><span>名&#12288;称：' + item.name + '</span> <br> <span style="margin-top: 10px;display: block">关键字：' + item.keywords + '</span> </li>';
                        break;
                    case '#eventResult':
                        $(".panel-whole9").show();
                        resultStr += ' <li onclick="checkEventDetails(' + item.id + ')"><span>名称：' + item.name + '</span> <div style="margin-top: 10px;">地址：' + item.address + '</div> </li>';
                        break;
                    case '#military':
                        $(".panel-whole10").show();
                        resultStr += ' <li onclick="displayLayer(' + item.id + ')"><span>名称：' + item.name + '</span><span style="float: right;margin-right: 20px">' + item.savetime + '&nbsp;&nbsp;&nbsp;<a  href="javascript:deleteMilitaryLayer('+item.id+')"><img style="margin-bottom: 3px" src="../../images/map/delete.png"></a></span><div style="margin-top: 10px;">备注信息：' + item.remark + '</div> </li>';
                        break;
                }
            });
            $(i).html(resultStr);
        });

        if (totalNum === 0) {
            $('#totalNum').html('未查询到符合条件结果');
        } else {
            $('#totalNum').html('查询符合条件总数为:'+totalNum+'条');
        }
    });
    $("#searchResult").show(1000);
}

function deleteMilitaryLayer(id) {
    // alert("删除成功");
    $.ligerDialog.confirm('确定删除元素吗？', function (flag) {
        if (flag) {
            $.post(BASE_URL + '/map/deleteMilitaryLayer.action', {id: id}, function (data) {
                showResult();
            });
        }
    })
}

function checkUndefined(str) {
    if (str == null) {
        return "无"
    } else {
        return str;
    }
}

function checkURLUndefined(str) {
    if (str == null) {
        return "javascript:void(0)"
    } else {
        return str;
    }
}

function checkPreplanDetails(id) {
    $.post(BASE_URL + '/map/checkPreplanDetails.action', {id: id}, function (data) {
        var resultStr = '<div style="margin: 10px 0px;color: #4AD5FC;"><h4>预案信息</h4><a style="float: right;margin-right: 10px;" class="ol-popup-closer" onclick="hideDetailsPanel()"></a></div>';
        resultStr += ' <li>预案名称：' + data.name + '</li>' +
            '<li>所属单位：' + data.department + '</li>' +
            '<li>事件类型：' + data.type + '</li>' +
            '<li>事件性质：' + data.property + '</li>' +
            '' + checkURLUndefined(data.filepath)+'<li>文件查看：<a href="/">'+data.filename + '' + checkUndefined(data.filename) + '</a></li>' +
            '<li>处置流程：<textarea style="width:260px;height:140px;" readonly>' + data.dealflow + '</textarea></li>' +
            '<li>事件描述：<textarea style="width:260px;height:140px;" readonly>' + data.decribe + '</textarea></li>' +
            '<li>组织指挥：<textarea style="width:260px;height:140px;" readonly>' + data.command + '</textarea></li>' +
            '<li>参与力量：<textarea style="width:260px;height:140px;" readonly>' + data.participant + '</textarea></li>';
        $('#resultDetails').find('ul').html(resultStr);
    });
    $("#resultDetails").show();
}

function checkCaseDetails(id) {
    $.post(BASE_URL + '/map/checkCaseDetails.action', {id: id}, function (data) {
        var resultStr = '<div style="margin: 10px 0px;color: #4AD5FC;"><h4>案例信息</h4><a style="float: right;margin-right: 10px;" class="ol-popup-closer" onclick="hideDetailsPanel()"></a></div>';
        resultStr += '<li>案例名称：' + data.name + '</li>' +
            '<li>&#12288;&#12288;时间：' + data.eventtime + '</li>' +
            '<li>&#12288;&#12288;地点：' + data.eventaddress + '</li>' +
            '<li>&#12288;关键字：' + data.keywords + '</li>' +
            '<li>事件类型：' + data.type + '</li>' +
            '<li>事件规模：' + data.eventscale + '</li>' +
            '<li>事件性质：' + data.eventlevel + '</li>' +
            '' + checkURLUndefined(data.filepath) +'<li>相关文件：<a href="/">'+data.filename+ '' + checkUndefined(data.filename) + '</a></li>' +
            '<li>事件描述：<textarea style="width:260px;height:160px;" readonly>' + data.eventdescribe + '</textarea></li>' +
            '<li>解决方案：<textarea style="width:260px;height:160px;" readonly>' + data.eventsolution + '</textarea></li>' +
            '<li>处置结果：<textarea style="width:260px;height:160px;" readonly>' + data.eventresult + '</textarea></li>';
        $('#resultDetails').find('ul').html(resultStr);
    })
    $("#resultDetails").show();
}

function checkProfessorDetails(id) {
    $.post(BASE_URL + '/map/checkProfessorDetails.action', {id: id}, function (data) {
        var resultStr = '<div style="margin: 10px 0px;color: #4AD5FC;"><h4>专家信息</h4><a style="float: right;margin-right: 10px;" class="ol-popup-closer" onclick="hideDetailsPanel()"></a></div>';
        resultStr += ' <li style="float: right;margin-right: 20px;margin-top: 20px"><img style="width:120px;height:150px" src="#"></li><li>专家姓名：' + data.name + '</li>' +
            '<li>&#12288;&#12288;性别：' + (data.sex == 0 ? "男" : "女") + '</li>' +
            '<li>&#12288;&#12288;年龄：' + data.age + '</li>' +
            '<li>专业领域：' + data.field + '</li>' +
            '<li>手机号码：' + data.mobiephone + '</li>' +
            '<li>办公电话：' + data.telephone + '</li>' +
            '<li>所属单位：' + data.department + '</li>';
        $('#resultDetails').find('ul').html(resultStr);
    });
    $("#resultDetails").show();
}

function checkLawDetails(id) {

    $.post(BASE_URL + '/map/checkLawDetails.action', {id: id}, function (data) {
        var resultStr = '<div style="margin: 10px 0px;color: #4AD5FC;"><h4>法规信息</h4><a style="float: right;margin-right: 10px;" class="ol-popup-closer" onclick="hideDetailsPanel()"></a></div>';
        resultStr += '<li>&#12288;&#12288;名称：' + data.name + '</li>' +
            '<li>&#12288;&#12288;类型：' + data.type + '</li>' +
            '<li>发布文号：' + data.pulishnumber + '</li>' +
            '<li>&#12288;关键字：' + data.keywords + '</li>' +
            '<li>生效时间：' + data.abledtime + '</li>' +
            '' + checkURLUndefined(data.filepath) +'<li>附件名称：<a href="/">'+data.filename+ '' + checkUndefined(data.filename) + '</a></li>' +
            '<li>&#12288;&#12288;摘要：<textarea style="height: 600px;width:260px;" readonly>' + data.abstract + '</textarea></li>';
        $('#resultDetails').find('ul').html(resultStr);
    })
    $("#resultDetails").show();
}

function checkEventDetails(id) {
    $.post(BASE_URL + '/map/checkEventDetails.action', {id: id}, function (data) {
        var resultStr = '<div style="margin: 10px 0px;color: #4AD5FC;"><h4>事件信息</h4><a style="float: right;margin-right: 10px;" class="ol-popup-closer" onclick="hideDetailsPanel()"></a></div>';
        resultStr += '<li>&#12288;事件名称：' + data.name + '</li>' +
            '<li>&#12288;&#12288;&#12288;地点：' + data.address + '</li>' +
            '<li>&#12288;事件时间：' + data.time + '</li>' +
            '<li>&#12288;&#12288;上报人：' + data.reportpeople + '</li>' +
            '<li>上报人电话：' + data.reportpeople + '</li>' +
            '<li>&#12288;&#12288;责任人：' + data.responsepeopleid + '</li>' +
            '<li>&#12288;&#12288;处理组：' + data.commandgroupid + '</li>' +
            '<li>&#12288;&#12288;&#12288;状态：' + data.status + '</li>' +
            '<li>&#12288;&#12288;组成员：<textarea style="height: 160px;width:260px;" readonly>' + data.commandgroupid + '</textarea></li>' +
            '<li>&#12288;事件描述：<textarea style="height: 350px;width:260px;" readonly>' + data.remark + '</textarea></li>';
        $('#resultDetails').find('ul').html(resultStr);
    })
    $("#resultDetails").show();
}

function hideDetailsPanel() {
    $("#resultDetails").hide();
}

/**
 *定义全局变量，以便于清除，所有图层显示
 * @type {ol.layer.Vector}
 */
var layer = new ol.layer.Vector({
    source: new ol.source.Vector()
});
map.addLayer(layer);

function locateDepartment(id) {
    $.post(BASE_URL + '/map/locateDepartment.action', {id: id}, function (data) {
        //移动到feature所在位置
        moveToFeature([data.lng, data.lat]);
        // 创建一个Feature，并设置好在地图上的位置
        var anchor = new ol.Feature({
            geometry: new ol.geom.Point([data.lng, data.lat]),
            id: data.id,
            type: 'department',
            phone: data.phone,
            coordinate : [data.lng, data.lat]
        });
        // 设置样式，在样式中就可以设置图标
        anchor.setStyle(new ol.style.Style({
            image: new ol.style.Icon({
                src: '../images/map/department/department.png'
            }),
            text: new ol.style.Text({
                textAlign: 'center', //位置
                offsetY: 24,
                textBaseline: 'middle', //基准线
                font: 'normal 14px 微软雅黑',  //文字样式
                text: data.name,  //文本内容
                fill: new ol.style.Fill({color: '#aa3300'}), //文本填充样式（即文字颜色）
                stroke: new ol.style.Stroke({color: '#ffcc33', width: 2})
            })

        }));
        // 添加到之前的创建的layer中去
        layer.getSource().addFeature(anchor);
        // map.addLayer(layer);
    })
}


/**
 * 实现popup的html元素
 */
var container = document.getElementById('popup');
var content = document.getElementById('popup-content');
var closer = document.getElementById('popup-closer');
var header = document.getElementById('popup-header');

/**
 * 在地图容器中创建一个Overlay
 */
var popup = new ol.Overlay(/** @type {olx.OverlayOptions} */({
    element: container,
    autoPan: true,
    offset: [20, 20],
    positioning: 'center-center',
    stopEvent: false,
    autoPanAnimation: {
        duration: 250
    }
}));
map.addOverlay(popup);

/**
 * 添加关闭按钮的单击事件（隐藏popup）
 * @return {boolean} Don't follow the href.
 */
closer.onclick = function () {
    popup.setPosition(undefined);  //未定义popup位置
    closer.blur(); //失去焦点
    return false;
};


/**
 * 为map添加点击事件监听，渲染弹出popup
 */
map.on('singleclick', function (evt) {

    addIcon(evt.coordinate, objType);

    if (plotDraw.isDrawing()) {
        return;
    }



    var feature = map.forEachFeatureAtPixel(evt.pixel, function (feature, layer) {
        return feature;
    });



    if (feature) {
        var id = feature.get("id");
        var type = feature.get("type");
        switch (type) {
            case 'department':
                $.post(BASE_URL + '/map/locateDepartment.action', {id: id}, function (data) {
                    /**
                     * 为标注弹出popup
                     * @type {ol.Coordinate}
                     */
                    var featuerInfo = {
                        geo: [data.lng, data.lat],
                        att: {
                            parentDepartment: '所属单位：' + data.parentDepartment,
                            name: '名称：  ' + (data.name == null ? "未配置" : data.name),
                            addr: '地址： ' + data.addr,
                            phone: '电话： ' + data.phone,
                            tax: '传真： ' + data.tax,
                            leaderName: '负责人： ' + data.leaderName,
                            remark: data.remark
                        }
                    };
                    content.innerHTML = ''; //清空popup的内容容器
                    addFeatrueInfo(featuerInfo, "department"); //在popup中加载当前要素的具体信息
                    // if (popup.getPosition() == undefined) {
                    //     popup.setPosition(featuerInfo.geo); //设置popup的位置
                    // }
                    popup.setPosition(featuerInfo.geo); //设置popup的位置

                });
                break;
            case 'camera':
                $.post(BASE_URL + '/map/locateCamera.action', {id: id}, function (data) {
                    /**
                     * 为标注弹出popup
                     * @type {ol.Coordinate}
                     */
                    var featuerInfo = {
                        geo: [data.longitude, data.latitude],
                        att: {
                            name: '镜头名称：' + data.name,
                            address: '安装位置： ' + (data.address == null ? "未配置" : data.address),
                            finishtime: '竣工时间： ' + data.finishtime,
                            objtype: '镜头类型： ' + data.cameraType,
                            userunit: '使用单位： ' + data.userunit,
                            managerunit: '管理单位： ' + data.managerunit,
                            status: '设施状态： ' + data.cameraStatus,
                            remark: data.remark
                        }
                    };
                    content.innerHTML = ''; //清空popup的内容容器
                    addFeatrueInfo(featuerInfo, "camera"); //在popup中加载当前要素的具体信息
                    // if (popup.getPosition() == undefined) {
                    //     popup.setPosition(featuerInfo.geo); //设置popup的位置
                    // }
                    popup.setPosition(featuerInfo.geo); //设置popup的位置
                });
                break;
            case 'facility':
                $.post(BASE_URL + '/map/locateFacility.action', {id: id}, function (data) {
                    /**
                     * 为标注弹出popup
                     * @type {ol.Coordinate}
                     */
                    var featuerInfo = {
                        geo: [data.longitude, data.latitude],
                        att: {
                            name: '设施名称：' + data.name,
                            address: '建设地段： ' + (data.address == null ? "未配置" : data.address),
                            objtype: '项目类别： ' + data.objtype,
                            childtype: '设施类型： ' + data.childtype,
                            finishTime: '竣工时间： ' + data.finishtime,
                            managerUnit: '管理单位： ' + data.managerunit,
                            status: '设施状态： ' + data.status,
                            invest: '投资金额： ' + data.invest,
                            remark: data.remark
                        }
                    };

                    content.innerHTML = ''; //清空popup的内容容器
                    addFeatrueInfo(featuerInfo, "facility"); //在popup中加载当前要素的具体信息
                    // if (popup.getPosition() == undefined) {
                    //     popup.setPosition(featuerInfo.geo); //设置popup的位置
                    // }
                    popup.setPosition(featuerInfo.geo); //设置popup的位置
                });
                break;
            // case 'military_pic':
            //     /**
            //      * @author zc
            //      * @function 更改军标标绘名称
            //      */
            //     $.ligerDialog.prompt('请输入名称', true, function (yes, symbolName) {
            //         if (yes) {
            //             //实现自己的业务逻辑
            //             feature.getStyle().getText().setText(symbolName);
            //             feature.setStyle(feature.getStyle());
            //         }
            //     });
            //     break;
            case 'military_vector':
                plotEdit.activate(feature);
                // activeDelBtn();
                plotVectorAction='deactivate';
                break;
            default:
                // if (plotVectorAction === 'activate') {
                //     // 开始编辑
                //     plotEdit.activate(feature);
                //     activeDelBtn();
                //     plotVectorAction='deactivate';
                // }

        }
    } else {
        // 结束编辑
        plotEdit.deactivate();
        // deactiveDelBtn();
    }
});


/**
 * 动态创建popup的具体内容
 * @param {string} title
 */
function addFeatrueInfo(info, type) {

    switch (type) {
        case 'department':
            //新增li标签
            var departmentparentDepartment = document.createElement('li');
            setInnerText(departmentparentDepartment, info.att.parentDepartment);
            content.appendChild(departmentparentDepartment);

            var departmentname = document.createElement('li');
            departmentname.className = "indentTwoem";
            setInnerText(departmentname, info.att.name);
            content.appendChild(departmentname);

            var departmentaddr = document.createElement('li');
            departmentaddr.className = "indentTwoem";
            setInnerText(departmentaddr, info.att.addr);
            content.appendChild(departmentaddr);


            var departmentphone = document.createElement('li');
            setInnerText(departmentphone, info.att.phone);
            departmentphone.className = "indentTwoem";
            content.appendChild(departmentphone);

            var departmenttax = document.createElement('li');
            departmenttax.className = "indentTwoem";
            setInnerText(departmenttax, info.att.tax);
            content.appendChild(departmenttax);

            var departmentleaderName = document.createElement('li');
            setInnerText(departmentleaderName, info.att.leaderName);
            departmentleaderName.className = "indentOneem";
            content.appendChild(departmentleaderName);

            var departmentRemark = document.createElement('li');
            departmentRemark.innerText = '备注信息： ';
            var departmentTextarea = document.createElement('div');
            departmentTextarea.className = "textarea";
            // departmentTextarea.readOnly = true;
            setInnerText(departmentTextarea, info.att.remark);
            departmentRemark.appendChild(departmentTextarea);
            content.appendChild(departmentRemark);
            break;
        case 'camera':
            //新增li标签
            var cameraName = document.createElement('li');
            setInnerText(cameraName, info.att.name);
            content.appendChild(cameraName);

            var cameraAddress = document.createElement('li');
            setInnerText(cameraAddress, info.att.address);
            content.appendChild(cameraAddress);

            var cameraFinishTime = document.createElement('li');
            setInnerText(cameraFinishTime, info.att.finishtime);
            content.appendChild(cameraFinishTime);

            var cameraObjType = document.createElement('li');
            setInnerText(cameraObjType, info.att.objtype);
            content.appendChild(cameraObjType);

            var cameraUserUnit = document.createElement('li');
            setInnerText(cameraUserUnit, info.att.userunit);
            content.appendChild(cameraUserUnit);

            var cameraManagerUnit = document.createElement('li');
            setInnerText(cameraManagerUnit, info.att.managerunit);
            content.appendChild(cameraManagerUnit);

            var cameraStatus = document.createElement('li');
            setInnerText(cameraStatus, info.att.status);
            content.appendChild(cameraStatus);

            var cameraRemark = document.createElement('li');
            cameraRemark.innerText = '备注信息： ';
            // var cameraTextarea = document.createElement('textarea');
            var cameraTextarea = document.createElement('div');
            cameraTextarea.className = "textarea";
            // cameraTextarea.readOnly = true;
            setInnerText(cameraTextarea, info.att.remark);
            cameraRemark.appendChild(cameraTextarea);
            content.appendChild(cameraRemark);
            break;
        case 'facility':
            //新增li标签
            var nameli = document.createElement('li');
            setInnerText(nameli, info.att.name);
            content.appendChild(nameli);

            var addressli = document.createElement('li');
            setInnerText(addressli, info.att.address);
            content.appendChild(addressli);

            var objtypeli = document.createElement('li');
            setInnerText(objtypeli, info.att.objtype);
            content.appendChild(objtypeli);

            var childtypeli = document.createElement('li');
            setInnerText(childtypeli, info.att.childtype);
            content.appendChild(childtypeli);

            var finishTimeli = document.createElement('li');
            setInnerText(finishTimeli, info.att.finishTime);
            content.appendChild(finishTimeli);

            var managerUnitli = document.createElement('li');
            setInnerText(managerUnitli, info.att.managerUnit);
            content.appendChild(managerUnitli);

            var statusli = document.createElement('li');
            setInnerText(statusli, info.att.status);
            content.appendChild(statusli);

            var investli = document.createElement('li');
            setInnerText(investli, info.att.invest);
            content.appendChild(investli);

            // var picli = document.createElement('img');
            // picli.src="../images/p07.jpg";
            // picli.className="myViewer";
            // picli.style.width='20px';
            // picli.style.height='20px';
            // // setInnerText(investli, info.att.invest);
            // content.appendChild(picli);
            // $('.myViewer').viewer();
            //
            //
            // var videoli = document.createElement('img');
            // picli.src="../images/p07.jpg";
            // picli.className="myViewer";
            // picli.style.width='20px';
            // picli.style.height='20px';
            // // setInnerText(investli, info.att.invest);
            // content.appendChild(videoli);

            var remarkli = document.createElement('li');
            remarkli.innerText = '备注信息： ';
            // var remarkTextarea = document.createElement('textarea');
            var remarkTextarea = document.createElement('div');
            // remarkTextarea.className = "popupTextarea";
            remarkTextarea.className = "textarea";
            // remarkTextarea.readOnly = true;
            setInnerText(remarkTextarea, info.att.remark);
            remarkli.appendChild(remarkTextarea);
            content.appendChild(remarkli);
            break;
    }


    // //新增a元素;
    // var elementA = document.createElement('a');
    // elementA.className = "markerInfo";
    // elementA.href = info.att.titleURL;
    // //elementA.innerText = info.att.title;
    // setInnerText(elementA, info.att.title);
    // content.appendChild(elementA); // 新建的div元素添加a子节点

    //
    // //新增img元素
    // var elementImg = document.createElement('img');
    // elementImg.className = "markerImg";
    // elementImg.src = info.att.imgURL;
    // content.appendChild(elementImg); // 为content添加img子节点
}

/**
 * 动态设置元素文本内容（兼容）
 * zc 可能是为了兼容不同浏览器
 */
function setInnerText(element, text) {
    if (typeof element.textContent === "string") {
        element.textContent = text;
    } else {
        element.innerText = text;
    }
}


/**
 * 为map添加鼠标移动事件监听，当指向标注时改变鼠标光标状态
 */
map.on('pointermove', function (e) {
    var pixel = map.getEventPixel(e.originalEvent);
    var hit = map.hasFeatureAtPixel(pixel);
    map.getTargetElement().style.cursor = hit ? 'pointer' : 'default';
});


/**
 * 增加鼠标右键菜单
 */
function  test() {
    alert("hello world");
}
$(map.getViewport()).on("contextmenu", function(evt){

    evt.preventDefault();//@author zc 阻止系统右键菜单
    var coordinate = map.getEventCoordinate(evt);//获取鼠标坐标
    var pixel = map.getEventPixel(evt.originalEvent);//获取鼠标当前像素点
    var feature = map.forEachFeatureAtPixel(pixel, function (feature, layer) {
        return feature;
    });

    header.innerHTML = '';
    content.innerHTML = '';
    var menuUL, menuListToCenter;
    if (feature) {

        if (feature.get('type') === 'department' || feature.get('type') === 'camera' ||feature.get('type') === 'facility' ||feature.get('type') === 'military_pic') {
            menuUL = document.createElement('ul');
            menuUL.className = 'contextmenuUL';
            var menuListDel = document.createElement('li');
            var menuListDelA = document.createElement('a');
            menuListDelA.onclick = function(){
                deleteFeature(feature);
            };
            menuListDelA.href = 'javascript:void(0)';
            menuListDelA.innerHTML = '删除';
            menuListDel.appendChild(menuListDelA);

            var menuListRename = document.createElement('li');
            var menuListRenameA = document.createElement('a');
            menuListRenameA.onclick = function(){
                renameFeature(feature);
            };
            menuListRenameA.href = 'javascript:void(0)';
            menuListRenameA.innerHTML = '重命名';
            menuListRename.appendChild(menuListRenameA);

            menuUL.appendChild(menuListDel);
            menuUL.appendChild(menuListRename);
            content.appendChild(menuUL);
            popup.setPositioning('top-left');
            popup.setOffset([0,36]);
            popup.setPosition(feature.get('coordinate'));
        } else if (feature.get('type') === 'military_vector') {
            menuUL = document.createElement('ul');
            menuUL.className = 'contextmenuUL';
            var menuListDel = document.createElement('li');
            var menuListDelA = document.createElement('a');
            menuListDelA.onclick = function(){
                deleteFeature(feature);
            };
            menuListDelA.href = 'javascript:void(0)';
            menuListDelA.innerHTML = '删除';
            menuListDel.appendChild(menuListDelA);

            menuUL.appendChild(menuListDel);
            content.appendChild(menuUL);
            popup.setOffset([0,0]);
            popup.setPosition(coordinate);
        }
    } else {
        menuUL = document.createElement('ul');
        menuUL.className = 'contextmenuUL';

        var menuListZoomOut = document.createElement('li');
        var menuListZoomOutA = document.createElement('a');
        menuListZoomOutA.onclick = function(){
            var view = map.getView();
            view.animate({
                zoom: view.getZoom() + 1,
                duration: 250
            })
        };
        menuListZoomOutA.href = 'javascript:void(0)';
        menuListZoomOutA.innerHTML = '放大';
        menuListZoomOut.appendChild(menuListZoomOutA);
        menuUL.appendChild(menuListZoomOut);

        var menuListZoomIn = document.createElement('li');
        var menuListZoomInA = document.createElement('a');
        menuListZoomInA.onclick = function(){
            var view = map.getView();
            view.animate({
                zoom: view.getZoom() - 1,
                duration: 250
            })
        };
        menuListZoomInA.href = 'javascript:void(0)';
        menuListZoomInA.innerHTML = '缩小';
        menuListZoomIn.appendChild(menuListZoomInA);
        menuUL.appendChild(menuListZoomIn);

        menuListToCenter = document.createElement('li');
        var menuListToCenterA = document.createElement('a');
        menuListToCenterA.onclick = function(){

            var view = map.getView();
            // 设置地图中心为芒市的坐标，即可让地图移动到芒市
            view.setCenter(coordinate);
            view.setZoom(14);
            map.render();
        };
        menuListToCenterA.href = 'javascript:void(0)';
        menuListToCenterA.innerHTML = '以该点居中地图';
        menuListToCenter.appendChild(menuListToCenterA);
        menuUL.appendChild(menuListToCenter);

        content.appendChild(menuUL);
        popup.setOffset([0,0]);
        popup.setPosition(coordinate);
    }

});

function renameFeature(feature) {
    $.ligerDialog.prompt('请输入名称', true, function (yes, symbolName) {
        if (yes) {
            //实现自己的业务逻辑
            feature.getStyle().getText().setText(symbolName);
            feature.setStyle(feature.getStyle());
        }
    });
}

function deleteFeature(feature){
  $.ligerDialog.confirm('确定删除元素吗？', function (flag) {
                    /**
                     * @author zc
                     * @function 删除单个feature
                     */
                    if (flag) {
                        if (feature.get('type') ==='military_pic' || feature.get('type') === 'department' || feature.get('type') === 'facility' || feature.get('type') === 'camera') {
                            layer.getSource().removeFeature(feature);
                        } else {
                            drawOverlay.getSource().removeFeature(feature);
                            deactiveDelBtn();
                            plotEdit.deactivate();
                        }
                    }
                });
}

$(map.getViewport()).on("click", function(e){
    e.preventDefault();
   popup.setPosition(undefined);
});


function locateFacility(id) {
    $.post(BASE_URL + '/map/locateFacility.action', {id: id}, function (data) {
        //移动到feature所在位置
            moveToFeature([data.longitude, data.latitude]);
            // 创建一个Feature，并设置好在地图上的位置
            var anchor = new ol.Feature({
                geometry: new ol.geom.Point([data.longitude, data.latitude]),
                id: data.id,
                type: 'facility',
                coordinate : [data.longitude, data.latitude]
            });
            // 设置样式，在样式中就可以设置图标
                anchor.setStyle(new ol.style.Style({
                image: new ol.style.Icon({
                    src: '../images/map/department/department.png'
                }),
                text: new ol.style.Text({
                    textAlign: 'center', //位置
                    offsetY: 24,
                    textBaseline: 'middle', //基准线
                    font: 'normal 14px 微软雅黑',  //文字样式
                    text: data.name,  //文本内容
                    fill: new ol.style.Fill({color: '#aa3300'}), //文本填充样式（即文字颜色）
                    stroke: new ol.style.Stroke({color: '#ffcc33', width: 2})
                })
            }));
            // 添加到之前的创建的layer中去
            layer.getSource().addFeature(anchor);
            // map.addLayer(layer);
        }
    )
}

function locateCamera(id) {
    $.post(BASE_URL + '/map/locateCamera.action', {id: id}, function (data) {
            //移动到feature要素所在位置
            moveToFeature([data.longitude, data.latitude]);
            var cameraType = "";
            if (data.cameraType === "枪机") {
                cameraType = '../images/map/camera/gunCamera.png';
            } else if (data.cameraType === "球机") {
                cameraType = '../images/map/camera/ballCamera.png';
            } else {
                cameraType = '../images/map/camera/bigBallCamera';
            }
            // 创建一个Feature，并设置好在地图上的位置
            var anchor = new ol.Feature({
                geometry: new ol.geom.Point([data.longitude, data.latitude]),
                id: data.id,
                type: 'camera',
                coordinate: [data.longitude, data.latitude]
            });
            // 设置样式，在样式中就可以设置图标
            anchor.setStyle(new ol.style.Style({
                image: new ol.style.Icon({
                    src: cameraType
                }),
                text: new ol.style.Text({
                    textAlign: 'center', //位置
                    offsetY: 24,
                    textBaseline: 'middle', //基准线
                    font: 'normal 14px 微软雅黑',  //文字样式
                    text: data.name,  //文本内容
                    fill: new ol.style.Fill({color: '#aa3300'}), //文本填充样式（即文字颜色）
                    stroke: new ol.style.Stroke({color: '#ffcc33', width: 2})
                })

            }));
            // 添加到之前的创建的layer中去
            layer.getSource().addFeature(anchor);
        }
    )
}

map.on('dblclick', function (evt) {
    var feature = map.forEachFeatureAtPixel(evt.pixel, function (feature, layer) {
        return feature;
    });
    if (feature) {
        var type = feature.get('type');
        switch (type) {
            // case 'military_pic':
            //     $.ligerDialog.confirm('确定删除元素吗？', function (flag) {
            //         /**
            //          * @author zc
            //          * @function 删除单个feature
            //          */
            //         if (flag) {
            //             layer.getSource().removeFeature(feature);
            //         }
            //     });
            //     break;
            case 'department':
                sendCommand('call_tel', feature.get('phone'))
                break;
            case 'camera':
                sendCommand('play_video', feature.get('id'))
                break;
        }
    }
});

function sendCommand(commandType, commandParam) {

    $.post(BASE_URL + '/map/sendCommand.action', {commandType: commandType,commandParam:commandParam }, function (data) {
            // alert("消息发送成功");
        console.log("消息发送成功")
    });
}

function displayLayer(id) {
    $.post(BASE_URL + '/map/displayLayer.action', {id: id}, function (data) {

        // var temwkt ="POLYGON((98.57849887047745 24.440809887661608,98.59123862387986 24.43857666193879,98.59135350583394 24.439948416373255,98.59469220320423 24.436002683117458,98.59074646994844 24.43266398574717,98.59086022158287 24.43403583437494,98.57792655155602 24.433942060604558))";
        var format = new ol.format.WKT();
        var wktTextArray = data.wktText.split(';');
        for (var i=0;i<wktTextArray.length-1;i++) {
            var militaryFeature = format.readFeature(wktTextArray[i]);
            militaryFeature.set('type','military_vector');
            drawOverlay.getSource().addFeature(militaryFeature);
        }

        var picSrcArray = data.picSrc.split(';');
        var picTextArray = data.picText.split(';');
        var coordinateArray = data.coordinate.split(';');
        var offsetYArray = data.offsetY.split(';');

        for (i=0; i<picSrcArray.length;i++) {
            //添加feature
            var picFeature = new ol.Feature({
                geometry: new ol.geom.Point(eval(coordinateArray[i])),
                type: 'military_pic',
                coordinate : eval(coordinateArray[i])
            });


            picFeature.setStyle(new ol.style.Style({
                image: new ol.style.Icon({
                    src: picSrcArray[i],
                    scale: map.getView().getZoom() / 14
                }),
                text: new ol.style.Text({
                    textAlign: 'center', //位置
                    offsetY: offsetYArray[i],
                    textBaseline: 'middle', //基准线
                    font: 'normal 14px 微软雅黑',  //文字样式
                    text: picTextArray[i],  //文本内容
                    fill: new ol.style.Fill({color: '#aa3300'}), //文本填充样式（即文字颜色）
                    stroke: new ol.style.Stroke({color: '#ffcc33', width: 2})
                })
            }));
            layer.getSource().addFeature(picFeature);
        }
    });
}