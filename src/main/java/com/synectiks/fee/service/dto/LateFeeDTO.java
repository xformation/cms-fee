package com.synectiks.fee.service.dto;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.synectiks.fee.domain.LateFee} entity.
 */
public class LateFeeDTO implements Serializable {

    private Long id;

    private String isAutoLateFee;

    private Long lateFeeDays;

    private String chargeType;

    private Long fixedCharges;

    private String percentCharges;

    private String lateFeeFrequency;

    private Long lateFeeRepeatDays;

    private Long academicYearId;

    private Long termId;

    private Long branchId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsAutoLateFee() {
        return isAutoLateFee;
    }

    public void setIsAutoLateFee(String isAutoLateFee) {
        this.isAutoLateFee = isAutoLateFee;
    }

    public Long getLateFeeDays() {
        return lateFeeDays;
    }

    public void setLateFeeDays(Long lateFeeDays) {
        this.lateFeeDays = lateFeeDays;
    }

    public String getChargeType() {
        return chargeType;
    }

    public void setChargeType(String chargeType) {
        this.chargeType = chargeType;
    }

    public Long getFixedCharges() {
        return fixedCharges;
    }

    public void setFixedCharges(Long fixedCharges) {
        this.fixedCharges = fixedCharges;
    }

    public String getPercentCharges() {
        return percentCharges;
    }

    public void setPercentCharges(String percentCharges) {
        this.percentCharges = percentCharges;
    }

    public String getLateFeeFrequency() {
        return lateFeeFrequency;
    }

    public void setLateFeeFrequency(String lateFeeFrequency) {
        this.lateFeeFrequency = lateFeeFrequency;
    }

    public Long getLateFeeRepeatDays() {
        return lateFeeRepeatDays;
    }

    public void setLateFeeRepeatDays(Long lateFeeRepeatDays) {
        this.lateFeeRepeatDays = lateFeeRepeatDays;
    }

    public Long getAcademicYearId() {
        return academicYearId;
    }

    public void setAcademicYearId(Long academicYearId) {
        this.academicYearId = academicYearId;
    }

    public Long getTermId() {
        return termId;
    }

    public void setTermId(Long termId) {
        this.termId = termId;
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

        LateFeeDTO lateFeeDTO = (LateFeeDTO) o;
        if (lateFeeDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), lateFeeDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "LateFeeDTO{" +
            "id=" + getId() +
            ", isAutoLateFee='" + getIsAutoLateFee() + "'" +
            ", lateFeeDays=" + getLateFeeDays() +
            ", chargeType='" + getChargeType() + "'" +
            ", fixedCharges=" + getFixedCharges() +
            ", percentCharges='" + getPercentCharges() + "'" +
            ", lateFeeFrequency='" + getLateFeeFrequency() + "'" +
            ", lateFeeRepeatDays=" + getLateFeeRepeatDays() +
            ", academicYearId=" + getAcademicYearId() +
            ", termId=" + getTermId() +
            ", branchId=" + getBranchId() +
            "}";
    }
}
