function hello() {
    console.log("Hello!")
    alert("GAST!")
}

console.log("JO.")

// Show the modal after 1 seconds
setTimeout(() => {
    const modal = new bootstrap.Modal(document.getElementById('exampleModal'));
    modal.show();
}, 1000);
