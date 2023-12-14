package egovframework.vo;

public class PersonVO{

	private static final long serialVersionUID = 1L;

	/** 아이디 */
	private String psId;

	/** 이름 */
	private String psNm;

	/** 내용 */
	private String psSexCd;

	/** 사용여부 */
	private String psBirth;

	/** 등록자 */
	private String remark;

	public String getPsId() {
		return psId;
	}

	public void setPsId(String psId) {
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

}
