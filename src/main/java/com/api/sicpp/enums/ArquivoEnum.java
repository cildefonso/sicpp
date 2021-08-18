package com.api.sicpp.enums;

public enum ArquivoEnum {

	PDF(".pdf", "application/pdf"), 
	XLS(".xls", "application/vnd.ms-excel"),
	XLSX(".xlsx", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");

	private final String extensao;
	private final String mimeType;

	ArquivoEnum(final String extensao, final String mimeType) {
		this.extensao = extensao;
		this.mimeType = mimeType;
	}

	public String getExtensao() {
		return extensao;
	}

	public String getMimeType() {
		return mimeType;
	}
}