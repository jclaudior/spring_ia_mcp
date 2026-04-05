package com.jcr.mcp.application.adapter.in.mcp;

import com.jcr.mcp.application.port.in.CompanyUseCase;
import com.jcr.mcp.application.port.in.InviteUseCase;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class McpTools {

    @Bean
    public ToolCallbackProvider tools(
            CompanyUseCase companyUseCase,
            InviteUseCase inviteUseCase
    ) {
        return MethodToolCallbackProvider.builder()
                .toolObjects(
                        companyUseCase,
                        inviteUseCase
                )
                .build();
    }

}
