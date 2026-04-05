package com.jcr.mcp.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaginationInviteDTO {
    @JsonProperty("pageable")
    PaginationDTO pageable;
    @JsonProperty("content")
    List<InviteDTO> content;
}
