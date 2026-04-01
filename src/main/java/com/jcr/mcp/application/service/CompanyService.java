package com.jcr.mcp.application.service;

import com.jcr.mcp.application.adapter.out.client.CompanyClientPort;
import com.jcr.mcp.application.port.in.CompanyUseCase;
import com.jcr.mcp.domain.model.PaginationCompanyDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService implements CompanyUseCase {

    @Autowired
    private CompanyClientPort client;

    @Override
    public PaginationCompanyDTO getByUser(String userId) {
        return client.getByUser(userId);
    }
}
