package com.test.api.web.model;

import java.util.Arrays;

// 기상청_단기예보 ((구)_동네예보) 조회서비스 API에서 응답한 내용을 담을 객체
public class TestResponse {

	Response response;

	public Response getResponse() {
		return response;
	}

	public void setResponse(Response response) {
		this.response = response;
	}

	public class Response {
		Header header;
		Body body;

		public Header getHeader() {
			return header;
		}

		public void setHeader(Header header) {
			this.header = header;
		}

		public Body getBody() {
			return body;
		}

		public void setBody(Body body) {
			this.body = body;
		}

		public class Header {
			String resultCode;
			String resultMsg;

			public String getResultCode() {
				return resultCode;
			}

			public void setResultCode(String resultCode) {
				this.resultCode = resultCode;
			}

			public String getResultMsg() {
				return resultMsg;
			}

			public void setResultMsg(String resultMsg) {
				this.resultMsg = resultMsg;
			}

			@Override
			public String toString() {
				return "Header [resultCode=" + resultCode + ", resultMsg=" + resultMsg + "]";
			}
		}

		public class Body {
			String dataType;
			String pageNo;
			String numOfRows;
			String totalCount;
			Items items;

			public String getDataType() {
				return dataType;
			}

			public void setDataType(String dataType) {
				this.dataType = dataType;
			}

			public String getPageNo() {
				return pageNo;
			}

			public void setPageNo(String pageNo) {
				this.pageNo = pageNo;
			}

			public String getNumOfRows() {
				return numOfRows;
			}

			public void setNumOfRows(String numOfRows) {
				this.numOfRows = numOfRows;
			}

			public String getTotalCount() {
				return totalCount;
			}

			public void setTotalCount(String totalCount) {
				this.totalCount = totalCount;
			}

			public Items getItems() {
				return items;
			}

			public void setItems(Items items) {
				this.items = items;
			}

			public class Items {
				private Item[] item;

				public Item[] getItem() {
					return item;
				}

				public void setItem(Item[] item) {
					this.item = item;
				}

				@Override
				public String toString() {
					return "Items [item=" + Arrays.toString(item) + "]";
				}

				public class Item {
					String baseDate;
					String baseTime;
					String nx;
					String ny;
					String category;
					String obsrValue;

					public String getBaseDate() {
						return baseDate;
					}

					public void setBaseDate(String baseDate) {
						this.baseDate = baseDate;
					}

					public String getBaseTime() {
						return baseTime;
					}

					public void setBaseTime(String baseTime) {
						this.baseTime = baseTime;
					}

					public String getNx() {
						return nx;
					}

					public void setNx(String nx) {
						this.nx = nx;
					}

					public String getNy() {
						return ny;
					}

					public void setNy(String ny) {
						this.ny = ny;
					}

					public String getCategory() {
						return category;
					}

					public void setCategory(String category) {
						this.category = category;
					}

					public String getObsrValue() {
						return obsrValue;
					}

					public void setObsrValue(String obsrValue) {
						this.obsrValue = obsrValue;
					}

					@Override
					public String toString() {
						return "Item [baseDate=" + baseDate + ", baseTime=" + baseTime + ", nx=" + nx + ", ny=" + ny
								+ ", category=" + category + ", obsrValue=" + obsrValue + "]";
					}
				}
			}

			@Override
			public String toString() {
				return "Body [dataType=" + dataType + ", pageNo=" + pageNo + ", numOfRows=" + numOfRows
						+ ", totalCount=" + totalCount + ", items=" + items + "]";
			}
		}

		@Override
		public String toString() {
			return "Response [header=" + header + ", body=" + body + "]";
		}

	}

	@Override
	public String toString() {
		return "TestResponse [response=" + response + "]";
	}
}