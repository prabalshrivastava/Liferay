Liferay.Service.register("Liferay.Service.Voting", "sambaash.platform.portlet.voting.service", "Voting-portlet");

Liferay.Service.registerClass(
	Liferay.Service.Voting, "Voting",
	{
		testVoting: true,
		voteUp: true,
		findByEntry: true,
		findByEntryAndUserId: true,
		findByEntryAndIp: true,
		countByEntry: true,
		countByEntryAndUserId: true,
		countByEntryAndIp: true
	}
);