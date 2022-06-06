package ufrn.br.projetoaulaweb.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;
import ufrn.br.projetoaulaweb.model.Endereco;
import ufrn.br.projetoaulaweb.model.Pessoa;
import ufrn.br.projetoaulaweb.model.generic.AbstractEntity;

import java.io.Serializable;

@Data
public class EnderecoDtoResponse implements Serializable{

    private String logradouro;
    private String bairro;
    private String numero;
    private String cep;
    private String cidade;
    private String uf;
    //Pessoa pessoa;

    public  EnderecoDtoResponse (Endereco e){
        this.logradouro = e.getLogradouro();
        this.bairro = e.getBairro();
        this.numero = e.getNumero();
        this.cep = e.getCep();
        this.cidade = e.getCidade();
        this.uf = e.getUf();
        //this.pessoa = e.getPessoa();
    }
}
