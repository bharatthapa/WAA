package mum.edu.domain;

import java.io.Serializable;

public class InputDomain implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	private Integer sum1;
    private Integer sum2;
    private Integer sumTotal;
    
    private Integer mul1;
    private Integer mul2;
    private Integer mulTotal;
    
    public Integer getSum1() {
		return sum1;
	}
	public void setSum1(Integer sum1) {
		this.sum1 = sum1;
	}
	public Integer getSum2() {
		return sum2;
	}
	public void setSum2(Integer sum2) {
		this.sum2 = sum2;
	}
	public Integer getSumTotal() {
		sumTotal=sum1+sum2;
		return sumTotal;
	}
	public void setSumTotal(Integer sumTotal) {
		this.sumTotal = sumTotal;
	}
	public Integer getMul1() {
		return mul1;
	}
	public void setMul1(Integer mul1) {
		this.mul1 = mul1;
	}
	public Integer getMul2() {
		return mul2;
	}
	public void setMul2(Integer mul2) {
		this.mul2 = mul2;
	}
	public Integer getMulTotal() {
		mulTotal=mul1*mul2;
		return mulTotal;
	}
	public void setMulTotal(Integer mulTotal) {
		this.mulTotal = mulTotal;
	}
	
	
    
	

}
