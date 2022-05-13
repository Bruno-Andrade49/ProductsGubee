function getAPI(url) {
    let request = new XMLHttpRequest();
    request.open("GET", url, false);
    request.send();
    return request.responseText;
}

function criarLinha(produto) {
    linha = document.createElement("tr");
    tdNomeProduct = document.createElement("td");
    tdDescription = document.createElement("td");
    tdTargetMarket = document.createElement("td");
    tdStack = document.createElement("td");

    tdNomeProduct.innerHTML = produto.productName
    tdDescription.innerHTML = produto.description
    tdTargetMarket.innerHTML = produto.targetMarket
    tdStack.innerHTML = produto.stack

    linha.appendChild(tdNomeProduct);
    linha.appendChild(tdDescription);
    linha.appendChild(tdTargetMarket);
    linha.appendChild(tdStack);

    return linha;
}

function main() {
    let data = getAPI("http://localhost:8080/produto/listagem")
    let usuarios = JSON.parse(data);

    console.log(usuarios)

    let tabela = document.getElementById("tabela");

    usuarios.forEach(element => {
        let linha = criarLinha(element);
        tabela.appendChild(linha);
    });
}


document.getElementById("btn1").addEventListener("click", PesquisarStack);

document.getElementById("btn2").addEventListener("click", PesquisarMarketPlace);


function PesquisarStack() {  

    let input = document.getElementById("Busca");
    let filtro = input.value.toUpperCase();
    
    let tabela = document.getElementById("tabela");

    let tr = tabela.getElementsByTagName("tr");

    for(i = 1; i < tr.length; i++) {
        td = tr[i].getElementsByTagName('td')[3];
        if (td.innerHTML.toUpperCase().indexOf(filtro) > -1) {
            console.log(tr[i])
            tr[i].style.display = "";
            } else { 
            tr[i].style.display ="none";
            }
        }
    }

    function PesquisarMarketPlace() {  

        let input = document.getElementById("Busca2");
        let filtro = input.value.toUpperCase();
        
        let tabela = document.getElementById("tabela");
    
        let tr = tabela.getElementsByTagName("tr");
    
        for(i = 1; i < tr.length; i++) {
            td = tr[i].getElementsByTagName('td')[2];
            if (td.innerHTML.toUpperCase().indexOf(filtro) > -1) {
                console.log(tr[i])
                tr[i].style.display = "";
                } else { 
                tr[i].style.display ="none";
        }
    }
}



main();





