$(function () {
    appendApplyList("apply");
});

function appendApplyList(url){
    var userName = $("#currentUserName").text();
    console.info(userName);
    $("#jiazai").show();
    $.ajax({
        type:'POST',
        dataType:'html',
        url:'apply/list',
        data:{'type':url,'userName':userName},
        success:function (data) {
            $("#jiazai").hide();
            $("#applyList").html(data);
        }
    })
};
function apply(url){
    appendApplyList(url);
};

function startApply() {
    var userName = $("#currentUserName").text();
    window.location.href="apply/startApply?userName="+userName;
}