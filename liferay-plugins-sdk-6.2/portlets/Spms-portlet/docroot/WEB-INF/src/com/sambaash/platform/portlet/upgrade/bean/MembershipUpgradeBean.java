package com.sambaash.platform.portlet.upgrade.bean;

//import com.liferay.portlet.login.util.LoginUtil;

import java.io.Serializable;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.portlet.RenderRequest;

/**
import sambaash.platform.srv.membershippackage.model.MembershipPackage;
import sambaash.platform.srv.membershippackage.model.MembershipPackagePromotionCode;
import sambaash.platform.srv.membershippackage.service.MembershipPackageLocalServiceUtil;
import sambaash.platform.srv.membershipsubscription.model.MembershipSubscription;
import sambaash.platform.srv.membershipsubscription.service.MembershipSubscriptionLocalServiceUtil;
import sambaash.platform.srv.socialprofile.model.SocialProfile;
import sambaash.platform.srv.spparameter.NoSuchSPParametersException;
import sambaash.platform.srv.spparameter.model.SPParameters;
import sambaash.platform.srv.spparameter.service.SPParametersLocalServiceUtil;
import sambaash.platform.upgrade.service.MembershipUpgradeService;**/
import com.sambaash.platform.constant.SambaashConstants;

public class MembershipUpgradeBean implements Serializable {
/**
		private static final long serialVersionUID = 1L;

		private static Log _log = LogFactoryUtil.getLog(MembershipUpgradeBean.class);

		private List<MembershipPackage> membershipPackages;
		private List<MembershipPackage> membershipPackagesList;
		private MembershipPackage currentMembershipPackage;
		private MembershipPackage membershipPackage;
		private MembershipPackagePromotionCode promotionCode;
		private ThemeDisplay themeDisplay;

		private String messageSuccess;

		private double gst = 0d;
		private double netTotal = 0d;

		private boolean isMembershipEmpty = false;
		private boolean upgradable = false;

		public void setProcessParameters( RenderRequest renderRequest )
		{
			try
			{
				ThemeDisplay _themeDisplay = (ThemeDisplay)
						renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

				this.setThemeDisplay( _themeDisplay );

				long userId = _themeDisplay.getUserId();

				SocialProfile socialProfile = this.getSocialProfile( userId );

				this.setCurrentMembershipPackage(
						MembershipPackageLocalServiceUtil.getMembershipPackage( socialProfile.getMemberPackage() ) );

				this.setMembershipPackages(
						MembershipPackageLocalServiceUtil.findByMembershipPackageType( socialProfile.getUserType() ) );

				this.sortMembershipPackages();
			} catch (PortalException e) {
				_log.error(e);
			} catch (SystemException e) {
				_log.error(e);
			}
		}

		public List<MembershipPackage> getDefaultPackageList()
		{
			List<MembershipPackage> list = new ArrayList<MembershipPackage>();

			for ( MembershipPackage mp : this.getMembershipPackages() )
			{
				if ( mp.getMpId() != this.getCurrentMembershipPackage().getMpId() )
				{
					if ( mp.getCost() >= this.getCurrentMembershipPackage().getCost() )
					{
						this.setUpgradable( true );

						list.add( mp );
					}
				}
			}

			//auxiliary package list

			if ( list.size() != 0 )
				this.setMembershipPackagesList( list );

			return list;
		}

		public String getPackagesJsonString()
		{
			JSONObject json = JSONFactoryUtil.createJSONObject();

			List<MembershipPackage> upgradePackages = this.getDefaultPackageList();

			int i = 0;

			if ( upgradePackages.size() != 0 )
			{
				for (MembershipPackage _package : upgradePackages)
				{
					//should be the value of package dropdown
					//json.put(Long.toString(_package.getMpId()), getPackageDescription(_package));
					//membershipPackage.setMpId( _package.getMpId() );
					json.put(i+"-"+_package.getMpId(), getPackageDescription(_package));
					i++;
				}
			}

			return json.toString();
		}

		public String getMembershipPackageJsonString()
		{

			String packageDetails = "";
			int cntr = 0;

			if ( this.getMembershipPackagesList().size() != 0 )
			{
				for (MembershipPackage mp : this.getMembershipPackagesList() )
				{
					//the first index should be setted

					if ( cntr == 0 )
					{
						packageDetails = this.getMembershipPackageJsonString( mp );
						this.setMembershipPackage(mp);
					}

					cntr++;
				}
			}

			return packageDetails;
		}

		public String getMembershipPackageJsonString( MembershipPackage mp )
		{
			JSONObject json = JSONFactoryUtil.createJSONObject();

			if (mp == null) {
				json.put("empty", true);
			} else {

				String dscount = "0";

				if (Validator.isNotNull( this.getPromotionCode() ))
					dscount = this.getPromotionCode().getDiscount();

				json.put("empty", false);
				json.put("item", mp.getName() );
				//json.put("quantity", "");
				json.put("currency", mp.getCostCurrency() );
				json.put("price", new Double( mp.getCost() ).doubleValue() );
				json.put("discount", dscount+"%");
				json.put("total", this.getTotal( mp, dscount ) );
				json.put("description", mp.getDescription() );
				json.put("details", mp.getExtra2());
			}

			return json.toString();
		}

		private SocialProfile getSocialProfile( long userId )
		{
			return MembershipUpgradeService.getUserProfile( String.valueOf( userId) );
		}

		private String getPackageDescription(MembershipPackage _package)
		{
			String validity = null;

			if (_package.getCostPeriodType().equalsIgnoreCase("weekly")) {
				validity = "Week";
			} else if (_package.getCostPeriodType().equalsIgnoreCase("monthly")) {
				validity = "Month";
			} else if (_package.getCostPeriodType().equalsIgnoreCase("yearly")) {
				validity = "Year";
			}

			return _package.getName() + " " +
					_package.getCostCurrency() + " "
						+ this.getDecimalFormat(_package.getCost()) + " / " + validity;
		}

		public double getTotal( MembershipPackage mp, String dscount )
		{
			double discount = this.getCalculateDiscount( dscount );

			double totalDiscount = mp.getCost() - (mp.getCost() * discount);

			double totalGst = ( totalDiscount * this.getGst() ) / 100;

			double total = totalDiscount + totalGst;

			//only the dicounted amount will be passing to paypal
			//payments has the computation for gst
			this.setNetTotal( this.getDecimalFormat( totalDiscount ) );

			return total;
		}

		private double getCalculateDiscount( String dscount )
		{
			return Double.parseDouble( dscount ) / 100;
		}

		public double getGst()
		{
			double gst = 0;
			try {

				SPParameters paramameter =
						SPParametersLocalServiceUtil
							.findBySPParametersGroupIdAndName(
									this.getThemeDisplay().getScopeGroupId(),
											SambaashConstants.PAYPAL_TAXFACTOR);

				gst = Double.parseDouble(paramameter.getValue());

			} catch (NoSuchSPParametersException e) {
				_log.error(e);
			} catch (SystemException e) {
				_log.error(e);
			}

			return gst;
		}

		private double getDecimalFormat( double amount )
		{
			NumberFormat nf = new DecimalFormat("###0.00");
			return Double.parseDouble( nf.format(amount) );
		}

		private void sortMembershipPackages() {
			final Comparator costSorter = new Comparator() {
				@Override
				public int compare(Object obj1, Object obj2) {
					MembershipPackage _package1 = (MembershipPackage)obj1;
					MembershipPackage _package2 = (MembershipPackage)obj2;

					if ( _package1.getCost() < _package2.getCost()) {
						return -1;
					} else if (_package2.getCost() > _package1.getCost()) {
						return 1;
					}

					return 0;
				}
			};
			Collections.sort(this.getMembershipPackages(), costSorter);
		}

		//**Getter and Setter

		public MembershipPackage getMembershipPackage() {
			return membershipPackage;
		}

		public MembershipPackage getCurrentMembershipPackage() {
			return currentMembershipPackage;
		}

		public void setCurrentMembershipPackage(
				MembershipPackage currentMembershipPackage) {
			this.currentMembershipPackage = currentMembershipPackage;
		}

		public void setMembershipPackage(MembershipPackage membershipPackage) {
			this.membershipPackage = membershipPackage;
		}

		public ThemeDisplay getThemeDisplay() {
			return themeDisplay;
		}

		public void setThemeDisplay(ThemeDisplay themeDisplay) {
			this.themeDisplay = themeDisplay;
		}

		public double getNetTotal() {
			return netTotal;
		}

		public void setNetTotal(double netTotal) {
			this.netTotal = netTotal;
		}

		public MembershipPackagePromotionCode getPromotionCode() {
			return promotionCode;
		}

		public void setPromotionCode(MembershipPackagePromotionCode promotionCode) {
			this.promotionCode = promotionCode;
		}

		public String getMessageSuccess() {
			return messageSuccess;
		}

		public void setMessageSuccess(String messageSuccess) {
			this.messageSuccess = messageSuccess;
		}

		public boolean isMembershipEmpty() {
			return isMembershipEmpty;
		}

		public void setMembershipEmpty(boolean isMembershipEmpty) {
			this.isMembershipEmpty = isMembershipEmpty;
		}

		public List<MembershipPackage> getMembershipPackages() {
			return membershipPackages;
		}

		public void setMembershipPackages(List<MembershipPackage> membershipPackages) {
			this.membershipPackages = membershipPackages;
		}

		public boolean isUpgradable() {
			return upgradable;
		}

		public void setUpgradable(boolean upgradable) {
			this.upgradable = upgradable;
		}

		public List<MembershipPackage> getMembershipPackagesList() {
			return membershipPackagesList;
		}

		public void setMembershipPackagesList(
				List<MembershipPackage> membershipPackagesList) {
			this.membershipPackagesList = membershipPackagesList;
		}

**/
}