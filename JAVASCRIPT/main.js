// Show welcome message in console
console.log("Welcome to the Community Portal");

// Sample event data
const events = [
  { name: "Music Fest", date: "2025-06-15", seats: 5, category: "Music" },
  { name: "Yoga Workshop", date: "2025-06-20", seats: 8, category: "Wellness" },
  { name: "Coding Bootcamp", date: "2025-07-01", seats: 10, category: "Tech" },
];

// DOM references
const eventsDiv = document.querySelector("#events");
const eventSelect = document.querySelector('select[name="event"]');

// Render events to the page
function renderEvents() {
  eventsDiv.innerHTML = ""; // Clear existing content
  events.forEach(event => {
    if (new Date(event.date) > new Date() && event.seats > 0) {
      const card = document.createElement("div");
      card.className = "event-card";
      card.textContent = `${event.name} on ${event.date} - ${event.seats} seats left`;
      eventsDiv.appendChild(card);
    }
  });
}

// Populate dropdown options
function populateDropdown() {
  eventSelect.innerHTML = "";
  events.forEach(event => {
    if (new Date(event.date) > new Date() && event.seats > 0) {
      const option = document.createElement("option");
      option.value = event.name;
      option.textContent = event.name;
      eventSelect.appendChild(option);
    }
  });
}

// Handle registration form submit
document.getElementById("registrationForm").onsubmit = function (e) {
  e.preventDefault();
  const form = e.target;
  const name = form.elements.name.value.trim();
  const email = form.elements.email.value.trim();
  const selectedEventName = form.elements.event.value;

  if (!name || !email || !selectedEventName) {
    alert("Please fill out all fields.");
    return;
  }

  const selectedEvent = events.find(ev => ev.name === selectedEventName);
  if (selectedEvent && selectedEvent.seats > 0) {
    selectedEvent.seats--;
    alert(`${name}, you are registered for ${selectedEvent.name}.`);
    renderEvents();
    populateDropdown();
  } else {
    alert("This event is full or unavailable.");
  }
};

// Initial setup
window.onload = () => {
  alert("Page fully loaded");
  renderEvents();
  populateDropdown();
};
