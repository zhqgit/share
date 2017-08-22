/**
 * Created by ZHQ on 2017/8/17.
 */
var vm = new Vue({
    el: '#app',
    data: {
        name: '卜冠今',
        isActive: '关注'
    },
    mounted: function () {

    },
    methods: {
        active: function (e) {
            var e = e.target || e.srcElement;
            console.log(e);
            console.log(e.title);
            this.isActive = e.title;
        }
    }
})