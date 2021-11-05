


function sayHi() {
   
    document.getElementById("hi").innerHTML = localStorage.name ;
  }


  async function getMyRequests() {
    let myRequests;
    let empId = localStorage.getItem("employeeId");
  
    httpResponse = await fetch(`http://localhost:7000/myRequests/${empId}`);
    myRequests = await httpResponse.json();

    
  
    return myRequests
  
  }  

  async function populateRequestDD() {
    
    const myRequests = await getMyRequests();
    
    if(myRequests.length == 0) {
      document.getElementById("requestDropdown").innerHTML= "<option> You have no requests to update </option>";
    } else {
      var requestOptions = '<option value="" disabled selected>Choose a request you would like to review</option>';
      
      for (request of myRequests) {  
        var status;
        //console.log(request.statusId)
        statusId = ""  + request.statusId;
        //console.log(statusId)

        switch(statusId) {
          case "1": {
            status = "Awaiting Supervisor approval";
            break;
          }
          case "3": {
            status = "Awaiting Department Head approval";
            break;
          }
          case "4": {
            status = "Awaiting benefits Coordinator approval";
            break;
          }
          case "5": {
            status = "Awaiting course completion";
            break;
          }
          case "7": {
            status = "Awaiting Benefits Coordinator to confirm passing grade";
            break;
          }
          case "8": {
            status = "Awaiting presentation confirmation from Supervisor";
            break;
          }
          case "9": {
            status = "Request canceled";
            break;
          }
          case "10": {
            status = "Request denied";
            break;
          }
          case "11": {
            status = "Request awarded!";
            break;
          }
        }

        requestOptions += "<option value='" + request.requestId + "' > Event: &nbsp" + request.eventDescription + ",&nbsp&nbsp&nbsp&nbsp&nbsp Location:  &nbsp"
         + request.eventLocation + ",&nbsp&nbsp&nbsp&nbsp&nbsp Date: &nbsp" + request.eventDate + "&nbsp&nbsp&nbsp&nbsp Status: &nbsp&nbsp" + status + "</option>";
        
         //console.log(requestOptions);
      }
    }

    document.getElementById("requestDropdown").innerHTML = requestOptions;

 
    console.log(myRequests);
    
  }