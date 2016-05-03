$("#login").keyup(function () {
    $("#status").html('<img src="images/loader.gif" width="16" height="16" align="absmiddle">&nbsp;Checking availability...');
    $.ajax({
        type: "GET",
        url: 'check_login_exist.action?userName=' + $("#login").val(),
        dataType: 'text',
        success: function (data) {
            if ('exist' === data) {
                $("#status").html('<img src="images/cross.png" width="16" height="16" align="absmiddle">&nbsp;User with this login already exist');
            }
        },
        error: function () {
            alert("Abnormal！");
        }
    });
    if ($("#login").val().length > 3)
        $("#status").html('<img src="images/tick.png" width="16" height="16" align="absmiddle">&nbsp;You can use this login');
    else
        $("#status").html('<img src="images/cross.png" width="16" height="16" align="absmiddle">&nbsp;Login should be longer than 3 characters');
});
$("#repeatPassword").keyup(function () {
    if ($("#repeatPassword").val() !== $("#password").val())
        $("#passwordStatus").html('<img src="images/cross.png" width="16" height="16" align="absmiddle">&nbsp;Passwords doesnt match');
    else {
        $("#passwordStatus").html('<img src="images/tick.png" width="16" height="16" align="absmiddle">&nbsp;Passwords matches');
    }
});