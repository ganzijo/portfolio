package com.ke.css.cimp.vo;

public class DocVo {
	private String docName = "";
	private String docVer = "";
	private String docId = "";
	private String docHeader = "";
	private String docBody = "";
	private String docFull = "";
	private String[] docIdArr = null;

	public DocVo() {
		super();
	}

	public String getDocName() {
		return docName;
	}

	public void setDocName(String docName) {
		this.docName = docName;
	}

	public String getDocVer() {
		return docVer;
	}

	public void setDocVer(String docVer) {
		this.docVer = docVer;
	}

	public String getDocId() {
		return docId;
	}

	public void setDocId(String docId) {
		this.docId = docId;
	}

	public String getDocHeader() {
		return docHeader;
	}

	public void setDocHeader(String docHeader) {
		this.docHeader = docHeader;
	}

	public String getDocBody() {
		return docBody;
	}

	public void setDocBody(String docBody) {
		this.docBody = docBody;
	}

	public String getDocFull() {
		return docFull;
	}

	public void setDocFull(String docFull) {
		this.docFull = docFull;
	}

	public String[] getDocIdArr() {
		return docIdArr;
	}

	public void setDocIdArr(String[] docIdArr) {
		this.docIdArr = docIdArr;
	}

}
