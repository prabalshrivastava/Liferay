package com.sambaash.platform.finance.constants;

public class FinanceConstants {
	
	private FinanceConstants() {}
	public static final String PREF_SHOW_PENDING = "showPendingPref";
	public static final String PREF_SUBMIT_CLAIM_DETAIL_URL = "submitClaimDetailUrlPref";
	public static final String PREF_RECEIPT_BASE_URL = "receiptBaseUrlPref";
	public static final String PREF_PAY_ONLINE_BASE_URL = "payOnlineBaseUrlPref";
	public static final String PREF_CATEGORY_TYPE = "categoryTypePref";
	public static final String PREF_IS_NOTIFY = "isNotifyPref";
	public static final String PREF_EMAIL_ADRESSES = "emailAddressesPref";
	public static final String PREF_INVOICE_TYPE = "invoiceTypePref";
	public static final String PREF_SEND_NOTIFICATION = "sendNotificationPref";
	public static final String PREF_ENABLE_APPROVAL = "enableApprovalPref";
	public static final String PREF_LIST_HEADER = "listHeaderPref";
	public static final String PREF_DISCLAIMER_HYPERLINK = "disclaimerHyperLinkUrlPref";
	public static final String STRIPE_KEY = "pk_test_RrgPSULOAyk19py3fwTCM2aN";
	public static final String FINANCE_SUBMITTER_ROLE = "Finance Submitter";
	public static final String FINANCE_VERIFIER_ROLE = "Finance Verifier";
	public static final String FINANCE_APPROVER_ROLE = "Finance Approver";
	public static final String EB_SUBMITTER_ROLE = "EB Submitter";
	public static final String AA_EXECUTIVE_ROLE = "AA Executive";
	public static final String FINANCE_EXECUTIVE_ROLE = "Finance Executive";
	public static final String RECEIPT_NOTIFICATION = "RECEIPT_NOTIFICATION";
	public static final String NOTIFICATION_TYPE_VOID_RECEIPT = "NOTIFICATION_TYPE_VOID_RECEIPT";
	public static final String NOTIFICATION_TYPE_CANCEL_RECEIPT = "NOTIFICATION_TYPE_CANCEL_RECEIPT";
	public static final String NOTIFICATION_TYPE_RETURN_RECEIPT = "NOTIFICATION_TYPE_RETURN_RECEIPT";
	public static final String NOTIFICATION_TYPE = "notificationType";
	public static final String NOTIFICATION_LINK = "friendlyUrl";
	public static final String NOTIFICATION_TITLE = "title";
	public static final String NOTIFICATION_RECEIPT_NUMBER = "receiptNumber";
	public static final String APPROVER_RECEIPT_NOTIFICATION_BODY = "Receipt <a href='link'><b>#receiptNumber</b></a> is waiting for your approval.";
	public static final String SUBMITTER_RECEIPT_NOTIFICATION_BODY = "Receipt <a href='link'><b>#receiptNumber</b></a> is sent back for amendments.";
	public static final String PREF_CREDIT_NOTES_URL = "creditNotesUrlPref";
	public static final String SUBMITTED_FOR_VERIFICATION = "Submitted For Verification";
	public static final String PENDING_VERIFICATION = "Pending Verification";
	public static final String PENDING_AMENDMENTS = "Pending Amendments";
	public static final String RETURN_FOR_AMENDMENTS = "Returned For Amendments";
	public static final String REJECT = "Reject";
	public static final String REJECTED = "Rejected";
	public static final String PENDING_APPROVAL = "Pending Approval";
	public static final String SUBMITTED_FOR_APPROVAL = "Submitted For Approval";
	public static final String APPROVED = "Approved";
	public static final String SUBMITTER_ROLE_PARAM = "Submitter Roles";
	public static final String VERIFIER_ROLE_PARAM = "Verifier Roles";
	public static final String APPROVER_ROLE_PARAM = "Approver Roles";
	public static final String SUBMIT_CLAIM_SUBMITTER_MAIL_TEMPLATE = "submitclaim.submitter.mailtemplate";
	public static final String SUBMIT_CLAIM_VERIFIER_MAIL_TEMPLATE = "submitclaim.verifier.mailtemplate";
	public static final String SUBMIT_CLAIM_APPROVER_MAIL_TEMPLATE = "submitclaim.approver.mailtemplate";
	public static final String SUBMIT_CLAIM_APPROVED_MAIL_TEMPLATE = "submitclaim.approved.mailtemplate";
	public static final String SUBMIT_CLAIM_REJECTED_MAIL_TEMPLATE = "submitclaim.rejected.mailtemplate";
	public static final String SUBMIT_CLAIM_RFA_MAIL_TEMPLATE = "submitclaim.rfa.mailtemplate";
	
}
