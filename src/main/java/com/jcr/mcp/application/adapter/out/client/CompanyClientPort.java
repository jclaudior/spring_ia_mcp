package com.jcr.mcp.application.adapter.out.client;

import com.jcr.mcp.domain.model.PaginationCompanyDTO;


public interface CompanyClientPort {
    PaginationCompanyDTO getByUser(String userId);
}
