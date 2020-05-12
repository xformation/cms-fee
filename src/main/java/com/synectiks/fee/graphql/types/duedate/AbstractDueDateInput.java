package com.synectiks.fee.graphql.types.duedate;

public class AbstractDueDateInput {
    private Long id;
    private String paymentMethod;
    private Long installments;
    private String dayDesc;
    private Long paymentDay;
    private String frequency;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public Long getInstallments() {
		return installments;
	}
	public void setInstallments(Long installments) {
		this.installments = installments;
	}
	public String getDayDesc() {
		return dayDesc;
	}
	public void setDayDesc(String dayDesc) {
		this.dayDesc = dayDesc;
	}
	public Long getPaymentDay() {
		return paymentDay;
	}
	public void setPaymentDay(Long paymentDay) {
		this.paymentDay = paymentDay;
	}
	public String getFrequency() {
		return frequency;
	}
	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}


}
