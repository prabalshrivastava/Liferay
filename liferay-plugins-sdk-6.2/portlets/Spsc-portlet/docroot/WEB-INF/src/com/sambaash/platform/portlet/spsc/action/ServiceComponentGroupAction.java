package com.sambaash.platform.portlet.spsc.action;

/**
**/
public class ServiceComponentGroupAction {
/**

	private static Log log = LogFactoryUtil.getLog(ServiceComponentGroupAction.class);

	public static void serviceGroupAction(ActionRequest req, ActionResponse res)
			throws IOException, PortletException {

		try {
		String author = UserLocalServiceUtil.getUser(Long.parseLong(req.getRemoteUser())).getFullName();
		ThemeDisplay themeDisplay = (ThemeDisplay)req.getAttribute(WebKeys.THEME_DISPLAY);
		String portletName = (String)req.getAttribute(WebKeys.PORTLET_ID);

		PortletURL redirectURL = PortletURLFactoryUtil
				.create( PortalUtil.getHttpServletRequest(req), portletName,
						themeDisplay.getLayout().getPlid(), PortletRequest.RENDER_PHASE );

		String cmd = req.getParameter("CMD");
		log.info("cmd@@@:"+cmd+"|author:"+author+ "|Date:"+Calendar.getInstance().getTime());

		if (cmd != null && cmd.equals("process")) {
			long pKey = CounterLocalServiceUtil.increment("ServiceComponentGroup.class");
			String serviceName = req.getParameter("name");
			String serviceDescription = req.getParameter("description");
			String serviceStatus = req.getParameter("status");
			String servicePhase = req.getParameter("phase");
			String serviceVersion = req.getParameter("version");
			String deploymentCluster = req.getParameter("deploymentCluster");
			String community = req.getParameter("community");
			String[] extra2 = req.getParameterValues("extra1");
			String extra1 = "";

			for (int s = 0; s<extra2.length; s++) {
				extra1 = extra1 + extra2[s]+",";
			}

			log.info("extra1" + extra1);

			ServiceComponentGroup entityImpl = ServiceComponentGroupLocalServiceUtil.createServiceComponentGroup(pKey);

			entityImpl.setPrimaryKey(pKey);
			entityImpl.setName(serviceName);
			entityImpl.setDescription(serviceDescription);
			entityImpl.setExtra1(extra1);
			entityImpl.setStatus(serviceStatus);
			entityImpl.setVersion(serviceVersion);
			entityImpl.setPhase(servicePhase);
			entityImpl.setDeploymentCluster(deploymentCluster);
			entityImpl.setCommunity(community);

			entityImpl.setDateAdded(Calendar.getInstance().getTime());
			entityImpl.setDateModified(Calendar.getInstance().getTime());
			entityImpl.setExtra5(Calendar.getInstance().getTime());
			entityImpl.setExtra6(Calendar.getInstance().getTime());
			entityImpl.setAuthor(author);
			log.info("addServiceComponentGroup" + entityImpl);
			ServiceComponentGroup scg = ServiceComponentGroupLocalServiceUtil.addServiceComponentGroup(entityImpl);
			log.info("Before ServiceHelper.index(entityImpl) ");
			ServiceHelper.index(entityImpl);
			log.info("After ServiceHelper.index(entityImpl) ");

			SessionMessages.add(req, "added");
		} else if (cmd != null && cmd.equals("delete")) {
			//05.04.10
			List<String> inUseList = new ArrayList<String>();

				String[] pKeys = req.getParameterValues("deleteItem");

				if ((pKeys != null) && (pKeys.length != 0)) {
				for (int i = 0; i<pKeys.length; i++) {
					boolean inUse = ServiceComponentsLocalServiceUtil.isServiceGroupInUse(pKeys[i]);

					if (inUse) {
						String mpGrpName = getServiceComponentGrpName(pKeys[i]);

						if (!inUseList.contains(mpGrpName)) {
							inUseList.add(mpGrpName);
						}
					}else {
						ServiceHelper.removeIndex(ServiceComponentGroupLocalServiceUtil.getServiceComponentGroup(Long.parseLong(pKeys[i])));
						ServiceComponentGroupLocalServiceUtil.deleteServiceComponentGroup(Long.parseLong(pKeys[i]));
					}
				}
			}

			HttpServletRequest request = PortalUtil.getHttpServletRequest(req);
			HttpSession session = request.getSession();
			session.setAttribute("inUseList", inUseList);
			SessionMessages.add(req, "deleted");
				//end 05.04.10
				log.info("deleted serviceComponent delete:");
		} else if (cmd != null && cmd.equals("edit")) {

			String recId = req.getParameter("recId");
			long pKey = Long.parseLong(recId);
			//06.05.10
			List<String> inUseList = new ArrayList<String>();
			boolean inUse = ServiceComponentsLocalServiceUtil.isServiceGroupInUse(recId);

			if (inUse) {
				String mpGrpName = getServiceComponentGrpName(recId);
				inUseList.add(mpGrpName);

			}else {

				String serviceName = req.getParameter("name");
				String serviceDescription = req.getParameter("description");
				String serviceStatus = req.getParameter("status");
				String servicePhase = req.getParameter("phase");
				String serviceVersion = req.getParameter("version");
				String deploymentCluster = req.getParameter("deploymentCluster");
				String community = req.getParameter("community");
				String[] extra2 = req.getParameterValues("extra1");
				String extra1 = "";

				for (int s = 0; s<extra2.length; s++) {
					extra1 = extra1 + extra2[s]+",";
				}

				ServiceComponentGroup entityImpl = ServiceComponentGroupLocalServiceUtil.getServiceComponentGroup(pKey);
				entityImpl.setPrimaryKey(pKey);
				entityImpl.setName(serviceName);
				entityImpl.setDescription(serviceDescription);
				entityImpl.setExtra1(extra1);
				entityImpl.setStatus(serviceStatus);
				entityImpl.setVersion(serviceVersion);
				entityImpl.setPhase(servicePhase);
				entityImpl.setDeploymentCluster(deploymentCluster);
				entityImpl.setCommunity(community);
				entityImpl.setExtra1(extra1);
				entityImpl.setExtra5(Calendar.getInstance().getTime());
				entityImpl.setExtra6(Calendar.getInstance().getTime());

				entityImpl.setDateModified(Calendar.getInstance().getTime());
				entityImpl.setAuthor(author);
				ServiceComponentGroupLocalServiceUtil.updateServiceComponentGroup(entityImpl);
				ServiceHelper.reIndex(entityImpl.getPrimaryKey());
			}

			HttpServletRequest request = PortalUtil.getHttpServletRequest(req);
			HttpSession session = request.getSession();
			session.setAttribute("inUseList", inUseList);
			SessionMessages.add(req, "updated");
		}

		if (cmd != null && cmd.equals("clone")) {
			log.info("cmd@@@:"+cmd);
			String pKeys = req.getParameter("deleteItem");
			req.setAttribute("clone","clone");

			if ((pKeys != null) && (pKeys.length() != 0)) {
			//for (int i=0; i<pKeys.length; i++) {
				log.info(cmd+"pKey:"+pKeys);
				//ServiceComponentGroup cloneImpl = new ServiceComponentGroupImpl();
				ServiceComponentGroup cloneImpl = null;
				long pKey = CounterLocalServiceUtil.increment("ServiceComponentGroup.class");

				if (pKeys.length() > 0)
//				ServiceComponentGroup	cloneImpl = ServiceComponentGroupLocalServiceUtil.getServiceComponentGroup(Long.parseLong(pKeys));
				cloneImpl = ServiceComponentGroupLocalServiceUtil.getServiceComponentGroup(Long.parseLong(pKeys));
				String cloneName = cloneImpl.getName() +"_clone";
				cloneImpl.setScgId(pKey);
				cloneImpl.setName(cloneName);
				cloneImpl.setDateAdded(Calendar.getInstance().getTime());
				cloneImpl.setDateModified(Calendar.getInstance().getTime());
				cloneImpl.setAuthor(author);
				ServiceComponentGroup scg = ServiceComponentGroupLocalServiceUtil.addServiceComponentGroup(cloneImpl);
				ServiceHelper.index(scg);

				req.setAttribute("recId", pKey);

				PortletURL url = ((ActionResponseImpl)res).createRenderURL();
				url.setParameter("struts_action", "/spsc/servicecomponentgroup_action");
				url.setParameter("CMD", "edit");
				url.setParameter("cloned", "clone");
				url.setParameter("recId", String.valueOf(pKey));

				SessionMessages.add(req, "cloned");

				res.sendRedirect(url.toString());

				//}
			}
		}
//			else {
//		PortletURL url = ((ActionResponseImpl)res).createRenderURL();
//		url.setParameter("struts_action", "/spsc/servicecomponentgroup_action");
//		res.sendRedirect(url.toString());
//			}

//		  cmd = req.getParameter("CMD");
		  String recId = req.getParameter("recId");

			if (cmd != null && cmd.equals("formView"))
			{
				redirectURL.setParameter("jspPage", "/html/servicecomponentgroup_form.jsp");
				res.sendRedirect(redirectURL.toString());
			} else if (cmd != null && cmd.equals("detailView"))
			{
				redirectURL.setParameter("recId", recId);
				redirectURL.setParameter("jspPage", "/html/servicecomponentgroup_detail.jsp");
				res.sendRedirect(redirectURL.toString());
			} else if (cmd != null && cmd.equals("editView"))
			{
				String cloned = req.getParameter("cloned");
				redirectURL.setParameter("recId", recId);
				//redirectURL.setAttribute("recId", recId);

				log.info("cloned@@@:"+cloned);

				if ((cloned!= null) && (cloned.equals("clone")))
				{
					redirectURL.setParameter("clone", "clone");
					log.info("cloned@@@:"+cloned);
				}

				redirectURL.setParameter("jspPage", "/html/servicecomponentgroup_edit.jsp");
				res.sendRedirect(redirectURL.toString());
			}
			else if (cmd != null && cmd.equals("lookup"))
			{
				redirectURL.setParameter("jspPage", "/html/servicecomponentgroup_lookup.jsp");
				res.sendRedirect(redirectURL.toString());
			} else if (cmd != null && cmd.equals("list"))
			{
				redirectURL.setParameter("jspPage", "/html/servicecomponents_list.jsp");
				res.sendRedirect(redirectURL.toString());
			} else {
				redirectURL.setParameter("jspPage", "/html/servicecomponentgroup_list.jsp");
				res.sendRedirect(redirectURL.toString());
			}
		} catch (NumberFormatException e) {
			log.error(e);
		} catch (PortalException e) {
			log.error(e);
		} catch (SystemException e) {
			log.error(e);
		} catch (Exception e) {
			log.error(e);
		}
	}

	//05.04.10
	public static String getServiceComponentGrpName(String mpGrpId) throws NumberFormatException, PortalException, SystemException {

		ServiceComponentGroup scGrp = null;
		try {
			scGrp = ServiceComponentGroupLocalServiceUtil.getServiceComponentGroup(Long.parseLong(mpGrpId));
		} catch (com.liferay.portal.kernel.exception.PortalException e) {
			log.error(e);

		} catch (com.liferay.portal.kernel.exception.SystemException e) {
			log.error(e);
		}

		if (scGrp != null)
		return scGrp.getName();
		else return null;
	}
	//end 05.04.10
**/
}