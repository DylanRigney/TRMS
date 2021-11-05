function supportsLocalStorage () {
    try {
        return 'localStorage' in window && window['localStorage'] !== null;
    } catch (e) {
        console.log('You dont have local storage');
        return false;
    }
}


// Dont ask
async function signIn() {
    let emailValue = document.getElementById("emailInput").value;
    let passwordValue = document.getElementById("passwordInput").value;
    let url = `http://localhost:7000/employees?email=${emailValue}&password=${passwordValue}`;

    isLocalStorage = supportsLocalStorage();
    //console.log("Your browser supports local storage?"  + isLocalStorage)


    let httpResponse = await fetch(`http://localhost:7000/employees`);   //'https://jsonplaceholder.typicode.com/users/9'
    

    let employees = await httpResponse.json();
    let status = await httpResponse.status;
    console.log(status);
    
    // Dont try this at home
    breakme: if(true) {
        // for each employee in employees
        for (const key in employees) {
            if (Object.hasOwnProperty.call(employees, key)) {
                const employee = employees[key];
                // if there is a match to sign in credentials, add that employee to local storage
                if (employee.email == emailValue && employee.password == passwordValue) {
                    //console.log("we have a match! " + employee.name); 
                    localStorage.setItem("employeeId", employee.employeeId);
                    localStorage.setItem("name", employee.name);
                    localStorage.setItem("email", employee.email);
                    localStorage.setItem("password", employee.password);
                    localStorage.setItem("isBenco", employee.isBenco);
                    localStorage.setItem("deptId", employee.deptId);
                    localStorage.setItem("supervisorId", employee.supervisorId);
                    
                    window.location.replace("index.html");

                    //break all the way out
                    break breakme;
                }
            } 
        }
        // otherwise alert there is no match
        alert("No user found with these credentials Please try again.");
    }

    
    
 
    //console.log(employee.email)
    
    
    
    // if (status === 404) {
    //     console.log("employee not found");
    //     alert("No user found with these credentials Please try again.");

    // } else if(status === 200) {
    //     localStorage.setItem("name", employee.name);
    //     localStorage.setItem("email", employee.email);

    //     window.location.replace("index.html");
    // } else {
    //     console.log("what have you done!?!?!?!?!")  
    // }

    

    // if(httpResponse == {}) {
    //     alert("No user found with these credentials Please try again.")
    // } else {
    //     window.location.replace("index.html");
    // }


    // console.log("Signing In");
}
