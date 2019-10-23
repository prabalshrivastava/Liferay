package com.sambaash.platform.portlet.spsc.action;

/**
import com.liferay.portlet.PortletURLFactoryUtil;**/
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class ServiceComponentsAction
 */
public class ServiceComponentsAction extends MVCPortlet {
/**
	private static Log _log = LogFactoryUtil.getLog(ServiceComponentsAction.class);

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {

		String cmd = renderRequest.getParameter("CMD");
		String _VIEW_SERVICECOMP_JSP = "/html/servicecomponents_lookup.jsp";
		String _VIEW_SERVICEGROUPCOMP_JSP = "/html/servicecomponentgroup_lookup.jsp";

		if (cmd != null && cmd.equals("list")) {
			include("/html/servicecomponents_list.jsp", renderRequest, renderResponse);
		} else if (cmd != null && cmd.equals("sclookup")) {
			include(_VIEW_SERVICECOMP_JSP, renderRequest, renderResponse);
		} else if (cmd != null && cmd.equals("sglookup")) {
			include(_VIEW_SERVICEGROUPCOMP_JSP, renderRequest, renderResponse);
		} else {
			super.doView(renderRequest, renderResponse);
		}
	}

	public void componentAction(ActionRequest req, ActionResponse res) throws IOException, PortletException {
		try {
			String author = UserLocalServiceUtil.getUser(Long.parseLong(req.getRemoteUser())).getFullName();// req.getRemoteUser();

			String cmd = req.getParameter("CMD");
			_log.info("ServiceComponentsAction=>cmd" + cmd);
			String recId2 = req.getParameter("recId");
			_log.info("form=>recId:" + recId2);

			String deleteItem = req.getParameter("deleteItem");
			_log.info("form=>deleteItem:" + deleteItem);
			ThemeDisplay themeDisplay = (ThemeDisplay)req.getAttribute(WebKeys.THEME_DISPLAY);
			String portletName = (String)req.getAttribute(WebKeys.PORTLET_ID);
			PortletURL redirectURL = PortletURLFactoryUtil.create(PortalUtil.getHttpServletRequest(req), portletName, themeDisplay.getLayout()
					.getPlid(), PortletRequest.RENDER_PHASE);

			if (cmd != null && cmd.equals("process")) {
				long pKey = CounterLocalServiceUtil.increment("ServiceComponentGroup.class");

				// ServiceComponents entityImpl = new ServiceComponentsImpl();

				String serviceName = req.getParameter("name");
				String serviceDescription = req.getParameter("description");
				String serviceExtra1 = req.getParameter("extra1");
				String technologyComponent = req.getParameter("technologyComponent");
				String serviceExtra2 = req.getParameter("extra2");
				String serviceStatus = req.getParameter("status");
				String servicePhase = req.getParameter("phase");
				String serviceType = req.getParameter("serviceType");
				String serviceVersion = req.getParameter("version");
				String ServiceExposureType = req.getParameter("ServiceExposureType");
				String userType = req.getParameter("userType");
				String platformType = req.getParameter("platformType");
				String islaCarteService = req.getParameter("islaCarteService");
				String isExternal = req.getParameter("isExternal");
				String serviceTag = req.getParameter("tag");
				String usageStatistics = req.getParameter("usageStatistics");
				String channelID = req.getParameter("channelID");
				String webserviceURL = req.getParameter("webserviceURL");
				String deploymentCluster = req.getParameter("deploymentCluster");
				String deploymentLocation = req.getParameter("deploymentLocation");
				String testPlan = req.getParameter("testPlan");
				String performanceProfile = req.getParameter("performanceProfile");

				ServiceComponents entityImpl = ServiceComponentsLocalServiceUtil.createServiceComponents(pKey);

				// entityImpl = (ServiceComponentsImpl)UIHelper.getObject(req,
				// ServiceComponentsImpl.class);

				entityImpl.setPrimaryKey(pKey);
				entityImpl.setName(serviceName);
				entityImpl.setDescription(serviceDescription);
				entityImpl.setExtra1(serviceExtra1);
				entityImpl.setTechnologyComponent(technologyComponent);
				entityImpl.setExtra2(serviceExtra2);
				entityImpl.setPhase(servicePhase);
				entityImpl.setStatus(serviceStatus);
				entityImpl.setServiceType(serviceType);
				entityImpl.setVersion(serviceVersion);
				entityImpl.setServiceExposureType(ServiceExposureType);
				entityImpl.setUserType(userType);
				entityImpl.setPlatformType(platformType);
				entityImpl.setIslaCarteService(Boolean.parseBoolean(islaCarteService));
				entityImpl.setIsExternal(Boolean.parseBoolean(isExternal));
				entityImpl.setTag(serviceTag);
				entityImpl.setUsageStatistics(usageStatistics);
				entityImpl.setChannelID(channelID);
				entityImpl.setWebserviceURL(webserviceURL);
				entityImpl.setDeploymentCluster(deploymentCluster);
				entityImpl.setDeploymentLocation(deploymentLocation);
				entityImpl.setTestPlan(testPlan);
				entityImpl.setPerformanceProfile(performanceProfile);
				entityImpl.setExtra5(Calendar.getInstance().getTime());
				entityImpl.setExtra6(Calendar.getInstance().getTime());

				req.setAttribute("recId", String.valueOf(pKey));
				entityImpl.setDateAdded(Calendar.getInstance().getTime());
				entityImpl.setDateModified(Calendar.getInstance().getTime());
				entityImpl.setAuthor(author);

				String serviceExposureType = req.getParameter("ServiceExposureType");
				entityImpl.setServiceExposureType(serviceExposureType);
				_log.info("ServiceExposureType" + entityImpl.getServiceExposureType());

				// entityImpl.se

				ServiceComponentsLocalServiceUtil.addServiceComponents(entityImpl);
				SessionMessages.add(req, "added");

			} else if (cmd != null && cmd.equals("delete")) {

				List<String> inUseList = new ArrayList<String>();
				String[] pKeys = req.getParameterValues("deleteItem");
				boolean success = true;

				// 05.04.10

				boolean inUse = false;

				if ((pKeys != null) && (pKeys.length != 0)) {
					for (int i = 0; i < pKeys.length; i++) {
						inUse = ServiceComponentsLocalServiceUtil.isServiceInUse(pKeys[i]);

						if (inUse) {

							// for success delete or not

							success = false;
							String scName = getServiceComponentsName(pKeys[i]);

							if (!inUseList.contains(scName)) {
								inUseList.add(scName);
							}
						} else {

							List ls = ServiceComponentGroupLocalServiceUtil.findByServiceComponentGroupExtra1Like("%" + pKeys[i] + "%");

							_log.info("serviceComponent delete:" + ls.size() + ">>" + pKeys[i]);

							if (ls.isEmpty())
								ServiceComponentsLocalServiceUtil.deleteServiceComponents(Long.parseLong(pKeys[i]));

							// SessionMessages.add(req, "updated");

							else {
								_log.info("Couldnotdelete serviceComponent delete:" + ls.size() + ">>" + pKeys[i]);
								SessionErrors.add(req, "couldnotdelete");

								success = false;
							}
						}
					}

					if (inUse) {
						HttpServletRequest request = PortalUtil.getHttpServletRequest(req);
						HttpSession session = request.getSession();
						session.setAttribute("inUseList", inUseList);
						SessionMessages.add(req, "deleted");
					}

					// end 04.05.10 deleted

					if (success) {
						SessionMessages.add(req, "deleted");
						_log.info("deleted serviceComponent delete:");
					}
				}
			} else if (cmd != null && cmd.equals("edit")) {
				String recId = req.getParameter("recId");
				long pKey = Long.parseLong(recId);

				// ServiceComponents entityImpl = new ServiceComponentsImpl();
				// entityImpl = (ServiceComponentsImpl)UIHelper.getObject(req,
				// ServiceComponentsImpl.class);

				String serviceName = req.getParameter("name");
				String serviceDescription = req.getParameter("description");
				String serviceExtra1 = req.getParameter("extra1");
				String technologyComponent = req.getParameter("technologyComponent");
				String serviceExtra2 = req.getParameter("extra2");
				String serviceStatus = req.getParameter("status");
				String servicePhase = req.getParameter("phase");
				String serviceType = req.getParameter("serviceType");
				String serviceVersion = req.getParameter("version");
				String ServiceExposureType = req.getParameter("ServiceExposureType");
				String userType = req.getParameter("userType");
				String platformType = req.getParameter("platformType");
				String islaCarteService = req.getParameter("islaCarteService");
				String isExternal = req.getParameter("isExternal");
				String serviceTag = req.getParameter("tag");
				String usageStatistics = req.getParameter("usageStatistics");
				String channelID = req.getParameter("channelID");
				String webserviceURL = req.getParameter("webserviceURL");
				String deploymentCluster = req.getParameter("deploymentCluster");
				String deploymentLocation = req.getParameter("deploymentLocation");
				String testPlan = req.getParameter("testPlan");
				String performanceProfile = req.getParameter("performanceProfile");

				ServiceComponents entityImpl = ServiceComponentsLocalServiceUtil.getServiceComponents(pKey);
				entityImpl.setPrimaryKey(pKey);
				entityImpl.setName(serviceName);
				entityImpl.setDescription(serviceDescription);
				entityImpl.setExtra1(serviceExtra1);
				entityImpl.setTechnologyComponent(technologyComponent);
				entityImpl.setExtra2(serviceExtra2);
				entityImpl.setPhase(servicePhase);
				entityImpl.setStatus(serviceStatus);
				entityImpl.setServiceType(serviceType);
				entityImpl.setVersion(serviceVersion);
				entityImpl.setServiceExposureType(ServiceExposureType);
				entityImpl.setUserType(userType);
				entityImpl.setPlatformType(platformType);
				entityImpl.setIslaCarteService(Boolean.parseBoolean(islaCarteService));
				entityImpl.setIsExternal(Boolean.parseBoolean(isExternal));
				entityImpl.setTag(serviceTag);
				entityImpl.setUsageStatistics(usageStatistics);
				entityImpl.setChannelID(channelID);
				entityImpl.setWebserviceURL(webserviceURL);
				entityImpl.setDeploymentCluster(deploymentCluster);
				entityImpl.setDeploymentLocation(deploymentLocation);
				entityImpl.setTestPlan(testPlan);
				entityImpl.setPerformanceProfile(performanceProfile);
				entityImpl.setExtra5(Calendar.getInstance().getTime());
				entityImpl.setExtra6(Calendar.getInstance().getTime());

				// ServiceComponents actualImpl =
				// ServiceComponentsLocalServiceUtil.getServiceComponents(pKey);
				// UIHelper.copyBean(actualImpl, entityImpl, req);

				entityImpl.setDateModified(Calendar.getInstance().getTime());
				entityImpl.setAuthor(author);

				// actualImpl.setServiceExposureType(req.getParameter("ServiceExposureType"));

				ServiceComponentsLocalServiceUtil.updateServiceComponents(entityImpl);
				SessionMessages.add(req, "updated");
			}

			if (cmd != null && cmd.equals("form")) {
				long pKey = CounterLocalServiceUtil.increment("ServiceComponents.class");

				// ServiceComponents entityImpl = new ServiceComponentsImpl();

				ServiceComponents entityImpl = ServiceComponentsLocalServiceUtil.createServiceComponents(pKey);
				_log.info("ServiceComponents.class:form=>pKey:" + pKey);

				// entityImpl = (ServiceComponentsImpl)UIHelper.getObject(req,
				// ServiceComponentsImpl.class);

				entityImpl.setPrimaryKey(pKey);

				if (deleteItem != null)

					req.setAttribute("scgId", deleteItem);
				res.setProperty("scgId", deleteItem);
				res.addProperty("scgId", deleteItem);

				// entityImpl.setScgId(new Long(deleteItem).longValue());
				// mapping.findForward("spsc.servicecomponents.form");

				PortletURL url = ((ActionResponseImpl)res).createRenderURL();
				url.setParameter("struts_action", "/spsc/servicecomponents_action");
				url.setParameter("CMD", "form");
				url.setParameter("scgId", deleteItem);
				_log.info("ServiceComponents.class:url:" + url.toString());
				url.setParameter("jspPage", "/html/servicecomponents_list.jsp");
				res.sendRedirect(url.toString());

				// ServiceComponentsLocalServiceUtil.addServiceComponents(entityImpl);

			}

			// cmd = req.getParameter("CMD");

			String recId = req.getParameter("recId");

			if (cmd != null && cmd.equals("formView")) {
				String scgId = req.getParameter("scgId");
				_log.info("render form=>scgId:" + scgId);

				if (scgId != null)
					redirectURL.setParameter("scgId", scgId);
				redirectURL.setParameter("jspPage", "/html/servicecomponents_form.jsp");
				res.sendRedirect(redirectURL.toString());
			} else if (cmd != null && cmd.equals("detailView")) {
				redirectURL.setParameter("recId", recId);
				redirectURL.setParameter("jspPage", "/html/servicecomponents_detail.jsp");
				res.sendRedirect(redirectURL.toString());
			} else if (cmd != null && cmd.equals("editView")) {
				redirectURL.setParameter("recId", recId);
				redirectURL.setParameter("jspPage", "/html/servicecomponents_edit.jsp");
				res.sendRedirect(redirectURL.toString());
			} else if (cmd != null && cmd.equals("lookup")) {
				redirectURL.setParameter("jspPage", "/html/servicecomponents_lookup.jsp");
				res.sendRedirect(redirectURL.toString());
			} else if (cmd != null && cmd.equals("list")) {
				redirectURL.setParameter("jspPage", "/html/servicecomponentgroup_list.jsp");
				res.sendRedirect(redirectURL.toString());
			} else if (cmd != null && cmd.equals("iterate")) {
				redirectURL.setParameter("jspPage", "/html/servicecomponent_list.jsp");
				res.sendRedirect(redirectURL.toString());
			} else {
				redirectURL.setParameter("jspPage", "/html/servicecomponents_list.jsp");
				res.sendRedirect(redirectURL.toString());
			}
		} catch (NumberFormatException e) {
			_log.error(e);
		} catch (PortalException e) {
			_log.error(e);
		} catch (Exception e) {
			_log.error(e);
		}

	}

	public void componentGroupAction(ActionRequest req, ActionResponse res) throws IOException, PortletException {
		try {
			ServiceComponentGroupAction.serviceGroupAction(req, res);
		} catch (NumberFormatException e) {
			_log.error(e);
		} catch (Exception e) {
			_log.error(e);
		}
	}

	// 05.04.10

	public String getServiceComponentsName(String scId) throws NumberFormatException, PortalException, SystemException {

		ServiceComponents sc = null;
		try {
			sc = ServiceComponentsLocalServiceUtil.getServiceComponents(Long.parseLong(scId));
		} catch (com.liferay.portal.kernel.exception.PortalException e) {

			// TODO Auto-generated catch block

		} catch (com.liferay.portal.kernel.exception.SystemException e) {

			// TODO Auto-generated catch block

		}

		return sc.getName();
	}

	// end 05.04.10

**/
}