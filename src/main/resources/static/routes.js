function controleRotasGet(url){
    switch(url){
        case "/logout":
            gerarSwal(url);
            break;
        default:
            $.get(url,function(data){
                $(".container").html(data);
            });
    }
}