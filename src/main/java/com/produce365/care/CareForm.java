package com.produce365.care;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CareForm {
	@NotEmpty(message = "케어 항목을 입력해주세요.")
	private String category;
	@NotEmpty(message = "가격을 입력해주세요.")
	private int cost;
}

