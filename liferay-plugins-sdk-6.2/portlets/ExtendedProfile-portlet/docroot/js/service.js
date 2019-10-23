Liferay.Service.register("Liferay.Service.ExtendedProfile", "com.sambaash.platform.srv.service", "ExtendedProfile-portlet");

Liferay.Service.registerClass(
	Liferay.Service.ExtendedProfile, "Certification",
	{
		findByUserIdAndCertificationId: true,
		findByUserId: true
	}
);

Liferay.Service.registerClass(
	Liferay.Service.ExtendedProfile, "Competency",
	{
		findByCompetencyList: true,
		findByCategoryIdAndCompetencyId: true,
		findByCategoryId: true
	}
);

Liferay.Service.registerClass(
	Liferay.Service.ExtendedProfile, "JobRole",
	{
		findByJobRole: true
	}
);