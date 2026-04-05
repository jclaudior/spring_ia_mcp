package com.jcr.mcp.application.adapter.out.client;

import com.jcr.mcp.domain.model.CreateInviteRequestDTO;
import com.jcr.mcp.domain.model.CreateInviteResponseDTO;
import com.jcr.mcp.domain.model.PaginationInviteDTO;

public interface InviteClientPort {
    CreateInviteResponseDTO createInvite(CreateInviteRequestDTO inviteRequestDTO);

    PaginationInviteDTO getByCompany(String companyId);
}
