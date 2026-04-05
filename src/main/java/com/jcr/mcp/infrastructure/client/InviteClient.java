package com.jcr.mcp.infrastructure.client;

import com.jcr.mcp.application.adapter.out.client.InviteClientPort;
import com.jcr.mcp.domain.model.CreateInviteRequestDTO;
import com.jcr.mcp.domain.model.CreateInviteResponseDTO;
import com.jcr.mcp.domain.model.PaginationInviteDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class InviteClient implements InviteClientPort {
    private final WebClient webClient;

    public InviteClient(WebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    public CreateInviteResponseDTO createInvite(CreateInviteRequestDTO inviteRequestDTO) {
        return webClient.post()
                .uri(uriBuilder -> uriBuilder
                        .path("/invites")
                        .build()
                )
                .bodyValue(inviteRequestDTO)
                .header("Content-Type", "application/json")
                .retrieve()
                .bodyToMono(CreateInviteResponseDTO.class)
                .block();
    }

    @Override
    public PaginationInviteDTO getByCompany(String companyId) {
         return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/invites")
                        .queryParam("companyId", companyId)
                        .build()
                )
                .retrieve()
                .bodyToMono(PaginationInviteDTO.class)
                .block();
    }
}
