function test()
{

}

function instagram_selected() {
    titleController.instagramSelected();
}

function login() {
    var res = loginController.authorizeInstagram("fdsf","fsfsgf");
    var element = document.getElementById("test");
    element.innerHTML = res;
}
