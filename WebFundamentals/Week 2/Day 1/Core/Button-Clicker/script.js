
function Addlogout(element) {
    if (element.innerText === "login") {
    element.innerText = "logout";
    } else {
    element.innerText = "login";
    }
}

function AddRemove() {
    var button= document.getElementById("hide-button")
button.remove();

}
var count1=0
function Addlikes(){
var likes=document.querySelector("#like1");
    likes.innerText++;
}
