package ufrn.br.projetoaulaweb.dtos;

import lombok.Data;
import org.springframework.hateoas.RepresentationModel;
import ufrn.br.projetoaulaweb.controller.DeficienciaController;
import ufrn.br.projetoaulaweb.controller.EnderecoController;
import ufrn.br.projetoaulaweb.controller.PessoaFisicaController;
import ufrn.br.projetoaulaweb.model.Deficiencia;
import ufrn.br.projetoaulaweb.model.Endereco;
import ufrn.br.projetoaulaweb.model.PessoaFisica;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;


import java.util.List;
@Data
public class PessoaFisicaDtoResponse extends RepresentationModel<PessoaFisicaDtoResponse> {

    private String nome;
    private String email;
    private String telefone;
    private String cpf;
    private String rg;
    private Endereco endereco;
    private List<Deficiencia> deficiencias;

    public PessoaFisicaDtoResponse(PessoaFisica pf){
        this.nome = pf.getNome();
        this.email = pf.getEmail();
        this.telefone = pf.getTelefone();
        this.rg = pf.getRg();
        this.cpf = pf.getCpf();
        this.endereco = pf.getEndereco();
        this.deficiencias = pf.getDeficiencias();

        add(linkTo(PessoaFisicaController.class).slash(pf.getId()).withSelfRel());
        add(linkTo(PessoaFisicaController.class).withRel("allPessoaFisica"));

        this.endereco.add(linkTo(EnderecoController.class).slash(endereco.getId()).withSelfRel());
        this.endereco.add(linkTo(EnderecoController.class).withRel("allEnderecos"));

        if(!pf.getDeficiencias().isEmpty()) {
            int cont = 0;
            for (Deficiencia defs : pf.getDeficiencias()) {
                this.deficiencias.get(cont).add(linkTo(DeficienciaController.class).slash(defs.getId()).withSelfRel());
                this.deficiencias.get(cont).add(linkTo(DeficienciaController.class).withRel("allDeficiencias"));
                cont++;
            }
        }
    }
}
