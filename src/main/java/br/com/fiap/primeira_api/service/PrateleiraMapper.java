package br.com.fiap.primeira_api.service;

import br.com.fiap.primeira_api.dto.PrateleiraRequest;
import br.com.fiap.primeira_api.model.Prateleira;
import org.springframework.stereotype.Service;

@Service
public class PrateleiraMapper {
    public Prateleira requestToPrateleira(PrateleiraRequest prateleiraRequest) {
        Prateleira prateleira = new Prateleira();
        prateleira.setNome(prateleiraRequest.nome());
        prateleira.setDescricao(prateleiraRequest.descricao());
        return prateleira;
    }
}
