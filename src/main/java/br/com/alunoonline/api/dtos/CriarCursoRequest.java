package br.com.alunoonline.api.dtos;

import br.com.alunoonline.api.enums.CursoTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CriarCursoRequest {

    private String name;

    private CursoTypeEnum type;

    private BigDecimal monthlyCost;

}
