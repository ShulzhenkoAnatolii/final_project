function runFilter() {
        var checkboxes = document.getElementsByClassName('form-check-input');
        var url = [[${url}]];
        var key = false;
        for (var i = 0; i < checkboxes.length; i++) {
            if (checkboxes[i].checked) {
                if (key == false) url = url + '&vaccine=';
                key = true;
                url = url + checkboxes[i].id + ",";
            }
        }
        if (url.charAt(url.length - 1) == ','){
            url = url.slice(0, -1);
        }
        document.location.href = url;
    }