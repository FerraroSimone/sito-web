let cardsDiv = document.querySelector("#cardsDiv");

const URLFURGONI = "http://localhost:8080/api/furgoni";
fetch(URLFURGONI)
  .then(function (response) {
    return response.json();
  })

  .then(function (data) {
    cards(data);
  });

function cards(data) {
  data.forEach((data) => {
    let descrizioneCards = `
        <div class="col">
            <div class="card text-center align-items-center"> 
              <img src="${data.immagine}" class="card-img-top img-fluid" alt="${data.nome}" style="width: 240px; height: 140px;" />
              <div class="card-body">
                <h5 class="card-title text-center">${data.nome}</h5>
                <p class="card-text text-center">
                  Numero: ${data.n_telefono}
                </p>
                <a href="./truck.html?id=${data.id}" class="btn btn-warning text-center fw-bold" id="btnVai">Prenota da loro!</a>
              </div>
            </div>
        </div>   
    `;
    cardsDiv.innerHTML += descrizioneCards;
  });
}
