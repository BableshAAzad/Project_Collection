var inValues = "";
let val = document.getElementById("disp");

function oneClick() {
    inValues += 1;
    val.innerHTML = inValues;
}
function twoClick() {
    inValues += 2;
    val.innerHTML = inValues;
}
function threeClick() {
    inValues += 3;
    val.innerHTML = inValues;
}
function fourClick() {
    inValues += 4;
    val.innerHTML = inValues;
}
function fiveClick() {
    inValues += 5;
    val.innerHTML = inValues;
}
function sixClick() {
    inValues += 6;
    val.innerHTML = inValues;
}
function sevenClick() {
    inValues += 7;
    val.innerHTML = inValues;
}
function eightClick() {
    inValues += 8;
    val.innerHTML = inValues;
}
function nineClick() {
    inValues += 9;
    val.innerHTML = inValues;
}
function zeroClick() {
    inValues += 0;
    val.innerHTML = inValues;
}
// ~-------------------------------
function pluseClick(ele) {
    inValues += "+";
    val.innerHTML = inValues;
    return ele;
}
function minusClick() {
    inValues += "-";
    val.innerHTML = inValues;
}
function muxClick() {
    inValues += "*";
    val.innerHTML = inValues;
}
function perceClick() {
    inValues += "%";
    val.innerHTML = inValues;
}
function modulusClick() {
    inValues += "/";
    val.innerHTML = inValues;
}
function backClick() {
    let temp = inValues.slice(0, inValues.length - 1);
    val.innerHTML = temp;
    inValues = temp;
}
function allClearedClick() {
    val.innerHTML = "";
    inValues = "";
}
// ^  final result
function equalToClick() {
    try {
        let result = eval(inValues);
        val.innerHTML = result;
        inValues = result;
    } catch (error) {
       alert(error);
    }
}