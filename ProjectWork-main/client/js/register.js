let username = document.querySelector('#username');
let userCheck = document.querySelector('#userCheck');

let ruolo = document.querySelector('#ruolo');
let ruoloCheck = document.querySelector('#ruoloCheck');

let email = document.querySelector('#email');
let emailCheck = document.querySelector('#emailCheck');

let password = document.querySelector('#password');
let passwordCheck = document.querySelector('#passwordCheck');

let nome = document.querySelector('#nome');
let nomeCheck = document.querySelector('#nomeCheck')

let cognome = document.querySelector('#cognome');
let cognomeCheck = document.querySelector('#cognomeCheck')

let registraForm = document.querySelector('#registraForm');

const FORMATO_USER = /^[a-zA-Z0-9]{4,15}$/;
const FORMATO_EMAIL = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
const FORMATO_PW = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&#])[A-Za-z\d@$!%*?&]{8,}$/;

function checkUser() {
    if (username.value.length < 4) {
        userCheck.textContent = 'Il tuo username deve contenere almeno 4 caratteri!';
        return false;
    } else if (username.value.length > 15) {
        userCheck.textContent = 'Il tuo username deve contenere meno di 15 caratteri!';
        return false;
    } else if (!username.value.match(FORMATO_USER)) {
        userCheck.textContent = 'Il tuo username può contenere solo lettere e numeri!';
        return false;
    } else {
        userCheck.textContent = '';
        return true;
    }
}

function checkNome(){
    if(nome.value.trim() == ''){
        nomeCheck.textContent = 'Inserisci il nome!'
        return false;
    }  else {
        return true;
    }
}

function checkCognome(){
    if(cognome.value.trim() == ''){
        cognomeCheck.textContent = 'Inserisci il cognome!'
        return false;
    }  else {
        return true;
    }
}

function checkRole() {
    if (ruolo.value !== 'admin' && ruolo.value !== 'user') {
        ruoloCheck.textContent = 'Scegli un ruolo!';
        return false;
    } else {
        ruoloCheck.textContent = '';
        return true;
    }
}

function checkEmail() {
    if (!email.value.match(FORMATO_EMAIL)) {
        emailCheck.textContent = 'Il tuo indirizzo email non è valido!';
        return false;
    } else {
        emailCheck.textContent = '';
        return true;
    }
}

function checkPass() {
    if (password.value.length < 8 || !password.value.match(FORMATO_PW)) {
        passwordCheck.innerHTML = `
            <li>La tua password deve contenere: </li>
            <li>Almeno 8 caratteri</li>
            <li>Almeno una maiuscola</li>
            <li>Almeno una minuscola</li>
            <li>Almeno un numero</li>
            <li>Almeno un carattere speciale</li>`;
        return false;
    } else {
        passwordCheck.innerHTML = '';
        return true;
    }
}

function User(email, password, nome, cognome, ruolo, username) {
    this.email = email;
    this.password = password;
    this.nome = nome;
    this.cognome = cognome
    this.ruolo = ruolo;
    this.username = username;
}

function addUser(event) {
    event.preventDefault();

    let userOk = checkUser();
    let emailOk = checkEmail();
    let passwordOk = checkPass();
    let roleOk = checkRole();
    let nomeOk = checkNome();
    let cognomeOk = checkCognome();

    if (userOk && emailOk && passwordOk && roleOk && nomeOk && cognomeOk) {
        let newUser = new User(email.value, password.value, nome.value, cognome.value, ruolo.value, username.value);

        const URL_UTENTI = 'http://localhost:8080/api/utente/inserisci';

        fetch(URL_UTENTI, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(newUser)
        })
        .then(response => {
            if (!response.ok) {
                throw new Error('Errore nella registrazione dell\'utente: ' + response.statusText);
            }
            return response.json();
        })
        .then(result => {
            console.log('Utente registrato con successo:', result);

            window.location.href = 'login.html';
        })
        .catch(error => {
            console.error('Errore nella richiesta:', error);
        });
    }
}

registraForm.addEventListener('submit', addUser);
