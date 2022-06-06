package ufrn.br.projetoaulaweb.dtos;

import lombok.Data;
import ufrn.br.projetoaulaweb.model.Deficiencia;

import java.io.Serializable;
import java.util.Date;

@Data
public class DeficienciaDtoResponse implements Serializable {

    String tipoDeficiencia;
    String descricaoLaudo;
    Date dataLaudo;

    public DeficienciaDtoResponse(Deficiencia deficiencia){
        this.tipoDeficiencia = deficiencia.getTipoDeficiencia();
        this.descricaoLaudo = deficiencia.getDescricaoLaudo();
        this.dataLaudo = deficiencia.getDataLaudo();

    }
}
