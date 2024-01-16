
window.onload = () => {
    document.getElementById("list").innerHTML = window.localStorage.getItem("list");
};
var list = document.getElementById("list");
function newElement() {
    var li = document.createElement("li");
    var inputValue = document.getElementById("task").value;
    var t = document.createTextNode(inputValue);
    li.appendChild(t);
    if (inputValue === "" || inputValue === " ") {
        $(".error").toast("show");
    } else {
        $(".success").toast("show");
        document.getElementById("list").appendChild(li);
        window.localStorage.setItem("list", list.innerHTML);
    }
    document.getElementById("task").value = "";
    // var span = document.createElement("span");
    // var txt = document.createTextNode("\u00D7");
    // span.className = "close";
    // span.appendChild(txt);
    // li.appendChild(span);
    //
    // for (i = 0; i < close.length; i++) {
    //   close[i].onclick = function () {
    //     var div = this.parentElement;
    //     div.style.display = "none";
    //   };
    // }
}