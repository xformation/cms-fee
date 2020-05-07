package com.synectiks.fee.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * A PaymentRemainder.
 */
@Entity
@Table(name = "payment_remainder")
public class PaymentRemainder implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "is_auto_remainder")
    private String isAutoRemainder;

    @Column(name = "is_first_payment_remainder")
    private String isFirstPaymentRemainder;

    @Column(name = "first_payment_remainder_days")
    private Long firstPaymentRemainderDays;

    @Column(name = "is_second_payment_remainder")
    private String isSecondPaymentRemainder;

    @Column(name = "second_payment_remainder_days")
    private Long secondPaymentRemainderDays;

    @Column(name = "is_over_due_payment_remainder")
    private String isOverDuePaymentRemainder;

    @Column(name = "over_due_payment_remainder_after_due_date_or_until_paid")
    private String overDuePaymentRemainderAfterDueDateOrUntilPaid;

    @Column(name = "over_due_payment_remainder_days")
    private Long overDuePaymentRemainderDays;

    @Column(name = "is_remainder_recipients")
    private String isRemainderRecipients;

    @Column(name = "remainder_recipients")
    private String remainderRecipients;

    @Column(name = "branch_id")
    private Long branchId;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsAutoRemainder() {
        return isAutoRemainder;
    }

    public PaymentRemainder isAutoRemainder(String isAutoRemainder) {
        this.isAutoRemainder = isAutoRemainder;
        return this;
    }

    public void setIsAutoRemainder(String isAutoRemainder) {
        this.isAutoRemainder = isAutoRemainder;
    }

    public String getIsFirstPaymentRemainder() {
        return isFirstPaymentRemainder;
    }

    public PaymentRemainder isFirstPaymentRemainder(String isFirstPaymentRemainder) {
        this.isFirstPaymentRemainder = isFirstPaymentRemainder;
        return this;
    }

    public void setIsFirstPaymentRemainder(String isFirstPaymentRemainder) {
        this.isFirstPaymentRemainder = isFirstPaymentRemainder;
    }

    public Long getFirstPaymentRemainderDays() {
        return firstPaymentRemainderDays;
    }

    public PaymentRemainder firstPaymentRemainderDays(Long firstPaymentRemainderDays) {
        this.firstPaymentRemainderDays = firstPaymentRemainderDays;
        return this;
    }

    public void setFirstPaymentRemainderDays(Long firstPaymentRemainderDays) {
        this.firstPaymentRemainderDays = firstPaymentRemainderDays;
    }

    public String getIsSecondPaymentRemainder() {
        return isSecondPaymentRemainder;
    }

    public PaymentRemainder isSecondPaymentRemainder(String isSecondPaymentRemainder) {
        this.isSecondPaymentRemainder = isSecondPaymentRemainder;
        return this;
    }

    public void setIsSecondPaymentRemainder(String isSecondPaymentRemainder) {
        this.isSecondPaymentRemainder = isSecondPaymentRemainder;
    }

    public Long getSecondPaymentRemainderDays() {
        return secondPaymentRemainderDays;
    }

    public PaymentRemainder secondPaymentRemainderDays(Long secondPaymentRemainderDays) {
        this.secondPaymentRemainderDays = secondPaymentRemainderDays;
        return this;
    }

    public void setSecondPaymentRemainderDays(Long secondPaymentRemainderDays) {
        this.secondPaymentRemainderDays = secondPaymentRemainderDays;
    }

    public String getIsOverDuePaymentRemainder() {
        return isOverDuePaymentRemainder;
    }

    public PaymentRemainder isOverDuePaymentRemainder(String isOverDuePaymentRemainder) {
        this.isOverDuePaymentRemainder = isOverDuePaymentRemainder;
        return this;
    }

    public void setIsOverDuePaymentRemainder(String isOverDuePaymentRemainder) {
        this.isOverDuePaymentRemainder = isOverDuePaymentRemainder;
    }

    public String getOverDuePaymentRemainderAfterDueDateOrUntilPaid() {
        return overDuePaymentRemainderAfterDueDateOrUntilPaid;
    }

    public PaymentRemainder overDuePaymentRemainderAfterDueDateOrUntilPaid(String overDuePaymentRemainderAfterDueDateOrUntilPaid) {
        this.overDuePaymentRemainderAfterDueDateOrUntilPaid = overDuePaymentRemainderAfterDueDateOrUntilPaid;
        return this;
    }

    public void setOverDuePaymentRemainderAfterDueDateOrUntilPaid(String overDuePaymentRemainderAfterDueDateOrUntilPaid) {
        this.overDuePaymentRemainderAfterDueDateOrUntilPaid = overDuePaymentRemainderAfterDueDateOrUntilPaid;
    }

    public Long getOverDuePaymentRemainderDays() {
        return overDuePaymentRemainderDays;
    }

    public PaymentRemainder overDuePaymentRemainderDays(Long overDuePaymentRemainderDays) {
        this.overDuePaymentRemainderDays = overDuePaymentRemainderDays;
        return this;
    }

    public void setOverDuePaymentRemainderDays(Long overDuePaymentRemainderDays) {
        this.overDuePaymentRemainderDays = overDuePaymentRemainderDays;
    }

    public String getIsRemainderRecipients() {
        return isRemainderRecipients;
    }

    public PaymentRemainder isRemainderRecipients(String isRemainderRecipients) {
        this.isRemainderRecipients = isRemainderRecipients;
        return this;
    }

    public void setIsRemainderRecipients(String isRemainderRecipients) {
        this.isRemainderRecipients = isRemainderRecipients;
    }

    public String getRemainderRecipients() {
        return remainderRecipients;
    }

    public PaymentRemainder remainderRecipients(String remainderRecipients) {
        this.remainderRecipients = remainderRecipients;
        return this;
    }

    public void setRemainderRecipients(String remainderRecipients) {
        this.remainderRecipients = remainderRecipients;
    }

    public Long getBranchId() {
        return branchId;
    }

    public PaymentRemainder branchId(Long branchId) {
        this.branchId = branchId;
        return this;
    }

    public void setBranchId(Long branchId) {
        this.branchId = branchId;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PaymentRemainder)) {
            return false;
        }
        return id != null && id.equals(((PaymentRemainder) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "PaymentRemainder{" +
            "id=" + getId() +
            ", isAutoRemainder='" + getIsAutoRemainder() + "'" +
            ", isFirstPaymentRemainder='" + getIsFirstPaymentRemainder() + "'" +
            ", firstPaymentRemainderDays=" + getFirstPaymentRemainderDays() +
            ", isSecondPaymentRemainder='" + getIsSecondPaymentRemainder() + "'" +
            ", secondPaymentRemainderDays=" + getSecondPaymentRemainderDays() +
            ", isOverDuePaymentRemainder='" + getIsOverDuePaymentRemainder() + "'" +
            ", overDuePaymentRemainderAfterDueDateOrUntilPaid='" + getOverDuePaymentRemainderAfterDueDateOrUntilPaid() + "'" +
            ", overDuePaymentRemainderDays=" + getOverDuePaymentRemainderDays() +
            ", isRemainderRecipients='" + getIsRemainderRecipients() + "'" +
            ", remainderRecipients='" + getRemainderRecipients() + "'" +
            ", branchId=" + getBranchId() +
            "}";
    }
}
