package com.jcr.mcp.application.adapter.in.mcp;

import com.jcr.mcp.application.port.in.CompanyUseCase;
import com.jcr.mcp.domain.model.PaginationCompanyDTO;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Component;

@Component
public class CompanyTools {

    private final CompanyUseCase useCase;

    public CompanyTools(CompanyUseCase useCase) {
        this.useCase = useCase;
    }

    @Tool(
            name = "company.getByUser",
            description = "Retorna empresas de um usuário"
    )
    public PaginationCompanyDTO getCompaniesByUser(String userId) {

        return useCase.getByUser(userId);
    }
}
