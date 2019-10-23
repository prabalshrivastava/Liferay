package com.sambaash.platform.pe.helpers;

import java.util.Date;
import java.util.Map;
import java.util.WeakHashMap;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.sambaash.platform.constant.PEConstantsGlobal;
import com.sambaash.platform.pe.PEEntityClassRegister;
import com.sambaash.platform.pe.PEError;
import com.sambaash.platform.pe.PERequestData;
import com.sambaash.platform.pe.constants.PEConstants;
import com.sambaash.platform.pe.error.PEErrors;
import com.sambaash.platform.pe.exception.PEException;
import com.sambaash.platform.pe.exception.PEProcessStateException;
import com.sambaash.platform.pe.jaxb.PEProcessableNode;
import com.sambaash.platform.srv.processbuilder.model.PEProcess;
import com.sambaash.platform.srv.processbuilder.model.PEProcessState;
import com.sambaash.platform.srv.processbuilder.service.PEProcessStateLocalServiceUtil;

public class PEProcessStateHelper {

	private static Map<String, String> locks = new WeakHashMap<>();

	// Guest processstate will have userIdProcess value zero. This field
	// indicates actual user who is going to go thorough process flow

	public static PEProcessState createPrcoessStateGuest(PEProcess process, long entityClassId, long entityId,
			PERequestData requestData) throws SystemException, PEException {

		PEProcessState processState = null;
		processState = PEProcessStateLocalServiceUtil.createWithPrimaryKeyZero();

		// actual user (applicant) who is undergoing through process
		processState.setUserIdProcess(0);
		// UserIdCreator represents the one who is creating this application.
		// Could be agent or actual user
		processState.setUserIdCreator(requestData.getUserId());
		long tempEntityClassId = (entityClassId == PEConstantsGlobal.PROCESS_DEFAULT_ENTITY)
				? process.getEntityClassId() : entityClassId;

		if (!PEEntityClassRegister.isRegisteredClass(tempEntityClassId)) {
			_log.error("Invalid ClassNameId supplied.");
			throw new PEException("Error in Configuration.Class Name Id is not valid.");
		}
		processState.setEntityClassId(tempEntityClassId);
		if (entityId == 0) {
			throw new PEException(PEErrors.INVALID_STATUS_ENTITY_ID);
		}
		processState.setEntityId(entityId);
		processState.setSpPEProcessId(process.getSpPEProcessId());

		PEHelper.fillAudit(processState, requestData, true);

		// TODO: move the code to respective action
		/*
		 * try { ClassName cn =
		 * ClassNameLocalServiceUtil.getClassName(process.getEntityClassId());
		 * // this code should run only for Product App.
		 * if(cn.getClassName().contains(Product.class.getName())){ Product
		 * product = ProductLocalServiceUtil.getProduct(classPK); Course course
		 * = CourseLocalServiceUtil.getCourse(product.getSpCourseId());
		 * AssetCategory catg =
		 * AssetCategoryLocalServiceUtil.getAssetCategory(GetterUtil.getLong(
		 * course.getCountryId())); long supervisorId =
		 * ProductSupervisorLocalServiceUtil .getSupervisor(catg.getName(), 0,
		 * 0); if (supervisorId > 0) {
		 * processState.setUserIdSupervisor(supervisorId); } } } catch
		 * (Exception e) { _log.error(e); }
		 */

		// comment till here if the process is directly initiated from form.

		if (PEProcessHelper.isAgent(requestData.getUser(), process)) {
			processState.setUserIdAgent(requestData.getUserId());
		}

		if (PEProcessHelper.isSupervisor(requestData.getUser(), process)) {
			processState.setUserIdSupervisor(requestData.getUserId());
		}

		return processState;
	}

	public static PEProcessState getProcessState(long entityClassId, long entityId, PEProcess process,
			PERequestData requestData) throws SystemException, PEException {
		PEProcessState processState = null;

		processState = createPrcoessStateGuest(process, entityClassId, entityId, requestData);
		/*
		 * if (!themeDisplay.isSignedIn()){ // Guest
		 * 
		 * // Guest processstate will have userIdProcess value zero. //
		 * CreateAccount action is responsible for updating processState to have
		 * actual userId who is owning the process
		 * 
		 * processState = createPrcoessStateGuest(process, classPK,
		 * themeDisplay); }else if (
		 * PEProcessHelper.isAgent(themeDisplay.getUser(), process)) {
		 * 
		 * // this case also same guest.. because actual user is not agent.
		 * 
		 * processState = createPrcoessStateGuest(process, classPK,
		 * themeDisplay); }else {
		 * 
		 * // actual user -- // signed in user. Get process state, if not exist
		 * it will create one using supplied params
		 * 
		 * processState = createPEprocessState(classPK,
		 * themeDisplay.getUserId(), themeDisplay, process); }
		 */
		return processState;
	}

	public static boolean isValidProcessState(PEProcessState processState) {

		if (processState == null || processState.getUserIdProcess() == 0 || processState.getEntityClassId() == 0
				|| processState.getEntityId() == 0 || processState.getSpPEProcessId() == 0
				|| processState.getNodeId() == 0 || processState.getSpPEProcessStateId() == 0) {
			return false;
		}

		return true;
	}

	public static void updateErrorSafe(PEProcessState processState, PEError error, PERequestData requestData) {
		if (Validator.isNotNull(error) && Validator.isNotNull(processState)) {
			
			if (_log.isDebugEnabled()) {
				StringBuilder sb = new StringBuilder("Printing Stack Trace for Debugging Purpose \n");
				sb.append("Process ID : ")
				.append(processState.getSpPEProcessId())
				.append(" : ProcessStateId : ")
				.append(processState.getSpPEProcessStateId())
				.append(" : ProcessStageId : ")
				.append(processState.getSpPEProcessStageId())
				.append(" : NodeId : ")
				.append(processState.getNodeId())
				.append(" : NodeIdLastProcessed : ")
				.append(processState.getNodeIdLastProcessed())
				.append(" : UserIdProcess : ")
				.append(processState.getUserIdProcess())
				.append(StringPool.NEW_LINE);
				for (StackTraceElement ste : Thread.currentThread().getStackTrace()) {
					sb.append(StringPool.NEW_LINE).append(ste);
				}
				_log.debug(sb.toString());
			}
			
			processState.setLastErrorCode(error.getCode());
			processState.setLastErrorMsg(error.getMsg());
			processState.setLastErrorDate(new Date());
			PEProcessStateHelper.updateProcessStateSafe(processState, requestData);
		}
	}

	/**
	 * This method must be called only to persist process state.
	 * 
	 * @param processState
	 * @param requestData
	 * @throws PEProcessStateException
	 * @throws SystemException
	 */
	public static void updateProcessState(PEProcessState processState, PERequestData requestData)
			throws PEProcessStateException, SystemException {
		updateProcessState(processState, requestData, PEConstants.ACTION_DONE);
	}

	/**
	 * Used to persist process state.
	 * 
	 * Action Done parameter used to indicate if any action done on process
	 * state, if so it will update process state. In below sceanrios ActionDone
	 * is fasle 1. while locking/unlocking the application, ProcessState has to
	 * be updated but not modified date. 2. When there is no change in nodeId of
	 * application being processed.
	 * 
	 * 
	 * @param processState
	 * @param requestData
	 * @param actionDone
	 *            - True - used to set modified date
	 * @throws PEProcessStateException
	 * @throws SystemException
	 */
	public static void updateProcessState(PEProcessState processState, PERequestData requestData, boolean actionDone)
			throws PEProcessStateException, SystemException {

		if (processState.isNew() || processState.getSpPEProcessStateId() == 0) {
			processState.setSpPEProcessStateId(PEProcessStateLocalServiceUtil.getNewPrimaryKey());
			processState.setActiveStatus(PEConstantsGlobal.ACTIVE_STATUS_ACTIVE);
		}

		if (!isValidProcessState(processState)) {
			_log.error("trying to persist invialid process state. One or more PK fields in Process State are 0 "
					+ processState);
			throw new PEProcessStateException(
					PEErrors.format(PEErrors.PROCESS_STATE_MISSKING_PK_FIELD_ARGS, processState.toString()));
		}

		// AUDIT must be done only if there is action related to process.
		if (actionDone) {
			PEHelper.fillAudit(processState, requestData, processState.isNew());
		}
		PEProcessStateLocalServiceUtil.updatePEProcessState(processState);
		// updateProcessState(processState);
	}

	// whenever node execution is done, this method must be called to update
	// processstate.

	public static void updateProcessStateLastTraversedNode(PEProcessableNode node, PEProcessState processState)
			throws PEProcessStateException, SystemException {
		if (Validator.isNotNull(node)) {
			processState.setNodeIdLastProcessed(node.getNodeId());

			if (node.isDisplayable()) {
				processState.setNodeIdLastDisplayed(node.getNodeId());
			}

			if (node.isDataSubmittable()) {
				processState.setNodeIdLastDataSubmitted(node.getNodeId());
			}
		}
		// updateProcessState(processState);
	}

	// whenever node is going to be executed, this method must be called to
	// update processstate.

	public static void updateProcessStateNextNodeToProcess(PEProcessableNode node, PEProcessState processState)
			throws PEProcessStateException, SystemException {
		if (Validator.isNotNull(node)) {
			processState.setNodeId(node.getNodeId());
		}
		// updateProcessState(processState);
	}

	public static void updateProcessStateSafe(PEProcessState processState, PERequestData requestData) {
		updateProcessStateSafe(processState, requestData, PEConstants.ACTION_DONE);
	}

	public static void updateProcessStateSafe(PEProcessState processState, PERequestData requestData,
			boolean actionDone) {
		if (isValidProcessState(processState)) {
			try {
				PEProcessStateHelper.updateProcessState(processState, requestData, actionDone);
			} catch (SystemException | PEProcessStateException e) {
				_log.error("Error while updating process state ", e);
			}
		}
	}

	public static boolean obtainLock(PEProcessState processState, PERequestData requestData) {
		long start = System.currentTimeMillis();
		// PEProcessState processState = dataSource.getProcessState();
		// PERequestData requestData = dataSource.getRequestData();
		// new applications are not rerquired to lock
		if (processState.isNew()) {
			return true;
		}

		// max number of times trying to get lock
		int tolerance = 3;

		// each time when fail to get lock then wait 3 secds
		long toleranceUnit = 3 * 1000l;
		while (tolerance-- > 0) {
			if (processState.getLock() == PEConstants.LOCKED) {
				try {
					Thread.sleep(toleranceUnit);
					// get the latest
					processState = PEProcessStateLocalServiceUtil.clearCacheAndGetProcessState(processState);
				} catch (Exception e) {
					_log.error(e);
				}
			} else {
				String lock = getLock(String.valueOf(processState.getSpPEProcessStateId()));// String.valueOf(processState.getSpPEProcessStateId())
																							// +
																							// "processsate";
				synchronized (lock) {
					try {
						processState = PEProcessStateLocalServiceUtil.clearCacheAndGetProcessState(processState);
						if (processState.getLock() == PEConstants.LOCKED) {
							continue;
						}
						lockApplicationAndSave(processState, requestData);
						long end = System.currentTimeMillis();
						_log.error("Time taken while acquiring the lock" + (end - start) / 1000);
						return true;
					} catch (Exception e) {
						_log.error(e);
					}
				}
			}
		}

		Date lockedDate = processState.getLockDate();
		if (lockedDate != null) {
			long lockedTime = lockedDate.getTime();
			long currentTime = DateUtil.newTime();

			long lockedPeriod = currentTime - lockedTime;

			// 2 minutes, if it is locked for more than 3 min then unlock it
			long lockTolerance = 2 * 60 * 1000;
			if (lockedPeriod > lockTolerance) {
				unLockApplicationAndSave(processState, requestData);
				return obtainLock(processState, requestData);
			}
		} else {
			unLockApplicationAndSave(processState, requestData);
			return obtainLock(processState, requestData);
		}

		return false;
	}

	public static void lockApplicationAndSave(PEProcessState processState, PERequestData requestData) {
		processState.setLock(PEConstants.LOCKED);
		processState.setLockDate(DateUtil.newDate());
		updateProcessStateSafe(processState, requestData, PEConstants.ACTION_NOT_DONE);
	}

	public static void unLockApplicationAndSave(PEProcessState processState, PERequestData requestData) {
		if (processState.getLock() == PEConstants.LOCKED) {
			unlockApplication(processState);
			updateProcessStateSafe(processState, requestData, PEConstants.ACTION_NOT_DONE);
		}
	}

	public static void unlockApplication(PEProcessState processState) {
		processState.setLock(PEConstants.UNLOCKED);
		processState.setLockDate(null);
	}

	private static String getLock(String id) {
		String lock = locks.get(id);
		if (Validator.isNull(lock)) {
			synchronized (locks) {
				if (locks.get(id) == null) {
					locks.put(id, id);
				}
			}
		}
		return locks.get(id);
	}

	public static boolean isRejectedApplicaiton(PEProcessState processState) {
		return PEConstantsGlobal.STATUS_REJECTED.equalsIgnoreCase(processState.getStatus());
	}

	public static boolean isActiveApplicaiton(PEProcessState processState) {
		return PEConstantsGlobal.ACTIVE_STATUS_ACTIVE == processState.getActiveStatus();
	}

	public static boolean isApprovedStatusType(PEProcessState processState) {
		return PEConstantsGlobal.STATUS_APPROVED.equalsIgnoreCase(processState.getStatus());
	}

	public static boolean isPendingStatusType(PEProcessState processState) {
		return PEConstantsGlobal.STATUS_PENDING.equalsIgnoreCase(processState.getStatus());
	}

	public static boolean isConvertedToOtherApplication(PEProcessState processState) {
		return processState.getConvertedToProcessStateId() > 0;
	}

	// Pending application.
	public static boolean isOpenApplication(PEProcessState processState) {
		return (!PEProcessStateHelper.isRejectedApplicaiton(processState) && processState.getClosedStageId() == 0
				&& PEProcessStateHelper.isActiveApplicaiton(processState)
				&& !PEProcessStateHelper.isConvertedToOtherApplication(processState));
	}

	private static Log _log = LogFactoryUtil.getLog(PEProcessStateHelper.class);
}
