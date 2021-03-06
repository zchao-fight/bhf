<%--
  Created by IntelliJ IDEA.
  User: zc
  Date: 2017/10/17
  Time: 21:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv=Content-Type content="text/html;charset=utf-8">
    <meta http-equiv=X-UA-Compatible content="IE=edge,chrome=1">
    <meta content=always name=referrer>
    <title>德宏州党政军警民联防平台综合态势</title>
    <link href="${ctx}/css/ol.css" rel="stylesheet" type="text/css"/>
    <link href="${ctx}/css/ligerui-dialog.css" rel="stylesheet" type="text/css"/>

    <link rel="stylesheet" href="${ctx}/css/bootstrap.css" type="text/css">
    <link rel="stylesheet" href="${ctx}/css/jquery.dataTables.min.css" type="text/css">
    <link rel="stylesheet" href="${ctx}/css/panel.css" type="text/css">
    <link rel="stylesheet" href="${ctx}/css/measuretool.css" type="text/css">
    <link rel="stylesheet" href="${ctx}/css/p-ol3.min.css" type="text/css">
    <link rel="stylesheet" href="${ctx}/css/defaults.css" type="text/css">
    <link rel="stylesheet" href="${ctx}/css/viewer.css" type="text/css">
    <link rel="stylesheet" href="${ctx}/css/custom.css" type="text/css">
    <link rel="stylesheet" href="${ctx}/css/jquery.mCustomScrollbar.css" type="text/css">
    <link rel="stylesheet" href="${ctx}/css/zTreeStyle.css" type="text/css">
    <link rel="stylesheet" href="${ctx}/css/bootstrap-select.min.css" type="text/css">
    <script type="text/javascript" src="${ctx}/js/jquery.min.js" charset="UTF-8"></script>
    <script type="text/javascript" src="${ctx}/js/My97DatePicker/WdatePicker.js" charset="UTF-8"></script>
    <script type="text/javascript" src="${ctx}/js/ligerui.min.js" charset="UTF-8"></script>
    <script type="text/javascript" src="${ctx}/js/niuniucapture.js" charset="UTF-8"></script>
    <script type="text/javascript" src="${ctx}/js/capturewrapper.js" charset="UTF-8"></script>
    <script type="text/javascript" src="${ctx}/js/bootstrap.js" charset="UTF-8"></script>
    <script type="text/javascript" src="${ctx}/js/ol-debug.js" charset="utf-8"></script>
    <script type="text/javascript" src="${ctx}/js/FileSaver.min.js" charset="utf-8"></script>
    <script type="text/javascript" src="${ctx}/js/measuretool.js" charset="UTF-8"></script>
    <script type="text/javascript" src="${ctx}/js/p-ol3.min.js" charset="UTF-8"></script>
    <script type="text/javascript" src="${ctx}/js/init.js" charset="UTF-8"></script>
    <script type="text/javascript" src="${ctx}/js/viewer.js" charset="UTF-8"></script>
    <script type="text/javascript" src="${ctx}/js/jquery.ztree.all-3.5.min.js" charset="UTF-8"></script>
    <script type="text/javascript" src="${ctx}/js/jquery.SuperSlide.js" charset="UTF-8"></script>
    <script type="text/javascript" src="${ctx}/js/echarts.js"></script>
    <script type="text/javascript" src="${ctx}/js/map/jquery.mousewheel.min.js"></script>
    <script type="text/javascript" src="${ctx}/js/map/jquery.mCustomScrollbar.min.js"></script>
    <script type="text/javascript" src="${ctx}/js/map/jquery.nicescroll.min.js"></script>
    <script type="text/javascript" src="${ctx}/js/jquery.dataTables.min.js"></script>
    <script type="text/javascript" src="${ctx}/js/bootstrap-select.min.js"></script>
    <script type="text/javascript" src="${ctx}/js/drag.js"></script>
    <script type="text/javascript" src="${ctx}/js/ue/ueditor.config.js"></script>
    <script type="text/javascript" src="${ctx}/js/ue/ueditor.all.js"></script>
    <script type="text/javascript" charset="utf-8" src="${ctx}/js/ue/lang/zh-cn/zh-cn.js"></script>
    <style>


        ._mCS_1 .mCSB_scrollTools .mCSB_dragger .mCSB_dragger_bar {
            background: #09c;
        }

        /*给第一个滚动条加样式*/

    </style>

</head>
<script>


    (function ($) {
        $(window).load(function () {
            $(".ztree").mCustomScrollbar({scrollInertia: 500, mouseWheelPixels: 100});
        });
    })(jQuery);
</script>


<%--树形--%>
<script>
    $(function () {
        initStatistics('eventType');
        initStatistics('eventNum');
        initStatistics('eventProp');
        initStatistics('eventRegion');
    });
    $(document).ready(function () {

        getVideoTree();
        getResourceTree();
        getComprehensiveAnalysis();

        //
        function ml_close_demo() {
            $('.float-news').animate({
                left: '-450px'
            }, 300, function () {
                $('.float-open').delay(50).animate({
                    left: '-2px'
                }, 300);
            });
        }

        function ml_open_demo() {
            $('.float-open').animate({
                left: '-70px'
            }, 100, function () {
                $('.float-news').delay(50).animate({
                    left: '0px'
                }, 300);
            });
        }

        $('.float-close').click(function () {
            ml_close_demo();
            $('#resultDetails').hide();
            return false;
        });
        $('.open-btn').click(function () {
            ml_open_demo();
            return false;
        });

        // setTimeout(function(){ml_close_demo()},5000);

        $('.shrinkToRight').click(function () {
            $('.float-right-open').animate({
                right: '0px'
            }, 100, function () {
                $('#right-panel').delay(50).animate({
                    right: '-260px'
                }, 300);
            });
        });
    });


</script>

<%--增加鼠标响应事件
@author zc
--%>
<body onkeydown="if (event.keyCode!==13){}else showResult();" onbeforeunload="close()">

<%--左侧菜单--%>
<div class="float-open" id="float-open" style="left:-2px;">
    <a class="open-btn" href="javascript:void(0);">
    </a>
</div>
<div class="float-news" id="float-news" style="left:-450px;">
    <!-- <a class="float-close" href="javascript:void(0);">X</a> -->
    <a class="float-close" href="javascript:void(0);">
        &nbsp; &nbsp; &nbsp;
    </a>
    <div class="newslist">
        <div class="hp-tab-newprd">
            <ul class="j-sw-nav">
                <li class="newprd-s1">
                    <a style="padding-left: 30px;padding-right:10px;">
                        视频监控
                    </a>
                </li>
                <li class="newprd-s2">
                    <a style="padding-right:30px;padding-left:30px;">
                        综合资源
                    </a>
                </li>
            </ul>
            <div class="newprd-clip">
                <div class="tempWrap" style="position:relative; width:220px;">
                    <div class="j-sw-c"
                         style="width:220px; position: relative; padding: 0px; margin: 0px; left: -450px;">
                        <ul class="ztree" id="videoTree"
                            style="float: left; width: 220px;overflow-y:auto;overflow-x:hidden;height: 335px">
                        </ul>
                        <ul class="ztree" id="resourceTree"
                            style="float: left; width: 220px;overflow-y:auto;overflow-x:hidden;height: 335px">
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <a class="float-close" href="javascript:void(0);">
            &nbsp; &nbsp; &nbsp;
        </a>
        <div class="hp-tab-newprd">
            <ul class="j-sw-nav">
                <li class="newprd-s1">
                    <a style="padding-bottom:5px;padding-left: 30px;padding-right:10px;">
                        通讯录
                    </a>
                </li>
                <li class="newprd-s2">
                    <a style="padding-bottom:5px;padding-right:30px;padding-left:30px">
                        综合研判
                    </a>
                </li>
            </ul>
            <div class="newprd-clip">
                <div class="tempWrap" style="overflow:hidden; position:relative; width:250px">
                    <div class="j-sw-c"
                         style=" position: relative; overflow: hidden; padding: 0px; margin: 0px; left: -5640px;">
                        <ul class="address_book" style="float: left; width: 230px;font-size: 12px;color:white">
                            <table style="width:240px;" id="contact">
                                <thead>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                </thead>
                                <c:if test="${!empty contact}">
                                    <c:forEach items="${contact}" var="item">
                                        <tr>
                                            <td style="width:25%;">${item.name}</td>
                                            <td style="width:30%;">${item.phone}</td>
                                            <td style="width:15%;"><a><img src="${ctx}/images/map/left_menu/phone.png"></a>
                                            </td>
                                            <td style="width:15%;"><a><img
                                                    src="${ctx}/images/map/left_menu/message.png"></a></td>
                                            <td style="width:15%;">&nbsp;&nbsp;<a><img
                                                    src="${ctx}/images/map/left_menu/chat.png"></a></td>
                                        </tr>
                                    </c:forEach>
                                </c:if>
                            </table>
                            <script>
                                //新加的
                                $(document).ready(function () {
                                    $('#contact').DataTable({
                                        "lengthChange": false,
                                        "iDisplayLength": 8,
                                        "searching": false,
                                        "pagingType": "simple",
                                        "oLanguage": { // 国际化配置
                                            "sProcessing": "正在获取数据，请稍后...",
                                            "sLengthMenu": "显示 _MENU_ 条",
                                            "sZeroRecords": "没有找到数据",
                                            "sInfo": "",
                                            "sInfoEmpty": "记录数为0",
                                            "sInfoFiltered": "",
                                            "sInfoPostFix": "",
                                            "sSearch": "查询",
                                            "sUrl": "",
                                            "oPaginate": {
                                                "sFirst": "第一页",
                                                "sPrevious": "上一页",
                                                "sNext": "下一页",
                                                "sLast": "最后一页"
                                            }
                                        }

                                    });
                                });


                            </script>
                        </ul>
                        <ul id="comprehensiveAnalysis" class="ztree"
                            style="float: left; width: 240px;margin-left:10px;overflow-y:auto;overflow-x:hidden;height: 335px">

                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <script type="text/javascript">
            jQuery(".hp-tab-newprd").slide({
                titCell: ".j-sw-nav li",
                mainCell: ".j-sw-c",
                effect: "left",
                easing: "easeInOutSine",
                delayTime: 500
            });
        </script>
    </div>
</div>

<div id="map"></div>
<div id="filling_header"></div>

<div id="globleSearch">
    <div style="width: 300px; position: relative; ">
        <input id="searchKeyword" name="keyword" placeholder="请输入搜索内容">
        <button id="searchButton" onclick="showResult()" style="padding:0;"><img src="${ctx}/images/search.png">
        </button>
    </div>
</div>


<div id="searchResult">
    <p>
        <span id="totalNum"
              style="font-style:italic;font-weight: 300;font-size: 15px;color:#4AD5FC;padding-left:10px;margin: 20px 0;display: block;"></span>
        <a class="ol-popup-closer" style="float: right;margin-right:10px;" onclick="hideSearchResult()">
        </a>
    </p>

    <div class="panel-group" id="accordion">
        <div class="panel panel-default panel-whole1">
            <div class="panel-heading">
                <h4 class="panel-title" style="color:#4AD5FC;">
                    &nbsp;&nbsp;单位
                    <a data-toggle="collapse" data-parent="#accordion"
                       href="#collapseOne" title="展开">

                        <span class="totalResultNumbers"
                              style="float: right; margin-right: 30px;font-size: 20px;color: #4AD5FC">+</span>
                    </a>


                </h4>
            </div>
            <div id="collapseOne" class="panel-collapse collapse">
                <div class="panel-body">
                    <ul id="departmentResult">

                    </ul>
                </div>
            </div>
        </div>


        <div class="panel panel-default panel-whole2">
            <div class="panel-heading">
                <h4 class="panel-title" style="color:#4AD5FC;">
                    &nbsp;&nbsp;镜头
                    <a data-toggle="collapse" data-parent="#accordion"
                       href="#collapseTwo" title="展开">
                         <span class="totalResultNumbers"
                               style="float: right; margin-right: 30px;font-size: 20px;color: #4AD5FC">+</span>
                    </a>
                </h4>
            </div>
            <div id="collapseTwo" class="panel-collapse collapse">
                <div class="panel-body">
                    <ul id="cameraResult">

                    </ul>
                </div>
            </div>
        </div>
        <div class="panel panel-success panel-whole3">
            <div class="panel-heading">
                <h4 class="panel-title" style="color:#4AD5FC;">
                    &nbsp;&nbsp;设施
                    <a data-toggle="collapse" data-parent="#accordion"
                       href="#collapseThree" title="展开">
                        <span class="totalResultNumbers"
                              style="float: right; margin-right: 30px;font-size: 20px;color: #4AD5FC">+</span>
                    </a>

                </h4>
            </div>
            <div id="collapseThree" class="panel-collapse collapse">
                <div class="panel-body">
                    <ul id="facilityResult">

                    </ul>
                </div>
            </div>
        </div>
        <%--<div class="panel panel-success">--%>
        <%--<div class="panel-heading">--%>
        <%--<h4 class="panel-title">--%>
        <%--<a data-toggle="collapse" data-parent="#accordion"--%>
        <%--href="#collapseFour">--%>
        <%--界碑搜索结果如下--%>
        <%--</a>--%>
        <%--</h4>--%>
        <%--</div>--%>
        <%--<div id="collapseFour" class="panel-collapse collapse">--%>
        <%--<div class="panel-body">--%>
        <%--<ul id="boundaryResult">--%>

        <%--</ul>--%>
        <%--</div>--%>
        <%--</div>--%>
        <%--</div>--%>
        <%--<div class="panel panel-success">--%>
        <%--<div class="panel-heading">--%>
        <%--<h4 class="panel-title">--%>
        <%--<a data-toggle="collapse" data-parent="#accordion"--%>
        <%--href="#collapseFive">--%>
        <%--国门搜索结果如下--%>
        <%--</a>--%>
        <%--</h4>--%>
        <%--</div>--%>
        <%--<div id="collapseFive" class="panel-collapse collapse">--%>
        <%--<div class="panel-body">--%>
        <%--<ul id="gateResult">--%>

        <%--</ul>--%>
        <%--</div>--%>
        <%--</div>--%>
        <%--</div>--%>
        <div class="panel panel-success panel-whole4">
            <div class="panel-heading">
                <h4 class="panel-title" style="color:#4AD5FC;">
                    &nbsp;&nbsp;装备
                    <a data-toggle="collapse" data-parent="#accordion"
                       href="#collapseSix" title="展开">
                        <span class="totalResultNumbers"
                              style="float: right; margin-right: 30px;font-size: 14px;color: #4AD5FC">+</span>
                    </a>

                </h4>
            </div>
            <div id="collapseSix" class="panel-collapse collapse">
                <div class="panel-body">
                    <ul id="equipmentResult">

                    </ul>
                </div>
            </div>
        </div>
        <div class="panel panel-success panel-whole5">
            <div class="panel-heading">
                <h4 class="panel-title" style="color:#4AD5FC;">
                    &nbsp;&nbsp;预案
                    <a data-toggle="collapse" data-parent="#accordion"
                       href="#collapseSeven" title="展开">
                        <span class="totalResultNumbers"
                              style="float: right; margin-right: 30px;font-size: 20px;color: #4AD5FC">+</span>
                    </a>

                </h4>
            </div>
            <div id="collapseSeven" class="panel-collapse collapse">
                <div class="panel-body">
                    <ul id="preplanResult">

                    </ul>
                </div>
            </div>
        </div>
        <div class="panel panel-success panel-whole6">
            <div class="panel-heading">
                <h4 class="panel-title" style="color:#4AD5FC;">
                    &nbsp;&nbsp;案例
                    <a data-toggle="collapse" data-parent="#accordion"
                       href="#collapseEight" title="展开">
                        <span class="totalResultNumbers"
                              style="float: right; margin-right: 30px;font-size: 20px;color: #4AD5FC">+</span>
                    </a>

                </h4>
            </div>
            <div id="collapseEight" class="panel-collapse collapse">
                <div class="panel-body">
                    <ul id="caseResult">

                    </ul>
                </div>
            </div>
        </div>
        <div class="panel panel-success panel-whole7">
            <div class="panel-heading">
                <h4 class="panel-title" style="color:#4AD5FC;">
                    &nbsp;&nbsp;专家
                    <a data-toggle="collapse" data-parent="#accordion"
                       href="#collapseNine" title="展开">
                        <span class="totalResultNumbers"
                              style="float: right; margin-right: 30px;font-size: 20px;color: #4AD5FC">+</span>
                    </a>

                </h4>
            </div>
            <div id="collapseNine" class="panel-collapse collapse">
                <div class="panel-body">
                    <ul id="professorResult">

                    </ul>
                </div>
            </div>
        </div>
        <div class="panel panel-info panel-whole8">
            <div class="panel-heading">
                <h4 class="panel-title" style="color:#4AD5FC;">
                    &nbsp;&nbsp;法规
                    <a data-toggle="collapse" data-parent="#accordion"
                       href="#collapseTen" title="展开">
                        <span class="totalResultNumbers"
                              style="float: right; margin-right: 30px;font-size: 20px;color: #4AD5FC">+</span>
                    </a>

                </h4>
            </div>
            <div id="collapseTen" class="panel-collapse collapse">
                <div class="panel-body">
                    <ul id="lawResult">

                    </ul>
                </div>
            </div>
        </div>
        <div class="panel panel-warning panel-whole9">
            <div class="panel-heading">
                <h4 class="panel-title" style="color:#4AD5FC;">
                    &nbsp;&nbsp;事件
                    <a data-toggle="collapse" data-parent="#accordion"
                       href="#collapseEleven" title="展开">
                        <span class="totalResultNumbers"
                              style="float: right; margin-right: 30px;font-size: 20px;color: #4AD5FC">+</span>
                    </a>
                </h4>
            </div>
            <div id="collapseEleven" class="panel-collapse collapse">
                <div class="panel-body">
                    <ul id="eventResult">

                    </ul>
                </div>
            </div>
        </div>

        <div class="panel panel-warning panel-whole10">
            <div class="panel-heading">
                <h4 class="panel-title" style="color:#4AD5FC;">
                    &nbsp;&nbsp;图层
                    <a data-toggle="collapse" data-parent="#accordion"
                       href="#collapseTwelve" title="展开">
                        <span class="totalResultNumbers"
                              style="float: right; margin-right: 30px;font-size: 20px;color: #4AD5FC">+</span>
                    </a>
                </h4>
            </div>
            <div id="collapseTwelve" class="panel-collapse collapse">
                <div class="panel-body">
                    <ul id="military">

                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>
<div id="resultDetails" style="overflow: hidden">
    <ul>

    </ul>

</div>


<script type="text/javascript">
    //        $(function () { $('#collapseFour').collapse({
    //            toggle: false
    //        })});
    //        $(function () { $('#collapseTwo').collapse('show')});
    //        $(function () { $('#collapseThree').collapse('toggle')});
    //        $(function () { $('#collapseOne').collapse('hide')});
    $(function () {
        $('#collapseEleven').collapse('hide')
    });
    $(function () {
        $('#collapseTen').collapse('hide')
    });
    $(function () {
        $('#collapseNine').collapse('hide')
    });
    $(function () {
        $('#collapseEight').collapse('hide')
    });
    $(function () {
        $('#collapseSeven').collapse('hide')
    });
    $(function () {
        $('#collapseSix').collapse('hide')
    });
    $(function () {
        $('#collapseFive').collapse('hide')
    });
    $(function () {
        $('#collapseFour').collapse('hide')
    });
    $(function () {
        $('#collapseThree').collapse('hide')
    });
    $(function () {
        $('#collapseTwo').collapse('hide')
    });
    $(function () {
        $('#collapseOne').collapse('hide')
    });
</script>

<%--<style>--%>

<%--.nav > li:hover .dropdown-menu { display: block; }--%>
<%--</style>--%>

<%--<script>--%>
<%--$(document).ready(function(){--%>
<%--$(document).off('click.bs.dropdown.data-api');--%>
<%--});--%>

<%--</script>--%>

<style>
    .navbar .nav > li > a {
        padding: 0;
    }

    .navbar .nav > li > a > img:hover {
        width: 40px;
        height: 40px;
    }

</style>
<style>
    #plotting_tool_bar li img {
        width: 32px;
        height: 32px;
    }

    #plotting_tool_bar li:hover {
        background-color: #007FC0;
    }

</style>

<!-- 模态框（Modal） -->
<div class="modal fade" id="mySaveLayerModal" tabindex="-1" role="dialog"
     aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="myModalLabel">保存图层-图层信息</h4>
            </div>
            <div class="modal-body" style="margin-left:30px;">
                &nbsp; &#12288;&#12288;标 题 :&nbsp;&nbsp;<input type="text" id="layerName"
                                                              style="width: 350px"
                                                              placeholder="请输入标题">
                <span style="color: red">*</span>
                <br/>
                <span style="vertical-align: top">备 注 信 息 :&nbsp;&nbsp;</span><textarea id="layerRemark" placeholder="请输入备注信息"
                                              style="height:200px;width:350px;"></textarea>
                <%--<div id="saveLayerTip" style="color: red;font-size:12px;">提示信息：若当前图层无元素，不建议保存，但您仍可以保存</div>--%>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" onclick="saveLayer()">提交</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>

<!-- 系统设置模态框（Modal） -->
<div class="modal fade" id="systemSetModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content" id="systemSetContent">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title">系统设置</h4>
            </div>
            <div class="modal-body">
                <form id="systemSetBody">
                    <div>
                        主题设置
                        <label style="cursor: pointer"><input style="margin-left: 50px;" type="radio" name="theme"
                                                              value="purple">紫色</label>
                        <label style="cursor: pointer"><input style="margin-left: 50px;" type="radio" name="theme"
                                                              value="black" checked="checked">黑色</label>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" id="submitSystemSetButton" class="btn btn-primary" onclick="modifySystemSet()">
                    提交
                </button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /modal-dialog -->
</div><!-- /.modal -->


<!-- 新建资源图层模态框（Modal） -->
<div class="modal fade" id="resourceLayer" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content" id="resourceContent">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title">新建资源</h4>
            </div>
            <div class="modal-body">
                <form id="resourceLayerBody">
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" id="submitResourceButton" class="btn btn-primary">提交</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /modal-dialog -->
</div><!-- /.modal -->

<!-- 事件查询模态框（Modal） -->
<div class="modal fade" id="eventStatistics" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title">事件查询</h4>
            </div>
            <div class="modal-body">
                <form id="eventStatisticsBody">
                    <div>
                        <div class="form-group" style="height: 20px;">
                            <label class="col-sm-1 control-label">地址：</label>
                            <div class="col-sm-9">
                                <select id="eventAddr" name="address" class="selectpicker form-control"
                                        multiple="multiple">
                                    <c:forEach items="${addrs}" var="item">
                                        <option>
                                                ${item}
                                        </option>
                                    </c:forEach>
                                </select>
                            </div>

                        </div>
                    </div>
                    <div class="form-group">
                        <label>开始时间：</label><input id="eventBeginTime" class="Wdate"
                                                   style="margin-left: 20px;margin-right: 40px;"
                                                   type="text" onclick="WdatePicker({ dateFmt: 'yyyy/M/d HH:mm:ss' })">
                        <label>结束时间：</label><input id="eventEndTime" class="Wdate" type="text"
                                                   onclick="WdatePicker({ dateFmt: 'yyyy/M/d HH:mm:ss' })">
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" id="submitEventButton" class="btn btn-primary">提交</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /modal-dialog -->
</div>
<!-- /.modal -->

</div>


<div id="navigate-tool-bar">
    <nav class="navbar navbar-default" role="navigation">
        <div class="container-fluid" style="padding-right:0">
            <div style="color: #000;">
                <ul class="nav navbar-nav" style="margin:0">
                    <%--<li><a href="javascript:zoomOut()"><img src="${ctx}/images/map/military/zoomout.png" alt="放大"--%>
                    <%--title="放大"></a></li>--%>
                    <%--<li><a href="javascript:zoomIn()"><img src="${ctx}/images/map/military/zoomin.png" alt="缩小"--%>
                    <%--title="缩小"></a></li>--%>
                    <!-- <li class="btn-primary"><a href="javascript:void(0)" onclick="moveToLeft()">左移</a></li>
                     <li class="btn-primary"><a href="javascript:void(0)">右移</a></li>-->
                    <!--active 表示选中颜色假设-->
                    <!--<li class="active"><a href="javascript:void(0)">右移</a></li>-->
                    <li><a href="javascript:wander()"><img src="${ctx}/images/map/military/wander.png" alt="漫游"
                                                           title="漫游"></a></li>

                    <li class="dropdown"><a href="javascript:void(0)" class="dropdown-toggle"
                                            data-toggle="dropdown"><img
                            src="${ctx}/images/map/menu/new.png" title="新建" alt="新建"></a>
                        <ul class="dropdown-menu">

                            <li><a href="javascript:createResource('camera')" onclick="">摄像机</a></li>
                            <li class="divider"></li>
                            <li><a href="javascript:createResource('equipment')" onclick="">装备</a></li>
                            <li class="divider"></li>
                            <li><a href="javascript:createResource('facility',1000,'point')" onclick="">界碑</a></li>
                            <li><a href="javascript:createResource('facility',1001,'point')" onclick="">国门</a></li>
                            <li class="divider"></li>
                            <li><a href="javascript:createResource('facility',1002,'point')" onclick="">监控中心</a></li>
                            <li><a href="javascript:createResource('facility',1003,'point')" onclick="">监控站</a></li>
                            <li><a href="javascript:createResource('facility',1004,'line')" onclick="">传输线路</a></li>
                            <li><a href="javascript:createResource('facility',1005,'point')" onclick="">报警装置</a></li>
                            <li class="divider"></li>
                            <li><a href="javascript:createResource('facility',1006,'point')" onclick="">执勤房</a></li>
                            <li><a href="javascript:createResource('facility',1007,'point')" onclick="">瞭望塔</a></li>
                            <li><a href="javascript:createResource('facility',1008,'point')" onclick="">标志牌</a></li>
                            <li><a href="javascript:createResource('facility',1009,'point')" onclick="">灯塔</a></li>
                            <li class="divider"></li>
                            <li><a href="javascript:createResource('facility',1010,'point')" onclick="">巡逻路</a></li>
                            <li><a href="javascript:createResource('facility',1011,'point')" onclick="">桥梁</a></li>
                            <li><a href="javascript:createResource('facility',1012,'point')" onclick="">执勤码头</a></li>
                            <li><a href="javascript:createResource('facility',1013,'point')" onclick="">直升机停机坪</a></li>
                            <li><a href="javascript:createResource('facility',1014,'point')" onclick="">通道</a></li>
                            <li><a href="javascript:createResource('facility',1015,'point')" onclick="">口岸</a></li>
                            <li class="divider"></li>
                            <li><a href="javascript:createResource('facility',1016,'point')" onclick="">铁丝网</a></li>
                            <li><a href="javascript:createResource('facility',1017,'point')" onclick="">铁栅栏</a></li>
                            <li><a href="javascript:createResource('facility',1018,'point')" onclick="">隔离带</a></li>
                            <li><a href="javascript:createResource('facility',1019,'point')" onclick="">车辆拦阻设施</a></li>
                            <li class="divider"></li>
                        </ul>
                    </li>

                    <li><a id="measureLength" href="javascript:void(0)"><img
                            src="${ctx}/images/map/military/measureLength.png" alt="测距" title="测距"></a></li>
                    <li><a id="measureArea" href="javascript:void(0)"><img
                            src="${ctx}/images/map/military/measureArea.png" alt="测面" title="测面"></a></li>
                    <li><a href="javascript:clearPlotting()"><img src="${ctx}/images/map/military/clear.png"
                                                                  alt="清除" title="清除"></a></li>
                    <li><a href="javascript:moveToCenter()"><img src="${ctx}/images/map/military/toCenter.png"
                                                                 alt="本级区域" title="本级区域"></a></li>
                    <li><a href="javascript:StartCapture()"><img src="${ctx}/images/map/military/screenshot.png"
                                                                 alt="截图" title="截图"></a></li>
                    <!--<li class="btn-primary"><a href="javascript:void(0)">图层控制</a></li>-->
                    <li><a href="javascript:activate(P.PlotTypes.MARKER)()"><img
                            src="${ctx}/images/map/military/point_menu.png" title="点标" alt="点标"></a>
                    </li>
                    <%--<li style="color:white;"><a href="javascript:drawPolygon()" onclick="">报警区域</a></li>--%>
                    <li class="dropdown"><a href="javascript:void(0)" class="dropdown-toggle"
                                            data-toggle="dropdown"><img
                            src="${ctx}/images/map/military/line_menu.png" title="线标" alt="线标"></a>
                        <ul class="dropdown-menu">
                            <li><a href="javascript:void(0)" onclick="activate(P.PlotTypes.ARC)"><img
                                    src="${ctx}/images/map/military/line/arc.png" title="弧线" alt="弧线"></a></li>
                            <li class="divider"></li>
                            <li><a href="javascript:void(0)" onclick="activate(P.PlotTypes.CURVE)"><img
                                    src="${ctx}/images/map/military/line/curve.png" title="曲线" alt="曲线"></a></li>
                            <li class="divider"></li>
                            <li><a href="javascript:void(0)" onclick="activate(P.PlotTypes.POLYLINE)"><img
                                    src="${ctx}/images/map/military/line/broken_line.png" title="折线" alt="折线"></a></li>
                            <li class="divider"></li>
                            <li><a href="javascript:void(0)" onclick="activate(P.PlotTypes.FREEHAND_LINE)"><img
                                    src="${ctx}/images/map/military/line/free_line.png" title="自由线" alt="自由线"></a></li>
                        </ul>
                    </li>
                    <li class="dropdown"><a href="javascript:void(0)" class="dropdown-toggle"
                                            data-toggle="dropdown"><img
                            src="${ctx}/images/map/military/region_menu.png" title="面标" alt="面标"></a>
                        <ul class="dropdown-menu">
                            <li><a href="javascript:void(0)" onclick="activate(P.PlotTypes.CIRCLE)"><img
                                    src="${ctx}/images/map/military/region/circle.png" title="圆" alt="圆"></a></li>
                            <li class="divider"></li>
                            <li><a href="javascript:void(0)" onclick="activate(P.PlotTypes.ELLIPSE)"><img
                                    src="${ctx}/images/map/military/region/ellipse.png" title="椭圆" alt="椭圆"></a></li>
                            <li class="divider"></li>
                            <li><a href="javascript:void(0)" onclick="activate(P.PlotTypes.LUNE)"><img
                                    src="${ctx}/images/map/military/region/bow.png" title="弓形" alt="弓形"></a></li>
                            <li class="divider"></li>
                            <li><a href="javascript:void(0)" onclick="activate(P.PlotTypes.SECTOR)"><img
                                    src="${ctx}/images/map/military/region/sectors.png" title="扇形" alt="扇形"></a></li>
                            <li class="divider"></li>
                            <li><a href="javascript:void(0)" onclick="activate(P.PlotTypes.CLOSED_CURVE)"><img
                                    src="${ctx}/images/map/military/region/curve_region.png" title="曲线面" alt="曲线面"></a>
                            </li>
                            <li class="divider"></li>
                            <li><a href="javascript:void(0)" onclick="activate(P.PlotTypes.POLYGON)"><img
                                    src="${ctx}/images/map/military/region/polygon.png" title="多边形" alt="多边形"></a></li>
                            <li class="divider"></li>
                            <li><a href="javascript:void(0)" onclick="activate(P.PlotTypes.RECTANGLE)"><img
                                    src="${ctx}/images/map/military/region/rectangle.png" title="矩形" alt="矩形"></a></li>
                            <li class="divider"></li>
                            <li><a href="javascript:void(0)" onclick="activate(P.PlotTypes.FREEHAND_POLYGON)"><img
                                    src="${ctx}/images/map/military/region/free_region.png" title="自由面" alt=自由面"></a>
                            </li>
                            <li class="divider"></li>
                            <li><a href="javascript:void(0)" onclick="activate(P.PlotTypes.GATHERING_PLACE)"><img
                                    src="${ctx}/images/map/military/region/gathering_place.png" title="聚集地"
                                    alt=聚集地"></a></li>
                        </ul>
                    </li>
                    <li class="dropdown"><a href="javascript:void(0)" class="dropdown-toggle"
                                            data-toggle="dropdown"><img
                            src="${ctx}/images/map/military/arrow_menu.png" title="箭头" alt="箭头"></a>
                        <ul class="dropdown-menu">
                            <li><a href="javascript:void(0)" onclick="activate(P.PlotTypes.DOUBLE_ARROW)"><img
                                    src="${ctx}/images/map/military/arrow/qianji.png" title="钳击" alt="钳击"></a></li>
                            <li class="divider"></li>
                            <li><a href="javascript:void(0)" onclick="activate(P.PlotTypes.STRAIGHT_ARROW)"><img
                                    src="${ctx}/images/map/military/arrow/straight_arrow.png" title="直箭头" alt="直箭头"></a>
                            </li>
                            <li class="divider"></li>
                            <li><a href="javascript:void(0)" onclick="activate(P.PlotTypes.FINE_ARROW)"><img
                                    src="${ctx}/images/map/military/arrow/straight_thin_arrow.png" title="细直箭头"
                                    alt="细直箭头"></a></li>
                            <li class="divider"></li>
                            <li><a href="javascript:void(0)" onclick="activate(P.PlotTypes.ASSAULT_DIRECTION)"><img
                                    src="${ctx}/images/map/military/arrow/tuji_direction.png" title="突击方向"
                                    alt="突击方向"></a></li>
                            <li class="divider"></li>
                            <li><a href="javascript:void(0)" onclick="activate(P.PlotTypes.ATTACK_ARROW)"><img
                                    src="${ctx}/images/map/military/arrow/attack_direction.png" title="进攻方向" alt="进攻方向"></a>
                            </li>
                            <li class="divider"></li>
                            <li><a href="javascript:void(0)" onclick="activate(P.PlotTypes.TAILED_ATTACK_ARROW)"><img
                                    src="${ctx}/images/map/military/arrow/attack_direction_tail.png" title="进攻方向（尾）"
                                    alt="进攻方向（尾）"></a></li>
                            <li class="divider"></li>
                            <li><a href="javascript:void(0)" onclick="activate(P.PlotTypes.SQUAD_COMBAT)"><img
                                    src="${ctx}/images/map/military/arrow/combat_action.png" title="分队战斗行动"
                                    alt="分队战斗行动"></a></li>
                            <li class="divider"></li>
                            <li><a href="javascript:void(0)" onclick="activate(P.PlotTypes.TAILED_SQUAD_COMBAT)"><img
                                    src="${ctx}/images/map/military/arrow/combat_action_tail.png" title="分队战斗行动（尾）"
                                    alt="分队战斗行动（尾）"></a></li>
                        </ul>
                    </li>
                    <li class="dropdown"><a href="javascript:void(0)" class="dropdown-toggle" data-toggle="dropdown">
                        <img src="${ctx}/images/map/military/military_list.png" title="军标" alt="军标"/></a>
                        <ul class="dropdown-menu" id="military_list" style="overflow-y: scroll;width: 110px;">
                            <li><a href="javascript:void(0)" onclick="setObjType(100)"><img
                                    src="${ctx}/images/map/military/military_pic/100.png" title="解放军1" alt="人员"></a>
                            </li>
                            <li class="divider"></li>
                            <li><a href="javascript:void(0)" onclick="setObjType(101)"><img
                                    src="${ctx}/images/map/military/military_pic/101.png" title="解放军2" alt="车辆"></a>
                            </li>
                            <li class="divider"></li>
                            <li><a href="javascript:void(0)" onclick="setObjType(102)"><img
                                    src="${ctx}/images/map/military/military_pic/102.png" title="解放军3" alt="飞机"></a>
                            </li>
                            <li class="divider"></li>
                            <li><a href="javascript:void(0)" onclick="setObjType(103)"><img
                                    src="${ctx}/images/map/military/military_pic/103.png" title="解放军排" alt="单位"></a>
                            </li>
                            <li class="divider"></li>
                            <li><a href="javascript:void(0)" onclick="setObjType(104)"><img
                                    src="${ctx}/images/map/military/military_pic/104.png" title="解放军连" alt="军标"></a>
                            </li>
                            <li class="divider"></li>
                            <li><a href="javascript:void(0)" onclick="setObjType(105)"><img
                                    src="${ctx}/images/map/military/military_pic/105.png" title="解放军营" alt="军标"></a>
                            </li>
                            <li class="divider"></li>
                            <li><a href="javascript:void(0)" onclick="setObjType(106)"><img
                                    src="${ctx}/images/map/military/military_pic/106.png" title="难民收容点" alt="军标"></a>
                            </li>
                            <li class="divider"></li>
                            <li><a href="javascript:void(0)" onclick="setObjType(107)"><img
                                    src="${ctx}/images/map/military/military_pic/107.png" title="观察点" alt="军标"></a></li>
                            <li class="divider"></li>
                            <li><a href="javascript:void(0)" onclick="setObjType(108)"><img
                                    src="${ctx}/images/map/military/military_pic/108.png" title="拒马" alt="军标"></a></li>
                            <li class="divider"></li>
                            <li><a href="javascript:void(0)" onclick="setObjType(109)"><img
                                    src="${ctx}/images/map/military/military_pic/109.png" title="通道" alt="军标"></a></li>
                            <li class="divider"></li>
                            <li><a href="javascript:void(0)" onclick="setObjType(110)"><img
                                    src="${ctx}/images/map/military/military_pic/110.png" title="巡逻哨" alt="军标"></a></li>
                            <li class="divider"></li>
                            <li><a href="javascript:void(0)" onclick="setObjType(111)"><img
                                    src="${ctx}/images/map/military/military_pic/111.png" title="高机阵地" alt="军标"></a>
                            </li>
                            <li class="divider"></li>
                            <li><a href="javascript:void(0)" onclick="setObjType(112)"><img
                                    src="${ctx}/images/map/military/military_pic/112.png" title="克钦独立军排" alt="军标"></a>
                            </li>
                            <li class="divider"></li>
                            <li><a href="javascript:void(0)" onclick="setObjType(113)"><img
                                    src="${ctx}/images/map/military/military_pic/113.png" title="克钦独立军连" alt="军标"></a>
                            </li>
                            <li class="divider"></li>
                            <li><a href="javascript:void(0)" onclick="setObjType(114)"><img
                                    src="${ctx}/images/map/military/military_pic/114.png" title="克钦独立军营" alt="军标"></a>
                            </li>
                            <li class="divider"></li>
                            <li><a href="javascript:void(0)" onclick="setObjType(115)"><img
                                    src="${ctx}/images/map/military/military_pic/115.png" title="缅甸政府军排" alt="军标"></a>
                            </li>
                            <li class="divider"></li>
                            <li><a href="javascript:void(0)" onclick="setObjType(116)"><img
                                    src="${ctx}/images/map/military/military_pic/116.png" title="缅甸政府军连" alt="军标"></a>
                            </li>
                            <li class="divider"></li>
                            <li><a href="javascript:void(0)" onclick="setObjType(117)"><img
                                    src="${ctx}/images/map/military/military_pic/117.png" title="缅甸政府军营" alt="军标"></a>
                            </li>
                            <li class="divider"></li>
                        </ul>
                    </li>
                    <li class="dropdown"><a href="javascript:void(0)" class="dropdown-toggle"
                                            data-toggle="dropdown"><img
                            src="${ctx}/images/map/military/picture_menu.png" alt="要图标绘" title="要图标绘"></a>
                        <ul class="dropdown-menu">
                            <li><a href="javascript:void(0)" onclick="setObjType(1)"><img
                                    src="${ctx}/images/map/military/soldier_menu.png" title="人员" alt="人员"></a></li>
                            <li class="divider"></li>
                            <li><a href="javascript:void(0)" onclick="setObjType(2)"><img
                                    src="${ctx}/images/map/military/vehicle_menu.png" title="车辆" alt="车辆"></a></li>
                            <li class="divider"></li>
                            <li><a href="javascript:void(0)" onclick="setObjType(3)"><img
                                    src="${ctx}/images/map/military/plane_menu.png"
                                    title="飞机" alt="飞机"></a></li>
                            <li class="divider"></li>
                            <li><a href="javascript:void(0)" onclick="setObjType(4)"><img
                                    src="${ctx}/images/map/department/department_menu.png" title="单位" alt="单位"></a></li>
                            <li class="divider"></li>
                            <li><a href="javascript:void(0)" onclick="setObjType(5)"><img
                                    src="${ctx}/images/map/military/pin_menu.png" title="图钉" alt="图钉"></a></li>
                            <li class="divider"></li>
                            <li><a href="javascript:void(0)" onclick="setObjType(6)"><img
                                    src="${ctx}/images/map/military/water_menu.png" title="水滴" alt="水滴"></a></li>
                            <li class="divider"></li>
                        </ul>
                    </li>
                    <%--  <li>
                          <a id="export-png" href="javascript:void(0)">
                              <img src="${ctx}/images/map/menu/download.png" alt="导出" title="导出">
                          </a>
                      </li>--%>
                    <li>
                        <a id="collPlotting" onclick="joinCollPlotting()">
                            <img src="${ctx}/images/map/chat/cooperChat.png" style="height:26px;"
                                  alt="协同标绘" title="协同标绘">
                        </a>
                    </li>
                    <li>
                        <a id="saveLayer" data-toggle="modal"
                           data-target="#mySaveLayerModal">
                            <img src="${ctx}/images/map/menu/save.png" alt="保存图层" title="保存图层">
                        </a>
                    </li>

                    <li>
                        <a id="systemSet" data-toggle="modal"
                           data-target="#systemSetModal">
                            <img src="${ctx}/images/map/menu/set.png" alt="设置" title="设置">
                        </a>
                    </li>

                    <script>
                        $("#military_list").height((document.body.clientHeight - 60) + "px");
                    </script>
                    <li style="padding-right: 0"><a href="javascript:void(0)"
                                                    onclick="sendCommand('switch_map','')"><img
                            src="${ctx}/images/map/military/switch_map.png" title="切换地图" alt="切换地图"></a></li>
                    <%--</li>--%>
                    <%--<li class="btn"><a href="javascript:void(0)">定位</a></li>--%>
                    <%--<li class="btn dropdown"><a href="javascript:void(0)" class="dropdown-toggle" data-toggle="dropdown">切换<b--%>
                    <%--class="caret"></b></a>--%>
                    <%--<ul class="dropdown-menu">--%>
                    <%--<li><a href="javascript:void(0)">地形</a></li>--%>
                    <%--<li><a href="javascript:void(0)">影像</a></li>--%>
                    <%--</ul>--%>
                    <%--</li>--%>
                </ul>
            </div>
        </div>
    </nav>
</div>


<script>


    /*

    暂时注释掉， 我还会回来的
    $(function () {
         $(":checkbox[name='onlineList']").click(function() {
             alert('test');
             var $subs = $("input[name='onlineList']");
             alert($subs.length);
             $("#selectAll").prop("checked",$subs.length == $subs.filter(":checked").length ? true : false);
         });
     });*/
    var ws;//一个ws对象就是一个通信管道 不要忘记加工程名
    function joinCollPlotting() {
        var username = '${sessionScope.username}';

        var target = 'ws://127.0.0.1:8080/bhf/chatSocket?username=' + username;
        //初始加载 window.onload
        ws = new WebSocket(target);
        ws.onmessage = function (event) {

//                console.log(event.data);
//                var msg = JSON.parse(event.data);
//                console.log(msg);

            var msg = eval('(' + event.data + ')');
            console.log("内容是：" + msg);
            if (undefined !== msg.welcome) {
                $('#content').append('<div style="color:red;margin-bottom:5px;margin-left:5px;">' + msg.welcome + '</div>');
            }

            if (undefined !== msg.users) {
                $('#userList').html('');
                /*  $('#userList').append("<div style='font-size: 16px;margin-bottom:10px;font-weight: bold'>在线列表</div>");
                  <!--<input type=\"checkbox\" id=\"investselect\">反选/取消反选-->

                  $('#userList').append("<div style='margin-left: 10px;'><input type='checkbox' id='selectAll' onclick='selectAllOrCancel(this)'>全选/取消全选</div>");*/

                $.each(msg.users, function (i, entry) {
                    $('#userList').append("<input name='onlineList' style='margin-left: 10px;' type=checkbox value='" + entry + "'>" + entry + "<br>")
                })
            }

            if (undefined !== msg.content && "" !== msg.content) {
                if (msg.plotting === 1) {
//                    var wktText = msg.content.split('<br>')[1];

                    var militaryText = msg.content;
                    var militaryTextArray = militaryText.split('&');

                    var wktText = militaryTextArray[0];
                    var format = new ol.format.WKT();

                    drawOverlay.getSource().clear(true);
                    layer.getSource().clear(true);

                    var wktTextArray = wktText.split(';');
                    for (var i = 0; i < wktTextArray.length - 1; i++) {
                        var militaryFeature = format.readFeature(wktTextArray[i]);
                        militaryFeature.set('type', 'military_vector');
                        drawOverlay.getSource().addFeature(militaryFeature);
                    }

                    var picSrcArray = militaryTextArray[1].split(';');
                    var coordinateArray = militaryTextArray[2].split(';');
                    var picTextArray = militaryTextArray[3].split(';');
                    var offsetYArray = militaryTextArray[4].split(';');

                    if (militaryTextArray[1] !== '') {
                        for (i = 0; i < picSrcArray.length-1; i++) {
                            //添加feature
                            var picFeature = new ol.Feature({
                                geometry: new ol.geom.Point(eval(coordinateArray[i])),
                                type: 'military_pic',
                                coordinate: eval(coordinateArray[i])
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
                    }


                } else {
                    $('#content').append(msg.content);
                    console.log(msg.content);
                }
            }

            $('#content').scrollTop($('#content')[0].scrollHeight);
        };

        ws.onclose = function (e) {
            console.log(e);
//                alert('退出群聊');
//                ws.close(); //关闭TCP连接
        };

        $('#draggableChat').show(500);
        $('#collPlotting').removeAttr('onclick');//去掉a标签中的onclick事件

    }

    function closeSocket() {
        var flag = confirm("确定退出协同标绘？");
        if (flag) {
            $('#draggableChat').hide();
            ws.close();
            $("#collPlotting").attr("onclick","joinCollPlotting()");
        }
    }

    function close() {
        ws.close();
        return "确认离开吗？";
    }

    function showPopover(target, msg) {
        target.attr("data-original-title", msg);
//        $('[data-toggle="tooltip"]').tooltip();
        target.tooltip('show');
//        target.focus();

        //1秒后消失提示框
        setTimeout(
            function () {
                target.attr("data-original-title", "");
                target.tooltip('hide');
            }, 1000
        );
    }

    function subSend() {
//        var msg = $('#msg').val();
        var msg = ue.getContent();
        var obj = null;
        if ($('#userList :checked').size() === 0) {
            showPopover($("#sendPlottingMessage"), "请选择成员");
            return;
            /*                广播
                        obj = {
                            msg : msg,
                            type : 1,//广播 2单聊
                            isPlotting : 0//标绘
                        }*/
        } else {
            if (msg === '') {
                showPopover($("#sendPlottingMessage"), "发送内容不能为空");
                return;
            }
//                单聊
            var to = "";
            $("#userList :checked").each(function () {
                to += $(this).val() + ";";
            });
            obj = {
                to: to,
                msg: msg,
                type: 2,//广播 2单聊
                isPlotting: 0//标绘
            }
        }


        ws.send(JSON.stringify(obj));
        ue.setContent("");
    }

    function selectAllOrCancel(obj) {
        $(":checkbox[name='onlineList']").prop("checked", obj.checked); // this指代的你当前选择的这个元素的JS对象
    }

    function collaborate() {

        if ($('#userList :checked').size() === 0) {
            showPopover($("#sendPlottingMessage"), "请选择成员");
            return;
        }

        var features = layer.getSource().getFeatures();
        var picSrc = '';
        var coordinate = '';
        var picText = '';
        var offsetY = '';
        for (var i in features) {
            picSrc += features[i].getStyle().getImage().getSrc() + ';';
            coordinate += '[' + features[i].get('coordinate') + '];';
            picText += features[i].getStyle().getText().getText() + ';';
            offsetY += features[i].getStyle().getText().getOffsetY() + ';';
        }


        var vectorFeatures = drawOverlay.getSource().getFeatures();
        var wktText = '';

        for (var j in vectorFeatures) {
            var format = new ol.format.WKT(),
                wkt = format.writeGeometry(vectorFeatures[j].getGeometry());
            wktText += wkt + ';';
            // console.log("测试经纬度："+ vectorFeatures[i].getGeometry().getCoordinates());
        }


        if (picSrc === '' && wktText === '') {
            showPopover($("#sendPlottingMessage"), "请先进行标绘");
            return;
        }

        var msg = wktText + '&' + picSrc + '&' + coordinate + '&' + picText + '&' + offsetY;
        var obj = null;
        if ($('#userList :checked').size() === 0) {
//                广播
            obj = {
                msg: msg,
                type: 1, //广播 2单聊
                isPlotting: 1//标绘
            }
        } else {
//                单聊
            var to = "";
            $("#userList :checked").each(function () {
                to += $(this).val() + ";";
            });

            obj = {
                to: to,
                msg: msg,
                type: 2,//广播 2单聊
                isPlotting: 1//标绘
            }
        }
        ws.send(JSON.stringify(obj));
        showPopover($("#sendPlottingMessage"), "协同成功");
    }

</script>

<script>
    $(function () {
        $('#draggableChat').myDrag({
            handler: '.handler'
        })
    })
</script>


<div id="draggableChat"
     style="position: absolute;width:500px;top:200px;right:50px;background-color: whitesmoke;display:none">

    <div id="chatTitle" class="panel-heading handler"
         style="width: 470px;font-weight: bold;font-size:16px;border-bottom: 1px solid #C4D4BC">
        <img src="${ctx}/images/map/chat/cooperChat.png" style="width: 26px;height: 26px;"/>&nbsp;协同标绘
        <a style="color:red;float:right;margin-right: 5px;" onclick="closeSocket()">X</a>
    </div>
    <div id="container" style="float: left;width:350px;height: 462px;">

        <div id="content" style="float: left;width:350px;height: 300px;overflow-y: scroll">

        </div>
        <div style="float: left;width:350px;">
            <div>
                <script id="editor">
                </script>
            </div>
        </div>
        <%--<input id="msg" type="text">--%>
        <div>
            <input style='margin-left:216px;margin-right:20px;' id="sendMessage" type="button" value=" 发 送 "
                   data-toggle="tooltip" data-placement="top" onclick="subSend()">
            <input data-toggle="tooltip" id="sendPlottingMessage" type="button" value=" 协 同 " onclick="collaborate()">
        </div>


    </div>
    <div style="float: left;width:140px;height: 400px;">
        <div style='font-size: 16px;margin-bottom:10px;'>在线列表</div>
        <div style='margin-left: 10px;'>
            <input type='checkbox' id='selectAll' onclick='selectAllOrCancel(this)'>全选/取消全选
        </div>
        <div id="userList" style="overflow-y: auto"></div>
    </div>
</div>

<script>
    var ue = UE.getEditor('editor', {
        toolbars: [
            ['fullscreen',
                'fontsize', 'fontfamily', 'simpleupload', 'insertimage', 'emotion']
        ],
        //focus时自动清空初始化时的内容
        autoClearinitialContent: true,
        //关闭字数统计
        wordCount: false,
        //关闭elementPath
        elementPathEnabled: false,
        //默认的编辑区域高度
        initialFrameHeight: 100,
        autoHeightEnabled: false,
        enableAutoSave: false, //禁止自动保存
        autoSyncData: false//自动同步编辑器要提交的数据
    });
</script>


<%--右侧统计--%>
<div class="float-right-open"
     style="position: fixed;top:40px;right:2px;padding:4px 4px 4px 6px;width:20px;height: 20px;">
    <a class="right-open-btn" href="javascript:void(0);">
        <img src="${ctx}/images/map/right_cartogram/expand_right.png">
    </a>
</div>
<script type="text/javascript">
    $('.right-open-btn').click(function () {
        $('.float-right-open').animate({
            right: '-25px'
        }, 100, function () {
            $('#right-panel').delay(50).animate({
                right: '0px'
            }, 300);
        });
    });


</script>
<div id="right-panel" class="right-panel" style="position: fixed;top:40px;bottom:0;width: 250px;right:-260px;">
    <%--<div style="height:20px; ">--%>
    <%--<a class="right-close-btn" href="javascript:void(0)" style="margin-top: 2px;">--%>
    <%--<img src="${ctx}/images/map/right_cartogram/shrink_right.png">--%>
    <%--</a>--%>
    <%--</div>--%>

    <div class="rect" style="height: 25%;">

        <div class="rectHeader"><a class="shrinkToRight"><img src="${ctx}/images/map/right_cartogram/shrink_right.png"></a><span
                style="margin-left: 60px;">事件类型</span><a class="filter"><img title="筛选" alt="筛选"
                                                                             src="${ctx}/images/map/right_cartogram/filter.png"
                                                                             onclick="bindSubmitEvent('eventType')"></a>
        </div>
        <div id="eventType" style="height: 85%"></div>
    </div>

    <div class="rect" style="height: 25%;margin-top: 2px;">
        <div class="rectHeader"><a class="shrinkToRight"><img src="${ctx}/images/map/right_cartogram/shrink_right.png"></a><span
                style="margin-left: 60px;">事件数量</span><a class="filter"><img title="筛选" alt="筛选"
                                                                             src="${ctx}/images/map/right_cartogram/filter.png"
                                                                             onclick="bindSubmitEvent('eventNum')"></a>
        </div>
        <div id="eventNum" style="height: 85%"></div>
    </div>

    <div class="rect" style="height: 25%;margin-top: 2px;">
        <div class="rectHeader"><a class="shrinkToRight"><img src="${ctx}/images/map/right_cartogram/shrink_right.png"></a><span
                style="margin-left: 60px;">事件性质</span><a class="filter"><img title="筛选" alt="筛选"
                                                                             src="${ctx}/images/map/right_cartogram/filter.png"
                                                                             onclick="bindSubmitEvent('eventProp')"></a>
        </div>
        <div id="eventProp" style="height: 85%"></div>
    </div>

    <div class="rect" style="height: 25%;margin-top: 2px;">
        <div class="rectHeader"><a class="shrinkToRight"><img src="${ctx}/images/map/right_cartogram/shrink_right.png"></a><span
                style="margin-left: 60px;">事件地域</span><a class="filter"><img title="筛选" alt="筛选"
                                                                             src="${ctx}/images/map/right_cartogram/filter.png"
                                                                             onclick="bindSubmitEvent('eventRegion')"></a>
        </div>
        <div id="eventRegion" style="height: 85%"></div>
    </div>
</div>

<!-- Popup -->
<div id="popup" class="ol-popup" style="background-color: #4A5254;color:#FEFBEC">
    <div id="popup-header" style="padding: 10px 0px;color: #4AD5FC;">
        <span>属性信息</span>
        <a href="javascript:void(0)" id="popup-closer" class="ol-popup-closer"
           style="float:right;margin-right: 10px;"></a>
    </div>
    <div id="popup-content">


    </div>
</div>


<div id="delete-wrapper">
    <div id="btn-delete" style="display:none;">删 除</div>
</div>


<script type="text/javascript">

    //增加军标标绘
    var map, plotDraw, plotEdit, drawOverlay, drawStyle, tileLayer;
    //zc 自定义
    var plotVectorAction;


    //var center = ol.proj.transform([98.5847, 24.4365], 'EPSG:4326', 'EPSG:3857');
    var offlineMapLayer = new ol.layer.Tile({
        source: new ol.source.XYZ({
//            crossOrigin: 'anonymous',
            url: 'http://127.0.0.1:8087/tiles/{z}/{x}/{y}.png'
//            url: 'http://10.16.3.15:8084/tiles/{z}/{x}/{y}.jpg'
        })
    });

    tileLayer = new ol.layer.Tile({
        source: new ol.source.TileWMS({
            url: 'http://localhost:8080/geoserver/ccf_bhf/wms',
            params: {
                'VERSION': '1.1.1',
                'tiled': false,
                STYLES: '',
                LAYERS: 'ccf_bhf:point',
                CQL_FILTER: "NAME LIKE '%张超%'"
                //,
//                 CQL_FILTER: "NAME LIKE '%芒%'"
                //                CQL_FILTER: ''
            },
            serverType: 'geoserver'   //服务器类型
//            crossOrigin: 'anonymous'
        })
    });

    map = new ol.Map({
        layers: [offlineMapLayer, tileLayer],
        interactions: ol.interaction.defaults({
            doubleClickZoom: false
        }),
        view: new ol.View({
            center: [98.5847, 24.4365],
            projection: 'EPSG:4326',
            zoom: 14,
            // 限制地图缩放最大级别为14，最小级别为11
            minZoom: 4,
            maxZoom: 18
        }),
        target: 'map',
        controls: ol.control.defaults().extend([
            new ol.control.OverviewMap({
                layers: [offlineMapLayer, tileLayer],
                view: new ol.View({
                    projection: 'EPSG:4326'
                })
            }),
            new ol.control.ScaleLine({})
//            new ol.control.ZoomSlider({})
        ])
    });

    map.on('postcompose', function (e) {
        console.log(e);
    });


    //map.on('click', function(e){
    //    if(plotDraw.isDrawing()){
    //        return;
    //    }
    //    var feature = map.forEachFeatureAtPixel(e.pixel, function (feature, layer) {
    //        return feature;
    //    });
    //
    //    if(feature){
    //        // 开始编辑
    //        plotEdit.activate(feature);
    //        activeDelBtn();
    //
    //    }else{
    //        // 结束编辑
    //        plotEdit.deactivate();
    //        deactiveDelBtn();
    //    }
    //});


    // 初始化标绘绘制工具，添加绘制结束事件响应
    plotDraw = new P.PlotDraw(map);
    plotDraw.on(P.Event.PlotDrawEvent.DRAW_END, onDrawEnd, false, this);

    // 初始化标绘编辑工具
    plotEdit = new P.PlotEdit(map);

    // 设置标绘符号显示的默认样式
    var stroke = new ol.style.Stroke({
        color: '#FF0000',
        width: 2
    });
    //    var fill = new ol.style.Fill({color: 'rgba(0,255,0,0.4)'});
    var fill = new ol.style.Fill({color: 'rgba(255,0,0,0.5)'});
    var image = new ol.style.Circle({fill: fill, stroke: stroke, radius: 8});
    drawStyle = new ol.style.Style({image: image, fill: fill, stroke: stroke});

    // 绘制好的标绘符号，添加到FeatureOverlay显示。
    drawOverlay = new ol.layer.Vector({
        source: new ol.source.Vector()
    });
    drawOverlay.setStyle(drawStyle);
    drawOverlay.setMap(map);

    get('btn-delete').onclick = function () {
        if (drawOverlay && plotEdit && plotEdit.activePlot) {
            drawOverlay.getSource().removeFeature(plotEdit.activePlot);
            plotEdit.deactivate();
            deactiveDelBtn();
        }
    };

    /*    // 初始化加载一个扇形标绘符号
        var sector = new P.PlotFactory.createPlot(P.PlotTypes.SECTOR, [center, [98.5847, 24.4365], [98.5141, 24.4161]]);
        var feature = new ol.Feature({
            geometry: sector
        });
        drawOverlay.getSource().addFeature(feature);*/


    // 绘制结束后，添加到FeatureOverlay显示。
    function onDrawEnd(event) {
        var feature = event.feature;
        feature.set('type', 'military_vector');
//        var format = new ol.format.WKT(),
//        wkt = format.writeGeometry(feature.getGeometry());
//        alert(wkt);
        drawOverlay.getSource().addFeature(feature);
        // 开始编辑
        plotEdit.activate(feature);
//        activeDelBtn();
    }

    // 指定标绘类型，开始绘制。
    function activate(type) {
        plotEdit.deactivate();
        plotDraw.activate(type);
        plotVectorAction = 'activate';
    }

    function get(domId) {
        return document.getElementById(domId);
    }

    function activeDelBtn() {
        get('btn-delete').style.display = 'inline-block';
    }

    function deactiveDelBtn() {
        get('btn-delete').style.display = 'none';
    }

    //    var temwkt ="POLYGON((98.57849887047745 24.440809887661608,98.59123862387986 24.43857666193879,98.59135350583394 24.439948416373255,98.59469220320423 24.436002683117458,98.59074646994844 24.43266398574717,98.59086022158287 24.43403583437494,98.57792655155602 24.433942060604558))";
    //   var temwkt ="POINT(98.62182177276613 24.437487052917483)";
    //    var tempformat = new ol.format.WKT();
    //    var fea = tempformat.readFeature(temwkt);
    //    drawOverlay.getSource().addFeature(fea);
    //
    //    var temp = tempformat.writeGeometry(fea.getGeometry());


</script>

</body>
<script>
    var BASE_URL = '${ctx}';

</script>
<script type="text/javascript" src="${ctx}/js/map/toolBar.js" charset="UTF-8"></script>
<script type="text/javascript" src="${ctx}/js/map/mapSearch.js" charset="UTF-8"></script>
<script type="text/javascript" src="${ctx}/js/map/panel.js"></script>

</html>
