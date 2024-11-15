function hello() {
    console.log("Hello!")
    alert("GAST!")
}

console.log("JO.")

// Show the modal after 5 seconds
setTimeout(() => {
    const modal = new bootstrap.Modal(document.getElementById('exampleModal'));
    modal.show();
}, 1000); // 5000 ms = 5 seconds
