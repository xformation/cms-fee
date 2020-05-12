package com.synectiks.fee.graphql.types.invoice;

import java.time.LocalDate;

public class AbstractInvoiceInput {
    private Long id;
    private String invoiceNumber;
    private Long amountPaid;
    private LocalDate paymentDate;
    private LocalDate nextPaymentDate;
    private Long outStandingAmount;
    private String modeOfPayment;
    private Long chequeNumber;
    private Long demandDraftNumber;
    private String onlineTxnRefNumber;
    private String paymentStatus;
    private String comments;
    private String updatedBy;
    private LocalDate updatedOn;
    private String bank;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getInvoiceNumber() {
		return invoiceNumber;
	}
	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}
	public Long getAmountPaid() {
		return amountPaid;
	}
	public void setAmountPaid(Long amountPaid) {
		this.amountPaid = amountPaid;
	}
	public LocalDate getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}
	public LocalDate getNextPaymentDate() {
		return nextPaymentDate;
	}
	public void setNextPaymentDate(LocalDate nextPaymentDate) {
		this.nextPaymentDate = nextPaymentDate;
	}
	public Long getOutStandingAmount() {
		return outStandingAmount;
	}
	public void setOutStandingAmount(Long outStandingAmount) {
		this.outStandingAmount = outStandingAmount;
	}
	public String getModeOfPayment() {
		return modeOfPayment;
	}
	public void setModeOfPayment(String modeOfPayment) {
		this.modeOfPayment = modeOfPayment;
	}
	public Long getChequeNumber() {
		return chequeNumber;
	}
	public void setChequeNumber(Long chequeNumber) {
		this.chequeNumber = chequeNumber;
	}
	public Long getDemandDraftNumber() {
		return demandDraftNumber;
	}
	public void setDemandDraftNumber(Long demandDraftNumber) {
		this.demandDraftNumber = demandDraftNumber;
	}
	public String getOnlineTxnRefNumber() {
		return onlineTxnRefNumber;
	}
	public void setOnlineTxnRefNumber(String onlineTxnRefNumber) {
		this.onlineTxnRefNumber = onlineTxnRefNumber;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public LocalDate getUpdatedOn() {
		return updatedOn;
	}
	public void setUpdatedOn(LocalDate updatedOn) {
		this.updatedOn = updatedOn;
	}
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
    
    
}
