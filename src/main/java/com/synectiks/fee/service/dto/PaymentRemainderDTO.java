package com.synectiks.fee.service.dto;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.synectiks.fee.domain.PaymentRemainder} entity.
 */
public class PaymentRemainderDTO implements Serializable {

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

    private Long branchId;


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

    public Long getBranchId() {
        return branchId;
    }

    public void setBranchId(Long branchId) {
        this.branchId = branchId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        PaymentRemainderDTO paymentRemainderDTO = (PaymentRemainderDTO) o;
        if (paymentRemainderDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), paymentRemainderDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "PaymentRemainderDTO{" +
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
