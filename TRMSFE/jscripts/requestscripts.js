function calculateReimbursement() {
    let cost  =  document.getElementById("eventCost").value;
    let eventType =  document.getElementById("eventType").value;
    let eventPct;
    let reimbursement;

    switch(eventType) {
      case "1":
        eventPct = .80;
        
        break;
      case "2":
        eventPct = .60;
        break;  
      case "3":
        eventPct = .75;
        break;  
      case "4":
        eventPct = 1;
        break;
      case "5":
        eventPct = .90;
        
        break;  
     
      default: 
        eventPct = .3;
             
    }

      
    if ( document.getElementById("eventType").value == "Please select the event grading format" || document.getElementById("eventCost").value == "" ) {
      alert("Please input event cost and select event type");
    } else {
      reimbursement = (eventPct * cost);
      document.getElementById("projectedReimbusement").style.fontSize = "x-large" ;
      document.getElementById("projectedReimbusement").style.color = 'red';
      document.getElementById("projectedReimbusement").innerHTML = "$ " + reimbursement + "!"
    }
  } 

  async function buildRequest() {
    
    const request = {
      employeeName        :  document.getElementById("employeeName").value,
      workRelatedJustification   :  document.getElementById("workJustification").value,
      eventType           :  document.getElementById("eventType").value,
      gradingFormat       :  document.getElementById("gradingFormat").value,
      passingGrade        :  document.getElementById("passingGrade").value,
      eventDescription    :  document.getElementById("eventDescription").value,
      eventLocation       :  document.getElementById("eventLocation").value,
      eventTime           :  document.getElementById("eventTime").value,
      eventDate           :  document.getElementById("eventDate").value,
      eventCost           :  document.getElementById("eventCost").value,
      requestDateTime     :  Date.now(),
      employeeId          :  localStorage.getItem("employeeId"),
      empSupervisorId     :  localStorage.getItem("supervisorId"),
      empDeptId           :  localStorage.getItem("deptId")
    };
    

    // The new request we added to the database if needed
    createdRequest = await addRequest(request);
    
  }

async function addRequest(request) {
       
    url = "http://localhost:7000/requests"

    const options = {
      method: 'POST',
      body: JSON.stringify(request),
      headers: new Headers({
        'Content-Type': 'application/json'
      })
    }

    let httpResponse = await fetch(url, options);
    // The new request is here if I need it
    let body = await httpResponse.json();

    console.log(body);

    if(body != null) {
      
      alert("You have succesfully created a new request");
      window.location.replace("index.html");
     
    } else {
      alert("Sorry. A request could not be created at this time")
      console.log("body is null");
    }
  }