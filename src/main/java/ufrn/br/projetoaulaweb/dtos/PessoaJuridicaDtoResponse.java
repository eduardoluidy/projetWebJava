package ufrn.br.projetoaulaweb.dtos;

import lombok.Data;
import org.springframework.hateoas.RepresentationModel;
import ufrn.br.projetoaulaweb.controller.EnderecoController;
import ufrn.br.projetoaulaweb.controller.PessoaJuridicaController;
import ufrn.br.projetoaulaweb.model.Endereco;
import ufrn.br.projetoaulaweb.model.PessoaJuridica;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Data
public class PessoaJuridicaDtoResponse extends RepresentationModel<PessoaJuridicaDtoResponse> {

    private String cnpj;
    private String nome;
    private String email;
    private String telefone;

    private Endereco endereco;

    public  PessoaJuridicaDtoResponse(PessoaJuridica pj){
        this.cnpj = pj.getCnpj();
        this.nome = pj.getNome();
        this.email = pj.getEmail();
        this.telefone = pj.getTelefone();
        this.endereco = pj.getEndereco();

        add(linkTo(PessoaJuridicaController.class).slash(pj.getId()).withSelfRel());
        add(linkTo(PessoaJuridicaController.class).withRel("allPessoaJuridica"));

        this.endereco.add(linkTo(EnderecoController.class).slash(endereco.getId()).withSelfRel());
        this.endereco.add(linkTo(EnderecoController.class).withRel("allEnderecos"));
    }

}
