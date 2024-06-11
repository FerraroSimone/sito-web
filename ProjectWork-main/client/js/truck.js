const qS = (element) => document.querySelector(element);
let params = new URL(document.location).searchParams;
let idURL = params.get("id");

let truckDesc = qS("#truck_desc");
let truckImage = qS("#truck_image");
let truckName = qS("#truck_name");
let menuSection = qS("#menu_section");
let pageTitle = qS("#pageTitle");
let mobile = qS("#mobile");
let buyBtn;
let cart = [];

fetch("http://localhost:8080/api/furgoni")
  .then((res) => res.json())
  .then((data) => {
    let isTruckInside = data.find((element) => element.id == idURL);
    if (isTruckInside) {
      populatePage(isTruckInside);
    } else {
      window.location.href = "/client/404.html";
    }
  });

fetch("http://localhost:8080/api/cibo")
  .then((res) => res.json())
  .then((data) => {
    let truckFood = data.filter((truck) => truck.furgoni_id == idURL);
    truckFood.map((element) => createCard(element));
    buyBtn = document.querySelectorAll(".buyBtn");

    addToCart(truckFood);
  });

const createCard = (data) => {
  menuSection.innerHTML += `
    <div class="card d-flex flex-column justify-content-between" style="width: 20rem; height:24rem" id="${
      data.id
    } ">
    <div
      class="d-flex flex-column justify-content-center align-items-center"
    >
      <h2 class="d-block ms-auto p-2">${data.prezzo.toFixed(2)}€</h2>
      <img
        src= "${data.immagine}"
        class="card-img-top w-50"
        alt="image food"
        style= "width: "5rem; height: 5rem"
      />
    </div>
    <div class="d-flex p-3 ">
      <div class="d-flex flex-column">
        <h5 class="card-title my-4">${data.nome}</h5>
        <p class="card-text">
      ${data.descrizione.split(" ").slice(0, 10).join(" ")} ...
        </p>
      </div>
      <button class="btn btn-warning d-block mt-auto buyBtn" id="${data.id}"
        ><i class="fa-solid fa-cart-shopping"></i
      ></button>
    </div>
  </div>
    `;
};

const populatePage = (data) => {
  pageTitle.textContent = data.nome;
  truckName.textContent = data.nome;
  truckDesc.textContent = data.descrizione;
  truckImage.src = data.immagine;
  mobile.textContent = `+39 ${data.n_telefono}`;
};

const addToCart = (data) => {
  [...buyBtn].forEach((btn) => {
    btn.addEventListener("click", (e) => {
      let cartObj = data.find((elementArray) => elementArray.id == btn.id);
      let existingItem = cart.find((item) => item.id == cartObj.id);

      if (existingItem) {
        existingItem.amount += 1;
      } else {
        cartObj.amount = 1;
        cart.push(cartObj);
      }

      console.log(cart);
      localStorage.setItem("Cart", JSON.stringify(cart));
    });
  });
};