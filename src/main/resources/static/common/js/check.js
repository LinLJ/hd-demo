function clickCheck() {
    var checkName = $("#currentUser").text();
    var instId = $("#instId").text();
    var nextCheckName = $("#nextCheckName").val();

    $("#jiazai").show();

    debugger
    $.ajax({
        type:'POST',
        url:'clickCheck',
        data:{'instId':instId,'checkName':checkName,"nextCheckName":nextCheckName},
        success:function () {
            $("#jiazai").hide();
            window.location.href="/clickLogin?userName="+checkName;
        }
    })
}