package com.synectiks.fee.graphql.types.paymentremainder;

public class AbstractPaymentRemainderInput {
	
    private Long id;
    private String isAutoRemainder;
    private String isFirstPaymentRemainder;
    private Long firstPaymentRemainderDays;
    private String isSecondPaymentRemainder;
    private Long secondPaymentRemainderDays;
    private String isOverDuePaymentRemainder;
    private String overDuePaymentRemainderAfterDueDateOrUntilPaid;
    private Long overDuePaymentRemainderDays;
    private String isRemainderRecipients;
    private String remainderRecipients;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getIsAutoRemainder() {
		return isAutoRemainder;
	}
	public void setIsAutoRemainder(String isAutoRemainder) {
		this.isAutoRemainder = isAutoRemainder;
	}
	public String getIsFirstPaymentRemainder() {
		return isFirstPaymentRemainder;
	}
	public void setIsFirstPaymentRemainder(String isFirstPaymentRemainder) {
		this.isFirstPaymentRemainder = isFirstPaymentRemainder;
	}
	public Long getFirstPaymentRemainderDays() {
		return firstPaymentRemainderDays;
	}
	public void setFirstPaymentRemainderDays(Long firstPaymentRemainderDays) {
		this.firstPaymentRemainderDays = firstPaymentRemainderDays;
	}
	public String getIsSecondPaymentRemainder() {
		return isSecondPaymentRemainder;
	}
	public void setIsSecondPaymentRemainder(String isSecondPaymentRemainder) {
		this.isSecondPaymentRemainder = isSecondPaymentRemainder;
	}
	public Long getSecondPaymentRemainderDays() {
		return secondPaymentRemainderDays;
	}
	public void setSecondPaymentRemainderDays(Long secondPaymentRemainderDays) {
		this.secondPaymentRemainderDays = secondPaymentRemainderDays;
	}
	public String getIsOverDuePaymentRemainder() {
		return isOverDuePaymentRemainder;
	}
	public void setIsOverDuePaymentRemainder(String isOverDuePaymentRemainder) {
		this.isOverDuePaymentRemainder = isOverDuePaymentRemainder;
	}
	public String getOverDuePaymentRemainderAfterDueDateOrUntilPaid() {
		return overDuePaymentRemainderAfterDueDateOrUntilPaid;
	}
	public void setOverDuePaymentRemainderAfterDueDateOrUntilPaid(String overDuePaymentRemainderAfterDueDateOrUntilPaid) {
		this.overDuePaymentRemainderAfterDueDateOrUntilPaid = overDuePaymentRemainderAfterDueDateOrUntilPaid;
	}
	public Long getOverDuePaymentRemainderDays() {
		return overDuePaymentRemainderDays;
	}
	public void setOverDuePaymentRemainderDays(Long overDuePaymentRemainderDays) {
		this.overDuePaymentRemainderDays = overDuePaymentRemainderDays;
	}
	public String getIsRemainderRecipients() {
		return isRemainderRecipients;
	}
	public void setIsRemainderRecipients(String isRemainderRecipients) {
		this.isRemainderRecipients = isRemainderRecipients;
	}
	public String getRemainderRecipients() {
		return remainderRecipients;
	}
	public void setRemainderRecipients(String remainderRecipients) {
		this.remainderRecipients = remainderRecipients;
	}
	
    
}
