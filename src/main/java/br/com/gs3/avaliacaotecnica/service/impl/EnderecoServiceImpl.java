package br.com.gs3.avaliacaotecnica.service.impl;

import br.com.gs3.avaliacaotecnica.dao.entity.Endereco;
import br.com.gs3.avaliacaotecnica.dao.repository.EnderecoRepository;
import br.com.gs3.avaliacaotecnica.dto.EnderecoIntegracaoDTO;
import br.com.gs3.avaliacaotecnica.exception.IntegracaoExternaException;
import br.com.gs3.avaliacaotecnica.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class EnderecoServiceImpl implements EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Value("${api.cep}")
    private String urlApiCep;


    @Override
    public Endereco buscarDadosDeCEP(String cep) {
        String urlFormatada = urlApiCep.replace("{cep}", cep);
        try {
            RestTemplate restTemplate = new RestTemplate();
            EnderecoIntegracaoDTO enderecoDTO = restTemplate.getForObject(urlFormatada, EnderecoIntegracaoDTO.class);
            return converterDTOParaEntidade(enderecoDTO);
        } catch (ResourceAccessException e) {
            throw new IntegracaoExternaException("Não foi possível buscar o CEP na Integração Externa. URL: " + urlFormatada);
        }
    }

    private Endereco converterDTOParaEntidade(EnderecoIntegracaoDTO enderecoDTO) {
        Endereco entidade = new Endereco();
        entidade.setCep(enderecoDTO.getCep());
        entidade.setBairro(enderecoDTO.getBairro());
        entidade.setComplemento(enderecoDTO.getComplemento());
        entidade.setCidade(enderecoDTO.getLocalidade());
        entidade.setUf(enderecoDTO.getUf());
        entidade.setLogradouro(enderecoDTO.getLogradouro());
        return entidade;
    }

    @Override
    public Endereco salvar(Endereco novoEndereco) {
        return enderecoRepository.save(novoEndereco);
    }

    @Override
    public void remover(Endereco enderecoARemover) {

    }

    @Override
    public Endereco alterar(Endereco enderecoASerAlterado) {
        return null;
    }
}
