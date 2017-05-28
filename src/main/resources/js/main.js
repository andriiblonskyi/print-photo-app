function test()
{

}

function instagram_selected() {
    var html = titleController.instagramSelected();
    document.getElementsByTagName('body')[0].innerHTML = html;
    titleController.addVkListener();
}

function login() {
    var inputsList = document.getElementsByClassName('input');

    var res = loginController.authorizeInstagram(inputsList.length,inputsList.length);

}

function basket() {

}