function signOut() {
    localStorage.clear();
    window.location.replace("goodbye.html");
    console.log(localStorage.getItem("name"));
} 