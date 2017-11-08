/**
 * Created by Administrator on 2017/11/8 0008.
 */

function init(){

    
}
function getImg() {

}
function flushQr() {
   // alert("ok");
    var src=$("#imgflu").attr("src");

    var shu=100*Math.random();
    if(src!="./getone") {
        $("#imgflu").attr("src", "./getone"+"?time"+shu);
    }else {
        $("#imgflu").attr("src", "./getflush"+"?time"+shu);
    }
    console.info("daozhe");
}

function getYanZhengCode() {
    var shu=100*Math.random();
    $("#imgs").attr("src", "./yanzhengCode"+"?time="+shu);
}
