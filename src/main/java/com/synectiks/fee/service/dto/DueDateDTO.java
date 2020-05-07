package com.synectiks.fee.service.dto;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.synectiks.fee.domain.DueDate} entity.
 */
public class DueDateDTO implements Serializable {

    private Long id;

    private String paymentMethod;

    private Long installments;

    private String dayDesc;

    private Long paymentDay;

    private String frequency;

    private Long branchId;


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

        DueDateDTO dueDateDTO = (DueDateDTO) o;
        if (dueDateDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), dueDateDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "DueDateDTO{" +
            "id=" + getId() +
            ", paymentMethod='" + getPaymentMethod() + "'" +
            ", installments=" + getInstallments() +
            ", dayDesc='" + getDayDesc() + "'" +
            ", paymentDay=" + getPaymentDay() +
            ", frequency='" + getFrequency() + "'" +
            ", branchId=" + getBranchId() +
            "}";
    }
}
