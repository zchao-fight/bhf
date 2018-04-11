function showHorizontalBar() {
	$.post(BASE_URL + "/stat/resource.action", {}, function(data) {
		console.log(data.num);
		console.log(data.name);

		var horizontalBarChart = echarts.init(document
				.getElementById('resource_statistics_zc'));
		horizontalBar = {
			tooltip : {
				trigger : 'axis',
				axisPointer : {
					type : 'shadow'
				},
				hideDelay : 0,
				showDelay : 0
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
	}, "json");
}

function showVerticalBar() {

	/*
	 * $.post(BASE_URL + "/stat/eventLevel.action", {}, function(data) {
	 * 
	 * var tempData = new Array();
	 * 
	 * for (var i = 0; i < data.name.length; i++) { var temp =
	 * {value:data.num[i], name:data.name[i]}; tempData.push(temp); }
	 * 
	 * var myChart = echarts.init(document.getElementById('duty_statistics'));
	 * 
	 * 
	 * var option = { title : { text: '事件程度', subtext: '统计分析', x:'center' },
	 * tooltip : { trigger: 'item', formatter: "{a} <br/>{b} : {c} ({d}%)" },
	 * legend: { orient: 'vertical', left: 'left', data: data.name }, series : [ {
	 * name: '事件程度', type: 'pie', radius : '55%', center: ['50%', '60%'], data:
	 * tempData , itemStyle: { emphasis: { shadowBlur: 10, shadowOffsetX: 0,
	 * shadowColor: 'rgba(0, 0, 0, 0.5)' } } } ] }; // 使用刚指定的配置项和数据显示图表。
	 * myChart.setOption(option);
	 *  }, "json");
	 */

	$.post(BASE_URL + "/stat/countPost.action", {}, function(data) {

		var tempData = new Array();

		for (var i = 0; i < data.name.length; i++) {
			var temp = {
				value : data.num[i],
				name : data.name[i]
			};
			tempData.push(temp);
		}

		var myChart = echarts.init(document.getElementById('duty_statistics'));

		var option = {
			/*
			 * title : { text: '事件程度', subtext: '统计分析', x:'center' },
			 */
			tooltip : {
				trigger : 'item',
				formatter : "{a} <br/>{b} : {c} ({d}%)",
				hideDelay : 0,
				showDelay : 0
			},
			legend : {
				orient : 'vertical',
				x : 'left',
				data : data.name,
				itemGap : 3,
				itemWidth : 10,
				itemHeight:10,
				show : false
			},
			series : [ {
				name : '发文量',
				type : 'pie',
				radius : '55%',
				center : [ '50%', '60%' ],
				data : tempData,
				itemStyle : {
					emphasis : {
						shadowBlur : 10,
						shadowOffsetX : 0,
						shadowColor : 'rgba(0, 0, 0, 0.5)'
					}
				}
			} ]
		};
		// 使用刚指定的配置项和数据显示图表。
		myChart.setOption(option);

	}, "json");

}

function showRadar() {

	$.post(BASE_URL + "/stat/duty.action", {}, function(data) {
		var myChart = echarts.init(document.getElementById('radar'));

		var tempData = new Array();
		if (data.name.length == 0) {
			return;
		}

		for (var i = 0; i < data.name.length; i++) {
			var temp = {
				text : data.name[i],
				max : data.max
			};
			tempData.push(temp);
		}
		option = {
			title : {},
			tooltip : {
				hideDelay : 0,
				showDelay : 0
			},
			legend : {
				left : 'left',
			},
			toolbox : {},
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
					name : '实际',
					normal : {
						color : 'red'
					}
				}, ]
			} ]
		};

		// 使用刚指定的配置项和数据显示图表。
		myChart.setOption(option);
	}, "json");

}

function showPieChart() {

	$.post(BASE_URL + "/stat/getVisit.action", {},
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
						formatter : "{a} <br/>{b}: {c} ({d}%)",
						hideDelay : 0,
						showDelay : 0
					},
					legend : {
						orient : 'vertical',
						x : 'left',
						data : data.name,
						itemGap : 3,
						itemWidth : 10,
						itemHeight:10,
						show: false
					},
					  series: [
					           {
					               name:'访问来源',
					               type:'pie',
					               selectedMode: 'single',
					               radius: [0, '30%'],

					               label: {
					                   normal: {
					                       position: 'inner'
					                   }
					               },
					               labelLine: {
					                   normal: {
					                       show: false
					                   }
					               },

					           },
					           {
					               name:'访问来源',
					               type:'pie',
					               radius: ['40%', '55%'],

					               data:tempData
					           }
					       ]
				};

				myChart.setOption(option);

			}, "json");

}
