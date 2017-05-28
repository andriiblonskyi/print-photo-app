function search()
{
    var value = document.getElementById('solologininput').innerHTML;
    var result = loginController.findUserByName(value);
    var json = JSON.parse(result);
    document.getElementsByTagName('body')[0].innerHTML = json["html"];
    document.getElementsByTagName('body')[0].background="";
}

function insta_left_search() {

}

function insta_right_search() {
    var result = mainController.getMedia();
    var json = JSON.parse(result);
    document.getElementsByClassName("container")[0].innerHTML = json["html"];

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

function test() {
    document.getElementsByTagName('body')[0].innerHTML = "hello";
}

function basket() {

}