package egovframework.vo;

public class PersonVO{

	private static final long serialVersionUID = 1L;

	private Integer psId;
	private String psNm;
	private String psSexCd;
	private String psBirth;
	private String psTel;
	private String psEmail;
	private String remark;
	private Integer mPartId;

	public Integer getPsId() {
		return psId;
	}

	public void setPsId(Integer psId) {
		this.psId = psId;
	}

	public String getPsNm() {
		return psNm;
	}

	public void setPsNm(String psNm) {
		this.psNm = psNm;
	}

	public String getPsSexCd() {
		return psSexCd;
	}

	public void setPsSexCd(String psSexCd) {
		this.psSexCd = psSexCd;
	}

	public String getPsBirth() {
		return psBirth;
	}

	public void setPsBirth(String psBirth) {
		this.psBirth = psBirth;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public Integer getMPartId() {
		return mPartId;
	}

	public void setMPartId(Integer mPartId) {
		this.mPartId = mPartId;
	}
	public String getPsTel() {
		return psTel;
	}

	public void setPsTel(String psTel) {
		this.psTel = psTel;
	}
	public String getPsEmail() {
		return psEmail;
	}

	public void setPsEmail(String psEmail) {
		this.psEmail = psEmail;
	}

}
