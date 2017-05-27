function test()
{
    alert('Hello');
    var element = document.getElementById("test");
    element.innerHTML = "New Header";
    testController.testOut("Hello");
}
