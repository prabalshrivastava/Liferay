function drawSteps(steps) {
	if (!steps) {
		console.log("Steps are null");
		return;
	}
	 var stepContainer = document.getElementsByClassName("ProgressTracker")[0];
	    var stepsProgress = steps.stepsItem;
	    if ((Object.keys(steps).length) > 0) {
	        var progressNavDiv = document.createElement("div");
	        progressNavDiv.className = "progressNav";
	        var ul = document.createElement("ul");
	        ul.className = "progtrckr";
	        var currentStep;
	        var stepRequested=false;
	        for (key in steps) {
	            var li = document.createElement("li");
	            li.className = "progtrckr-todo";
	            var stepItem1 = steps[key];
	            //console.log("*stepItem1**" + JSON.stringify(stepItem1));
	            for (key in stepItem1) {
	                /*alert("stepsKey" + key);
	                alert("stepsKey" + stepItem1[key]);*/
	                var link = document.createElement('a');
	                var url ="javascript:;";
	                //if url exists, then only use it
	                if (stepItem1.url && stepItem1.url.length > 0) {
	                	url = stepItem1.url;
	                }
	                link.setAttribute('href', url);
	                //Seq No Instance Creation
	                var progtrckrNo = document.createElement("div");
	                progtrckrNo.innerHTML = stepItem1.seqNo;
	                progtrckrNo.className = "progtrckr-No";
	                //Circle No Instance Creation
	                var progtrckrCircle = document.createElement("div");
	                progtrckrCircle.className = "circle ";
	                //Line No Instance Creation
	                var progtrckrLine = document.createElement("div");
	                progtrckrLine.className = "progtrckr-todo-Notselect ";
	                progtrckrLine.appendChild(progtrckrCircle);

	                //COLOR ADD

	                if (stepItem1) {
	                    var stepStyle = stepItem1.style;

	                    for (key in stepStyle) {
	                       

	                        progtrckrCircle.setAttribute('Style', "background-image" + ":" + 'radial-gradient(' + "circle at 50% 50%" + ', ' + stepStyle.circleColor1 + ',' + stepStyle.circleColor2 + ');');
	                        progtrckrLine.setAttribute('Style', "background-color" + ":" + "#3bb740" + ";");


	                    }
	                }

	                //Txt instance creation
	                var progtrckrText = document.createElement("div");
	                progtrckrText.className = "progtrckr-todo-text";
	                progtrckrText.innerHTML = stepItem1.name;
	                //Steps Condtion Checking
	                if (stepItem1.current == true) {
	                	currentStep = progtrckrCircle;
	                    progtrckrCircle.className += " activeStage";
	                    progtrckrText.classList += " activeStepColor";
	                    //progtrckrLine.removeAttribute('Style');

	                } else if (stepItem1.completed == true) {
	                    progtrckrCircle.className += " completed-Stage";
	                    progtrckrText.classList += ' completedStepColor';

	                } else if (stepItem1.completed == false) {
	                    progtrckrCircle.className = "circle";
	                    progtrckrLine.className += "seqLine";
	                    progtrckrCircle.removeAttribute('Style');
	                    progtrckrLine.removeAttribute('Style');

	                } 
	                
	                if (stepItem1.requestedStatusType == true) {
	                	progtrckrCircle.className += " requested-step stepDisplay";
	                	stepRequested = true;
	                }


	            }
	            li.appendChild(link);
	            link.appendChild(progtrckrNo);
	            link.appendChild(progtrckrLine);
	            link.appendChild(progtrckrText);
	            ul.appendChild(li);
	        }
	        
	        if(!stepRequested && currentStep){
	        	currentStep.className += " stepDisplay";
	        }

	        progressNavDiv.appendChild(ul);
	        stepContainer.appendChild(progressNavDiv);
	    }
}