<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">

<style type="text/css">
.container {
	position: absolute;
	display: none;
	padding-left: 10px;
}

.shadow {
	float: left;
}

.frame {
	position: relative;
	background: #fff;
	padding: 6px;
	display: block;
	-moz-box-shadow: 3px 3px 10px rgba(0, 0, 0, 0.6);
	-webkit-box-shadow: 3px 3px 10px rgba(0, 0, 0, 0.6);
	box-shadow: 3px 3px 10px rgba(0, 0, 0, 0.6);
}

.clear {
	clear: left;
}


#language {
	font-size: 13px;
	color: #4f6b72;
	height: 20px;
}

div.frame div {
	margin-bottom: 5px;
}

div.frame div.foot {
	margin-top: 10px;
}

div.frame label {
	margin: 0 10px 0 5px;
}

div.frame a:link, div.frame span a:visited {
	text-decoration: none;
}
</style>

</head>
<body>

	<div class="container">
		<div class="shadow">
			<div class="frame" style="height: 400px;overflow-y:scroll;">
				<div>
					<input type="checkbox" value="1" id="location0" checked="checked" /><label
						for="location0">摄像头</label>
				</div>
				<div>
					<input type="checkbox" value="984069" id="location1"
						checked="checked" /><label for="location1">通道</label>
				</div>
				<div>
					<input type="checkbox" value="984070" id="location2"
						checked="checked" /><label for="location2">口岸</label>
				</div>
				<div>
					<input type="checkbox" value="991234" id="location3"
						checked="checked" /><label for="location3">国门</label>
				</div>
				<div>
					<input type="checkbox" value="991233" id="location4"
						checked="checked" /><label for="location4">界碑</label>
				</div>
				<div>
					<input type="checkbox" value="984066" id="location5" /><label
						for="location5">码头</label>
				</div>
				<div>
					<input type="checkbox" value="984067" id="984067" /><label
						for="984067">停机坪</label>
				</div>
				<div>
					<input type="checkbox" value="984068" id="984068" /><label
						for="984068">桥梁</label>
				</div>
				<div>
					<input type="checkbox" value="987137" id="987137" /><label
						for="987137">标志牌</label>
				</div>
				<div>
					<input type="checkbox" value="987138" id="987138" /><label
						for="987138">灯塔</label>
				</div>
				<div>
					<input type="checkbox" value="987139" id="987139" /><label
						for="987139">电子墙</label>
				</div>
				<div>
					<input type="checkbox" value="987140" id="987140" /><label
						for="987140">瞭望台</label>
				</div>
				<div>
					<input type="checkbox" value="987141" id="987141" /><label
						for="987141">执勤房</label>
				</div>
				<div>
					<input type="checkbox" value="985089" id="985089" /><label
						for="985089">车辆</label>
				</div>
				<div>
					<input type="checkbox" value="985090" id="985090" /><label
						for="985090">隔离带</label>
				</div>
				<div>
					<input type="checkbox" value="985091" id="985091" /><label
						for="985091">铁丝网</label>
				</div>
				<div>
					<input type="checkbox" value="985092" id="985092" /><label
						for="985092">铁栅栏</label>
				</div>
				<div>
					<input type="checkbox" value="983584" id="983584" /><label
						for="983584">报警装置</label>
				</div>
				<div>
					<input type="checkbox" value="983585" id="983585" /><label
						for="983585">传输路线</label>
				</div>
				<div>
					<input type="checkbox" value="983586" id="983586" /><label
						for="983586">雷达</label>
				</div>
				<div>
					<input type="checkbox" value="983587" id="983587" /><label
						for="983587">监控中心</label>
				</div>
				<div>
					<input type="checkbox" value="983588" id="983588" /><label
						for="983588">监控站</label>
				</div>

				<div class="foot" style="margin-bottom: 10px">
					<a href="javascript:void(0)" id="submit">确定</a> &nbsp;&nbsp; <a
						href="javascript:void(0)" id="cancel">取消</a>
				</div>
			</div>
		</div>
	</div>
	<script>

    $('#language').bind('click', function() {
        var offset = $(this).offset(), container = $('div.container');
        console.dir(offset);
        console.dir(container);
        container.css({top:offset.top+Number($(this).css('height').replace('px', '')), left:offset.left}).show(100);
    });

    $(document).bind('click', function(){
        var targ;
        if (event.target) {
			targ = event.target
		} 
        else if (event.srcElement) {
			targ = event.srcElement
		} 
        if (targ.nodeType == 3) {
			targ = targ.parentNode;// defeat Safari bug 
		}
            
        if (targ.id !='language' && !$(targ).parents('div.container').attr('class')) {
			$('div.container').hide(100);
		}
            
    });

$('#cancel').bind('click', function() {
	
	$('div.container').hide(100);
});
    
$('#submit').bind('click', function(){
	var type = new Array();
	var typeName = new Array();
	
        $('div.frame input[type=checkbox]:checked').each(function(){
			typeName.push($(this).next().text());
			type.push($(this).val());
        });
		
		console.log(type);
		console.log(typeName);
	 	if(type.length <  3 || type.length > 8) {
			alert("请选择3条到8条显示");
			return;
		} 
        $('div.container').hide(100);
        
        var resource = {"type" : type};
        console.log(resource);
        
        
        $.ajax({
                    url : BASE_URL + "/stat/resource.action",
                    data : {
                        "type" : type,
                        "typeName": typeName
                    },
                    dataType : 'json',
                    type : "post",
                    traditional: true,//属性在这里设置
                    success : function(data) {   
                    	console.log(data.num);
                		console.log(data.name);

                		var horizontalBarChart = echarts.init(document
                				.getElementById('resource_statistics_zc'));
                		horizontalBar = {
                			tooltip : {
                				trigger : 'axis',
                				axisPointer : {
                					type : 'shadow'
                				}
                			},

                			grid : {
                				left : '15%',
                				right : '4%',
                				bottom : '8%',
                				top : '1%'

                			},
                			xAxis : {

                			},
                			yAxis : {
                				type : 'category',
                				/* data: ['其他','边防设施','路障设施','手持设备','联防设施','摄像头'] */
                				data : data.name
                			},
                			series : [ {
                				name : '资源数',
                				type : 'bar',
                				/* data: [5, 20, 36, 100, 10, 20] */
                				data : data.num
                			},

                			]
                		};

                		// 使用刚指定的配置项和数据显示图表。
                		horizontalBarChart.setOption(horizontalBar);
                    },
                    waitMsg : '正在处理数据....'
                }
        );
        
    });
</script>

</body>
</html>