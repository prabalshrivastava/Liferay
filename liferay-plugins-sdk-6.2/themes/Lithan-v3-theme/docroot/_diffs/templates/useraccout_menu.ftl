	                            	<#if nav_items?? >
	                            	<#assign menuCount = 0 />
	                            	<#list nav_items as nav_item>
	                            	<#if nav_item.getName() == 'Application Summary'>
	                            	<#if nav_item.hasChildren()>
	                            	<#list nav_item.getChildren() as nav_child>
	                            	
 										<#assign img_url = "/image/layout_icon?img_id="+nav_child.getLayout().getIconImageId()>
	                            		<div class="applications resize-width">
	                            			<a href="${nav_child.getURL()}">
			                            		<#if nav_child.getLayout().getIconImageId() != 0>
			                            			<img src="${img_url}" class="dropdown-image-resize" />
			                            		</#if>
			                            		<span class="dropdown-resize">${nav_child.getName()}</span>
		                            		</a>
	                            		</div>
	                            	
	                            	<#assign menuCount = menuCount+1 />
	                            	</#list>
	                         	 	</#if>
	                         	 	</#if>
	                         	 	</#list>
	                         	 	</#if>
