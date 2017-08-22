/**
 * Created by ZHQ on 2017/8/15.
 */
$(document).ready(function () {
    $.ajax({
        type: 'GET',
        url: './data/index.json',
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
});