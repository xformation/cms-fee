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
 * A LateFee.
 */
@Entity
@Table(name = "late_fee")
public class LateFee implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "is_auto_late_fee")
    private String isAutoLateFee;

    @Column(name = "late_fee_days")
    private Long lateFeeDays;

    @Column(name = "charge_type")
    private String chargeType;

    @Column(name = "fixed_charges")
    private Long fixedCharges;

    @Column(name = "percent_charges")
    private String percentCharges;

    @Column(name = "late_fee_frequency")
    private String lateFeeFrequency;

    @Column(name = "late_fee_repeat_days")
    private Long lateFeeRepeatDays;

    @Column(name = "academic_year_id")
    private Long academicYearId;

    @Column(name = "term_id")
    private Long termId;

    @Column(name = "branch_id")
    private Long branchId;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsAutoLateFee() {
        return isAutoLateFee;
    }

    public LateFee isAutoLateFee(String isAutoLateFee) {
        this.isAutoLateFee = isAutoLateFee;
        return this;
    }

    public void setIsAutoLateFee(String isAutoLateFee) {
        this.isAutoLateFee = isAutoLateFee;
    }

    public Long getLateFeeDays() {
        return lateFeeDays;
    }

    public LateFee lateFeeDays(Long lateFeeDays) {
        this.lateFeeDays = lateFeeDays;
        return this;
    }

    public void setLateFeeDays(Long lateFeeDays) {
        this.lateFeeDays = lateFeeDays;
    }

    public String getChargeType() {
        return chargeType;
    }

    public LateFee chargeType(String chargeType) {
        this.chargeType = chargeType;
        return this;
    }

    public void setChargeType(String chargeType) {
        this.chargeType = chargeType;
    }

    public Long getFixedCharges() {
        return fixedCharges;
    }

    public LateFee fixedCharges(Long fixedCharges) {
        this.fixedCharges = fixedCharges;
        return this;
    }

    public void setFixedCharges(Long fixedCharges) {
        this.fixedCharges = fixedCharges;
    }

    public String getPercentCharges() {
        return percentCharges;
    }

    public LateFee percentCharges(String percentCharges) {
        this.percentCharges = percentCharges;
        return this;
    }

    public void setPercentCharges(String percentCharges) {
        this.percentCharges = percentCharges;
    }

    public String getLateFeeFrequency() {
        return lateFeeFrequency;
    }

    public LateFee lateFeeFrequency(String lateFeeFrequency) {
        this.lateFeeFrequency = lateFeeFrequency;
        return this;
    }

    public void setLateFeeFrequency(String lateFeeFrequency) {
        this.lateFeeFrequency = lateFeeFrequency;
    }

    public Long getLateFeeRepeatDays() {
        return lateFeeRepeatDays;
    }

    public LateFee lateFeeRepeatDays(Long lateFeeRepeatDays) {
        this.lateFeeRepeatDays = lateFeeRepeatDays;
        return this;
    }

    public void setLateFeeRepeatDays(Long lateFeeRepeatDays) {
        this.lateFeeRepeatDays = lateFeeRepeatDays;
    }

    public Long getAcademicYearId() {
        return academicYearId;
    }

    public LateFee academicYearId(Long academicYearId) {
        this.academicYearId = academicYearId;
        return this;
    }

    public void setAcademicYearId(Long academicYearId) {
        this.academicYearId = academicYearId;
    }

    public Long getTermId() {
        return termId;
    }

    public LateFee termId(Long termId) {
        this.termId = termId;
        return this;
    }

    public void setTermId(Long termId) {
        this.termId = termId;
    }

    public Long getBranchId() {
        return branchId;
    }

    public LateFee branchId(Long branchId) {
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
        if (!(o instanceof LateFee)) {
            return false;
        }
        return id != null && id.equals(((LateFee) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "LateFee{" +
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
