var conditionJSonData = [

						   {
						      "id":"textbox",
						      "component":"textInput",
						      "editable":false,
						      "index":0,
						      "label":"Name",
						      "description":"Your name",
						      "placeholder":"Your name",
						      "options":[

						      ],
						      "required":true,
						      "validation":"/.*/",
						      "multiple":"",
						      "multioptions":"",
						      "optionlist":[
						         ""
						      ]
						   },

						   {
						      "id":"",
						      "component":"radio",
						      "editable":true,
						      "index":1,
						      "label":"Gender",
						      "description":"I am",
						      "placeholder":"placeholder",
						      "options":[
						         "Male",
						         "Female"
						      ],
						      "required":false,
						      "validation":"/.*/",
						      "multiple":"",
						      "multioptions":"",
						      "optionlist":""
						   },

						   {
						      "id":"checkbox",
						      "component":"checkbox",
						      "editable":true,
						      "index":2,
						      "label":"Pets",
						      "description":"Do you have any pets?",
						      "placeholder":"placeholder",
						      "options":[
						         "Dog",
						         "Cat"
						      ],
						      "required":false,
						      "validation":"/.*/",
						      "multiple":"",
						      "multioptions":"",
						      "optionlist":""
						   },

						   {
						      "id":"",
						      "component":"select",
						      "editable":true,
						      "index":3,
						      "label":"Country",
						      "description":"Country",
						      "placeholder":"placeholder",
						      "options":[
						         "India",
						         "USA",
						         "UK"
						      ],
						      "required":false,
						      "validation":"/.*/",
						      "multiple":"",
						      "multioptions":"",
						      "optionlist":""
						   },

						   {
						      "id":"",
						      "component":"multipleselect",
						      "editable":true,
						      "index":4,
						      "label":"Hobbies",
						      "description":"Hobbie",
						      "placeholder":"placeholder",
						      "options":[

						      ],
						      "required":false,
						      "validation":"/.*/",
						      "multiple":"",
						      "multioptions":[

						      ],
						      "optionlist":[
						         {
						            "Value":"1",
						            "Text":"Music",
						            "Selected":false
						         },

						         {
						            "Value":"2",
						            "Text":"Singing",
						            "Selected":false
						         },

						         {
						            "Value":"3",
						            "Text":"Playing Game",
						            "Selected":false
						         },

						         {
						            "Value":"4",
						            "Text":"Surfing",
						            "Selected":false
						         }
						      ]
						   },

						   {
						      "id":"fileupload",
						      "component":"fileupload",
						      "editable":true,
						      "index":5,
						      "label":"Profile Picture",
						      "description":"upload your picture here",
						      "placeholder":"",
						      "options":[

						      ],
						      "required":true,
						      "validation":"/.*/",
						      "multiple":"",
						      "multioptions":"",
						      "optionlist":[
						         ""
						      ]
						   },

						   {
						      "id":"",
						      "component":"textArea",
						      "editable":true,
						      "index":6,
						      "label":"Describe Your Self",
						      "description":"Describe about your self",
						      "placeholder":"tell us about your self",
						      "options":[

						      ],
						      "required":true,
						      "validation":"/.*/",
						      "multiple":"",
						      "multioptions":"",
						      "optionlist":[
						         ""
						      ]
						   }
]



var dataTypesOperators = [
						   {
							   "dataTypeName" : "String",
							   "operator" :[
	                        	              {
	                        	            	  label : "Equal",
	                        	            	  value : "equals"
	                        	              },
	                        	              {
	                        	            	  label : "Not Equals",
	                        	            	  value : "notEquals"
	                        	              },
	                        	              {
	                        	            	  label : "Contains",
	                        	            	  value : "contains"
	                        	              },
	                        	              {
	                        	            	  label : "Not Contians",
	                        	            	  value : "notContains"
	                        	              },
	                        	              {
	                        	            	  label : "Starts With",
	                        	            	  value : "startsWith"
	                        	              },
	                        	              {
	                        	            	  label : "In",
	                        	            	  value : "in"
	                        	              },
	                        	              {
	                        	            	  label : "Not In",
	                        	            	  value : "notin"
	                        	              },
	                        	              {
	                        	            	  label : "Is Empty",
	                        	            	  value : "isEmpty"
	                        	              },
	                        	              {
	                        	            	  label : "Is Not Empty",
	                        	            	  value : "isNotEmpty"
	                        	              }
	                        	              
							              ]
						   },

						   {
							   "dataTypeName" : "Number",
							   "operator" : [

														   {
															   label : "Equal",
															   value : "equals"
														   },
														   {
															   label : "Not Equals",
														 	   value : "notEquals"
														   },
														   {
															   label : "Greater Than",
														 	   value : "greaterThan"
														   },
														   {
															   label : "Less Than",
														 	   value : "lessThan"
														   },
														   {
															   label : "Greater Than Or Equal",
														 	   value : "gte"
														   },
														   {
															   label : "Less Than Or Equal",
															   value : "lte"
														   },
														   {
					                        	               label : "In",
					                        	               value : "in"
					                        	            },
					                        	            {
					                        	            	label : "Not In",
					                        	            	value : "notin"
					                        	            }

							                         ]

						   },

						   {

							   "dataTypeName" : "Boolean",

							   "operator" : [

												   {
													   label : "Equal",
													   value : "equals"
												   }

											]

						   }




				   ]