package com.jcr.mcp.application.service;

import com.jcr.mcp.application.adapter.out.client.InviteClientPort;
import com.jcr.mcp.application.port.in.InviteUseCase;
import com.jcr.mcp.domain.model.CompanyDTO;
import com.jcr.mcp.domain.model.CreateInviteRequestDTO;
import com.jcr.mcp.domain.model.CreateInviteResponseDTO;
import com.jcr.mcp.domain.model.PaginationInviteDTO;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InviteService implements InviteUseCase {

    @Autowired
    private InviteClientPort client;

    @Override
    @Tool(
            name = "invite.createInvite",
            description = "Manda um invite a partir do id da empresa e o email do convidado"
    )
    public CreateInviteResponseDTO createInvite(@ToolParam(description = "Id da empresa para o convite") String companyId, @ToolParam(description = "Email para criar o convite") String email) {
        CreateInviteRequestDTO createInviteRequestDTO = CreateInviteRequestDTO.builder()
                .email(email)
                .company(CompanyDTO.builder().id(companyId).build())
                .build();
        CreateInviteResponseDTO inviteResponseDTO = client.createInvite(createInviteRequestDTO);
        return inviteResponseDTO;
    }

    @Override
    @Tool(
            name = "invite.getByCompany",
            description = "Lista os invites a partir do id da empresa"
    )
    public PaginationInviteDTO getByCompany(@ToolParam(description = "Id da empresa para listar os convites") String companyId) {
        PaginationInviteDTO invites = client.getByCompany(companyId);
        return invites;
    }
}
