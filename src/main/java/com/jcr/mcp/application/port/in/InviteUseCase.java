package com.jcr.mcp.application.port.in;

import com.jcr.mcp.domain.model.CreateInviteResponseDTO;
import com.jcr.mcp.domain.model.PaginationInviteDTO;

public interface InviteUseCase {
    CreateInviteResponseDTO createInvite(String companyId, String email);

    PaginationInviteDTO getByCompany(String companyId);
}
