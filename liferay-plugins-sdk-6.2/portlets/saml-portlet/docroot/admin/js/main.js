AUI.add(
	'saml-admin',
	function(A) {
		var AObject = A.Object;
		var Lang = A.Lang;
		var Node = A.Node;
		
		var EVENT_CLICK = 'click';
		var EVENT_SUBMIT = 'submit';
		
		var SamlAdmin = A.Component.create(
			{
				NAME: 'samladmin',
				
				EXTENDS: A.Base,
				
				prototype: {
					initializer: function(config) {
						var instance = this;
						
						instance._config = config;
						
						instance.portletId = config.portletId;
						instance._prefixedPortletId = "_" + config.portletId + "_";
					}
				}
			}
		);
		
		Liferay.Portlet.SamlAdmin = SamlAdmin;
	},
	'',
	{
		requires: ['aui-dialog',
		           'aui-dialog-iframe',
		           'aui-loading-mask'
		          ]
	}
);