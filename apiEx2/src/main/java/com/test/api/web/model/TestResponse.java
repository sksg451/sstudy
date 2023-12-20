package com.test.api.web.model;

import java.util.Arrays;


public class TestResponse {
	MetalService MetalService;

	public MetalService getMetalService() {
		return MetalService;
	}

	public void setMetalService(MetalService metalService) {
		this.MetalService = metalService;
	}
	
	public class MetalService{
		Header header;
		Item[] item;
		public Header getHeader() {
			return header;
		}
		public void setHeader(Header header) {
			this.header = header;
		}
		public Item[] getItem() {
			return item;
		}
		public void setItem(Item[] item) {
			this.item = item;
		}
		
		public class Header{
			String code;
			String message;
			public String getCode() {
				return code;
			}
			public void setCode(String code) {
				this.code = code;
			}
			public String getMessage() {
				return message;
			}
			public void setMessage(String message) {
				this.message = message;
			}
			@Override
			public String toString() {
				return "Header [code=" + code + ", message=" + message + "]";
			}
			
			
		}
		
		public class Item{
			String SDATE;
			String STATIONCODE;
			String ITEMCODE;
			String TIMECODE;
			String VALUE;
			public String getSDATE() {
				return SDATE;
			}
			public void setSDATE(String sDATE) {
				SDATE = sDATE;
			}
			public String getSTATIONCODE() {
				return STATIONCODE;
			}
			public void setSTATIONCODE(String sTATIONCODE) {
				STATIONCODE = sTATIONCODE;
			}
			public String getITEMCODE() {
				return ITEMCODE;
			}
			public void setITEMCODE(String iTEMCODE) {
				ITEMCODE = iTEMCODE;
			}
			public String getTIMECODE() {
				return TIMECODE;
			}
			public void setTIMECODE(String tIMECODE) {
				TIMECODE = tIMECODE;
			}
			public String getVALUE() {
				return VALUE;
			}
			public void setVALUE(String vALUE) {
				VALUE = vALUE;
			}
			@Override
			public String toString() {
				return "Item [SDATE=" + SDATE + ", STATIONCODE=" + STATIONCODE + ", ITEMCODE=" + ITEMCODE
						+ ", TIMECODE=" + TIMECODE + ", VALUE=" + VALUE + "]";
			}
			
			
		}

		@Override
		public String toString() {
			return "MetalService [header=" + header + ", item=" + Arrays.toString(item) + "]";
		}
		
	}

	@Override
	public String toString() {
		return "TestResponse [metalService=" + MetalService + "]";
	}

}