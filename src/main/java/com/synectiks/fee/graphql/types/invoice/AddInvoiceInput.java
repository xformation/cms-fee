package com.synectiks.fee.graphql.types.invoice;

import java.util.Objects;

public class AddInvoiceInput extends AbstractInvoiceInput{
    private Long feeCategoryId;
    private Long feeDetailsId;
    private Long dueDateId;
    private Long paymentRemainderId;
    private Long branchId;
    private Long studentId;
    private Long academicYearId;
    private Long departmentId;

    public Long getFeeCategoryId() {
        return feeCategoryId;
    }

    public void setFeeCategoryId(Long feeCategoryId) {
        this.feeCategoryId = feeCategoryId;
    }

    public Long getFeeDetailsId() {
        return feeDetailsId;
    }

    public void setFeeDetailsId(Long feeDetailsId) {
        this.feeDetailsId = feeDetailsId;
    }

    public Long getDueDateId() {
        return dueDateId;
    }

    public void setDueDateId(Long dueDateId) {
        this.dueDateId = dueDateId;
    }

    public Long getPaymentRemainderId() {
        return paymentRemainderId;
    }

    public void setPaymentRemainderId(Long paymentRemainderId) {
        this.paymentRemainderId = paymentRemainderId;
    }

    public Long getBranchId() {
        return branchId;
    }

    public void setBranchId(Long branchId) {
        this.branchId = branchId;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getAcademicYearId() {
        return academicYearId;
    }

    public void setAcademicYearId(Long academicYearId) {
        this.academicYearId = academicYearId;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }
}
