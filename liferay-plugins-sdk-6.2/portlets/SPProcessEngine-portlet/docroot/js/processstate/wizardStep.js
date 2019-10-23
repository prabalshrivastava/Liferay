function drawSteps(steps) {
	if (!steps) {
		console.log("Steps are null");
		return;
	}
	 var stepContainer = document.getElementsByClassName("wizardTracker")[0];
	    var stepsProgress = steps.stepsItem;
	    if ((Object.keys(steps).length) > 0) {
	        var requestedStepNo = -1;
	        var ul = document.createElement("div");
	        ul.className = "wizard-progress";
	        var currentStep;
	        var stepRequested=false;
	        for (key in steps) {
	            var li = document.createElement("div");
	            li.className = "step";
	            var stepItem1 = steps[key];
	            //console.log("*stepItem1**" + JSON.stringify(stepItem1));
	            for (key in stepItem1) {
	                /*alert("stepsKey" + key);
	                alert("stepsKey" + stepItem1[key]);*/
	                var link = document.createElement('a');
	                 link.className = "wizLink";
	                var url ="javascript:;";
	                //if url exists, then only use it
	                if (stepItem1.url && stepItem1.url.length > 0) {
	                	url = stepItem1.url;
	                }
	                link.setAttribute('href', url);
	                //Circle No Instance Creation
	                var progtrckrCircle = document.createElement("div");
	                progtrckrCircle.className = "node ";
	                //Line No Instance Creation
	                // var progtrckrLine = document.createElement("div");
	                // progtrckrLine.className = "progtrckr-todo-Notselect ";
	                // progtrckrLine.appendChild(progtrckrCircle);

	                //COLOR ADD

	                // if (stepItem1) {
	                //     var stepStyle = stepItem1.style;

	                //     for (key in stepStyle) {
	                       

	                //         progtrckrCircle.setAttribute('Style', "background-image" + ":" + 'radial-gradient(' + "circle at 50% 50%" + ', ' + stepStyle.circleColor1 + ',' + stepStyle.circleColor2 + ');');
	                //         progtrckrLine.setAttribute('Style', "background-color" + ":" + "#3bb740" + ";");


	                //     }
	                // }

	                //Txt instance creation
	                var progtrckrText = document.createElement("div");
	                progtrckrText.className = "wizardstepTitleprog";
	                progtrckrText.innerHTML = stepItem1.name;
	                //Steps Condtion Checking
	                if (stepItem1.current == true) {
	                	currentStep = link;
	                    link.className += " in-progress";
	                    // progtrckrText.classList += " activeStepColor";
	                    //progtrckrLine.removeAttribute('Style');
	                    if (requestedStepNo == -1) { // there was no requested step before this step
	                    	link.className += " current-step";
	                    }

	                } else if (stepItem1.completed == true) {
	                    link.className += " complete";
	                  

	                } else if (stepItem1.completed == false) {
	                    link.className = "wizLink";
	                    //progtrckrLine.className += "seqLine";
	                  
	                   //progtrckrLine.removeAttribute('Style');

	                } 
	                
	                if (stepItem1.requestedStatusType == true) {
	                	link.className += " requested-step stepDisplay current-step";
	                	stepRequested = true;
	                	requestedStepNo = stepItem1.seqNo;
	                }

	            }
	           
	            // link.appendChild(progtrckrNo);
	            link.appendChild(progtrckrCircle);
	            link.appendChild(progtrckrText);
	            li.appendChild(link);
	            ul.appendChild(li);
	        }
	        
	        if(!stepRequested && currentStep){
	        	currentStep.className += " stepDisplay";
	        }
	        stepContainer.appendChild(ul);
	    }
}