let loginForm = document.querySelector("#loginForm");

loginForm.addEventListener("submit", login);

function login(event) {
    event.preventDefault();

    let emailInput = document.querySelector("#email");
    let passwordInput = document.querySelector("#password");

    let email = emailInput.value.trim();
    let password = passwordInput.value.trim();

    fetch("http://localhost:8080/api/utente/verifica", {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify({ email: email, password: password }),
    })
    .then((response) => {
        if (!response.ok) {
            throw new Error("Credenziali non valide");
        }
        return response.json();
    })
    .then((result) => {
        if (result.exists) {
            console.log("Login avvenuto con successo:", result);
            localStorage.setItem("Utente", JSON.stringify(result.utente));
            window.location.href = "index.html";
        } else {
            alert("Email o password errati!");
        }
    })
    .catch((error) => {
        console.error("Errore:", error);
        alert("Email o password errati!");
    });
}
