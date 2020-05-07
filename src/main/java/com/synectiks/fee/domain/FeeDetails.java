package com.synectiks.fee.domain;
import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * A FeeDetails.
 */
@Entity
@Table(name = "fee_details")
public class FeeDetails implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "fee_particulars_name")
    private String feeParticularsName;

    @Column(name = "fee_particular_desc")
    private String feeParticularDesc;

    @Column(name = "student_type")
    private String studentType;

    @Column(name = "gender")
    private String gender;

    @Column(name = "amount")
    private Float amount;

    @Column(name = "status")
    private String status;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_on")
    private LocalDate createdOn;

    @Column(name = "updated_by")
    private String updatedBy;

    @Column(name = "updated_on")
    private LocalDate updatedOn;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "branch_id")
    private Long branchId;

    @Column(name = "department_id")
    private Long departmentId;

    @Column(name = "batch_id")
    private Long batchId;

    @Column(name = "facility_id")
    private Long facilityId;

    @Column(name = "transport_route_id")
    private Long transportRouteId;

    @ManyToOne
    @JsonIgnoreProperties("feeDetails")
    private FeeCategory feeCategory;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFeeParticularsName() {
        return feeParticularsName;
    }

    public FeeDetails feeParticularsName(String feeParticularsName) {
        this.feeParticularsName = feeParticularsName;
        return this;
    }

    public void setFeeParticularsName(String feeParticularsName) {
        this.feeParticularsName = feeParticularsName;
    }

    public String getFeeParticularDesc() {
        return feeParticularDesc;
    }

    public FeeDetails feeParticularDesc(String feeParticularDesc) {
        this.feeParticularDesc = feeParticularDesc;
        return this;
    }

    public void setFeeParticularDesc(String feeParticularDesc) {
        this.feeParticularDesc = feeParticularDesc;
    }

    public String getStudentType() {
        return studentType;
    }

    public FeeDetails studentType(String studentType) {
        this.studentType = studentType;
        return this;
    }

    public void setStudentType(String studentType) {
        this.studentType = studentType;
    }

    public String getGender() {
        return gender;
    }

    public FeeDetails gender(String gender) {
        this.gender = gender;
        return this;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Float getAmount() {
        return amount;
    }

    public FeeDetails amount(Float amount) {
        this.amount = amount;
        return this;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public FeeDetails status(String status) {
        this.status = status;
        return this;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public FeeDetails createdBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDate getCreatedOn() {
        return createdOn;
    }

    public FeeDetails createdOn(LocalDate createdOn) {
        this.createdOn = createdOn;
        return this;
    }

    public void setCreatedOn(LocalDate createdOn) {
        this.createdOn = createdOn;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public FeeDetails updatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
        return this;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public LocalDate getUpdatedOn() {
        return updatedOn;
    }

    public FeeDetails updatedOn(LocalDate updatedOn) {
        this.updatedOn = updatedOn;
        return this;
    }

    public void setUpdatedOn(LocalDate updatedOn) {
        this.updatedOn = updatedOn;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public FeeDetails startDate(LocalDate startDate) {
        this.startDate = startDate;
        return this;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public FeeDetails endDate(LocalDate endDate) {
        this.endDate = endDate;
        return this;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Long getBranchId() {
        return branchId;
    }

    public FeeDetails branchId(Long branchId) {
        this.branchId = branchId;
        return this;
    }

    public void setBranchId(Long branchId) {
        this.branchId = branchId;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public FeeDetails departmentId(Long departmentId) {
        this.departmentId = departmentId;
        return this;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public Long getBatchId() {
        return batchId;
    }

    public FeeDetails batchId(Long batchId) {
        this.batchId = batchId;
        return this;
    }

    public void setBatchId(Long batchId) {
        this.batchId = batchId;
    }

    public Long getFacilityId() {
        return facilityId;
    }

    public FeeDetails facilityId(Long facilityId) {
        this.facilityId = facilityId;
        return this;
    }

    public void setFacilityId(Long facilityId) {
        this.facilityId = facilityId;
    }

    public Long getTransportRouteId() {
        return transportRouteId;
    }

    public FeeDetails transportRouteId(Long transportRouteId) {
        this.transportRouteId = transportRouteId;
        return this;
    }

    public void setTransportRouteId(Long transportRouteId) {
        this.transportRouteId = transportRouteId;
    }

    public FeeCategory getFeeCategory() {
        return feeCategory;
    }

    public FeeDetails feeCategory(FeeCategory feeCategory) {
        this.feeCategory = feeCategory;
        return this;
    }

    public void setFeeCategory(FeeCategory feeCategory) {
        this.feeCategory = feeCategory;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof FeeDetails)) {
            return false;
        }
        return id != null && id.equals(((FeeDetails) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "FeeDetails{" +
            "id=" + getId() +
            ", feeParticularsName='" + getFeeParticularsName() + "'" +
            ", feeParticularDesc='" + getFeeParticularDesc() + "'" +
            ", studentType='" + getStudentType() + "'" +
            ", gender='" + getGender() + "'" +
            ", amount=" + getAmount() +
            ", status='" + getStatus() + "'" +
            ", createdBy='" + getCreatedBy() + "'" +
            ", createdOn='" + getCreatedOn() + "'" +
            ", updatedBy='" + getUpdatedBy() + "'" +
            ", updatedOn='" + getUpdatedOn() + "'" +
            ", startDate='" + getStartDate() + "'" +
            ", endDate='" + getEndDate() + "'" +
            ", branchId=" + getBranchId() +
            ", departmentId=" + getDepartmentId() +
            ", batchId=" + getBatchId() +
            ", facilityId=" + getFacilityId() +
            ", transportRouteId=" + getTransportRouteId() +
            "}";
    }
}
