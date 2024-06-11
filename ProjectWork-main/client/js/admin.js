const qS = (element) => document.querySelector(element);
const Utente = JSON.parse(localStorage.getItem("Utente"));
let nomeUtenteInAlto = document.querySelector('#nomeUtente');

let btnLogout = document.querySelector('#logoutBtn');

btnLogout.addEventListener('click', function(){
  localStorage.removeItem('Utente');
  window.location.href = 'index.html';
});


nomeUtenteInAlto.textContent = Utente.username ;

let dashContent = qS("#dashboar_content");
let productsBtn = qS("#btn_prodotti");
let ordersBtn = qS("#btn_ordini");
let trucksBtn = qS("#btn_trucks");
let addBtn = qS("#addBtn");

let arrayBtn = [productsBtn, ordersBtn, trucksBtn];
let endpoint;
addBtn.classList.add("d-none");

const handleClick = async (btn) => {
  if (btn == trucksBtn) {
    endpoint = "furgoni";
  } else if (btn == productsBtn) {
    endpoint = "cibo";
  } else if (btn == ordersBtn) {
    endpoint = "ordini";
  }

  try {
    const response = await fetch(`http://localhost:8080/api/${endpoint}`);
    const data = await response.json();
    fillContainer(btn, data);
  } catch (error) {
    console.error("Errore durante il fetch:", error);
  }
};

arrayBtn.forEach((btn) => {
  btn.addEventListener("click", () => handleClick(btn));
});

const fillContainer = (btn, data) => {
  dashContent.innerHTML = "";

  if (data.length <= 0) {
    dashContent.innerHTML =
      '<p class= "p-4"> Non ci sono elementi da visualizzare</p>';
    if (btn == trucksBtn) {
      trucksBtn.classList.add("selected");
      ordersBtn.classList.remove("selected");
      productsBtn.classList.remove("selected");
    } else if (btn == productsBtn) {
      trucksBtn.classList.remove("selected");
      ordersBtn.classList.remove("selected");
      productsBtn.classList.add("selected");
    } else if (btn == ordersBtn) {
      trucksBtn.classList.remove("selected");
      ordersBtn.classList.add("selected");
      productsBtn.classList.remove("selected");
    }
  } else {
    data.map((element) => {
      if (btn == trucksBtn) {
        trucksBtn.classList.add("selected");
        ordersBtn.classList.remove("selected");
        productsBtn.classList.remove("selected");
        addBtn.classList.remove("d-none");

        dashContent.innerHTML += `
            <div class="card text-center align-items-center" style="width: 18rem"> 
              <img src="${element.immagine}" class="card-img-top img-fluid" alt="${element.nome}" style="width: 240px; height: 140px;" />
              <div class="card-body">
                <h5 class="card-title text-center">${element.nome}</h5>
                <p class="card-text text-center">
                  
                </p>
                <a href="./truck.html?id=${element.id}" class="btn btn-warning text-center fw-bold" id="btnVai">Elimina</a>
              </div>
            </div>
    `;
      } else if (btn == productsBtn) {
        trucksBtn.classList.remove("selected");
        ordersBtn.classList.remove("selected");
        productsBtn.classList.add("selected");
        addBtn.classList.add("d-none");

        dashContent.innerHTML += `
          <div class="card d-flex flex-column justify-content-between " style="width: 20rem; height:24rem" id="${
            element.id
          }">
          <div
            class="d-flex flex-column justify-content-center align-items-center"
          >
            <h2 class="d-block ms-auto p-2">${element.prezzo.toFixed(2)}€</h2>
            <img
              src= "${element.immagine}"
              class="card-img-top w-50"
              alt="image food"
              style= "width: 50px; height: 140px;"
            />
          </div>
          <div class="d-flex p-1">
            <div class="d-flex flex-column">
              <h5 class="card-title my-2">${element.nome}</h5>
              <p class="card-text">
              ${element.descrizione.split(" ").slice(0, 10).join(" ")} ...
              </p>
            </div>
            <button class="btn btn-warning d-block mt-auto"
              ><i class="fa-solid fa-trash"></i
            ></button>
          </div>
        </div>
        
          `;
      } else if (btn == ordersBtn) {
        trucksBtn.classList.remove("selected");
        ordersBtn.classList.add("selected");
        productsBtn.classList.remove("selected");
        addBtn.classList.add("d-none");
      }
    });
  }
};

const onHandleOpenModal = () => {
  document.body.innerHTML += `<!-- Button trigger modal -->
  <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModalCenter">
    Launch demo modal
  </button>
  
  <!-- Modal -->
  <div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="exampleModalLongTitle">Modal title</h5>
          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">&times;</span>
          </button>
        </div>
        <div class="modal-body">
          ...
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
          <button type="button" class="btn btn-primary">Save changes</button>
        </div>
      </div>
    </div>
  </div>`;
};
