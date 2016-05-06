$(document).ready(function () {
    $(".delete").click(function () {
        bootbox.dialog({
            message: "Are you sure?",
            title: "Confirm delete",
            buttons: {
                success: {
                    label: "Yes!",
                    className: "btn",
                    callback: function () {
                        document.getElementById("delBtn").click()
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
    });
});
