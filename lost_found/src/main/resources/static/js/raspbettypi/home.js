
function lost() {

    console.info("lost");

    init();

}

function found() {

    console.info("found");

}
function show(i) {
    alert(i);
}
function init() {
    var html1="";
    var keyBoardId="jia";
    html1+="<div id='"+keyBoardId+"' class='auth_keybord'>"
        +"<div id='auth_keybord_exit' class='auth_keybord_exit'>关闭</div>"
        +"<div id='auth_keybord_menu' class='auth_keybord_menu'></div>"
        +"<div>"
        +"<ul  id='number_list'>"


    html1+="<li>"
    var bian=3
    for(var i=0;i<=9;i++){
        if(i==bian){
            html1+="</li><li>"
            bian+=3;
        }
        html1+="<button class='col-lg-4' type='button' onclick='show("+i  +")'>"+i+"</button>"
    }
    html1+="<button type='submit'>清除</button>"
    +"<button type='submit'>退格</button></li>"
    +"</ul></div></div>";

    console.info(html1);
    console.info($("#keywo").html());

    $("#keywo").html(html1);

}
