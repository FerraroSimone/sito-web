let teamSection = document.querySelector("#team-section");

const team = [
  {
    id: 1,
    name: "Naruto Uzumaki",
    role: "Front-end developer",
    image: "https://pngfre.com/wp-content/uploads/naruto-poster.png",
    social: {
      linkedln: "link",
      gitHub: "link",
    },
  },
  {
    id: 2,
    name: "Naruto Uzumaki",
    role: "Front-end developer",
    image: "https://pngfre.com/wp-content/uploads/naruto-poster.png",
    social: {
      linkedln: "link",
      gitHub: "link",
    },
  },
  {
    id: 3,
    name: "Naruto Uzumaki",
    role: "Front-end developer",
    image: "https://pngfre.com/wp-content/uploads/naruto-poster.png",
    social: {
      linkedln: "link",
      gitHub: "link",
    },
  },
  {
    id: 4,
    name: "Naruto Uzumaki",
    role: "Front-end developer",
    image: "https://pngfre.com/wp-content/uploads/naruto-poster.png",
    social: {
      linkedln: "link",
      gitHub: "link",
    },
  },
  {
    id: 5,
    name: "Naruto Uzumaki",
    role: "Front-end developer",
    image: "https://pngfre.com/wp-content/uploads/naruto-poster.png",
    social: {
      linkedln: "link",
      gitHub: "link",
    },
  },
];

team.map((element) => {
  teamSection.innerHTML += `
    <div
    class="card d-flex flex-column align-items-center p-3  border-0 "
    style="width: 18rem"
    id=${element.id}
  >
    <img
      class="card-img-top rounded-circle border bg-warning border "
      style="width: 12rem"
      src=${element.image}
      alt="Card image cap"
    />
    <div
      class="card-body d-flex flex-column align-items-center justify-content-center"
    >
      <h4 class="card-text">${element.name}</h4>
      <p>${element.role}</p>
    </div>
  </div>
    `;
});
