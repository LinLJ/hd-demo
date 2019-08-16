function login(){
    var userName = $("#userName").val();
    window.location.href="clickLogin?userName="+userName;
}