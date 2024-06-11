const header = document.querySelector("#header");
const footer = document.querySelector(".footer");

const user = JSON.parse(localStorage.getItem("Utente"));


if (user && user.ruolo === "admin") {
    header.innerHTML = `
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
      <div class="container-fluid">
        <a class="navbar-brand" href="./index.html">
          <img src="./img/Take_Away-removebg-preview.png" alt="Logo" width="50" height="50" />
        </a>
        <button
          class="navbar-toggler"
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="#navbar123"
          aria-controls="navbar123"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbar123">
          <ul class="navbar-nav ms-auto mb-2 mb-lg-0 align-items-center justify-content-center text-center">
            <li class="nav-item">
              <a class="nav-link text-decoration-none" href="./index.html">Home</a>
            </li>
            <li class="nav-item">
              <a class="nav-link text-decoration-none" href="./chiSiamo.html">Chi Siamo</a>
            </li>
            <li class="nav-item">
              <a class="nav-link text-decoration-none" href="./index.html#takeAway">Take Away</a>
            </li>
            <li class="nav-item">
              <a class="nav-link text-decoration-none" href="./admin.html">Modifica</a>
            </li>
            <li class="nav-item">
              <button type="button" id="btnLogout" class="btn btn-link nav-link">Logout</button>
            </li>
            <li class="nav-item d-flex text-center align-items-center justify-content-center me-md-3">
            <p class="text-center mb-0 text-white fw-bold" style="font-size: 18px;">@${user.username}</p>
            </li>
          </ul>
        </div>
      </div>
    </nav>
    `;
} else if (user && user.ruolo === "User") {
    header.innerHTML = `
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
      <div class="container-fluid">
        <a class="navbar-brand" href="./index.html">
          <img src="./img/Take_Away-removebg-preview.png" alt="Logo" width="50" height="50" />
        </a>
        <button
          class="navbar-toggler"
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="#navbar123"
          aria-controls="navbar123"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbar123">
          <ul class="navbar-nav ms-auto mb-2 mb-lg-0 align-items-center">
            <li class="nav-item">
              <a class="nav-link text-decoration-none" href="./index.html">Home</a>
            </li>
            <li class="nav-item">
              <a class="nav-link text-decoration-none" href="./chiSiamo.html">Chi Siamo</a>
            </li>
            <li class="nav-item">
              <a class="nav-link text-decoration-none" href="./index.html#takeAway">Take Away</a>
            </li>
            <li class="nav-item">
              <button type="button" id="btnLogout" class="btn btn-link nav-link">Logout</button>
            </li>
            <li class="nav-item d-flex text-center align-items-center justify-content-center me-md-3">
            <p class="text-center mb-0 text-white fw-bold" style="font-size: 18px;">@${user.username}</p>
            </li>
          </ul>
        </div>
      </div>
    </nav>
    `;
} else {
    header.innerHTML = `
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
      <div class="container-fluid">
        <a class="navbar-brand" href="./index.html">
          <img src="./img/Take_Away-removebg-preview.png" alt="Logo" width="50" height="50" />
        </a>
        <button
          class="navbar-toggler"
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="#navbar123"
          aria-controls="navbar123"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbar123">
          <ul class="navbar-nav ms-auto mb-2 mb-lg-0 align-items-center">
            <li class="nav-item">
              <a class="nav-link text-decoration-none" href="./index.html">Home</a>
            </li>
            <li class="nav-item">
              <a class="nav-link text-decoration-none" href="./chiSiamo.html">Chi Siamo</a>
            </li>
            <li class="nav-item">
              <a class="nav-link text-decoration-none" href="./index.html#takeAway">Take Away</a>
            </li>
            <li class="nav-item">
              <a class="nav-link text-decoration-none" href="./login.html">Login</a>
            </li>
          </ul>
        </div>
      </div>
    </nav>
    `;
}

footer.innerHTML = `  
<div class="container">     
  <div class="row">                       
    <div class="col-lg-4 col-sm-4 col-xs-12">
      <div class="single_footer">
        <h4>PRIVACY E POLICY</h4>
        <ul>
          <li><a href="#">Condizioni di utilizzo</a></li>
          <li><a href="#">Informativa sulla privacy</a></li>
          <li><a href="#">Informativa sui cookie</a></li>
          <li><a href="#">Community Rules</a></li>
          <li><a href="#">Dichiarazione di responsabilità</a></li>
        </ul>
      </div>
    </div> 
    <div class="col-md-4 col-sm-4 col-xs-12">
      <div class="single_footer single_footer_address">
        <h4>COLLEGAMENTI</h4>
        <ul>
          <li><a href="../index.html">Home</a></li>
          <li><a href="../chiSiamo.html">Chi siamo</a></li>
          <li><a href="../register.html">Login</a></li>
        </ul>
      </div>
    </div>
    <div class="col-md-4 col-sm-4 col-xs-12">
      <div class="single_footer single_footer_address">
        <h4>Subscribe today</h4>
        <div class="signup_form">                           
          <form action="#" class="subscribe">
            <input type="text" class="subscribe__input" placeholder="Enter Email Address">
            <button type="button" class="subscribe__btn"><i class="fas fa-paper-plane"></i></button>
          </form>
        </div>
      </div>
      <div class="social_profile">
        <ul>
          <li><a href="#"><i class="fab fa-facebook-f"></i></a></li>
          <li><a href="#"><i class="fab fa-twitter"></i></a></li>
          <li><a href="#"><i class="fab fa-google-plus-g"></i></a></li>
          <li><a href="#"><i class="fab fa-instagram"></i></a></li>
        </ul>
      </div>                          
    </div>        
  </div>
  <div class="row">
    <div class="col-lg-12 col-sm-12 col-xs-12">
      <p class="copyright">Copyright © 2024 - Project work team 3</p>
    </div>                
  </div>                
</div>
`;


let btnLogout = document.querySelector('#btnLogout');
btnLogout.addEventListener('click', function() {
    localStorage.removeItem('Utente');
    window.location.href = 'index.html';
});
