
var china_map;

$(function(){
    //创建地图容器
    china_map =echarts.init(document.getElementById("main"));
    //加载中国地图
    loadChinaMap();
})


//加载中国地图
function loadChinaMap(){
    //中国地图数据
    $.post("http://localhost:8080/Educational_Managerment_System/yiqingController/selectChinaProvinceInfo.ajax",function(data){
        var option = {
            title: {
                text: '新冠型肺炎人口来源分析',
                textStyle:{color:'#fff'},
                //subtext: '纯属虚构',
                x:'center'
            },
            tooltip : {
                trigger: 'item'
            },
            visualMap: {
                show : false,
                x: 'left',
                y: 'bottom',
                //layoutCenter:['30%','30%'],
                splitList: [
                    {start: 0, end:100},{start: 100, end: 300},
                    {start: 300, end: 500},{start: 500, end: 800},
                    {start: 800, end: 1500},{start: 1500, end: 100000},
                ],
                color: ['red', 'yellow', 'Purple','DarkCyan', 'green', 'Lime']
            },
            series: [{
                name: '新冠型肺炎人口来源分析',
                type: 'map',
                mapType: 'china',
                roam: true,
                label: {
                    normal: {
                        show: true
                    },
                    emphasis: {
                        show: false
                    }
                },
                data:data
            }]
        };
        china_map.setOption(option);
    })
}