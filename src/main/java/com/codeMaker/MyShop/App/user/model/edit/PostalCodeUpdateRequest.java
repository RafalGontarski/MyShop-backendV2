package com.codeMaker.MyShop.App.user.model.edit;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostalCodeUpdateRequest {
    private String postalCode;
}
