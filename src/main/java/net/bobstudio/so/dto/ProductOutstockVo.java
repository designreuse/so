package net.bobstudio.so.dto;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class ProductOutstockVo {
	private Long id;

	private ProductVo product;
	
	private String standard;
	
	private String barcode;
	
	private Integer numStock;
	
	private Date posDate;	//出库时间
	
	private String remark;
	
	private String receipt;	//出库单据号
	
	private AccountVo outstocker;	//出库人
	
	private AccountVo salesman;	//业务员
	
	private CustomerVo customer;
	
	public ProductOutstockVo(){
		//
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ProductVo getProduct() {
		return product;
	}

	public void setProduct(ProductVo product) {
		this.product = product;
	}

	public String getStandard() {
		return standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public Integer getNumStock() {
		return numStock;
	}

	public void setNumStock(Integer numStock) {
		this.numStock = numStock;
	}

	public Date getPosDate() {
		return posDate;
	}

	public void setPosDate(Date posDate) {
		this.posDate = posDate;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getReceipt() {
		return receipt;
	}

	public void setReceipt(String receipt) {
		this.receipt = receipt;
	}

	public AccountVo getOutstocker() {
		return outstocker;
	}

	public void setOutstocker(AccountVo outstocker) {
		this.outstocker = outstocker;
	}

	public AccountVo getSalesman() {
		return salesman;
	}

	public void setSalesman(AccountVo salesman) {
		this.salesman = salesman;
	}

	public CustomerVo getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerVo customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
