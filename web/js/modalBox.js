function deleteItem(obj) {
    bootbox.dialog({
        message: "Are you sure?",
        title: "Confirm delete",
        buttons: {
            success: {
                label: "Yes!",
                className: "btn",
                callback: function () {
                    var adr = "delBtn" + obj.getAttribute('atr');
                    document.getElementById(adr).click()
                }
            },
            danger: {
                label: "No!",
                className: "delete",
                callback: function () {
                }
            },
        }
    });
};
