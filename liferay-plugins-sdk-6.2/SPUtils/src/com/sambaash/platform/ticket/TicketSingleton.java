package com.sambaash.platform.ticket;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.sambaash.platform.srv.rsvp.model.RsvpTicket;

public class TicketSingleton {

	private static Log _log = LogFactoryUtil.getLog(TicketSingleton.class);

	private static Map<String, AtomicInteger> ticketMap;
	private static TicketSingleton obj = null;

	private TicketSingleton(RsvpTicket rsvpTicket) {
		ticketMap = new Hashtable<String, AtomicInteger>();
		AtomicInteger atomicInteger = new AtomicInteger(
				Validator.isNotNull(rsvpTicket.getLastSequenceNumber()) ? rsvpTicket
						.getLastSequenceNumber() : rsvpTicket
						.getTicketSequence());
		ticketMap.put(String.valueOf(rsvpTicket.getRsvpTicketId()),
				atomicInteger);
	}

	private void addToMap(RsvpTicket rsvpTicket) {
		AtomicInteger atomicInteger = new AtomicInteger(
				Validator.isNotNull(rsvpTicket.getLastSequenceNumber()) ? rsvpTicket
						.getLastSequenceNumber() : rsvpTicket
						.getTicketSequence());
		ticketMap.put(String.valueOf(rsvpTicket.getRsvpTicketId()),
				atomicInteger);
	}

	public static TicketSingleton getInstance(RsvpTicket rsvpTicket)
			throws PortalException, SystemException {
		if (obj == null) {
			obj = new TicketSingleton(rsvpTicket);
		}

		if (ticketMap == null) {
			ticketMap = new HashMap<String, AtomicInteger>();
		}

		return obj;
	}

	public int getTicketCounter(RsvpTicket rsvpTicket) throws SystemException {
		int counter = -1;
		if (Validator.isNull(ticketMap.get(String.valueOf(rsvpTicket
				.getRsvpTicketId())))) {
			addToMap(rsvpTicket);
		}

		counter = ticketMap.get(String.valueOf(rsvpTicket.getRsvpTicketId()))
				.getAndIncrement();

		if (_log.isDebugEnabled()) {
			_log.debug(" RsvpId  : " + rsvpTicket.getRsvpId() + " : price : "
					+ rsvpTicket.getPrice() + " : ticketCounter : " + counter);
		}

		return counter;
	}
}