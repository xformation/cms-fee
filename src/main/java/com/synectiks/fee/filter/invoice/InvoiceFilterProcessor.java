package com.synectiks.fee.filter.invoice;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.synectiks.fee.business.service.CmsInvoiceService;
import com.synectiks.fee.domain.vo.CmsInvoice;

@Component
public class InvoiceFilterProcessor {

	private final Logger logger = LoggerFactory.getLogger(InvoiceFilterProcessor.class);

	private Long totalInvoice = 0L;
	private Long totalPaidInvoice = 0L;
	private Long totalUnPaidInvoice = 0L;
	private Long totalCanceledInvoice = 0L;
	
	@Autowired
	private CmsInvoiceService cmsInvoiceService;

	public List<CmsInvoice> searchInvoice(String invoiceNumber, Long studentId, Long collegeId, Long branchId, Long academicYearId) throws Exception{
		return cmsInvoiceService.searchInvoice(invoiceNumber, studentId, collegeId, branchId, academicYearId);
	}

	public List<CmsInvoice> searchInvoiceOnType(String invoiceType, Long branchId, Long academicYearId) throws Exception{
		return cmsInvoiceService.searchInvoiceOnType(invoiceType, branchId, academicYearId);
	}

	public Long getTotalInvoice(Long branchId, Long academicYearId) {
		return cmsInvoiceService.getTotalInvoice(branchId, academicYearId);
	}
	public Long getTotalPaidInvoice(Long branchId, Long academicYearId) {
		return cmsInvoiceService.getTotalPaidInvoice(branchId, academicYearId);
	}
	public Long getTotalUnPaidInvoice(Long branchId, Long academicYearId) {
		return cmsInvoiceService.getTotalUnPaidInvoice(branchId, academicYearId);
	}
	public Long getTotalCanceledInvoice(Long branchId, Long academicYearId) {
		return cmsInvoiceService.getTotalCanceledInvoice(branchId, academicYearId);
	}

	public CmsInvoice getInvoiceData(Long branchId, Long academicYearId) {
//		InvoiceFilterProcessor ifp = new InvoiceFilterProcessor();
		CmsInvoice inv = new CmsInvoice();
		inv.setTotalInvoice(this.getTotalInvoice(branchId, academicYearId));
		inv.setTotalPaidInvoice(this.getTotalPaidInvoice(branchId, academicYearId));
		inv.setTotalUnPaidInvoice(this.getTotalUnPaidInvoice(branchId, academicYearId));
		inv.setTotalCanceledInvoice(this.getTotalCanceledInvoice(branchId, academicYearId));
		return inv;
	}

	public Long getTotalInvoice() {
		return totalInvoice;
	}

	public void setTotalInvoice(Long totalInvoice) {
		this.totalInvoice = totalInvoice;
	}

	public Long getTotalPaidInvoice() {
		return totalPaidInvoice;
	}

	public void setTotalPaidInvoice(Long totalPaidInvoice) {
		this.totalPaidInvoice = totalPaidInvoice;
	}

	public Long getTotalUnPaidInvoice() {
		return totalUnPaidInvoice;
	}

	public void setTotalUnPaidInvoice(Long totalUnPaidInvoice) {
		this.totalUnPaidInvoice = totalUnPaidInvoice;
	}

	public Long getTotalCanceledInvoice() {
		return totalCanceledInvoice;
	}

	public void setTotalCanceledInvoice(Long totalCanceledInvoice) {
		this.totalCanceledInvoice = totalCanceledInvoice;
	}

    @Override
    public String toString() {
        return "InvoiceFilterProcessor{" +
            "totalInvoice=" + totalInvoice +
            ", totalPaidInvoice=" + totalPaidInvoice +
            ", totalUnPaidInvoice=" + totalUnPaidInvoice +
            ", totalCanceledInvoice=" + totalCanceledInvoice +
            ", cmsInvoiceService=" + cmsInvoiceService +
            '}';
    }
}

