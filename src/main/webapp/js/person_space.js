window.onload = function() {
    function ajax() {
        var ajaxData = {
            type: arguments[0].type || "GET",
            url: arguments[0].url || "",
            async: arguments[0].async || "true",
            data: arguments[0].data || null,
            dataType: arguments[0].dataType || "text",
            contentType: arguments[0].contentType || "application/x-www-form-urlencoded",
            beforeSend: arguments[0].beforeSend || function() {},
            success: arguments[0].success || function() {},
            error: arguments[0].error || function() {}
        };
        ajaxData.beforeSend();
        var xhr = createxmlHttpRequest();
        xhr.responseType = ajaxData.dataType;
        xhr.open(ajaxData.type, ajaxData.url, ajaxData.async);
        xhr.setRequestHeader("Content-Type", ajaxData.contentType);
        xhr.send(convertData(ajaxData.data));
        xhr.onreadystatechange = function() {
            if (xhr.readyState == 4) {
                if (xhr.status == 200) {
                    ajaxData.success(xhr.response);
                } else {
                    ajaxData.error();
                }
            }
        };
    }

    function createxmlHttpRequest() {
        if (window.ActiveXObject) {
            return new ActiveXObject("Microsoft.XMLHTTP");
        } else if (window.XMLHttpRequest) {
            return new XMLHttpRequest();
        }
    }

    function convertData(data) {
        if (typeof data === 'object') {
            var convertResult = "";
            for (var c in data) {
                convertResult += c + "=" + data[c] + "&";
            }
            convertResult = convertResult.substring(0, convertResult.length - 1);
            return convertResult;
        } else {
            return data;
        }
    }


    ajax({
        type: "GET",
        url: "data/data.json",
        dataType: "json",
        beforeSend: function() {
            //some js code
        },
        success: function(msg) {
            console.log("haha");
            console.log(msg);
            console.log(msg.personal);
            var personalTitle = document.getElementById('personal-title');
            console.log(personalTitle);
            console.log(personalTitle.children);
            console.log(typeof personalTitle.children);

            console.log(personalTitle.children[0].innerHTML);

            personalTitle.children[0].innerHTML = msg.personal.name;
            personalTitle.children[1].innerHTML = msg.personal.intro;

            // 获取ul
            var actives = document.getElementById('actives');

            console.log(actives);
            // console.log(actives.children);
            // console.log(actives.children[0]);
            // console.log(actives.children[0].children[0].innerHTML);


            // actives.children[0].children[0].innerHTML = msg.personal.actives[0].title;
            // actives.children[0].children[1].innerHTML = msg.personal.actives[0].content;
            // console.log(msg.personal.actives[0]);



            for (var i = 0; i < msg.personal.actives.length; i++) {
                var li = document.createElement('li');
                var h1 = document.createElement('h1');
                var p = document.createElement('p');

                li.append(h1);
                li.append(p);

                actives.append(li);
            }

            if (actives.children) {
                for (var j = 0; j < msg.personal.actives.length; j++) {
                    actives.children[j].children[0].innerHTML = msg.personal.actives[j].title;
                    actives.children[j].children[1].innerHTML = msg.personal.actives[j].content;
                }
            }













        },
        error: function() {
            console.log("error");
        }
    });
};
