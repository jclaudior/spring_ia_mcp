package com.jcr.mcp.application.adapter.out.client;

import com.jcr.mcp.domain.model.PaginationCompanyDTO;

import java.util.List;

public interface CompanyClientPort {
    PaginationCompanyDTO getByUser(String userId);
}
