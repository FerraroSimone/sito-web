document.addEventListener('DOMContentLoaded', function() {

    const URL_ORDINI = 'http://localhost:8080/api/ordini';
    const URL_ORDINI_DET = 'http://localhost:8080/api/ordinidettaglio/array';
    

    const mainContainer = document.querySelector('#mainContainer');
    const contenitoreRiepilogo = document.querySelector('#contenitoreRiepilogo');
    const TotaleRiepilogo = document.querySelector('#totale');
    

    let prodottiScelti = JSON.parse(localStorage.getItem("Cart")) || [];
    let totaleOrdine = 0;

    function renderCart() {
        const descrizioneMain = `
            <div class="d-flex justify-content-between align-items-center">
                <h1 class="text-center">Il Tuo Carrello</h1>
                <small id="oggettiCount" class="text-center"></small>
            </div>
            <div class="d-flex justify-content-end">
                <button class="btn btn-warning fw-bold" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasRight" aria-controls="offcanvasRight">
                  Riepilogo
                </button>
            </div>
            <hr>
            <div id="carrelloProdotti"></div>
        `;
        mainContainer.innerHTML = descrizioneMain;

        aggiornaCarrello();
    }


    function aggiornaCarrello() {
        const carrelloProdotti = document.querySelector('#carrelloProdotti');
        let riepilogo = '';
        totaleOrdine = 0; 
        carrelloProdotti.innerHTML = '';

        prodottiScelti.forEach((element, index) => {
            const descrizioneCarrello = `
                <div class="d-flex container justify-content-center align-items-center prodotto-carrello" data-index="${index}">
                    <img class="col-md-2 col-12 d-flex justify-content-center align-items-center me-5 immagine" src="${element.immagine}"></img>
                    <div class="col-md-3 col-8">
                        <h3>${element.nome}</h3>
                    </div>
                    <div class="col-md-6 col-4">
                        <div class="d-flex align-items-center">
                            <button class="btn decrement" data-index="${index}">-</button>
                            <input class="text-center input" style="width: 50px;" type="number" min="1" value="${element.amount}" readonly>
                            <button class="btn increment" data-index="${index}">+</button>
                        </div>
                    </div>
                    <div class="col-md-1 col-1">
                        <small>€${element.prezzo.toFixed(2)}</small>
                    </div>
                </div>
                <hr>
            `;
            carrelloProdotti.innerHTML += descrizioneCarrello;

            const descrizioneRiepilogo = `
                <div class="container d-flex justify-content-between align-items-center">
                    <h6 class="text-center col-3">${element.nome}</h6>
                    <h5 class="text-center col-3">${element.amount}</h5>
                    <h5 class="text-center col-3">€${(element.prezzo * element.amount).toFixed(2)}</h5>
                </div>
                <hr>
            `;
            riepilogo += descrizioneRiepilogo;

            totaleOrdine += element.prezzo * element.amount;
        });

        contenitoreRiepilogo.innerHTML = riepilogo;
        TotaleRiepilogo.innerHTML = `
            <div class="d-flex justify-content-between align-items-center text-center">
                Totale: <span id="totaleOrdine">€${totaleOrdine.toFixed(2)}</span>
            </div>
        `;
        localStorage.setItem("Cart", JSON.stringify(prodottiScelti));
        document.getElementById('oggettiCount').textContent = `Oggetti: ${prodottiScelti.length}`;
    }


    function DettaglioOrdine(cibo_id, ordini_id, quantita, prezzo){
        this.cibo_id = cibo_id
        this.ordine_id = ordini_id
        this.quantita = quantita
        this.prezzo = prezzo
    }

    
    function confermaOrdine() {
        const user = JSON.parse(localStorage.getItem("Utente"));

        if(user) {
            
            const d = new Date();
            let text = d.toISOString();
            const ordine = { utenti_id: user.id, data: text };

            fetch(URL_ORDINI, {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(ordine)
            })
            .then(response => {
                if (!response.ok) {
                    throw new Error('Errore nella registrazione dell\'ordine: ' + response.statusText);
                }
                return response.json();
            })
            .then(ordine => {
                console.log('Ordine registrato con successo:', ordine);

                const ordine_id = ordine.id;
                const cart = prodottiScelti.map(element => new DettaglioOrdine(element.id, ordine_id, element.amount, (element.prezzo * element.amount)));

                fetch(URL_ORDINI_DET, {
                    method: 'POST',
                    headers: { 'Content-Type': 'application/json' },
                    body: JSON.stringify(cart)
                })
                .then(response => {
                    if (!response.ok) {
                        throw new Error('Errore nella registrazione dell\'cart: ' + response.statusText);
                    }
                    return response.json();
                })
                .then(cart => {
                    console.log('Ordine registrato con successo:', cart);

                    localStorage.removeItem('Cart');
                    alert('Ordine Registrato!');
                    window.location.href = 'index.html';
                })
                .catch(error => {
                    console.error('Errore nella richiesta:', error);
                });
            })
            .catch(error => {
                console.error('Errore nella richiesta:', error);
            });
        } else {
            alert("Devi effettuare il login per procedere con l'ordine");
        }
    }

   
    mainContainer.addEventListener('click', (event) => {
        if (event.target.classList.contains('decrement')) {
            let index = event.target.getAttribute('data-index');
            prodottiScelti[index].amount--;
            if (prodottiScelti[index].amount < 1) {
                prodottiScelti.splice(index, 1);
            }
            aggiornaCarrello();
            updateCartIcon();
        } else if (event.target.classList.contains('increment')) {
            let index = event.target.getAttribute('data-index');
            prodottiScelti[index].amount++;
            aggiornaCarrello();
            updateCartIcon();
        }
    });

    
    document.getElementById('prenotaButton').addEventListener('click', confermaOrdine);

    
    renderCart();
});
