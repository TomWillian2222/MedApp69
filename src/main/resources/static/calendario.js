let dataCalendario = new Date();
let dataSelecionada = new Date();

$(document).ready(function(){
    createCalendar(dataCalendario);

    $("#next-month").click(function(){
        atualizaCalendario(1);
    });

    $("#previous-month").click(function(){
        atualizaCalendario(-1);
    });
});

function atualizaCalendario(att){
    dataCalendario.setMonth(dataCalendario.getMonth()+(att));
    createCalendar(dataCalendario);
}

function createCalendar(data){
    data.setHours(0,0,0,0);
    dataSelecionada.setHours(0,0,0,0);

    let dataAtual = new Date();
    dataAtual.setHours(0,0,0,0);

    let dataInicio = new Date(data);
    dataInicio.setDate(1);
    if(dataInicio.getDay() !== 0){
        dataInicio.setDate((dataInicio.getDay() * -1)+1);
    }

    let dataFim = new Date(data.getFullYear(),data.getMonth()+1,0);

    if(dataFim.getDay() !== 6){
        dataFim.setDate(dataFim.getDate() + (6 - dataFim.getDay()));
    }

    imprimeCabecalhoCalendario(data);
    imprimeDatasCalendario(new Date(dataInicio),dataFim,data);

    atualizaDataAtividades();
    ativarClickCalendario();
}