/**
 * Created by ZHQ on 2017/8/17.
 */
var vm = new Vue({
    el: '#app',
    data: {
        name: '卜冠今',
        isActive: '资源',
        noActive: false
    },
    mounted: function () {
        $.ajax({
            type: 'GET',
            url: './data/person_res.json',
            dataType: 'json',
            success: function (data) {
                if(data){
                    console.log(data);
                }
            },
            error: function (jqXHR) {
                alert("发生错误：" + jqXHR.status);
            }
        });
    },
    methods: {
        active: function (e) {
            var e = e.target || e.srcElement;
            console.log(e);
            console.log(e.title);
            this.isActive = e.title;
        }
    }
});