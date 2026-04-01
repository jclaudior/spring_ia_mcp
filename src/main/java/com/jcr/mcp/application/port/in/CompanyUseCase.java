package com.jcr.mcp.application.port.in;

import com.jcr.mcp.domain.model.PaginationCompanyDTO;

public interface CompanyUseCase {
    PaginationCompanyDTO getByUser(String userId);
}
