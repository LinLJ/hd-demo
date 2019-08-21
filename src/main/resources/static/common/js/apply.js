function clickApply(){
    var userName = $("#userName").text();
    var reason = $("#reason").val();
    var checkName = $("#checkName").val();
    var suggest = $("#suggest").val();
    $("#jiazai").show();
    $.ajax({
        type:'POST',
        url:'clickApply',
        data:{'userName':userName,'reason':reason,'checkName':checkName,'suggest':suggest},
        success:function () {
            $("#jiazai").hide();
            window.location.href="/clickLogin?userName="+userName;
        }
    })
};