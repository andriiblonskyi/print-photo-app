function test()
{
    var element = document.getElementById("test");
    element.innerHTML = "New Header";
    testController.testOut("Hello");
}

function login() {
    var res = loginController.authorizeInstagram("fdsf","fsfsgf");
    var element = document.getElementById("test");
    element.innerHTML = res;
}
