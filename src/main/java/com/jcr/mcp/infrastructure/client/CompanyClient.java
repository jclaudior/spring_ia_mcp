package com.jcr.mcp.infrastructure.client;

import com.jcr.mcp.application.adapter.out.client.CompanyClientPort;
import com.jcr.mcp.domain.model.PaginationCompanyDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Component
public class CompanyClient implements CompanyClientPort {

    private final WebClient webClient;

    public CompanyClient(WebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    public PaginationCompanyDTO getByUser(String userId) {

        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/companies")
                        .queryParam("userId", userId)
                        .build()
                )
                .retrieve()
                .bodyToMono(PaginationCompanyDTO.class)
                .block();
    }


}
