package com.nuriapp.vo;

public class ServerConfigVO {
	public String ip1;
	public String ip2;
	public String ip3;
	public String ip4;
	public String portNum;
	public String retrySec;
	public String retryNum;
	public String timeoutSec;
	
	public ServerConfigVO(String ip1, String ip2, String ip3, String ip4,
			String portNum, String retrySec, String retryNum, String timeoutSec) {
		super();
		this.ip1 = ip1;
		this.ip2 = ip2;
		this.ip3 = ip3;
		this.ip4 = ip4;
		this.portNum = portNum;
		this.retrySec = retrySec;
		this.retryNum = retryNum;
		this.timeoutSec = timeoutSec;
	}

	public ServerConfigVO(String string) {
		// TODO Auto-generated constructor stub
		this.ip1 = string;
	}

	public String getIp1() {
		return ip1;
	}

	public void setIp1(String ip1) {
		this.ip1 = ip1;
	}

	public String getIp2() {
		return ip2;
	}

	public void setIp2(String ip2) {
		this.ip2 = ip2;
	}

	public String getIp3() {
		return ip3;
	}

	public void setIp3(String ip3) {
		this.ip3 = ip3;
	}

	public String getIp4() {
		return ip4;
	}

	public void setIp4(String ip4) {
		this.ip4 = ip4;
	}

	public String getPortNum() {
		return portNum;
	}

	public void setPortNum(String portNum) {
		this.portNum = portNum;
	}

	public String getRetrySec() {
		return retrySec;
	}

	public void setRetrySec(String retrySec) {
		this.retrySec = retrySec;
	}

	public String getRetryNum() {
		return retryNum;
	}

	public void setRetryNum(String retryNum) {
		this.retryNum = retryNum;
	}

	public String getTimeoutSec() {
		return timeoutSec;
	}

	public void setTimeoutSec(String timeoutSec) {
		this.timeoutSec = timeoutSec;
	}

	
}
