async function getDSupRequests() {
  let requestsForDSup;
  // Get logged in employee's id.  if that employee is anyones supervisor, then that employee ID is equal to the second persons supervisor Id
  let supervisorId = localStorage.getItem("employeeId");

  let httpResponse = await fetch(`http://localhost:7000/requestsForSupervisor/${supervisorId}`);
  requestsForDSup = await httpResponse.json();
  
  //console.log(requestsForDSup);

  return requestsForDSup;
}


async function getDeptHeadRequests() {
  let requestsForDeptHead;
  let deptHeadId = localStorage.getItem("deptId");
  let empId = localStorage.getItem("employeeId");

  if ( (empId == 1) || (empId == 2) || (empId == 3) || (empId == 4) || (empId == 5) || (empId == 6) || (empId == 7) ) {
    let httpResponse = await fetch(`http://localhost:7000/requestsForDept/${deptHeadId}`);
    requestsForDeptHead = await httpResponse.json();
  }

  //console.log(requestsForDeptHead)

  return requestsForDeptHead;
}


async function getBencoRequests() {
  let requestsForBenco;
  const isBenco = localStorage.getItem("isBenco");


    if(isBenco === "true") {
      
      httpResponse = await fetch("http://localhost:7000/requestsForBenco");
      // Here are the requests for the Benco
      requestsForBenco = await httpResponse.json();
  
      //console.log(requestsForBenco);

    } 
    return requestsForBenco;
}


async function getEmployeeRequests() {
  let requestsForEmployee;
  let empId = localStorage.getItem("employeeId");

  httpResponse = await fetch(`http://localhost:7000/requestsForEmployee/${empId}`);
  requestsForEmployee = await httpResponse.json();

  //console.log(requestsForEmployee);

  return requestsForEmployee;
}

async function getResolvedRequests() {
  let requestsResolved;
  let empId = localStorage.getItem("employeeId");

  httpResponse = await fetch(`http://localhost:7000/resolvedRequests/${empId}`);
  requestsResolved = await httpResponse.json();

  //console.log(requestsResolved);

  return requestsResolved;
}

async function getMyRequests() {
  let myRequests;
  let empId = localStorage.getItem("employeeId");

  httpResponse = await fetch(`http://localhost:7000/myRequests/${empId}`);
  requestsResolved = await httpResponse.json();

  return myRequests

}



async function collectRequests() {

    let allRequests = [];
    const requestsForDSup = await getDSupRequests();
    const requestsForDeptHead = await getDeptHeadRequests();
    const requestsForBenco = await getBencoRequests();
    const requestsForEmployee = await getEmployeeRequests();
    // const requestsResolved = await getResolvedRequests();

    if(requestsForDSup != null) {
      allRequests = allRequests.concat(requestsForDSup)
    }

    if(requestsForDeptHead != null) {
      allRequests = allRequests.concat(requestsForDeptHead);
    }

    if(requestsForBenco != null) {
      allRequests = allRequests.concat(requestsForBenco);
    }

    if(requestsForEmployee != null) {
      allRequests = allRequests.concat(requestsForEmployee);
    }

    // if(requestsResolved != null) {
    //   allRequests = allRequests.concat(requestsResolved);
    // }

    return allRequests;
  }

  var requestsForReview; 

  async function populateRequestDD() {
    requestsForReview = await collectRequests();
    
    if(requestsForReview.length == 0) {
      document.getElementById("requestDropdown").innerHTML= "<option> You have no requests to update </option>";
    } else {
      var requestOptions = '<option value="" disabled selected>Choose a request you would like to review</option>';
      
      for (request of requestsForReview) {  
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
        
        requestOptions += "<option value='" + request.requestId + "' > Event: &nbsp" + request.eventDescription + ",&nbsp&nbsp&nbsp&nbsp&nbsp Location:  &nbsp" + request.eventLocation
         + ",&nbsp&nbsp&nbsp&nbsp&nbsp Date: &nbsp" + request.eventDate + "&nbsp&nbsp&nbsp&nbsp Status: &nbsp&nbsp" + status +  "</option>";
        //console.log(requestOptions);
      }
    }

    document.getElementById("requestDropdown").innerHTML = requestOptions;

 
    //console.log(requestsForReview);
    
  }

   var globalRequest;
   function setRequest(value) {
     //console.log(value);
     
     for(request of requestsForReview) {
      if (request.requestId == value) {
        
        document.getElementById("employeeName").value = request.employeeName;
        document.getElementById("workRelatedJustification").value = request.workRelatedJustification;
        document.getElementById("eventDescription").value = request.eventDescription;
        document.getElementById("eventLocation").value = request.eventLocation;
        document.getElementById("eventType").value = request.eventType;
        document.getElementById("gradingFormat").value = request.gradingFormat;
        document.getElementById("passingGrade").value = request.passingGrade;
        document.getElementById("eventTime").value = request.eventTime;
        document.getElementById("eventDate").value = request.eventDate;
        document.getElementById("eventCost").value = request.eventCost;

       
       
        if (request.statusId == "5") {
          
          document.getElementById("approve").innerHTML = "Course passed";
          document.getElementById("deny").innerHTML = "Course failed";
        } 


        
        // used to give current request to approveRequest and denyRequest.  Dont use for anthing else.
        globalRequest = request;
      }
     }
     
   }


   
    async function approveRequest() {
      let request = globalRequest;
      let currentStatus = "" + request.statusId;
      console.log(currentStatus);
      
      // Set the request status to it's next level upon approval
      switch (currentStatus) {
        case "1": {
          request.statusId = "3";
          break;
        }
        case "3": {
          request.statusId = "4";
          break;
        }
        case "4": {
          request.statusId = "5";
          break;
        }
        case "5": {
          if(request.gradingFormat == 1){ 
            request.statusId = "7";
          } else  request.statusId = "8";
          break;
        }
        default: {
          request.statusId = "11";
        }
      }

      console.log(request.statusId);

      let url = "http://localhost:7000/requests";
      
      const options = {
        method: 'PATCH',
        body: JSON.stringify(request),
        headers: new Headers({
          'Content-Type': 'application/json'
        })
      }

      let httpResponse = await fetch(url, options);
      let updatedRequestStatus = httpResponse.json();

      window.location.replace("index.html");

   }

   
   async function denyRequest() {
     let request = globalRequest;
     request.statusId = "10";

     let url = "http://localhost:7000/requests";

     const options = {
      method: 'PATCH',
      body: JSON.stringify(request),
      headers: new Headers({
        'Content-Type': 'application/json'
      })
    }

    let httpResponse = await fetch(url, options);
    let updatedRequestStatus = httpResponse.json();
    
    
    window.location.replace("index.html");
   }

  

  