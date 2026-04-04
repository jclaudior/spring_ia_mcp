package com.jcr.mcp.application.service;

import com.jcr.mcp.application.adapter.out.client.CompanyClientPort;
import com.jcr.mcp.application.port.in.CompanyUseCase;
import com.jcr.mcp.domain.model.PaginationCompanyDTO;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService implements CompanyUseCase {

    @Autowired
    private CompanyClientPort client;

    @Override
    @Tool(
            name = "company.getByUser",
            description = "Retorna empresas de um usuário"
    )
    public PaginationCompanyDTO getByUser(@ToolParam(description = "userId") String userId) {
        PaginationCompanyDTO paginationUser = client.getByUser(userId);
        return paginationUser;
    }
}
