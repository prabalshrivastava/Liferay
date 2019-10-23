package com.sambaash.platform.dbutility.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import com.sambaash.platform.dbutility.entity.Message;

public class MessageQueueUtil {
	private static Queue<Message> messageQueue = new LinkedList<Message>();
	private static final String TAB_SPACE = "    ";

	public static void enQueue(String userid, String data, int tabSpace) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < tabSpace; i++) {
			sb.append(TAB_SPACE);
		}
		sb.append(data);
		messageQueue.add(new Message(userid, sb.toString()));
	}

	public static String deQueue(String userid) {
		Iterator<Message> iterator = messageQueue.iterator();
		ArrayList<Message> deQueueList = new ArrayList<Message>();
		while (iterator.hasNext()) {
			Message message = iterator.next();
			if (message.getUserid().equals(userid)) {
				deQueueList.add(message);
				iterator.remove();
			}
		}
		return listToString(deQueueList);
	}

	private static String listToString(ArrayList<Message> messageList) {
		StringBuilder sb = new StringBuilder();
		for (Message message : messageList) {
			sb.append(message.getData());
			sb.append(System.getProperty("line.separator"));
		}
		return sb.toString();
	}

}
