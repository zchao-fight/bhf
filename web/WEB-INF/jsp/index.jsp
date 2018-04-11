<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script src="${ ctx }/js/jquery.min.js"></script> 
<%-- <script src="${ ctx }/js/jquery-1.8.3.min.js"></script> --%>
<script src="${ ctx }/js/jquery.SuperSlide.js"></script>
<script src="${ ctx }/js/dropdown.js"></script>

<%-- <script src="${ctx}/js/highcharts.js" type="text/javascript"></script> --%>

<script src="${ctx}/js/echarts.js"></script>
<script src="${ctx}/js/page.js"></script>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>德宏州党政军警民联防平台</title>
<link href="${ctx}/css/style.css" rel="stylesheet">





</head>

<body
	onload="showRadar();showVerticalBar();showPieChart();showHorizontalBar()">

	<!-- 使用公共头部 -->
	<jsp:include page="/WEB-INF/jsp/common/header.jsp"></jsp:include>

	<!-- slide -->
	<div class="slide">
		<div class="bd">
			<ul>
				<!-- <li><a href="javascript:;"><img src="images/b01.jpg" alt=""></a></li>
				<li><a href="javascript:;"><img src="images/b02.jpg" alt=""></a></li>
				<li><a href="javascript:;"><img src="images/b03.jpg" alt=""></a></li>
				<li><a href="javascript:;"><img src="images/b04.jpg" alt=""></a></li>
				<li><a href="javascript:;"><img src="images/b05.jpg" alt=""></a></li> -->

				<c:forEach var="item" items="${toppedPicture }">
					<li><a><img src="/upload/4097/0/${item }" alt=""></a></li>
				</c:forEach>
			</ul>
		</div>
		<div class="hd">
			<ul>
			</ul>
		</div>
	</div>
	<!-- content -->
	<div class="content">
		<div class="section">
			<div class="panel">
				<div class="panel-hd">
					<a href="${ctx }//notice/more.action">通知公告</a>
				</div>
				<div class="panel-bd">
					<ul class="news-list">
						<c:forEach items="${notice }" var="item">
							<li><a
								href="${ctx}/notice/detail.action?id=${item.id}&tmp=<%=Math.random()%>">${item.name }</a>
								<span class="news-date">${fn:substringBefore(item.createdate, " ")}</span></li>
						</c:forEach>
					</ul>
				</div>
			</div>
			<div class="panel">
				<div class="panel-hd">
					<a href="#">值班信息</a>
				</div>
				<div class="panel-bd">
					<ul class="onduty">
						<li class="onduty-tit">
							<div class="dd">
								<span class="dd-item">上午</span> <span class="dd-item">下午</span>
							</div>
						</li>
						<c:set var="index" value="0"></c:set>
						<c:forEach begin="1" end="7" step="1" varStatus="status">
							<li><c:choose>
									<c:when test="${status.count eq 1 }">
										<span class="dt">一</span>
									</c:when>
									<c:when test="${status.count eq 2 }">
										<span class="dt">二</span>
									</c:when>
									<c:when test="${status.count eq 3 }">
										<span class="dt">三</span>
									</c:when>
									<c:when test="${status.count eq 4 }">
										<span class="dt">四</span>
									</c:when>
									<c:when test="${status.count eq 5 }">
										<span class="dt">五</span>
									</c:when>
									<c:when test="${status.count eq 6 }">
										<span class="dt">六</span>
									</c:when>
									<c:when test="${status.count eq 7 }">
										<span class="dt">日</span>
									</c:when>
								</c:choose>
								<div class="dd">

									<c:if test="${status.count < weekIndex}">
										<span class="dd-item"></span>
										<span class="dd-item"></span>
									</c:if>
									<c:if test="${status.count >= weekIndex}">

										<c:choose>
											<c:when test="${duty[index].type != '全天' }">
												<span class="dd-item">${duty[index].advisername }</span>
												<span class="dd-item">${duty[index+1].advisername }</span>
												<c:set var="index" value="${index+2 }"></c:set>
											</c:when>
											<c:otherwise>
												<span class="dd-item">${duty[index].advisername }</span>
												<span class="dd-item">${duty[index].advisername }</span>
												<c:set var="index" value="${index+1 }"></c:set>
											</c:otherwise>
										</c:choose>
									</c:if>


								</div></li>
						</c:forEach>
					</ul>
				</div>
			</div>
			<div class="panel">
				<div class="panel-hd">
					资源统计
					<img id="language" style="float: right;margin-top: 10px" title="筛选" alt="筛选" src="${ctx }/images/screen_out.png">
				</div>

				<div id="resource_statistics_zc" class="panel-bd"
					style="width: 380px; height: 280px;"></div>
			</div>
		</div>
		<div class="section">
			<div class="panel-tab" id="tab01">
				<ul class="tab-hd">
					<li class="active"><a href="${ctx }/work/more.action">工作动态</a></li>
					<li><a href="${ctx }/news/more.action">联防要闻</a></li>
					<!-- <li><a href="javascript:;">国内外新闻</a></li> -->
				</ul>
				<div class="tab-bd">
					<div class="tab-item" style="display: block">
						<!-- slide -->
						<div class="slide-sm">
							<div class="bd">
								<ul>
									<c:forEach var="item" items="${focusWork }">
										<li><a
											href="${ ctx }/work/detail.action?id=${item.id}&tmp=<%=Math.random()%>"><img
												src="/upload/2049/${item.id }/${item.id }.jpg" /><span
												class="txt">${item.name }</span></a></li>
									</c:forEach>
								</ul>
							</div>
							<div class="hd">
								<ul>
								</ul>
							</div>
						</div>
						<ul class="news-list pull-left">
							<c:forEach items="${work }" var="item">
								<li><a
									href="${ ctx }/work/detail.action?id=${item.id}&tmp=<%=Math.random()%>">${item.name }</a>
									<span class="news-date">${fn:substringBefore(item.createdate, " ")}</span></li>
							</c:forEach>
						</ul>
					</div>
					<div class="tab-item">
						<!-- slide -->
						<div class="slide-sm">
							<div class="bd">
								<ul>
									<!-- <li><a href="javascript:;"><img
											src="images/pic/p01.jpg" alt=""><span class="txt">国家实验室认证成功
												给三院111厂</span></a></li>
									<li><a href="javascript:;"><img
											src="images/pic/p02.jpg" alt=""><span class="txt">国家实验室认证成功
												给三院111厂</span></a></li>
									<li><a href="javascript:;"><img
											src="images/pic/p01.jpg" alt=""><span class="txt">国家实验室认证成功
												给三院111厂</span></a></li>
									<li><a href="javascript:;"><img
											src="images/pic/p02.jpg" alt=""><span class="txt">国家实验室认证成功
												给三院111厂</span></a></li> -->



									<c:forEach var="item" items="${focuNews }">
										<li><a
											href="${ctx }/news/detail.action?id=${item.id}&tmp=<%=Math.random()%>"><img
												src="/upload/257/${item.id }/${item.id }.jpg" /><span
												class="txt">${item.name }</span></a></li>
									</c:forEach>
								</ul>
							</div>
							<div class="hd">
								<ul>
								</ul>
							</div>
						</div>
						<ul class="news-list pull-left">


							<c:forEach items="${news }" var="item">
								<li><a
									href="${ctx }/news/detail.action?id=${item.id}&tmp=<%=Math.random()%>">${item.name }</a>
									<span class="news-date">${fn:substringBefore(item.createdate, " ")}</span></li>
							</c:forEach>
						</ul>
					</div>
					<div class="tab-item">
						<!-- slide -->
						<div class="slide-sm">
							<div class="bd">
								<ul>
									<li><a href="javascript:;"><img
											src="images/pic/p01.jpg" alt=""><span class="txt">国家实验室认证成功
												给三院111厂</span></a></li>
									<li><a href="javascript:;"><img
											src="images/pic/p02.jpg" alt=""><span class="txt">国家实验室认证成功
												给三院111厂</span></a></li>
									<li><a href="javascript:;"><img
											src="images/pic/p01.jpg" alt=""><span class="txt">国家实验室认证成功
												给三院111厂</span></a></li>
									<li><a href="javascript:;"><img
											src="images/pic/p02.jpg" alt=""><span class="txt">国家实验室认证成功
												给三院111厂</span></a></li>
								</ul>
							</div>
							<div class="hd">
								<ul>
								</ul>
							</div>
						</div>
						<ul class="news-list pull-left">
							<li><a href="#">三院隆重举行升旗仪式 纪念航天事业典礼仪式开始</a> <span
								class="news-date">2017-05-06</span></li>
							<li><a href="#">三院隆重举行升旗仪式 纪念航天事业典礼仪式开始</a> <span
								class="news-date">2017-05-06</span></li>
							<li><a href="#">三院隆重举行升旗仪式 纪念航天事业典礼仪式开始</a> <span
								class="news-date">2017-05-06</span></li>
							<li><a href="#">三院隆重举行升旗仪式 纪念航天事业典礼仪式开始</a> <span
								class="news-date">2017-05-06</span></li>
							<li><a href="#">三院隆重举行升旗仪式 纪念航天事业典礼仪式开始</a> <span
								class="news-date">2017-05-06</span></li>
							<li><a href="#">三院隆重举行升旗仪式 纪念航天事业典礼仪式开始</a> <span
								class="news-date">2017-05-06</span></li>
						</ul>
					</div>
				</div>
			</div>
			<div class="panel">
				<div class="panel-hd">
					值班签到次数统计（周） 
					<select id="dutySelect" style="float: right; font-size: 10px; float: right; font-size: 10px; height: 20px; margin-top: 10px;display:none">
						<option value="week">周</option>
						<option value="month" selected="selected">月</option>
						<option value="season">季</option>
						<option value="year">年</option>
					</select>

				</div>
				<div class="panel-bd">
					<div id="radar" style="width: 350px; height: 280px;"
						class="chart-box"></div>
				</div>
			</div>
		</div>
		<div class="section">
			<div class="panel">
				<div class="panel-hd">
					<a href="${ctx }/style/more.action">基层风采</a>
				</div>
				<div class="panel-bd">
					<div class="soldiers">
						<c:forEach var="item" items="${style }">
							<a
								href="${ctx }/style/detail.action?id=${item.id}&tmp=<%=Math.random()%>"><img
								src="/upload/513/${item.id }/${item.id }.jpg" class="s-pic"
								alt=""></a>

							<p style="word-break: break-all;">${ item.content };</p>
						</c:forEach>


					</div>
				</div>
			</div>
			<div class="panel">
				<div class="panel-hd">
					<a href="${ctx }/law/more.action">政策法规</a>
				</div>
				<div class="panel-bd">
					<ul class="news-list news-list-onlytxt">
						<c:forEach items="${law }" var="item">
							<li><a
								href="${ctx}/law/detail.action?id=${item.id}&tmp=<%=Math.random()%>">${item.name }</a></li>
						</c:forEach>
					</ul>
				</div>
			</div>
			<div class="panel">
				<div class="panel-hd">联防平台发文量统计
						<select id="postCount" style="float: right; font-size: 10px; float: right; font-size: 10px; height: 20px; margin-top: 10px;">
						<option value="notice" >通知公告</option>
						<option value="news"  >联防要闻</option>
						<option value="work" selected="selected">工作动态</option>
						<option value="style">基层风采</option>
						<option value="law">政策法规</option>
					</select>
				</div>
				<div class="panel-bd">
					<div id="duty_statistics" class="chart-box"
						style="width: 350px; height: 250px;">
						<!--  <img src="images/pic/p04.jpg"> -->
					</div>
				</div>
			</div>
		</div>
		<div class="section">
			<div class="panel-tab panel-tab-sm" id="tab02">
				<ul class="tab-hd">
					<li class="active"><a style="float:left" href="${ ctx }/showAllFilms.do"
						style="a: hover: red">戍边影院</a></li>
				</ul>
				<div class="tab-bd">
					<div class="tab-item" style="display: block;">
						<ul class="v-list">
							<c:forEach var="item" items="${film }">
								<li><a href="${ctx }/playFilm.do?id=${item.id}"
									class="v-pic"><img src="${item.imgurl}" alt=""
										style="width: 160px; height: 120px"></a>
									<div class="v-info" style="margin-left: 170px">
										<p>片名：${item.title }</p>
										<p>国家：${item.country }</p>
										<p>时长：${item.during }</p>
										<p>主演：${item.leadingrole }</p>
									</div></li>
							</c:forEach>
						</ul>
					</div>
				</div>
			</div>
			<div class="panel">
				<div class="panel-hd">
					<a href="${ctx }/category_list.do">论坛互动</a>
				</div>
				<div class="panel-bd">
					<ul class="news-list">


						<c:forEach var="item" items="${thread }">
							<li><a href="${ctx }/thread_list.do?id=${item.id}">
									${item.title } </a> <span class="news-date"> <fmt:formatDate
										value="${item.datecreated }" pattern="yyyy/MM/dd" /></span></li>
						</c:forEach>
					</ul>
				</div>
			</div>
			<div class="panel">
				<div class="panel-hd">联防平台访问量统计
						<select id="eventProportion" style="float: right; font-size: 10px; float: right; font-size: 10px; height: 20px; margin-top: 10px;display:none">
						<option value="week">周</option>
						<option value="month" selected="selected">月</option>
						<option value="season">季</option>
						<option value="year">年</option>
					</select>
				
				</div>
				<div class="panel-bd">
					<div id="event_statistics" class="chart-box"
						style="width: 350px; height: 250px;">
						<!--  <img src="images/pic/p04.jpg"> -->
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- 包含资源统计信息 -->
	<jsp:include page="/WEB-INF/jsp/statistics/resource.jsp"></jsp:include>
	<!-- 包含公共的尾部footer -->
	<jsp:include page="/WEB-INF/jsp/common/footer.jsp"></jsp:include>


	<script>
	
jQuery(".slide").slide({
  titCell:".hd ul",
  mainCell:".bd ul",
  effect:"left",
  autoPlay:true,
  autoPage:"<li><a></a></li>",
  interTime: 2000
});
jQuery(".slide-sm").slide({
  mainCell:".bd ul",
  effect:"left",
  autoPlay:true,
  autoPage:"<li><a></a></li>",
  interTime: 2000
});

//选项卡切换
 function tab(obj){
  var $this = $(obj);
  var $tabmenu = $this.find(".tab-hd li");
  $tabmenu.on("mousemove",function(){
    if ($(this).hasClass('active')) return
    $(this).addClass("active").siblings().removeClass("active");
    $this.find(".tab-item").eq($(this).index()).fadeIn().siblings().hide();
  })
} 
 //选项卡调用
tab(".panel-tab");

// 返回顶部

$("#return").click(function(){ 
  $('body,html').animate({scrollTop:0},500); 
})


</script>
	<!-- 测试json -->
	<script type="text/javascript">
		var BASE_URL = "${ctx}/";
		//发送ajax post请求，对于TestControoller的getData方法
		$.post("${ctx}/modifyPersonalInfo.do", {}, function(data) {
			/* console.log(data.aa);
			console.log(data); */
		}, "json");
	</script>
	
<script type="text/javascript">

$("select#dutySelect").change(function(){
	  console.log($(this).val());
	  var jsonData = {"time":$(this).val()};
	  console.log(jsonData);
	  
	  $.post(BASE_URL + "/stat/duty.action", jsonData, function(data) {
			var myChart = echarts.init(document.getElementById('radar'));

			var tempData = new Array();

			for (var i = 0; i < data.name.length; i++) {
				var temp = {
					text : data.name[i],
					max : data.max
				};
				tempData.push(temp);
			}
			option = {
				title : {},
				tooltip : {},
				legend : {
					left : 'left',
				},
				toolbox : {
				},
				calculable : true,

				polar : [ {
					indicator : tempData,
					radius : 90

				} ],
				series : [ {
					name : '反馈率对比',
					type : 'radar',
					itemStyle : {
						normal : {
							areaStyle : {
								type : 'blue'
							}
						}
					},
					data : [ {
						value : data.num,
						name : '反馈次数',
						normal : {
							color : 'red'
						}
					},
					]
				} ]
			};

			// 使用刚指定的配置项和数据显示图表。
			myChart.setOption(option);
		}, "json");
	  
	 });
</script>
<script type="text/javascript">

$("select#eventLevel").change(function(){
	  console.log($(this).val());
	  
	  var jsonData = {"time":$(this).val()};
	  console.log(jsonData);
	  
	  $.post(BASE_URL + "/stat/eventLevel.action", jsonData, function(data) {
		  var tempData = new Array();

			for (var i = 0; i < data.name.length; i++) {
				var temp = {value:data.num[i], name:data.name[i]};
				tempData.push(temp);
			}
			
			var myChart = echarts.init(document.getElementById('duty_statistics'));
			
			
			var option = {
				    /*title : {
				        text: '事件程度',
				        subtext: '统计分析',
				        x:'center'
				    },*/
				    tooltip : {
				        trigger: 'item',
				        formatter: "{a} <br/>{b} : {c} ({d}%)"
				    },
				    legend: {
				        orient: 'vertical',
				        left: 'left',
				        data: data.name
				    },
				    series : [
				        {
				            name: '事件程度',
				            type: 'pie',
				            radius : '55%',
				            center: ['50%', '60%'],
				            data: tempData ,
				            itemStyle: {
				                emphasis: {
				                    shadowBlur: 10,
				                    shadowOffsetX: 0,
				                    shadowColor: 'rgba(0, 0, 0, 0.5)'
				                }
				            }
				        }
				    ]
				};
			// 使用刚指定的配置项和数据显示图表。
			myChart.setOption(option);
	  },"json");
	  
	  
	  
	  
	  
	 });
</script>
<script type="text/javascript">

$("select#eventProportion").change(function(){
	  console.log($(this).val());
	  var jsonData = {"time":$(this).val()};
	  console.log(jsonData);
	  $.post(BASE_URL + "/stat/eventType.action", jsonData,
				function(data) {

					var tempData = new Array();

					for (var i = 0; i < data.name.length; i++) {
						var temp = {
								value : data.num[i],
								name : data.name[i]
						
						};
						tempData.push(temp);
					}
					var myChart = echarts.init(document
							.getElementById('event_statistics'));

					option = {
						tooltip : {
							trigger : 'item',
							formatter : "{a} <br/>{b}: {c} ({d}%)"
						},
						legend : {
							orient : 'vertical',
							x : 'left',
							data : data.name
						},
						series : [ {
							name : '事件类型',
							type : 'pie',
							radius : [ '50%', '70%' ],
							avoidLabelOverlap : false,
							label : {
								normal : {
									show : false,
									position : 'center'
								},
								emphasis : {
									show : true,
									textStyle : {
										fontSize : '30',
										fontWeight : 'bold'
									}
								}
							},
							labelLine : {
								normal : {
									show : false
								}
							},
							data : tempData
						} ]
					};

					myChart.setOption(option);
	  }, "json");
	 });
	 
	 
	 
	 
	 
	 
$("select#postCount").change(function(){
	  console.log($(this).val());
	  
	  var jsonData = {"type":$(this).val()};
	  console.log(jsonData);
	  
	  $.post(BASE_URL + "/stat/countPost.action", jsonData, function(data) {
		  var tempData = new Array();

			for (var i = 0; i < data.name.length; i++) {
				var temp = {value:data.num[i], name:data.name[i]};
				tempData.push(temp);
			}
			
			var myChart = echarts.init(document.getElementById('duty_statistics'));
			
			
			var option = {
				    tooltip : {
				        trigger: 'item',
				        formatter: "{a} <br/>{b} : {c} ({d}%)",
				        hideDelay : 0,
						showDelay : 0
				    },
				     legend: {
				    	 orient : 'vertical',
							x : 'left',
							data : data.name,
							itemGap : 3,
							itemWidth : 10,
							itemHeight:10,
							show : false
				    }, 
				    series : [
				        {
				            name: '发文量',
				            type: 'pie',
				            radius : '55%',
				            center: ['50%', '60%'],
				            data: tempData ,
				            itemStyle: {
				                emphasis: {
				                    shadowBlur: 10,
				                    shadowOffsetX: 0,
				                    shadowColor: 'rgba(0, 0, 0, 0.5)'
				                }
				            }
				        }
				    ]
				};
			// 使用刚指定的配置项和数据显示图表。
			myChart.setOption(option);
	  },"json");
	 });
	 
	 

/* $(function () {
	var chart = new Highcharts.Chart({ 
                chart: {
                    type: 'column',
                    renderTo: 'event_statistics',
                },
                title: {
                    text: null
                },
                subtitle: {
                    text: null
                },
                xAxis: {
                    type: 'category',
                    labels: {
                        rotation: -45,
                        style: {
                            fontSize: '13px',
                            fontFamily: 'Verdana, sans-serif'
                        }
                    }
                },
                yAxis: {
                    min: 0,
                    title: {
                        text: null
                    }
                },
                legend: {
                    enabled: false
                },
                tooltip: {
                    pointFormat: '人口总量: <b>{point.y:.1f} 百万</b>'
                },
                credits: {  
                    enabled: false     //不显示LOGO 
                },
                series: [{
                    name: '总人口',
                    colorByPoint:true,
                    data: [
                         
                        ['上海', 24.25],
                        ['北京', 21.51],
                        ['德里', 16.78],
                        ['拉各斯', 16.06],
                        ['天津', 15.20],
                        ['伊斯坦布尔', 14.16],
                        ['东京', 13.51],
                        ['广州', 13.08],
                        ['孟买', 12.44],
                        ['莫斯科', 12.19],
                        ['圣保罗', 12.03],
                        ['深圳', 10.46]
                    ],
                    plotOptions: {
                    	column:{
                    		colorByPoint:true
                    	}
                    },
                    dataLabels: {
                        enabled: true,
                        rotation: -90,
                        color: '#000',
                        align: 'right',
                        format: '{point.y:.1f}', // one decimal
                        y: 10, // 10 pixels down from the top
                        style: {
                            fontSize: '13px',
                            fontFamily: 'Verdana, sans-serif'
                        }
                    }
                }]
    });
}); */



	
	 
	 
</script>

</body>
</html>